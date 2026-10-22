package com.bytedance.locallife.poi.poidetail.container.component.view;

import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiExpCollectShareLayout f263797a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiExpCollectShareLayout f263798a;

        public a(PoiExpCollectShareLayout r100) {
            this.f263798a = r100;
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
            this.f263798a.getLayoutParams().height = r103;
            PoiExpCollectShareLayout r104 = this.f263798a;
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

    public d(PoiExpCollectShareLayout r100) {
        this.f263797a = r100;
    }

    public final void a() {
        PoiExpCollectShareLayout r100 = this.f263797a;
        if (r100.f263782o != 0) goto L5;
        r100.f263782o = r100.getHeight();
    L5:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f263797a.f263782o});
        r101.setDuration(300);
        r101.addUpdateListener(new a(this.f263797a));
        r101.start();
        this.f263797a.setVisibility(0);
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
