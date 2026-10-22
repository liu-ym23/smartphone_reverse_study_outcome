package com.bytedance.ee.bear.bitable.anniex.env;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.log.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f206714b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f206715a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.anniex.env.a$a, reason: collision with other inner class name */
    public static final class C2982a {
    }

    public static final class b implements LynxDevtoolCardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f206716a = null;

        static {
            f206716a = new b();
        }

        public b() {
        }

        @Override // com.lynx.devtoolwrapper.LynxDevtoolCardListener
        public final void open(String r100) {
            int r101 = a.f206714b;
            tt5.a.h("BitableLynxDebugger", "open url: " + r100);
        }
    }

    static {
    }

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.lynx.devtool.LynxGlobalDebugBridge");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.lynx.devtool.LynxGlobalDebugBridge");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.lynx.devtool.LynxGlobalDebugBridge");
    }

    public final String c() {
        String r100 = ((zm4.b) org.koin.java.a.c(zm4.b.class, null, null, 6)).getGeckoConfig().a();
        Application r101 = eu5.b.f474075a;
        StringBuilder r102 = new StringBuilder("gecko_build_in");
        String r103 = File.separator;
        r102.append(r103);
        r102.append(r100);
        r102.append(r103);
        r102.append("bitable_lynx_channel");
        String r104 = r102.toString();
        Intrinsics.checkNotNull(r101);
        return r104 + r103 + e(r101, r104) + r103 + "res";
    }

    public final String d() {
        String r100 = this.f206715a;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final void f() {
        Object r100 = BitableLynxEnv.f206706a;
        BitableLynxEnv.a(eu5.b.f474075a);
        if (((Boolean) new ml5.b("debug_config").a("lynx_bitable_enable_proxy", Boolean.FALSE)).booleanValue() == true) goto L10;
        return;
    L10:
        Class r101 = a();     // Catch: Throwable -> L7
        Method r102 = r101.getMethod("getInstance", new Class[0]);     // Catch: Throwable -> L7
        Field r103 = r101.getDeclaredField("mCardListeners");     // Catch: Throwable -> L7
        r103.setAccessible(true);     // Catch: Throwable -> L7
        Object r104 = r103.get(r102.invoke(null, new Object[0]));     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.Set<com.lynx.devtoolwrapper.LynxDevtoolCardListener>");     // Catch: Throwable -> L7
        ((Set) r104).clear();     // Catch: Throwable -> L7
        LynxDevtoolGlobalHelper.getInstance().registerCardListener(b.f206716a);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.d(tt5.a.a(""), "BitableLynxDebugger", th);
    }

    public final String b() {
        String r100 = this.f206715a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return r100;
    L11:
        Application r102 = eu5.b.f474075a;
        String r103 = ((zm4.b) org.koin.java.a.c(zm4.b.class, null, null, 6)).getGeckoConfig().a();
        StringBuilder r104 = new StringBuilder("gecko_build_in");
        String r105 = File.separator;
        r104.append(r105);
        r104.append(r103);
        r104.append(r105);
        r104.append("bitable_lynx_channel");
        String r106 = r104.toString();
        Intrinsics.checkNotNull(r102);
        String r107 = r106 + r105 + e(r102, r106) + r105 + ChameleonResConstants.TEMPLATE_VERSION;
        tt5.a.b("BitableLynxDebugger", "getBuildInLynxVersion, revisionPath:" + r107);
        InputStream r108 = r102.getAssets().open(r107);     // Catch: IOException -> L29
        BufferedReader r109 = new BufferedReader(new InputStreamReader(r108));     // Catch: IOException -> L29
    L13:
        String r110 = r109.readLine();     // Catch: IOException -> L29
        if (r110 == null) goto L27;
        tt5.a.h("BitableLynxDebugger", "getBuildInLynxVersion, read line:" + r110);     // Catch: IOException -> L29
        if (StringsKt.startsWith$default(r110, "version:", false, 2, null) != true) goto L18;
        boolean r111 = true;
    L19:
        if (r111 == false) goto L13;
        String r112 = StringsKt.substringAfter$default(r110, "version:", null, 2, null);     // Catch: IOException -> L29
        if (r112 == null) goto L24;
        String r113 = StringsKt.trim(r112).toString();     // Catch: IOException -> L29
        if (r113 == null) goto L24;
    L25:
        this.f206715a = r113;     // Catch: IOException -> L29
        return r113;
    L24:
        r113 = "";
        goto L25
    L18:
        r111 = false;
        goto L19
    L27:
        r109.close();     // Catch: IOException -> L29
        r108.close();     // Catch: IOException -> L29
    L31:
        return "";
    L29:
        e = move-exception;
        tt5.a.e("BitableLynxDebugger", "getBuildInLynxVersion, error", e, false);
        goto L31
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "debuggerServer");
        Object r101 = BitableLynxEnv.f206706a;
        BitableLynxEnv.a(eu5.b.f474075a);
        if (StringsKt.contains$default(r100, "remote_debug_lynx", false, 2, null) == false) goto L8;
        LynxDevtoolGlobalHelper r102 = LynxDevtoolGlobalHelper.getInstance();
        if (r102.shouldPrepareRemoteDebug(r100) == true) goto L7;
        return false;
    L7:
        return r102.prepareRemoteDebug(r100);
    L8:
        String r103 = UriProtector.parse(r100).getEncodedAuthority();
        ml5.b r104 = new ml5.b("debug_config");
        String r105 = "";
        String r106 = (String) r104.a("lynx_bitable_proxy_ip", "");
        if (r103 == null) goto L12;
        r105 = r103;
    L12:
        boolean r107 = new Regex("^\\d+\\.\\d+\\.\\d+\\.\\d+:\\d+$").matches(r105);
        tt5.a.h("BitableLynxDebugger", "checkAndUpdateLocalIp, localIp:" + r106 + ", remoteIp:" + r103 + ", hostIsIp:" + r107);
        if (TextUtils.equals(r106, r103) == true) goto L19;
        if (r107 == false) goto L20;
        tt5.a.h("BitableLynxDebugger", "checkAndUpdateLocalIp, update localIp:" + r103);
        r104.b("lynx_bitable_proxy_ip", r103);
        return true;
    L20:
        return true;
    L19:
        return true;
    }

    public static Long e(Context r100, String r101) {
        String[] r102 = r100.getAssets().list(r101);
        Long r103 = null;
        if (r102 == null) goto L7;
        int r104 = r102.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        String r106 = r102[r105];
        Intrinsics.checkNotNull(r106);
        r103 = Long.valueOf(CastLongProtector.parseLong(r106));
        r105 = r105 + 1;
    L7:
        return r103;
    }
}
