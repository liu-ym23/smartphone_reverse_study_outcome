package com.bytedance.awemeopen.apps.framework.feed.ui.information.warning;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements com.bytedance.awemeopen.infra.base.image.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f196543a;

    @Override // com.bytedance.awemeopen.infra.base.image.c
    public final void onFail() {
        this.f196543a.e();
    }

    public e(d r100) {
        this.f196543a = r100;
    }

    @Override // com.bytedance.awemeopen.infra.base.image.c
    public final void onSuccess(Bitmap r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        d r100 = this.f196543a;
        DmtTextView r101 = r100.f196540e;
        ImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L9:
        ImageView r105 = r100.f196541f;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r105 = null;
    L12:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r110.getWidth() <= r110.getHeight()) goto L18;
        r106.width = MathKt.roundToInt(TypedValue.applyDimension(1, 26, d.d(Resources.getSystem())));
        r106.height = MathKt.roundToInt(TypedValue.applyDimension(1, 16, d.d(Resources.getSystem())));
        if (r104 == null) goto L22;
        r104.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 2, d.d(Resources.getSystem()))));
    L22:
        DmtTextView r107 = r100.f196540e;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r107 = null;
    L25:
        r107.setLayoutParams(r104);
        ImageView r108 = r100.f196541f;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r108 = null;
    L28:
        r108.setLayoutParams(r106);
        ImageView r109 = r100.f196541f;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
    L32:
        r102.setImageBitmap(r110);
        return;
    L31:
        r102 = r109;
        goto L32
    L18:
        float r111 = 16;
        r106.width = MathKt.roundToInt(TypedValue.applyDimension(1, r111, d.d(Resources.getSystem())));
        r106.height = MathKt.roundToInt(TypedValue.applyDimension(1, r111, d.d(Resources.getSystem())));
        if (r104 == null) goto L22;
        r104.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, d.d(Resources.getSystem()))));
        goto L22
    L8:
        r104 = null;
        goto L9
    }
}
