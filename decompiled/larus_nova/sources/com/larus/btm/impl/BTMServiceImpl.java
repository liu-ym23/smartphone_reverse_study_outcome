package com.larus.btm.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cd.c;
import com.bytedance.android.bcm.api.BcmHostDependManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.f;
import com.bytedance.android.btm.api.view.BtmViewUtils;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.ecom.bcm.track.api.TrackHostDependManager;
import com.bytedance.ies.bullet.core.y;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IBtmHostDependencyDelegate;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import jc.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import mv8.d;
import mv8.g;
import mv8.h;
import mv8.i;
import mv8.j;
import mv8.l;
import mv8.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J6\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J6\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J(\u0010+\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0014\u0010,\u001a\u0004\u0018\u00010\u00132\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010.\u001a\u00020\u000bH\u0016J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u00100\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u00101\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J&\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010$\u001a\u000203H\u0016J(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010$\u001a\u000203H\u0016J$\u00105\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010$\u001a\u0002032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u0002032\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(0'H\u0016J\u0010\u00109\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\u000eH\u0016J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?H\u0016J\u001f\u0010B\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?2\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010CJ\u001f\u0010D\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?2\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010CJ \u0010E\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000eH\u0016J\u0010\u0010I\u001a\u00020%2\u0006\u0010$\u001a\u000203H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006K"}, d2 = {"Lcom/larus/btm/impl/BTMServiceImpl;", "Lcom/larus/btm/api/IBTMService;", "<init>", "()V", "ecommerceSettingsConfig", "Lcom/larus/platform/model/mainbot/ECommerceSettingsConfig;", "getEcommerceSettingsConfig", "()Lcom/larus/platform/model/mainbot/ECommerceSettingsConfig;", "ecommerceSettingsConfig$delegate", "Lkotlin/Lazy;", "minimizeInit", "", "init", "hostBtmInited", "", "initBtmTracker", "registerHybridContainers", "getHybridContainerClassNames", "", "", "initBcmTracker", "registerBtmPageOnCreate", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "btmPage", "activity", "Landroid/app/Activity;", "unregisterBtmPageOnDestroy", "appendJumpSourceBtmToken", "Landroid/net/Uri;", "url", "btm", "bcm", "Lorg/json/JSONObject;", "Landroidx/fragment/app/FragmentActivity;", "doCreateBtmToken", "pageFinder", "Lcom/bytedance/android/btm/api/model/PageFinder;", "createSourceBtmToken", "", "", "view", "Landroid/view/View;", "createSourceBtmTokenFromJsb", "getBtmShowIdByBtmToken", "btmToken", "initBtmSdk", "sourceBtmToken", "registerBtmPage", "registerBtmView", "createReportParams", "Lcom/larus/btm/api/BtmPageFinder;", "createFullyReportParams", "createJumpSourceBtmToken", "setBcmPageEventParams", "finder", "params", "setInitInActivity", "btmViewHide", "forward", "btmViewShow", "registerBtmDialog", "dialog", "Landroid/app/Dialog;", "unregisterBtmDialog", "showBtmDialog", "hideBtmDialog", "(Landroid/app/Dialog;Ljava/lang/Boolean;)V", "dismissBtmDialog", "setBcmPageParams", "intent", "Landroid/content/Intent;", "clearOldValue", "createPageFinder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BTMServiceImpl implements IBTMService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f319821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f319822c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f319823d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f319824e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f319825a;

    public static final class a {
    }

    static {
        f319821b = CollectionsKt.listOf(new String[]{"com.larus.live.impl.ttlivesdk.OpenLiveDummyActivity", "com.larus.search.impl.WebActivity", "com.bytedance.applet.view.AppletActivity", "com.bytedance.ai.applet.app.AppletAppActivity", "com.bytedance.ai.applet.app.AppletFullScreenActivity", "com.bytedance.android.anniex.container.AnnieXHostActivity", "com.bytedance.locallife.hybrid.page.LifeLynxActivity"});
        f319822c = new AtomicBoolean(false);
        f319823d = new Object();
    }

    @Override // com.larus.btm.api.IBTMService
    public final void init() {
        if (f319822c.compareAndSet(false, true) == true) goto L6;
        FLogger.f375446a.i("BTMServiceImpl", "init ignored, already initialized");
        return;
    L6:
        FLogger r100 = FLogger.f375446a;
        r100.i("BTMServiceImpl", "initBtmTracker invoke");
        BtmSDK r101 = BtmSDK.INSTANCE;
        f r102 = new f();
        AppHost.Companion r103 = AppHost.f326268a;
        r102.f42034a = r103.getApplication();
        r102.f42043j = new String[]{String.valueOf(r103.getAppId())};
        r102.f42048o = r103.getAppId();
        r102.f42045l = o.f365780a.getDeviceId();
        r102.f42035b = r103.isDebug();
        r102.f42046m = r103.getVersionName();
        r102.f42047n = String.valueOf(r103.getUpdateVersionCode());
        r102.f42044k = true;
        r102.f42036c = new g();
        r102.f42039f = new h();
        r102.f42042i = new mv8.a();
        r102.f42041h = new i();
        r102.f42040g = new j();
        r102.f42037d = new l();
        r102.f42038e = new n();
        r101.init(r102);
        d r104 = new d();
        b r105 = com.bytedance.android.bcm.api.b.f41761a;
        BcmHostDependManager.f41760e.getClass();
        c r106 = BcmHostDependManager.f41757b;
        KProperty[] r107 = BcmHostDependManager.f41756a;
        KProperty r108 = r107[0];
        r106.f23359b = null;
        c r109 = BcmHostDependManager.f41758c;
        KProperty r110 = r107[1];
        r109.f23359b = r104;
        c r111 = BcmHostDependManager.f41759d;
        KProperty r112 = r107[2];
        r111.f23359b = null;
        com.bytedance.android.bcm.api.b.f41761a.init();
        mv8.f r113 = new mv8.f();
        Lazy r114 = EcomBcmTracker.f51058a;
        TrackHostDependManager.f51063d.getClass();
        er.c r115 = TrackHostDependManager.f51061b;
        KProperty[] r116 = TrackHostDependManager.f51060a;
        KProperty r117 = r116[0];
        r115.f473573b = r113;
        er.c r118 = TrackHostDependManager.f51062c;
        KProperty r119 = r116[1];
        r118.f473573b = null;
        EcomBcmTracker.i().init();
        r100.i("BTMServiceImpl", "registerHybridContainer invoke");
        BtmHostDependManager r120 = r101.getDepend();
        String[] r121 = new String[4];
        r121[0] = "com.bytedance.applet.view.AppletActivity";
        r121[1] = "com.bytedance.ai.applet.app.AppletAppActivity";
        r121[2] = "com.bytedance.ai.applet.app.AppletFullScreenActivity";
        if (r103.isOversea() == true) goto L9;
        String r122 = "com.bytedance.android.anniex.container.AnnieXHostActivity";
    L10:
        r121[3] = r122;
        List r123 = CollectionsKt.listOfNotNull(r121);
        List<String> r124 = z2.f365865a.Q2();
        LinkedHashSet r125 = new LinkedHashSet();
        r125.addAll(r123);
        r125.addAll(r124);
        List<String> r126 = f319821b;
        ArrayList r127 = new ArrayList();
        Iterator<T> r128 = r126.iterator();
    L12:
        if (r128.hasNext() == false) goto L16;
        Object r129 = r128.next();
        if (r125.remove((String) r129) == false) goto L12;
        r127.add(r129);
        goto L12
    L16:
        Iterator r130 = CollectionsKt.plus(r127, r125).iterator();
    L18:
        if (r130.hasNext() == false) goto L20;
        com.bytedance.android.btm.api.i r131 = new com.bytedance.android.btm.api.i(null, (String) r130.next(), 1);
        r120.getClass();
        BtmHostDependManager.h(r131);
        goto L18
    L20:
        com.bytedance.android.btm.bridge.bullet.support.a r132 = com.bytedance.android.btm.bridge.bullet.support.a.f42083b;
        if (com.bytedance.android.btm.bridge.bullet.support.a.f42082a == true) goto L38;
        CopyOnWriteArrayList<y> r133 = com.bytedance.ies.bullet.core.i.f246510a;     // Catch: Throwable -> L29
        if (r133.contains(r132) == true) goto L27;
        r133.add(r132);     // Catch: Throwable -> L29
    L27:
        com.bytedance.android.btm.bridge.bullet.support.a.f42082a = true;     // Catch: Throwable -> L29
        return;
    L38:
        return;
    L39:
        return;
    L9:
        r122 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [mv8.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.btm.api.IBTMService
    public final void o() {
        if (f319824e == false) goto L5;
        return;
    L5:
        Object r100 = f319823d;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (f319824e == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        IBtmHostDependencyDelegate r101 = IBtmHostDependencyDelegate.f364779b;     // Catch: Throwable -> L14
        r101.a(new mv8.c(this));     // Catch: Throwable -> L14
        r101.minimizeInit(AppHost.f326268a.getApplication());     // Catch: Throwable -> L14
        PageInfoStack.a r102 = PageInfoStack.Companion;     // Catch: Throwable -> L14
        com.bytedance.android.bcm.impl.model.c r103 = com.bytedance.android.bcm.impl.model.c.f41818a;     // Catch: Throwable -> L14
        r102.getClass();     // Catch: Throwable -> L14
        com.bytedance.android.bcm.impl.model.c r104 = com.bytedance.android.bcm.impl.model.c.f41818a;     // Catch: Throwable -> L14
        c r105 = PageInfoStack.access$getPageInfoFactory$cp();     // Catch: Throwable -> L14
        KProperty r106 = PageInfoStack.a.f42329a[0];     // Catch: Throwable -> L14
        r105.f23359b = r104;     // Catch: Throwable -> L14
        f319824e = true;     // Catch: Throwable -> L14
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
    }

    public BTMServiceImpl() {
        this.f319825a = LazyKt.lazy(new mv8.b());
    }

    @Override // com.larus.btm.api.IBTMService
    public final void initBtmSdk() {
        init();
    }

    public static PageFinder r(lv8.a r100) {
        PageFinder r101 = new PageFinder();
        r101.btmPageId = r100.f510973a;
        r101.page = r100.f510974b;
        r101.view = r100.f510975c;
        r101.fragment = r100.f510976d;
        return r101;
    }

    @Override // com.larus.btm.api.IBTMService
    public final void btmViewHide(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        String r101 = BtmViewUtils.f42074a;
        BtmViewUtils.a(r100);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void btmViewShow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        String r101 = BtmViewUtils.f42074a;
        BtmViewUtils.c(r100);
    }

    @Override // com.larus.btm.api.IBTMService
    public final String c(String r100) {
        String r101 = BtmPageRecorder.f42212a;
        return BtmPageRecorder.g(r100);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void f(Fragment r100) {
        if (r100 == null) goto L5;
        BtmSDK.INSTANCE.unregisterPageInstance(r100);
        return;
    }

    @Override // com.larus.btm.api.IBTMService
    public final Map h(Activity r100) {
        Intrinsics.checkNotNullParameter("", "btm");
        if (r100 != null) goto L7;
        return MapsKt.emptyMap();
    L7:
        return BtmSDK.INSTANCE.createReportParams("", PageFinder.via(r100));
    }

    @Override // com.larus.btm.api.IBTMService
    public final void k(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter("a35794.b102518", "btmPage");
        if (r100 == null) goto L6;
        com.bytedance.android.btm.api.a r101 = new com.bytedance.android.btm.api.a(r100, "a35794.b102518", null, 60);
        BtmSDK.INSTANCE.registerBtmPageOnCreate(r101);
        return;
    }

    @Override // com.larus.btm.api.IBTMService
    public final void q(Activity r100) {
        if (r100 == null) goto L5;
        BtmSDK.INSTANCE.unregisterPageInstance(r100);
        return;
    }

    @Override // com.larus.btm.api.IBTMService
    public final void setInitInActivity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        BtmSDK.INSTANCE.setInitInActivity(r100);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void showBtmDialog(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        ad.a.b(r100);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void unregisterBtmDialog(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        int r101 = ad.a.f2930a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.m(r100);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void a(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "btmPage");
        if (r100 == null) goto L6;
        BtmSDK.INSTANCE.registerBtmPageOnCreate(new com.bytedance.android.btm.api.h(r100, r101, null, 60));
        return;
    }

    @Override // com.larus.btm.api.IBTMService
    public final Map<String, Object> b(String r100, lv8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        return BtmSDK.INSTANCE.createReportParams(r100, r(r101));
    }

    @Override // com.larus.btm.api.IBTMService
    public final void btmViewHide(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        String r102 = BtmViewUtils.f42074a;
        BtmViewUtils.b(r100, r101);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void dismissBtmDialog(Dialog r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        ad.a.a(r100, r101);
    }

    @Override // com.larus.btm.api.IBTMService
    public final Map<String, Object> g(String r100, lv8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        return BtmSDK.INSTANCE.createFullyReportParams(r100, r(r101));
    }

    @Override // com.larus.btm.api.IBTMService
    public final void hideBtmDialog(Dialog r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        int r102 = ad.a.f2930a;
        BtmSDK r103 = BtmSDK.INSTANCE;
        r103.getPageLifecycle().c(r100, BtmPageLifecycle.State.PAUSED);
        BtmPageLifecycle.a.a(r103.getPageLifecycle(), r100, r101, 4);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void i(Activity r100, Intent r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "intent");
        Uri r101 = r110.getData();     // Catch: Exception -> L50
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = UriProtector.getQueryParameter(r101, "bcm");     // Catch: Exception -> L50
    L8:
        boolean r104 = true;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
    L24:
        if (r103 != null) goto L26;
    L29:
        boolean r106 = true;
    L30:
        if (r106 == true) goto L32;
    L34:
        if (r103 != null) goto L36;
    L39:
        boolean r111 = true;
    L40:
        if (r111 == true) goto L55;
        String r112 = new JSONObject(r103).optString("bcm_share_id");     // Catch: Exception -> L50
        if (r112 != null) goto L44;
    L47:
        if (r104 == true) goto L56;
        BcmParams r107 = new BcmParams();     // Catch: Exception -> L50
        r107.put("bcm_share_id", r112);     // Catch: Exception -> L50
        b r113 = com.bytedance.android.bcm.api.b.f41761a;     // Catch: Exception -> L50
        com.bytedance.android.bcm.api.b.d(PageFinder.via(r100), r107, false);     // Catch: Exception -> L50
        return;
    L56:
        return;
    L44:
        if (r112.length() == 0) goto L47;
        r104 = false;
        goto L47
    L55:
        return;
    L36:
        if (r103.length() == 0) goto L39;
        r111 = false;
        goto L40
    L32:
        if (r110.hasExtra("bcm") == false) goto L34;
        r103 = r110.getStringExtra("bcm");     // Catch: Exception -> L50
        goto L34
    L26:
        if (r103.length() == 0) goto L29;
        r106 = false;
        goto L30
    L17:
        if (r110.hasExtra("uri_string") == false) goto L24;
        String r108 = r110.getStringExtra("uri_string");     // Catch: Exception -> L50
        if (r108 == null) goto L23;
        Uri r109 = UriProtector.parse(r108);     // Catch: Exception -> L50
        if (r109 == null) goto L23;
        r102 = UriProtector.getQueryParameter(r109, "bcm");     // Catch: Exception -> L50
    L23:
        r103 = r102;
        goto L24
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = null;
    L50:
        e = move-exception;
        FLogger.f375446a.e("BTMServiceImpl", "setBcmPageParams error", e);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void l(lv8.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "finder");
        Intrinsics.checkNotNullParameter(r101, "params");
        PageFinder r102 = r(r100);
        com.bytedance.android.bcm.api.b.f41761a.setPageEventParams(r102, r101);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void registerBtmDialog(Dialog r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "btm");
        int r102 = ad.a.f2930a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.l(r100, r101, false);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void registerBtmView(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        String r102 = BtmViewUtils.f42074a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.k(r100, r101, null);
    }

    @Override // com.larus.btm.api.IBTMService
    public final String d(String r100, Map<String, ? extends Object> r101, View r102) {
        com.bytedance.android.btm.api.model.d r103 = new com.bytedance.android.btm.api.model.d();
        if (r100 == null) goto L5;
        r103.f42022a = r100;
    L5:
        r103.f42023b = PageFinder.via(r102);
        if (r101 == null) goto L9;
        BcmParams.Companion.getClass();
        r103.f42024c = BcmParams.a.c(r101);
    L9:
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r103);
    }

    @Override // com.larus.btm.api.IBTMService
    public final String e(String r100, lv8.a r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        BtmSDK r103 = BtmSDK.INSTANCE;
        PageFinder r104 = r(r101);
        BcmParams.Companion.getClass();
        return r103.createJumpSourceBtmToken(r100, r104, BcmParams.a.b(r102));
    }

    @Override // com.larus.btm.api.IBTMService
    public final String m(String r100, Map<String, ? extends Object> r101, Activity r102) {
        if (r102 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.btm.api.model.d r103 = new com.bytedance.android.btm.api.model.d();
        if (r100 == null) goto L8;
        r103.f42022a = r100;
    L8:
        r103.f42023b = PageFinder.via(r102);
        if (r101 == null) goto L12;
        BcmParams.Companion.getClass();
        r103.f42024c = BcmParams.a.c(r101);
    L12:
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r103);
    }

    @Override // com.larus.btm.api.IBTMService
    public final String n(String r100, JSONObject r101, View r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        BtmSDK r103 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.model.d r104 = new com.bytedance.android.btm.api.model.d();
        r104.f42022a = r100;
        BcmParams.Companion.getClass();
        r104.f42024c = BcmParams.a.b(r101);
        r104.f42023b = PageFinder.via(r102);
        return r103.createJumpSourceBtmTokenForJSB(r104);
    }

    @Override // com.larus.btm.api.IBTMService
    public final boolean registerBtmPage(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        return BtmSDK.INSTANCE.registerBtmPage(r100, r101, r102);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void registerBtmPageOnCreate(Activity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "btmPage");
        BtmSDK.INSTANCE.registerBtmPageOnCreate(r100, r101, r102);
    }

    @Override // com.larus.btm.api.IBTMService
    public final void registerBtmPageOnCreate(Fragment r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "btmPage");
        BtmSDK.INSTANCE.registerBtmPageOnCreate(r100, r101, r102);
    }

    @Override // com.larus.btm.api.IBTMService
    public final Uri j(String r100, String r101, JSONObject r102, Fragment r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        if (r103 == null) goto L5;
        PageFinder r105 = PageFinder.via(r103);
        Intrinsics.checkNotNull(r105);
        com.bytedance.android.btm.api.model.d r106 = new com.bytedance.android.btm.api.model.d();
        if (r101 == null) goto L9;
        r106.f42022a = r101;
    L9:
        r106.f42023b = r105;
        if (r102 == null) goto L12;
        BcmParams.Companion.getClass();
        r106.f42024c = BcmParams.a.b(r102);
    L12:
        String r107 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r106);
        if (o0.d(r107) == false) goto L16;
        r104.appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r107);
    L16:
        return r104.build();
    L5:
        return r104.build();
    }

    @Override // com.larus.btm.api.IBTMService
    public final Uri p(String r100, String r101, JSONObject r102, FragmentActivity r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        if (r103 == null) goto L5;
        PageFinder r105 = PageFinder.via(r103);
        Intrinsics.checkNotNull(r105);
        com.bytedance.android.btm.api.model.d r106 = new com.bytedance.android.btm.api.model.d();
        if (r101 == null) goto L9;
        r106.f42022a = r101;
    L9:
        r106.f42023b = r105;
        if (r102 == null) goto L12;
        BcmParams.Companion.getClass();
        r106.f42024c = BcmParams.a.b(r102);
    L12:
        String r107 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r106);
        if (o0.d(r107) == false) goto L16;
        r104.appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r107);
    L16:
        return r104.build();
    L5:
        return r104.build();
    }
}
