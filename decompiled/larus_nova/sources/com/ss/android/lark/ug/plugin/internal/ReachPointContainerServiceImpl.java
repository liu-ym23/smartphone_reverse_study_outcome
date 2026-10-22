package com.ss.android.lark.ug.plugin.internal;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.squareup.wire.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ug_reach.MaterialBase;
import com.ss.android.lark.ug.integrator.UgReachSdkIntegrator;
import com.ss.android.lark.ug.plugin.ReachPointPluginException;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import k9c.d;
import k9c.e;
import k9c.f;
import k9c.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class ReachPointContainerServiceImpl implements e, k9c.a, k9c.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ReachPointContainerServiceImpl> f444455c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k9c.a f444456b;

    public static final class a {
    }

    public static final class b extends l9c.b<Message<?, ?>, l9c.a<Message<?, ?>>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f444457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Class<RP> f444458d;

        @Override // l9c.b
        public final l9c.a<Message<?, ?>> h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reachPointId");
            ConcurrentHashMap<Class<? extends d<?>>, l9c.a.b> r101 = l9c.a.f508137e;
            GenericDeclaration r102 = this.f444458d;
            Intrinsics.checkNotNullParameter(r102, "reachPoint");
            Intrinsics.checkNotNullParameter(r100, "reachPointId");
            l9c.a.b r103 = l9c.a.f508137e.get(r102);
            if (r103 == null) goto L7;
            f<? extends l9c.a<?>> r104 = r103.f508143b;
            if (r104 == null) goto L7;
            l9c.a<Message<?, ?>> r105 = r104.a(r100);
        L8:
            if (r105 == null) goto L10;
            return r105;
        L10:
            Log.e("ReachPointPlugin", "BaseReachPoint createReachPoint return null ");
            throw new ReachPointPluginException("BaseReachPoint createReachPoint return null ");
        L7:
            r105 = null;
            goto L8
        }

        public b(String r100, Class<RP> r101) {
            this.f444457c = r100;
            this.f444458d = r101;
        }
    }

    public ReachPointContainerServiceImpl() {
    }

    static {
        f444455c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ReachPointContainerServiceImpl$Companion$instance$2.INSTANCE);
    }

    @Override // k9c.e
    public final void g() {
        Lazy<PluginManager> r100 = PluginManager.f444453b;
        Iterator r101 = new HashMap(PluginManager.a.a().f444454a).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        g r102 = (g) r101.next();
        Iterator r103 = r102.b().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        r102.f(((d) r103.next()).b());
        goto L7
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void h(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r100);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    @Override // k9c.a
    public final void a(m9c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        k9c.a r101 = this.f444456b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // k9c.e
    public final void c(UgReachSdkIntegrator.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dataService");
        this.f444456b = r100;
    }

    @Override // k9c.e
    public final <RP extends d<DATA>, DATA extends Message<?, ?>> void f(RP r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPoint");
        if ((r100 instanceof l9c.a) == false) goto L5;
        l9c.a r101 = (l9c.a) r100;
    L6:
        if (r101 == null) goto L11;
        String r102 = r101.f508138a;
        String r103 = r101.f508139b;
        Intrinsics.checkNotNullParameter(r102, "reachPointId");
        Intrinsics.checkNotNullParameter(r103, "reachPointType");
        Lazy<PluginManager> r104 = PluginManager.f444453b;
        g<? extends Message<?, ?>, ? extends d<? extends Message<?, ?>>> r105 = PluginManager.a.a().a(r103);
        if (r105 == null) goto L12;
        r105.f(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // k9c.a
    public final void openUrl(String r100) {
        k9c.a r101 = this.f444456b;
        if (r101 == null) goto L6;
        r101.openUrl(r100);
        return;
    }

    @Override // k9c.e
    public final <RP extends d<?>> RP b(String r100, Class<RP> r101) {
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        Intrinsics.checkNotNullParameter(r101, "reachPointClazz");
        h(r101.getName());     // Catch: Exception -> L24
        ConcurrentHashMap<Class<? extends d<?>>, l9c.a.b> r102 = l9c.a.f508137e;     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r101, "reachPoint");     // Catch: Exception -> L24
        l9c.a.b r103 = l9c.a.f508137e.get(r101);     // Catch: Exception -> L24
        if (r103 == null) goto L6;
        String r104 = r103.f508142a;     // Catch: Exception -> L24
    L7:
        if (r104 != null) goto L10;
        Log.e("ReachPointPlugin", "ReachPoint obtain error, not found " + r101 + " associate reachPointType");     // Catch: Exception -> L24
        return null;
    L10:
        Lazy<PluginManager> r105 = PluginManager.f444453b;     // Catch: Exception -> L24
        g<? extends Message<?, ?>, ? extends d<? extends Message<?, ?>>> r106 = PluginManager.a.a().a(r104);     // Catch: Exception -> L24
        g r107 = r106;
        if (r106 != null) goto L20;
        b r108 = new b(r104, r101);     // Catch: Exception -> L24
        r108.f508145b = new WeakReference(this);     // Catch: Exception -> L24
        PluginManager r109 = PluginManager.a.a();     // Catch: Exception -> L24
        monitor-enter(r109);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r108, CloudControlInf.PLUGIN);     // Catch: Throwable -> L17
        r109.f444454a.put(r104, r108);     // Catch: Throwable -> L17
        monitor-exit(r109);     // Catch: Exception -> L24
        r107 = r108;
        goto L20
    L17:
        th = move-exception;
        throw th;     // Catch: Exception -> L24
    L20:
        l9c.a r110 = r107.e(r100);     // Catch: Exception -> L24
        if ((r110 instanceof d) == true) goto L23;
        return null;
    L23:
        return r110;
    L6:
        r104 = null;
    L24:
        e = move-exception;
        Log.e("ReachPointPlugin", "ReachPoint obtain error", e);
        return null;
    }

    @Override // k9c.e
    public final void d(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        Intrinsics.checkNotNullParameter(r110, "reachPointType");
        Lazy<PluginManager> r101 = PluginManager.f444453b;
        g<? extends Message<?, ?>, ? extends d<? extends Message<?, ?>>> r102 = PluginManager.a.a().a(r110);
        if (r102 != null) goto L5;
        return;
    L5:
        boolean r103 = r102.a(r100);
        MaterialBase r104 = r102.c(r100);
        a(new m9c.a(r100, r110, new m9c.a.C6784a("didHide", r103), r104, 16));
    }

    @Override // k9c.a
    public final void openUrl(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        k9c.a r102 = this.f444456b;
        if (r102 == null) goto L6;
        r102.openUrl(r100, r101);
        return;
    }

    @Override // k9c.e
    public final void e(String r100, String r101, byte[] r110) {
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        Intrinsics.checkNotNullParameter(r101, "reachPointType");
        Intrinsics.checkNotNullParameter(r110, HTTP.CONTENT_RANGE_BYTES);
        Lazy<PluginManager> r102 = PluginManager.f444453b;
        g<? extends Message<?, ?>, ? extends d<? extends Message<?, ?>>> r103 = PluginManager.a.a().a(r101);
        if (r103 != null) goto L11;
        return;
    L11:
        boolean r111 = r103.d(r100, r110);     // Catch: Exception -> L7
    L9:
        MaterialBase r104 = r103.c(r100);
        a(new m9c.a(r100, r101, new m9c.a.C6784a("didShow", r111), r104, 16));
        return;
    L7:
        e = move-exception;
        Log.e("ReachPointPlugin", "showReachPoint", e);
        r111 = false;
        goto L9
    }
}
