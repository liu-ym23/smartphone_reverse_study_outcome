package com.bytedance.ee.bear.list.folder;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SubFolderDeleteItemV2 extends DeleteItemV2 {
    private final boolean mIsGrid;
    private final ShareFolderUserPermission mParentPermission;
    private final String mParentToken;

    @Override // com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2, com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L5;
        return false;
    L5:
        oj5.c r0 = getMoreInfo();
        if (r0 == null) goto L16;
        if (r0.E() == false) goto L16;
        ShareFolderUserPermission r3 = this.mParentPermission;
        if (r3 != null) goto L12;
        return false;
    L12:
        if (canMoveSubNode(r3, r0) == false) goto L48;
        return true;
    L48:
        return false;
    L16:
        if ((r0 instanceof oj5.a) == false) goto L30;
        if (qc5.a.b(this.mDocument.L1) == true) goto L20;
        ShareFolderUserPermission r4 = this.mParentPermission;
        if (r4 != null) goto L24;
        return false;
    L24:
        if (canMoveSubNode(r4, r0) == true) goto L26;
        return false;
    L26:
        if (canOperateEntity(r0) == false) goto L51;
        return true;
    L51:
        return false;
    L20:
        return canOperateEntity(r0);
    L30:
        if ((r0 instanceof oj5.b) == false) goto L54;
        ShareFolderUserPermission r5 = ((oj5.b) r0).t;
        if (qc5.a.b(this.mDocument.L1) == false) goto L38;
        if (r5 != null) goto L35;
        return false;
    L35:
        if (canBeMoved(r5, r0) == false) goto L53;
        return true;
    L53:
        return false;
    L38:
        ShareFolderUserPermission r6 = this.mParentPermission;
        if (r6 != null) goto L41;
        return false;
    L41:
        if (canMoveSubNode(r6, r0) == false) goto L56;
        if (r5 != null) goto L44;
        return false;
    L44:
        if (canBeMoved(r5, r0) == false) goto L58;
        return true;
    L58:
        return false;
    L56:
        return false;
    L54:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (qc5.a.b(this.mDocument.L1) == true) goto L9;
        if (TextUtils.equals(this.mParentToken, this.mDocument.d) == false) goto L9;
        return false;
    L9:
        return this.mIsGrid;
    }

    private boolean canOperateEntity(oj5.c r4) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r4, "DELETE_ENTITY", r4.c().a).getAllow();
    L7:
        return r4.canOperateEntity();
    }

    private boolean canBeMoved(ShareFolderUserPermission r3, oj5.c r4) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r4, r3, "MOVE_THIS_NODE").booleanValue();
    }

    private boolean canMoveSubNode(ShareFolderUserPermission r3, oj5.c r4) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r4, r3, "MOVE_SUB_NODE").booleanValue();
    }

    public SubFolderDeleteItemV2(Document r1, int r2, boolean r3, String r4, ShareFolderUserPermission r5, boolean r6, com.bytedance.ee.bear.list.list.f.a r7) {
        super(r1, r2, r6, r7);
        this.mIsGrid = r3;
        this.mParentToken = r4;
        this.mParentPermission = r5;
    }
}
