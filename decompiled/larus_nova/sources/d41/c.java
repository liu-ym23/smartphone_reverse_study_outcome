package d41;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f466810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f466811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f466812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f466813d;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f466814a;

        public a(int r100) {
            this.f466814a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            long r101 = ((Number) r100).longValue();
            return Long.valueOf(((long) this.f466814a) - r101);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f466815a;

        public b(c r100) {
            this.f466815a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            c r102 = this.f466815a;
            r102.f466810a = (int) r101.longValue();
            if (r101.longValue() > 0) goto L8;
            Disposable r103 = this.f466815a.f466811b;
            if (r103 == null) goto L7;
            r103.dispose();
        L7:
            c r104 = this.f466815a;
            r104.f466811b = null;
            jy0.b.a(r104.f466812c, "time count down end");
        L8:
            c r105 = this.f466815a;
            r105.f466813d.g(r105.f466812c, r105.f466810a);
        }
    }

    /* JADX INFO: renamed from: d41.c$c, reason: collision with other inner class name */
    public static final class C5629c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f466816a;

        public C5629c(c r100) {
            this.f466816a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            jy0.b.a(this.f466816a.f466812c, "time count down error " + r101.getMessage());
            r101.printStackTrace();
        }
    }

    public final void a() {
        Disposable r100 = this.f466811b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f466811b = null;
    }

    public final void c() {
        Disposable r100 = this.f466811b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        this.f466811b = null;
        this.f466810a = 0;
        this.f466813d.g(this.f466812c, 0);
    }

    public final void b(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        long r101 = 1000;
        int r102 = (int) (r100 / r101);
        int r103 = (int) (r100 % r101);
        int r104 = r102 + 1;
        this.f466810a = r104;
        Disposable r105 = this.f466811b;
        if (r105 == null) goto L8;
        r105.dispose();
    L8:
        this.f466811b = du2.a.b(0, 1, TimeUnit.SECONDS).take(r104).delay(r103, TimeUnit.MILLISECONDS).map(new a(r102)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new C5629c(this));
        this.f466813d.g(this.f466812c, this.f466810a);
    }

    public c(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f466812c = r100;
        this.f466813d = r101;
    }
}
