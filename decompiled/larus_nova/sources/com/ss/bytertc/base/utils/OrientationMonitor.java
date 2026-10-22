package com.ss.bytertc.base.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.realx.base.ContextUtils;
import com.ss.bytertc.engine.UIDeviceOrientation;
import faceverify.w;
import fna.g;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: classes40.dex */
public class OrientationMonitor {
    private Context mContext;
    private GravityOrientationDetector mGravitySensorListener;
    private long mNativeObj;

    public class GravityOrientationDetector implements SensorEventListener {
        private int mGravityOrientation;
        final /* synthetic */ OrientationMonitor this$0;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r100, int r101) {
        }

        public GravityOrientationDetector(OrientationMonitor r100) {
            this.this$0 = r100;
            this.mGravityOrientation = UIDeviceOrientation.Portrait.value();
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r100) {
            float[] r101 = r100.values;
            float r102 = r101[0];
            float r103 = r101[1];
            float r104 = Math.abs(r102);
            float r105 = Math.abs(r103);
            if (Math.abs(r104 - r105) >= 6.0d) goto L6;
            return;
        L6:
            if (r104 < r105) goto L12;
            if (r102 < 0.0f) goto L10;
            int r106 = UIDeviceOrientation.LandscapeRight.value();
        L16:
            if (r106 == this.mGravityOrientation) goto L19;
            this.mGravityOrientation = r106;
            OrientationMonitor.nativeOnGravityOrientationChange(OrientationMonitor.access$000(this.this$0), this.mGravityOrientation);
            return;
        L19:
            return;
        L10:
            r106 = UIDeviceOrientation.LandscapeLeft.value();
            goto L16
        L12:
            if (r103 < 0.0f) goto L14;
            r106 = UIDeviceOrientation.Portrait.value();
            goto L16
        L14:
            r106 = UIDeviceOrientation.PortraitUpsidedown.value();
            goto L16
        }
    }

    public static native void nativeOnGravityOrientationChange(long r100, int r101);

    public int getUIOrientation() {
        Context r100 = this.mContext;
        if (r100 != null) goto L6;
        this.mContext = ContextUtils.getApplicationContext();
        return -1;
    L6:
        int r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L15;
        return UIDeviceOrientation.Portrait.value();
    L15:
        return UIDeviceOrientation.LandscapeLeft.value();
    L17:
        return UIDeviceOrientation.PortraitUpsidedown.value();
    L19:
        return UIDeviceOrientation.LandscapeRight.value();
    }

    public int startGravityRotationCheck() {
        Context r100 = this.mContext;
        if (r100 != null) goto L6;
        this.mContext = ContextUtils.getApplicationContext();
        return -1;
    L6:
        SensorManager r101 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        if (r101 != null) goto L10;
        return -2;
    L10:
        Sensor r102 = r101.getDefaultSensor(9);
        if (r102 != null) goto L15;
        return -3;
    L15:
        if (this.mGravitySensorListener != null) goto L17;
        this.mGravitySensorListener = new GravityOrientationDetector(this);
    L17:
        r101.registerListener(this.mGravitySensorListener, r102, 2);
        return 0;
    }

    public int stopGravityRotationCheck() {
        Context r100 = this.mContext;
        if (r100 != null) goto L6;
        return -1;
    L6:
        SensorManager r101 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        if (r101 != null) goto L10;
        return -2;
    L10:
        GravityOrientationDetector r102 = this.mGravitySensorListener;
        if (r102 != null) goto L14;
        return -3;
    L14:
        INVOKEVIRTUAL_com_ss_bytertc_base_utils_OrientationMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r101, r102);
        return 0;
    }

    public OrientationMonitor(long r100) {
        this.mContext = null;
        this.mGravitySensorListener = null;
        this.mNativeObj = r100;
        this.mContext = ContextUtils.getApplicationContext();
    }

    public static /* synthetic */ long access$000(OrientationMonitor r100) {
        return r100.mNativeObj;
    }

    public static void INVOKEVIRTUAL_com_ss_bytertc_base_utils_OrientationMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        b.c(new a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }
}
