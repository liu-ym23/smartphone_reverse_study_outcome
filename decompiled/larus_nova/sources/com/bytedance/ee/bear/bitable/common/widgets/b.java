package com.bytedance.ee.bear.bitable.common.widgets;

import android.content.Context;
import android.graphics.Paint;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final MaterialShapeDrawable a(Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ShapeAppearanceModel.Builder r103 = new ShapeAppearanceModel.Builder().setTopLeftCorner(new RoundedCornerTreatment());
        if (r102 == false) goto L5;
        r103.setAllCornerSizes(r101);
    L6:
        MaterialShapeDrawable r104 = new MaterialShapeDrawable(r103.build());
        r104.setStrokeColor(UDColorUtils.getColorStateList(r100, R.color.line_divider_default));
        r104.setStrokeWidth(1.0f);
        r104.setTint(UDColorUtils.getColor(r100, R.color.transparent));
        r104.setPaintStyle(Paint.Style.FILL);
        r104.setShadowCompatibilityMode(2);
        r104.initializeElevationOverlay(r100);
        r104.setShadowRadius(n.c(16.0f));
        r104.setShadowColor(ColorProtector.parseColor("#D2D2D2"));
        return r104;
    L5:
        r103.setTopLeftCornerSize(r101);
        goto L6
    }
}
