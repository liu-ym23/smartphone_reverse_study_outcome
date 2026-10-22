package vm2;

import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f556075a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f556076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f556077c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f556078d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f556079e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f556080f = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_DYLITE_LINKMIC_OPEN", "getLIVE_DYLITE_LINKMIC_OPEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "INETRACT_GUEST_FRAME_OPT", "getINETRACT_GUEST_FRAME_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_AUDIENCE_DEVICE_OVERALL_SCORE", "getLIVE_AUDIENCE_DEVICE_OVERALL_SCORE()F", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_LINK_CAMERA_BACKUP_SWITCH", "getLIVE_LINK_CAMERA_BACKUP_SWITCH()Lcom/bytedance/android/livesdkapi/model/ILiveLinkCameraBackUpConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REQUEST_CAMERA_PERMISSION_BEFORE_VIDEO_LINK", "getLIVE_REQUEST_CAMERA_PERMISSION_BEFORE_VIDEO_LINK()Z", 1))};
        f556075a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dylite_linkmic_open", r101, r102, false);
        f556076b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("interact_guest_frame_opt", r101, r102, false);
        f556077c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_device_model_overall_score", Float.valueOf(7.5f), Float.TYPE, false);
        f556078d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        Class<?> r106 = ((JsonAdapter) ILiveLinkCameraBackUpConfig.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r107 = vh7.b.f554981a;
        Constructor r108 = r107.get(r106);
        if (r108 != null) goto L12;
        r108 = r106.getConstructor(new Class[0]);
        if (r108 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r109 = r107.putIfAbsent(r106, (Constructor<? extends SerializableObjectJsonAdapterBase>) r108);
        if (r109 == null) goto L12;
        r108 = r109;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r110 = ((SerializableObjectJsonAdapterBase) r108.newInstance(new Object[0])).createInstance();
        if (r110 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_link_camera_backup_switch", (ILiveLinkCameraBackUpConfig) r110, ILiveLinkCameraBackUpConfig.class, false);
        f556079e = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_request_camera_permission_before_video_link", r101, r102, false);
        f556080f = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[4]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig");
    }

    public static final boolean a() {
        return ((Boolean) f556077c.getValue(null, f556075a[1])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) f556076b.getValue(null, f556075a[0])).booleanValue();
    }

    public static final ILiveLinkCameraBackUpConfig c() {
        return (ILiveLinkCameraBackUpConfig) f556079e.getValue(null, f556075a[3]);
    }
}
