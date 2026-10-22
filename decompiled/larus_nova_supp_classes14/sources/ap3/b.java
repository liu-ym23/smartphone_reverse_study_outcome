package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ WindowDatabase a;
    public final /* synthetic */ io.b b;

    public b(WindowDatabase r1, io.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Long> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        c r0 = c.a;
        monitor-enter(r0);
        ho.d r1 = this.a.d();     // Catch: Throwable -> L13
        io.b r2 = this.b;     // Catch: Throwable -> L13
        ho.d r3 = r1;     // Catch: Throwable -> L13
        r3.a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r3.a.beginTransaction();     // Catch: Throwable -> L13
        long r4 = r3.b.insertAndReturnId(r2);     // Catch: Throwable -> L10
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r3.a.endTransaction();     // Catch: Throwable -> L13
        monitor-exit(r0);
        r6.onNext(Long.valueOf(r4));
        return;
    L10:
        th = move-exception;
        r3.a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
