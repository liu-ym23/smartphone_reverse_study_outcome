package rj3;

import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;
import tj3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreSearchHistoryDatabase f537999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f538000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f538001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f538002d;

    public d(StoreSearchHistoryDatabase r100, a r101, String r102, String r103) {
        this.f537999a = r100;
        this.f538000b = r101;
        this.f538001c = r102;
        this.f538002d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<h>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        a r101 = this.f538000b;
        monitor-enter(r101);
        tj3.b r102 = this.f537999a.c();     // Catch: Throwable -> L8
        f r103 = (f) r102;     // Catch: Throwable -> L8
        List<h> r104 = r103.a(this.f538001c, this.f538002d);     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        Intrinsics.checkNotNull(r104);
        r100.onNext(r104);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
