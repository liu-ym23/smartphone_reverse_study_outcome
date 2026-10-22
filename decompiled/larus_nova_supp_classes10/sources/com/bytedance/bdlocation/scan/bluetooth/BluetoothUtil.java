package com.bytedance.bdlocation.scan.bluetooth;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BluetoothUtil {
    public static final String BLE_SCAN_TRACE = "ble_scan_trace";
    public static final int SHAKE_TYPE = 1;
    public static final int UPLOAD_TYPE = 2;
    public static final byte[] hex = null;

    public BluetoothUtil() {
    }

    public static int byteToInt(byte r0, byte r1) {
        return ((r0 & 255) * DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) + (r1 & 255);
    }

    static {
        hex = "0123456789ABCDEF".getBytes();
    }

    public static String Bytes2HexString(byte[] r5) {
        byte[] r0 = new byte[r5.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L7;
        int r2 = r1 * 2;
        byte[] r3 = hex;
        r0[r2] = r3[(r5[r1] >> 4) & 15];
        r0[r2 + 1] = r3[r5[r1] & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    public static byte charToByte(char r1) {
        return (byte) "0123456789ABCDEF".indexOf(r1);
    }

    public static byte[] hexStringToBytes(String r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.equals("") == true) goto L13;
        String r6 = r5.toUpperCase();
        int r0 = r6.length() / 2;
        char[] r7 = r6.toCharArray();
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        int r3 = r2 * 2;
        int r4 = charToByte(r7[r3]) << 4;
        r1[r2] = (byte) (charToByte(r7[r3 + 1]) | r4);
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L13:
        return null;
    }

    public static double calculateAccuracy(int r4, double r5) {
        if (r5 != 0.0d) goto L6;
        return -1.0d;
    L6:
        double r6 = (r5 * 1.0d) / ((double) r4);
        if (r6 >= 1.0d) goto L11;
        return Math.pow(r6, 10.0d);
    L11:
        return (Math.pow(r6, 7.7095d) * 0.89976d) + 0.111d;
    }
}
