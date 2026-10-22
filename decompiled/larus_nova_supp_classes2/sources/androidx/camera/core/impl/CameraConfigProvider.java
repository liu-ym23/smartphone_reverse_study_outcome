package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraConfigProvider {
    public static final CameraConfigProvider EMPTY = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraConfigProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            CameraConfigProvider r0 = CameraConfigProvider.EMPTY;
        }

        public static /* synthetic */ CameraConfig lambda$static$0(CameraInfo r0, Context r1) {
            return null;
        }
    }

    CameraConfig getConfig(CameraInfo r1, Context r2);

    static {
        EMPTY = new a();
    }
}
