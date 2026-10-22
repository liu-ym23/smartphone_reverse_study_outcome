package qh2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<Integer, Integer, Float, Unit> f532939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f532940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f532941c;

    /* JADX INFO: renamed from: qh2.a$a, reason: collision with other inner class name */
    public static final class C7327a {
    }

    static {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationCancel(r100);
        int r101 = this.f532941c;
        if (r101 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r102 = this.f532939a;
        if (r102 == null) goto L16;
        Unit r103 = r102.invoke(120, 0, Float.valueOf(0.0f));
        return;
    L16:
        return;
    L5:
        if (r101 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r104 = this.f532939a;
        if (r104 == null) goto L14;
        Unit r105 = r104.invoke(220, this.f532940b.invoke(), Float.valueOf(1.0f));
        return;
    L14:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        int r101 = this.f532941c;
        if (r101 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r102 = this.f532939a;
        if (r102 == null) goto L16;
        Unit r103 = r102.invoke(120, this.f532940b.invoke(), Float.valueOf(1.0f));
        return;
    L16:
        return;
    L5:
        if (r101 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r104 = this.f532939a;
        if (r104 == null) goto L14;
        Unit r105 = r104.invoke(220, 0, Float.valueOf(0.0f));
        return;
    L14:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        int r101 = this.f532941c;
        if (r101 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r102 = this.f532939a;
        if (r102 == null) goto L16;
        Unit r103 = r102.invoke(100, 0, Float.valueOf(0.0f));
        return;
    L16:
        return;
    L5:
        if (r101 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r104 = this.f532939a;
        if (r104 == null) goto L14;
        Unit r105 = r104.invoke(200, this.f532940b.invoke(), Float.valueOf(1.0f));
        return;
    L14:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100, r101);
        int r102 = this.f532941c;
        if (r102 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r103 = this.f532939a;
        if (r103 == null) goto L16;
        Unit r104 = r103.invoke(120, this.f532940b.invoke(), Float.valueOf(1.0f));
        return;
    L16:
        return;
    L5:
        if (r102 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r105 = this.f532939a;
        if (r105 == null) goto L14;
        Unit r106 = r105.invoke(220, 0, Float.valueOf(0.0f));
        return;
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function3<? super Integer, ? super Integer, ? super Float, Unit> r100, Function0<Integer> r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "viewHeight");
        this.f532939a = r100;
        this.f532940b = r101;
        this.f532941c = r102;
    }
}
