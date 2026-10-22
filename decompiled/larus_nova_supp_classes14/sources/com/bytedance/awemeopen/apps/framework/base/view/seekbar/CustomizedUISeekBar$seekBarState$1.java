package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.animation.Animator;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class CustomizedUISeekBar$seekBarState$1 extends FunctionReferenceImpl implements Function2<SeekBarState.State, SeekBarState.Action, Unit> {
    public CustomizedUISeekBar$seekBarState$1(Object r8) {
        super(2, r8, CustomizedUISeekBar.class, "newState", "newState(Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$Action;)V", 0);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.SeekBar, com.bytedance.awemeopen.apps.framework.base.view.seekbar.CustomizedUISeekBar, com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar] */
    public final void invoke(SeekBarState.State r7, SeekBarState.Action r8) {
        Intrinsics.checkNotNullParameter(r7, "p0");
        Intrinsics.checkNotNullParameter(r8, "p1");
        ?? r0 = (CustomizedUISeekBar) ((CallableReference) this).receiver;
        Animator r1 = r0.G;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        int r9 = CustomizedUISeekBar.a.b[r7.ordinal()];
        if (r9 != 1) goto L8;
        r0.setProgressDrawable(r0.H);
        Resources r10 = Resources.getSystem();
        int r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
        Resources r2 = Resources.getSystem();
        r0.setPadding(0, r11, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
        r0.setThumb(r0.I);
        return;
    L8:
        if (r9 == 2) goto L26;
        if (r9 == 3) goto L15;
        if (r9 != 4) goto L50;
        r0.e(r0.A);
        if (r0.w == false) goto L41;
        r0.h();
        return;
    L41:
        return;
    L50:
        return;
    L15:
        int r12 = CustomizedUISeekBar.a.a[r8.ordinal()];
        if (r12 == 5) goto L22;
        if (r12 != 6) goto L19;
    L21:
        r0.e(r0.z);
    L24:
        if (r0.w == false) goto L43;
        r0.h();
        return;
    L43:
        return;
    L19:
        if (r12 == 7) goto L21;
    L22:
        r0.c(r0.z);
        goto L24
    L26:
        int r13 = CustomizedUISeekBar.a.a[r8.ordinal()];
        if (r13 == 1) goto L36;
        if (r13 == 2) goto L35;
        if (r13 == 3) goto L35;
        if (r13 != 4) goto L51;
        r0.e(r0.y);
        if (r0.w == false) goto L45;
        r0.f();
        return;
    L45:
        return;
    L51:
        return;
    L35:
        r0.c(r0.y);
        return;
    L36:
        r0.setProgressDrawable(r0.D);
        r0.setThumb(r0.E);
        SeekBarAnimateState r14 = r0.y;
        r0.F = r14;
        r0.c(r14);
        if (r0.w == false) goto L48;
        r0.f();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((SeekBarState.State) r1, (SeekBarState.Action) r2);
        return Unit.INSTANCE;
    }
}
