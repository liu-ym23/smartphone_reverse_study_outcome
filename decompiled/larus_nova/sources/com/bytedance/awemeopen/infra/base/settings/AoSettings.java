package com.bytedance.awemeopen.infra.base.settings;

import com.bytedance.awemeopen.servicesapi.setting.AoSDKSettingsService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class AoSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f198802a = null;

    static {
        f198802a = LazyKt.lazy(AoSettings$service$2.INSTANCE);
    }

    public static JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((AoSDKSettingsService) f198802a.getValue()).getSettings(r100);
    }
}
