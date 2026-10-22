package com.bytedance.rts.kmp.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@RTSHiddenFromObjC
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267612a = 0;

    public static final class a {
        public static String a(int... r100) {
            Intrinsics.checkNotNullParameter(r100, "code");
            StringBuilder r101 = new StringBuilder();
            int r102 = r100.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            r101.append((char) r100[r103]);
            r103 = r103 + 1;
            goto L3
        L6:
            return r101.toString();
        }
    }

    static {
    }
}
