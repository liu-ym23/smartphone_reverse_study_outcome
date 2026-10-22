package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import ho.l;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final i a = null;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ WindowDatabase a;
        public final /* synthetic */ io.d b;

        public a(WindowDatabase r1, io.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Long> r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            i r0 = i.a;
            monitor-enter(r0);
            l r1 = this.a.f();     // Catch: Throwable -> L13
            io.d r2 = this.b;     // Catch: Throwable -> L13
            l r3 = r1;     // Catch: Throwable -> L13
            r3.a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
            r3.a.beginTransaction();     // Catch: Throwable -> L13
            long r4 = r3.b.insertAndReturnId(r2);     // Catch: Throwable -> L10
            r3.a.setTransactionSuccessful();     // Catch: Throwable -> L10
            r3.a.endTransaction();     // Catch: Throwable -> L13
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
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

    public i() {
    }

    static {
        a = new i();
    }

    public static Observable a(io.d r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        WindowDatabase r0 = go.a.b.a();
        if (r0 == null) goto L7;
        return Observable.create(new a(r0, r2));
    L7:
        return Observable.just(-1L);
    }
}
