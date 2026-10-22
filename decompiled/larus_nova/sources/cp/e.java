package cp;

import com.bytedance.android.ec.window.base.repository.searchhistorydb.WindowSearchHistoryDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchHistoryDatabase f464605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f464606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f464607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f464608d;

    public e(WindowSearchHistoryDatabase r100, b r101, String r102, String r103) {
        this.f464605a = r100;
        this.f464606b = r101;
        this.f464607c = r102;
        this.f464608d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<a>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        b r101 = this.f464606b;
        monitor-enter(r101);
        dp.b r102 = this.f464605a.c();     // Catch: Throwable -> L8
        dp.f r103 = (dp.f) r102;     // Catch: Throwable -> L8
        List<a> r104 = r103.a(this.f464607c, this.f464608d);     // Catch: Throwable -> L8
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
