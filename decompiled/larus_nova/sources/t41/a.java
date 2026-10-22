package t41;

import com.bytedance.android.livesdk.model.o0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vh7.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f544552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f544553b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f544554c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f544555d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f544556e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f544557f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f544558g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f544559h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f544560i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f544561j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f544562k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f544563l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f544564m = null;

    public a() {
    }

    public final boolean a() {
        return ((Boolean) f544561j.getValue(this, f544552a[8])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f544557f.getValue(this, f544552a[4])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedEggsDebug", "getLivePkFeedEggsDebug()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedEggsEnterDebug", "getLivePkFeedEggsEnterDebug()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveVideoLayoutOptValue", "getLiveVideoLayoutOptValue()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedObserveMessageOpt", "getLivePkFeedObserveMessageOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pkPreviewOpt", "getPkPreviewOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePlayerRevSmoothEnterRoom", "getLivePlayerRevSmoothEnterRoom()Lcom/bytedance/android/livesdk/model/RevLivePlayerRevSmoothEnterRoomConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiPreviewEnable", "getLiveMultiPreviewEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "multiFeedViewNew", "getMultiFeedViewNew()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "feedStallOpt", "getFeedStallOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "feedPkBgEnable", "getFeedPkBgEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "screenRecordPlayerFix", "getScreenRecordPlayerFix()Z", 0))};
        f544552a = r100;
        f544564m = new a();
        Boolean r110 = Boolean.FALSE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_eggs_debug", r110, r111, false);
        f544553b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class r112 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_eggs_enter_debug", 0, r112, false);
        f544554c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_video_layout_optimize_value", 124, r112, false);
        f544555d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Boolean r104 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_observe_message_opt", r104, r111, false);
        f544556e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_preview_enable", r110, r111, false);
        f544557f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        Class<?> r107 = ((JsonAdapter) o0.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r108 = b.f554981a;
        Constructor r109 = r108.get(r107);
        if (r109 != null) goto L12;
        r109 = r107.getConstructor(new Class[0]);
        if (r109 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r113 = r108.putIfAbsent(r107, (Constructor<? extends SerializableObjectJsonAdapterBase>) r109);
        if (r113 == null) goto L12;
        r109 = r113;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r114 = ((SerializableObjectJsonAdapterBase) r109.newInstance(new Object[0])).createInstance();
        if (r114 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_rev_smooth_enter_room", (o0) r114, o0.class, false);
        f544558g = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_preview_enable", r110, r111, false);
        f544559h = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_feedview_new", r104, r111, false);
        f544560i = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_feed_stall_opt", r104, r111, false);
        f544561j = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_feed_pk_bg_enable", r104, r111, false);
        f544562k = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_feed_judge_fix", r104, r111, false);
        f544563l = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[10]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.model.RevLivePlayerRevSmoothEnterRoomConfig");
    }
}
