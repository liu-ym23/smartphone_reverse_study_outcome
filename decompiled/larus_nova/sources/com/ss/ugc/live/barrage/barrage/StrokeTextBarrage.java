package com.ss.ugc.live.barrage.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public class StrokeTextBarrage extends TextBarrage {
    public static final /* synthetic */ KProperty[] G = null;
    public final Lazy C;
    public final float D;
    public final int E;
    public final int F;

    static {
        G = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StrokeTextBarrage.class), "strokedTextPaint", "getStrokedTextPaint()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final Bitmap h() {
        return null;
    }

    @Override // com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void k() {
        Lazy r100 = this.C;
        KProperty r101 = G[0];
        r((Paint) r100.getValue());
    }

    @Override // com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void g(Canvas r100) {
        float r101 = 0;
        if (this.D <= r101) goto L9;
        String r102 = this.f458079w;
        RectF r103 = this.f458058f;
        float r104 = r103.left;
        float r105 = this.f458075s;
        if (r105 > r101) goto L8;
        r105 = this.f458065m.f458068b;
    L8:
        float r106 = (r103.bottom - this.f458077u) + this.f458065m.f458069c;
        Lazy r107 = this.C;
        KProperty r108 = G[0];
        r100.drawText(r102, r104 + r105, r106, (Paint) r107.getValue());
    L9:
        super.g(r100);
    }

    public StrokeTextBarrage(String r100, final float r101, int r102, final Typeface r103, float r104, final AbsBarrage.b r105, float r106, int r107, int r108) {
        super(r100, r101, r102, r103, r104, r105);
        this.D = r106;
        this.E = r107;
        this.F = r108;
        this.C = LazyKt.lazy(LazyThreadSafetyMode.NONE, new StrokeTextBarrage$strokedTextPaint$2(this, r101, r103, r105));
    }
}
