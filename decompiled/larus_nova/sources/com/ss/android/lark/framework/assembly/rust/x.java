package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.tool.v1.OnlineScenario;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class x implements te6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0c.c f425717a;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Future<Map<String, String>> f425718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f425719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f425720c;

        public b(Future<Map<String, String>> r100, Ref.IntRef r101, long r102) {
            this.f425718a = r100;
            this.f425719b = r101;
            this.f425720c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map<String, String> r100 = this.f425718a.get();     // Catch: Throwable -> L4
            opb.e r101 = opb.e.a.f524824a;     // Catch: Throwable -> L4
            int r102 = this.f425719b.element;     // Catch: Throwable -> L4
            long r103 = this.f425720c;     // Catch: Throwable -> L4
            r101.getClass();     // Catch: Throwable -> L4
            opb.e.f(r102, true, r103, r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f425721a;

        public c(Ref.IntRef r100) {
            this.f425721a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            opb.e r100 = opb.e.a.f524824a;     // Catch: Throwable -> L4
            int r101 = this.f425721a.element;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            opb.e.f(r101, false, 0, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ te6.c f425722a;

        public d(te6.c r100) {
            this.f425722a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            opb.e r100 = opb.e.a.f524824a;     // Catch: Throwable -> L4
            te6.c r101 = this.f425722a;     // Catch: Throwable -> L4
            r100.g(r101.f545586g, r101.f545580a, r101.f545581b, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ te6.c f425723a;

        public e(te6.c r100) {
            this.f425723a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Map<String, String> call() {
            ppb.a.InterfaceC7225a r100 = ((ppb.a) ApiUtils.getApi(ppb.a.class)).getFeatureGatingDependency();
            te6.c r101 = this.f425723a;
            String r102 = r101.f545580a;
            Map<String, String> r103 = r101.f545586g;
            ((LarkSettingModuleDependency.a) r100).getClass();
            return idb.f.a().getChangedKeysBySyncUpdate(r102, r103);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Inject
    public x(l0c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "userFlowMonitor");
        this.f425717a = r100;
    }

    /* JADX INFO: renamed from: onNext, reason: avoid collision after fix types in other method */
    public void onNext2(te6.c r110) {
        Intrinsics.checkNotNullParameter(r110, "t");
        Log.i("RustOnlineResponseObserver", "onNext start");
        long r100 = System.currentTimeMillis();
        gpb.a r101 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        IUserListService r102 = (IUserListService) e0c.k.a(LarkContext.getApplication(), IUserListService.class);
        this.f425717a.a(String.valueOf(r110.f545585f.getValue()));
        if (r110.f545583d == true) goto L6;
        Log.i("RustOnlineResponseObserver", "onNext failed");
        return;
    L6:
        StringBuilder r103 = new StringBuilder("now isForeground: ");
        r103.append(r110.f545581b);
        r103.append(", online uid: ");
        r103.append(r110.f545580a);
        r103.append(", global uid: ");
        User r104 = r102.getForegroundUser();
        String r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.userId;
    L10:
        r103.append(r106);
        Log.i("RustOnlineResponseObserver", r103.toString());
        if (r110.f545581b == false) goto L13;
        r102.q();
    L13:
        StringBuilder r107 = new StringBuilder("then global uid: ");
        User r108 = r102.getForegroundUser();
        if (r108 == null) goto L16;
        String r109 = r108.userId;
    L17:
        r107.append(r109);
        Log.i("RustOnlineResponseObserver", r107.toString());
        DomainSettings r111 = r110.f545584e;
        if (r111 == null) goto L53;
        if (r110.f545581b == false) goto L28;
        Log.i("RustOnlineResponseObserver", "sync execute start, before domain update.");
        LinkedHashMap r112 = new LinkedHashMap();
        List<DomainSettings.Pair> r113 = r111.pairs;
        if (r113 == null) goto L27;
        Iterator<DomainSettings.Pair> r114 = r113.iterator();
    L25:
        if (r114.hasNext() == false) goto L27;
        DomainSettings.Pair r115 = r114.next();
        r112.put(r115.alias_str, r115.domains);
    L27:
        jcb.b.c().h0(r112);
        Log.i("RustOnlineResponseObserver", "sync execute finish.");
        Log.i("RustOnlineResponseObserver", "updateDomainSettings from rust online response for foreground user.");
    L28:
        InitSDKRequest.EnvV2 r116 = r110.f545582c;
        if (r116 == null) goto L33;
        InitSDKRequest.EnvV2.Type r117 = r116.type;
        if (r117 == null) goto L33;
        InitSDKRequest.EnvType r118 = InitSDKRequest.EnvType.fromValue(r117.getValue());
    L34:
        InitSDKRequest.EnvV2 r119 = r110.f545582c;
        if (r119 == null) goto L37;
        String r120 = r119.unit;
    L38:
        if (r119 == null) goto L40;
        r105 = r119.brand;
    L40:
        IDomainConfigService r121 = jcb.b.c();
        String r122 = r110.f545580a;
        if (r118 != null) goto L43;
        r118 = InitSDKRequest.EnvType.fromValue(r101.envType());
    L43:
        InitSDKRequest.EnvType r123 = r118;
        if (r120 != null) goto L46;
        r120 = r101.getUserUnit();
    L46:
        String r124 = r120;
        if (r105 != null) goto L49;
        r105 = r101.getTenantBrand();
    L49:
        r121.K0(r122, r123, r124, r105, r110.f545584e);
        if (r110.f545581b == false) goto L53;
        Log.i("RustOnlineResponseObserver", "updateFastDomainCache, after domain update");
        gcb.a.b();
        goto L53
    L37:
        r120 = null;
    L33:
        r118 = null;
    L53:
        if (CollectionUtils.isNotEmpty(r110.f545586g) == false) goto L71;
        OnlineScenario r125 = r110.f545585f;
        if (r125 != OnlineScenario.FIRST_TIME_LOGIN) goto L57;
    L60:
        boolean r126 = true;
    L61:
        Log.i("RustOnlineResponseObserver", "updateAppSettings, isSyncUpdate: " + r126 + ", OnlineScenario: " + r110.f545585f);
        if (r126 == false) goto L70;
        Ref.IntRef r127 = new Ref.IntRef();
        if (r110.f545585f != OnlineScenario.VERSION_CHANGED) goto L73;
        r127.element = 1;
    L73:
        Future r128 = CoreThreadPool.getDefault().getFixedThreadPool().submit(new e(r110));     // Catch: Exception -> L68
        long r129 = System.currentTimeMillis();     // Catch: Exception -> L68
        opb.e.a.f524824a.g(r110.f545586g, r110.f545580a, r110.f545581b, true);     // Catch: Exception -> L68
        long r130 = System.currentTimeMillis() - r129;     // Catch: Exception -> L68
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r128, r127, r130));     // Catch: Exception -> L68
        Log.i("RustOnlineResponseObserver", "updateAppSettings success, syncCost: " + r130);     // Catch: Exception -> L68
    L68:
        e = move-exception;
        Log.e("RustOnlineResponseObserver", "updateAppSettings error", e);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r127));
        goto L71
    L70:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(r110));
        goto L71
    L57:
        if (r125 == OnlineScenario.VERSION_CHANGED) goto L60;
        r126 = false;
    L71:
        Log.i("RustOnlineResponseObserver", "onNext finish, cost: " + (System.currentTimeMillis() - r100));
        return;
    L16:
        r109 = null;
        goto L17
    L9:
        r106 = null;
        goto L10
    }

    @Override // io.reactivex.Observer
    public final /* bridge */ /* synthetic */ void onNext(te6.c r100) {
        onNext2(r100);
    }
}
