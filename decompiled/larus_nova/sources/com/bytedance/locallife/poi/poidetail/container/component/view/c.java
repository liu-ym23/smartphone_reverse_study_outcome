package com.bytedance.locallife.poi.poidetail.container.component.view;

import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiExpCollectShareLayout f263794a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiExpCollectShareLayout f263795a;

        public a(PoiExpCollectShareLayout r100) {
            this.f263795a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Integer) == false) goto L5;
            Integer r102 = (Integer) r101;
        L6:
            if (r102 == null) goto L8;
            int r103 = r102.intValue();
        L9:
            this.f263795a.getLayoutParams().height = r103;
            PoiExpCollectShareLayout r104 = this.f263795a;
            r104.setLayoutParams(r104.getLayoutParams());
            return;
        L8:
            r103 = 0;
            goto L9
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiExpCollectShareLayout f263796a;

        public b(PoiExpCollectShareLayout r100) {
            this.f263796a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f263796a.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(PoiExpCollectShareLayout r100) {
        this.f263794a = r100;
    }

    public final void a() {
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{this.f263794a.f263782o, 0});
        r100.setDuration(300);
        r100.addUpdateListener(new a(this.f263794a));
        r100.start();
        PoiExpCollectShareLayout r101 = this.f263794a;
        r101.postDelayed(new b(r101), 300);
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
