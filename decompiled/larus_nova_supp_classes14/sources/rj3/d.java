package rj3;

import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;
import tj3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements ObservableOnSubscribe {
    public final /* synthetic */ StoreSearchHistoryDatabase a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public d(StoreSearchHistoryDatabase r1, a r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<List<h>> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        a r0 = this.b;
        monitor-enter(r0);
        tj3.b r1 = this.a.c();     // Catch: Throwable -> L8
        f r2 = (f) r1;     // Catch: Throwable -> L8
        List<h> r3 = r2.a(this.c, this.d);     // Catch: Throwable -> L8
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        Intrinsics.checkNotNull(r3);
        r5.onNext(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
