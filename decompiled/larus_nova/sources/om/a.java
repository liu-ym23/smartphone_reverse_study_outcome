package om;

import com.bytedance.android.ec.store.db.StoreDatabase;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f524204a = null;

    /* JADX INFO: renamed from: om.a$a, reason: collision with other inner class name */
    public static final class C7069a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StoreDatabase f524205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f524206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f524207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f524208d;

        public C7069a(StoreDatabase r100, String r101, String r102, String r103) {
            this.f524205a = r100;
            this.f524206b = r101;
            this.f524207c = r102;
            this.f524208d = r103;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<List<nm.a>> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            CollectionsKt.emptyList();
            a r101 = a.f524204a;
            monitor-enter(r101);
            mm.a r102 = this.f524205a.c();     // Catch: Throwable -> L8
            mm.d r103 = (mm.d) r102;     // Catch: Throwable -> L8
            List<nm.a> r104 = r103.a(this.f524206b, this.f524207c, this.f524208d);     // Catch: Throwable -> L8
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            r100.onNext(r104);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public a() {
    }

    static {
        f524204a = new a();
    }

    public static Observable a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "secShopId");
        Intrinsics.checkNotNullParameter(r102, "date");
        StoreDatabase r103 = lm.a.f509822b.a();
        if (r103 == null) goto L7;
        return Observable.create(new C7069a(r103, r100, r101, r102));
    L7:
        return Observable.just(CollectionsKt.emptyList());
    }
}
