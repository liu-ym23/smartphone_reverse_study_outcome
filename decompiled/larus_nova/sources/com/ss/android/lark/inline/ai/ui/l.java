package com.ss.android.lark.inline.ai.ui;

import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427562a;

    public l(InlineAIDragView r100) {
        this.f427562a = r100;
    }

    public final void a() {
        InlineAIDragView r100 = this.f427562a;
        r100.f427355b.setAlpha(1.0f);
        int r101 = r100.f427370q - r100.f427356c.getTop();
        Log.i("InlineAIDragView", "do showAnim, initTranslationY = " + r101 + ", panelView.top = " + r100.f427356c.getTop());
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100.f427356c, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{(float) r101, 0.0f});
        r102.setDuration(200);
        r102.setInterpolator(new DecelerateInterpolator());
        r100.K = r102;
        r102.addListener(new i(r100));
        ObjectAnimator r103 = r100.K;
        if (r103 == null) goto L6;
        r103.start();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
