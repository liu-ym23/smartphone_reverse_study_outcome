package com.bytedance.ee.bear.drive.core.fragment;

import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(DrivePluginHost r3, com.bytedance.ee.drive.render.j r4) {
        if (r3 == null) goto L22;
        if (r4 == null) goto L26;
        com.bytedance.ee.drive.render.k.c r5 = r4.b().d();     // Catch: Throwable -> L17
        if (r5 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        DriveMediaImmersiveVM r2 = r3.f();     // Catch: Throwable -> L17
        boolean r7 = r3.c.isVCFollowMode();     // Catch: Throwable -> L17
        if (r2 == null) goto L23;
        if (r2.isMediaImmersiveActive(r6, r7) != true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L9:
        if (r5.a != true) goto L11;
        r6 = true;
    L17:
        th = move-exception;
        tt5.a.l("DRIVE_CACHE_FLOW", "media immersive active resolve failed", th);
        return false;
    L26:
        return false;
    L22:
        return false;
    }
}
