package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/NumberScrollView;", "Landroid/widget/ScrollView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getTextColor", "()I", "setTextColor", "(I)V", "textColor", "Landroid/widget/LinearLayout;", "b", "Landroid/widget/LinearLayout;", "getLinearContainer", "()Landroid/widget/LinearLayout;", "setLinearContainer", "(Landroid/widget/LinearLayout;)V", "linearContainer", "Landroid/animation/ValueAnimator;", "c", "Landroid/animation/ValueAnimator;", "getMValueAnimator", "()Landroid/animation/ValueAnimator;", "setMValueAnimator", "(Landroid/animation/ValueAnimator;)V", "mValueAnimator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NumberScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f450206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f450207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f450208c;

    public final LinearLayout getLinearContainer() {
        return this.f450207b;
    }

    public final ValueAnimator getMValueAnimator() {
        return this.f450208c;
    }

    public final int getTextColor() {
        return this.f450206a;
    }

    public NumberScrollView(Context r100) {
        this(r100, null);
    }

    public final void setLinearContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450207b = r100;
    }

    public final void setMValueAnimator(ValueAnimator r100) {
        this.f450208c = r100;
    }

    public final void setTextColor(int r100) {
        this.f450206a = r100;
    }

    public NumberScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f450206a = -1;
        this.f450207b = new LinearLayout(r100);
    }
}
