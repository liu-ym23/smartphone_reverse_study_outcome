package xa1;

import com.bytedance.android.livesdk.config.z51;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f563032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f563033b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f563034c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f563035d = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "liveMsgChannelSetting", "getLiveMsgChannelSetting()Lcom/bytedance/android/livesdk/config/LiveMsgChannelConfig;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "updateRoomByInviteResult", "getUpdateRoomByInviteResult()Z", 0))};
        f563032a = r100;
        f563035d = new b();
        Class<?> r101 = ((JsonAdapter) z51.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r102 = vh7.b.f554981a;
        Constructor r103 = r102.get(r101);
        if (r103 != null) goto L12;
        r103 = r101.getConstructor(new Class[0]);
        if (r103 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r102.putIfAbsent(r101, (Constructor<? extends SerializableObjectJsonAdapterBase>) r103);
        if (r104 == null) goto L12;
        r103 = r104;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r105 = ((SerializableObjectJsonAdapterBase) r103.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_msg_channel_setting", (z51) r105, z51.class, false);
        f563033b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("update_room_by_invite_result", Boolean.TRUE, Boolean.TYPE, false);
        f563034c = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[1]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LiveMsgChannelConfig");
    }

    public b() {
    }
}
