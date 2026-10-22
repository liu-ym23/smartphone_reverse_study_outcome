package com.bytedance.android.shopping.store.tabkit.mixframe.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;
import com.bytedance.android.shopping.store.tabkit.mixframe.TabKitMixFrameTabFragment;
import com.bytedance.android.shopping.store.tabkit.mixframe.c;
import com.bytedance.android.shopping.store.tabkit.mixframe.presenter.ECTabKitMixEnginePresenter;
import com.bytedance.android.shopping.store.tabkit.mixframe.presenter.ECTabKitMixFrameStatusPresenter;
import com.bytedance.android.shopping.store.tabkit.mixframe.presenter.ECTabKitMixRefreshPresenter;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.utils.f;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ok3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECTabKitMixFrameBaseImpl implements c {
    public final Lazy b;
    public final Lazy c;
    public final Fragment d;

    public final TabKitViewModel d() {
        return (TabKitViewModel) this.c.getValue();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void destroy() {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void onShow(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final View a() {
        return LayoutInflater.from(this.d.requireContext()).inflate(2131560912, null);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void init() {
        if ((!StringsKt.isBlank(d().getRouterParams().getBtmAB())) == false) goto L5;
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.b(this.d, d().getRouterParams().getBtmAB(), d().getRouterParams().getSourceBtmToken());
    L5:
        Bundle r1 = this.d.getArguments();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.getInt("tab_id");
        String r4 = r1.getString("tab_api_url");
        String r3 = r1.getString("tab_api_params");
        if (r3 == null) goto L12;
        Map<String, Object> r5 = f.c(r3);
        if (r5 == null) goto L12;
    L13:
        List<String> r6 = d().getRouterParams().getApiParamsKeyList();
        Integer r7 = d().getAnchorTabId();
        if (r7 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        ((MixFrameViewModel) this.b.getValue()).init(r4, MapsKt.toMutableMap(r5), r6, r2, r8, d().getTabKitMonitor());
        a r9 = ((MixFrameViewModel) this.b.getValue()).getTabMonitor();
        if (r9 == null) goto L24;
        TabkitFramePref.recordTime$default(r9.c(r2), "t_tab_init", null, 2, null);
        return;
    L24:
        return;
    L17:
        if (r2 != r7.intValue()) goto L19;
        r8 = true;
    L12:
        r5 = MapsKt.emptyMap();
        goto L13
    }

    public ECTabKitMixFrameBaseImpl(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.d = r2;
        this.b = LazyKt.lazy(new ECTabKitMixFrameBaseImpl$viewModel$2(this));
        this.c = LazyKt.lazy(new ECTabKitMixFrameBaseImpl$tabKitViewModel$2(this));
    }

    public static Fragment c(Fragment r1) {
        Fragment r2 = r1.requireParentFragment();
        if ((r2 instanceof com.bytedance.android.shopping.store.tabkit.f) == false) goto L5;
        return r2;
    L5:
        return c(r2);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final List<QIPresenter> b(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Fragment r5 = this.d;
        k r1 = null;
        if ((r5 instanceof TabKitMixFrameTabFragment) == true) goto L5;
        r5 = null;
    L5:
        TabKitMixFrameTabFragment r6 = (TabKitMixFrameTabFragment) r5;
        if (r6 == null) goto L8;
        r1 = r6.getTab();
    L8:
        ArrayList r7 = new ArrayList();
        r7.add(new ECTabKitMixEnginePresenter(this.d, r1));
        r7.add(new ECTabKitMixRefreshPresenter(this.d));
        r7.add(new ECTabKitMixFrameStatusPresenter(this.d));
        return r7;
    }
}
