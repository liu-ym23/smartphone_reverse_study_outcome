package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f274271a = null;

    static {
        f274271a = new b();
    }

    public b() {
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
    public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
        Intrinsics.checkNotNullParameter(r101, "neighbors");
        Path r102 = new Path();
        r102.addRect(0.0f, 0.0f, r100, r100, Path.Direction.CW);
        return r102;
    }
}
