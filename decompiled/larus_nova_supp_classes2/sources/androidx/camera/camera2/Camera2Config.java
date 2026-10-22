package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.UseCaseConfigFactory;
import f.a;
import f.b;
import f.c;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2Config {

    public static final class DefaultProvider implements CameraXConfig.Provider {
        public DefaultProvider() {
        }

        @Override // androidx.camera.core.CameraXConfig.Provider
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }

    public static /* synthetic */ UseCaseConfigFactory a(Context r0) {
        return lambda$defaultConfig$1(r0);
    }

    public static /* synthetic */ CameraDeviceSurfaceManager b(Context r0, Object r1, Set r2) {
        return lambda$defaultConfig$0(r0, r1, r2);
    }

    public static CameraXConfig defaultConfig() {
        CameraFactory.Provider r0 = new a();
        CameraDeviceSurfaceManager.Provider r1 = new b();
        UseCaseConfigFactory.Provider r2 = new c();
        return new CameraXConfig.Builder().setCameraFactoryProvider(r0).setDeviceSurfaceManagerProvider(r1).setUseCaseConfigFactoryProvider(r2).build();
    }

    private Camera2Config() {
    }

    private static /* synthetic */ UseCaseConfigFactory lambda$defaultConfig$1(Context r1) throws InitializationException {
        return new Camera2UseCaseConfigFactory(r1);
    }

    private static /* synthetic */ CameraDeviceSurfaceManager lambda$defaultConfig$0(Context r1, Object r2, Set r3) throws InitializationException {
        return new Camera2DeviceSurfaceManager(r1, r2, r3);
    L4:
        e = move-exception;
        throw new InitializationException(e);
    }
}
