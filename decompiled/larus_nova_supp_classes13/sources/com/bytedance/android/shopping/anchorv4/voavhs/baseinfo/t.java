package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ECUrlModel a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public static final class a<T> implements y.c {
        public final /* synthetic */ t a;
        public final /* synthetic */ ObservableEmitter b;

        public a(t r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Bitmap r2 = (Bitmap) r9;
            if (this.b.isDisposed() == true) goto L8;
            if (r2 != null) goto L6;
            this.b.onError(new Throwable("load remote url fails: " + this.a.a));
            return;
        L6:
            ObservableEmitter r10 = this.b;
            t r0 = this.a;
            r10.onNext(new w.b(r0.b, r2, r0.c, r0.a.getUri(), this.a.a.getWidth(), this.a.a.getHeight()));
            this.b.onComplete();
            return;
        }
    }

    public t(ECUrlModel r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = true;
    }

    public final void subscribe(ObservableEmitter<w> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        y.l(this.a, 0, 0, new a(this, r3));
    }
}
