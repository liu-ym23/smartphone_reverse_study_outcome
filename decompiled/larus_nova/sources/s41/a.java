package s41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f540537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f540538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f540539c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f540540d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f540541e = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveSceneGiftSyncConfigSetting", "getLiveSceneGiftSyncConfigSetting()Lcom/bytedance/android/livesdk/configmodel/LiveSceneGiftSyncConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAiGiftAsyncSortConfig", "getLiveAiGiftAsyncSortConfig()Lcom/bytedance/android/live/revlink/impl/config/LiveGiftAsyncSortConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePostPkUiThread", "getLivePostPkUiThread()Z", 0))};
        f540537a = r100;
        f540541e = new a();
        Class<?> r101 = ((JsonAdapter) ys1.b.class.getAnnotation(JsonAdapter.class)).value();
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
        if (r105 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_scene_gift_sync_config_setting", (ys1.b) r105, ys1.b.class, false);
        f540538b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        Class<?> r107 = ((JsonAdapter) k.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r108 = r102.get(r107);
        if (r108 != null) goto L24;
        r108 = r107.getConstructor(new Class[0]);
        if (r108 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r109 = r102.putIfAbsent(r107, r108);
        if (r109 == null) goto L24;
        r108 = r109;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r110 = r108.newInstance(new Object[0]).createInstance();
        if (r110 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ai_gift_async_sort_config", (k) r110, k.class, false);
        f540539c = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_post_pk_thread", Boolean.TRUE, Boolean.TYPE, false);
        f540540d = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[2]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LiveGiftAsyncSortConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.configmodel.LiveSceneGiftSyncConfig");
    }

    public a() {
    }

    public final k a() {
        return (k) f540539c.getValue(this, f540537a[1]);
    }
}
