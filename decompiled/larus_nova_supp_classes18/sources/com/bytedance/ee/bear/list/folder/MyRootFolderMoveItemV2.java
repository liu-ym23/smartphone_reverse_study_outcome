package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.more.itemv2.MoveItemV2;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyRootFolderMoveItemV2 extends MoveItemV2 {
    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2
    public boolean enableUnorganized() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        return false;
    L6:
        if (this.mDocument.getType() == sbb.e.f.b) goto L8;
    L12:
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L25;
        oj5.a r1 = (oj5.a) r0;
        if (r1.p == false) goto L19;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r1, r1.s, "MOVE_THIS_NODE").booleanValue();
    L19:
        if (isEnableApply() == false) goto L23;
        return true;
    L23:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r1, r1.i.a, "MOVE_THIS_NODE").booleanValue();
    L25:
        if ((r0 instanceof oj5.b) == false) goto L32;
        oj5.b r2 = (oj5.b) r0;
        if (r2.q == true) goto L29;
        ShareFolderUserPermission r3 = r2.t;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r2, r3, "MOVE_THIS_NODE").booleanValue();
    L29:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r2, r2.u, "MOVE_THIS_NODE").booleanValue();
    L32:
        return false;
    L8:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.mDocument.L1)) == true) goto L12;
        if (this.mDocument.Q1 == false) goto L12;
        return false;
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (this.mDocument.getType() != sbb.e.f.b) goto L5;
        return true;
    L5:
        return FolderVersion.isShareFolderV2(Integer.valueOf(this.mDocument.L1));
    }

    public MyRootFolderMoveItemV2(Context r9, Document r10, AccountService.Account r11, boolean r12, String r13, String r14) {
        super(r9, r10, r11, r12, "", r13, r14);
    }
}
