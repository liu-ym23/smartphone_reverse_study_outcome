package y41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565923b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f565924c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "multiAnchorBackupStreamDisable", "getMultiAnchorBackupStreamDisable()Z", 0))};
        f565922a = r100;
        f565924c = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_linker_backup_stream_disable", Boolean.FALSE, Boolean.TYPE, false);
        f565923b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public a() {
    }

    public final boolean a() {
        return ((Boolean) f565923b.getValue(this, f565922a[0])).booleanValue();
    }
}
