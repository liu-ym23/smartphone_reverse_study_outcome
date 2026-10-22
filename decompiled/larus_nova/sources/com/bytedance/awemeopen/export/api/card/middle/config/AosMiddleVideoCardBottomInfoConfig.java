package com.bytedance.awemeopen.export.api.card.middle.config;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/middle/config/AosMiddleVideoCardBottomInfoConfig;", "", "()V", "itemSpanMargin", "", "getItemSpanMargin", "()I", "setItemSpanMargin", "(I)V", "marginBottom", "getMarginBottom", "setMarginBottom", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AosMiddleVideoCardBottomInfoConfig {
    private int itemSpanMargin;
    private int marginBottom;
    private int textColor;
    private int textSize;

    public AosMiddleVideoCardBottomInfoConfig() {
        this.textSize = 12;
        Intrinsics.checkNotNullParameter("#59161823", "<this>");
        this.textColor = ColorProtector.parseColor("#59161823");
        float r100 = 8;
        this.itemSpanMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardBottomInfoConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.marginBottom = MathKt.roundToInt(TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardBottomInfoConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    }

    public final int getItemSpanMargin() {
        return this.itemSpanMargin;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardBottomInfoConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setItemSpanMargin(int r100) {
        this.itemSpanMargin = r100;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setTextColor(int r100) {
        this.textColor = r100;
    }

    public final void setTextSize(int r100) {
        this.textSize = r100;
    }
}
