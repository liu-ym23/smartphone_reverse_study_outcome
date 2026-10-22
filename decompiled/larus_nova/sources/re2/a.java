package re2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f537415a;

    public a(b r100) {
        this.f537415a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        this.f537415a.b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        b r101 = this.f537415a;
        Drawable r102 = r101.f70875g.getBackground();
        if (r102 == null) goto L16;
        GradientDrawable r103 = (GradientDrawable) r102;
        int[] r104 = new int[2];
        if (this.f537415a.B == false) goto L7;
        long r105 = BodyPartID.bodyIdMax;
    L8:
        r104[0] = (int) r105;
        r104[1] = 0;
        ObjectAnimator r106 = ObjectAnimator.ofInt(r103, "color", r104);
        r106.setDuration(400);
        r106.setEvaluator(new ArgbEvaluator());
        ((ArrayList) this.f537415a.f70877i).add(r106);
        Unit r107 = Unit.INSTANCE;
        r101.N = r106;
        ObjectAnimator r108 = this.f537415a.N;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("buttonBgColorGone");
    L11:
        r108.start();
        b r109 = this.f537415a;
        if (r109.B == false) goto L17;
        r109.f70885q.start();
        return;
    L17:
        return;
    L7:
        r105 = 3003121664L;
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }
}
