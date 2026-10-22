package om;

import com.bytedance.android.ec.store.db.StoreDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mm.h;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreDatabase f524219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nm.b f524220b;

    public f(StoreDatabase r100, nm.b r101) {
        this.f524219a = r100;
        this.f524220b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        g r101 = g.f524221a;
        monitor-enter(r101);
        mm.e r102 = this.f524219a.d();     // Catch: Throwable -> L13
        nm.b r103 = this.f524220b;     // Catch: Throwable -> L13
        h r104 = (h) r102;     // Catch: Throwable -> L13
        r104.f514407a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f514407a.beginTransaction();     // Catch: Throwable -> L13
        int r105 = r104.f514409c.handle(r103) + 0;     // Catch: Throwable -> L10
        r104.f514407a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f514407a.endTransaction();     // Catch: Throwable -> L13
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Integer.valueOf(r105));
        return;
    L10:
        th = move-exception;
        r104.f514407a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
