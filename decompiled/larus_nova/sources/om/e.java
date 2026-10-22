package om;

import com.bytedance.android.ec.store.db.StoreDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mm.h;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreDatabase f524215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f524216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f524217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f524218d;

    public e(StoreDatabase r100, String r101, String r102, String r103) {
        this.f524215a = r100;
        this.f524216b = r101;
        this.f524217c = r102;
        this.f524218d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<nm.b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        CollectionsKt.emptyList();
        g r101 = g.f524221a;
        monitor-enter(r101);
        mm.e r102 = this.f524215a.d();     // Catch: Throwable -> L8
        h r103 = (h) r102;     // Catch: Throwable -> L8
        List<nm.b> r104 = r103.a(this.f524216b, this.f524217c, this.f524218d);     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        r100.onNext(r104);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
