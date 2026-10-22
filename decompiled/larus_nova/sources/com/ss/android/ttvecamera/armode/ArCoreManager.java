package com.ss.android.ttvecamera.armode;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import com.ss.android.ttvecamera.TECameraSettings;

/* JADX INFO: loaded from: classes38.dex */
public class ArCoreManager {

    public static class Holder {
        private static final ArCoreManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new ArCoreManager();
        }

        public static /* synthetic */ ArCoreManager access$000() {
            return INSTANCE;
        }
    }

    public ArCoreManager() {
    }

    public CameraDevice.StateCallback getDevicesStateCallback() {
        return null;
    }

    public boolean init(Context r100, TECameraSettings r101) {
        return false;
    }

    public void registerEventHandler(Handler r100) {
    }

    public static ArCoreManager getInstance() {
        return Holder.access$000();
    }
}
