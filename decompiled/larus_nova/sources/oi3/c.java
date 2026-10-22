package oi3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.ViewPropertyAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends SlcRoundFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f523385c;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f523386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f523387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f523388c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r101 = this.f523386a;
            r101.f523385c = false;
            r101.b(this.f523387b + 1, this.f523388c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f523386a.f523385c = true;
        }

        public a(c r100, int r101, List r102) {
            this.f523386a = r100;
            this.f523387b = r101;
            this.f523388c = r102;
        }
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
    }

    public final void b(int r100, List<oi3.a> r101) {
        oi3.a r102 = (oi3.a) CollectionsKt.getOrNull(r101, r100);
        if (r102 == null) goto L6;
        ViewPropertyAnimator r103 = animate().setDuration((long) (r102.f523384c * 1000)).scaleX(r102.f523382a).scaleY(r102.f523383b);
        r103.setListener(new a(this, r100, r101));
        r103.start();
        return;
    }
}
