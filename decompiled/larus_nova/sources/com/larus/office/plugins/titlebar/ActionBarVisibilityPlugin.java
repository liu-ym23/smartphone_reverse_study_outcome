package com.larus.office.plugins.titlebar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0013\u0016\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0012\u0010#\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010$\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010'\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010(\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\r2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u00066"}, d2 = {"Lcom/larus/office/plugins/titlebar/ActionBarVisibilityPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "coordinator", "Lcom/larus/office/plugins/titlebar/ActionBarVisibilityCoordinator;", "titleBarStateChangedListener", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar$OnTitleBarStateChangedListener;", "registeredFragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragmentLifecycleCallbacks", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "currentHostKey", "", "hostLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "appletCapsuleVisibilityAbility", "Lcom/bytedance/ee/bear/document/ability/AppletCapsuleVisibilityAbility;", "appletCapsuleVisibilityListener", "com/larus/office/plugins/titlebar/ActionBarVisibilityPlugin$appletCapsuleVisibilityListener$1", "Lcom/larus/office/plugins/titlebar/ActionBarVisibilityPlugin$appletCapsuleVisibilityListener$1;", "hostLifecycleObserver", "com/larus/office/plugins/titlebar/ActionBarVisibilityPlugin$hostLifecycleObserver$1", "Lcom/larus/office/plugins/titlebar/ActionBarVisibilityPlugin$hostLifecycleObserver$1;", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "updateCustomViewFullscreen", "fullscreen", "", "isActionBarVisible", "bindTitleBar", "bindAppletCapsuleVisibility", "unbindAppletCapsuleVisibility", "unbindTitleBar", "bindFragmentLifecycle", "bindHostLifecycle", "unbindHostLifecycle", "syncHostActive", "active", "unbindFragmentLifecycle", "syncFragmentFullscreen", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "isStarted", "syncExistingFullscreenFragments", "fragmentManager", "syncExistingFullscreenFragment", "buildFragmentKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarVisibilityPlugin extends OfficeDocumentPlugin {
    public static final a Companion = null;
    private static final String TAG = "ActionBarVisibilityPlugin";
    private vz4.b appletCapsuleVisibilityAbility;
    private final b appletCapsuleVisibilityListener;
    private final com.larus.office.plugins.titlebar.a coordinator;
    private String currentHostKey;
    private FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks;
    private final ActionBarVisibilityPlugin$hostLifecycleObserver$1 hostLifecycleObserver;
    private LifecycleOwner hostLifecycleOwner;
    private FragmentManager registeredFragmentManager;
    private final TitleBar.a titleBarStateChangedListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements vz4.b.InterfaceC8053b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarVisibilityPlugin f363488a;

        public b(ActionBarVisibilityPlugin r100) {
            this.f363488a = r100;
        }

        @Override // vz4.b.InterfaceC8053b
        public final void a(boolean r100) {
            FLogger.f375446a.i(ActionBarVisibilityPlugin.TAG, "onCapsuleVisibilityChanged: visible=" + r100);
            com.larus.office.plugins.titlebar.a r101 = ActionBarVisibilityPlugin.access$getCoordinator$p(this.f363488a);
            r101.f363493b = d.a(r101.f363493b, false, r100, false, null, 13);
            r101.a();
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(ActionBarVisibilityPlugin r100, com.bytedance.ee.bear.browser.plugin.d r101) {
        titleBarStateChangedListener$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit c(ActionBarVisibilityPlugin r100, boolean r101) {
        return coordinator$lambda$1(r100, r101);
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final void unbindAppletCapsuleVisibility() {
        vz4.b r100 = this.appletCapsuleVisibilityAbility;
        if (r100 == null) goto L5;
        r100.If(null);
    L5:
        this.appletCapsuleVisibilityAbility = null;
    }

    private final void unbindFragmentLifecycle() {
        FragmentManager r100 = this.registeredFragmentManager;
        if (r100 != null) goto L5;
        return;
    L5:
        FragmentManager.FragmentLifecycleCallbacks r101 = this.fragmentLifecycleCallbacks;
        if (r101 == null) goto L8;
        r100.unregisterFragmentLifecycleCallbacks(r101);
    L8:
        this.fragmentLifecycleCallbacks = null;
        this.registeredFragmentManager = null;
    }

    private final void unbindHostLifecycle() {
        LifecycleOwner r100 = this.hostLifecycleOwner;
        if (r100 == null) goto L7;
        Lifecycle r101 = r100.getLifecycle();
        if (r101 == null) goto L7;
        r101.removeObserver(this.hostLifecycleObserver);
    L7:
        String r102 = this.currentHostKey;
        if (r102 == null) goto L10;
        com.larus.office.g r103 = com.larus.office.f.f362173a;
        Intrinsics.checkNotNullParameter(r102, "hostKey");
        com.larus.office.f.f362174b.remove(r102);
        com.larus.office.f.a();
    L10:
        this.hostLifecycleOwner = null;
        this.currentHostKey = null;
    }

    public final boolean isActionBarVisible() {
        d r100 = this.coordinator.f363493b;
        if (r100.f363506a == true) goto L5;
    L11:
        return false;
    L5:
        if (r100.f363507b == false) goto L11;
        if (r100.f363508c == true) goto L11;
        if (r100.f363509d.isEmpty() == false) goto L11;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.office.plugins.titlebar.ActionBarVisibilityPlugin$hostLifecycleObserver$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.titlebar.b] */
    public ActionBarVisibilityPlugin() {
        this.coordinator = new com.larus.office.plugins.titlebar.a(new com.larus.office.plugins.titlebar.b(this));
        this.titleBarStateChangedListener = new c(this);
        this.appletCapsuleVisibilityListener = new b(this);
        this.hostLifecycleObserver = new ActionBarVisibilityPlugin$hostLifecycleObserver$1(this);
    }

    public static final /* synthetic */ com.larus.office.plugins.titlebar.a access$getCoordinator$p(ActionBarVisibilityPlugin r100) {
        return r100.coordinator;
    }

    private final void bindAppletCapsuleVisibility(ChameleonPluginHost r100) {
        unbindAppletCapsuleVisibility();
        if (r100 == null) goto L5;
        vz4.b r101 = (vz4.b) r100.getHostAbilityOrNull(vz4.b.class);
    L6:
        if (r101 != null) goto L9;
        FLogger.f375446a.i(TAG, "bindAppletCapsuleVisibility: ability not found");
        return;
    L9:
        this.appletCapsuleVisibilityAbility = r101;
        com.larus.office.plugins.titlebar.a r102 = this.coordinator;
        boolean r103 = r101.nc();
        r102.f363493b = d.a(r102.f363493b, false, r103, false, null, 13);
        r102.a();
        r101.If(this.appletCapsuleVisibilityListener);
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void bindFragmentLifecycle(ChameleonPluginHost r100) {
        if (r100 == null) goto L15;
        Fragment r101 = r100.getFragment();
        if (r101 == null) goto L16;
        FragmentManager r102 = r101.getChildFragmentManager();
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.registeredFragmentManager == r102) goto L11;
    L13:
        unbindFragmentLifecycle();
        FragmentManager.FragmentLifecycleCallbacks r103 = new AnonymousClass1(this);
        this.fragmentLifecycleCallbacks = r103;
        Intrinsics.checkNotNull(r103);
        r102.registerFragmentLifecycleCallbacks(r103, true);
        this.registeredFragmentManager = r102;
        syncExistingFullscreenFragments(r102);
        return;
    L11:
        if (this.fragmentLifecycleCallbacks == null) goto L13;
        return;
    L16:
        return;
    }

    private final void bindHostLifecycle(ChameleonPluginHost r100) {
        if (r100 == null) goto L13;
        Fragment r101 = r100.getFragment();
        if (r101 == null) goto L14;
        this.currentHostKey = buildFragmentKey(r101);
        LifecycleOwner r102 = this.hostLifecycleOwner;
        if (r102 == null) goto L11;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L11;
        r103.removeObserver(this.hostLifecycleObserver);
    L11:
        this.hostLifecycleOwner = r101;
        r101.getLifecycle().addObserver(this.hostLifecycleObserver);
        return;
    L14:
        return;
    }

    private final void bindTitleBar(com.bytedance.ee.bear.browser.plugin.t r100) {
        if (r100 == null) goto L12;
        TitleBar r101 = r100.getTitleBar();
        if (r101 == null) goto L13;
        r101.g(this.titleBarStateChangedListener);
        com.larus.office.plugins.titlebar.a r102 = this.coordinator;
        com.bytedance.ee.bear.browser.plugin.d r103 = r101.getDeviceInfo();
        if (r103 == null) goto L9;
        boolean r104 = r103.f216622e;
    L10:
        r102.f363493b = d.a(r102.f363493b, r104, false, false, null, 14);
        r102.a();
        return;
    L9:
        r104 = true;
        goto L10
    L13:
        return;
    }

    private final String buildFragmentKey(Fragment r100) {
        return r100.getClass().getName() + '@' + System.identityHashCode(r100);
    }

    private final void syncExistingFullscreenFragment(Fragment r100) {
        if ((r100 instanceof com.bytedance.ee.bear.l) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.getChildFragmentManager().getFragments().iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        Fragment r102 = (Fragment) r101.next();
        Intrinsics.checkNotNull(r102);
        syncExistingFullscreenFragment(r102);
        goto L9
    L11:
        return;
    L5:
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        this.coordinator.b(buildFragmentKey(r100), true);
        goto L7
    }

    private final void syncExistingFullscreenFragments(FragmentManager r100) {
        Iterator<T> r101 = r100.getFragments().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Fragment r102 = (Fragment) r101.next();
        Intrinsics.checkNotNull(r102);
        syncExistingFullscreenFragment(r102);
        goto L4
    }

    private final void syncHostActive(boolean r100) {
        String r101 = this.currentHostKey;
        if (r101 != null) goto L5;
        return;
    L5:
        com.larus.office.f.b(r101, r100);
    }

    private final void unbindTitleBar(com.bytedance.ee.bear.browser.plugin.t r100) {
        if (r100 == null) goto L7;
        TitleBar r101 = r100.getTitleBar();
        if (r101 == null) goto L8;
        r101.c(this.titleBarStateChangedListener);
        return;
    L8:
        return;
    }

    public final void updateCustomViewFullscreen(boolean r100) {
        FLogger.f375446a.i(TAG, "updateCustomViewFullscreen: fullscreen=" + r100);
        com.larus.office.plugins.titlebar.a r101 = this.coordinator;
        r101.f363493b = d.a(r101.f363493b, false, false, r100, null, 11);
        r101.a();
    }

    public static final /* synthetic */ void access$syncHostActive(ActionBarVisibilityPlugin r100, boolean r101) {
        r100.syncHostActive(r101);
    }

    private static final Unit coordinator$lambda$1(ActionBarVisibilityPlugin r100, boolean r101) {
        String r102 = r100.currentHostKey;
        if (r102 == null) goto L6;
        com.larus.office.f.c(r102, r101);
    L6:
        return Unit.INSTANCE;
    }

    private final void syncFragmentFullscreen(Fragment r100, boolean r101) {
        if ((r100 instanceof com.bytedance.ee.bear.l) == true) goto L5;
        return;
    L5:
        String r102 = buildFragmentKey(r100);
        FLogger.f375446a.i(TAG, "syncFragmentFullscreen: key=" + r102 + ", isStarted=" + r101);
        this.coordinator.b(r102, r101);
    }

    private static final void titleBarStateChangedListener$lambda$2(ActionBarVisibilityPlugin r100, com.bytedance.ee.bear.browser.plugin.d r101) {
        com.larus.office.plugins.titlebar.a r102 = r100.coordinator;
        boolean r103 = r101.f216622e;
        r102.f363493b = d.a(r102.f363493b, r103, false, false, null, 14);
        r102.a();
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        bindHostLifecycle(r100);
        bindAppletCapsuleVisibility(r100);
        this.coordinator.a();
        bindTitleBar(r101);
        bindFragmentLifecycle(r100);
        boolean r102 = false;
        if (r100 == null) goto L13;
        Fragment r103 = r100.getFragment();
        if (r103 == null) goto L13;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L13;
        Lifecycle.State r105 = r104.getCurrentState();
        if (r105 == null) goto L13;
        if (r105.isAtLeast(Lifecycle.State.RESUMED) != true) goto L13;
        r102 = true;
    L13:
        syncHostActive(r102);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        unbindTitleBar(r101);
        unbindFragmentLifecycle();
        unbindAppletCapsuleVisibility();
        com.larus.office.plugins.titlebar.a r102 = this.coordinator;
        r102.getClass();
        r102.f363493b = new d(0);
        r102.f363494c = null;
        unbindHostLifecycle();
        super.onDetachFromUIContainer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }

    public static final /* synthetic */ void access$syncFragmentFullscreen(ActionBarVisibilityPlugin r100, Fragment r101, boolean r102) {
        r100.syncFragmentFullscreen(r101, r102);
    }
}
