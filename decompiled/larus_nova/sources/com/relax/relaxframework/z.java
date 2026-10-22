package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Double> f405364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<ModifierValuePattern> f405365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f405366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ModifierValuePattern f405367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f405368e;

    public ArrayList<Object> a() {
        return com.bytedance.rts.foundation.j.k(new Object[0]);
    }

    public final f8 b() {
        ArrayList r100 = new ArrayList();
        ArrayList<ModifierValuePattern> r101 = this.f405365b;
        ModifierValuePattern r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("offsetPattern");
        r101 = null;
    L6:
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.rts.foundation.j.j(r100, Integer.valueOf(((ModifierValuePattern) r103.next()).getValue()));
        goto L8
    L10:
        ArrayList<Double> r104 = this.f405364a;
        if (r104 == null) goto L13;
        ArrayList<Double> r105 = r104;
    L14:
        double r106 = this.f405366c;
        ModifierValuePattern r107 = this.f405367d;
        if (r107 == null) goto L17;
        r102 = r107;
    L19:
        return new f8(r105, r100, r106, r102.getValue(), this.f405368e);
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("blurPattern");
        goto L19
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("offsetValues");
        r105 = null;
        goto L14
    }

    public z() {
        ArrayList<Double> r100 = com.bytedance.rts.foundation.j.k(new Double[0]);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405364a = r100;
        ArrayList<ModifierValuePattern> r101 = com.bytedance.rts.foundation.j.k(new ModifierValuePattern[0]);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405365b = r101;
        this.f405366c = AudioStats.AUDIO_AMPLITUDE_NONE;
        ModifierValuePattern r102 = ModifierValuePattern.PX;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405367d = r102;
        this.f405368e = 0;
    }

    public final void c(s0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f405368e = r100.f405261a;
    }

    public final void d(s0.c r100, s0.c r101) {
        Intrinsics.checkNotNullParameter(r100, "x");
        Intrinsics.checkNotNullParameter(r101, "y");
        ArrayList<Double> r102 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r100.a()), Double.valueOf(r101.a())});
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405364a = r102;
        ModifierValuePattern r103 = ModifierValuePattern.PX;
        ArrayList<ModifierValuePattern> r104 = com.bytedance.rts.foundation.j.k(new ModifierValuePattern[]{r103, r103});
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f405365b = r104;
    }
}
