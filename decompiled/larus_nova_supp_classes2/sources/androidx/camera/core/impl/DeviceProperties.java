package androidx.camera.core.impl;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class DeviceProperties {
    public DeviceProperties() {
    }

    public abstract String manufacturer();

    public abstract String model();

    public abstract int sdkVersion();

    public static DeviceProperties create() {
        return create(Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT);
    }

    public static DeviceProperties create(String r1, String r2, int r3) {
        return new AutoValue_DeviceProperties(r1, r2, r3);
    }
}
