package j4a;

import android.content.Intent;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j {
    static {
    }

    public static void a(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        r100.putExtra("android.intent.extras.CAMERA_FACING", 0);
        r100.putExtra("android.intent.extras.LENS_FACING_BACK", 1);
        r100.putExtra("default_camera", "0");
        r100.putExtra("default_mode", "com.huawei.camera2.mode.photo.PhotoMode");
        r100.putExtra("camerafacing", "back");
        r100.putExtra("previous_mode", "back");
    }

    public static void b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        r100.putExtra("android.intent.extras.CAMERA_FACING", 1);
        r100.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
        r100.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        r100.putExtra("default_camera", "1");
        r100.putExtra("default_mode", "com.huawei.camera2.mode.photo.PhotoMode");
        r100.putExtra("camerafacing", NewBroadcastMonitor.CAPTURE.FRONT);
        r100.putExtra("previous_mode", NewBroadcastMonitor.CAPTURE.FRONT);
    }
}
