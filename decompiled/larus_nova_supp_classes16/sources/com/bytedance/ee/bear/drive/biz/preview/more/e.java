package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ BaseOpenEntity a;
    public final /* synthetic */ b b;
    public final /* synthetic */ BaseMoreMenuAction c;
    public final /* synthetic */ Ref.BooleanRef d;

    public e(BaseOpenEntity r1, b r2, BaseMoreMenuAction r3, Ref.BooleanRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r24) {
        s55.a r0 = s55.a.a;
        BaseOpenEntity r2 = this.a;
        int r3 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        Long r4 = null;
        if (r2 == null) goto L5;
        Integer r5 = Integer.valueOf(r2.getBizType());
    L6:
        if (r5 != null) goto L9;
    L11:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L49;
        b r7 = this.b;
        BaseMoreMenuAction r8 = this.c;
        Intrinsics.checkNotNull(r8);
        r7.getClass();
        if (b.i(r8) == false) goto L49;
        b r1 = this.b;
        BaseOpenEntity r9 = this.a;
        BaseMoreMenuAction r10 = this.c;
        Intrinsics.checkNotNull(r10);
        r1.getClass();
    L45:
        e = move-exception;
        tt5.a.d("DriveAttachmentMoreMenuCreator", "buildOpenMenuItems， click error" + e);
        return;
    L18:
        if ((r9 instanceof OnlineOpenEntity) == false) goto L20;
        OnlineOpenEntity r11 = (OnlineOpenEntity) r9;     // Catch: Exception -> L45
    L21:
        PermissionOperation r12 = PermissionOperation.DOWNLOAD;     // Catch: Exception -> L45
        if (r9 == null) goto L24;
        String r13 = r9.getMountPoint();     // Catch: Exception -> L45
    L25:
        if (r9 == null) goto L27;
        String r14 = r9.getFileId();     // Catch: Exception -> L45
    L28:
        if (r9 == null) goto L30;
        Long r16 = r9.getSenderTenantID();     // Catch: Exception -> L45
    L32:
        if (r11 == null) goto L34;
        String r18 = r11.getMsgId();     // Catch: Exception -> L45
    L35:
        if (r11 == null) goto L37;
        Long r19 = r11.getChatID();     // Catch: Exception -> L45
    L38:
        if (r11 == null) goto L40;
        Long r20 = r11.getChatType();     // Catch: Exception -> L45
    L41:
        if (r11 == null) goto L43;
        r4 = r11.getSenderUserID();     // Catch: Exception -> L45
    L43:
        s55.a.e(new s55.e("DOWNLOAD", r12, 2131887246, r13, r14, r16, null, null, null, null, r18, r19, r20, r4, 3008), r1.a, new l(r1, r10));     // Catch: Exception -> L45
        return;
    L40:
        r20 = null;
        goto L41
    L37:
        r19 = null;
        goto L38
    L34:
        r18 = null;
        goto L35
    L30:
        r16 = null;
        goto L32
    L27:
        r14 = null;
        goto L28
    L24:
        r13 = null;
        goto L25
    L20:
        r11 = null;
    L49:
        if (this.d.element == false) goto L51;
    L60:
        b r17 = this.b;
        BaseMoreMenuAction r21 = this.c;
        Intrinsics.checkNotNull(r21);
        r17.g(r21);
        return;
    L51:
        if (this.c.b() == (-1)) goto L60;
        b r22 = this.b;
        BaseMoreMenuAction r23 = this.c;
        Intrinsics.checkNotNull(r23);
        r22.getClass();
        if (b.i(r23) == true) goto L55;
    L58:
        Toast.showText(eu5.b.a, this.c.b());
        return;
    L55:
        if (r0.k(new s55.e("DOWNLOAD", PermissionOperation.DOWNLOAD, this.c.b(), this.a.getMountPoint(), this.a.getFileId(), null, null, null, null, null, null, null, null, null, 32736), this.b.a) == true) goto L58;
        tt5.a.h("DriveAttachmentMoreMenuCreator", "handlePermissionUiAction return false");
        return;
    L9:
        if (r5.intValue() != 3) goto L11;
        r6 = true;
        goto L13
    L5:
        r5 = null;
        goto L6
    }
}
