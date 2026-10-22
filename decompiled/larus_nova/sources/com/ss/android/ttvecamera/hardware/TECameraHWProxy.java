package com.ss.android.ttvecamera.hardware;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraHWProxy extends TECameraHardware2Proxy {
    private static boolean isYale() {
        ArrayList r100 = new ArrayList();
        r100.add("YAL-AL00");
        r100.add("YAL-AL10");
        r100.add("YAL-TL00");
        r100.add("YAL-TL10");
        r100.add("YAL-L21");
        r100.add("YAL-L41");
        r100.add("YAL-AL50");
        r100.add("YAL-TL50");
        r100.add("YAL-L51");
        r100.add("SEA-AL00");
        r100.add("SEA-TL00");
        r100.add("SEA-AL10");
        r100.add("SEA-TL10");
        return r100.contains(Build.MODEL);
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public boolean isSupportWideAngle() {
        if ("0".equals(getWideAngleID()) == true) goto L5;
    L8:
        return true;
    L5:
        if (isYale() == true) goto L8;
        return false;
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public String getWideAngleID() {
        if (isYale() == false) goto L7;
        return "3";
    L7:
        return super.getWideAngleID();
    }

    public TECameraHWProxy(Context r100) {
        super(r100);
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public boolean isSupportWideAngle(CameraCharacteristics r100) {
        Integer r101 = (Integer) r100.get(CameraCharacteristics.LENS_FACING);
        if (r101 != null) goto L5;
    L7:
        float r102 = ((float[]) r100.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS))[0];
        return false;
    L5:
        if (r101.intValue() != 0) goto L7;
        return false;
    }
}
