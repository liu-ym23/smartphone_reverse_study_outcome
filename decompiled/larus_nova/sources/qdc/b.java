package qdc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.photopickerimpl.view.large.a<Photo> f532606a;

    public b(com.ss.android.lark.widget.photopickerimpl.view.large.a<Photo> r100) {
        this.f532606a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        odc.a.InterfaceC7038a r101 = this.f532606a.f522914b;
        Intrinsics.checkNotNull(r101);
        r101.d(this.f532606a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        odc.a.InterfaceC7038a r101 = this.f532606a.f522914b;
        Intrinsics.checkNotNull(r101);
        r101.d(this.f532606a);
    }
}
