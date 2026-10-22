package com.huawei.secure.android.common;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public abstract class HiPkgSignManager {
    public HiPkgSignManager() {
    }

    public static byte[] getInstalledAPPSignature(Context r100, String r101) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAPPSignature(r100, r101);
    }

    public static String getInstalledAppHash(Context r100, String r101) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAppHash(r100, r101);
    }

    public static byte[] getUnInstalledAPPSignature(Context r100, String r101) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAPPSignature(r100, r101);
    }

    public static String getUnInstalledAppHash(Context r100, String r101) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAppHash(r100, r101);
    }

    public static boolean doCheckInstalled(Context r100, String r101, String r102) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckInstalled(r100, r101, r102);
    }

    public static boolean doCheckArchiveApk(Context r100, String r101, String r102, String r103) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckArchiveApk(r100, r101, r102, r103);
    }
}
