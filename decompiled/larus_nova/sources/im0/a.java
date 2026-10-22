package im0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.messagewindow.framework.schedule.action.AbsAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a extends AbsAction<Integer> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f490429d;

    /* JADX INFO: renamed from: im0.a$a, reason: collision with other inner class name */
    public static final class C6286a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6286a f490430a = null;

        static {
            f490430a = new C6286a();
        }

        public C6286a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Integer r101 = (Integer) r100;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f490431a = null;

        static {
            f490431a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f490432a;

        public c(a r100) {
            this.f490432a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f490432a.f490429d.clear();
        }
    }

    public static final class d {
    }

    static {
    }

    public a(j71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        super(r100, 1);
        CompositeDisposable r101 = new CompositeDisposable();
        this.f490429d = r101;
        RxUtilKt.c(this.f83198b.subscribe(C6286a.f490430a, b.f490431a, new c(this)), r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a(int r100) {
        Comparable r101 = Integer.valueOf(r100);
        Intrinsics.checkNotNullParameter(r101, "newState");
        this.f83197a.a((State) r101);
        if (r100 != 3) goto L6;
        this.f83197a.onComplete();
        return;
    }
}
