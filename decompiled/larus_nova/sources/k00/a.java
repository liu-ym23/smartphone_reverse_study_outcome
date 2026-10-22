package k00;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.model.l1;
import com.google.gson.Gson;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f501236a = null;

    static {
        f501236a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<l1> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Gson r102 = GsonHelper.get();     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.sharedpref.e<String> r103 = e.f501240a;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((l1) r102.fromJson(e.f501240a.getValue(), l1.class));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        l1 r105 = (l1) r104;
        if (r105 == null) goto L13;
        r100.onNext(r105);
        r100.onComplete();
        return;
    L13:
        com.bytedance.android.livesdk.sharedpref.e<String> r106 = e.f501240a;
        r100.onComplete();
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
