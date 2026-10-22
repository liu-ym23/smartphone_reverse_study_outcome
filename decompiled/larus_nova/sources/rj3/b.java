package rj3;

import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;
import tj3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreSearchHistoryDatabase f537993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f537994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f537995c;

    public b(StoreSearchHistoryDatabase r100, a r101, h r102) {
        this.f537993a = r100;
        this.f537994b = r101;
        this.f537995c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        a r101 = this.f537994b;
        monitor-enter(r101);
        tj3.b r102 = this.f537993a.c();     // Catch: Throwable -> L13
        h r103 = this.f537995c;     // Catch: Throwable -> L13
        f r104 = (f) r102;     // Catch: Throwable -> L13
        r104.f546404a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f546404a.beginTransaction();     // Catch: Throwable -> L13
        long r105 = r104.f546405b.insertAndReturnId(r103);     // Catch: Throwable -> L10
        r104.f546404a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f546404a.endTransaction();     // Catch: Throwable -> L13
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Long.valueOf(r105));
        return;
    L10:
        th = move-exception;
        r104.f546404a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
