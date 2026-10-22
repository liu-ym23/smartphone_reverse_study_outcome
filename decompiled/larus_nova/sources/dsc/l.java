package dsc;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l<S extends DrawStyle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f469928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f469929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f469930c;

    /* JADX WARN: Multi-variable type inference failed */
    public l(DrawStyle r100) {
        long r101 = Color.Companion.m4862getTransparent0d7_KjU();
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f469928a = r100;
        this.f469929b = r101;
        this.f469930c = 1.0f;
    }
}
