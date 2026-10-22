package com.bytedance.dux.panel.header;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import em4.n;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f205381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f205382b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f205381a.removeOnAttachStateChangeListener(this);
        Resources r101 = Resources.getSystem();
        int r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        b r103 = this.f205382b;
        n.c(r103.f205388k, r102, r102, new View[]{r103.f205385h, r103.f205383f});
    }

    public a(View r100, b r101) {
        this.f205381a = r100;
        this.f205382b = r101;
    }
}
