package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1a.b f299848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final de8.c f299849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f299850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f299851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f299852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f299853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f299854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f299855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f299856i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Boolean> f299858b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f299857a, r101.f299857a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299858b, r101.f299858b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f299857a.hashCode() * 31) + this.f299858b.hashCode();
        }

        public final String toString() {
            return "DisallowCondition(logMessage=" + this.f299857a + ", disable=" + this.f299858b + ')';
        }

        public b(String r100, Function0<Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "logMessage");
            Intrinsics.checkNotNullParameter(r101, "disable");
            this.f299857a = r100;
            this.f299858b = r101;
        }
    }

    static {
    }

    public b0(t1a.b r100, de8.c r101) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        this.f299848a = r100;
        this.f299849b = r101;
        this.f299850c = LazyKt.lazy(new m(this));
        this.f299851d = LazyKt.lazy(new s(this));
        this.f299852e = LazyKt.lazy(new t(this));
        this.f299853f = LazyKt.lazy(new u(this));
        this.f299854g = LazyKt.lazy(new v(this));
        this.f299855h = LazyKt.lazy(new w(this));
        this.f299856i = LazyKt.lazy(new x(this));
    }
}
