package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyRootFolderDeleteItemV2 extends DeleteItemV2 {
    private final boolean mIsGrid;

    @Override // com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2, com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L5;
        return false;
    L5:
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L8;
    L12:
        if (r0 == null) goto L17;
        if (r0.E() == false) goto L17;
        return true;
    L17:
        if ((r0 instanceof oj5.a) == false) goto L21;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r0.c().a, "DELETE_ENTITY").booleanValue();
    L21:
        if ((r0 instanceof oj5.b) == false) goto L24;
        ShareFolderUserPermission r1 = ((oj5.b) r0).t;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r0, r1, "MOVE_THIS_NODE").booleanValue();
    L24:
        return false;
    L8:
        if (r0.getType() == sbb.e.f.b) goto L12;
        if (DocVersion.isDocV2(r0.C()) == true) goto L12;
        return true;
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return this.mIsGrid;
    }

    public MyRootFolderDeleteItemV2(Document r1, boolean r2, int r3, boolean r4, com.bytedance.ee.bear.list.list.f.a r5) {
        super(r1, r3, r4, r5);
        this.mIsGrid = r2;
    }
}
