package ez1;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f474839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f474840b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_MSESSAGE_BOARD_GIFT_DIALOG_URL", "getLIVE_MSESSAGE_BOARD_GIFT_DIALOG_URL()Ljava/lang/String;", 1))};
        f474839a = r100;
        KmpEnv r101 = KmpEnv.f255139a;
        KmpEnv.a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_message_board_gift_dialog_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_gift_douyin%2Fpages%2Fgift%2Fmessage_board_gift%2Ftemplate.js&load_taro=0&enable_canvas=1&width_percent=100&type=popup&gravity=bottom&height=300&web_bg_color=00FFFFFF", String.class, false);
        f474840b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
    }
}
