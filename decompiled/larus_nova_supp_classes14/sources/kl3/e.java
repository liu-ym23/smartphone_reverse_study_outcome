package kl3;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public final com.bytedance.android.ec.core.async.b a;

    public static final class a implements Action {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.invoke();
        }
    }

    public e(com.bytedance.android.ec.core.async.b r2) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        this.a = r2;
    }

    public final void a(long r4, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r4 >= 0) goto L6;
        r6.invoke();
        return;
    L6:
        com.bytedance.android.ec.core.async.a.a(Completable.timer(r4, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new a(r6)), this.a);
    }
}
