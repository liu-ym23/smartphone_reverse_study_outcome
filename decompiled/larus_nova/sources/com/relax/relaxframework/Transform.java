package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class Transform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f404980a = 0;

    public static final class Companion {
        public static u8 a(final d3 r100) {
            Intrinsics.checkNotNullParameter(r100, "x");
            return new u8(new Transform$Companion$translateX$xGetter$1(r100));
        }

        public static v8 b(final d3 r100) {
            Intrinsics.checkNotNullParameter(r100, "y");
            return new v8(new Transform$Companion$translateY$yGetter$1(r100));
        }
    }

    static {
    }
}
