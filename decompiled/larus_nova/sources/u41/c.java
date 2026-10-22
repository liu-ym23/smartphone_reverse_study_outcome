package u41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f548657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f548658b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f548659c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f548660d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f548661e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f548662f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c.class, "livePkAudienceScoreFilter", "getLivePkAudienceScoreFilter()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkReplyMessageCache", "getLivePkReplyMessageCache()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkInviteTimerInterval", "getLivePkInviteTimerInterval()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkInviteMsgAtLeastAvailableTime", "getLivePkInviteMsgAtLeastAvailableTime()J", 0))};
        f548657a = r100;
        f548662f = new c();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_score_message_filter", r101, r102, false);
        f548658b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_reply_message_cache", r101, r102, false);
        f548659c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        Class r105 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_invite_timer_interval", 25L, r105, false);
        f548660d = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_invite_msg_at_least_available_time", 5L, r105, false);
        f548661e = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[3]);
    }

    public c() {
    }
}
