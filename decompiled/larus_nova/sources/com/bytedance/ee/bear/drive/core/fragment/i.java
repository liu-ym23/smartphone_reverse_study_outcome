package com.bytedance.ee.bear.drive.core.fragment;

import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f224216a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(DrivePluginHost r100, com.bytedance.ee.drive.render.j r101) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L26;
        com.bytedance.ee.drive.render.k.c r102 = r101.b().d();     // Catch: Throwable -> L17
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        DriveMediaImmersiveVM r104 = r100.f();     // Catch: Throwable -> L17
        boolean r105 = r100.f224125c.isVCFollowMode();     // Catch: Throwable -> L17
        if (r104 == null) goto L23;
        if (r104.isMediaImmersiveActive(r103, r105) != true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L9:
        if (r102.f242744a != true) goto L11;
        r103 = true;
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
