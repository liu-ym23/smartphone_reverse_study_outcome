package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.g;
import com.bytedance.ies.argus.repository.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
public final class PluginManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<PluginManager> f246071d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f246072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, b> f246073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends c>, ISecurePlugin<?>> f246074c;

    public static final class a {
    }

    static {
        f246071d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PluginManager$Companion$instance$2.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        Lazy<ArgusConfigManager> r100 = ArgusConfigManager.f246083j;
        ArgusConfigManager r101 = ArgusConfigManager.a.a();
        Function1<m, Unit> r102 = new PluginManager$setup$1(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "collector");
        ArgusConfigManager.c r103 = r101.f246087d;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "collector");
        r103.f246098b.add((Function1<T, Unit>) r102);
        ArgusConfigManager r104 = ArgusConfigManager.a.a();
        Function1<com.bytedance.ies.argus.repository.f, Unit> r105 = new PluginManager$setup$2(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "collector");
        g r106 = r104.f246085b;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "collector");
        r106.f246098b.add((Function1<T, Unit>) r105);
    }

    public final void b() {
        List r100 = CollectionsKt.listOf(new e());
        Lazy<ArgusEnv> r101 = ArgusEnv.f245917d;
        CoroutineScope r102 = ArgusEnv.b.a().f245920c;
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L16;
        ISecurePlugin r104 = (ISecurePlugin) r103.next();
        String r105 = (String) r104.f246070a.getValue();
        d r106 = this.f246072a;
        if (r106 == null) goto L12;
        List<String> r107 = r106.a();
        if (r107 == null) goto L12;
        boolean r108 = r107.contains(r105);
        boolean r109 = true;
        if (r108 != true) goto L12;
    L13:
        if (r109 == true) goto L4;
        BuildersKt.launch$default(r102, null, null, new PluginManager$setupPlugin$1(r104, this, null), 3, null);
    L12:
        r109 = false;
        goto L13
    }

    public PluginManager() {
        this.f246073b = MapsKt.emptyMap();
        this.f246074c = new ConcurrentHashMap();
    }
}
