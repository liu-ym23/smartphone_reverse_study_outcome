package mh2;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f513930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f513931b;

    public static final class a<T> implements com.bytedance.android.ec.core.utils.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f513932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f513933b;

        public a(o r100, ObservableEmitter r101) {
            this.f513932a = r100;
            this.f513933b = r101;
        }

        @Override // com.bytedance.android.ec.core.utils.o
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (this.f513933b.isDisposed() == true) goto L8;
            if (r101 != null) goto L6;
            this.f513933b.onError(new Throwable("load remote url fails: " + this.f513932a.f513930a));
            return;
        L6:
            q.f513935a.put(this.f513932a.f513930a, new WeakReference(r101));
            this.f513933b.onNext(new r.b(this.f513932a.f513931b, r101));
            this.f513933b.onComplete();
            return;
        }
    }

    public o(String r100, int r101) {
        this.f513930a = r100;
        this.f513931b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<r> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ECLiveImageUtils.f(this.f513930a, new a(this, r100));
    }
}
