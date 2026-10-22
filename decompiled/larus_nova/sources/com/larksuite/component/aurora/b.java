package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends AuroraDelegate {
    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void f() {
        this.f282935a.invalidate();
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final Paint a() {
        Paint r100 = super.a();
        r100.setColor(0);
        return r100;
    }

    public b(AuroraView r100) {
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
        if (this.f282935a.getBlurRadius$aurora_release() != 0.0f) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        c().setColor(r104);
    L9:
        c().setShadowLayer(this.f282935a.getBlurRadius$aurora_release(), 0.0f, 0.0f, r104);
        d().set(r101.f282965c);
        r102.invoke(d());
        r100.drawOval(d(), c());
        return;
    L8:
        c().setColor(0);
        goto L9
    L5:
        r105 = false;
        goto L6
    }
}
