package com.bytedance.rts.kmp.foundation;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@RTSHiddenFromObjC
public final class r {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "messages");
            System.out.println("RTSError:" + ArraysKt.joinToString$default(r11, " ", null, null, 0, null, null, 62, null));
        }
    }

    static {
    }
}
