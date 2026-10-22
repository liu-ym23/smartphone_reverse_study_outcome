package com.ss.android.bytedcert.adapter.bpea;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.e;
import com.bytedance.bpea.entry.api.permission.PermissionEntry;
import com.ss.android.cert.manager.ablity.ICertCompliance;

/* JADX INFO: loaded from: classes34.dex */
public class CertComplianceAdapter implements ICertCompliance {

    public static class a {
        public static void requestPermissions(Activity r100, String[] r101, int r102) {
            PermissionEntry.a(r100, r101, r102, TokenCert.with("bpea-cert_request_camera_permission"));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public CertComplianceAdapter() {
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Camera openCamera() {
        TokenCert r100 = TokenCert.with("bpea-cert_take_photo_and_video");     // Catch: Throwable -> L4
        int r101 = com.bytedance.bpea.entry.api.camera.a.f202181a;     // Catch: Throwable -> L4
        return com.bytedance.bpea.entry.api.camera.a.C2917a.b(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Camera openCamera(int r100) {
        TokenCert r101 = TokenCert.with("bpea-cert_take_photo_and_video");     // Catch: Throwable -> L4
        int r102 = com.bytedance.bpea.entry.api.camera.a.f202181a;     // Catch: Throwable -> L4
        return com.bytedance.bpea.entry.api.camera.a.C2917a.a(r100, r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void releaseCamera(Camera r100) {
        if (r100 == null) goto L11;
        TokenCert r101 = TokenCert.with("bpea-cert_take_photo_and_video");     // Catch: Throwable -> L6
        int r102 = com.bytedance.bpea.entry.api.camera.a.f202181a;     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.camera.a.C2917a.c(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void releaseRecord(AudioRecord r100) {
        if (r100 == null) goto L11;
        TokenCert r101 = TokenCert.with("bpea-cert_record_audio");     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.b(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void startRecord(AudioRecord r100) {
        if (r100 == null) goto L11;
        TokenCert r101 = TokenCert.with("bpea-cert_record_audio");     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.c(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void stopRecord(AudioRecord r100) {
        if (r100 == null) goto L11;
        TokenCert r101 = TokenCert.with("bpea-cert_record_audio");     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();     // Catch: Throwable -> L6
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.d(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Sensor getDefaultSensor(SensorManager r100, int r101) {
        if (r100 == null) goto L19;
        TokenCert r102 = TokenCert.with("bpea-cert_sensor_get_phone_orientation");     // Catch: Throwable -> L11
        int r103 = e.f202188a;     // Catch: Throwable -> L11
    L18:
        return e.a.a(r100, r101, r102);
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    L19:
        return null;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void requestPermissions(Activity r100, String[] r101, int r102) {
        a.requestPermissions(r100, r101, r102);
    }
}
