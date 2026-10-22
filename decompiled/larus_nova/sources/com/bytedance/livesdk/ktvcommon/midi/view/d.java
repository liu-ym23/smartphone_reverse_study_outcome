package com.bytedance.livesdk.ktvcommon.midi.view;

import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.KtvMidiHitParticleView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f256069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f256070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bl6.e f256071c;

    public d(e r100, Pair r101, bl6.e r102) {
        this.f256069a = r100;
        this.f256070b = r101;
        this.f256071c = r102;
    }

    public final void a() {
        KtvMidiHitParticleView r100 = this.f256069a.f256073b;
        if (r100 == null) goto L6;
        float r101 = ((Number) this.f256070b.getFirst()).floatValue();
        float r102 = ((Number) this.f256070b.getSecond()).floatValue();
        e r103 = this.f256069a;
        HitType r104 = r103.f256080i;
        boolean r105 = r103.f256079h;
        r100.b(r101, r102, r104, this.f256071c.f19488i, r105);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
