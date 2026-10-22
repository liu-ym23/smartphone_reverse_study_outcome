package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f405180a = 0;

    public static final class a {
        public static void a(String... r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            ArrayList r101 = new ArrayList(ArraysKt.toList(r100));
            int r102 = com.bytedance.rts.foundation.y.f267598a;
            int r103 = l6.f405180a;
            com.bytedance.rts.foundation.y.a.a(new Object[]{"[Relax] " + com.bytedance.rts.foundation.j.g(r101, " ")});
        }
    }

    static {
    }
}
