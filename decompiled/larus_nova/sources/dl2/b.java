package dl2;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f469111a = null;

    static {
        f469111a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.onError(new NullPointerException("netService is Null Pointer"));
        r100.onComplete();
    }
}
