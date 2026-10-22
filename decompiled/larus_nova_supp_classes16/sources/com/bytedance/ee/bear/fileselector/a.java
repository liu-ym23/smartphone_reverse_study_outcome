package com.bytedance.ee.bear.fileselector;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.fileselector.a$a, reason: collision with other inner class name */
    public interface InterfaceC0191a {
        void a();

        void onUnavailable();
    }

    static {
    }

    @JvmStatic
    public static final void a(Context r4, InterfaceC0191a r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Object r6 = r4.getSystemService("camera");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager r7 = (CameraManager) r6;
        boolean r0 = !ArraysKt.contains(r7.getCameraIdList(), DiagramData$RESULT.SUCCESS);
        boolean r1 = !ArraysKt.contains(r7.getCameraIdList(), DiagramData$RESULT.FAIL);
        int r8 = r7.getCameraIdList().length;
        tt5.a.h("CameraUtils", "OpenCameraSimple, count:" + r8 + ", facingBackCameraAvailable:" + r0 + ", facingFrontCameraAvailable:" + r1);
        if (r8 <= 0) goto L7;
        if (r0 == false) goto L6;
        if (r1 == true) goto L7;
    L6:
        r5.a();
        return;
    L7:
        r5.onUnavailable();
    }
}
