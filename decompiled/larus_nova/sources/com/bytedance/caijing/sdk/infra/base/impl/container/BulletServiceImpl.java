package com.bytedance.caijing.sdk.infra.base.impl.container;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import cd4.q;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess;
import com.bytedance.android.anniex.lite.flow.base.dispatch.FlowTaskType;
import com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.caijing.sdk.infra.base.api.container.IBulletService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.y;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\"\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/BulletServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/container/IBulletService;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "CJTag", "Lcd4/e;", "getBulletHelper", "Lcd4/c;", "getAnnieXRouterHelper", "Landroid/net/Uri;", "schema", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "cacheTime", "Lcd4/f;", "callback", "", "preRender", "Landroid/app/Activity;", "activity", "Lcom/bytedance/caijing/sdk/infra/base/api/container/IBulletService$a;", "Landroid/app/Application;", "application", "bid", "anniexDispatchFlow", "Lcd4/q;", "getStorageHelper", "<init>", "()V", "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final class BulletServiceImpl implements IBulletService, ICJTag {

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a implements cd4.c {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class b implements cd4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Class<?>, q26.g<?>> f202371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BulletServiceImpl f202372b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f202373a = null;

            static {
                int[] r100 = new int[KitType.values().length];
                r100[KitType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[KitType.LYNX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[KitType.RN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f202373a = r100;
            }
        }

        @Override // cd4.e
        public final String a() {
            XCoreBridgeMethod r100 = (XCoreBridgeMethod) g(XCoreBridgeMethod.class);     // Catch: Throwable -> L48
            if (r100 == null) goto L8;
            m16.b r101 = (m16.b) r100.provideContext(m16.b.class);     // Catch: Throwable -> L48
            if (r101 == null) goto L8;
            h16.e r102 = (h16.e) r101.c(h16.e.class);     // Catch: Throwable -> L48
        L9:
            if (r102 == null) goto L13;
            o r103 = r102.getKitView();     // Catch: Throwable -> L48
            if (r103 == null) goto L13;
            KitType r104 = r103.getKitType();     // Catch: Throwable -> L48
        L14:
            if (r104 != null) goto L16;
            int r105 = -1;
        L18:
            if (r105 != 1) goto L20;
            if (r102 == null) goto L40;
            o r106 = r102.getKitView();     // Catch: Throwable -> L48
            if (r106 == null) goto L40;
            View r107 = r106.realView();     // Catch: Throwable -> L48
        L42:
            if ((r107 instanceof WebView) == false) goto L44;
            WebView r108 = (WebView) r107;     // Catch: Throwable -> L48
        L45:
            if (r108 != null) goto L47;
            return null;
        L47:
            return r108.getUrl();
        L44:
            r108 = null;
        L40:
            r107 = null;
            goto L42
        L20:
            if (r105 != 2) goto L22;
            if (r102 == null) goto L55;
            BulletContext r109 = r102.getBulletContext();     // Catch: Throwable -> L48
            if (r109 == null) goto L56;
            a36.a r110 = r109.f246449q;     // Catch: Throwable -> L48
            if (r110 != null) goto L58;
            return null;
        L58:
            return r110.b();
        L56:
            return null;
        L55:
            return null;
        L22:
            if (r105 != 3) goto L50;
            if (r102 == null) goto L51;
            BulletContext r111 = r102.getBulletContext();     // Catch: Throwable -> L48
            if (r111 == null) goto L52;
            a36.a r112 = r111.f246449q;     // Catch: Throwable -> L48
            if (r112 != null) goto L54;
            return null;
        L54:
            return r112.b();
        L52:
            return null;
        L51:
            return null;
        L50:
            return null;
        L16:
            r105 = a.f202373a[r104.ordinal()];     // Catch: Throwable -> L48
        L13:
            r104 = null;
        L8:
            r102 = null;
            goto L9
        L60:
            return null;
        }

        @Override // cd4.e
        public final com.bytedance.caijing.sdk.infra.base.impl.container.c b() {
            return new com.bytedance.caijing.sdk.infra.base.impl.container.c(this, this.f202372b);
        }

        @Override // cd4.e
        public final id4.c d() {
            XCoreBridgeMethod r100 = (XCoreBridgeMethod) g(XCoreBridgeMethod.class);
            if (r100 == null) goto L7;
            m16.b r101 = (m16.b) r100.provideContext(m16.b.class);
            if (r101 == null) goto L7;
            return (id4.c) r101.c(id4.c.class);
        L7:
            return null;
        }

        @Override // cd4.e
        public final gd4.a f() {
            XCoreBridgeMethod r100 = (XCoreBridgeMethod) g(XCoreBridgeMethod.class);
            if (r100 == null) goto L7;
            m16.b r101 = (m16.b) r100.provideContext(m16.b.class);
            if (r101 == null) goto L7;
            return (gd4.a) r101.c(gd4.a.class);
        L7:
            return null;
        }

        @Override // cd4.e
        public final com.bytedance.caijing.sdk.infra.base.impl.container.a getContainerAbility() {
            return new com.bytedance.caijing.sdk.infra.base.impl.container.a(this);
        }

        @Override // cd4.e
        public final com.bytedance.caijing.sdk.infra.base.impl.container.b getContainerContext() {
            return new com.bytedance.caijing.sdk.infra.base.impl.container.b(this);
        }

        @Override // cd4.e
        public final com.bytedance.caijing.sdk.infra.base.impl.container.d getEvent() {
            return new com.bytedance.caijing.sdk.infra.base.impl.container.d(this);
        }

        @Override // cd4.e
        public final f getKitView() {
            return new f(this);
        }

        @Override // cd4.e
        public final gd4.b getPageConfig() {
            XCoreBridgeMethod r100 = (XCoreBridgeMethod) g(XCoreBridgeMethod.class);
            if (r100 == null) goto L7;
            m16.b r101 = (m16.b) r100.provideContext(m16.b.class);
            if (r101 == null) goto L7;
            return (gd4.b) r101.c(gd4.b.class);
        L7:
            return null;
        }

        @Override // cd4.e
        public final g getWebView() {
            return new g(this);
        }

        @Override // cd4.e
        public final Context provideContext() {
            XCoreBridgeMethod r100 = (XCoreBridgeMethod) g(XCoreBridgeMethod.class);
            if (r100 == null) goto L9;
            m16.b r101 = (m16.b) r100.provideContext(m16.b.class);
            if (r101 == null) goto L9;
            m16.c r102 = r101.a(Context.class);
            if (r102 == null) goto L9;
            return (Context) r102.provideInstance();
        L9:
            return null;
        }

        public b(BulletServiceImpl r100) {
            this.f202372b = r100;
            this.f202371a = new ConcurrentHashMap();
        }

        @Override // cd4.e
        public final void c(boolean r100) {
            XCoreBridgeMethod r101 = (XCoreBridgeMethod) g(XCoreBridgeMethod.class);
            if (r101 == null) goto L7;
            m16.b r102 = (m16.b) r101.provideContext(m16.b.class);
            if (r102 == null) goto L7;
            h16.e r103 = (h16.e) r102.c(h16.e.class);
        L8:
            if (r103 == null) goto L12;
            h16.d r104 = r103.getActivityWrapper();
            if (r104 == null) goto L12;
            r104.finish();
        L12:
            if (r100 == false) goto L20;
            if (r103 == null) goto L21;
            h16.d r105 = r103.getActivityWrapper();
            if (r105 == null) goto L22;
            Activity r106 = r105.getActivity();
            if (r106 == null) goto L23;
            r106.overridePendingTransition(0, 0);
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        L7:
            r103 = null;
            goto L8
        }

        public final <T> T g(Class<T> r100) {
            q26.g<?> r101 = this.f202371a.get(r100);
            if (r101 == null) goto L13;
            Object r102 = r101.provideInstance();
            if (r102 != null) goto L7;
            return null;
        L7:
            if (r100.isAssignableFrom(r102.getClass()) == true) goto L10;
            r102 = null;
        L10:
            if (r102 != null) goto L12;
            return null;
        L12:
            return (T) r102;
        L13:
            return null;
        }

        @Override // cd4.e
        public final void e(Class r100, IXPayBaseMethod r101) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            if (r101 == null) goto L5;
            this.f202371a.put(r100, new s26.c(r101));
            return;
        L5:
            this.f202371a.put(r100, new s26.c(null));
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class c implements y {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f202374a = null;

            static {
                int[] r100 = new int[PoolResult.values().length];
                r100[PoolResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[PoolResult.FAIL_EXISTS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[PoolResult.FAIL_LOAD_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[PoolResult.FAIL_INVALID.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[PoolResult.FAIL_EXCEPTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f202374a = r100;
            }
        }

        public c() {
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            throw null;
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void a(PoolResult r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            int r102 = a.f202374a[r100.ordinal()];
            if (r102 == 1) goto L15;
            if (r102 == 2) goto L15;
            if (r102 == 3) goto L15;
            if (r102 == 4) goto L15;
            if (r102 == 5) goto L15;
            throw new NoWhenBranchMatchedException();
        L15:
            throw null;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class d implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBulletService.a f202375a;

        public d(IBulletService.a r100) {
            this.f202375a = r100;
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            this.f202375a.onSuccess();
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void a(PoolResult r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            IBulletService.a r102 = this.f202375a;
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r102.onFail(r101);
        }
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "BulletServiceImpl";
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService
    public cd4.c getAnnieXRouterHelper() {
        return new a();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService
    public cd4.e getBulletHelper() {
        return new b(this);
    }

    public BulletServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService
    public q getStorageHelper() {
        return if4.a.f489574a;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService
    public String anniexDispatchFlow(Application r110, String r111, Uri r112) {
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r112, "schema");
        com.bytedance.android.anniex.assemble.a r100 = com.bytedance.android.anniex.assemble.a.f40251a;
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r112, "schema");
        int r101 = com.bytedance.android.anniex.lite.flow.a.f40917a;
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r112, "schema");
        String r102 = w36.a.a(r112, "__x_session_id");
        if (r102 != null) goto L5;
        r102 = UUID.randomUUID().toString();
    L5:
        Uri r103 = r112.buildUpon().appendQueryParameter("__x_session_id", r102).build();
        Intrinsics.checkNotNullParameter("default_bid", "bid");
        Intrinsics.checkNotNullParameter(r103, "schema");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Lazy<SchemaService> r104 = SchemaService.f248116f;
        SchemaService r105 = SchemaService.a.a();
        com.bytedance.ies.bullet.service.sdk.c r106 = new com.bytedance.ies.bullet.service.sdk.c();
        r106.a(new u36.b(new Bundle()));
        r106.a(new s36.a());
        r106.a(new o26.a("default_bid"));
        r106.a(new e16.a());
        Unit r107 = Unit.INSTANCE;
        r105.a(r103, r106);
        String r108 = com.bytedance.android.anniex.lite.c.a("default_bid", r103, r102).f544443a.c().get("url");
        if (r108 != null) goto L8;
    L11:
        boolean r109 = true;
    L12:
        if (r109 == true) goto L14;
        r112 = UriProtector.parse(r108);
    L14:
        KitType r113 = com.bytedance.android.anniex.lite.utils.c.a(r112);
        int r114 = com.bytedance.android.anniex.lite.flow.a.C0760a.f40918a[r113.ordinal()];
        if (r114 != 1) goto L17;
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r112, "uri");
        if (com.bytedance.android.anniex.lite.flow.base.a.f40919a.a(r102) == null) goto L25;
    L27:
        return r102;
    L25:
        if (SwitchCenter.a(r112) == true) goto L27;
        AnnieXWebDispatchManager r115 = new AnnieXWebDispatchManager(r111, r102);
        r115.f(new oa.b(FlowTaskType.RouterInitTask, r111, r102, r112));
        r115.f(new oa.b(FlowTaskType.EnginePreloadTask, r111, r102, r112));
        goto L27
    L17:
        if (r114 != 2) goto L27;
        r100.c(r110);
        AnnieXServiceCenter.f40313a.getClass();
        IAnnieXLynxProcess r116 = (IAnnieXLynxProcess) AnnieXServiceCenter.d(r111, IAnnieXLynxProcess.class);
        if (r116 == null) goto L27;
        r116.o0();
        goto L27
    L8:
        if (r108.length() == 0) goto L11;
        r109 = false;
        goto L12
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService
    public void preRender(String r100, Activity r110, long r111, IBulletService.a r112) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = CJSchemaExtensionKt.getQueryParameter(r100, "bid");
        String r102 = "default_bid";
        if (r101 != null) goto L5;
    L8:
        Uri r103 = UriProtector.parse(r100);
        Map<String, Map<Class<?>, Object>> r104 = x26.a.f562251a;
        a0 r105 = (a0) x26.a.b(r102, a0.class);
        if (r105 == null) goto L12;
        r105.e(r103, r110, r111, new d(r112));
        return;
    L12:
        return;
    L5:
        if (StringsKt.isBlank(r101) == false) goto L7;
        r101 = "default_bid";
    L7:
        r102 = r101;
        goto L8
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService
    public void preRender(Uri r100, Context r101, long r102, cd4.f r110) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "callback");
        Map<String, Map<Class<?>, Object>> r111 = x26.a.f562251a;
        a0 r103 = (a0) x26.a.b("default_bid", a0.class);
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102, new c());
        return;
    }
}
