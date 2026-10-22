package qc8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f532516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BubbleBannerComponent f532517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f532518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f532519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f532520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f532521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float f532522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f532523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f532524i;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f532516a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f532516a == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f532517b.f297496v, this.f532518c) == false) goto L10;
        this.f532517b.f297497w = null;
        BubbleBannerComponent.h3(this.f532519d, this.f532520e, this.f532521f, this.f532522g, this.f532523h, 1.0f);
        this.f532524i.invoke();
        return;
    }

    public q(BubbleBannerComponent r100, String r101, View r102, float r103, float r104, float r105, float r106, Function0<Unit> r107) {
        this.f532517b = r100;
        this.f532518c = r101;
        this.f532519d = r102;
        this.f532520e = r103;
        this.f532521f = r104;
        this.f532522g = r105;
        this.f532523h = r106;
        this.f532524i = r107;
    }
}
