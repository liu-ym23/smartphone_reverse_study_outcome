package com.larus.canvas.feature.component.resultdisplay.image;

import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f323558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f323559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ChatConstraintLayout.b, Unit> f323560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<CanvasProgressState> f323561d;

    /* JADX WARN: Multi-variable type inference failed */
    public q(int r100, int r101, Function1<? super ChatConstraintLayout.b, Unit> r102, Function0<CanvasProgressState> r103) {
        Intrinsics.checkNotNullParameter(r102, "addBottomInsetUpdateListener");
        Intrinsics.checkNotNullParameter(r103, "canvasProgressStateGetter");
        this.f323558a = r100;
        this.f323559b = r101;
        this.f323560c = r102;
        this.f323561d = r103;
    }
}
