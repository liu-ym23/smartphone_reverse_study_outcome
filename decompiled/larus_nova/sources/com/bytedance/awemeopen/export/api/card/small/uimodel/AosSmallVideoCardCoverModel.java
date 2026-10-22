package com.bytedance.awemeopen.export.api.card.small.uimodel;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import r44.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/small/uimodel/AosSmallVideoCardCoverModel;", "Lr44/a;", "<init>", "()V", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class AosSmallVideoCardCoverModel extends a {
    public AosSmallVideoCardCoverModel() {
        setBorderWidth(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_small_uimodel_AosSmallVideoCardCoverModel_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        Intrinsics.checkNotNullParameter("#1E161823", "<this>");
        setBorderColor(ColorProtector.parseColor("#1E161823"));
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_small_uimodel_AosSmallVideoCardCoverModel_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
