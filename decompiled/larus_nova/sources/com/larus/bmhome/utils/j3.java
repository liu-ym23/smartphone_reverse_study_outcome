package com.larus.bmhome.utils;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j3 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.larus.bmhome.social.page.datasource.event.c<xc8.b> f315030h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f315031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.bmhome.social.page.datasource.event.c<xc8.b> f315032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super com.larus.bmhome.social.page.datasource.event.c<xc8.b>, Unit> f315033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f315034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f315035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.bmhome.social.page.datasource.event.c<xc8.b> f315036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f315037g;

    public static final class a {
    }

    public j3() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j3) == true) goto L8;
        return false;
    L8:
        j3 r101 = (j3) r100;
        if (Intrinsics.areEqual(this.f315031a, r101.f315031a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f315032b, r101.f315032b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f315033c, r101.f315033c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f315034d, r101.f315034d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f315035e, r101.f315035e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f315031a.hashCode() * 31) + this.f315032b.hashCode()) * 31) + this.f315033c.hashCode()) * 31) + Float.floatToIntBits(this.f315034d)) * 31) + Float.floatToIntBits(this.f315035e);
    }

    public final String toString() {
        return "RecoverTask(toppingStrategy=" + this.f315031a + ", updateEvent=" + this.f315032b + ", recoverAction=" + this.f315033c + ", startY=" + this.f315034d + ", endY=" + this.f315035e + ')';
    }

    static {
        f315030h = new com.larus.bmhome.social.page.datasource.event.c(CollectionsKt.emptyList(), 0, CollectionsKt.emptyList());
    }

    public final void a() {
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r100 = this.f315032b;
        this.f315033c.invoke(r100);
        this.f315033c = new i3();
        this.f315032b = f315030h;
    }

    public j3(d2 r100) {
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r101 = f315030h;
        Function1<? super com.larus.bmhome.social.page.datasource.event.c<xc8.b>, Unit> r102 = new h3();
        Intrinsics.checkNotNullParameter(r100, "toppingStrategy");
        Intrinsics.checkNotNullParameter(r101, "updateEvent");
        Intrinsics.checkNotNullParameter(r102, "recoverAction");
        this.f315031a = r100;
        this.f315032b = r101;
        this.f315033c = r102;
        this.f315034d = 0.0f;
        this.f315035e = 0.0f;
        this.f315036f = r101;
    }
}
