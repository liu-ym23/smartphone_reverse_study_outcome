package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.more.q;
import jg5.e;
import oj5.c;
import oj5.f;
import rj5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DeleteItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String TAG = "DeleteItemV2";
    private final Activity activity;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254201;
    }

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
        return CommonMoreItemId.DELETE.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        new g(this.activity).b(getMoreInfo());
        getHost().a();
        if ((getMoreInfo() instanceof oj5.a) == false) goto L6;
        oj5.a r0 = (oj5.a) getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.c, r0.getType(), false, r0.b(), "delete", "ccm_space_delete_view", "", "", r0 instanceof f, r0.k, r0.r, r0.isOwner(), r0.L()));
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131887736);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (y.a() == true) goto L5;
        return "";
    L5:
        if (j.a.a.getNetworkState().a() == false) goto L7;
        return "";
    L7:
        return getString(2131887951);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if (y.a() == true) goto L6;
        y.c(TAG, getId());
        return true;
    L6:
        boolean r0 = j.a.a.getNetworkState().a();
        String r2 = getId();
        if (r0 == false) goto L9;
        String r4 = "";
    L10:
        y.b(TAG, r2, true, r0, r4, DocFeed$Value$DataSource.NETWORK);
        return r0;
    L9:
        r4 = DocFeed$Value$DataSource.NETWORK;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.m() == false) goto L8;
        return false;
    L8:
        if (r0.e() == false) goto L11;
        return false;
    L11:
        if (isItemInvisibleByBenefit() == false) goto L14;
        return false;
    L14:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r0.C())) == false) goto L24;
        DocPermission r2 = r0.c();
        if (r2 != null) goto L18;
        return false;
    L18:
        if (isFullAccess(r2, r0) == true) goto L20;
        return false;
    L20:
        if (q.b(r0) == true) goto L31;
        return true;
    L31:
        return false;
    L24:
        if (r0.isOwner() == true) goto L26;
        return false;
    L26:
        if (q.b(r0) == true) goto L34;
        return true;
    L34:
        return false;
    }

    public DeleteItemV2(Activity r1) {
        this.activity = r1;
    }

    private boolean isFullAccess(DocPermission r8, c r9) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r9.getToken(), r9, BizDomain.FileBizDomainCCM, "FULL_ACCESS", r8.a).getAllow();
    L7:
        return r8.a.isFullAccess();
    }
}
