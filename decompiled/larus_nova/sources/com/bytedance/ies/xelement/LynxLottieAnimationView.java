package com.bytedance.ies.xelement;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/xelement/LynxLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMAutoPlay", "()Z", "setMAutoPlay", "(Z)V", "mAutoPlay", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-lottie_release"}, k = 1, mv = {1, 6, 0})
public final class LynxLottieAnimationView extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249608b;

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f249607a == true) goto L5;
        return;
    L5:
        if (this.f249608b == true) goto L7;
        return;
    L7:
        if (isAnimating() == true) goto L12;
        playAnimation();
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        if (isAnimating() == false) goto L5;
        this.f249608b = true;
    L5:
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    public final boolean getMAutoPlay() {
        return this.f249607a;
    }

    public LynxLottieAnimationView(Context r100) {
        new LinkedHashMap();
        super(r100);
    }

    public final void setMAutoPlay(boolean r100) {
        this.f249607a = r100;
    }
}
