package com.bytedance.ies.xelement.bytedlottie;

import android.content.Context;
import android.graphics.Canvas;
import com.airbnb.lottie.LottieAnimationView;
import com.lynx.tasm.base.LLog;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/xelement/bytedlottie/LynxBytedLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMAutoPlay", "()Z", "setMAutoPlay", "(Z)V", "mAutoPlay", "b", "getDestroyed", "setDestroyed", "destroyed", "", "c", "Ljava/lang/String;", "getSrcUrl", "()Ljava/lang/String;", "setSrcUrl", "(Ljava/lang/String;)V", "srcUrl", "d", "getIgnoreAttachStatus", "setIgnoreAttachStatus", "ignoreAttachStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-bdlottie_release"}, k = 1, mv = {1, 6, 0})
public final class LynxBytedLottieAnimationView extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f249814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249816e;

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        if (this.f249815d == false) goto L5;
        return;
    L5:
        super.onAttachedToWindow();
        if (this.f249812a == true) goto L8;
        return;
    L8:
        if (this.f249816e == true) goto L10;
        return;
    L10:
        if (isAnimating() == true) goto L15;
        playAnimation();
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f249815d == false) goto L6;
        return;
    L6:
        if (isAnimating() == false) goto L8;
        this.f249816e = true;
    L8:
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    public final boolean getDestroyed() {
        return this.f249813b;
    }

    public final boolean getIgnoreAttachStatus() {
        return this.f249815d;
    }

    public final boolean getMAutoPlay() {
        return this.f249812a;
    }

    public final String getSrcUrl() {
        return this.f249814c;
    }

    public LynxBytedLottieAnimationView(Context r100) {
        new LinkedHashMap();
        super(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f249813b == false) goto L6;
        LLog.d("byted-lottie", "draw lottie-view after destroyed with src " + this.f249814c);
        return;
    L6:
        super.onDraw(r100);
    }

    public final void setDestroyed(boolean r100) {
        this.f249813b = r100;
    }

    public final void setIgnoreAttachStatus(boolean r100) {
        this.f249815d = r100;
    }

    public final void setMAutoPlay(boolean r100) {
        this.f249812a = r100;
    }

    public final void setSrcUrl(String r100) {
        this.f249814c = r100;
    }
}
