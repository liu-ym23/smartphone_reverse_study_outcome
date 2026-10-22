package com.bytedance.android.window.shop.home.tab.tabplugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.window.base.utils.playable.controller.WindowRestrictMarginAreaProcessor;
import com.bytedance.android.ec.window.base.utils.playable.controller.playcontrol.WindowPlayControlStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/tabplugin/ECWindowPlayAbilityPlugin;", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/e;", "Landroidx/lifecycle/LifecycleEventObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowPlayAbilityPlugin implements e, LifecycleEventObserver {
    public com.bytedance.android.ec.window.base.utils.playable.controller.b a;
    public final RecyclerView b;
    public final LifecycleOwner c;
    public final WindowRestrictMarginAreaProcessor d;

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        this.c.getLifecycle().addObserver(this);
        com.bytedance.android.ec.window.base.utils.playable.controller.b r0 = new com.bytedance.android.ec.window.base.utils.playable.controller.b(new vp.a(), new wp.a(this.b), this.d, WindowPlayControlStrategy.KEEP_LAST);
        RecyclerView r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        r0.a = r1;
        r1.addOnScrollListener(r0.d);
        Unit r2 = Unit.INSTANCE;
        this.a = r0;
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        com.bytedance.android.ec.window.base.utils.playable.controller.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.e.c();
    L5:
        this.c.getLifecycle().removeObserver(this);
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = d.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r5 = this.a;
        if (r5 == null) goto L16;
        r5.e.b();
        return;
    L16:
        return;
    L5:
        if (r4 != 2) goto L17;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r6 = this.a;
        if (r6 == null) goto L14;
        r6.e.d();
        return;
    L14:
        return;
    }

    public ECWindowPlayAbilityPlugin(RecyclerView r2, Fragment r3, WindowRestrictMarginAreaProcessor r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
