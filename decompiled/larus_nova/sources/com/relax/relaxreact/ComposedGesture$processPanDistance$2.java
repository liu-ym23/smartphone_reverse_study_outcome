package com.relax.relaxreact;

import androidx.camera.video.AudioStats;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "gesture", "Lcom/relax/relaxreact/PanGesture;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ComposedGesture$processPanDistance$2 extends Lambda implements Function1<r0, Unit> {
    public static final ComposedGesture$processPanDistance$2 INSTANCE = null;

    static {
        INSTANCE = new ComposedGesture$processPanDistance$2();
    }

    public ComposedGesture$processPanDistance$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        Object r101 = com.bytedance.rts.kmp.foundation.j.c(r100.f405385c, "minDistance");
        Double r102 = null;
        if ((r101 instanceof Double) == false) goto L5;
        Double r103 = (Double) r101;
    L6:
        if (r103 == null) goto L12;
        Object r104 = com.bytedance.rts.kmp.foundation.j.c(r100.f405385c, "minDistance");
        if ((r104 instanceof Double) == false) goto L11;
        r102 = (Double) r104;
    L11:
        if (Intrinsics.areEqual(r102, AudioStats.AUDIO_AMPLITUDE_NONE) == true) goto L12;
        return;
    L12:
        r100.e(Double.valueOf(10.0d));
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(r0 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
