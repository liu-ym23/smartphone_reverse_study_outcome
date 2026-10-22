package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmLottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initView", "", "onVisibilityAggregated", "isVisible", "", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "onWindowVisibilityChanged", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmLottieView extends LottieAnimationView {
    public MmLottieView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmLottieView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (r100 == false) goto L5;
        playAnimation();
        return;
    L5:
        pauseAnimation();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (Build.VERSION.SDK_INT >= 24) goto L10;
        if (r100 == 0) goto L6;
    L8:
        pauseAnimation();
        return;
    L6:
        if (getVisibility() != 0) goto L8;
        playAnimation();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        if (r100 != 0) goto L6;
        playAnimation();
        return;
    L6:
        pauseAnimation();
        return;
    }

    public MmLottieView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setClickable(false);
        setEnabled(false);
        setRepeatCount(-1);
    }

    public /* synthetic */ MmLottieView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
