package com.bytedance.ee.bear.bitable.card.view.cell.link;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.OpenDiscussPanelType;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class BitableLinkRecordCreateManager extends ViewModel {
    private String mLinkedBaseId;
    private List<String> mLinkedRecordIds;
    private String mLinkedTableId;
    private a mOnLinkRecordCreatedListener;
    private String mSourceBaseId;
    private String mSourceRecordId;
    private String mSourceTableId;

    public interface a {
        void L0();
    }

    public BitableLinkRecordCreateManager() {
        this.mLinkedBaseId = null;
        this.mLinkedTableId = null;
        this.mLinkedRecordIds = new LinkedList();
    }

    public void setLinkRecordCreatedListener(a r100) {
        this.mOnLinkRecordCreatedListener = r100;
    }

    public void setWaitCreateLinkInfo(fp4.d r100, cp4.a r101, List<cp4.a> r102) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L24;
        cp4.b r103 = r101.f464634a;
        if (r103 == null) goto L25;
        cp4.b r104 = r100.f478240n;
        this.mLinkedBaseId = r104.f464658b;
        this.mLinkedTableId = r104.f464660d;
        this.mSourceBaseId = r103.f464658b;
        this.mSourceTableId = r103.f464660d;
        this.mSourceRecordId = r101.f464635b;
        if (r102 == null) goto L26;
        Iterator<cp4.a> r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L27;
        cp4.a r106 = r105.next();
        if (r106 == null) goto L10;
        if (TextUtils.isEmpty(r106.f464635b) == true) goto L10;
        this.mLinkedRecordIds.add(r106.f464635b);
        goto L10
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }

    public void setWaitCreateLinkInfoV2(fp4.d r100, cp4.a r101, List<String> r102) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        cp4.b r103 = r101.f464634a;
        if (r103 == null) goto L12;
        cp4.b r104 = r100.f478240n;
        this.mLinkedBaseId = r104.f464658b;
        this.mLinkedTableId = r104.f464660d;
        this.mSourceBaseId = r103.f464658b;
        this.mSourceTableId = r103.f464660d;
        this.mSourceRecordId = r101.f464635b;
        if (r102 == null) goto L13;
        this.mLinkedRecordIds.addAll(r102);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    public void showLinkPickPanelIfNeed(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(this.mSourceBaseId) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mSourceTableId) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.mSourceRecordId) == false) goto L9;
        return;
    L9:
        if (TextUtils.equals(r100, this.mSourceBaseId) == true) goto L11;
        return;
    L11:
        if (TextUtils.equals(r101, this.mSourceTableId) == true) goto L13;
        return;
    L13:
        if (TextUtils.equals(r102, this.mSourceRecordId) == false) goto L24;
        a r103 = this.mOnLinkRecordCreatedListener;
        if (r103 == null) goto L17;
        r103.L0();
    L17:
        this.mSourceBaseId = null;
        this.mSourceTableId = null;
        this.mSourceRecordId = null;
        this.mOnLinkRecordCreatedListener = null;
        return;
    }

    public void showLinkTableIfNeeded(String r100, String r110, String r111, String r112, BitableCardViewModel r113) {
        if (r113 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(this.mLinkedBaseId) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.mLinkedTableId) == false) goto L8;
        return;
    L8:
        if (TextUtils.equals(r100, this.mLinkedBaseId) == true) goto L10;
        return;
    L10:
        if (TextUtils.equals(r110, this.mLinkedTableId) == true) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r112) == true) goto L20;
        this.mLinkedRecordIds.add(r112);
        String[] r101 = new String[this.mLinkedRecordIds.size()];
        r113.forwardLinkTable((String[]) this.mLinkedRecordIds.toArray(r101), r112, r100, r110, r111, OpenDiscussPanelType.NONE);
        this.mLinkedBaseId = null;
        this.mLinkedTableId = null;
        this.mLinkedRecordIds.clear();
        return;
    }
}
