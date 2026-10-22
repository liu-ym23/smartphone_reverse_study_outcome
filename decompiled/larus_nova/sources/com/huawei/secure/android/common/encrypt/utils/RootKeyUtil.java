package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;

/* JADX INFO: loaded from: classes23.dex */
public class RootKeyUtil {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278049b = "RootKeyUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f278050a;

    public byte[] getRootKey() {
        return (byte[]) this.f278050a.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.f278050a);
    }

    private RootKeyUtil() {
        this.f278050a = null;
    }

    private void a(String r100, String r101, String r102, byte[] r103) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        b.c(f278049b, "initRootKey: sha1");
        this.f278050a = BaseKeyUtil.exportRootKey(r100, r101, r102, r103, false);
        return;
    L5:
        b.c(f278049b, "initRootKey: sha256");
        this.f278050a = BaseKeyUtil.exportRootKey(r100, r101, r102, r103, true);
    }

    public static RootKeyUtil newInstance(String r100, String r101, String r102, String r103) {
        RootKeyUtil r104 = new RootKeyUtil();
        r104.a(r100, r101, r102, r103);
        return r104;
    }

    private void a(String r100, String r101, String r102, String r103) {
        a(r100, r101, r102, HexUtil.hexStr2ByteArray(r103));
    }

    public static RootKeyUtil newInstance(String r100, String r101, String r102, byte[] r103) {
        RootKeyUtil r104 = new RootKeyUtil();
        r104.a(r100, r101, r102, r103);
        return r104;
    }
}
