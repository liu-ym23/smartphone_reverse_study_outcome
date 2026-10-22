package v41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.l;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f553029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f553030b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f553031c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f553032d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f553033e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f553034f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f553035g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f553036h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f553037i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f553038j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f553039k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f553040l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f553041m = null;

    public a() {
    }

    public final boolean a() {
        return ((Boolean) f553031c.getValue(this, f553029a[1])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveSEIReplyMsgAck", "getLiveSEIReplyMsgAck()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveEnableRtsLogin", "getLiveEnableRtsLogin()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveResetPkTimerByMsg", "getLiveResetPkTimerByMsg()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveInteractMaxTimeout", "getLiveInteractMaxTimeout()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkBusinessTimeoutInterval", "getLivePkBusinessTimeoutInterval()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkHandleRepeatInvite", "getLivePkHandleRepeatInvite()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveWaitingListMsgUsers", "getLiveWaitingListMsgUsers()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDisableStartLimit", "getLivePkDisableStartLimit()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkInviteConfig", "getLivePkInviteConfig()Lcom/bytedance/android/live/revlink/impl/config/LivePkInviteConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pkTestTime", "getPkTestTime()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAnchorLinkPkAutoRefuseFallback", "getLiveAnchorLinkPkAutoRefuseFallback()Z", 0))};
        f553029a = r100;
        f553041m = new a();
        Boolean r110 = Boolean.FALSE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_reply_message_ack", r110, r111, true);
        f553030b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r112 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_rts_login", r112, r111, true);
        f553031c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_reset_pk_timer_by_msg", r112, r111, true);
        f553032d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_connect_timeout_interval", 20, Integer.TYPE, false);
        f553033e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_business_timeout_interval", 15L, Long.TYPE, false);
        f553034f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_handle_repeat_invite", r112, r111, false);
        f553035g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_waiting_list_msg_users", r112, r111, true);
        f553036h = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_disable_start_limit", r112, r111, true);
        f553037i = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[7]);
        Class<?> r109 = ((JsonAdapter) l.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r113 = vh7.b.f554981a;
        Constructor r114 = r113.get(r109);
        if (r114 != null) goto L12;
        r114 = r109.getConstructor(new Class[0]);
        if (r114 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r115 = r113.putIfAbsent(r109, (Constructor<? extends SerializableObjectJsonAdapterBase>) r114);
        if (r115 == null) goto L12;
        r114 = r115;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r116 = ((SerializableObjectJsonAdapterBase) r114.newInstance(new Object[0])).createInstance();
        if (r116 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_frequency_control", (l) r116, l.class, false);
        f553038j = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_test_time", r110, r111, false);
        f553039k = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_pk_auto_refuse_fallback", r110, r111, false);
        f553040l = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[10]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LivePkInviteConfig");
    }
}
