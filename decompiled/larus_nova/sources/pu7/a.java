package pu7;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.vector.style.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530730a = null;

    static {
        f530730a = new a();
    }

    public a() {
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
    public final Path a(float r110, com.github.alexzhirkevich.customqrgenerator.style.c r111) {
        Intrinsics.checkNotNullParameter(r111, "neighbors");
        Path r112 = new Path();
        float r100 = r110 / 5.0f;
        r112.addRect(0.0f, 0.0f, r110, r100, Path.Direction.CW);
        r112.addRect(0.0f, 0.0f, r100, r110, Path.Direction.CW);
        float r101 = r110 - r100;
        r112.addRect(r101, 0.0f, r110, r110, Path.Direction.CW);
        r112.addRect(0.0f, r101, r110, r110, Path.Direction.CW);
        return r112;
    }
}
