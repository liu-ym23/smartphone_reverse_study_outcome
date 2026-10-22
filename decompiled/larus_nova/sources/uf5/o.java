package uf5;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f549919a;

    public o() {
        this.f549919a = new ConcurrentHashMap();
    }

    public static void b(final String r100) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new a()).map(new f(r100)).subscribe(new g(), new h());
    }

    public final void a(String r100, int r101) {
        tt5.a.h("BadgeManager", "readAllMessage");
        NetService.e r102 = new NetService.f("/api/message/read_all/");
        HashMap r103 = new HashMap();
        r103.put("token", r100);
        r103.put("obj_type", r101 + "");
        r102.d(r103);
        r102.f216906c = 1;
        ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.f()).a(r102).subscribe(new m(this), new n(this));
    }

    public static void c(final String r100, final long r101, final long r110) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new b()).map(new c(r100, r101, r110)).subscribe(new d(r101, r110), new e());
    }
}
