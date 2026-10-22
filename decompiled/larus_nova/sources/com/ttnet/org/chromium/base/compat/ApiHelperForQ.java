package com.ttnet.org.chromium.base.compat;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.biometrics.BiometricManager;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.net.Uri;
import android.os.FileUtils;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public final class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    public static int canAuthenticate(BiometricManager r100) {
        return r100.canAuthenticate();
    }

    public static BiometricManager getBiometricManagerSystemService(Context r100) {
        return (BiometricManager) r100.getSystemService(BiometricManager.class);
    }

    public static int getClassification(MotionEvent r100) {
        return r100.getClassification();
    }

    public static int getCurrentThermalStatus(PowerManager r100) {
        return r100.getCurrentThermalStatus();
    }

    public static Set<String> getExternalVolumeNames(Context r100) {
        return MediaStore.getExternalVolumeNames(r100);
    }

    public static TransportInfo getTransportInfo(NetworkCapabilities r100) {
        return r100.getTransportInfo();
    }

    public static Uri setIncludePending(Uri r100) {
        return MediaStore.setIncludePending(r100);
    }

    public static long copy(InputStream r100, OutputStream r101) throws IOException {
        return FileUtils.copy(r100, r101);
    }

    public static void requestCellInfoUpdate(TelephonyManager r100, final Callback<List<CellInfo>> r101) {
        r100.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new AnonymousClass1(r101));
    }

    public static void startForeground(Service r100, int r101, Notification r102, int r103) {
        r100.startForeground(r101, r102, r103);
    }

    public static void updateServiceGroup(Context r100, ServiceConnection r101, int r102, int r103) {
        r100.updateServiceGroup(r101, r102, r103);
    }

    public static boolean bindIsolatedService(Context r100, Intent r101, int r102, String r103, Executor r104, ServiceConnection r105) {
        return r100.bindIsolatedService(r101, r102, r103, r104, r105);
    }
}
