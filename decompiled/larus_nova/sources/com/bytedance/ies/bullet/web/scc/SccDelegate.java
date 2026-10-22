package com.bytedance.ies.bullet.web.scc;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.lynx.scc.cloudservice.network.DefaultNetAdapter;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import n07.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class SccDelegate {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f248341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function2<? super String, ? super JSONObject, Unit> f248342c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n07.a f248343a;

    public static final class a implements o07.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x06.a f248344a;

        public a(x06.a r100) {
            this.f248344a = r100;
        }

        @Override // o07.b
        public final <T> T create(String r100, Class<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "baseUrl");
            Intrinsics.checkNotNullParameter(r101, "api");
            return (T) this.f248344a.create(r100, r101);
        }
    }

    public static final class b implements p07.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f248345a = null;

        static {
            f248345a = new b();
        }

        public b() {
        }

        @Override // p07.a
        public final void a(String r100, Map<String, String> r101) {
            JSONObject r102 = new JSONObject();
            Iterator r103 = ((HashMap) r101).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            Map.Entry r104 = (Map.Entry) r103.next();
            r102.put((String) r104.getKey(), (String) r104.getValue());
            goto L4
        L6:
            Function2<? super String, ? super JSONObject, Unit> r105 = SccDelegate.f248342c;
            if (r105 == null) goto L11;
            r105.invoke(r100, r102);
            return;
        }
    }

    public static final class c {
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.common.lib.AppLogNewUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.common.lib.AppLogNewUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.common.lib.AppLogNewUtils");
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f248343a.b(StringsKt.substringBefore$default(r100, '#', null, 2, null));
    }

    public final WebResourceResponse c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        String r101 = StringsKt.substringBefore$default(r100, '#', null, 2, null);
        d r102 = this.f248343a.c(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        String r103 = r102.f516591c;
        if (r103 == null) goto L29;
        if (Intrinsics.areEqual("black", r103) == false) goto L10;
    L16:
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.f("SccDelegate", "scc_sdk " + r101 + " is notice.", null, 12);
        n07.a r105 = this.f248343a;
        r105.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L24;
        ArrayList<String> r106 = r105.f516582b;
        monitor-enter(r106);
        r105.f516582b.add(r101);     // Catch: Throwable -> L25
        monitor-exit(r106);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L24:
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    L10:
        if (Intrinsics.areEqual("notice", r103) == true) goto L16;
        if (Intrinsics.areEqual("deny", r103) == false) goto L29;
        this.f248343a.a(r101);
        HybridLogger r107 = HybridLogger.f246343a;
        HybridLogger.f("SccDelegate", "scc_sdk " + r101 + " is deny.", null, 12);
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    L29:
        return this.f248343a.g(r101);
    }

    public final SccConfig.SccLevel d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        String r101 = StringsKt.substringBefore$default(r100, '#', null, 2, null);
        n07.a r102 = this.f248343a;
        r102.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        return SccConfig.SccLevel.NOTICE;
    L12:
        if (this.f248343a.d(r101) == false) goto L15;
        return SccConfig.SccLevel.DENY;
    L15:
        return SccConfig.SccLevel.SAFE;
    L5:
        ArrayList<String> r104 = r102.f516582b;
        monitor-enter(r104);
        r103 = r102.f516582b.remove(r101);     // Catch: Throwable -> L16
        monitor-exit(r104);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public SccDelegate(JsonObject r100, x06.a r110) {
        Intrinsics.checkNotNullParameter(r100, "sccConfig");
        Intrinsics.checkNotNullParameter(r110, "networkDepend");
        n07.a r101 = new n07.a(null);
        this.f248343a = r101;
        if (f248341b == false) goto L5;
    L18:
        r101.f(r100);
        return;
    L5:
        monitor-enter(SccDelegate.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f248341b == true) goto L12;
        final Method r102 = a().getMethod("onEventV3", new Class[]{String.class, JSONObject.class});     // Catch: Throwable -> L15
        f248342c = new SccDelegate$1$1(r102);     // Catch: Throwable -> L15
        if (n07.b.a() != null) goto L11;
        HybridLogger.m("SccDelegate", "set SccSDK NetAdapter", null, null, 12);     // Catch: Throwable -> L15
        n07.b.d(new DefaultNetAdapter(new a(r110)));     // Catch: Throwable -> L15
    L11:
        n07.b.c(b.f248345a);     // Catch: Throwable -> L15
        f248341b = true;     // Catch: Throwable -> L15
    L12:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(SccDelegate.class);
        goto L18
    }
}
