package com.bytedance.rts.foundation;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "messages");
            Object[] r2 = Arrays.copyOf(r11, r11.length);
            Intrinsics.checkNotNullParameter(r2, "messages");
            System.err.println("RTSError:" + ArraysKt.joinToString$default(r2, " ", null, null, 0, null, null, 62, null));
        }

        public static void b(Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "messages");
            Object[] r2 = Arrays.copyOf(r11, r11.length);
            Intrinsics.checkNotNullParameter(r2, "messages");
            String r12 = ArraysKt.joinToString$default(r2, " ", null, null, 0, null, null, 62, null);
            System.out.println(r12);
        }
    }

    static {
    }
}
