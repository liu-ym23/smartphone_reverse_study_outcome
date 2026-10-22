package com.bytedance.ee.bear.more.itemv2;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.q;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class StarItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String TAG = "StarItemV2";

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.STAR.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (j.a.a.getNetworkState().a() == true) goto L7;
        return getString(2131887951);
    L7:
        return getString(2131887803);
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

    private boolean isStared() {
        if (getMoreInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getMoreInfo().D() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (isStared() == false) goto L5;
        return 2131254025;
    L5:
        return 2131254139;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (isStared() == false) goto L5;
        int r0 = 2131889631;
    L7:
        return getString(r0);
    L5:
        r0 = 2131887713;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L13;
        oj5.a r0 = (oj5.a) getMoreInfo();
        if (r0.p == false) goto L13;
        if (r0.q == false) goto L10;
        return false;
    L10:
        if (canView(r0) == true) goto L13;
        return false;
    L13:
        if ((getMoreInfo() instanceof oj5.b) == false) goto L23;
        oj5.b r1 = (oj5.b) getMoreInfo();
        if (r1.q == false) goto L23;
        if (r1.r == false) goto L20;
        return false;
    L20:
        if (canView(r1) == true) goto L23;
        return false;
    L23:
        return j.a.a.getNetworkState().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (getMoreInfo() != null) goto L5;
    L9:
        return false;
    L5:
        if (q.b(getMoreInfo()) == true) goto L9;
        if (getMoreInfo().w() == true) goto L9;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        c r0 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: moreInfo = " + r0);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.D() == false) goto L7;
        String r1 = "remove_favorites";
    L8:
        com.bytedance.ee.bear.more.c.b(r0, r1);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).P(getHost().getHostFragment().getContext(), q.a(r0), q.getType(r0), r0.D());
        if (isFromSpace() == false) goto L11;
        String r2 = "none";
    L12:
        String r9 = r2;
        if ((r0 instanceof oj5.b) == false) goto L20;
        oj5.b r3 = (oj5.b) r0;
        Bundle r4 = getHost().getHostFragment().getArguments();
        String r5 = r0.getToken();
        int r6 = r0.getType();
        boolean r7 = FolderVersion.isShareFolder(r3.o.getOwnerType(), r3.p);
        String r8 = r0.b();
        if (isStared() == false) goto L17;
        String r10 = "remove_from_favorites";
    L18:
        com.bytedance.ee.bear.more.c.c(new i(r4, r5, r6, r7, r8, r10, r9, "", "", false, false, r0.H(), r0.isOwner(), r0.L()));
    L26:
        getHost().a();
        return;
    L17:
        r10 = "add_to_favorites";
        goto L18
    L20:
        if ((r0 instanceof oj5.a) == false) goto L26;
        Bundle r11 = getHost().getHostFragment().getArguments();
        String r12 = r0.getToken();
        int r13 = r0.getType();
        String r14 = r0.b();
        if (isStared() == false) goto L24;
        String r15 = "remove_from_favorites";
    L25:
        com.bytedance.ee.bear.more.c.c(new i(r11, r12, r13, false, r14, r15, r9, "", "", r0 instanceof f, ((oj5.a) r0).k, r0.H(), r0.isOwner(), r0.L()));
        goto L26
    L24:
        r15 = "add_to_favorites";
        goto L25
    L11:
        r2 = "ccm_docs_page_view";
        goto L12
    L7:
        r1 = "add_favorites";
        goto L8
    }

    public StarItemV2() {
    }

    private boolean canView(c r4) {
        if ((r4 instanceof oj5.a) == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r4, "VIEW", r4.c().a).getAllow();
    L7:
        if ((r4 instanceof oj5.b) == false) goto L10;
        ShareFolderUserPermission r0 = ((oj5.b) r4).t;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r4, "VIEW", r0).getAllow();
    L10:
        return false;
    }
}
