package uo5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatViewContainer f550917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f550918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f550919c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        d.a(this.f550917a, this.f550918b);
        this.f550917a.setTranslationX(this.f550919c);
    }

    public b(FloatViewContainer r100, int r101, float r102) {
        this.f550917a = r100;
        this.f550918b = r101;
        this.f550919c = r102;
    }
}
