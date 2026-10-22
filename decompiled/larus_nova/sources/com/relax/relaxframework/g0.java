package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Double> f405092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f405093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f405094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f405095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f405096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f405097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f405098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f405099h;

    public g0(ArrayList r100, ArrayList r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        Intrinsics.checkNotNullParameter(r101, "offsetPattern");
        this.f405092a = r100;
        this.f405093b = r101;
        this.f405094c = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f405095d = r102;
        this.f405096e = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f405097f = r103;
        this.f405098g = 0;
        this.f405099h = r104;
    }
}
