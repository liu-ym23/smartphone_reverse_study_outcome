package com.bytedance.ee.bear.init;

import ak5.f;
import ak5.g;
import android.app.Application;
import androidx.arch.core.executor.ArchTaskExecutor;
import com.bytedance.ee.bear.assemble.OfficeCCMKoinModuleKt;
import com.bytedance.ee.bear.basesdk.apisupport.ISdkClaymoreService;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.container.u;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.office.common.screenmenu.i;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.ee.util.db.SecureTaskExecutor;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okhttp3.h;

/* JADX INFO: loaded from: classes16.dex */
@Singleton
public final class c implements com.bytedance.ee.bear.init.a {

    public static final class a implements nv4.b.a {
        public a() {
        }

        @Override // nv4.b.a
        public final h a() {
            return h.f523873a;
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public c() {
        lk5.b r100 = lk5.d.f509575a;
        i r101 = i.f235226a;
        Intrinsics.checkNotNullParameter(r101, "factory");
        lk5.d.f509575a = r101;
        if (CCMOfficeSDKAssembleFG.b() == false) goto L5;
        ((ISdkClaymoreService) ApiUtils.getApi(ISdkClaymoreService.class)).checkAndInit();
    L63:
        DocOpenConfig.h();     // Catch: Exception -> L57
    L59:
        u.a();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfficeCCMGlobalInitImpl$initDebug$1(null), 2, null);
        return;
    L57:
        e = move-exception;
        tt5.a.e("OfficeCCMGlobalInitImpl", "preload DocOpenConfig failed", e, false);
        goto L59
    L5:
        eu5.b.f474075a = LarkContext.getApplication();
        htb.a.a();
        com.bytedance.ee.bear.assemble.c.a(LarkContext.getApplication());
        Intrinsics.checkNotNullParameter(LarkContext.getApplication(), PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.ee.bear.assemble.c.f206279b.compareAndSet(false, true) == false) goto L34;
        tt5.a.h("KoinInit", "onSetupModules Start");
        hwc.a r102 = hwc.a.f487464a;     // Catch: Throwable -> L33
        org.koin.core.a r103 = hwc.a.a();     // Catch: Throwable -> L33
        r103.c(CollectionsKt.listOf(OfficeCCMKoinModuleKt.f206269a), false);     // Catch: Throwable -> L11
    L13:
        tt5.a.h("KoinInit", "load CommonModule success");     // Catch: Throwable -> L33
        Iterator<T> r104 = OfficeCCMKoinModuleKt.f206270b.iterator();     // Catch: Throwable -> L33
        int r105 = 0;
    L15:
        if (r104.hasNext() == false) goto L20;
        Object r106 = r104.next();     // Catch: Throwable -> L33
        int r107 = r105 + 1;     // Catch: Throwable -> L33
        if (r105 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L19:
        r103.c(CollectionsKt.listOf((kwc.a) r106), false);     // Catch: Throwable -> L33
        r105 = r107;
        goto L15
    L20:
        Iterator<T> r108 = OfficeCCMKoinModuleKt.f206271c.iterator();     // Catch: Throwable -> L33
        int r109 = 0;
    L22:
        if (r108.hasNext() == false) goto L65;
        Object r110 = r108.next();     // Catch: Throwable -> L33
        int r111 = r109 + 1;     // Catch: Throwable -> L33
        if (r109 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L26:
        r103.c(CollectionsKt.listOf((kwc.a) r110), false);     // Catch: Throwable -> L33
        r109 = r111;
        goto L22
    L65:
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L30
        tt5.a.h("KoinInit", "loadLarkDependencyFallbackKoinDefinitions start = " + r112);     // Catch: Throwable -> L30
        OfficeCCMKoinModuleKt.d(r103);     // Catch: Throwable -> L30
        tt5.a.h("KoinInit", "loadLarkDependencyFallbackKoinDefinitions cost = " + (System.currentTimeMillis() - r112));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        tt5.a.e("KoinInit", "load LarkDependencyFallbackModule", th, false);     // Catch: Throwable -> L33
        goto L34
    L11:
        th = move-exception;
        tt5.a.e("KoinInit", "load CommonModule", th, false);     // Catch: Throwable -> L33
    L34:
        g r113 = new g();
        Application r114 = LarkContext.getApplication();
        tt5.a.h("FacadeInit", null);
        eu5.b.f474075a = r114;
        ArchTaskExecutor.getInstance().setDelegate(new SecureTaskExecutor());
        r113.f4014a = r114;
        tt5.a.b("HttpConfig", "configHttpClient start");
        lr5.b.f510406e = r113;
        BearExecutors.a().execute(new f(r113));
        tt5.a.b("HttpConfig", "configHttpClient end");
        rr5.b.f539032a = r113;
        nv4.b.f520864a = new a();
        if (jn4.a.f499726b == true) goto L63;
        Object r115 = jn4.a.f499725a;
        monitor-enter(r115);
    L52:
        th = move-exception;
        throw th;
    L39:
        if (jn4.a.f499726b == true) goto L50;
        Application r116 = LarkContext.getApplication();     // Catch: Throwable -> L52
        com.bytedance.ee.bear.appsetting.c r117 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Throwable -> L52
        r117.a(new jn4.a.C6463a());     // Catch: Throwable -> L52
        if ("release".equals(AppInfoUtils.d(r116)) == true) goto L43;
    L46:
        boolean r118 = true;
    L47:
        if (r118 == false) goto L49;
        r117.a(new fn4.b(LarkContext.getApplication()));     // Catch: Throwable -> L52
    L49:
        r117.a(new fn4.c());     // Catch: Throwable -> L52
        r117.a(new fmb.b());     // Catch: Throwable -> L52
        jn4.a.f499726b = true;     // Catch: Throwable -> L52
        goto L50
    L43:
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L46;
        r118 = false;
    L50:
        monitor-exit(r115);     // Catch: Throwable -> L52
        goto L63
    }
}
