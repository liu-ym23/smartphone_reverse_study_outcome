package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends AuroraDelegate {
    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void e() {
        if (this.f282935a.getBlurRadius$aurora_release() != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        this.f282935a.setRenderEffect(null);
        return;
    L8:
        AuroraView r101 = this.f282935a;
        r101.setRenderEffect(RenderEffect.createBlurEffect(r101.getBlurRadius$aurora_release(), this.f282935a.getBlurRadius$aurora_release(), Shader.TileMode.CLAMP));
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void f() {
        e();
    }

    public c(AuroraView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void b(Canvas r100, AuroraView.a r101, Function1<? super RectF, Unit> r102, Function1<? super Integer, Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "blob");
        Intrinsics.checkNotNullParameter(r102, "boundModifier");
        Intrinsics.checkNotNullParameter(r103, "colorModifier");
        int r104 = r103.invoke(Integer.valueOf(r101.a())).intValue();
        c().setColor(r104);
        d().set(r101.f282965c);
        r102.invoke(d());
        r100.drawOval(d(), c());
    }
}
