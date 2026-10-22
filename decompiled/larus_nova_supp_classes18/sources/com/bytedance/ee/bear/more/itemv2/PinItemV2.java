package com.bytedance.ee.bear.more.itemv2;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.q;
import jdb.g;
import oj5.c;
import oj5.f;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PinItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String TAG = "PinItemV2";
    private g fgService;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        g r0 = this.fgService;
        if (r0 == null) goto L14;
        if (ex4.a.a(r0) == false) goto L14;
        if ((getMoreInfo() instanceof oj5.b) == true) goto L14;
        if (isPined() == false) goto L11;
        return 2131256070;
    L11:
        return 2131254096;
    L14:
        if (isPined() == false) goto L16;
        return 2131254024;
    L16:
        return 2131253905;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.PIN.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        g r0 = this.fgService;
        if (r0 == null) goto L15;
        if (ex4.a.a(r0) == false) goto L15;
        if ((getMoreInfo() instanceof oj5.b) == true) goto L15;
        if (isPined() == false) goto L11;
        int r1 = 2131889632;
    L13:
        return getString(r1);
    L11:
        r1 = 2131889574;
    L15:
        if (isPined() == false) goto L17;
        int r2 = 2131887961;
    L19:
        return getString(r2);
    L17:
        r2 = 2131887878;
        goto L19
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (j.a.a.getNetworkState().a() == false) goto L5;
        c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L16;
        if (((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).m() == false) goto L16;
        oj5.a r1 = (oj5.a) r0;
        boolean r2 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r1, r1.i.a, "VIEW").booleanValue();
        if (r1.p == false) goto L16;
        if (r2 == true) goto L16;
        return getString(2131889883);
    L16:
        return getString(2131887803);
    L5:
        return getString(2131887951);
    }

    private boolean isFromSpace() {
        Bundle r0 = getHost().getHostFragment().getArguments();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getInt("more_scene", -1) != 0) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        c r0 = getMoreInfo();
        if ((r0 instanceof f) == false) goto L15;
        if (((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).m() == false) goto L15;
        f r1 = (f) r0;
        if (r1.p == false) goto L15;
        if (r1.q == false) goto L12;
        return false;
    L12:
        if (canWikiMoreRead(r1) == true) goto L15;
        return false;
    L15:
        if ((r0 instanceof oj5.a) == false) goto L25;
        oj5.a r2 = (oj5.a) r0;
        if (r2.p == false) goto L25;
        if (r2.q == false) goto L22;
        return false;
    L22:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r2, r2.i.a, "VIEW").booleanValue() == true) goto L25;
        return false;
    L25:
        if ((r0 instanceof oj5.b) == false) goto L35;
        oj5.b r3 = (oj5.b) r0;
        if (r3.q == false) goto L35;
        if (r3.r == false) goto L32;
        return false;
    L32:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r3, r3.t, "VIEW").booleanValue() == true) goto L35;
        return false;
    L35:
        return j.a.a.getNetworkState().a();
    }

    public boolean isPined() {
        if (getMoreInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getMoreInfo().k() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (q.b(r0) == false) goto L8;
        return false;
    L8:
        if (r0.w() == false) goto L11;
        return false;
    L11:
        if (r0.getType() != e.n.b) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
    L17:
        return true;
    L16:
        if (((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).m() == true) goto L17;
        return false;
    L13:
        r1 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        c r0 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r0);
        if (r0 != null) goto L5;
        return;
    L5:
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).M(getPinToken(r0), getPinType(r0), isPined());
        reportMoreItemClick(r0);
        getHost().a();
    }

    public PinItemV2(g r1) {
        this.fgService = r1;
    }

    private boolean canWikiMoreRead(f r4) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r4, r4.i.a, "VIEW").booleanValue();
    }

    private void reportMoreItemClick(c r19) {
        c r1 = getMoreInfo();
        if (isPined() == false) goto L5;
        String r2 = "add_quickaccess";
    L6:
        com.bytedance.ee.bear.more.c.b(r1, r2);
        if (isFromSpace() == false) goto L9;
        String r3 = "none";
    L10:
        String r9 = r3;
        if ((r19 instanceof oj5.b) == false) goto L18;
        oj5.b r4 = (oj5.b) r19;
        Bundle r5 = getHost().getHostFragment().getArguments();
        String r6 = r19.getToken();
        int r7 = r19.getType();
        boolean r8 = FolderVersion.isShareFolder(r4.o.getOwnerType(), r4.p);
        String r10 = r19.b();
        if (isPined() == false) goto L15;
        String r11 = "remove_from_quickaccess";
    L16:
        com.bytedance.ee.bear.more.c.c(new i(r5, r6, r7, r8, r10, r11, r9, "", "", false, false, r19.H(), r19.isOwner(), r19.L()));
        return;
    L15:
        r11 = "add_to_quickaccess";
        goto L16
    L18:
        if ((r19 instanceof oj5.a) == false) goto L26;
        Bundle r12 = getHost().getHostFragment().getArguments();
        String r13 = r19.getToken();
        int r14 = r19.getType();
        String r15 = r19.b();
        if (isPined() == false) goto L22;
        String r16 = "remove_from_quickaccess";
    L23:
        String r17 = r16;
        com.bytedance.ee.bear.more.c.c(new i(r12, r13, r14, false, r15, r17, r9, "", "", r19 instanceof f, ((oj5.a) r19).k, r19.H(), r19.isOwner(), r19.L()));
        return;
    L22:
        r16 = "add_to_quickaccess";
        goto L23
    L26:
        return;
    L9:
        r3 = "ccm_docs_page_view";
        goto L10
    L5:
        r2 = "remove_quickaccess";
        goto L6
    }

    public String getPinToken(c r1) {
        return q.a(r1);
    }

    public int getPinType(c r1) {
        return q.getType(r1);
    }
}
