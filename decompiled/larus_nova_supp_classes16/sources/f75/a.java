package f75;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public e b;
    public c c;
    public final CompositeDisposable d;
    public final MutableLiveData<VersionPayLoadData> e;

    /* JADX INFO: renamed from: f75.a$a, reason: collision with other inner class name */
    public static final class C0227a {
    }

    static {
    }

    public final void a() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        e r1 = this.b;
        if (r1 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).n5(r1);
    L8:
        e r2 = new e(this);
        this.b = r2;
        com.bytedance.ee.space.sync.b r4 = (com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6);
        sbb.e r5 = sbb.e.l;
        r4.S2(r0, r5.b, r2);
        String r3 = this.a;
        c r6 = this.c;
        if (r6 == null) goto L11;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).P1(r6);
    L11:
        c r7 = new c(this);
        this.c = r7;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).P8(r3, r5.b, r7);
    }

    public final void b() {
        e r0 = this.b;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).n5(r0);
    L5:
        c r1 = this.c;
        if (r1 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).P1(r1);
    L8:
        this.d.clear();
    }

    public a(String r1) {
        this.a = r1;
        this.d = new CompositeDisposable();
        this.e = new MutableLiveData();
    }
}
