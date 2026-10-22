package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i0 {
    public ImageView a;
    public TextView b;
    public TextView c;
    public ConstraintLayout d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public final float[] h;
    public final int[] i;

    public final void c() {
        ConstraintLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public i0() {
        this.h = ArraysKt.toFloatArray(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.3f), Float.valueOf(0.7f)});
        this.i = ArraysKt.toIntArray(new Integer[]{Integer.valueOf(ColorProtector.parseColor("#fff6fd")), Integer.valueOf(ColorProtector.parseColor("#ffe9d5")), Integer.valueOf(ColorProtector.parseColor("#f9c19a"))});
    }

    public final void b(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.d = r2;
        this.a = (ImageView) r2.findViewById(2131389617);
        this.b = (TextView) r2.findViewById(2131376903);
        this.c = (TextView) r2.findViewById(2131376906);
        this.e = (TextView) r2.findViewById(2131376905);
        this.f = (TextView) r2.findViewById(2131376904);
        this.g = (ImageView) r2.findViewById(2131376902);
    }

    public static final void a(i0 r10, TextView r11, float r12, float r13) {
        r10.getClass();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        LinearGradient r0 = new LinearGradient(0.0f, 0.0f, r12, r13, r10.i, r10.h, Shader.TileMode.CLAMP);
        r11.getPaint().setShader(r0);
        return;
    L5:
        r11.setTextColor(ColorProtector.parseColor("#F9C19A"));
    }
}
