package com.bytedance.locallife.dito.provider;

import com.bytedance.locallife.dito.event.action.IDitoActionHandlerSpi;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoSpiComponentManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<DitoSpiComponentManager> f258655e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f258656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<IDitoActionHandlerSpi>> f258657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<fq6.b> f258658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends g> f258659d;

    public static final class a {
    }

    static {
        f258655e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DitoSpiComponentManager$Companion$sInstance$2.INSTANCE);
    }

    public DitoSpiComponentManager() {
        this.f258656a = new d(0);
        this.f258657b = new LinkedHashMap();
        com.bytedance.locallife.dito.a.a("action_handler", new AnonymousClass1(this));
        com.bytedance.locallife.dito.a.a("action_handler_interceptor", new AnonymousClass2(this));
        com.bytedance.locallife.dito.a.a("dito_spi_component_provider", new AnonymousClass3(this));
    }
}
