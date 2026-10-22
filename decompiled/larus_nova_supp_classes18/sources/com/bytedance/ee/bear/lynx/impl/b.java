package com.bytedance.ee.bear.lynx.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSPath;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.bytedance.ee.bear.lynx.api.c {
    public static final WeakHashMap<LynxView, Object> b = null;
    public String a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.b$b, reason: collision with other inner class name */
    public static final class C0038b implements LynxDevtoolCardListener {
        public static final C0038b a = null;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.b$b$a */
        public static final class a implements Runnable {
            public final /* synthetic */ LynxView a;

            public a(LynxView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LynxBaseInspectorOwner r0 = this.a.getBaseInspectorOwner();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.reload(true);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        static {
            a = new C0038b();
        }

        public C0038b() {
        }

        public final void open(String r3) {
            WeakHashMap<LynxView, Object> r4 = b.b;
            Iterator<T> r5 = b.b.keySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            j.f(new a((LynxView) r5.next()));
            goto L4
        }
    }

    static {
        b = new WeakHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class f() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.lynx.devtool.LynxGlobalDebugBridge");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.lynx.devtool.LynxGlobalDebugBridge");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    @Override // com.bytedance.ee.bear.lynx.api.c
    public final boolean d() {
        if (this.a.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public b() {
        this.a = "";
    }

    @Override // com.bytedance.ee.bear.lynx.api.c
    public final String c() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.lynx.api.c
    public final boolean a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "debuggerServer");
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(eu5.b.a);     // Catch: Exception -> L26
        boolean r2 = true;
        Class r3 = f();     // Catch: Throwable -> L7
        Method r5 = r3.getMethod("getInstance", new Class[0]);     // Catch: Throwable -> L7
        Field r4 = r3.getDeclaredField("mCardListeners");     // Catch: Throwable -> L7
        r4.setAccessible(true);     // Catch: Throwable -> L7
        Object r6 = r4.get(r5.invoke(null, new Object[0]));     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.util.Set<com.lynx.devtoolwrapper.LynxDevtoolCardListener>");     // Catch: Throwable -> L7
        ((Set) r6).clear();     // Catch: Throwable -> L7
    L9:
        LynxDevtoolGlobalHelper.getInstance().registerCardListener(C0038b.a);     // Catch: Exception -> L26
        String r7 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(r8), ResourceData.KEY_URL)).getHost();     // Catch: Exception -> L26
        if (r7 != null) goto L12;
    L15:
        if (r2 == true) goto L25;
        Intrinsics.checkNotNullParameter(r7, "value");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r7) == false) goto L19;
    L21:
        this.a = r7;     // Catch: Exception -> L26
        LynxDevtoolGlobalHelper r9 = LynxDevtoolGlobalHelper.getInstance();     // Catch: Exception -> L26
        if (r9.shouldPrepareRemoteDebug(r8) == false) goto L33;
        return r9.prepareRemoteDebug(r8);
    L33:
        return false;
    L19:
        if (StringsKt.contains$default(r7, ":", false, 2, null) == true) goto L21;
        r7 = r7 + ":9000";     // Catch: Exception -> L26
        goto L21
    L25:
        return false;
    L12:
        if (r7.length() == 0) goto L15;
        r2 = false;
        goto L15
    L7:
        th = move-exception;
        Log.d(tt5.a.a(""), "CCMLynxDebugger", th);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        tt5.a.e("CCMLynxDebugger", "triggerLynxDevtool err. ", e, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.lynx.api.c
    public final VFSPath b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r5 = ay4.c.a;
        return ay4.c.a.f(Biz.DYNAMIC, null, false, false, 14).subPath("lynx_res").subPath("specific");
    }

    @Override // com.bytedance.ee.bear.lynx.api.c
    public final String e(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        String r16 = he5.a.a;
        String r17 = he5.a.a;
        String r1 = "";
        if (r17 == null) goto L22;
        BufferedReader r3 = null;
        BufferedReader r0 = new BufferedReader(new InputStreamReader(ay4.d.a().v(StringsKt.substringBefore$default(r17, "docs_lynx_channel", null, 2, null) + "docs_lynx_channel", "current_revision").newInputStream()));     // Catch: Throwable -> L16
    L23:
        String r8 = r0.readLine();     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L14
        if (r8 == null) goto L13;
        if (StringsKt.startsWith$default(r8, "version", false, 2, null) == false) goto L23;
        String[] r18 = (String[]) StringsKt.split$default(r8, new String[]{":"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Throwable -> L14
        if (r18.length != 2) goto L23;
        r1 = r18[1];     // Catch: Throwable -> L14
    L13:
        FileUtils.e(new Closeable[]{r0});
    L14:
        th = th;
        r3 = r0;
    L25:
        tt5.a.e("CCMLynxDebugger", "getCurrentVersion err", th, false);     // Catch: Throwable -> L19
        FileUtils.e(new Closeable[]{r3});
    L19:
        th = move-exception;
        FileUtils.e(new Closeable[]{r3});
        throw th;
    L16:
        th = th;
    L22:
        return r1;
    }
}
