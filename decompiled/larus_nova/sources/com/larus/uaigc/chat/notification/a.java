package com.larus.uaigc.chat.notification;

import androidx.camera.video.AudioStats;
import java.security.SecureRandom;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f371327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f371328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f371329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f371330d;

    public final int a(double r110) {
        int r100 = this.f371330d;
        int r101 = this.f371327a;
        if (r100 < r101) goto L5;
        return r101;
    L5:
        double r102 = (new SecureRandom().nextDouble() - 0.5d) * ((double) 2);
        int r111 = RangesKt.coerceIn((int) ((((double) this.f371327a) * (((double) 1) - Math.exp((-this.f371328b) * Math.pow(r110, this.f371329c)))) + r102), this.f371330d, this.f371327a);
        if (r111 <= this.f371330d) goto L9;
        this.f371330d = r111;
    L9:
        return this.f371330d;
    }

    public a(double r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = 99;
    L7:
        if ((r101 & 2) == 0) goto L10;
        r100 = 0.03d;
    L10:
        if ((r101 & 4) == 0) goto L12;
        double r103 = 0.7d;
    L13:
        this.f371327a = r102;
        this.f371328b = r100;
        this.f371329c = r103;
        return;
    L12:
        r103 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L13
    L5:
        r102 = 0;
        goto L7
    }
}
