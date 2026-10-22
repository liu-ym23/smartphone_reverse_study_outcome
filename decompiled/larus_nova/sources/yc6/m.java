package yc6;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f567204a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f567205b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f567206c = null;

    static {
        f567204a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(m.class, "GIFT_BUFF_CARD_LAST_SEND_IDS", "getGIFT_BUFF_CARD_LAST_SEND_IDS()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(m.class, "GIFT_BUFF_CARD_LAST_SEND_TIME", "getGIFT_BUFF_CARD_LAST_SEND_TIME()Ljava/util/Map;", 1))};
        f567205b = SpongePreferenceManager.a().a("gift_buff_card_last_send_ids", MapsKt.emptyMap(), rl3.a.f538461e);
        f567206c = SpongePreferenceManager.a().a("gift_buff_card_last_send_time", MapsKt.emptyMap(), rl3.a.f538458b);
    }
}
