package com.bytedance.livesdk.ktvcommon.midi.view;

import android.animation.Animator;
import android.content.Context;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.KtvMidiHitParticleView;
import com.bytedance.livesdk.ktvcommon.midi.view.midihitview.KtvMidiHitEffectView;
import com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.KtvMidiPlayerView;

/* JADX INFO: loaded from: classes20.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KtvMidiHitEffectView f256072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KtvMidiHitParticleView f256073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KtvMidiPlayerView f256074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f256075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f256076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f256077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f256078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f256079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HitType f256080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f256081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f256082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i f256083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f256084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Animator f256085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Animator f256086o;

    public final void a() {
        Animator r100 = this.f256085n;
        if (r100 != null) goto L5;
    L9:
        Animator r101 = this.f256086o;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isRunning() != true) goto L18;
        Animator r102 = this.f256086o;
        if (r102 == null) goto L19;
        r102.end();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r100.isRunning() != true) goto L9;
        Animator r103 = this.f256085n;
        if (r103 == null) goto L9;
        r103.end();
        goto L9
    }

    public e() {
        this.f256078g = -1;
        this.f256080i = HitType.MISS;
        this.f256081j = vm2.h.G();
        this.f256082k = vm2.h.I();
        this.f256084m = new KtvMidiStrategy();
    }
}
