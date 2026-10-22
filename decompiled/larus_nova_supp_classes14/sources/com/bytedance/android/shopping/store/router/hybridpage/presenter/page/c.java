package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.InitializeErrorType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements IECLynxCardLifeCycle {
    public final /* synthetic */ HybridPageCardPresenter a;
    public final /* synthetic */ String b;

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onFirstScreen() {
    }

    public final void onLoadStart() {
    }

    public final void onPreCreateView(boolean r1) {
    }

    public final void onRealSuccess() {
    }

    public final void onReceivedError(com.bytedance.lynx.service.model.b r1) {
    }

    public final void onTimingSetup(Map<String, ? extends Object> r1) {
    }

    public final void onTimingSetupPref(k r1) {
    }

    public final void onTimingUpdatePref(k r1) {
    }

    public final void onTransDataTime(long r1, long r3) {
    }

    public final void onLoadSuccess() {
        dm.a.a("HybridPageCardPresenter").i("lynxCard onLoadSuccess, template=" + this.a.i0());
    }

    public final void onRuntimeReady() {
        dm.a.a("HybridPageCardPresenter").i("lynxCard onRuntimeReady, template=" + this.a.i0() + ", pendingJsEvents=" + ((ArrayList) this.a.j).size());
        HybridPageCardPresenter r0 = this.a;
        r0.i = true;
        Iterator r1 = ((ArrayList) r0.j).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Function0) r1.next()).invoke();
        goto L4
    L6:
        ((ArrayList) this.a.j).clear();
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public c(HybridPageCardPresenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onLoadFailed(ECLynxCardErrorType r6, Integer r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "type");
        String r2 = null;
        dm.a.a("HybridPageCardPresenter").b("lynxCard onLoadFailed, template=" + this.a.i0() + ", type=" + r6 + ", code=" + r7 + ", msg=" + r8, null);
        this.a.j0().getLoadStatus().g(LoadStatus.InitializeError);
        HybridPageViewModel r0 = this.a.j0();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("page_card_url", this.b);
        r1.put("initialize_error_type", InitializeErrorType.PAGE_CARD_ERROR.getType());
        r1.put("error_type", r6.name());
        if (r7 == null) goto L5;
        r2 = String.valueOf(r7.intValue());
    L5:
        r1.put("error_code", r2);
        r1.put("error_msg", r8);
        Unit r9 = Unit.INSTANCE;
        r0.reportInitializeError(r1);
    }
}
