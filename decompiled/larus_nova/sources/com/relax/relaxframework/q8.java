package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q8 extends c0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f405238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f405239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h8 f405240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f405241j;

    public q8() {
        super(CSSModifierProperty.None, null, RxModifierType.Builtin, null, new r8());
        ModifierEngine.f404789a.getClass();
        this.f405241j = ModifierEngine.Companion.e();
        d(BuiltinModifierState.Init);
        this.f405239h = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.relax.relaxframework.p6
    public final int c() {
        return this.f405241j;
    }

    @Override // com.relax.relaxframework.c0
    public final c0 e(int r100) {
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        this.f405239h = r100;
        return this;
    }

    @Override // com.relax.relaxframework.c0
    public final c0 f(ModifierValue_AnimationProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f405238g = Integer.valueOf(r100.getValue());
        return this;
    }
}
