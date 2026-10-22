package d41;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f466804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f466805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f466806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f466807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d41.b f466808e;

    /* JADX INFO: renamed from: d41.a$a, reason: collision with other inner class name */
    public static final class C5628a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f466809a;

        public b(a r100) {
            this.f466809a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            a r102 = this.f466809a;
            int r103 = r102.f466804a + 1;
            r102.f466804a = r103;
            String r104 = r102.f466807d;
            if (r102.f466805b == false) goto L6;
            r102.f466808e.e(r104, r103);
            return;
        }
    }

    static {
    }

    public final void a() {
        Disposable r100 = this.f466806c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f466806c = null;
        this.f466804a = -1;
        this.f466805b = false;
    }

    public final void b(long r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        this.f466804a = (int) r100;
        Disposable r101 = this.f466806c;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f466806c = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        String r102 = this.f466807d;
        int r103 = this.f466804a;
        if (this.f466805b == false) goto L12;
        this.f466808e.e(r102, r103);
        return;
    }

    public final void update(long r100) {
        int r101 = (int) r100;
        this.f466804a = r101;
        this.f466805b = true;
        String r102 = this.f466807d;
        this.f466808e.e(r102, r101);
    }

    public a(String r100, d41.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f466807d = r100;
        this.f466808e = r101;
        this.f466804a = -1;
    }
}
