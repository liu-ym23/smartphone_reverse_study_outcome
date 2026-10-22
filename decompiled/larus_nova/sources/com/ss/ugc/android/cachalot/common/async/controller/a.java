package com.ss.ugc.android.cachalot.common.async.controller;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f457131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f457132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f457133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f457134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f457135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f457136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<RecyclerView.ViewHolder, Unit> f457137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f457138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f457139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f457140j;

    public a() {
        this(false, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f457131a == r101.f457131a) goto L12;
        return false;
    L12:
        if (this.f457132b == r101.f457132b) goto L15;
        return false;
    L15:
        if (this.f457133c == r101.f457133c) goto L18;
        return false;
    L18:
        if (this.f457134d == r101.f457134d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f457135e, r101.f457135e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f457136f, r101.f457136f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f457137g, r101.f457137g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f457138h, r101.f457138h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f457139i, r101.f457139i) == true) goto L36;
        return false;
    L36:
        if (this.f457140j == r101.f457140j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f457131a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f457132b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f457133c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f457134d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((((((r106 + r107) * 31) + this.f457135e.hashCode()) * 31) + this.f457136f.hashCode()) * 31) + this.f457137g.hashCode()) * 31;
        ExecutorService r109 = this.f457138h;
        int r110 = 0;
        if (r109 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r108 + r111) * 31;
        Long r113 = this.f457139i;
        if (r113 == null) goto L26;
        r110 = r113.hashCode();
    L26:
        int r114 = (r112 + r110) * 31;
        if (this.f457140j == true) goto L31;
        r100 = 1237;
    L31:
        return r114 + r100;
    L21:
        r111 = r109.hashCode();
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "IndividualBindConfig(forceBindOnMainThread=" + this.f457131a + ", notAllowDoPreloadOnMainThread=" + this.f457132b + ", bindNow=" + this.f457133c + ", forcePreBind=" + this.f457134d + ", canContinue=" + this.f457135e + ", onComplete=" + this.f457136f + ", onViewHolderCreated=" + this.f457137g + ", executor=" + this.f457138h + ", timeout=" + this.f457139i + ", isOffScreenPreBind=" + this.f457140j + ')';
    }

    public a(boolean r100, Function0 r101, Function0 r102, ExecutorService r103, Long r104, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r100 = false;
    L6:
        if ((r110 & 16) == 0) goto L9;
        r101 = IndividualBindConfig$1.INSTANCE;
    L9:
        if ((r110 & 32) == 0) goto L12;
        r102 = IndividualBindConfig$2.INSTANCE;
    L12:
        if ((r110 & 64) == 0) goto L14;
        IndividualBindConfig$3 r105 = IndividualBindConfig$3.INSTANCE;
    L16:
        if ((r110 & 128) == 0) goto L19;
        r103 = null;
    L19:
        if ((r110 & 256) == 0) goto L21;
        r104 = null;
    L21:
        Intrinsics.checkNotNullParameter(r101, "canContinue");
        Intrinsics.checkNotNullParameter(r102, "onComplete");
        Intrinsics.checkNotNullParameter(r105, "onViewHolderCreated");
        this.f457131a = false;
        this.f457132b = r100;
        this.f457133c = false;
        this.f457134d = false;
        this.f457135e = r101;
        this.f457136f = r102;
        this.f457137g = r105;
        this.f457138h = r103;
        this.f457139i = r104;
        this.f457140j = false;
        return;
    L14:
        r105 = null;
        goto L16
    }
}
