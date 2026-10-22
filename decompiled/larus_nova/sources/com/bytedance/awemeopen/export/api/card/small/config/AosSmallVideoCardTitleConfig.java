package com.bytedance.awemeopen.export.api.card.small.config;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.awemeopen.export.api.card.base.config.AosBaseVideoCardTextConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/small/config/AosSmallVideoCardTitleConfig;", "Lcom/bytedance/awemeopen/export/api/card/base/config/AosBaseVideoCardTextConfig;", "()V", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AosSmallVideoCardTitleConfig extends AosBaseVideoCardTextConfig {
    public AosSmallVideoCardTitleConfig() {
        setTextSize(17);
        setTextColor(-1);
        setMaxLines(2);
        setEllipsize(TextUtils.TruncateAt.END);
        setMarginBottom(MathKt.roundToInt(TypedValue.applyDimension(1, 6, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_small_config_AosSmallVideoCardTitleConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_small_config_AosSmallVideoCardTitleConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
