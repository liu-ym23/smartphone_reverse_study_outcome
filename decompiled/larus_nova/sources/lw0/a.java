package lw0;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f510982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f510983b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f510984c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f510985d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f510986e = null;

    static {
        f510982a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_TIME", "getLIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_DIALOG", "getLIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_DIALOG()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "CASH_EXCHANGE_GIFT_GUIDE_SHOWN", "getCASH_EXCHANGE_GIFT_GUIDE_SHOWN()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "CASH_EXCHANGE_GIFT_SEND_CHECKED", "getCASH_EXCHANGE_GIFT_SEND_CHECKED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "SHOW_CASH_EXCHANGE_DIAMOND_CONFIRM_DIALOG", "getSHOW_CASH_EXCHANGE_DIAMOND_CONFIRM_DIALOG()Z", 1))};
        f510983b = SpongePreferenceManager.a().a("live_recharge_exchange_confirm_show_time", 0L, Long.TYPE);
        com.bytedance.tools.kcp.spongepreference.runtime.b r100 = SpongePreferenceManager.a();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        f510984c = r100.a("live_recharge_exchange_confirm_show_dialog", r101, r102);
        com.bytedance.tools.kcp.spongepreference.runtime.b r103 = SpongePreferenceManager.a();
        Boolean r104 = Boolean.FALSE;
        f510985d = r103.a("cash_exchange_gift_guide_shown", r104, r102);
        f510986e = SpongePreferenceManager.a().a("cash_exchange_gift_send_checked", r104, r102);
        SpongePreferenceManager.a().a("show_cash_exchange_diamond_confirm_dialog", r101, r102);
    }
}
