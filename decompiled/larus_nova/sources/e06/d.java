package e06;

import com.bytedance.helios.sdk.HeliosEnvImpl;
import jz5.g;
import jz5.h;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f470643a = null;

    public d() {
    }

    static {
        g r100 = HeliosEnvImpl.get().f245478u;
        if (r100 == null) goto L5;
        com.bytedance.timon_monitor_impl.c r101 = r100.b("sky_eye_repo");
    L6:
        f470643a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
