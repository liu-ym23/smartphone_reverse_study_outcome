package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.window.shop.home.presenter.AbsECWindowPresenter$observableSourceFromLiveData$2;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.p;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowTabsSelectionJSbPluginExp extends ECWindowJsbPlugin {
    public static final /* synthetic */ int g = 0;
    public final List<p> b;
    public final List<Runnable> c;
    public Disposable d;
    public final ECWindowViewModel e;
    public final Function2<String, List<p>, Unit> f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.coupon.receive_result", new ECWindowTabsSelectionJSbPluginExp$createJsbActions$1(this)), new c("ecom.window.tab_anchor", new ECWindowTabsSelectionJSbPluginExp$createJsbActions$2(this))});
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        super.a();
        s0.c(this);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        super.b();
        s0.e(this);
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Subscribe
    public final void onReceiveAnchorEvent(com.bytedance.android.window.shop.home.tab.tabplugin.a r3) {
        Intrinsics.checkNotNullParameter(r3, "anchorParam");
        if ((!Intrinsics.areEqual(r3.a, this.e.getShopParam().getSecAuthorId())) == false) goto L5;
        return;
    L5:
        this.f.invoke(r3.b, this.b);
    }

    public ECWindowTabsSelectionJSbPluginExp(ECWindowViewModel r2, Function2 r3, AbsECWindowPresenter$observableSourceFromLiveData$2 r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "onTabSelected");
        Intrinsics.checkNotNullParameter(r4, "categoryListSource");
        this.e = r2;
        this.f = r3;
        this.b = new ArrayList();
        this.c = new ArrayList();
        r4.subscribe(new com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.a(this));
    }
}
