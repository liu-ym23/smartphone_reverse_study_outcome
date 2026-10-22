package com.ss.android.lark.biz.im.api.extension.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ScrollEvent {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Function1<RecyclerView, Integer> f410222j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScrollScene f410223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<RecyclerView, Integer> f410224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<RecyclerView, Integer> f410225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollAlign f410226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f410227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f410228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f410229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f410230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f410231i;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScrollEvent) == true) goto L8;
        return false;
    L8:
        ScrollEvent r101 = (ScrollEvent) r100;
        if (this.f410223a == r101.f410223a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410224b, r101.f410224b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410225c, r101.f410225c) == true) goto L18;
        return false;
    L18:
        if (this.f410226d == r101.f410226d) goto L21;
        return false;
    L21:
        if (this.f410227e == r101.f410227e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f410228f, r101.f410228f) == true) goto L27;
        return false;
    L27:
        if (this.f410229g == r101.f410229g) goto L30;
        return false;
    L30:
        if (this.f410230h == r101.f410230h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f410231i, r101.f410231i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f410223a.hashCode() * 31;
        Function1<RecyclerView, Integer> r101 = this.f410224b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function1<RecyclerView, Integer> r105 = this.f410225c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        ScrollAlign r108 = this.f410226d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f410227e == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f410228f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        long r116 = this.f410229g;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        if (this.f410230h == true) goto L26;
        r111 = 1237;
    L26:
        int r118 = (r117 + r111) * 31;
        b r119 = this.f410231i;
        if (r119 == null) goto L31;
        r102 = r119.hashCode();
    L31:
        return r118 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScrollEvent(scene=" + this.f410223a + ", position=" + this.f410224b + ", offset=" + this.f410225c + ", align=" + this.f410226d + ", smooth=" + this.f410227e + ", smoothSpeed=" + this.f410228f + ", delay=" + this.f410229g + ", dropPrevious=" + this.f410230h + ", callback=" + this.f410231i + ')';
    }

    static {
        ScrollEvent$Companion$TopPosition$1 r100 = ScrollEvent$Companion$TopPosition$1.INSTANCE;
        f410222j = ScrollEvent$Companion$BottomPosition$1.INSTANCE;
    }

    public ScrollEvent(ScrollScene r100, Function1 r101, Function1 r102, ScrollAlign r103, boolean r104, long r105, b r106) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f410223a = r100;
        this.f410224b = r101;
        this.f410225c = r102;
        this.f410226d = r103;
        this.f410227e = r104;
        this.f410228f = null;
        this.f410229g = r105;
        this.f410230h = false;
        this.f410231i = r106;
    }
}
