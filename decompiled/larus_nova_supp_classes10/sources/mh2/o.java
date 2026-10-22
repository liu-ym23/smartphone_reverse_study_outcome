package mh2;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    public static final class a<T> implements com.bytedance.android.ec.core.utils.o {
        public final /* synthetic */ o a;
        public final /* synthetic */ ObservableEmitter b;

        public a(o r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            if (this.b.isDisposed() == true) goto L8;
            if (r5 != null) goto L6;
            this.b.onError(new Throwable("load remote url fails: " + this.a.a));
            return;
        L6:
            q.a.put(this.a.a, new WeakReference(r5));
            this.b.onNext(new r.b(this.a.b, r5));
            this.b.onComplete();
            return;
        }
    }

    public o(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<r> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        ECLiveImageUtils.f(this.a, new a(this, r3));
    }
}
