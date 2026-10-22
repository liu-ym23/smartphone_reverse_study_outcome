package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class x implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<h0> f405344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RadialGradientShape f405345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f405346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<Double> f405347d;

    public final Object[] a() {
        Object[] r100 = this.f405346c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("sizeList");
        return null;
    }

    public x() {
        ArrayList<h0> r100 = com.bytedance.rts.foundation.j.k(new h0[0]);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405344a = r100;
        RadialGradientShape r101 = RadialGradientShape.Ellipse;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405345b = r101;
        ModifierValuePattern r102 = ModifierValuePattern.PERCENT;
        Object[] r103 = {new d3(AudioStats.AUDIO_AMPLITUDE_NONE, r102), new d3(AudioStats.AUDIO_AMPLITUDE_NONE, r102)};
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f405346c = r103;
        ArrayList<Double> r104 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)});
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f405347d = r104;
    }
}
