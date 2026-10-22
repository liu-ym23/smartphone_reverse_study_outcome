package f75;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f475757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f475758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f475759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<VersionPayLoadData> f475760e;

    /* JADX INFO: renamed from: f75.a$a, reason: collision with other inner class name */
    public static final class C5864a {
    }

    static {
    }

    public final void a() {
        String r100 = this.f475756a;
        if (r100 != null) goto L5;
        return;
    L5:
        e r101 = this.f475757b;
        if (r101 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).n5(r101);
    L8:
        e r102 = new e(this);
        this.f475757b = r102;
        com.bytedance.ee.space.sync.b r103 = (com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6);
        sbb.e r104 = sbb.e.f541301l;
        r103.S2(r100, r104.f541317b, r102);
        String r105 = this.f475756a;
        c r106 = this.f475758c;
        if (r106 == null) goto L11;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).P1(r106);
    L11:
        c r107 = new c(this);
        this.f475758c = r107;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).P8(r105, r104.f541317b, r107);
    }

    public final void b() {
        e r100 = this.f475757b;
        if (r100 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).n5(r100);
    L5:
        c r101 = this.f475758c;
        if (r101 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).P1(r101);
    L8:
        this.f475759d.clear();
    }

    public a(String r100) {
        this.f475756a = r100;
        this.f475759d = new CompositeDisposable();
        this.f475760e = new MutableLiveData();
    }
}
