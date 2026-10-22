package com.bytedance.bdlocation.scan.bluetooth;

import androidx.camera.video.AudioStats;
import kotlin.UByte;

/* JADX INFO: loaded from: classes10.dex */
public class BluetoothUtil {
    public static final String BLE_SCAN_TRACE = "ble_scan_trace";
    public static final int SHAKE_TYPE = 1;
    public static final int UPLOAD_TYPE = 2;
    public static final byte[] hex = null;

    public BluetoothUtil() {
    }

    public static int byteToInt(byte r100, byte r101) {
        return ((r100 & UByte.MAX_VALUE) * 256) + (r101 & UByte.MAX_VALUE);
    }

    static {
        hex = "0123456789ABCDEF".getBytes();
    }

    public static String Bytes2HexString(byte[] r100) {
        byte[] r101 = new byte[r100.length * 2];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r102 * 2;
        byte[] r104 = hex;
        r101[r103] = r104[(r100[r102] >> 4) & 15];
        r101[r103 + 1] = r104[r100[r102] & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    public static byte charToByte(char r100) {
        return (byte) "0123456789ABCDEF".indexOf(r100);
    }

    public static byte[] hexStringToBytes(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == true) goto L13;
        String r101 = r100.toUpperCase();
        int r102 = r101.length() / 2;
        char[] r103 = r101.toCharArray();
        byte[] r104 = new byte[r102];
        int r105 = 0;
    L7:
        if (r105 >= r102) goto L9;
        int r106 = r105 * 2;
        int r107 = charToByte(r103[r106]) << 4;
        r104[r105] = (byte) (charToByte(r103[r106 + 1]) | r107);
        r105 = r105 + 1;
        goto L7
    L9:
        return r104;
    L13:
        return null;
    }

    public static double calculateAccuracy(int r100, double r101) {
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return -1.0d;
    L6:
        double r102 = (r101 * 1.0d) / ((double) r100);
        if (r102 >= 1.0d) goto L11;
        return Math.pow(r102, 10.0d);
    L11:
        return (Math.pow(r102, 7.7095d) * 0.89976d) + 0.111d;
    }
}
