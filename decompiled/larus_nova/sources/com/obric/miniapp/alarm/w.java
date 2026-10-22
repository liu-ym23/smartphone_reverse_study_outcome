package com.obric.miniapp.alarm;

import android.os.Build;
import java.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class w implements Comparable<w> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f397489b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f397490c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f397491a;

    public static final class a {
        public static w a() {
            if (w.f397490c == false) goto L5;
            Object r100 = Instant.now();
        L7:
            return new w(r100);
        L5:
            r100 = new Date(System.currentTimeMillis());
            goto L7
        }

        public static w b(long r100) {
            if (w.f397490c == false) goto L5;
            Object r101 = Instant.ofEpochMilli(r100);
        L7:
            return new w(r101);
        L5:
            r101 = new Date(r100);
            goto L7
        }
    }

    public /* synthetic */ w() {
        throw null;
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = false;
        if (r100 < 34) goto L5;
        boolean r102 = true;
    L6:
        f397489b = r102;
        if (r100 < 26) goto L9;
        r101 = true;
    L9:
        f397490c = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final long b() {
        if (f397490c == false) goto L5;
        Object r100 = this.f397491a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.time.Instant");
        return ((Instant) r100).toEpochMilli();
    L5:
        Object r101 = this.f397491a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.Date");
        return ((Date) r101).getTime();
    }

    public w(Object r100) {
        this.f397491a = r100;
    }

    public final int a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (f397490c == false) goto L5;
        Object r101 = this.f397491a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.time.Instant");
        Object r102 = r100.f397491a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.time.Instant");
        return ((Instant) r101).compareTo((Instant) r102);
    L5:
        Object r103 = this.f397491a;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.Date");
        Object r104 = r100.f397491a;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.Date");
        return ((Date) r103).compareTo((Date) r104);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(w r100) {
        return a(r100);
    }
}
