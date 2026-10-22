package com.bytedance.dux.window.model;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import hm4.b;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements jm4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f205955b = null;

    static {
        jm4.a.f499636a.getClass();
        b r100 = jm4.a.C6460a.f499638b;
        Resources r101 = Resources.getSystem();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        float r103 = r102.widthPixels;
        float r104 = r102.density;
        new hm4.a(r103 / r104, r102.heightPixels / r104);
        MathKt.roundToInt(TypedValue.applyDimension(1, 0.0f, hm4.a.a(Resources.getSystem())));
        MathKt.roundToInt(TypedValue.applyDimension(1, 0.0f, hm4.a.a(Resources.getSystem())));
        f205955b = new LinkedHashSet();
        new CopyOnWriteArrayList();
    }
}
