package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f354342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f354343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Float, Unit> f354344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Float, Unit> f354345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Float, Unit> f354346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Float, Unit> f354347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f354348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function3<String, Float, Float, Unit> f354349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<String, Integer, Unit> f354350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<String, Unit> f354351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Boolean, Unit> f354352k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f354342a, r101.f354342a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354343b, r101.f354343b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354344c, r101.f354344c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f354345d, r101.f354345d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f354346e, r101.f354346e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f354347f, r101.f354347f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f354348g, r101.f354348g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f354349h, r101.f354349h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f354350i, r101.f354350i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f354351j, r101.f354351j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f354352k, r101.f354352k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.f354342a.hashCode() * 31) + this.f354343b.hashCode()) * 31) + this.f354344c.hashCode()) * 31) + this.f354345d.hashCode()) * 31) + this.f354346e.hashCode()) * 31) + this.f354347f.hashCode()) * 31) + this.f354348g.hashCode()) * 31) + this.f354349h.hashCode()) * 31) + this.f354350i.hashCode()) * 31) + this.f354351j.hashCode()) * 31) + this.f354352k.hashCode();
    }

    public final String toString() {
        return "DoubleTabEditAreaCallbacks(onPlayClick=" + this.f354342a + ", onRemoveClick=" + this.f354343b + ", onPitchChanged=" + this.f354344c + ", onRateChanged=" + this.f354345d + ", onPitchCommit=" + this.f354346e + ", onRateCommit=" + this.f354347f + ", onVibrate=" + this.f354348g + ", onReportEditResult=" + this.f354349h + ", onMixVoiceProgressChanged=" + this.f354350i + ", onMixVoiceItemAudition=" + this.f354351j + ", onExpandIconClick=" + this.f354352k + ')';
    }

    public h0() {
        this(new w(), new z(), new a0(), new b0(), new c0(), new d0(), new e0(), new f0(), new g0(), new x(), new y());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(Function1<? super String, Unit> r100, Function1<? super String, Unit> r101, Function1<? super Float, Unit> r102, Function1<? super Float, Unit> r103, Function1<? super Float, Unit> r104, Function1<? super Float, Unit> r105, Function0<Unit> r106, Function3<? super String, ? super Float, ? super Float, Unit> r107, Function2<? super String, ? super Integer, Unit> r110, Function1<? super String, Unit> r111, Function1<? super Boolean, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "onPlayClick");
        Intrinsics.checkNotNullParameter(r101, "onRemoveClick");
        Intrinsics.checkNotNullParameter(r102, "onPitchChanged");
        Intrinsics.checkNotNullParameter(r103, "onRateChanged");
        Intrinsics.checkNotNullParameter(r104, "onPitchCommit");
        Intrinsics.checkNotNullParameter(r105, "onRateCommit");
        Intrinsics.checkNotNullParameter(r106, "onVibrate");
        Intrinsics.checkNotNullParameter(r107, "onReportEditResult");
        Intrinsics.checkNotNullParameter(r110, "onMixVoiceProgressChanged");
        Intrinsics.checkNotNullParameter(r111, "onMixVoiceItemAudition");
        Intrinsics.checkNotNullParameter(r112, "onExpandIconClick");
        this.f354342a = r100;
        this.f354343b = r101;
        this.f354344c = r102;
        this.f354345d = r103;
        this.f354346e = r104;
        this.f354347f = r105;
        this.f354348g = r106;
        this.f354349h = r107;
        this.f354350i = r110;
        this.f354351j = r111;
        this.f354352k = r112;
    }
}
