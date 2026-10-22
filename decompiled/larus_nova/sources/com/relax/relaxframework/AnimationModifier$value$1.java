package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AnimationModifier$value$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<f> $value;
    final /* synthetic */ d this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationModifier$value$1(d r100, Function0<? extends f> r101) {
        this.this$0 = r100;
        this.$value = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d r100 = this.this$0;
        f r101 = this.$value.invoke();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        r101.getClass();
        r100.f405044g = AudioStats.AUDIO_AMPLITUDE_NONE;
        r100.f405045h = AudioStats.AUDIO_AMPLITUDE_NONE;
        r100.f405046i = null;
        r100.f405047j = r101.f405075c.getValue();
        r100.f405048k = r101.f405076d.getValue();
        r100.f405049l = r101.f405077e.getValue();
        r100.f405050m = r101.f405078f;
        ArrayList<t1> r102 = r101.f405074b;
        Intrinsics.checkNotNullParameter(r102, "keyframes");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f405051n = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
