package com.bytedance.caijing.sdk.infra.base.impl.bpea;

import android.app.Activity;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202370a = 0;

    public static final class a {
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

        public static void b(Activity r110, String[] r111, TokenCert r112, com.bytedance.caijing.sdk.infra.base.impl.bpea.a r113) {
            Class r100 = a("com.bytedance.ies.ezpermission.EzPermission");     // Catch: Exception -> L4
            Class r101 = a("com.bytedance.ies.ezpermission.core.EzPermissionRequestBuilder");     // Catch: Exception -> L4
            Class<?> r102 = a("com.bytedance.ies.ezpermission.core.PermissionResultListener");     // Catch: Exception -> L4
            Method r103 = r100.getDeclaredMethod("with", new Class[]{Activity.class, Cert.class});     // Catch: Exception -> L4
            Method r104 = r101.getDeclaredMethod(ComplianceResult.JsonKey.PERMISSIONS, new Class[]{new List[]{ArraysKt.toList(r111)}.getClass()});     // Catch: Exception -> L4
            Method r105 = r101.getDeclaredMethod("request", new Class[]{r102});     // Catch: Exception -> L4
            Constructor r106 = r100.getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L4
            r106.setAccessible(true);     // Catch: Exception -> L4
            r105.invoke(r104.invoke(r103.invoke(r106.newInstance(new Object[0]), new Object[]{r110, r112}), new Object[]{new List[]{ArraysKt.toList(r111)}}), new Object[]{Proxy.newProxyInstance(r102.getClassLoader(), new Class[]{r102}, r113)});     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }
}
