package com.bytedance.ee.bear;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f236228b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f236229a;

    public static final class a {
        @JvmStatic
        public static p a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            return new p(new b(r100));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f236230a;

        public b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            this.f236230a = r100;
        }
    }

    static {
    }

    public final Throwable a() {
        Object r100 = this.f236229a;
        if ((r100 instanceof b) == false) goto L5;
        b r101 = (b) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f236230a;
    L5:
        r101 = null;
        goto L6
    }

    public p(Object r100) {
        this.f236229a = r100;
    }
}
