package com.huawei.secure.android.common.encrypt.rootkey;

import android.os.Build;
import com.huawei.secure.android.common.encrypt.exception.RootKeyGenException;
import com.huawei.secure.android.common.encrypt.exception.RootKeyParamException;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;

/* JADX INFO: loaded from: classes23.dex */
public class RootKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278015a = "RootKey";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278016b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f278017c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f278018d = 32;

    private static int a(int r100, int r101, int r102) {
        if (r101 >= r100) goto L4;
        r100 = r101;
    L4:
        if (r102 >= r100) goto L7;
        return r102;
    L7:
        return r100;
    }

    private static boolean a(int r100) {
        if (r100 < 16) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean b(int r100) {
        if (r100 < 16) goto L5;
        return true;
    L5:
        return false;
    }

    public RootKey() {
    }

    private static void a(RootKeyConfig r100) throws RootKeyParamException {
        if (r100 != null) goto L4;
        b.b(f278015a, "rootKeyConfig is null.");
        throw new RootKeyParamException("rootKeyConfig is null.");
    L4:
        if (a(r100.getExportLen()) == true) goto L6;
        b.b(f278015a, "exportLen length must be more than 128bit.");
        throw new RootKeyParamException("exportLen length must be more than 128bit.");
    L6:
        if (r100.getExportLen() >= 32) goto L9;
        b.e(f278015a, "It is recommended that the exported length be greater than or equal to 256 bits.");
    L9:
        if (a(r100.getExportLen(), r100.getFirst()) == true) goto L11;
        b.b(f278015a, "material(first) length must be Greater than or equal to export length.");
        throw new RootKeyParamException("material(first) length must be Greater than or equal to export length.");
    L11:
        if (a(r100.getExportLen(), r100.getSecond()) == true) goto L13;
        b.b(f278015a, "material(second) length must be Greater than or equal to export length.");
        throw new RootKeyParamException("material(second) length must be Greater than or equal to export length.");
    L13:
        if (a(r100.getExportLen(), r100.getThird()) == false) goto L15;
        return;
    L15:
        b.b(f278015a, "material(third) length must be Greater than or equal to export length.");
        throw new RootKeyParamException("material(third) length must be Greater than or equal to export length.");
    }

    public static byte[] exportRootKey(RootKeyConfig r100) throws RootKeyParamException, RootKeyGenException {
        a(r100);
        byte[] r101 = HexUtil.hexStr2ByteArray(r100.getFirst());
        byte[] r102 = HexUtil.hexStr2ByteArray(r100.getSecond());
        byte[] r103 = HexUtil.hexStr2ByteArray(r100.getThird());
        int r104 = a(r101.length, r102.length, r103.length);
        if (a(r104, r100.getSalt()) == false) goto L21;
        char[] r105 = new char[r104];
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L8;
        r105[r106] = (char) ((r101[r106] ^ r102[r106]) ^ r103[r106]);
        r106 = r106 + 1;
        goto L5
    L8:
        if (r100.isSha256() == true) goto L10;
        b.c(f278015a, "exportRootKey: sha1");
        byte[] r107 = PBKDF2.pbkdfBottom(r105, r100.getSalt(), r100.getIteration(), r100.getExportLen() * 8, false);
    L14:
        if (r107 == null) goto L19;
        if (r107.length == 0) goto L19;
        return r107;
    L19:
        throw new RootKeyGenException("Failed to generate the rootkey.");
    L10:
        String r108 = f278015a;
        b.c(r108, "exportRootKey: sha256");
        if (Build.VERSION.SDK_INT >= 26) goto L13;
        b.b(r108, "system version not high than 26");
        r107 = null;
        goto L14
    L13:
        r107 = PBKDF2.pbkdfBottom(r105, r100.getSalt(), r100.getIteration(), r100.getExportLen() * 8, true);
        goto L14
    L21:
        throw new RootKeyParamException("key length must be more than 128bit.");
    }

    private static boolean a(byte[] r100) {
        if (r100.length < 16) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean a(int r100, String r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r101.length() < r100) goto L6;
        return true;
    }

    private static boolean a(int r100, byte[] r101) {
        return b(r100) & a(r101);
    }
}
