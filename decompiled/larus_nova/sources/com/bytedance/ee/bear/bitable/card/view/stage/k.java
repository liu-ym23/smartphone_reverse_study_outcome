package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k extends pr4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f208733c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StageDataViewHolder f208734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f208735b;

        public a(StageDataViewHolder r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
            this.f208734a = r100;
            this.f208735b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StageDataViewHolder r100 = this.f208734a;     // Catch: Throwable -> L4
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101 = this.f208735b;     // Catch: Throwable -> L4
            r100.f208670a.n(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // pr4.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        b r101 = this.f208732b.f208670a.getView();
        if (r101 == null) goto L5;
        r101.GY(r100);
    L5:
        com.bytedance.ee.util.ui.j.d(new a(this.f208732b, this.f208733c), 100);
    }

    public k(StageDataViewHolder r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
        this.f208732b = r100;
        this.f208733c = r101;
    }
}
