package yl5;

import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.rn.RnSyncManager;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {

    public static final class a<T> implements FlowableOnSubscribe {
        public static final a<T> a = null;

        /* JADX INFO: renamed from: yl5.b$a$a, reason: collision with other inner class name */
        public static final class C0342a implements n.c {
            public final /* synthetic */ FlowableEmitter<Boolean> a;

            public final void disconnect() {
            }

            public final void a() {
                RnSyncManager r0 = RnSyncManager.a;
                Intrinsics.checkNotNullParameter(this, "iRnConnectStatus");
                RnSyncManager.u.remove(this);
                this.a.onNext(Boolean.TRUE);
                this.a.onComplete();
            }

            public C0342a(FlowableEmitter<Boolean> r1) {
                this.a = r1;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        public final void subscribe(FlowableEmitter<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            RnSyncManager r0 = RnSyncManager.a;
            if (RnSyncManager.v == false) goto L5;
            r2.onNext(Boolean.TRUE);
            r2.onComplete();
            return;
        L5:
            C0342a r1 = new C0342a(r2);
            Intrinsics.checkNotNullParameter(r1, "iRnConnectStatus");
            RnSyncManager.u.add(r1);
        }
    }

    /* JADX INFO: renamed from: yl5.b$b, reason: collision with other inner class name */
    public static final class C0343b<T, R> implements Function {
        public final /* synthetic */ Function0<Flowable<String>> a;

        public C0343b(Function0<? extends Flowable<String>> r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Boolean) r2, "it");
            Flowable r3 = (Flowable) this.a.invoke();
            if (r3 == null) goto L6;
            return r3;
        L6:
            return Flowable.just("empty return");
        }
    }

    public static final String a() {
        StringBuilder r0 = new StringBuilder();
        r0.append(System.currentTimeMillis());
        r0.append('_');
        r0.append((int) (((Random.Default.nextDouble() * ((double) 9)) + ((double) 1)) * ((double) CCMLynxCardView.ViewType.BANNER)));
        return r0.toString();
    }

    public static final Flowable<String> b(Function0<? extends Flowable<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "apply");
        return Flowable.create(a.a, BackpressureStrategy.BUFFER).flatMap(new C0343b(r2));
    }
}
