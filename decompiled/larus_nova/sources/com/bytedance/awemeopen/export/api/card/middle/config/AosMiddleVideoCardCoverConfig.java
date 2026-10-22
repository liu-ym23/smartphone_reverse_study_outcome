package com.bytedance.awemeopen.export.api.card.middle.config;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.awemeopen.export.api.card.base.config.AosBaseVideoCardCoverConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/middle/config/AosMiddleVideoCardCoverConfig;", "Lcom/bytedance/awemeopen/export/api/card/base/config/AosBaseVideoCardCoverConfig;", "orientation", "", "(I)V", "marginBottom", "getMarginBottom", "()I", "setMarginBottom", "getOrientation", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AosMiddleVideoCardCoverConfig extends AosBaseVideoCardCoverConfig {
    private int marginBottom;
    private final int orientation;

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public AosMiddleVideoCardCoverConfig(int r100) {
        this.orientation = r100;
        if (r100 != 1) goto L5;
        setWidth(-1);
        setHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 193, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardCoverConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
    L6:
        this.marginBottom = MathKt.roundToInt(TypedValue.applyDimension(1, 8, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardCoverConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        return;
    L5:
        setWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 225, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardCoverConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        setHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 300, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardCoverConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        goto L6
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardCoverConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }
}
