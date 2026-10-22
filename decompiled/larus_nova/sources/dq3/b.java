package dq3;

import android.view.View;
import android.view.ViewGroup;
import aq3.h;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends com.bytedance.android.window.shop.home.module.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f469658m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new com.bytedance.android.window.shop.innerflow.presenter.c();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        ArrayList r100 = new ArrayList();
        r100.add(new c(this.f469658m.findViewById(R.id.ec_shop_inner_flow_toolbar)));
        r100.add(new a(this.f469658m.findViewById(R.id.ec_shop_inner_flow_fl_content)));
        r100.add(new h());
        return r100;
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        super(null);
        this.f469658m = r100;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f188233l = r100;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        return this.f469658m;
    }
}
