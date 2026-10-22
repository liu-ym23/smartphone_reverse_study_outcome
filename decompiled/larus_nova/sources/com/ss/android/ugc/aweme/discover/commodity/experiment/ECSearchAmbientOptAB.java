package com.ss.android.ugc.aweme.discover.commodity.experiment;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.discover.commodity.settings.ECSearchUseNewDesignStyle;
import com.ss.android.ugc.aweme.settings.newdesgin.SearchNewDesignEraAB;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/experiment/ECSearchAmbientOptAB;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchAmbientOptAB {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchAmbientOptAB f450036a = null;

    private ECSearchAmbientOptAB() {
    }

    static {
        f450036a = new ECSearchAmbientOptAB();
        Resources r100 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    public static float a() {
        SearchNewDesignEraAB.f454115a.getClass();
        Resources r100 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, 100, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    public static Drawable c() {
        GradientDrawable r100 = new GradientDrawable();
        f450036a.getClass();
        r100.setCornerRadius(a());
        ECSearchUseNewDesignStyle.f450354a.getClass();     // Catch: IllegalArgumentException -> L9
        if (ECSearchUseNewDesignStyle.a() == false) goto L6;
        String r101 = CustomHeaderConfig.COLOR_LIGHT;
    L7:
        r100.setColor(Color.parseColor(r101));     // Catch: IllegalArgumentException -> L9
        goto L8
    L6:
        r101 = "#E5FFFFFF";
    L8:
        return r100;
    }

    public static Drawable b(int r100) {
        if (r100 != 1) goto L7;
        GradientDrawable r101 = new GradientDrawable();
        f450036a.getClass();
        r101.setCornerRadius(a());
        r101.setColor(Color.parseColor("#E5FFFFFF"));     // Catch: IllegalArgumentException -> L9
        return r101;
    L13:
        return r101;
    L7:
        GradientDrawable r102 = new GradientDrawable();
        f450036a.getClass();
        r102.setCornerRadius(a());
        r102.setColor(ColorProtector.parseColor("#3DFFFFFF"));
        return r102;
    }
}
