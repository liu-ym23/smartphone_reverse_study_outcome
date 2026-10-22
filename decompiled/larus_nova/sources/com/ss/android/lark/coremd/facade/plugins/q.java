package com.ss.android.lark.coremd.facade.plugins;

import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class q extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f419794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f419795b;

    public q() {
        this.f419794a = true;
        this.f419795b = 320;
    }

    public final void a(TextPaint r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f419794a == false) goto L11;
        r100.setFakeBoldText(true);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        r100.setTypeface(Typeface.create(Typeface.DEFAULT, this.f419795b, false));
        return;
    L9:
        r100.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        a(r100);
    }
}
