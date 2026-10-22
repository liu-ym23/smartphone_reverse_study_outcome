package com.bytedance.awemeopen.servicesapi.ui;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;

/* JADX INFO: loaded from: classes46.dex */
public interface d {
    void a(AoAnimConfig.b r100);

    void b();

    void c(String r100);

    void cancelAnimation();

    void d(Drawable.Callback r100);

    void e();

    void f(int r100, int r101);

    void g(int r100);

    LottieDrawable getDrawable();

    float getScale();

    void h(a r100);

    boolean isRunning();

    void setFrame(int r100);

    void setRepeatCount(int r100);

    void setScale(float r100);

    void start();

    void stop();
}
