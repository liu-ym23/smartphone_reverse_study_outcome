package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f405044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f405045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h8 f405046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f405047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f405048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f405049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f405050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<t1> f405051n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<Function0<t1>> f405052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<Function0<t1>> f405053p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f405054q;

    public d() {
        super(CSSModifierProperty.None, null, RxModifierType.Builtin, null, new AnimationModifierApplier());
        ModifierEngine.f404789a.getClass();
        this.f405054q = ModifierEngine.Companion.e();
        d(BuiltinModifierState.Init);
        this.f405044g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f405045h = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f405047j = ModifierValue_AnimationFillMode.None.getValue();
        this.f405048k = ModifierValue_AnimationDirection.Normal.getValue();
        this.f405049l = ModifierValue_AnimationPlayState.Running.getValue();
        this.f405050m = 1;
        ArrayList<t1> r100 = com.bytedance.rts.foundation.j.k(new t1[0]);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405051n = r100;
        ArrayList<Function0<t1>> r101 = com.bytedance.rts.foundation.j.k(new Function0[0]);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405052o = r101;
        ArrayList<Function0<t1>> r102 = com.bytedance.rts.foundation.j.k(new Function0[0]);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405053p = r102;
    }

    @Override // com.relax.relaxframework.n
    public final n e() {
        int r100 = com.bytedance.rts.foundation.d.f267577a;
        this.f405044g = 300;
        return this;
    }

    @Override // com.relax.relaxframework.p6
    public final int c() {
        return this.f405054q;
    }

    @Override // com.relax.relaxframework.n
    public final n f(int r100) {
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        this.f405045h = r100;
        return this;
    }

    @Override // com.relax.relaxframework.n
    public final n g(ModifierValue_AnimationFillMode r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f405047j = r100.getValue();
        return this;
    }

    @Override // com.relax.relaxframework.n
    public final n h(int r100) {
        this.f405050m = r100;
        return this;
    }

    @Override // com.relax.relaxframework.n
    public final n i(ModifierValue_AnimationIterationCount r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100 != ModifierValue_AnimationIterationCount.Infinite) goto L5;
        this.f405050m = -1;
    L5:
        return this;
    }

    @Override // com.relax.relaxframework.n
    public final n j(ArrayList r100) {
        Intrinsics.checkNotNullParameter(r100, "keyframes");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405051n = r100;
        return this;
    }

    @Override // com.relax.relaxframework.n
    public final n k(h8 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f405046i = r100;
        return this;
    }
}
