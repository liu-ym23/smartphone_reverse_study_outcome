package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class o extends hf6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiCoiSingleFeedCard f263195a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiCoiSingleFeedCard f263196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animatable f263197b;

        public a(PoiCoiSingleFeedCard r100, Animatable r101) {
            this.f263196a = r100;
            this.f263197b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f263196a.P == false) goto L11;
            Animatable r100 = this.f263197b;     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            r100.start();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
    }

    public o(PoiCoiSingleFeedCard r100) {
        this.f263195a = r100;
    }

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
        PoiCoiSingleFeedCard r104 = this.f263195a;
        r104.post(new a(r104, r103));
    }
}
