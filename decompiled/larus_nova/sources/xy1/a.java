package xy1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565358b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "COMMENT_GIFT_GUIDE_CONFIG", "getCOMMENT_GIFT_GUIDE_CONFIG()Lcom/bytedance/android/livesdk/gift/guide/model/RevCommentGiftGuideConfig;", 1))};
        f565357a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("comment_gift_guide_config", new zy1.b(), zy1.b.class, false);
        f565358b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public static final zy1.b a() {
        return (zy1.b) f565358b.getValue(null, f565357a[0]);
    }
}
