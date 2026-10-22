package com.bytedance.android.window.shop.home.presenter;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0<T> implements ObservableSource {
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ k0 a;
        public final /* synthetic */ Observer b;

        public a(k0 r1, Observer r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowDialogStyledBackgroundPresenter.Z(this.a.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public k0(ECWindowDialogStyledBackgroundPresenter r1) {
        this.a = r1;
    }

    public final void subscribe(Observer<? super int[]> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (this.a.f0().getHeight() != 0) goto L5;
    L8:
        this.a.f0().post(new a(this, r3));
        return;
    L5:
        if (this.a.c0().getHeight() == 0) goto L8;
        ECWindowDialogStyledBackgroundPresenter.Z(this.a, r3);
    }
}
