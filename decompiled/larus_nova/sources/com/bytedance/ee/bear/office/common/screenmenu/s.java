package com.bytedance.ee.bear.office.common.screenmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f235249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenMenuLayout f235250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f235251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CommonMenu f235252d;

    public s(ScreenMenuLayout r100, ScreenMenuLayout r101, View r102, CommonMenu r103) {
        this.f235249a = r100;
        this.f235250b = r101;
        this.f235251c = r102;
        this.f235252d = r103;
    }

    public final void a() {
        ScreenMenuLayout r100 = this.f235250b;
        View r101 = this.f235251c;
        CommonMenu r102 = this.f235252d;
        Animator r103 = r100.f235182i;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        Animator r104 = r100.f235181h;
        if (r104 == null) goto L8;
        r104.cancel();
    L8:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{0.0f, 1.0f});
        r105.setDuration(100);
        if (r101.getWidth() != 0) goto L11;
    L18:
        tt5.a.h("ScreenMenuLayout", "sub menu enter animation fallback alpha only. " + r100.g(r102, r101));
        r100.f235181h = r105;
        r105.start();
        return;
    L11:
        if (r101.getHeight() == 0) goto L18;
        if (r102.getWidth() == 0) goto L18;
        if (r102.getHeight() == 0) goto L18;
        Pair r106 = ScreenMenuLayout.h(r101, r102);
        r101.setPivotX(((Number) r106.getFirst()).floatValue());
        r101.setPivotY(((Number) r106.getSecond()).floatValue());
        r101.setScaleX(0.0f);
        r101.setScaleY(0.0f);
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r101, View.SCALE_X, new float[]{0.0f, 1.0f});
        r107.setDuration(100);
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r108.setDuration(100);
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r105, r107, r108});
        r109.start();
        r100.f235181h = r109;
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
