package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f277412a = null;

    static {
        f277412a = Charset.forName("UTF-8");
    }

    public static Pair<byte[], String> a(String r100, int r101) {
        if (r100 == null) goto L10;
        if (r100.length() < r101) goto L10;
        String r102 = r100.substring(0, r101);
        String r103 = r100.substring(r101);
        return new Pair(HexUtil.hexStr2ByteArray(r102), r103);
    L10:
        return new Pair(new byte[0], r100);
    }

    public static String a(String r100, String r101) {
        Pair<byte[], String> r102 = a(r100, 32);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) r102.second), HexUtil.hexStr2ByteArray(r101), (byte[]) r102.first), f277412a);
    }

    public static String a(byte[] r100, String r101) {
        if (r100 != null) goto L5;
    L15:
        String r102 = "cbc encrypt(byte) param is not right";
    L11:
        v.b("AesCipher", r102);
        return "";
    L5:
        if (r100.length == 0) goto L15;
        if (r101 == null) goto L15;
        byte[] r103 = HexUtil.hexStr2ByteArray(r101);
        if (r103.length >= 16) goto L14;
        r102 = "key length is not right";
        goto L11
    L14:
        return HexUtil.byteArray2HexStr(AesGcm.encrypt(r100, r103));
    }

    public static String b(String r100, String r101) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(r100.getBytes(f277412a), HexUtil.hexStr2ByteArray(r101)));
    }
}
