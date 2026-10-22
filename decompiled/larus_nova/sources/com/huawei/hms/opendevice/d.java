package com.huawei.hms.opendevice;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;

/* JADX INFO: loaded from: classes23.dex */
public abstract class d {
    public static String a(byte[] r100) {
        return HexUtil.byteArray2HexStr(r100);
    }

    public static byte[] a(String r100) {
        return HexUtil.hexStr2ByteArray(r100);
    }
}
