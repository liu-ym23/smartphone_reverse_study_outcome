package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowTabNewProductPlugin extends ECWindowJsbPlugin {
    public static final /* synthetic */ int e = 0;
    public final ECWindowViewModel b;
    public final com.bytedance.android.window.shop.c c;
    public final Function1<TabNavigationParams, Unit> d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.coupon.receive_result", new ECWindowTabNewProductPlugin$createJsbActions$1(this)), new c("ecom.window.category_anchor", new ECWindowTabNewProductPlugin$createJsbActions$2(this))});
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        super.a();
        s0.c(this);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        s0.e(this);
        super.b();
    }

    public final void h(JSONObject r4) {
        String r0 = r4.optString("sec_author_id", "");
        boolean r2 = true;
        if ((!Intrinsics.areEqual(r0, "")) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
    L11:
        if (r2 == false) goto L14;
        Function1<TabNavigationParams, Unit> r1 = this.d;
        TabNavigationParams.Companion.getClass();
        r1.invoke(TabNavigationParams.a.a(r4));
        return;
    L14:
        return;
    L8:
        if (Intrinsics.areEqual(r0, this.b.getShopParam().getSecAuthorId()) == true) goto L11;
        r2 = false;
        goto L11
    }

    @Subscribe
    public final void onReceiveAnchorEvent(com.bytedance.android.window.shop.home.tab.tabplugin.a r9) {
        Intrinsics.checkNotNullParameter(r9, "anchorParam");
        if ((!Intrinsics.areEqual(this.c, com.bytedance.android.window.shop.c.c)) == false) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r9.a, this.b.getShopParam().getSecAuthorId())) == false) goto L8;
        return;
    L8:
        String r0 = r9.b;
        if (r0 != null) goto L11;
        WindowNavigationParam.Companion.getClass();
        WindowNavigationParam r1 = WindowNavigationParam.a.b();
    L12:
        WindowNavigationParam r4 = r1;
        String r2 = r9.c;
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        Long r3 = r9.d;
        Function1<TabNavigationParams, Unit> r10 = this.d;
        WindowNavigationParam.Companion.getClass();
        r10.invoke(new TabNavigationParams(WindowNavigationParam.a.b(), r3, r4, r2, null, WindowNavigationParam.a.b()));
        return;
    L11:
        WindowNavigationParam.Companion.getClass();
        r1 = WindowNavigationParam.a.c(r0);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowTabNewProductPlugin(ECWindowViewModel r2, com.bytedance.android.window.shop.c r3, Function1<? super TabNavigationParams, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "currentTabType");
        Intrinsics.checkNotNullParameter(r4, "actionPerformer");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
