package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class v implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<h0> f405308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f405309b;

    public ArrayList<Object> a() {
        return com.bytedance.rts.foundation.j.k(new Object[0]);
    }

    public v() {
        ArrayList<h0> r100 = com.bytedance.rts.foundation.j.k(new h0[0]);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405308a = r100;
        this.f405309b = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final void b(long r100, double r101) {
        ArrayList<h0> r102 = this.f405308a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("colorStopList");
        r102 = null;
    L6:
        com.bytedance.rts.foundation.j.j(r102, new h0(r100, r101));
    }

    public final void c(long r100, int r101) {
        ArrayList<h0> r102 = this.f405308a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("colorStopList");
        r102 = null;
    L6:
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r102, new h0(r100, r101));
    }
}
