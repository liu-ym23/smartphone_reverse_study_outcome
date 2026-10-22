package com.bytedance.android.shopping.store.tabkit.anniex;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.bytedance.android.shopping.store.tabkit.anniex.component.TabHybridComponent;
import com.bytedance.android.shopping.store.tabkit.anniex.view.TabRootView;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.TabVisibleFrom;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.monitor.TabKitAppMonitor;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00102R\u0014\u00108\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R\u0016\u00109\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/anniex/TabKitAnnieXTabFragment;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "Landroid/content/Context;", "context", "", "initRootView", "", "getPageVisibleChangeSource", "", "visible", "notifyMarketingVisibleChange", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "initHybridComponent", "onResume", "onPause", "Lcom/bytedance/android/shopping/store/tabkit/model/TabVisibleFrom;", "showFrom", "sendVisibleEvent", "Lcom/bytedance/android/shopping/store/tabkit/anniex/component/TabHybridComponent;", "hybridComponent", "Lcom/bytedance/android/shopping/store/tabkit/anniex/component/TabHybridComponent;", "getHybridComponent", "()Lcom/bytedance/android/shopping/store/tabkit/anniex/component/TabHybridComponent;", "setHybridComponent", "(Lcom/bytedance/android/shopping/store/tabkit/anniex/component/TabHybridComponent;)V", "Lcom/bytedance/android/shopping/store/tabkit/anniex/view/TabRootView;", "rootView", "Lcom/bytedance/android/shopping/store/tabkit/anniex/view/TabRootView;", "getRootView", "()Lcom/bytedance/android/shopping/store/tabkit/anniex/view/TabRootView;", "setRootView", "(Lcom/bytedance/android/shopping/store/tabkit/anniex/view/TabRootView;)V", "Lkk3/a;", "monitor", "Lkk3/a;", "getMonitor", "()Lkk3/a;", "setMonitor", "(Lkk3/a;)V", "isLandingTab", "Z", "()Z", "setLandingTab", "(Z)V", "isVisibility", "_isAppInBackground", "isCurrentTabShow", "isLandingFinished", "()Ljava/lang/Boolean;", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TabKitAnnieXTabFragment extends TabKitTabFragment {
    public static final a Companion = null;
    public static final String KEY_ARGUMENT_NEED_TITLE = "need_title";
    public static final String KEY_ARGUMENT_TAB_ID = "tab_id";
    private boolean _isAppInBackground;
    private TabHybridComponent hybridComponent;
    private boolean isLandingTab;
    private boolean isVisibility;
    private kk3.a monitor;
    private TabRootView rootView;

    public static final class a {
        public a() {
        }

        public static boolean a(k r1, TabKitAbilityConfig r2) {
            Intrinsics.checkNotNullParameter(r1, "tab");
            Intrinsics.checkNotNullParameter(r2, "config");
            Lazy r0 = ECAppInfoService.a;
            if (we.a.a == false) goto L5;
        L17:
            return false;
        L5:
            if (e.l(r1) == false) goto L17;
            s r3 = r1.f();
            if (r3 == null) goto L9;
            Integer r4 = r3.d();
        L10:
            if (r4 == null) goto L17;
            if (r4.intValue() != 1) goto L17;
            if (r2.b("disable_anniex_container") == true) goto L17;
            return true;
        L9:
            r4 = null;
            goto L10
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TabKitAnnieXTabFragment a;
        public final /* synthetic */ boolean b;

        public b(TabKitAnnieXTabFragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.b == false) goto L8;
            if (this.a.isResumed() == true) goto L8;
            return;
        L8:
            if (this.b == TabKitAnnieXTabFragment.access$isVisibility$p(this.a)) goto L23;
            String r0 = TabKitAnnieXTabFragment.access$getPageVisibleChangeSource(this.a);
            if (this.a.getHybridComponent() == null) goto L17;
            Intrinsics.checkNotNullParameter(r0, "source");
            Result.constructor-impl(null);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L17:
            if ((!Intrinsics.areEqual(r0, "app")) == false) goto L19;
            TabKitAnnieXTabFragment.access$notifyMarketingVisibleChange(this.a, this.b);
        L19:
            TabKitAnnieXTabFragment.access$setVisibility$p(this.a, this.b);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final String getPageVisibleChangeSource() {
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L8;
        n83.a r2 = r1.getAppLifecycleObserver();
        if (r2 == null) goto L8;
        r2.isAppInBackground();
    L8:
        if (this._isAppInBackground == false) goto L10;
        this._isAppInBackground = false;
        return "app";
    L10:
        return "page";
    }

    public final void initHybridComponent() {
        if (this.hybridComponent == null) goto L5;
        return;
    L5:
        TabHybridComponent r0 = new TabHybridComponent(this);
        r0.a();
        Unit r1 = Unit.INSTANCE;
        this.hybridComponent = r0;
    }

    public TabKitAnnieXTabFragment() {
        this.isVisibility = true;
    }

    private final boolean isCurrentTabShow() {
        y r0 = (y) getTabKitViewModel().getCurrentTab().getValue();
        if (r0 == null) goto L5;
        k r1 = r0.a;
    L7:
        return Intrinsics.areEqual(r1, getTab());
    L5:
        r1 = null;
        goto L7
    }

    private final Boolean isLandingFinished() {
        return (Boolean) getTabKitViewModel().isLandingFinished().getValue();
    }

    public void onPause() {
        super.onPause();
        boolean r2 = true;
        if (getTabKitViewModel().getLandingFinishedOpt() == false) goto L16;
        String r0 = getTabKitViewModel().getRouterParams().getAnchorUrl();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L18;
        if ((!Intrinsics.areEqual((Boolean) getTabKitViewModel().getPageLandingFinished().getValue(), Boolean.FALSE)) == true) goto L18;
        r2 = false;
    L18:
        if (isCurrentTabShow() == false) goto L22;
        if (r2 == false) goto L23;
        sendVisibleEvent$default(this, false, null, 2, null);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L16:
        r2 = true ^ Intrinsics.areEqual(isLandingFinished(), Boolean.FALSE);
        goto L18
    }

    public void onResume() {
        super.onResume();
        if (isCurrentTabShow() == false) goto L6;
        sendVisibleEvent$default(this, true, null, 2, null);
        return;
    }

    public final TabHybridComponent getHybridComponent() {
        return this.hybridComponent;
    }

    public final kk3.a getMonitor() {
        return this.monitor;
    }

    public final TabRootView getRootView() {
        return this.rootView;
    }

    public final boolean isLandingTab() {
        return this.isLandingTab;
    }

    public static final /* synthetic */ String access$getPageVisibleChangeSource(TabKitAnnieXTabFragment r0) {
        return r0.getPageVisibleChangeSource();
    }

    public static final /* synthetic */ boolean access$isVisibility$p(TabKitAnnieXTabFragment r0) {
        return r0.isVisibility;
    }

    private final void initRootView(Context r6) {
        if (this.rootView == null) goto L5;
        return;
    L5:
        Bundle r0 = getArguments();
        int r1 = 0;
        if (r0 == null) goto L8;
        boolean r2 = r0.getBoolean(KEY_ARGUMENT_NEED_TITLE);
    L9:
        TabRootView r3 = new TabRootView(r6, null, 6, r1);
        r3.setTabFragment(this);
        r3.setShowTitle(r2);
        r3.e();
        Unit r7 = Unit.INSTANCE;
        this.rootView = r3;
        if (this.isLandingTab == false) goto L13;
        initHybridComponent();
        return;
    L13:
        return;
    L8:
        r2 = false;
        goto L9
    }

    private final void notifyMarketingVisibleChange(boolean r9) {
        String r6 = getTabKitViewModel().getMarketingPageId();
        if (r6 == null) goto L25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        IMarketingServiceV2 r1 = ECMarketingSDK.c();     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L19
        if (r9 == false) goto L9;
        int r10 = 1;
    L10:
        r3.putOpt("visible", Integer.valueOf(r10));     // Catch: Throwable -> L19
        r3.putOpt("source", "page");     // Catch: Throwable -> L19
        k r2 = getTab();     // Catch: Throwable -> L19
        if (r2 == null) goto L14;
        Object r4 = r2.n();     // Catch: Throwable -> L19
        if (r4 == null) goto L14;
    L15:
        r3.putOpt("tab_id", r4);     // Catch: Throwable -> L19
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
        IMarketingServiceV2.a.b(r1, "ecom.marketing.event.pageVisibilityChange", r3, null, null, r6, 25);     // Catch: Throwable -> L19
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L19
    L21:
        Result.box-impl(r13);
        return;
    L14:
        r4 = "";
        goto L15
    L9:
        r10 = 0;
        goto L10
    L16:
        r12 = null;
    L19:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        Long r5 = getTabKitViewModel().getTabKitMonitorId();
        Observable<Boolean> r0 = TabKitAppMonitor.a;
        k r1 = getTab();
        if (r1 == null) goto L5;
        Integer r2 = r1.n();
    L6:
        TabKitAppMonitor.c(r5, r2);
        kk3.a r6 = new kk3.a(this);
        this.monitor = r6;
        Intrinsics.checkNotNullParameter("t_tab_init", "key");
        TabkitSwitchTabPref r7 = r6.a();
        if (r7 == null) goto L10;
        r7.recordTime("t_tab_init", null);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void setHybridComponent(TabHybridComponent r1) {
        this.hybridComponent = r1;
    }

    public final void setLandingTab(boolean r1) {
        this.isLandingTab = r1;
    }

    public final void setMonitor(kk3.a r1) {
        this.monitor = r1;
    }

    public final void setRootView(TabRootView r1) {
        this.rootView = r1;
    }

    public static final /* synthetic */ void access$notifyMarketingVisibleChange(TabKitAnnieXTabFragment r0, boolean r1) {
        r0.notifyMarketingVisibleChange(r1);
    }

    public static final /* synthetic */ void access$setVisibility$p(TabKitAnnieXTabFragment r0, boolean r1) {
        r0.isVisibility = r1;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitTabFragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        TabRootView r4 = this.rootView;
        if (r4 == null) goto L6;
        r4.d();
        return;
    }

    public void sendVisibleEvent(boolean r2, TabVisibleFrom r3) {
        Intrinsics.checkNotNullParameter(r3, "showFrom");
        View r4 = getView();
        if (r4 == null) goto L6;
        r4.post(new b(this, r2));
        return;
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        Context r4 = r1.getContext();
        if (this.rootView != null) goto L5;
        initRootView(r4);
    L5:
        TabRootView r5 = this.rootView;
        if (r5 == null) goto L9;
        return r5;
    L9:
        return new View(r4);
    }

    public static /* synthetic */ void sendVisibleEvent$default(TabKitAnnieXTabFragment r0, boolean r1, TabVisibleFrom r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TabVisibleFrom.Unknown;
    L6:
        r0.sendVisibleEvent(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendVisibleEvent");
    }
}
