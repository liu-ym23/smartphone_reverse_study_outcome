package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.more.itemv2.MoveItemV2;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SubFolderMoveItemV2 extends MoveItemV2 {
    private final ShareFolderUserPermission mParentPermission;
    private final boolean mParentShareFolder;

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        return false;
    L6:
        if (isEnableApplyFolder() == false) goto L8;
    L11:
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L31;
        oj5.a r3 = (oj5.a) r0;
        if (r3.p == false) goto L22;
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.mParentPermission, "MOVE_SUB_NODE").booleanValue() == true) goto L18;
        return false;
    L18:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r3.s, "MOVE_THIS_NODE").booleanValue() == false) goto L51;
        return true;
    L51:
        return false;
    L22:
        if (isEnableApply() == false) goto L25;
        return true;
    L25:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.mParentPermission, "MOVE_SUB_NODE").booleanValue() == true) goto L27;
        return false;
    L27:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r3.i.a, "MOVE_THIS_NODE").booleanValue() == false) goto L53;
        return true;
    L53:
        return false;
    L31:
        if ((r0 instanceof oj5.b) == false) goto L56;
        oj5.b r4 = (oj5.b) r0;
        if (r4.q == true) goto L35;
        ShareFolderUserPermission r5 = r4.t;
        if (isEnableApplyFolder() == false) goto L45;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r0, r5, "VIEW").booleanValue();
    L45:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.mParentPermission, "MOVE_SUB_NODE").booleanValue() == true) goto L47;
        return false;
    L47:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r0, r5, "MOVE_THIS_NODE").booleanValue() == false) goto L58;
        return true;
    L58:
        return false;
    L35:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.mParentPermission, "MOVE_SUB_NODE").booleanValue() == true) goto L37;
        return false;
    L37:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r4.u, "MOVE_THIS_NODE").booleanValue() == false) goto L55;
        return true;
    L55:
        return false;
    L56:
        return false;
    L8:
        if (TextUtils.equals(this.mParentToken, this.mDocument.d) == false) goto L11;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.mParentPermission, "MOVE_THIS_NODE").booleanValue();
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (isEnableApplyFolder() == true) goto L18;
        Document r0 = this.mDocument;
        if (r0.n == false) goto L13;
        String r1 = r0.e;
        AccountService.Account r2 = this.mAccount;
        if (r2 == null) goto L9;
        String r3 = r2.uid;
    L11:
        return TextUtils.equals(r1, r3);
    L9:
        r3 = "";
        goto L11
    L13:
        if (TextUtils.equals(this.mParentToken, r0.d) == true) goto L15;
        return true;
    L15:
        if (NodeType.isShortcut(this.mDocument.M1) == true) goto L21;
        return false;
    L21:
        return true;
    L18:
        return true;
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2
    public SpaceSelectorBean getSpaceSelectorBean(oj5.c r1, boolean r2) {
        SpaceSelectorBean r3 = super.getSpaceSelectorBean(r1, r2);
        r3.k = this.mParentShareFolder;
        return r3;
    }

    public SubFolderMoveItemV2(Context r10, Document r11, AccountService.Account r12, boolean r13, String r14, ShareFolderUserPermission r15, boolean r16, String r17, String r18) {
        super(r10, r11, r12, r13, r14, r17, r18);
        this.mParentPermission = r15;
        this.mParentShareFolder = r16;
    }
}
