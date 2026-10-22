package com.bytedance.rts.kmp.foundation;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@RTSHiddenFromObjC
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267614a = 0;

    public static final class a {
        public static void a(Object... r110) {
            Intrinsics.checkNotNullParameter(r110, "messages");
            System.out.println("RTSError:" + ArraysKt.joinToString$default(r110, " ", null, null, 0, null, null, 62, null));
        }
    }

    static {
    }
}
