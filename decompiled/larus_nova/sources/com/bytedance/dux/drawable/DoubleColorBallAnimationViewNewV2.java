package com.bytedance.dux.drawable;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.dux.drawable.doubleballV2.DoubleV2Scene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/dux/drawable/DoubleColorBallAnimationViewNewV2;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/bytedance/dux/drawable/f;", "", "size", "", "setProgressBarInfo", "", "progress", "setProgress", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "scene", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DoubleColorBallAnimationViewNewV2 extends LottieAnimationView implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f204990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoubleV2Scene f204991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f204992c;

    public DoubleColorBallAnimationViewNewV2(Context r100) {
        this(r100, null, 14);
    }

    public DoubleColorBallAnimationViewNewV2(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this(r100, r101, 12);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, com.bytedance.dux.drawable.f
    public void setProgress(float r100) {
    }

    @Override // com.bytedance.dux.drawable.f
    public void setProgressBarInfo(int r100) {
    }

    @Override // com.bytedance.dux.drawable.f
    public final void b() {
        cancelAnimation();     // Catch: Exception -> L5
        this.f204992c = false;     // Catch: Exception -> L5
        StringBuilder r100 = new StringBuilder("[scene = ");     // Catch: Exception -> L5
        r100.append(this.f204991b);     // Catch: Exception -> L5
        r100.append(']');     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.getMessage();
        Unit r101 = Unit.INSTANCE;
    }

    @Override // com.bytedance.dux.drawable.f
    public final void f() {
        if (this.f204992c == false) goto L6;
        return;
    L6:
        if (isAnimating() == false) goto L8;
        return;
    L8:
        if (getVisibility() != 0) goto L12;
        this.f204992c = true;
        playAnimation();
        Objects.toString(this.f204991b);
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public final String getScene() {
        return this.f204990a;
    }

    public DoubleColorBallAnimationViewNewV2(Context r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = DoubleV2Scene.defaultscene.name();
    L5:
        Intrinsics.checkNotNullParameter(r101, "scene");
        super(r100, null, 0);
        this.f204990a = r101;
        this.f204991b = DoubleV2Scene.defaultscene;
        int r103 = wl4.a.f560193a;
        setAnimation("dux_new_double_color_ball_animation.json");
        setRepeatMode(2);
        setRepeatCount(-1);
    }
}
