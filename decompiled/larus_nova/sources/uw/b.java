package uw;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f551913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f551914b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f551915c = null;

    static {
        f551913a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_NEW_GOLD_BOX_POSITION", "getLIVE_NEW_GOLD_BOX_POSITION()Lkotlin/Pair;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GOLD_COIN_DATE_CONFIG", "getLIVE_GOLD_COIN_DATE_CONFIG()Lkotlin/Pair;", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r100 = SpongePreferenceManager.a();
        Float r101 = Float.valueOf(-1.0f);
        f551914b = r100.a("live_gold_box_container_position", new Pair(r101, r101), sl3.a.f542457g);
        f551915c = SpongePreferenceManager.a().a("live_gold_coin_entrance_date_config", new Pair(0, Boolean.FALSE), sl3.a.f542458h);
    }

    public static final void a(Pair<Float, Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        f551914b.setValue(null, f551913a[0], r100);
    }
}
