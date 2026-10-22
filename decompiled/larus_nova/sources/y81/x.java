package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class x extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f566843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f566844b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationCancel(r100);
        l r101 = this.f566843a;
        r101.S = false;
        r101.h();
    }

    public x(l r100, Ref.IntRef r101) {
        this.f566843a = r100;
        this.f566844b = r101;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        l r102 = this.f566843a;
        r102.S = false;
        TextSwitcher r103 = r102.f566781p;
        if (r103 == null) goto L5;
        r103.setCurrentText("");
    L5:
        TextSwitcher r104 = this.f566843a.f566781p;
        if (r104 == null) goto L8;
        r104.setVisibility(8);
    L8:
        TextView r105 = this.f566843a.f566782q;
        if (r105 == null) goto L11;
        r105.setVisibility(8);
    L11:
        l r106 = this.f566843a;
        r106.r(r106.f566785t, 1.0f);
        l r107 = this.f566843a;
        int r108 = r107.N;
        if (r108 <= 0) goto L14;
        r107.m(r108);
    L28:
        View r109 = this.f566843a.f566791z;
        if (r109 == null) goto L31;
        r109.setVisibility(0);
    L31:
        HSImageView r110 = this.f566843a.f566780o;
        if (r110 == null) goto L34;
        r110.setVisibility(0);
    L34:
        List<String> r111 = this.f566843a.f566784s;
        if (r111 != null) goto L37;
    L39:
        this.f566843a.h();
        RelativeLayout r112 = this.f566843a.f566785t;
        if (r112 == null) goto L46;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L47;
        r113.width = -2;
        return;
    L47:
        return;
    L46:
        return;
    L37:
        if ((!((ArrayList) r111).isEmpty()) != true) goto L39;
        this.f566843a.o();
        return;
    L14:
        ViewGroup r114 = r107.f566779n;
        if (r114 != null) goto L17;
    L21:
        TextSwitcher r115 = this.f566843a.H;
        if (r115 == null) goto L28;
        if (r115.getVisibility() != 8) goto L28;
        TextSwitcher r116 = this.f566843a.H;
        if (r116 == null) goto L28;
        r116.setVisibility(0);
        goto L28
    L17:
        if (r114.getVisibility() != 0) goto L21;
        ViewGroup r117 = this.f566843a.f566779n;
        if (r117 == null) goto L21;
        r117.setVisibility(8);
        goto L21
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Ref.IntRef r102 = this.f566844b;
        ViewGroup r103 = this.f566843a.f566776k;
        if (r103 == null) goto L5;
        int r104 = r103.getWidth();
    L6:
        r102.element = r104;
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
