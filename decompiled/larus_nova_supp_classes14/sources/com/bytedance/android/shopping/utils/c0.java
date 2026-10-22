package com.bytedance.android.shopping.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 {
    public static Method a;
    public static boolean b;
    public static Class<?> c;
    public static Method d;

    public interface a {
        void onPageTranslucent();

        void onPageTranslucentError();
    }

    public static final class b implements InvocationHandler {
        public final a a;

        public b(com.bytedance.android.shopping.anchorv4.containers.l r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.a = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r2, Method r3, Object[] r4) throws Throwable {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            Intrinsics.checkNotNullParameter(r3, "method");
            Intrinsics.checkNotNullParameter(r4, "args");
            Object r5 = r4[0];     // Catch: Throwable -> L11
            if (r5 == null) goto L10;
            if (((Boolean) r5).booleanValue() == false) goto L8;
            int r6 = z.a;     // Catch: Throwable -> L11
            z.b("onPageTranslucent", null, null);     // Catch: Throwable -> L11
            this.a.onPageTranslucent();     // Catch: Throwable -> L11
        L13:
            return null;
        L8:
            int r7 = z.a;     // Catch: Throwable -> L11
            z.b("onPageTranslucentError", null, null);     // Catch: Throwable -> L11
            this.a.onPageTranslucentError();     // Catch: Throwable -> L11
            goto L13
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            int r8 = z.a;
            z.a("TranslucentConversionHandler error ", th, "PdpTranslucentUtil");
            a r9 = this.a;
            th.getMessage();
            r9.onPageTranslucentError();
            goto L13
        }
    }

    static {
    }
}
