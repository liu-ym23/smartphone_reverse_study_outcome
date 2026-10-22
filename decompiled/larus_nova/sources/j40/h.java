package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class h extends SettingKey<com.bytedance.android.livesdk.config.e0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f497230a = null;

    static {
        f497230a = new h();
    }

    public h() {
        Class<?> r100 = ((JsonAdapter) com.bytedance.android.livesdk.config.e0.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = vh7.b.f554981a;
        Constructor r102 = r101.get(r100);
        if (r102 != null) goto L12;
        r102 = r100.getConstructor(new Class[0]);
        if (r102 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r103 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
        if (r103 == null) goto L12;
        r102 = r103;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r104 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
        if (r104 == null) goto L31;
        com.bytedance.android.livesdk.config.e0 r105 = (com.bytedance.android.livesdk.config.e0) r104;
        Class<?> r106 = ((JsonAdapter) com.bytedance.android.livesdk.config.e0.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r107 = r101.get(r106);
        if (r107 != null) goto L24;
        r107 = r106.getConstructor(new Class[0]);
        if (r107 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r108 = r101.putIfAbsent(r106, r107);
        if (r108 == null) goto L24;
        r107 = r108;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r109 = r107.newInstance(new Object[0]).createInstance();
        if (r109 == null) goto L29;
        super("live_gift_asset_clean_in_room_config", "直播间内手动清理缓存配置", r105, (com.bytedance.android.livesdk.config.e0) r109);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.AssetManualCleanCacheConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.AssetManualCleanCacheConfig");
    }
}
