package rj3;

import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;
import tj3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ StoreSearchHistoryDatabase a;
    public final /* synthetic */ a b;
    public final /* synthetic */ h c;

    public e(StoreSearchHistoryDatabase r1, a r2, h r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        a r0 = this.b;
        monitor-enter(r0);
        tj3.b r1 = this.a.c();     // Catch: Throwable -> L13
        h r2 = this.c;     // Catch: Throwable -> L13
        f r3 = (f) r1;     // Catch: Throwable -> L13
        r3.a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r3.a.beginTransaction();     // Catch: Throwable -> L13
        int r4 = r3.e.handle(r2) + 0;     // Catch: Throwable -> L10
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r3.a.endTransaction();     // Catch: Throwable -> L13
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        r5.onNext(Integer.valueOf(r4));
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
