package s41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.u;
import r11.v;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f540542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f540543b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f540544c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "liveInterCommentConfig", "getLiveInterCommentConfig()Lcom/bytedance/android/live/revlink/impl/config/RevLiveInterComDialogConfig;", 0))};
        f540542a = r100;
        f540544c = new b();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_intercom_comment_config", new v(), u.class, false);
        f540543b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public b() {
    }

    public final u a() {
        return (u) f540543b.getValue(this, f540542a[0]);
    }
}
