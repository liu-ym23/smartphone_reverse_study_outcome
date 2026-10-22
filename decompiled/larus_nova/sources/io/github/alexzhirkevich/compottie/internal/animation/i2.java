package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.animation.core.Easing;

/* JADX INFO: loaded from: classes41.dex */
public final class i2 implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f491060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f491061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f491062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f491063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f491064e;

    @Override // androidx.compose.animation.core.Easing
    public final float transform(float r110) {
        if (this.f491064e == false) goto L5;
        return r110;
    L5:
        float r100 = 0.0f;
        if (r110 <= 0.0f) goto L17;
        float r101 = 1.0f;
        if (r110 >= 1.0f) goto L17;
    L9:
        float r102 = (r100 + r101) / 2;
        float r103 = 3;
        float r104 = 1 - r102;
        float r105 = (r102 * r102) * r102;
        float r106 = (((((this.f491060a * r103) * r104) * r104) * r102) + ((((this.f491062c * r103) * r104) * r102) * r102)) + r105;
        if (Math.abs(r110 - r106) < 1.0E-4f) goto L12;
        if (r106 < r110) goto L15;
        r101 = r102;
        goto L9
    L15:
        r100 = r102;
        goto L9
    L12:
        return (((((this.f491061b * r103) * r104) * r104) * r102) + ((((r103 * this.f491063d) * r104) * r102) * r102)) + r105;
    L17:
        return r110;
    }

    public i2(float r100, float r101, float r102, float r103) {
        this.f491060a = r100;
        this.f491061b = r101;
        this.f491062c = r102;
        this.f491063d = r103;
        if (Math.abs(r100 - r101) < 1.0E-4f) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.f491064e = r104;
        return;
    L5:
        if (Math.abs(r102 - r103) >= 1.0E-4f) goto L7;
        r104 = true;
        goto L8
    }
}
