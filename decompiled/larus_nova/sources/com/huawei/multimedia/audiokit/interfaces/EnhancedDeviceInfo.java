package com.huawei.multimedia.audiokit.interfaces;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;

/* JADX INFO: loaded from: classes23.dex */
public class EnhancedDeviceInfo {
    private static final int BLUETOOTH_A2DP_FB_RECORDING = 10005;
    private static final Object LOCK_ISFULLBAND_RECORD_SUPPORTED = null;
    private static final Object LOCK_ISKARAOKE_SUPPORTED = null;
    private static final String TAG = "HwAudioKit.EnhancedDeviceInfo";
    private static BluetoothAdapter mBluetoothAdapter;
    private static BluetoothDevice mBluetoothDevice;
    private AudioManager mAudioManager;
    private Context mContext;
    private int mDeviceType;

    static {
        LOCK_ISKARAOKE_SUPPORTED = new Object();
        LOCK_ISFULLBAND_RECORD_SUPPORTED = new Object();
    }

    private void createAudioManager() {
        if (this.mAudioManager != null) goto L8;
        Object r100 = this.mContext.getSystemService("audio");
        if ((r100 instanceof AudioManager) == false) goto L9;
        this.mAudioManager = (AudioManager) r100;
        return;
    L9:
        return;
    }

    private static boolean isBluetoothFBRecording() {
        boolean r100 = false;
        boolean r101 = true;
        Object r102 = BluetoothDevice.class.getMethod("getMetadata", new Class[]{Integer.TYPE}).invoke(mBluetoothDevice, new Object[]{10005});     // Catch: Throwable -> L17 NoSuchMethodException -> L18
        if ((r102 instanceof byte[]) == false) goto L23;
        byte[] r103 = (byte[]) r102;     // Catch: Throwable -> L17 NoSuchMethodException -> L18
        if (r103.length <= 0) goto L24;
        if (r103[0] != 0) goto L21;
        r101 = false;
    L21:
        LogUtils.info(TAG, "isBluetoothFBRecording byteArray[0]=" + r103[0]);     // Catch: Throwable -> L12 NoSuchMethodException -> L13
    L25:
        return r101;
    L12:
        r100 = r101;
    L13:
        r100 = r101;
        goto L15
    L24:
        return false;
    L23:
        return false;
    L14:
        LogUtils.error(TAG, "isBluetoothFBRecording Exception");
        return r100;
    L15:
        LogUtils.error(TAG, "No Such Method getMetadata");
        return r100;
    }

    public boolean isFullbandRecordSupported() {
        Object r100 = LOCK_ISFULLBAND_RECORD_SUPPORTED;
        monitor-enter(r100);
        int r101 = this.mDeviceType;     // Catch: Throwable -> L20
        if (r101 == 3) goto L16;
        boolean r102 = false;
        if (r101 != 4) goto L9;
    L17:
        LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isFbRecordSupported=" + r102);     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return r102;
    L9:
        if (r101 != 8) goto L11;
        createAudioManager();     // Catch: Throwable -> L20
        r102 = getBluetoothFBEnable(this.mAudioManager);     // Catch: Throwable -> L20
        goto L17
    L11:
        if (r101 == 11) goto L16;
        if (r101 != 22) goto L17;
    L16:
        r102 = true;
    L20:
        th = move-exception;
        throw th;
    }

    public boolean isKaraokeSupported() {
        Object r100 = LOCK_ISKARAOKE_SUPPORTED;
        monitor-enter(r100);
        int r101 = this.mDeviceType;     // Catch: Throwable -> L20
        if (r101 != 3) goto L7;
    L16:
        boolean r102 = true;
    L17:
        LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isDeviceSupported=" + r102);     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return r102;
    L7:
        if (r101 == 4) goto L16;
        if (r101 != 8) goto L11;
        createAudioManager();     // Catch: Throwable -> L20
        r102 = getBluetoothFBEnable(this.mAudioManager);     // Catch: Throwable -> L20
        goto L17
    L11:
        if (r101 == 11) goto L16;
        if (r101 == 22) goto L16;
        r102 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean getBluetoothFBEnable(AudioManager r100) {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        AudioDeviceInfo[] r101 = new AudioDeviceInfo[0];
        if (r100 == null) goto L5;
        r101 = r100.getDevices(2);
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L15;
        AudioDeviceInfo r104 = r101[r103];
        if (r104.getType() != 8) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(r104.getAddress());
    L13:
        r103 = r103 + 1;
        goto L6
    L10:
        r105 = false;
        goto L11
    L15:
        if (mBluetoothDevice != null) goto L18;
        return false;
    L18:
        return isBluetoothFBRecording();
    }

    public EnhancedDeviceInfo(Context r100, int r101) {
        this.mAudioManager = null;
        this.mContext = r100;
        this.mDeviceType = r101;
    }
}
