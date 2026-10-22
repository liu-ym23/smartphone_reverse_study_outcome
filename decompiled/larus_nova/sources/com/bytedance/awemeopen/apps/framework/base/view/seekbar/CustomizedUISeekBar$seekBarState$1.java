package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.animation.Animator;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class CustomizedUISeekBar$seekBarState$1 extends FunctionReferenceImpl implements Function2<SeekBarState.State, SeekBarState.Action, Unit> {
    public CustomizedUISeekBar$seekBarState$1(Object r100) {
        super(2, r100, CustomizedUISeekBar.class, "newState", "newState(Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$Action;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SeekBarState.State r100, SeekBarState.Action r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        CustomizedUISeekBar r102 = (CustomizedUISeekBar) this.receiver;
        Animator r103 = r102.G;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        int r104 = CustomizedUISeekBar.a.f193605b[r100.ordinal()];
        if (r104 != 1) goto L8;
        r102.setProgressDrawable(r102.H);
        Resources r105 = Resources.getSystem();
        int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        Resources r107 = Resources.getSystem();
        r102.setPadding(0, r106, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))));
        r102.setThumb(r102.I);
        return;
    L8:
        if (r104 == 2) goto L26;
        if (r104 == 3) goto L15;
        if (r104 != 4) goto L50;
        r102.e(r102.A);
        if (r102.f193600w == false) goto L41;
        r102.h();
        return;
    L41:
        return;
    L50:
        return;
    L15:
        int r108 = CustomizedUISeekBar.a.f193604a[r101.ordinal()];
        if (r108 == 5) goto L22;
        if (r108 != 6) goto L19;
    L21:
        r102.e(r102.f193603z);
    L24:
        if (r102.f193600w == false) goto L43;
        r102.h();
        return;
    L43:
        return;
    L19:
        if (r108 == 7) goto L21;
    L22:
        r102.c(r102.f193603z);
        goto L24
    L26:
        int r109 = CustomizedUISeekBar.a.f193604a[r101.ordinal()];
        if (r109 == 1) goto L36;
        if (r109 == 2) goto L35;
        if (r109 == 3) goto L35;
        if (r109 != 4) goto L51;
        r102.e(r102.f193602y);
        if (r102.f193600w == false) goto L45;
        r102.f();
        return;
    L45:
        return;
    L51:
        return;
    L35:
        r102.c(r102.f193602y);
        return;
    L36:
        r102.setProgressDrawable(r102.D);
        r102.setThumb(r102.E);
        SeekBarAnimateState r110 = r102.f193602y;
        r102.F = r110;
        r102.c(r110);
        if (r102.f193600w == false) goto L48;
        r102.f();
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SeekBarState.State r100, SeekBarState.Action r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
