package y41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565929a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565930b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f565931c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f565932d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f565933e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c.class, "livePkChorusPerformanceLimit", "getLivePkChorusPerformanceLimit()F", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkEnableChorus", "getLivePkEnableChorus()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkChorusMuteBackupEnable", "getLivePkChorusMuteBackupEnable()Z", 0))};
        f565929a = r100;
        f565933e = new c();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_chorus_performance_limit", Float.valueOf(7.02f), Float.TYPE, false);
        f565930b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r102 = Boolean.TRUE;
        Class r103 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_chorus", r102, r103, false);
        f565931c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_chorus_mute_back_up_enable", r102, r103, false);
        f565932d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
    }

    public c() {
    }
}
