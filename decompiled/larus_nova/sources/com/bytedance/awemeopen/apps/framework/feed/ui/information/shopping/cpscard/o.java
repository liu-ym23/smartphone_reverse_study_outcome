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
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f196510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f196511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f196512c;

    public o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f196510a = new Paint(1);
        this.f196511b = BitmapFactory.decodeResource(r100.getResources(), R.drawable.aos_cps_shopping_card_lightening);
        this.f196512c = new Path();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f196510a.setColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        this.f196512c.moveTo(0.0f, 0.0f);
        Path r101 = this.f196512c;
        Resources r102 = Resources.getSystem();
        r101.lineTo(MathKt.roundToInt(TypedValue.applyDimension(1, 11, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))), 0.0f);
        Path r103 = this.f196512c;
        Resources r104 = Resources.getSystem();
        r103.lineTo(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())), getHeight());
        this.f196512c.lineTo(0.0f, getHeight());
        this.f196512c.close();
        r100.drawPath(this.f196512c, this.f196510a);
        this.f196512c.reset();
        this.f196510a.reset();
        Bitmap r105 = this.f196511b;
        Resources r106 = Resources.getSystem();
        r100.drawBitmap(r105, TypedValue.applyDimension(1, -4, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())), 0.0f, this.f196510a);
    }
}
