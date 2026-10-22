package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class AuroraDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuroraView f282935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f282936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f282937c;

    public abstract void b(Canvas r100, AuroraView.a r101, Function1<? super RectF, Unit> r102, Function1<? super Integer, Integer> r103);

    public void e() {
    }

    public abstract void f();

    public Paint a() {
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        return r100;
    }

    public final Paint c() {
        return (Paint) this.f282936b.getValue();
    }

    public final RectF d() {
        return (RectF) this.f282937c.getValue();
    }

    public AuroraDelegate(AuroraView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f282935a = r100;
        this.f282936b = LazyKt.lazy(new AuroraDelegate$paint$2(this));
        this.f282937c = LazyKt.lazy(AuroraDelegate$rect$2.INSTANCE);
    }
}
