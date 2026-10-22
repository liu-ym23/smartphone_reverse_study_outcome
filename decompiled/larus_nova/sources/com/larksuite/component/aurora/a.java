package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends AuroraDelegate {
    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void f() {
        this.f282935a.invalidate();
    }

    public a(AuroraView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void b(Canvas r110, AuroraView.a r210, Function1<? super RectF, Unit> r211, Function1<? super Integer, Integer> r212) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r210, "blob");
        Intrinsics.checkNotNullParameter(r211, "boundModifier");
        Intrinsics.checkNotNullParameter(r212, "colorModifier");
        d().set(r210.f282965c);
        r211.invoke(d());
        int r100 = r212.invoke(Integer.valueOf(r210.a())).intValue();
        float r101 = d().width() + this.f282935a.getBlurRadius$aurora_release();
        float r102 = d().height() + this.f282935a.getBlurRadius$aurora_release();
        float r103 = d().centerX();
        float r104 = d().centerY();
        float r105 = Math.min(r101, r102);
        int r111 = r110.save();
        r110.scale(r101 / r105, r102 / r105, r103, r104);
        float r106 = (r105 - this.f282935a.getBlurRadius$aurora_release()) / r105;
        c().setShader(new RadialGradient(r103, r104, r105 / 2.0f, new int[]{r100, UDColorUtils.getAlphaColor(r100, (Color.alpha(r100) / 255.0f) * Math.max(0.45f, r106)), UDColorUtils.getAlphaColor(r100, (Color.alpha(r100) / 255.0f) * Math.min(0.45f, r106)), UDColorUtils.getAlphaColor(r100, (Color.alpha(r100) / 255.0f) * 0.0f)}, new float[]{0.0f, Math.min(0.45f, r106), Math.max(0.45f, r106), 1.0f}, Shader.TileMode.CLAMP));
        float r107 = r105 / 2;
        r110.drawOval(r103 - r107, r104 - r107, r103 + r107, r104 + r107, c());
        r110.restoreToCount(r111);
    }
}
