package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends View {
    public final Paint a;
    public final Bitmap b;
    public final Path c;

    public o(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3);
        this.a = new Paint(1);
        this.b = BitmapFactory.decodeResource(r3.getResources(), 2131231425);
        this.c = new Path();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        this.a.setColor(ColorProtector.parseColor("#FE2C55"));
        this.c.moveTo(0.0f, 0.0f);
        Path r0 = this.c;
        Resources r3 = Resources.getSystem();
        r0.lineTo(MathKt.roundToInt(TypedValue.applyDimension(1, 11, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))), 0.0f);
        Path r1 = this.c;
        Resources r4 = Resources.getSystem();
        r1.lineTo(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())), getHeight());
        this.c.lineTo(0.0f, getHeight());
        this.c.close();
        r7.drawPath(this.c, this.a);
        this.c.reset();
        this.a.reset();
        Bitmap r2 = this.b;
        Resources r5 = Resources.getSystem();
        r7.drawBitmap(r2, TypedValue.applyDimension(1, -4, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())), 0.0f, this.a);
    }
}
