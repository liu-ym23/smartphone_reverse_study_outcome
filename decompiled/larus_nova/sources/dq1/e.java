package dq1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class e {
    public e() {
    }

    public void a(VSCameraInfo r100, VSCameraInfo r101, Bundle r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "targetCamera");
    }

    public void b(VSCameraInfo r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "targetCamera");
    }

    public void c() {
    }

    public void d(VSCameraInfo r100, VSCameraInfo r101) {
        Intrinsics.checkNotNullParameter(r101, "targetCamera");
    }
}
