package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class p8 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransformType f405220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends ArrayList<Double>> f405221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends ArrayList<Double>> f405222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends ArrayList<Double>> f405223d;

    @Override // com.relax.relaxframework.b2
    public final ArrayList<Double> a() {
        Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        ArrayList<Double> r101 = com.bytedance.rts.foundation.j.k(new Double[]{r100, r100});
        Function0<? extends ArrayList<Double>> r102 = this.f405221b;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        r101 = r102.invoke();
    L5:
        ArrayList<Double> r103 = com.bytedance.rts.foundation.j.k(new Double[]{r100, r100});
        Function0<? extends ArrayList<Double>> r104 = this.f405222c;
        if (r104 == null) goto L8;
        Intrinsics.checkNotNull(r104);
        r103 = r104.invoke();
    L8:
        ArrayList<Double> r105 = com.bytedance.rts.foundation.j.k(new Double[]{r100, r100});
        Function0<? extends ArrayList<Double>> r106 = this.f405223d;
        if (r106 == null) goto L11;
        Intrinsics.checkNotNull(r106);
        r105 = r106.invoke();
    L11:
        Double[] r107 = new Double[1];
        int r108 = com.bytedance.rts.foundation.d.f267577a;
        TransformType r109 = this.f405220a;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("_type");
        r109 = null;
    L14:
        r107[0] = Double.valueOf(r109.getValue());
        return com.bytedance.rts.foundation.j.a(com.bytedance.rts.foundation.j.a(com.bytedance.rts.foundation.j.a(com.bytedance.rts.foundation.j.k(r107), new ArrayList[]{r101}), new ArrayList[]{r103}), new ArrayList[]{r105});
    }

    @Override // com.relax.relaxframework.b2
    public final o8 b() {
        TransformType r100 = this.f405220a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_type");
        r100 = null;
    L6:
        return new o8(r100.getValue(), com.bytedance.rts.foundation.j.k(new Double[0]));
    }

    public p8(TransformType r100, Function0 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f405221b = r101;
        this.f405222c = r102;
        this.f405223d = null;
        this.f405220a = r100;
    }
}
