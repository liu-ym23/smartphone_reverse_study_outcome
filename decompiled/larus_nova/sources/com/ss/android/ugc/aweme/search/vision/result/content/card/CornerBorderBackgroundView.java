package com.ss.android.ugc.aweme.search.vision.result.content.card;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.crop.util.PaintUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/content/card/CornerBorderBackgroundView;", "Landroid/view/View;", "", "color", "", "setColor", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isViewSelected", "()Z", "setViewSelected", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CornerBorderBackgroundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f453680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f453681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f453682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f453683d;

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f453680a == false) goto L6;
        if (r100 == null) goto L8;
        int r101 = r100.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.f453682c.set(getLeft(), getTop(), getRight(), getBottom());
        r100.drawColor(PaintUtil.f453558e);
        RectF r102 = this.f453682c;
        float r103 = this.f453683d;
        r100.drawRoundRect(r102, r103, r103, this.f453681b);
        r100.restoreToCount(r101);
        return;
    L8:
        return;
    L6:
        r100.drawColor(PaintUtil.f453558e);
    }

    public final void setColor(int r100) {
        this.f453681b.setColor(r100);
    }

    public final void setViewSelected(boolean r100) {
        this.f453680a = r100;
    }

    public CornerBorderBackgroundView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f453680a = true;
        int r102 = PaintUtil.f453554a;
        Paint r103 = new Paint(1);
        this.f453681b = r103;
        this.f453682c = new RectF();
        this.f453683d = UIUtils.dip2Px(r100, 8.0f);
        float r104 = UIUtils.dip2Px(r100, 4.0f);
        r103.setColor(r102);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(r104);
    }
}
