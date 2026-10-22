package oj0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f523505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f523506b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f523507c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_LOCAL_DEFAULT_THEME_RES", "getLIVE_LOCAL_DEFAULT_THEME_RES()Lcom/bytedance/android/live/liveinteract/theme/util/DefaultVoiceLiveThemeResource;", 0))};
        f523505a = r100;
        f523507c = new a();
        b r101 = new b();
        r101.f523508a = "webcast/audio_bg_3.png";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_local_default_audio_theme", r101, b.class, true);
        f523506b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
    }

    public a() {
    }
}
