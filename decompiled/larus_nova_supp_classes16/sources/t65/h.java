package t65;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements e {
    @Override // t65.e
    public final int a() {
        return 2131888426;
    }

    @Override // t65.e
    public final boolean b() {
        return true;
    }

    @Override // t65.e
    public final void c() {
    }

    @Override // t65.e
    public final int e() {
        return 2131888361;
    }

    @Override // t65.e
    public final void g() {
    }

    @Override // t65.e
    public final int h() {
        return 2131887788;
    }

    @Override // t65.e
    public final void f() {
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new f("cancel"), new g());
    }

    public h() {
    }

    @Override // t65.e
    public final void d(final Context r4) {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.f());
        NetService.f r1 = new NetService.f("/api/explorer/lark/notifysuitebot/");
        r1.c = 2;
        r0.a(r1).subscribe(new l55.e(r4), new l55.f(r4));
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new f("notify_admin"), new g());
    }
}
