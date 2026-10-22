package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class o1<T> implements h2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f491105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f491106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f491107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f491108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Easing f491109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Easing f491110f;

    @Override // io.github.alexzhirkevich.compottie.internal.animation.h2
    public final T a() {
        if (this.f491108d == false) goto L6;
        return this.f491105a;
    L6:
        return this.f491106b;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.h2
    public final T getEnd() {
        return this.f491106b;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.h2
    public final T getStart() {
        return this.f491105a;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.h2
    public final float getTime() {
        return this.f491107c;
    }

    public o1(T r100, T r110, float r111, boolean r112, y1 r113, y1 r114) {
        this.f491105a = r100;
        this.f491106b = r110;
        this.f491107c = r111;
        this.f491108d = r112;
        if (r112 == true) goto L17;
        if (r113 == null) goto L17;
        if (r114 == null) goto L17;
        if ((!r113.f491195a.isEmpty()) == true) goto L10;
    L16:
        Easing r101 = EasingKt.getLinearEasing();
    L18:
        this.f491109e = r101;
        if (r112 == true) goto L33;
        if (r113 == null) goto L33;
        if (r114 == null) goto L33;
        if (r113.f491195a.size() >= 2) goto L26;
    L34:
        this.f491110f = r101;
        return;
    L26:
        if (r113.f491196b.size() < 2) goto L34;
        if (r114.f491195a.size() < 2) goto L34;
        if (r114.f491196b.size() == 2) goto L34;
        r101 = new i2(RangesKt.coerceIn(((Number) ListProtector.get(r114.f491195a, 1)).floatValue(), -1.0f, 1.0f), RangesKt.coerceIn(((Number) ListProtector.get(r114.f491196b, 1)).floatValue(), -100.0f, 100.0f), RangesKt.coerceIn(((Number) ListProtector.get(r113.f491195a, 1)).floatValue(), -1.0f, 1.0f), RangesKt.coerceIn(((Number) ListProtector.get(r113.f491196b, 1)).floatValue(), -100.0f, 100.0f));
    L33:
        r101 = EasingKt.getLinearEasing();
        goto L34
    L10:
        if ((!r113.f491196b.isEmpty()) == false) goto L16;
        if ((!r114.f491195a.isEmpty()) == false) goto L16;
        if ((!r114.f491196b.isEmpty()) == false) goto L16;
        r101 = new i2(RangesKt.coerceIn(((Number) ListProtector.get(r114.f491195a, 0)).floatValue(), -1.0f, 1.0f), RangesKt.coerceIn(((Number) ListProtector.get(r114.f491196b, 0)).floatValue(), -100.0f, 100.0f), RangesKt.coerceIn(((Number) ListProtector.get(r113.f491195a, 0)).floatValue(), -1.0f, 1.0f), RangesKt.coerceIn(((Number) ListProtector.get(r113.f491196b, 0)).floatValue(), -100.0f, 100.0f));
    L17:
        r101 = EasingKt.getLinearEasing();
        goto L18
    }
}
