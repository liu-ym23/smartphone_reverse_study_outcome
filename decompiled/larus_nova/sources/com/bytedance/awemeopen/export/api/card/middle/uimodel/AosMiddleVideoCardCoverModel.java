package com.bytedance.awemeopen.export.api.card.middle.uimodel;

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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/middle/uimodel/AosMiddleVideoCardCoverModel;", "Lr44/a;", "", "roundedCornerRadius", "I", "getRoundedCornerRadius", "()I", "setRoundedCornerRadius", "(I)V", "<init>", "()V", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class AosMiddleVideoCardCoverModel extends a {
    private int roundedCornerRadius;

    public final int getRoundedCornerRadius() {
        int r100 = this.roundedCornerRadius;
        if (r100 >= 0) goto L6;
        return 0;
    L6:
        return r100;
    }

    public AosMiddleVideoCardCoverModel() {
        this.roundedCornerRadius = MathKt.roundToInt(TypedValue.applyDimension(1, 4, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_uimodel_AosMiddleVideoCardCoverModel_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        setBorderWidth(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_uimodel_AosMiddleVideoCardCoverModel_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        Intrinsics.checkNotNullParameter("#1E161823", "<this>");
        setBorderColor(ColorProtector.parseColor("#1E161823"));
        setOverlayColor(-1);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_card_middle_uimodel_AosMiddleVideoCardCoverModel_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setRoundedCornerRadius(int r100) {
        this.roundedCornerRadius = r100;
    }
}
