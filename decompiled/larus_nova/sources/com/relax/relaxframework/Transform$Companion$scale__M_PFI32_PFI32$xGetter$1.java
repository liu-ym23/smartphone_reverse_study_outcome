package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "Ljava/util/ArrayList;", "", "Lcom/bytedance/rts/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class Transform$Companion$scale__M_PFI32_PFI32$xGetter$1 extends Lambda implements Function0<ArrayList<Double>> {
    final /* synthetic */ Function0<Integer> $x;

    public Transform$Companion$scale__M_PFI32_PFI32$xGetter$1(Function0<Integer> r100) {
        this.$x = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<Double> invoke2() {
        int r100 = com.bytedance.rts.foundation.d.f267577a;
        return com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(this.$x.invoke().intValue()), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)});
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ArrayList<Double> invoke() {
        return invoke2();
    }
}
