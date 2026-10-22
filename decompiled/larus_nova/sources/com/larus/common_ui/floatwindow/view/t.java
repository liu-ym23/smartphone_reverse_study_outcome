package com.larus.common_ui.floatwindow.view;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class t implements HorizontalDragFrameLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HorizontalDragFrameLayout f327556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FullScreenFloatWindowHandler f327557b;

    @Override // com.larus.common_ui.floatwindow.view.HorizontalDragFrameLayout.b
    public final void a(float r100) {
        float r101 = this.f327556a.getTranslationX();
        FullScreenFloatWindowHandler r102 = this.f327557b;
        float r103 = RangesKt.coerceAtLeast(r102.f327438t - r102.f327431m, 0.0f);
        float r104 = RangesKt.coerceIn(r101 + r100, 0.0f, r103);
        this.f327556a.setTranslationX(r104);
        float r105 = 1.0f;
        if (r103 <= 0.0f) goto L5;
        r105 = 1.0f - (r104 / r103);
    L5:
        this.f327557b.y(r105, true);
    }

    @Override // com.larus.common_ui.floatwindow.view.HorizontalDragFrameLayout.b
    public final void c(float r100) {
        float r101 = this.f327556a.getTranslationX();
        FullScreenFloatWindowHandler r102 = this.f327557b;
        Integer r103 = r102.f327436r;
        if (r103 == null) goto L5;
        float r104 = r103.intValue();
    L6:
        FullScreenFloatWindowHandler r105 = this.f327557b;
        float r106 = RangesKt.coerceAtLeast(r105.f327438t - r105.f327431m, 0.0f);
        FullScreenFloatWindowHandler r107 = this.f327557b;
        Float r108 = r107.f327437s;
        boolean r109 = true;
        if (r107.f327429k == false) goto L19;
        if (r101 >= r104) goto L14;
        if (r108 != null) goto L12;
    L15:
        if (r109 == false) goto L17;
        this.f327557b.n();
        return;
    L17:
        this.f327557b.m();
        return;
    L12:
        if (r100 < r108.floatValue()) goto L15;
    L14:
        r109 = false;
        goto L15
    L19:
        if (r101 <= (r106 - r104)) goto L24;
        if (r108 != null) goto L22;
    L25:
        if (r109 == false) goto L27;
        this.f327557b.m();
        return;
    L27:
        this.f327557b.n();
        return;
    L22:
        if (r100 > (-r108.floatValue())) goto L25;
    L24:
        r109 = false;
        goto L25
    L5:
        r104 = RangesKt.coerceAtLeast(r102.f327438t - r102.f327431m, 0.0f) / 2.0f;
        goto L6
    }

    public t(HorizontalDragFrameLayout r100, FullScreenFloatWindowHandler r101) {
        this.f327556a = r100;
        this.f327557b = r101;
    }
}
