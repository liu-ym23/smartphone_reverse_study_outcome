package com.obric.aiagent.assistant.utils;

import android.app.role.RoleManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f384613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f384614b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f384615c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f384616d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f384617e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f384618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CoroutineScope f384619g = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrivacyApprovalStatus f384620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f384621b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f384620a == r101.f384620a) goto L12;
            return false;
        L12:
            if (this.f384621b == r101.f384621b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f384620a.hashCode() * 31;
            long r101 = this.f384621b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "CachedStatus(status=" + this.f384620a + ", timestamp=" + this.f384621b + ')';
        }

        public a(PrivacyApprovalStatus r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "status");
            this.f384620a = r100;
            this.f384621b = r101;
        }
    }

    public b() {
    }

    static {
        f384613a = new b();
        f384614b = UriProtector.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider");
        f384615c = UriProtector.parse("content://com.larus.nova.privacy.provider/status");
        f384616d = "android.permission.MANAGE_ROLE_HOLDERS";
        f384617e = "sys.debug.doubao.obric_fake_default_assist";
        f384618f = new a(PrivacyApprovalStatus.CannotObtain, -1);
        f384619g = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String d(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return "";
    L5:
        RoleManager r100 = (RoleManager) r110.getSystemService("role");
        if (r100 != null) goto L8;
        return null;
    L8:
        String r101 = f384617e;
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = "false";
        Intrinsics.checkNotNullParameter("false", "defaultValue");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Class r104 = a();     // Catch: Throwable -> L11
        Object r105 = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r104, new Object[]{r101, "false"});     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L11
        Object r106 = Result.m9449constructorimpl((String) r105);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r102 = r106;
    L18:
        if (Intrinsics.areEqual("true", (String) r102) == false) goto L46;
        return "com.larus.nova";
    L46:
    L43:
        e = move-exception;
        e.getMessage();
    L45:
        return null;
    L22:
        if (r100.isRoleAvailable("android.app.role.ASSISTANT") == true) goto L24;
        return "";
    L24:
        if (c(r110, f384616d) != 0) goto L26;
        Method r111 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L37 SecurityException -> L39
        r111.setAccessible(true);     // Catch: Exception -> L37 SecurityException -> L39
        Object r112 = r111.invoke(r100, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L37 SecurityException -> L39
        if ((r112 instanceof List) == false) goto L30;
        List r113 = (List) r112;     // Catch: Exception -> L37 SecurityException -> L39
    L31:
        if (r113 == null) goto L51;
        String r114 = (String) CollectionsKt.getOrNull(r113, 0);     // Catch: Exception -> L37 SecurityException -> L39
        if (r114 != null) goto L36;
        return "";
    L36:
        return r114;
    L51:
        return "";
    L30:
        r113 = null;
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L43
    L37:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L43
        goto L45
    L26:
        return null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static int c(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_obric_aiagent_assistant_utils_ObricAppStatusUtility_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
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
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112, CancellationSignal r113) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null, r113};
        f06.b r114 = new f06.b();
        f06.d r115 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r114);
        if (r115.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r114, false);
        return (Cursor) r115.f474983b;
    L6:
        Cursor r116 = r110.query(r111, r112, null, null, null, r113);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r116, r114, true);
        return r116;
    }
}
