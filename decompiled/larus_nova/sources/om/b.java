package om;

import com.bytedance.android.ec.store.db.StoreDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreDatabase f524209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nm.a f524210b;

    public b(StoreDatabase r100, nm.a r101) {
        this.f524209a = r100;
        this.f524210b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        a r101 = a.f524204a;
        monitor-enter(r101);
        mm.a r102 = this.f524209a.c();     // Catch: Throwable -> L13
        nm.a r103 = this.f524210b;     // Catch: Throwable -> L13
        mm.d r104 = (mm.d) r102;     // Catch: Throwable -> L13
        r104.f514404a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f514404a.beginTransaction();     // Catch: Throwable -> L13
        long r105 = r104.f514405b.insertAndReturnId(r103);     // Catch: Throwable -> L10
        r104.f514404a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f514404a.endTransaction();     // Catch: Throwable -> L13
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Long.valueOf(r105));
        return;
    L10:
        th = move-exception;
        r104.f514404a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
