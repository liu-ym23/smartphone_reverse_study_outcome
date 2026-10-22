package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.share.k2;
import com.bytedance.ee.bear.list.share.l2;
import com.bytedance.ee.bear.list.share.m2;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import dd5.n1;
import dd5.s1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import lc5.f;
import lc5.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SetHiddenItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String SET_HIDDEN_ID = "set_hiddenV2";
    private static final String TAG = "SetHiddenItemV2";
    private boolean isNewShareFolder;
    private Context mContext;
    private Document mDocument;
    private String mModule;
    private String mSource;

    public static class a implements ax4.e<Result> {
        public final WeakReference<SetHiddenItemV2> a;

        public a(SetHiddenItemV2 r2) {
            this.a = new WeakReference(r2);
        }

        public final void onFailed(Throwable r11) {
            tt5.a.d(SetHiddenItemV2.TAG, "handleHidden() fail..., throwable = " + r11);
            if (this.a.get() == null) goto L5;
            SetHiddenItemV2 r12 = this.a.get();
            Toast.showFailureText(SetHiddenItemV2.access$100(r12), SetHiddenItemV2.access$100(r12).getString(2131887802), 0);
            f.o(new u((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), SetHiddenItemV2.access$200(r12), SetHiddenItemV2.access$300(r12), false, SetHiddenItemV2.access$000(r12).P0, SetHiddenItemV2.access$000(r12).d));
            return;
        L5:
            tt5.a.h(SetHiddenItemV2.TAG, "SetHiddenCallback#onFailed()...itemRef = null");
        }

        public final void onSuccess(Object r11) {
            Result r12 = (Result) r11;
            tt5.a.h(SetHiddenItemV2.TAG, "SetHiddenCallback#onSuccess()...");
            if (this.a.get() == null) goto L16;
            SetHiddenItemV2 r13 = this.a.get();
            if (SetHiddenItemV2.access$000(r13).P0 == false) goto L7;
            int r0 = 2131887892;
        L8:
            Toast.showSuccessText(SetHiddenItemV2.access$100(r13), SetHiddenItemV2.access$100(r13).getString(r0), 0);
            f.o(new u((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), SetHiddenItemV2.access$200(r13), SetHiddenItemV2.access$300(r13), true, SetHiddenItemV2.access$000(r13).P0, SetHiddenItemV2.access$000(r13).d));
            s1 r1 = s1.a.a;
            String r2 = SetHiddenItemV2.access$000(r13).d;
            boolean r14 = SetHiddenItemV2.access$000(r13).P0;
            Iterator<WeakReference<n1>> r15 = r1.k.iterator();
        L10:
            if (r15.hasNext() == false) goto L25;
            WeakReference<n1> r3 = r15.next();
            if (r3 == null) goto L10;
            if (r3.get() == null) goto L10;
            r3.get().b5(r2);
            goto L10
        L25:
            return;
        L7:
            r0 = 2131887924;
            goto L8
        L16:
            tt5.a.h(SetHiddenItemV2.TAG, "SetHiddenCallback#onSuccess()...itemRef = null");
        }
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return SET_HIDDEN_ID;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (this.mDocument.P0 == false) goto L5;
        return 2131256160;
    L5:
        return 2131256159;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (this.mDocument.P0 == false) goto L5;
        int r0 = 2131889259;
    L7:
        return getString(r0);
    L5:
        r0 = 2131889260;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        return j.a.a.getNetworkState().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        tt5.a.b(TAG, "onItemClick: moreInfo = " + getMoreInfo());
        boolean r0 = this.mDocument.P0;
        NetService r1 = (NetService) org.koin.java.a.a(NetService.class);
        String r2 = this.mDocument.d;
        final a r3 = new a(this);
        if (this.isNewShareFolder == false) goto L7;
        if (r0 == false) goto L6;
        String r4 = "/space/api/explorer/v2/share/folder/show/";
    L10:
        NetService.f r5 = new NetService.f(r4);
        ((NetService.e) r5).c = 1;
        HashMap r6 = new HashMap();
        r6.put(ResourceData.KEY_TOKEN, r2);
        r5.d(r6);
        r1.Vc(new k2()).a(r5).subscribe(new l2(r3), new m2(r3));
        getHost().a();
        return;
    L6:
        r4 = "/space/api/explorer/v2/share/folder/hide/";
        goto L10
    L7:
        if (r0 == false) goto L9;
        r4 = "/api/explorer/share/folder/show/";
        goto L10
    L9:
        r4 = "/api/explorer/share/folder/hide/";
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        return getString(2131887951);
    }

    public static /* synthetic */ Document access$000(SetHiddenItemV2 r0) {
        return r0.mDocument;
    }

    public static /* synthetic */ Context access$100(SetHiddenItemV2 r0) {
        return r0.mContext;
    }

    public static /* synthetic */ String access$200(SetHiddenItemV2 r0) {
        return r0.mSource;
    }

    public static /* synthetic */ String access$300(SetHiddenItemV2 r0) {
        return r0.mModule;
    }

    public SetHiddenItemV2(Context r1, Document r2, String r3, String r4, boolean r5) {
        this.mContext = r1;
        this.mDocument = r2;
        this.mSource = r3;
        this.mModule = r4;
        this.isNewShareFolder = r5;
    }
}
