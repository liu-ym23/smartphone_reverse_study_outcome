package com.bytedance.ee.bear.middleground.comment.input;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t1 {
    public static kf5.b a(final com.bytedance.ee.bear.middleground.comment.uitls.p r15, com.bytedance.ee.bear.middleground.comment.control.z r16, com.bytedance.ee.bear.middleground.comment.control.t r17, Function1 r18, CommentInputRequest r19, Function5 r20, Function1 r21, boolean r22, Function0 r23, bb5.i r24, SharePermissionViewModel r25, int r26) {
        if ((r26 & 8) == 0) goto L5;
        Function1 r4 = InputCommentKt$createInputComment$1.INSTANCE;
    L7:
        if ((r26 & 32) == 0) goto L9;
        Function5 r6 = InputCommentKt$createInputComment$2.INSTANCE;
    L11:
        if ((r26 & 64) == 0) goto L13;
        Function1 r7 = InputCommentKt$createInputComment$3.INSTANCE;
    L15:
        if ((r26 & 128) == 0) goto L17;
        boolean r8 = true;
    L19:
        if ((r26 & 512) == 0) goto L21;
        Function0 r10 = new InputCommentKt$createInputComment$4(r15);
    L23:
        if ((r26 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L25;
        Function0<FragmentManager> r2 = new InputCommentKt$createInputComment$5(r15);
    L26:
        Function0<FragmentManager> r11 = r2;
        if ((r26 & DocUserPermission.USER_PREVIEW) == 0) goto L29;
        bb5.i r12 = new bb5.i();
    L31:
        if ((r26 & DocUserPermission.USER_PERCEIVE) == 0) goto L33;
        SharePermissionViewModel r13 = new SharePermissionViewModel(r15);
    L34:
        Intrinsics.checkNotNullParameter(r15, "configComment");
        Intrinsics.checkNotNullParameter(r16, "commentListeners");
        Intrinsics.checkNotNullParameter(r17, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "createCallBack");
        Intrinsics.checkNotNullParameter(r19, "inputRequest");
        Intrinsics.checkNotNullParameter(r6, "dismissCallback");
        Intrinsics.checkNotNullParameter(r7, "heightChange");
        Intrinsics.checkNotNullParameter(r10, "getViewParent");
        Intrinsics.checkNotNullParameter(r11, "getFragmentManager");
        Intrinsics.checkNotNullParameter(r12, "dialogLifecycle");
        Intrinsics.checkNotNullParameter(r13, "sharePermissionViewModel");
        if (ForsetiHelper.h() == false) goto L38;
        return new InputCommentV2(r15, r16, r17, r4, r19, r6, r7, r8, null, r10, r11, r12, r13);
    L38:
        return new InputComment(r15, r16, r17, r4, r19, r6, r7, r8, null, r10, r11, r12, r13);
    L33:
        r13 = r25;
        goto L34
    L29:
        r12 = r24;
        goto L31
    L25:
        r2 = null;
        goto L26
    L21:
        r10 = r23;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }
}
