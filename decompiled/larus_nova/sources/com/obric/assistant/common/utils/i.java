package com.obric.assistant.common.utils;

import android.os.Build;
import android.os.Trace;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f387878a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f387879b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f387880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f387881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f387882c;

        public final void a() {
            if (i.f387878a == true) goto L5;
            return;
        L5:
            if (this.f387882c.compareAndSet(false, true) == false) goto L9;
            Trace.endAsyncSection(this.f387880a, this.f387881b);
            return;
        }

        public a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f387880a = r100;
            this.f387881b = r101;
            this.f387882c = new AtomicBoolean(false);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r100 = true;
    L6:
        f387878a = r100;
        f387879b = new AtomicInteger(0);
        return;
    L5:
        r100 = false;
        goto L6
    }

    @JvmStatic
    public static final a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (f387878a == true) goto L5;
        return null;
    L5:
        if (Trace.isEnabled() == false) goto L11;
        int r101 = f387879b.updateAndGet(new h());
        Trace.beginAsyncSection(r100, r101);
        return new a(r100, r101);
    L11:
        return null;
    }

    @JvmStatic
    public static final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (f387878a == true) goto L5;
        return false;
    L5:
        if (Trace.isEnabled() == false) goto L11;
        Trace.beginSection(r100);
        return true;
    L11:
        return false;
    }
}
