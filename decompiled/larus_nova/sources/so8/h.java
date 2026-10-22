package so8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f542753a;

    public h(f r100) {
        this.f542753a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FrameLayout r101 = this.f542753a.f542749c;
        if (r101 == null) goto L5;
        e1.o(r101);
    L5:
        FrameLayout r102 = this.f542753a.f542749c;
        if (r102 == null) goto L8;
        r102.removeAllViews();
    L8:
        this.f542753a.getClass();
    }
}
