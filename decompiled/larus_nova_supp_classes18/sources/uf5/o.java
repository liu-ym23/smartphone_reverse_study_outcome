package uf5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final Map<String, String> a;

    public o() {
        this.a = new ConcurrentHashMap();
    }

    public static void b(final String r2) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new a()).map(new f(r2)).subscribe(new g(), new h());
    }

    public final void a(String r4, int r5) {
        tt5.a.h("BadgeManager", "readAllMessage");
        NetService.f r0 = new NetService.f("/api/message/read_all/");
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r4);
        r1.put("obj_type", r5 + "");
        r0.d(r1);
        ((NetService.e) r0).c = 1;
        ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.f()).a(r0).subscribe(new m(this), new n(this));
    }

    public static void c(final String r8, final long r9, final long r11) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new b()).map(new c(r8, r9, r11)).subscribe(new d(r9, r11), new e());
    }
}
