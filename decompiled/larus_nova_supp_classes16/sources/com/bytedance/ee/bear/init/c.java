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
import com.bytedance.lark.lark_markdown_render_android.BuildConfig;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okhttp3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Singleton
public final class c implements com.bytedance.ee.bear.init.a {

    public static final class a implements nv4.b.a {
        public a() {
        }

        @Override // nv4.b.a
        public final h a() {
            return h.a;
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public c() {
        lk5.b r0 = lk5.d.a;
        i r1 = i.a;
        Intrinsics.checkNotNullParameter(r1, "factory");
        lk5.d.a = r1;
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
        eu5.b.a = LarkContext.getApplication();
        htb.a.a();
        com.bytedance.ee.bear.assemble.c.a(LarkContext.getApplication());
        Intrinsics.checkNotNullParameter(LarkContext.getApplication(), "context");
        if (com.bytedance.ee.bear.assemble.c.b.compareAndSet(false, true) == false) goto L34;
        tt5.a.h("KoinInit", "onSetupModules Start");
        hwc.a r4 = hwc.a.a;     // Catch: Throwable -> L33
        org.koin.core.a r5 = hwc.a.a();     // Catch: Throwable -> L33
        r5.c(CollectionsKt.listOf(OfficeCCMKoinModuleKt.a), false);     // Catch: Throwable -> L11
    L13:
        tt5.a.h("KoinInit", "load CommonModule success");     // Catch: Throwable -> L33
        Iterator r6 = OfficeCCMKoinModuleKt.b.iterator();     // Catch: Throwable -> L33
        int r7 = 0;
    L15:
        if (r6.hasNext() == false) goto L20;
        Object r8 = r6.next();     // Catch: Throwable -> L33
        int r9 = r7 + 1;     // Catch: Throwable -> L33
        if (r7 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L19:
        r5.c(CollectionsKt.listOf((kwc.a) r8), false);     // Catch: Throwable -> L33
        r7 = r9;
        goto L15
    L20:
        Iterator r10 = OfficeCCMKoinModuleKt.c.iterator();     // Catch: Throwable -> L33
        int r11 = 0;
    L22:
        if (r10.hasNext() == false) goto L65;
        Object r12 = r10.next();     // Catch: Throwable -> L33
        int r13 = r11 + 1;     // Catch: Throwable -> L33
        if (r11 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L26:
        r5.c(CollectionsKt.listOf((kwc.a) r12), false);     // Catch: Throwable -> L33
        r11 = r13;
        goto L22
    L65:
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L30
        tt5.a.h("KoinInit", "loadLarkDependencyFallbackKoinDefinitions start = " + r14);     // Catch: Throwable -> L30
        OfficeCCMKoinModuleKt.d(r5);     // Catch: Throwable -> L30
        tt5.a.h("KoinInit", "loadLarkDependencyFallbackKoinDefinitions cost = " + (System.currentTimeMillis() - r14));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        tt5.a.e("KoinInit", "load LarkDependencyFallbackModule", th, false);     // Catch: Throwable -> L33
        goto L34
    L11:
        th = move-exception;
        tt5.a.e("KoinInit", "load CommonModule", th, false);     // Catch: Throwable -> L33
    L34:
        g r2 = new g();
        Application r16 = LarkContext.getApplication();
        tt5.a.h("FacadeInit", null);
        eu5.b.a = r16;
        ArchTaskExecutor.getInstance().setDelegate(new SecureTaskExecutor());
        r2.a = r16;
        tt5.a.b("HttpConfig", "configHttpClient start");
        lr5.b.e = r2;
        BearExecutors.a().execute(new f(r2));
        tt5.a.b("HttpConfig", "configHttpClient end");
        rr5.b.a = r2;
        nv4.b.a = new a();
        if (jn4.a.b == true) goto L63;
        Object r3 = jn4.a.a;
        monitor-enter(r3);
    L52:
        th = move-exception;
        throw th;
    L39:
        if (jn4.a.b == true) goto L50;
        Application r17 = LarkContext.getApplication();     // Catch: Throwable -> L52
        com.bytedance.ee.bear.appsetting.c r18 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Throwable -> L52
        r18.a(new jn4.a.a());     // Catch: Throwable -> L52
        if (BuildConfig.BUILD_TYPE.equals(AppInfoUtils.d(r17)) == true) goto L43;
    L46:
        boolean r19 = true;
    L47:
        if (r19 == false) goto L49;
        r18.a(new fn4.b(LarkContext.getApplication()));     // Catch: Throwable -> L52
    L49:
        r18.a(new fn4.c());     // Catch: Throwable -> L52
        r18.a(new fmb.b());     // Catch: Throwable -> L52
        jn4.a.b = true;     // Catch: Throwable -> L52
        goto L50
    L43:
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L46;
        r19 = false;
    L50:
        monitor-exit(r3);     // Catch: Throwable -> L52
        goto L63
    }
}
