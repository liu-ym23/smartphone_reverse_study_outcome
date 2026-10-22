package com.bytedance.ee.bear.bitable;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f211117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f211118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f211119c;

    public final void a(TextPaint r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        r100.setTextSize(TypedValue.applyDimension(2, this.f211117a, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        r100.setColor(this.f211118b);
        if (this.f211119c < 500) goto L5;
        boolean r103 = true;
    L6:
        r100.setFakeBoldText(r103);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        a(r100);
    }

    public e(int r100, int r101, int r102) {
        this.f211117a = r100;
        this.f211118b = r101;
        this.f211119c = r102;
    }
}
