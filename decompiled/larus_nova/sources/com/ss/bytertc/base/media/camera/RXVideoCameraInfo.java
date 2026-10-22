package com.ss.bytertc.base.media.camera;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.realx.base.RXLogging;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class RXVideoCameraInfo {
    private static final int CAMERA_BACK = 1;
    private static final int CAMERA_EXTERNAL = 2;
    private static final int CAMERA_FRONT = 0;
    private static final int CAMERA_INVALID = 3;
    private static final String TAG = "RXVideoCameraInfo";
    private ArrayList<DeviceInfo> deviceInfos;

    public class DeviceInfo {
        int cameraId;
        String name;
        final /* synthetic */ RXVideoCameraInfo this$0;

        public DeviceInfo(RXVideoCameraInfo r100) {
            this.this$0 = r100;
        }
    }

    public int getDeviceNumbers() {
        return this.deviceInfos.size();
    }

    public RXVideoCameraInfo() {
        RXLogging.i(TAG, "RXVideoCameraInfo Created...");
        this.deviceInfos = new ArrayList();
        Camera1Enumerator r100 = new Camera1Enumerator(true, false);     // Catch: IllegalArgumentException -> L14
        String[] r101 = r100.getDeviceNames();     // Catch: IllegalArgumentException -> L14
        int r102 = r101.length;     // Catch: IllegalArgumentException -> L14
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L20;
        String r104 = r101[r103];     // Catch: IllegalArgumentException -> L14
        DeviceInfo r105 = new DeviceInfo(this);     // Catch: IllegalArgumentException -> L14
        r105.name = r104;     // Catch: IllegalArgumentException -> L14
        if (r100.isFrontFacing(r104) == false) goto L9;
        r105.cameraId = 0;     // Catch: IllegalArgumentException -> L14
    L12:
        this.deviceInfos.add(r105);     // Catch: IllegalArgumentException -> L14
        r103 = r103 + 1;
        goto L4
    L9:
        if (r100.isBackFacing(r104) == false) goto L11;
        r105.cameraId = 1;     // Catch: IllegalArgumentException -> L14
        goto L12
    L11:
        r105.cameraId = 2;     // Catch: IllegalArgumentException -> L14
        goto L12
    L20:
        return;
    L14:
        e = move-exception;
        RXLogging.i(TAG, "Create VideoCapture failed : " + e.getMessage());
    }

    public int getCameraId(int r100) {
        if (r100 < this.deviceInfos.size()) goto L7;
        return 3;
    L7:
        return ((DeviceInfo) ListProtector.get(this.deviceInfos, r100)).cameraId;
    }

    public String getDeviceName(int r100) {
        if (r100 < this.deviceInfos.size()) goto L7;
        return null;
    L7:
        return ((DeviceInfo) ListProtector.get(this.deviceInfos, r100)).name;
    }
}
