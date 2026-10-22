package nz1;

import com.bytedance.android.livesdk.gift.configmodel.o0;
import com.bytedance.android.livesdk.gift.configmodel.v0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f521368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f521369b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f521370c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f521371d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f521372e = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_PAGING_CONFIG", "getLIVE_GIFT_LIST_PAGING_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftListPagingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BUFF_AND_DIY_CARD_CONFIG", "getLIVE_GIFT_BUFF_AND_DIY_CARD_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/config/BuffAndDiyCardConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GROUP_SHOW_II", "getGROUP_SHOW_II()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_ENTRANCE_OPTIMIZE", "getLIVE_GIFT_RECEIVER_ENTRANCE_OPTIMIZE()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelReceiverOptimizeConfig;", 1))};
        f521368a = r100;
        Class<?> r101 = ((JsonAdapter) o0.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r102 = vh7.b.f554981a;
        Constructor r103 = r102.get(r101);
        if (r103 != null) goto L12;
        r103 = r101.getConstructor(new Class[0]);
        if (r103 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r102.putIfAbsent(r101, (Constructor<? extends SerializableObjectJsonAdapterBase>) r103);
        if (r104 == null) goto L12;
        r103 = r104;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r105 = ((SerializableObjectJsonAdapterBase) r103.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L45;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_paging_config", (o0) r105, o0.class, false);
        f521369b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        Class<?> r107 = ((JsonAdapter) com.bytedance.android.livesdk.gift.platform.business.config.a.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r108 = r102.get(r107);
        if (r108 != null) goto L24;
        r108 = r107.getConstructor(new Class[0]);
        if (r108 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r109 = r102.putIfAbsent(r107, r108);
        if (r109 == null) goto L24;
        r108 = r109;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r110 = r108.newInstance(new Object[0]).createInstance();
        if (r110 == null) goto L43;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_buff_and_diy_card_config", (com.bytedance.android.livesdk.gift.platform.business.config.a) r110, com.bytedance.android.livesdk.gift.platform.business.config.a.class, false);
        f521370c = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_show_II", 0, Integer.TYPE, false);
        f521371d = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[2]);
        Class<?> r113 = ((JsonAdapter) v0.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r114 = r102.get(r113);
        if (r114 != null) goto L36;
        r114 = r113.getConstructor(new Class[0]);
        if (r114 == null) goto L35;
        Constructor<? extends SerializableObjectJsonAdapterBase> r115 = r102.putIfAbsent(r113, r114);
        if (r115 == null) goto L36;
        r114 = r115;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r116 = r114.newInstance(new Object[0]).createInstance();
        if (r116 == null) goto L41;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_receiver_experience_optimize_config", (v0) r116, v0.class, false);
        f521372e = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[3]);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftPanelReceiverOptimizeConfig");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.config.BuffAndDiyCardConfig");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftListPagingConfig");
    }

    public static final com.bytedance.android.livesdk.gift.platform.business.config.a a() {
        return (com.bytedance.android.livesdk.gift.platform.business.config.a) f521370c.getValue(null, f521368a[1]);
    }
}
