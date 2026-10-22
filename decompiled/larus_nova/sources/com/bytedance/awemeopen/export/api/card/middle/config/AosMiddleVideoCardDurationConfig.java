package com.bytedance.awemeopen.export.api.card.middle.config;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.awemeopen.export.api.card.base.config.AosBaseVideoCardTextConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/middle/config/AosMiddleVideoCardDurationConfig;", "Lcom/bytedance/awemeopen/export/api/card/base/config/AosBaseVideoCardTextConfig;", "()V", "marginRight", "", "getMarginRight", "()I", "setMarginRight", "(I)V", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AosMiddleVideoCardDurationConfig extends AosBaseVideoCardTextConfig {
    private int marginRight;

    public AosMiddleVideoCardDurationConfig() {
        setTextSize(12);
        setTextColor(-1);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setIncludeFontPadding(false);
        float r100 = 6;
        setMarginBottom(MathKt.roundToInt(TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardDurationConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        this.marginRight = MathKt.roundToInt(TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardDurationConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_config_AosMiddleVideoCardDurationConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setMarginRight(int r100) {
        this.marginRight = r100;
    }
}
