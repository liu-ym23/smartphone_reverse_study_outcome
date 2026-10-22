package com.bytedance.ies.argus.strategy;

import com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusTTMStrategyManagerWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ArgusTTMStrategyManagerWrapper> f246142c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f246143d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function0<Unit>> f246144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITTMStrategyManager f246145b;

    public static final class a {
    }

    static {
        f246142c = LazyKt.lazy(ArgusTTMStrategyManagerWrapper$Companion$instance$2.INSTANCE);
        f246143d = "TTMStrategyManagerWrapper";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager");
    }

    public ArgusTTMStrategyManagerWrapper() {
        this.f246144a = new CopyOnWriteArrayList();
    }
}
