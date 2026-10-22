package com.oplus.ocs.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes34.dex */
public class ServiceCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f404308a = null;

    public ServiceCheck() {
    }

    static {
        f404308a = "ServiceCheck";
    }

    public static boolean a(Context r100) {
        if (a(r100, "com.coloros.ocs.opencapabilityservice") == false) goto L5;
        return true;
    L5:
        if (a(r100, "com.oplus.ocs") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean b(Context r100) {
        if (b(r100, "com.coloros.ocs.opencapabilityservice") == false) goto L5;
        return true;
    L5:
        if (b(r100, "com.oplus.ocs") == true) goto L11;
        return false;
    L11:
        return true;
    }

    private static boolean a(Context r100, String r101) {
        Bundle r102 = r100.getPackageManager().getApplicationInfo(r101, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L11
        if (r102 != null) goto L6;
    L10:
        return false;
    L6:
        if (r102.containsKey("ocs_internal") == false) goto L10;
        if (r102.getInt("ocs_internal", 0) != 1) goto L10;
        return true;
    L11:
        e = move-exception;
        a.d(f404308a, String.format("Unable to fetch metadata from teh manifest %s", new Object[]{e.getMessage()}));
        return false;
    }

    private static boolean b(Context r100, String r101) {
        Bundle r102 = r100.getPackageManager().getApplicationInfo(r101, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L14
        if (r102 != null) goto L6;
    L13:
        return false;
    L6:
        if (r102.containsKey("ocs_internal") == false) goto L13;
        if (r102.containsKey("ocs_optimize") == false) goto L13;
        int r103 = r102.getInt("ocs_internal", 0);
        int r104 = r102.getInt("ocs_optimize", 0);
        if (r103 != 1) goto L13;
        if (r104 != 1) goto L13;
        return true;
    L14:
        e = move-exception;
        a.d(f404308a, String.format("Unable to fetch metadata from teh manifest %s", new Object[]{e.getMessage()}));
        return false;
    }

    public static boolean check(Context r100, String r101) {
        int r102 = r100.getPackageManager().getApplicationInfo(r101, 128).uid;     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (r102 == 0) goto L8;
        return true;
    L8:
        return false;
    L5:
        a.d(f404308a, String.format("%s not found", new Object[]{r101}));
        r102 = 0;
        goto L6
    }
}
