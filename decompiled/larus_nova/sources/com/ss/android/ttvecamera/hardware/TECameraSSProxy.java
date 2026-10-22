package com.ss.android.ttvecamera.hardware;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.util.SizeF;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraSSProxy extends TECameraHardware2Proxy {
    public Map<String, Float> sizeMap;

    public String getRightCam() {
        Map<String, Float> r100 = this.sizeMap;
        if (r100 != null) goto L6;
        return null;
    L6:
        Iterator<String> r101 = r100.keySet().iterator();
        float r102 = 0.0f;
        String r103 = "";
    L8:
        if (r101.hasNext() == false) goto L12;
        String r104 = r101.next();
        float r105 = this.sizeMap.get(r104).floatValue();
        if (r102 >= r105) goto L8;
        r103 = r104;
        r102 = r105;
        goto L8
    L12:
        return r103;
    }

    public TECameraSSProxy(Context r100) {
        super(r100);
        this.sizeMap = new HashMap();
    }

    public void addCamera(CameraCharacteristics r100, String r101) {
        float r102 = ((SizeF) r100.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)).getHeight();
        this.sizeMap.put(r101, Float.valueOf(r102));
    }

    public String selectCamera(CameraManager r100, int r110, String[] r111) throws CameraAccessException {
        int r101 = r111.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L13;
        String r104 = r111[r102];
        CameraCharacteristics r105 = r100.getCameraCharacteristics(r104);
        if (((Integer) r105.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L7;
        int r106 = 0;
    L8:
        if (r106 != r110) goto L11;
        if (r106 != 1) goto L11;
        addCamera(r105, r104);
        r103 = r103 + 1;
    L11:
        r102 = r102 + 1;
        goto L3
    L7:
        r106 = 1;
        goto L8
    L13:
        if (r103 >= 2) goto L15;
        return null;
    L15:
        return getRightCam();
    }
}
