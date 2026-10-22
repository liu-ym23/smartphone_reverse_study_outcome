package com.bytedance.rts.foundation;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267598a = 0;

    public static final class a {
        public static void a(Object... r110) {
            Intrinsics.checkNotNullParameter(r110, "messages");
            Object[] r100 = Arrays.copyOf(r110, r110.length);
            Intrinsics.checkNotNullParameter(r100, "messages");
            System.err.println("RTSError:" + ArraysKt.joinToString$default(r100, " ", null, null, 0, null, null, 62, null));
        }

        public static void b(Object... r110) {
            Intrinsics.checkNotNullParameter(r110, "messages");
            Object[] r100 = Arrays.copyOf(r110, r110.length);
            Intrinsics.checkNotNullParameter(r100, "messages");
            String r111 = ArraysKt.joinToString$default(r100, " ", null, null, 0, null, null, 62, null);
            System.out.println(r111);
        }
    }

    static {
    }
}
