package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes23.dex */
public final class UidVerifier {
    private UidVerifier() {
    }

    public static boolean isGooglePlayServicesUid(Context r100, int r101) {
        if (uidHasPackageName(r100, r101, "com.google.android.gms") == true) goto L12;
        return false;
    L12:
        PackageInfo r102 = r100.getPackageManager().getPackageInfo("com.google.android.gms", 64);     // Catch: PackageManager.NameNotFoundException -> L11
        return GoogleSignatureVerifier.getInstance(r100).isGooglePublicSignedPackage(r102);
    L14:
        return false;
    }

    public static boolean uidHasPackageName(Context r100, int r101, String r102) {
        return Wrappers.packageManager(r100).zza(r101, r102);
    }
}
