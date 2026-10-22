package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.g;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import q26.j;
import v26.l;
import y16.b;
import y16.c;

/* JADX INFO: loaded from: classes19.dex */
public class DefaultDynamicComponentFetcher implements k7a.a, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<j> f247380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f247381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ForestDynamicComponentProvider f247382c;

    public static final class a {
    }

    static {
    }

    private final j getContext() {
        WeakReference<j> r100 = this.f247380a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public DefaultDynamicComponentFetcher(j r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f247381b = g.a.v(this, r100);
        this.f247382c = new ForestDynamicComponentProvider(g.a.g(this, r100), g.a.s(this, r100), r100.getBid());
        this.f247380a = new WeakReference(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final String forestDownloadEngine(BulletContext r100) {
        return g.a.f(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final boolean hasGeckoModelInfo(BulletContext r100) {
        return g.a.l(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final String sessionID(BulletContext r100) {
        return g.a.r(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final boolean useForest(BulletContext r100) {
        return g.a.u(r100);
    }

    @Override // k7a.a
    public void loadDynamicComponent(String r100, final k7a.a.InterfaceC6515a r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = null;
        if (r100 != null) goto L8;
        r101.a(null, new Throwable("url is null"));
        return;
    L8:
        b r103 = c.f565659a;
        c.d("DefaultDynamicComponentFetcher start to load ".concat(r100));
        if (this.f247381b == false) goto L11;
        this.f247382c.loadDynamicComponent(r100, r101);
        return;
    L11:
        Uri r104 = UriProtector.parse(r100);
        final String r105 = UriProtector.getQueryParameter(r104, "dynamic_component_rl_callback_type");
        if (r105 != null) goto L14;
        r105 = "async";
    L14:
        l r106 = new l();
        int r107 = w16.a.f557913b;
        j r108 = getContext();
        if (r108 == null) goto L17;
        Map<Class<?>, Object> r109 = r108.getAllDependency();
    L18:
        r106.f552723z = w16.a.C8059a.a(r109);
        Intrinsics.checkNotNullParameter("component", "<set-?>");
        r106.f552711n = "component";
        String r110 = a36.b.b(r104);     // Catch: Throwable -> L32
        if (r110 == null) goto L22;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Throwable -> L32
        r106.f552708k = r110;     // Catch: Throwable -> L32
    L22:
        String r111 = UriProtector.getQueryParameter(r104, "channel");     // Catch: Throwable -> L32
        if (r111 == null) goto L25;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");     // Catch: Throwable -> L32
        r106.f552705h = r111;     // Catch: Throwable -> L32
    L25:
        String r112 = UriProtector.getQueryParameter(r104, "bundle");     // Catch: Throwable -> L32
        if (r112 == null) goto L28;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");     // Catch: Throwable -> L32
        r106.f552706i = r112;     // Catch: Throwable -> L32
    L28:
        r106.f552703f = 1;     // Catch: Throwable -> L32
        String r113 = UriProtector.getQueryParameter(r104, "dynamic");     // Catch: Throwable -> L32
        if (r113 == null) goto L34;
        r106.f552703f = Integer.valueOf(CastIntegerProtector.parseInt(r113));     // Catch: Throwable -> L32
    L34:
        ConcurrentHashMap<String, ResourceLoaderService> r114 = i.f246824a;
        j r115 = getContext();
        if (r115 == null) goto L37;
        r102 = r115.getBid();
    L37:
        i.b(r102, 2).g(r100, r106, new AnonymousClass1(r105, r101), new AnonymousClass2(r101));
        return;
    L32:
        th = move-exception;
        ExecutorService r116 = BulletLogger.f247763a;
        BulletLogger.l(th, "DefaultDynamicComponentFetcher parse url error", "XLynxKit");
        goto L34
    L17:
        r109 = null;
        goto L18
    }
}
