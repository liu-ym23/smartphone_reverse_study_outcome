package com.bytedance.ee.bear.fileselector;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.fileselector.a$a, reason: collision with other inner class name */
    public interface InterfaceC3247a {
        void a();

        void onUnavailable();
    }

    static {
    }

    @JvmStatic
    public static final void a(Context r100, InterfaceC3247a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Object r102 = r100.getSystemService("camera");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager r103 = (CameraManager) r102;
        boolean r104 = !ArraysKt.contains(r103.getCameraIdList(), "1");
        boolean r105 = !ArraysKt.contains(r103.getCameraIdList(), "0");
        int r106 = r103.getCameraIdList().length;
        tt5.a.h("CameraUtils", "OpenCameraSimple, count:" + r106 + ", facingBackCameraAvailable:" + r104 + ", facingFrontCameraAvailable:" + r105);
        if (r106 <= 0) goto L7;
        if (r104 == false) goto L6;
        if (r105 == true) goto L7;
    L6:
        r101.a();
        return;
    L7:
        r101.onUnavailable();
    }
}
