package com.ss.android.cert.manager.bpea;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;
import androidx.core.app.ActivityCompat;
import com.bytedance.permissions.annotation.PermissionsRequest;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import f06.b;
import f06.c;
import f06.d;
import fna.g;
import hna.a;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultCertCompliance implements ICertCompliance {
    public DefaultCertCompliance() {
    }

    private static Camera com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open() {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r110 = new b();
        d r111 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r110);
        if (r111.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r110, false);
        return (Camera) r111.f474983b;
    L6:
        Camera r112 = Camera.open();
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r112, r110, true);
        return r112;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Camera openCamera() {
        return com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open();
    }

    public static void INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r100) {
        if (g.d() == true) goto L6;
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_startRecording(r100);
        return;
    L6:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_startRecording(r100);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        a.b(r100.hashCode());
        return;
    }

    public static void INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(AudioRecord r100) {
        if (g.d() == true) goto L6;
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_stop(r100);
        return;
    L6:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_stop(r100);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        a.c(r100.hashCode());
        return;
    }

    private static Camera com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open(int r110) {
        c r100 = new c();
        Object[] r101 = {Integer.valueOf(r110)};
        b r111 = new b();
        d r112 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r111, false);
        return (Camera) r112.f474983b;
    L6:
        Camera r113 = Camera.open(r110);
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r113, r111, true);
        return r113;
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_release(Camera r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_release(AudioRecord r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_startRecording(AudioRecord r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_stop(AudioRecord r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Camera openCamera(int r100) {
        return com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open(r100);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void releaseCamera(Camera r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_release(r100);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void releaseRecord(AudioRecord r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_release(r100);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void startRecord(AudioRecord r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(r100);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void stopRecord(AudioRecord r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(r100);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Sensor getDefaultSensor(SensorManager r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getDefaultSensor(r101);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    @PermissionsRequest(forceAllPermissionsRequest = true, scene = "certification")
    public void requestPermissions(Activity r100, String[] r101, int r102) {
        ActivityCompat.requestPermissions(r100, r101, r102);
    }
}
