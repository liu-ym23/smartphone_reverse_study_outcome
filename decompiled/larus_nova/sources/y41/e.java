package y41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f565946c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f565947d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f565948e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f565949f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f565950g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f565951h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f565952i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f565953j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f565954k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f565955l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f565956m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f565957n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f565958o = null;

    public e() {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiAnchorLinkEnterRoomOptEnable", "getLiveMultiAnchorLinkEnterRoomOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiAnchorLinkEnterRoomOptConfig", "getLiveMultiAnchorLinkEnterRoomOptConfig()Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkEnterRoomOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveAnchorLinkCompositeOptEnable", "getLiveAnchorLinkCompositeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveAnchorLinkCompositeOptConfig", "getLiveAnchorLinkCompositeOptConfig()Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveAnchorLinkAudienceCompositeOptEnable", "getLiveAnchorLinkAudienceCompositeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiBattleFinishOpt", "getLiveMultiBattleFinishOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiBattleFinishAudienceOpt", "getLiveMultiBattleFinishAudienceOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "multiRevenueAsyncXml", "getMultiRevenueAsyncXml()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiBattleCountDownBackup", "getLiveMultiBattleCountDownBackup()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiMeasureOpt", "getLiveMultiMeasureOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiPersonPKBarBlockReport", "getLiveMultiPersonPKBarBlockReport()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveSilenceRequestMerge", "getLiveSilenceRequestMerge()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveDataLinkSwitchToPk", "getLiveDataLinkSwitchToPk()Z", 0))};
        f565944a = r100;
        f565958o = new e();
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_link_enter_room_opt_enable", r110, r111, false);
        f565945b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class<?> r112 = ((JsonAdapter) r11.a.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r113 = vh7.b.f554981a;
        Constructor r114 = r113.get(r112);
        if (r114 != null) goto L11;
        Constructor<?> r115 = r112.getConstructor(new Class[0]);
        if (r115 == null) goto L10;
        r114 = r113.putIfAbsent(r112, (Constructor<? extends SerializableObjectJsonAdapterBase>) r115);
        if (r114 != null) goto L11;
        r114 = r115;
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L11:
        Object r116 = ((SerializableObjectJsonAdapterBase) r114.newInstance(new Object[0])).createInstance();
        if (r116 == null) goto L30;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_link_enter_room_opt_config", (r11.a) r116, r11.a.class, false);
        f565946c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_composite_opt_enable", r110, r111, false);
        f565947d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Class<?> r104 = ((JsonAdapter) r11.b.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r105 = r113.get(r104);
        if (r105 != null) goto L23;
        r105 = r104.getConstructor(new Class[0]);
        if (r105 == null) goto L22;
        Constructor<? extends SerializableObjectJsonAdapterBase> r106 = r113.putIfAbsent(r104, r105);
        if (r106 == null) goto L23;
        r105 = r106;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L23:
        Object r107 = r105.newInstance(new Object[0]).createInstance();
        if (r107 == null) goto L28;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_composite_opt_config", (r11.b) r107, r11.b.class, false);
        f565948e = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_audience_composite_opt_enable", r110, r111, false);
        f565949f = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_battle_finish_opt", r110, r111, false);
        f565950g = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_battle_finish_audience_opt", r110, r111, false);
        f565951h = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_async_xml", r110, r111, false);
        f565952i = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_battle_count_down_back_up", r110, r111, false);
        f565953j = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[8]);
        Boolean r121 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_measure_opt", r121, r111, false);
        f565954k = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_person_pk_bar_block_report", r121, r111, false);
        f565955l = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_silence_request_merge", r110, r111, false);
        f565956m = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_data_link_switch_to_pk", r110, r111, false);
        f565957n = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[12]);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.AnchorLinkOptConfig");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.AnchorLinkEnterRoomOptConfig");
    }
}
