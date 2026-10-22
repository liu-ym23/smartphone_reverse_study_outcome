package com.bytedance.timon.clipboard.suite;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.timon.clipboard.suite.report.ReportHelper;
import com.bytedance.timon.clipboard.suite.storage.ClipboardSuiteStorageHelper;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.b;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache;
import com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import qg7.e;
import sx9.i;

/* JADX INFO: loaded from: classes3.dex */
public final class TimonClipboardSuite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f270586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ClipboardManager f270587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<Boolean> f270588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ClipDescription f270589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ClipData f270590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ClipData f270591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f270592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f270593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Application f270594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static List<String> f270595j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Function2<? super String, ? super String, String> f270596k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TimonClipboardSuite f270597l = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a implements ClipboardManager.OnPrimaryClipChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f270598a = null;

        static {
            f270598a = new a();
        }

        public a() {
        }

        @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
        public final void onPrimaryClipChanged() {
            TimonClipboardSuite.f270597l.getClass();
            if (TimonClipboardSuite.u() == false) goto L5;
        L20:
            int r100 = b.f270799a;
            b.e("ClipboardSuite", "cache isCleared=" + TimonClipboardSuite.u());
            return;
        L5:
            if (Build.VERSION.SDK_INT >= 26) goto L7;
            TimonClipboardSuite.d(null);
            goto L20
        L7:
            ClipDescription r101 = TimonClipboardSuite.n();
            ClipData r102 = TimonClipboardSuite.f270590e;
            if (r102 == null) goto L10;
            ClipDescription r103 = r102.getDescription();
        L11:
            if (r101 == null) goto L13;
            Long r104 = Long.valueOf(r101.getTimestamp());
        L14:
            if (r103 == null) goto L16;
            Long r105 = Long.valueOf(r103.getTimestamp());
        L18:
            if ((!Intrinsics.areEqual(r104, r105)) == false) goto L20;
            TimonClipboardSuite.d(null);
            goto L20
        L16:
            r105 = null;
            goto L18
        L13:
            r104 = null;
            goto L14
        L10:
            r103 = null;
            goto L11
        }
    }

    public TimonClipboardSuite() {
    }

    static {
        f270597l = new TimonClipboardSuite();
        f270586a = CollectionsKt.listOf(new String[]{"email", "phone", "address", "url", "date", SheetInputData.InputData.DateType.DATETIME, "flight"});
        f270595j = CollectionsKt.emptyList();
        f270596k = TimonClipboardSuite$multiThreadStack$1.INSTANCE;
    }

    public static ClipDescription n() {
        b.e("ClipboardSuite", "invoke getSystemDescription");
        ClipboardManager r100 = f270587b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return h(r100);
    }

    public static boolean u() {
        if (f270590e == null) goto L5;
    L7:
        return false;
    L5:
        if (f270589d != null) goto L7;
        return true;
    }

    public final void q() {
        if (f270587b == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L7:
        if (f270587b == null) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (((ITMClipboardSuiteInitService) ServiceManager.get().getService(ITMClipboardSuiteInitService.class)).a() == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        Object r100 = null;
        Application r101 = f270594i;     // Catch: Exception -> L24 Throwable -> L43
        if (r101 == null) goto L18;
        Object r102 = r101.getSystemService(DataType.CLIPBOARD);     // Catch: Exception -> L24 Throwable -> L43
    L20:
        if ((r102 instanceof ClipboardManager) == true) goto L22;
        r102 = null;
    L22:
        f270587b = (ClipboardManager) r102;     // Catch: Exception -> L24 Throwable -> L43
    L46:
        ClipboardManager r103 = f270587b;     // Catch: NullPointerException -> L39 Throwable -> L43
        if (r103 == null) goto L41;
        e(r103);     // Catch: NullPointerException -> L39 Throwable -> L43
        Unit r104 = Unit.INSTANCE;     // Catch: NullPointerException -> L39 Throwable -> L43
    L41:
        monitor-exit(this);
        return;
    L39:
        e = move-exception;
        int r105 = b.f270799a;     // Catch: Throwable -> L43
        b.c("ClipboardSuite", "addPrimaryClipChangedListener NPE " + e.getMessage());     // Catch: Throwable -> L43
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L43
        goto L41
        goto L25
    L18:
        r102 = null;
    L25:
        if (Looper.myLooper() != null) goto L46;
        Looper.prepare();     // Catch: Throwable -> L43
        Application r107 = f270594i;     // Catch: Throwable -> L43
        if (r107 == null) goto L29;
        Object r108 = r107.getSystemService(DataType.CLIPBOARD);     // Catch: Throwable -> L43
    L31:
        if ((r108 instanceof ClipboardManager) == false) goto L34;
        r100 = r108;
    L34:
        f270587b = (ClipboardManager) r100;     // Catch: Throwable -> L43
        goto L46
    L29:
        r108 = null;
        goto L31
    }

    public static void c() {
        if (u() == false) goto L5;
        return;
    L5:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 29) goto L9;
        return;
    L9:
        if (f270593h == true) goto L11;
        return;
    L11:
        f270593h = false;
        b.e("ClipboardSuite", "前台进后台");
        if (u() == false) goto L15;
        Pair r101 = new Pair(Boolean.FALSE, null);
    L34:
        if (((Boolean) r101.getFirst()).booleanValue() == false) goto L37;
        d((ClipDescription) r101.getSecond());
        b.e("ClipboardSuite", "clear cache because other app copied something");
        return;
    L37:
        return;
    L15:
        if (r100 >= 26) goto L17;
        r101 = new Pair(Boolean.TRUE, null);
        goto L34
    L17:
        ClipDescription r102 = f270589d;
        if (r102 != null) goto L24;
        ClipData r103 = f270590e;
        if (r103 == null) goto L23;
        r102 = r103.getDescription();
        goto L24
    L23:
        r102 = null;
    L24:
        if (r102 == null) goto L32;
        ClipDescription r104 = n();
        if (r104 != null) goto L28;
        r101 = new Pair(Boolean.TRUE, null);
        b.e("ClipboardSuite", "content changed: getSystemDescription() == null");
        goto L34
    L28:
        if (r104.getTimestamp() == r102.getTimestamp()) goto L30;
        b.e("ClipboardSuite", "content changed: description.timestamp != preDescription.timestamp");
        r101 = new Pair(Boolean.TRUE, r104);
        goto L34
    L30:
        b.e("ClipboardSuite", "content is same.");
        r101 = new Pair(Boolean.FALSE, null);
        goto L34
    L32:
        r101 = new Pair(Boolean.TRUE, null);
        b.e("ClipboardSuite", "content changed: cachedClipData?.description == null");
        goto L34
    }

    public static boolean s() {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        Class r103 = a(r100[r102].getClassName());     // Catch: ClassNotFoundException -> L7
    L8:
        if (r103 == null) goto L13;
        if (TextView.class.isAssignableFrom(r103) == false) goto L13;
        b.e("ClipboardSuite", "paste from TextView");
        return true;
    L13:
        r102 = r102 + 1;
    L7:
        r103 = null;
        goto L8
    L14:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void d(ClipDescription r100) {
        f270589d = null;
        f270590e = null;
        if (r100 == null) goto L5;
        f270589d = r100;
    L5:
        rg7.a.f537716e.clear();
    }

    public static void e(ClipboardManager r110) {
        a r100 = a.f270598a;
        ArrayList r101 = new ArrayList();
        Object[] r102 = {r100};
        f06.b r111 = new f06.b();
        g06.a r103 = ApiHookConfig.f245611b.get(101801);
        if (r103 == null) goto L5;
        f06.a[] r104 = r103.f479473i;
    L6:
        f06.a[] r112 = r104;
        int r105 = r112.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r112[r106];
        int r113 = r106;
        int r114 = r105;
        f06.a[] r115 = r112;
        d r108 = r107.preInvoke(101801, "android/content/ClipboardManager", "addPrimaryClipChangedListener", r110, r102, "void", r111);     // Catch: Exception -> L21
        if (r108.f474982a == true) goto L17;
        r101.add(r107);     // Catch: Exception -> L21
    L17:
        if (r108.f474982a == false) goto L19;
        return;
    L19:
        r110.addPrimaryClipChangedListener(r100);
        return;
    L14:
        r106 = r113 + 1;
        r105 = r114;
        r112 = r115;
        goto L8
    L15:
        r108 = new d(false, null);
        goto L17
    L5:
        r104 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void f(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101800);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(101800, "android/content/ClipboardManager", "clearPrimaryClip", r110, r111, "void", r112);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        r110.clearPrimaryClip();
        return;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static ClipData g(ClipboardManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    public static ClipDescription h(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101809);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r110, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (ClipDescription) r106.f474983b;
    L21:
        return r110.getPrimaryClipDescription();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean i(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101805);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.hasPrimaryClip();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void p(Application r100) {
        if (f270594i == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        f270594i = r100;
        if (rg7.a.f537714c != null) goto L27;
        b.f("从 ConfigProvider 中获取配置失败");
        JsonObject r102 = null;
        rg7.b r103 = rg7.a.d(null);
        if (r103 != null) goto L14;
        r103 = rg7.a.d(rg7.a.a());
    L14:
        if (r103 != null) goto L23;
        Function0<JsonObject> r104 = rg7.a.f537715d;
        if (r104 == null) goto L19;
        r102 = r104.invoke();
    L19:
        if (r102 == null) goto L21;
        b.f("从 defaultConfigProvider 中获取配置成功");
    L22:
        r103 = rg7.a.d(r102);
        goto L23
    L21:
        b.f("从 defaultConfigProvider 中获取配置失败");
    L23:
        if (r103 != null) goto L26;
        r103 = rg7.a.f537713b;
    L26:
        rg7.a.f537714c = r103;
    L27:
        ScenesDetector.f270874j.j(r100);
        com.bytedance.timonbase.scene.a r105 = ScenesDetector.f270869e;
        if (r105 == null) goto L31;
        r105.a(TimonClipboardSuite$init$1.INSTANCE);
        return;
    L31:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final synchronized ClipDescription k(String r100) {
        monitor-enter(this);
        rg7.b r101 = rg7.a.f537714c;     // Catch: Throwable -> L25
        if (r101 == null) goto L8;
        int r102 = r101.b();     // Catch: Throwable -> L25
        if (((rg7.a.b(r100).d() | r102) & 8) == 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L14;
        ClipDescription r104 = n();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r104;
    L14:
        if (f270589d != null) goto L22;
        ClipboardManager r105 = f270587b;     // Catch: Throwable -> L25
        if (r105 == null) goto L18;
        ClipDescription r106 = h(r105);     // Catch: Throwable -> L25
    L19:
        if (r106 == null) goto L22;
        f270589d = r106;     // Catch: Throwable -> L25
        goto L22
    L18:
        r106 = null;
    L22:
        ClipDescription r107 = f270589d;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r107;
    L8:
        r103 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public final Long o(String r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        ClipDescription r101 = k(r100);
        if (r101 == null) goto L7;
        return Long.valueOf(r101.getTimestamp());
    L7:
        return null;
    }

    public static void j(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void r(Function1 r100, String r101) {
        Unit r102 = (Unit) r100.invoke(r101);
    }

    public static boolean v(ClipData r100, ClipData r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        if (r100.getItemCount() == r110.getItemCount()) goto L7;
        return false;
    L7:
        int r101 = r100.getItemCount();
        int r102 = 0;
    L8:
        boolean r103 = true;
        if (r102 >= r101) goto L67;
        ClipData.Item r104 = r100.getItemAt(r102);
        ClipData.Item r105 = r110.getItemAt(r102);
        if (r104 == null) goto L66;
        CharSequence r106 = r104.getText();
        Intent r107 = null;
        if (r106 == null) goto L15;
        String r108 = r106.toString();
    L16:
        if (r105 == null) goto L20;
        CharSequence r109 = r105.getText();
        if (r109 == null) goto L20;
        String r111 = r109.toString();
    L22:
        if (Intrinsics.areEqual(r108, r111) == false) goto L63;
        String r112 = r104.getHtmlText();
        if (r105 == null) goto L26;
        String r113 = r105.getHtmlText();
    L28:
        if (Intrinsics.areEqual(r112, r113) == false) goto L63;
        Uri r114 = r104.getUri();
        if (r105 == null) goto L32;
        Uri r115 = r105.getUri();
    L34:
        if (Intrinsics.areEqual(r114, r115) == false) goto L63;
        if (r104.getIntent() != null) goto L43;
        if (r105 == null) goto L39;
        Intent r116 = r105.getIntent();
    L40:
        if (r116 == null) goto L43;
    L59:
        boolean r117 = false;
    L61:
        if (r117 == false) goto L63;
    L64:
        if (r103 == true) goto L66;
        return false;
    L39:
        r116 = null;
    L43:
        if (r104.getIntent() == null) goto L50;
        if (r105 == null) goto L46;
        Intent r118 = r105.getIntent();
    L47:
        if (r118 != null) goto L50;
    L46:
        r118 = null;
    L50:
        if (r104.getIntent() == null) goto L60;
        if (r105 == null) goto L53;
        r107 = r105.getIntent();
    L53:
        if (r107 == null) goto L60;
        if (r104.getIntent().getExtras() != null) goto L59;
        if (r105.getIntent().getExtras() != null) goto L59;
        r117 = r104.getIntent().filterEquals(r105.getIntent());
    L60:
        r117 = true;
        goto L61
    L32:
        r115 = null;
        goto L34
    L26:
        r113 = null;
    L63:
        r103 = false;
    L20:
        r111 = null;
        goto L22
    L15:
        r108 = null;
    L66:
        r102 = r102 + 1;
        goto L8
    L67:
        return true;
    }

    public final ClipData l(TokenCert r110, Function1 r111) {
        if (r110 == null) goto L5;
        Cert r100 = r110;
    L6:
        String r101 = sg7.a.f541845a.get(101803);
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        ReportHelper.b r102 = new ReportHelper.b(r101, r100, 101803, 15935);
        boolean r103 = TMEnv.f270767a;
        r102.f270601b.m(1);
        q();
        if (f270587b != null) goto L13;
        r102.f270601b.g(-6009);
        int r104 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: TimonClipboardSuite not init yet");
    L329:
        return null;
    L13:
        rg7.c r105 = rg7.a.f537712a;
        String r106 = r100.certToken();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        rg7.b r107 = rg7.a.f537714c;
        boolean r112 = false;
        if (r107 != null) goto L20;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L25;
    L33:
        int r109 = qg7.d.f532876a;
        qg7.b r113 = qg7.d.a(r100, TimonClipboardSuite$getPrimaryClip$fastPassResult$1.INSTANCE);
        if (r113.f532871a == false) goto L36;
        r102.f270601b.g(r113.f532874d);
        r102.f270601b.h();
        int r114 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r113);
        goto L329
    L36:
        String r115 = r100.certToken();
        if (r115 != null) goto L40;
        r115 = "";
    L40:
        rg7.b r116 = rg7.a.f537714c;
        if (r116 != null) goto L43;
    L46:
        boolean r117 = true;
    L47:
        if (r117 == true) goto L55;
        boolean r118 = ScenesDetector.f270865a;
        if (ScenesDetector.g() == false) goto L55;
        String r119 = r100.certToken();
        if (r119 != null) goto L54;
        r119 = "";
    L54:
        qg7.b r120 = new qg7.b(true, "Can't read clipboard in basic model", r119, -6006);
        r102.f270601b.g(-6006);
        int r121 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r120);
    L55:
        qg7.b r122 = qg7.a.a(r100, "clipboard_getClip", 101803);
        if (r122.f532871a == false) goto L58;
        r102.f270601b.g(r122.f532874d);
        int r123 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r122);
        goto L329
    L58:
        Function0<Boolean> r124 = f270588c;
        if (r124 == null) goto L63;
        Boolean r125 = r124.invoke();
        if (r125 == null) goto L63;
        boolean r126 = r125.booleanValue();
    L64:
        if (r126 == true) goto L77;
        String r127 = r100.certToken();
        if (r127 != null) goto L69;
        r127 = "";
    L69:
        rg7.b r128 = rg7.a.f537714c;
        if (r128 != null) goto L72;
    L74:
        boolean r129 = false;
    L75:
        if (r129 == true) goto L77;
        r102.f270601b.g(-6004);
        int r130 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: auto read clipboard toggle closed");
        goto L329
    L72:
        if (((rg7.a.b(r127).d() | r128.b()) & 2) == 0) goto L74;
        r129 = true;
    L77:
        qg7.b r131 = e.a(101803, r100);
        if (r131.f532871a == false) goto L80;
        r102.f270615p = r131;
        r102.f270601b.g(r131.f532874d);
        int r132 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r131);
        goto L329
    L80:
        c();
        int r133 = Build.VERSION.SDK_INT;
        if (r133 < 26) goto L102;
        Lazy r134 = ClipboardSuiteStorageHelper.f270616a;
        String r135 = r100.certToken();
        if (r135 != null) goto L86;
        b.a("ClipboardSuite", "getLastWriteTimestamp token is null ");
    L90:
        Long r136 = null;
    L91:
        if (r136 == null) goto L102;
        long r137 = r136.longValue();
        String r138 = r100.certToken();
        if (r138 != null) goto L96;
        r138 = "";
    L96:
        Long r139 = o(r138);
        if (r139 == null) goto L102;
        if (r137 != r139.longValue()) goto L102;
        boolean r140 = false;
    L103:
        if (r140 == true) goto L128;
        String r141 = r100.certToken();
        if (r141 != null) goto L108;
        r141 = "";
    L108:
        rg7.b r142 = rg7.a.f537714c;
        if (r142 != null) goto L112;
        r142 = new rg7.b(0);
    L112:
        int r143 = r142.b();
        rg7.c r144 = rg7.a.c(r141);
        if (r144 == null) goto L115;
        Integer r145 = Integer.valueOf(r144.d());
    L116:
        if (r145 == null) goto L122;
        if (r144.d() == 0) goto L122;
        r143 = r144.d();
    L122:
        if ((r143 & 1024) == 0) goto L124;
        boolean r146 = true;
    L125:
        if (r146 == false) goto L127;
        r102.f270601b.g(-6013);
        int r147 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        goto L329
    L127:
        r102.f270601b.o(Boolean.TRUE);
    L129:
        String r148 = r100.certToken();
        if (r148 != null) goto L133;
        r148 = "";
    L133:
        Long r149 = o(r148);
        if (r149 == null) goto L163;
        long r150 = r149.longValue();
        String r151 = r100.certToken();
        if (r151 != null) goto L139;
        r151 = "";
    L139:
        rg7.b r152 = rg7.a.f537714c;
        if (r152 != null) goto L143;
        r152 = new rg7.b(0);
    L143:
        int r153 = r152.b();
        rg7.c r154 = rg7.a.c(r151);
        if (r154 == null) goto L146;
        Integer r155 = Integer.valueOf(r154.d());
    L147:
        if (r155 == null) goto L153;
        if (r154.d() == 0) goto L153;
        r153 = r154.d();
    L153:
        if ((r153 & 512) == 0) goto L155;
        boolean r156 = true;
    L156:
        if (r156 == true) goto L163;
        Lazy r157 = ClipboardSuiteStorageHelper.f270616a;
        String r158 = r100.certToken();
        if (r158 != null) goto L161;
        r158 = "";
    L161:
        ((IStoreRepo) ClipboardSuiteStorageHelper.f270616a.getValue()).putLong(r158, r150);
        goto L163
    L155:
        r156 = false;
        goto L156
    L146:
        r155 = null;
    L163:
        if (r133 < 31) goto L226;
        String r159 = "";
        String r160 = r100.certToken();
        if (r160 != null) goto L169;
        r160 = "";
    L169:
        ClipDescription r161 = k(r160);
        if (r161 == null) goto L226;
        if (r161.getClassificationStatus() != 3) goto L226;
        ArrayList r162 = new ArrayList();
        String r163 = r100.certToken();
        if (r163 != null) goto L178;
        r163 = "";
    L178:
        rg7.c r164 = rg7.a.b(r163);
        if (r164.b() != 0.0f) goto L181;
        float r165 = 1.0f;
    L182:
        JSONObject r166 = new JSONObject();
        Iterator<T> r167 = f270586a.iterator();
    L184:
        if (r167.hasNext() == false) goto L189;
        String r168 = (String) r167.next();
        float r169 = r161.getConfidenceScore(r168);
        r166.putOpt(r168, Float.valueOf(r169));
        if (r169 < r165) goto L184;
        r162.add(r168);
        goto L184
    L189:
        StringBuilder r170 = new StringBuilder();
        Iterator r171 = r162.iterator();
    L191:
        if (r171.hasNext() == false) goto L200;
        String r172 = (String) r171.next();
        if (r170.length() <= 0) goto L195;
        boolean r173 = true;
    L196:
        if (r173 == false) goto L198;
        String r174 = ",";
    L199:
        r170.append(r174);
        r170.append(r172);
        goto L191
    L198:
        r174 = "";
        goto L199
    L195:
        r173 = false;
        goto L196
    L200:
        String r175 = r170.toString();
        r102.f270601b.k(r175);
        r102.f270601b.l(r166.toString());
        int r176 = b.f270799a;
        b.e("ClipboardSuite", "except " + r164.c() + ", matched " + r175);
        rg7.c r177 = rg7.a.f537712a;
        String r178 = r100.certToken();
        if (r178 != null) goto L204;
        r178 = "";
    L204:
        rg7.b r179 = rg7.a.f537714c;
        if (r179 == null) goto L213;
        int r180 = r179.b();
        rg7.c r181 = rg7.a.b(r178);
        if (r181.c().isEmpty() == true) goto L213;
        if (((r181.d() | r180) & 4) != 0) goto L213;
        boolean r182 = false;
    L214:
        if (r182 == true) goto L226;
        Iterator<T> r183 = r164.c().iterator();
        boolean r184 = true;
    L217:
        if (r183.hasNext() == false) goto L221;
        if (r162.contains((String) r183.next()) == true) goto L217;
        r184 = false;
        goto L217
    L221:
        if (r184 == true) goto L226;
        r102.f270601b.g(-6005);
        int r185 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        StringBuilder r186 = new StringBuilder("Error: ");
        String r187 = "content not matched patterns, except " + CollectionsKt.sorted(r164.c()) + ", matched " + CollectionsKt.sorted(r162);
        String r188 = r100.certToken();
        if (r188 == null) goto L225;
        r159 = r188;
    L225:
        r186.append(new qg7.b(true, r187, r159, -6005));
        r(r111, r186.toString());
        boolean r189 = true;
    L227:
        if (r189 == true) goto L329;
        if (u() == true) goto L243;
        rg7.c r190 = rg7.a.f537712a;
        String r191 = r100.certToken();
        if (r191 != null) goto L236;
        r191 = "";
    L236:
        if ((rg7.a.b(r191).d() & 256) != 0) goto L238;
    L240:
        boolean r192 = false;
    L241:
        if (r192 == false) goto L243;
        r102.f270601b.g(-6012);
        int r193 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error:duplicate read interception");
        goto L329
    L238:
        if (rg7.a.f537716e.containsKey(r191) == false) goto L240;
        r192 = true;
    L243:
        rg7.c r194 = rg7.a.f537712a;
        String r195 = r100.certToken();
        if (r195 != null) goto L247;
        r195 = "";
    L247:
        rg7.b r196 = rg7.a.f537714c;
        if (r196 != null) goto L250;
    L252:
        boolean r197 = false;
    L253:
        int r198 = b.f270799a;
        b.e("ClipboardSuite", "cache was disabled=" + r197);
        String r199 = "";
        String r200 = r100.certToken();
        if (r200 != null) goto L257;
        r200 = "";
    L257:
        ClipDescription r201 = k(r200);
        if (r201 == null) goto L327;
        if (r201.getMimeTypeCount() <= 0) goto L267;
        StringBuilder r1100 = new StringBuilder();
        int r1101 = r201.getMimeTypeCount();
        int r1102 = 0;
    L262:
        if (r1102 >= r1101) goto L266;
        if (r1102 == 0) goto L265;
        r1100.append("_");
    L265:
        r1100.append(r201.getMimeType(r1102));
        r1102 = r1102 + 1;
        goto L262
    L266:
        String r1103 = r1100.toString();
    L268:
        int r1104 = b.f270799a;
        b.e("ClipboardSuite", "mimeType " + r1103);
        r102.f270601b.j(r1103);
        if (r201.getMimeTypeCount() <= 0) goto L327;
        rg7.c r1105 = rg7.a.f537712a;
        String r1106 = r100.certToken();
        if (r1106 != null) goto L275;
        r1106 = "";
    L275:
        rg7.b r1107 = rg7.a.f537714c;
        if (r1107 != null) goto L279;
        r1107 = new rg7.b(0);
    L279:
        int r1108 = r1107.b();
        rg7.c r1109 = rg7.a.c(r1106);
        if (r1109 == null) goto L282;
        Integer r1110 = Integer.valueOf(r1109.d());
    L283:
        if (r1110 == null) goto L289;
        if (r1109.d() == 0) goto L289;
        r1108 = r1109.d();
    L289:
        if ((r1108 & 4096) == 0) goto L291;
        boolean r1111 = true;
    L293:
        if (r1111 == true) goto L295;
    L297:
        String r1112 = r100.certToken();
        if (r1112 == null) goto L300;
        r199 = r1112;
    L300:
        rg7.b r1113 = rg7.a.f537714c;
        if (r1113 != null) goto L304;
        r1113 = new rg7.b(0);
    L304:
        int r1114 = r1113.b();
        rg7.c r202 = rg7.a.c(r199);
        if (r202 == null) goto L307;
        Integer r1115 = Integer.valueOf(r202.d());
    L308:
        if (r1115 == null) goto L314;
        if (r202.d() == 0) goto L314;
        r1114 = r202.d();
    L314:
        if ((r1114 & 2048) == 0) goto L316;
        boolean r1116 = true;
    L317:
        if (r1116 == false) goto L327;
        Iterator r1117 = CollectionsKt.listOf("text/*").iterator();
    L320:
        if (r1117.hasNext() == false) goto L324;
        if (r201.hasMimeType((String) r1117.next()) == false) goto L320;
    L324:
        t(r102, r111, r1103, r100, 2048);
    L325:
        boolean r1118 = true;
    L328:
        if (r1118 == true) goto L329;
        if (f270590e == null) goto L335;
        if (r197 == true) goto L335;
        b.e("ClipboardSuite", "read from cache");
        r102.f270601b.e();
        r102.f270601b.i("1");
        r102.f270601b.p(1);
        ClipData r203 = f270590e;
    L334:
        ClipData r204 = r203;
        ReportHelper.a r205 = r102.f270601b;
        String r206 = r100.certToken();
        if (r206 != null) goto L354;
        r206 = "";
    L354:
        r205.r(o(r206));
        int r207 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        StringBuilder r208 = new StringBuilder("Success: FastPass=");
        r208.append(r113);
        r208.append(", Cert=");
        r208.append(r122);
        r208.append(", \n FromCache=");
        Integer r209 = r102.f270601b.b();
        if (r209 != null) goto L358;
    L360:
        boolean r1119 = false;
    L361:
        r208.append(r1119);
        r(r111, r208.toString());
        rg7.c r210 = rg7.a.f537712a;
        String r211 = r100.certToken();
        if (r211 != null) goto L366;
        r211 = "";
    L366:
        if ((rg7.a.b(r211).d() & 256) == 0) goto L393;
        rg7.a.f537716e.put(r211, 1);
        return r204;
    L393:
        return r204;
    L358:
        if (r209.intValue() != 1) goto L360;
        r1119 = true;
    L335:
        monitor-enter(this);
    L370:
        th = move-exception;
        throw th;
    L337:
        if (f270590e == null) goto L340;
        if (r197 == true) goto L340;
        b.e("ClipboardSuite", "read from cache_");     // Catch: Throwable -> L370
        r102.f270601b.e();     // Catch: Throwable -> L370
        r102.f270601b.i("1");     // Catch: Throwable -> L370
        r102.f270601b.p(1);     // Catch: Throwable -> L370
        r203 = f270590e;     // Catch: Throwable -> L370
    L348:
        monitor-exit(this);
    L340:
        f270597l.getClass();     // Catch: Throwable -> L370
        r203 = b(r197, r100, r102);     // Catch: Throwable -> L370
        ReportHelper.a r212 = r102.f270601b;     // Catch: Throwable -> L370
        int r213 = ReportHelper.f270599a;     // Catch: Throwable -> L370
        if (r203 == null) goto L343;
        boolean r1120 = true;
    L344:
        if (r1120 == false) goto L346;
        String r214 = "1";
    L347:
        r212.i(r214);     // Catch: Throwable -> L370
        goto L348
    L346:
        r214 = "0";
        goto L347
    L343:
        r1120 = false;
        goto L344
    L316:
        r1116 = false;
        goto L317
    L307:
        r1115 = null;
        goto L308
    L295:
        if (ClipDescription.compareMimeTypes(r201.getMimeType(0), "text/*") == true) goto L297;
        t(r102, r111, r1103, r100, 4096);
        goto L325
    L291:
        r1111 = false;
        goto L293
    L282:
        r1110 = null;
        goto L283
    L267:
        r1103 = "";
    L327:
        r1118 = false;
        goto L328
    L250:
        if (((rg7.a.b(r195).d() | r196.b()) & 8) == 0) goto L252;
        r197 = true;
    L213:
        r182 = true;
        goto L214
    L181:
        r165 = r164.b();
    L226:
        r189 = false;
        goto L227
    L124:
        r146 = false;
        goto L125
    L115:
        r145 = null;
        goto L116
    L128:
        r102.f270601b.o(Boolean.FALSE);
        goto L129
    L86:
        long r1121 = -1;
        long r1122 = ((IStoreRepo) ClipboardSuiteStorageHelper.f270616a.getValue()).getLong(r135, r1121);
        if (r1122 == r1121) goto L89;
        r136 = Long.valueOf(r1122);
        goto L91
    L89:
        b.a("ClipboardSuite", "getLastReadTimestamp timestamp is null ");
    L102:
        r140 = true;
    L63:
        r126 = false;
        goto L64
    L43:
        if (((rg7.a.b(r115).d() | r116.b()) & 32) != 0) goto L46;
        r117 = false;
        goto L47
    L25:
        if (s() == false) goto L33;
        ClipData r215 = b(true, r100, r102);
        ReportHelper.a r216 = r102.f270601b;
        int r217 = ReportHelper.f270599a;
        if (r215 == null) goto L29;
        r112 = true;
    L29:
        if (r112 == false) goto L31;
        String r218 = "1";
    L32:
        r216.i(r218);
        r102.f270601b.s(1);
        ReportHelper.b(r102);
        r(r111, "Success: Read from View pass.");
        return r215;
    L31:
        r218 = "0";
        goto L32
    L20:
        if (((rg7.a.b(r106).d() | r107.b()) & 64) == 0) goto L22;
        r108 = true;
        goto L23
    L5:
        r100 = pg7.a.a();
        goto L6
    }

    public final ClipDescription m(TokenCert r110, i r111) {
        if (r110 != null) goto L5;
        Cert r112 = pg7.a.a();
    L5:
        String r100 = sg7.a.f541845a.get(101809);
        String r101 = "";
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        ReportHelper.b r102 = new ReportHelper.b(r100, r112, 101809, 15935);
        boolean r103 = true;
        r102.f270601b.m(1);
        q();
        if (f270587b != null) goto L14;
        r102.f270601b.g(-6009);
        int r113 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: TimonClipboardSuite not init yet");
        return null;
    L14:
        if (s() == false) goto L17;
        r102.f270601b.s(1);
        int r114 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Success: Read from View pass.");
        return n();
    L17:
        int r104 = qg7.d.f532876a;
        qg7.b r105 = qg7.d.a(r112, TimonClipboardSuite$getPrimaryClipDescription$fastPassResult$1.INSTANCE);
        if (r105.f532871a == false) goto L21;
        r102.f270601b.g(r105.f532874d);
        r102.f270601b.h();
        int r115 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Success: method=getPrimaryClipDescription, " + r105);
        return null;
    L21:
        rg7.c r106 = rg7.a.f537712a;
        String r107 = r112.certToken();
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        rg7.b r108 = rg7.a.f537714c;
        if (r108 != null) goto L28;
    L31:
        boolean r109 = true;
    L33:
        if (r109 == true) goto L41;
        boolean r116 = ScenesDetector.f270865a;
        if (ScenesDetector.g() == false) goto L41;
        String r117 = r112.certToken();
        if (r117 == null) goto L39;
        r101 = r117;
    L39:
        qg7.b r118 = new qg7.b(true, "Can't read clipboard in basic model", r101, -6006);
        r102.f270601b.g(-6006);
        int r119 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r118);
        return null;
    L41:
        qg7.b r120 = qg7.a.a(r112, "clipboard_getDescription", 101809);
        if (r120.f532871a == false) goto L45;
        r102.f270601b.g(r120.f532874d);
        int r121 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r120.f532872b);
        return null;
    L45:
        qg7.b r122 = e.a(101809, r112);
        if (r122.f532871a == false) goto L49;
        r102.f270615p = r122;
        r102.f270601b.g(r122.f532874d);
        int r123 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        r(r111, "Error: " + r122);
        return null;
    L49:
        c();
        String r124 = r112.certToken();
        if (r124 == null) goto L52;
        r101 = r124;
    L52:
        ClipDescription r125 = k(r101);
        int r126 = ReportHelper.f270599a;
        ReportHelper.b(r102);
        StringBuilder r127 = new StringBuilder("Success:\nFastPass=");
        r127.append(r105);
        r127.append(", \n Cert=");
        r127.append(r120);
        r127.append(", \n FromCache=");
        if (r125 != null) goto L56;
        r103 = false;
    L56:
        r127.append(r103);
        r(r111, r127.toString());
        return r125;
    L28:
        if (((rg7.a.b(r107).d() | r108.b()) & 32) != 0) goto L31;
        r109 = false;
        goto L33
    }

    public static ClipData b(boolean r100, Cert r101, ReportHelper.b r110) {
        ClipDescription r102 = null;
        if (r100 == false) goto L18;
        ClipboardManager r103 = f270587b;
        if (r103 != null) goto L41;
    L10:
        ClipData r104 = null;
    L11:
        ClipData r105 = f270590e;
        if (r105 == null) goto L25;
        f270597l.getClass();
        boolean r106 = v(r105, r104);
        ReportHelper.a r111 = r110.f270601b;
        if (r106 == false) goto L16;
        int r107 = 1;
    L17:
        r111.f(r107);
        int r112 = b.f270799a;
        b.e("ClipboardSuite", "content is same:" + r106);
        Unit r113 = Unit.INSTANCE;
        goto L25
    L16:
        r107 = 0;
    L25:
        if (r104 == null) goto L27;
        r102 = r104.getDescription();
    L27:
        f270589d = r102;
        f270590e = r104;
        Lazy r114 = TMSensitiveContentCacheManager.f270900a;
        ISensitiveContentCache r115 = (ISensitiveContentCache) ((ConcurrentHashMap) TMSensitiveContentCacheManager.f270900a.getValue()).get(ISensitiveContentCache.Type.CLIPBOARD);
        if (r115 == null) goto L40;
        ClipData r108 = f270590e;
        if (r108 == null) goto L40;
        int r109 = r108.getItemCount();
        int r116 = 0;
    L32:
        if (r116 >= r109) goto L40;
        ClipData.Item r117 = r108.getItemAt(r116);
        if (r117 == null) goto L38;
        CharSequence r118 = r117.getText();
        if (r118 == null) goto L38;
        r118.toString();
        MapsKt.mapOf(new Pair[]{TuplesKt.to(LocationMonitorConst.BPEA_CERT_TOKEN, r101.certToken()), TuplesKt.to("disable_cache", Boolean.valueOf(r100))});
        r115.a();
    L38:
        r116 = r116 + 1;
    L40:
        return f270590e;
    L41:
        r104 = g(r103);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L18:
        ClipboardManager r119 = f270587b;
        if (r119 != null) goto L43;
    L24:
        r104 = null;
        goto L25
    L43:
        r104 = g(r119);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static void t(ReportHelper.b r100, Function1 r101, String r102, Cert r103, int r104) {
        StringBuilder r105 = new StringBuilder("Error: ");
        String r106 = "content contains intercept mime type, type: " + r102 + ", reason: " + r104;
        String r107 = r103.certToken();
        if (r107 != null) goto L6;
        r107 = "";
    L6:
        r105.append(new qg7.b(true, r106, r107, -6014));
        r(r101, r105.toString());
        r100.f270601b.g(-6014);
        int r108 = ReportHelper.f270599a;
        ReportHelper.b(r100);
    }
}
