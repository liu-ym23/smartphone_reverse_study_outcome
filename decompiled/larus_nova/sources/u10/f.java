package u10;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCall f548274a;

    public f(c r100) {
        this.f548274a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<HttpResponse> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.onNext((HttpResponse) this.f548274a.execute());     // Catch: Exception -> L5
    L10:
        r100.onComplete();
        return;
    L5:
        e = move-exception;
        if (r100.isDisposed() == true) goto L9;
        r100.onError(e);
        goto L10
    L9:
        ALogger.d("OpenNetworkExecutor", e.getMessage());
        goto L10
    }
}
