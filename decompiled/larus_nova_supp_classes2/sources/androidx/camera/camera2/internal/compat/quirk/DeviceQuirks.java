package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DeviceQuirks {
    private static final String TAG = "DeviceQuirks";
    private static volatile Quirks sQuirks;

    public static /* synthetic */ void a(QuirkSettings r0) {
        lambda$static$0(r0);
    }

    static {
        QuirkSettingsHolder.instance().observe(CameraXExecutors.directExecutor(), new a());
    }

    private DeviceQuirks() {
    }

    public static Quirks getAll() {
        return sQuirks;
    }

    public static <T extends Quirk> T get(Class<T> r1) {
        return (T) sQuirks.get(r1);
    }

    private static /* synthetic */ void lambda$static$0(QuirkSettings r1) {
        sQuirks = new Quirks(DeviceQuirksLoader.loadQuirks(r1));
        Logger.d(TAG, "camera2 DeviceQuirks = " + Quirks.toString(sQuirks));
    }
}
