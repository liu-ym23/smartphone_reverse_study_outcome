package com.bytedance.applet.impl;

import com.bytedance.ai.api.AppletBottomSheetAction;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import com.bytedance.ai.api.OperateResult;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetButtonRole;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z1 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;

        static {
            int[] r0 = new int[OperateResult.values().length];
            r0[OperateResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L61:
            r0[OperateResult.REJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L67:
            r0[OperateResult.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L8:
            a = r0;
            int[] r1 = new int[DoubaoBottomSheetButtonRole.values().length];
            r1[DoubaoBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L63:
            r1[DoubaoBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L69:
            r1[DoubaoBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L12:
            b = r1;
            int[] r2 = new int[AppletBottomSheetAction.values().length];
            r2[AppletBottomSheetAction.BUTTON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r2[AppletBottomSheetAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L15:
            c = r2;
            int[] r3 = new int[AppletBottomSheetButtonRole.values().length];
            r3[AppletBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L47:
            r3[AppletBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L57:
            r3[AppletBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L19:
            d = r3;
            int[] r4 = new int[AppletBottomSheetCancelSource.values().length];
            r4[AppletBottomSheetCancelSource.MASK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L49:
            r4[AppletBottomSheetCancelSource.GESTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L59:
            r4[AppletBottomSheetCancelSource.HOST_UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L65:
            r4[AppletBottomSheetCancelSource.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L24:
            e = r4;
        }
    }

    public static final GrantingAction a(OperateResult r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return GrantingAction.DISMISSED;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return GrantingAction.REJECTED;
    L13:
        return GrantingAction.AGREED;
    }
}
