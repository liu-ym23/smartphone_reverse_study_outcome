package wt0;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f561178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f561179b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f561180c = null;

    static {
        f561178a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "LIVE_IS_CLEAR_SCREEN_OPTIMIZE", "getLIVE_IS_CLEAR_SCREEN_OPTIMIZE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "LIVE_ANCHOR_HAS_VIP_CACHE", "getLIVE_ANCHOR_HAS_VIP_CACHE()Ljava/util/Map;", 1))};
        f561179b = SpongePreferenceManager.a().a("live_clear_screen_optimize", Boolean.FALSE, Boolean.TYPE);
        f561180c = SpongePreferenceManager.a().a("live_anchor_has_vip_cache_v2", MapsKt.emptyMap(), sl3.a.f542453c);
    }
}
