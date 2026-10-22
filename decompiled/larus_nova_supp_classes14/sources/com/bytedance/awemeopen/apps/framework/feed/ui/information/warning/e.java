package com.bytedance.awemeopen.apps.framework.feed.ui.information.warning;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements com.bytedance.awemeopen.infra.base.image.c {
    public final /* synthetic */ d a;

    public final void onFail() {
        this.a.e();
    }

    public e(d r1) {
        this.a = r1;
    }

    public final void onSuccess(Bitmap r11) {
        Intrinsics.checkNotNullParameter(r11, "result");
        d r0 = this.a;
        AppCompatTextView r1 = r0.e;
        ImageView r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r1 = null;
    L5:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r2;
    L9:
        ImageView r5 = r0.f;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r5 = null;
    L12:
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r11.getWidth() <= r11.getHeight()) goto L18;
        r6.width = MathKt.roundToInt(TypedValue.applyDimension(1, 26, d.d(Resources.getSystem())));
        r6.height = MathKt.roundToInt(TypedValue.applyDimension(1, 16, d.d(Resources.getSystem())));
        if (r4 == null) goto L22;
        r4.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 2, d.d(Resources.getSystem()))));
    L22:
        AppCompatTextView r7 = r0.e;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r7 = null;
    L25:
        r7.setLayoutParams(r4);
        ImageView r8 = r0.f;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r8 = null;
    L28:
        r8.setLayoutParams(r6);
        ImageView r9 = r0.f;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
    L32:
        r3.setImageBitmap(r11);
        return;
    L31:
        r3 = r9;
        goto L32
    L18:
        float r10 = 16;
        r6.width = MathKt.roundToInt(TypedValue.applyDimension(1, r10, d.d(Resources.getSystem())));
        r6.height = MathKt.roundToInt(TypedValue.applyDimension(1, r10, d.d(Resources.getSystem())));
        if (r4 == null) goto L22;
        r4.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, d.d(Resources.getSystem()))));
        goto L22
    L8:
        r4 = null;
        goto L9
    }
}
