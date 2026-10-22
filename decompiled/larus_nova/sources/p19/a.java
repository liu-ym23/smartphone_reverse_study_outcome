package p19;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.vector.style.l;
import com.github.alexzhirkevich.customqrgenerator.vector.style.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements l, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f527329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f527330b;

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
    public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
        Intrinsics.checkNotNullParameter(r101, "neighbors");
        return this.f527329a.a(r100, r101);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f527330b, ((a) r100).f527330b) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f527330b);
    }

    public final String toString() {
        return "Square(scale=" + this.f527330b + ')';
    }

    public a() {
        this(1.0f);
    }

    public a(float r100) {
        this.f527329a = new c(r100);
        this.f527330b = r100;
    }
}
