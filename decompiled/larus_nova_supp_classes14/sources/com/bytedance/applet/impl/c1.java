package com.bytedance.applet.impl;

import com.bytedance.ai.api.OperateResult;
import com.larus.platform.api.MusicOperateResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c1 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MusicOperateResult.values().length];
            r0[MusicOperateResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MusicOperateResult.REJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MusicOperateResult.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final OperateResult a(MusicOperateResult r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return OperateResult.CANCEL;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return OperateResult.REJECT;
    L13:
        return OperateResult.SUCCESS;
    }
}
