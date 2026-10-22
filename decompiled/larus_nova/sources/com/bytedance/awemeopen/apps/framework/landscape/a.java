package com.bytedance.awemeopen.apps.framework.landscape;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f197113a = 0.0f;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.landscape.a$a, reason: collision with other inner class name */
    public static final class C2824a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<View> f197114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<View> f197115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f197116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f197117d;

        public final void a() {
            List<View> r100 = this.f197114a;
            int r101 = this.f197117d;
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((View) r102.next()).setVisibility(r101);
            goto L4
        L6:
            List<View> r103 = this.f197115b;
            int r104 = this.f197117d;
            Iterator<T> r105 = r103.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            ((View) r105.next()).setVisibility(r104);
            goto L8
        L10:
            this.f197116c.setVisibility(this.f197117d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C2824a(List<? extends View> r100, List<? extends View> r101, View r102, int r103) {
            this.f197114a = r100;
            this.f197115b = r101;
            this.f197116c = r102;
            this.f197117d = r103;
        }
    }

    static {
        Resources r100 = Resources.getSystem();
        f197113a = TypedValue.applyDimension(1, 120, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()));
    }

    public static void a(List r100, List r101, View r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "top");
        Intrinsics.checkNotNullParameter(r101, "bottom");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        float r103 = 1.0f;
        if (r110 == false) goto L5;
        float r104 = 0.0f;
    L7:
        if (r110 == false) goto L9;
        int r105 = 8;
    L10:
        C2824a r106 = new C2824a(r100, r101, r102, r105);
        if (r110 == true) goto L14;
        r103 = 0.0f;
    L14:
        Iterator r107 = r100.iterator();
    L16:
        if (r107.hasNext() == false) goto L21;
        View r108 = (View) r107.next();
        if (r110 == true) goto L20;
        r108.setVisibility(0);
    L20:
        r108.animate().translationY(f197113a * (-r103)).setListener(r106).start();
        goto L16
    L21:
        Iterator r109 = r101.iterator();
    L23:
        if (r109.hasNext() == false) goto L28;
        View r111 = (View) r109.next();
        if (r110 == true) goto L27;
        r111.setVisibility(0);
    L27:
        r111.animate().translationY(f197113a * r103).setListener(r106).start();
        goto L23
    L28:
        if (r110 == true) goto L30;
        r102.setVisibility(0);
    L30:
        r102.animate().alpha(r104).setListener(r106).start();
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r104 = 1.0f;
        goto L7
    }
}
