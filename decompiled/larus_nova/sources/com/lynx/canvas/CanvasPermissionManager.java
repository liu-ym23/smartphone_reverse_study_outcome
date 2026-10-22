package com.lynx.canvas;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes32.dex */
public class CanvasPermissionManager {
    private static final String TAG = "KryptonCanvasPermissionManager";

    public CanvasPermissionManager() {
    }

    private static native void nativeOnUserMediaPermissionResponse(long r100, boolean r101);

    public static /* synthetic */ void access$000(long r100, boolean r101) {
        nativeOnUserMediaPermissionResponse(r100, r101);
    }

    private static boolean RequestUserMediaGranted(KryptonApp r100, boolean r101, boolean r102) {
        return DoRequest(r100, r101, r102, null);
    }

    private static boolean DoRequest(KryptonApp r100, boolean r101, boolean r102, KryptonPermissionService.Responder r103) {
        if (r100 != null) goto L5;
    L26:
        return false;
    L5:
        if (r100.isNativeReady() == false) goto L26;
        KryptonPermissionService r104 = (KryptonPermissionService) r100.getService(KryptonPermissionService.class);
        if (r104 != null) goto L12;
        if (r103 == null) goto L11;
        KryptonLLog.i(TAG, "request permission video:" + r101 + " audio:" + r102 + " force allow, no permission service found");
        r103.onResponse(true);
    L11:
        return true;
    L12:
        LinkedList r105 = new LinkedList();
        if (r101 == false) goto L15;
        r105.add(KryptonPermissionService.PermissionType.CAMERA);
    L15:
        if (r102 == false) goto L18;
        r105.add(KryptonPermissionService.PermissionType.RECORD_AUDIO);
    L18:
        if (r104.requestGranted(r105) == false) goto L22;
        if (r103 == null) goto L21;
        r103.onResponse(true);
    L21:
        return true;
    L22:
        if (r103 != null) goto L24;
        return false;
    L24:
        r104.requestPermission(r105, r103);
        return true;
    }

    private static void RequestUserMediaPermission(KryptonApp r100, final boolean r101, final boolean r102, final long r103) {
        DoRequest(r100, r101, r102, new AnonymousClass1(r101, r102, r103));
    }
}
