package rj3;

import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;
import tj3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreSearchHistoryDatabase f537996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f537997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f537998c;

    public c(StoreSearchHistoryDatabase r100, a r101, h r102) {
        this.f537996a = r100;
        this.f537997b = r101;
        this.f537998c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        a r101 = this.f537997b;
        monitor-enter(r101);
        tj3.b r102 = this.f537996a.c();     // Catch: Throwable -> L13
        h r103 = this.f537998c;     // Catch: Throwable -> L13
        f r104 = (f) r102;     // Catch: Throwable -> L13
        r104.f546404a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f546404a.beginTransaction();     // Catch: Throwable -> L13
        int r105 = r104.f546407d.handle(r103) + 0;     // Catch: Throwable -> L10
        r104.f546404a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f546404a.endTransaction();     // Catch: Throwable -> L13
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Integer.valueOf(r105));
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
