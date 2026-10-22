package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import androidx.compose.ui.util.MathHelpersKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes41.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f490997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Float> f490998b;

    public final float a() {
        return (((float) Math.sqrt((-2) * ((float) Math.log(this.f490997a.nextFloat())))) * ((float) Math.cos(((double) this.f490997a.nextFloat()) * 6.283185307179586d))) + 1;
    }

    public w() {
        this.f490997a = Random.Default;
        this.f490998b = new LinkedHashMap();
    }

    public final float b(int r100) {
        Float r101 = (Float) ((LinkedHashMap) this.f490998b).get(Integer.valueOf(r100));
        if (r101 != null) goto L7;
        float r102 = (this.f490997a.nextFloat() * 2) - 1;
        this.f490998b.put(Integer.valueOf(r100), Float.valueOf(r102));
        return r102;
    L7:
        return r101.floatValue();
    }

    public final float c(float r100) {
        int r101 = (int) r100;
        return MathHelpersKt.lerp(b(r101), b(r101 + 1), r100 - r101);
    }
}
