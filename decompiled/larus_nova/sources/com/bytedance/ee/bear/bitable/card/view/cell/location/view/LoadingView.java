package com.bytedance.ee.bear.bitable.card.view.cell.location.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import cu5.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/location/view/LoadingView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawable", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "init", "", "start", "stop", "onVisibilityAggregated", "isVisible", "", "onDetachedFromWindow", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CircularProgressDrawable f207917a;

    public final void stop() {
        CircularProgressDrawable r100 = this.f207917a;
        CircularProgressDrawable r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
        r100 = null;
    L6:
        if (r100.isRunning() == false) goto L13;
        CircularProgressDrawable r102 = this.f207917a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
    L11:
        r101.stop();
        return;
    L10:
        r101 = r102;
        goto L11
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public LoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        init(null);
    }

    public final void init(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.centerRadius, R.attr.loadingColor, R.attr.strokeWidth});
        float r102 = r101.getDimension(0, c.a(5.7f));
        float r103 = r101.getDimension(2, c.a(1.9f));
        int r104 = r101.getColor(1, UDColorUtils.getColor(getContext(), R.color.primary_fill_default));
        r101.recycle();
        CircularProgressDrawable r105 = new CircularProgressDrawable(getContext());
        this.f207917a = r105;
        r105.setColorSchemeColors(new int[]{r104});
        CircularProgressDrawable r106 = this.f207917a;
        CircularProgressDrawable r107 = null;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
        r106 = null;
    L5:
        r106.setStrokeCap(Paint.Cap.ROUND);
        CircularProgressDrawable r108 = this.f207917a;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
        r108 = null;
    L8:
        r108.setCenterRadius(r102);
        CircularProgressDrawable r109 = this.f207917a;
        if (r109 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
        r109 = null;
    L11:
        r109.setStrokeWidth(r103);
        CircularProgressDrawable r110 = this.f207917a;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
    L15:
        setImageDrawable(r107);
        return;
    L14:
        r107 = r110;
        goto L15
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (r100 == false) goto L15;
        CircularProgressDrawable r101 = this.f207917a;
        CircularProgressDrawable r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
        r101 = null;
    L8:
        if (r101.isRunning() == true) goto L18;
        CircularProgressDrawable r103 = this.f207917a;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("drawable");
    L14:
        r102.start();
        return;
    L13:
        r102 = r103;
        goto L14
    L18:
        return;
    L15:
        stop();
    }

    public LoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        init(r101);
    }

    public LoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        init(r101);
    }
}
