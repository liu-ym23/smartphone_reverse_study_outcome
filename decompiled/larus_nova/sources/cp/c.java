package cp;

import com.bytedance.android.ec.window.base.repository.searchhistorydb.WindowSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchHistoryDatabase f464599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f464600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f464601c;

    public c(WindowSearchHistoryDatabase r100, b r101, a r102) {
        this.f464599a = r100;
        this.f464600b = r101;
        this.f464601c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        b r101 = this.f464600b;
        monitor-enter(r101);
        dp.b r102 = this.f464599a.c();     // Catch: Throwable -> L13
        a r103 = this.f464601c;     // Catch: Throwable -> L13
        dp.f r104 = (dp.f) r102;     // Catch: Throwable -> L13
        r104.f469552a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f469552a.beginTransaction();     // Catch: Throwable -> L13
        long r105 = r104.f469553b.insertAndReturnId(r103);     // Catch: Throwable -> L10
        r104.f469552a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f469552a.endTransaction();     // Catch: Throwable -> L13
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Long.valueOf(r105));
        return;
    L10:
        th = move-exception;
        r104.f469552a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
