package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f274270a;

    public a() {
        this.f274270a = 0.8f;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
    public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
        Intrinsics.checkNotNullParameter(r101, "neighbors");
        Path r102 = new Path();
        float r103 = r100 / 2.0f;
        r102.addCircle(r103, r103, (r100 / 2) * RangesKt.coerceIn(this.f274270a, 0.0f, 1.0f), Path.Direction.CW);
        return r102;
    }
}
