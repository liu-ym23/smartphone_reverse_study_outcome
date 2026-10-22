package pa0;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l implements com.bytedance.android.live.incentive.balance.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Pair<com.bytedance.android.live.incentive.balance.e, Observable<e>>> f528346a;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f528347a;

        public b(l r100) {
            this.f528347a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            e r101 = (e) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            Long r102 = this.f528347a.d(r101);
            if (r102 == null) goto L5;
            long r103 = r102.longValue();
        L7:
            return Long.valueOf(r103);
        L5:
            r103 = -1;
            goto L7
        }
    }

    public static final class c<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f528348a = null;

        static {
            f528348a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Long r101 = (Long) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.longValue() < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public l() {
    }

    public abstract Long d(e r100);

    static {
        f528346a = new WeakReference(null);
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final Long b() {
        return d((e) o.f528351b.f90981b);
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final Observable<Long> c(com.bytedance.android.live.incentive.balance.e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Pair<com.bytedance.android.live.incentive.balance.e, Observable<e>> r101 = f528346a.get();
        if (r101 != null) goto L5;
    L7:
        jy0.b.d("Incentive/UserIncomeProvider", "updateExchangeInfo, reason = " + r100.f69337a);
        BehaviorSubject r102 = o.f528352c.b();
        f528346a = new WeakReference(TuplesKt.to(r100, r102));
        Observable<e> r103 = r102;
    L9:
        return r103.map(new b(this)).filter(c.f528348a);
    L5:
        if (r101.getFirst() != r100) goto L7;
        r103 = r101.getSecond();
        goto L9
    }
}
