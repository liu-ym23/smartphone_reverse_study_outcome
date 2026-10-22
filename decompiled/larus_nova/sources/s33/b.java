package s33;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.d;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import n33.f;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b<STATE extends g, PROPS extends u33.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l33.b<STATE, PROPS> f540457a;

    public void A() {
    }

    public void b() {
    }

    public void c() {
    }

    public void e(n33.c r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
    }

    public void f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
    }

    public void g(com.bytedance.kmp.ec.yata.common.biz.callback.a r100, n33.c r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    public void h(com.bytedance.kmp.ec.yata.common.biz.callback.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    public void i(com.bytedance.kmp.ec.yata.common.biz.callback.a r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    public abstract String j();

    public void q(int r100, int r101) {
    }

    public void r() {
    }

    public void s(String r100, RecyclerView r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "popupCode");
        Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
    }

    public void t(z33.a r100, Map<String, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r101, "containerMap");
    }

    public void u(z33.a r100, Map<String, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "containerMap");
    }

    public void v(z33.a r100, Map<String, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r101, "containerMap");
    }

    public void w(z33.a r100, ga6.c r101) {
        Intrinsics.checkNotNullParameter(r101, "config");
    }

    public void x() {
    }

    public void y() {
    }

    public void z() {
    }

    public com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a d() {
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(false);
    }

    public com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a k() {
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(false);
    }

    public b(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.f540457a = r100;
    }

    public com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a n(d r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(false);
    }

    public q33.b o(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = r100.f164136a;
        return new q33.b(false, r100.f164137b);
    }

    public com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a p(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.c r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerInfo");
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(false);
    }

    public q33.a l(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        return new q33.a();
    }

    public q33.b m(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        return new q33.b(false, r101);
    }
}
