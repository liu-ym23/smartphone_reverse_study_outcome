package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.core.util.Pair;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes23.dex */
public class PackageManagerWrapper {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    protected final Context f274613zza;

    public PackageManagerWrapper(Context r100) {
        this.f274613zza = r100;
    }

    public boolean isCallerInstantApp() {
        if (Binder.getCallingUid() != Process.myUid()) goto L7;
        return InstantApps.isInstantApp(this.f274613zza);
    L7:
        if (PlatformVersion.isAtLeastO() == false) goto L12;
        String r100 = this.f274613zza.getPackageManager().getNameForUid(Binder.getCallingUid());
        if (r100 != null) goto L11;
        return false;
    L11:
        return this.f274613zza.getPackageManager().isInstantApp(r100);
    L12:
        return false;
    }

    public int checkCallingOrSelfPermission(String r100) {
        return this.f274613zza.checkCallingOrSelfPermission(r100);
    }

    public CharSequence getApplicationLabel(String r100) throws PackageManager.NameNotFoundException {
        Context r101 = this.f274613zza;
        return r101.getPackageManager().getApplicationLabel(r101.getPackageManager().getApplicationInfo(r100, 0));
    }

    @ResultIgnorabilityUnspecified
    public Pair<CharSequence, Drawable> getApplicationLabelAndIcon(String r100) throws PackageManager.NameNotFoundException {
        ApplicationInfo r101 = this.f274613zza.getPackageManager().getApplicationInfo(r100, 0);
        return Pair.create(this.f274613zza.getPackageManager().getApplicationLabel(r101), this.f274613zza.getPackageManager().getApplicationIcon(r101));
    }

    @ResultIgnorabilityUnspecified
    public int checkPermission(String r100, String r101) {
        return this.f274613zza.getPackageManager().checkPermission(r100, r101);
    }

    @ResultIgnorabilityUnspecified
    public ApplicationInfo getApplicationInfo(String r100, int r101) throws PackageManager.NameNotFoundException {
        return this.f274613zza.getPackageManager().getApplicationInfo(r100, r101);
    }

    @ResultIgnorabilityUnspecified
    public PackageInfo getPackageInfo(String r100, int r101) throws PackageManager.NameNotFoundException {
        return this.f274613zza.getPackageManager().getPackageInfo(r100, r101);
    }

    public final boolean zza(int r100, String r101) {
        if (PlatformVersion.isAtLeastKitKat() == true) goto L22;
        String[] r102 = this.f274613zza.getPackageManager().getPackagesForUid(r100);
        if (r101 == null) goto L21;
        if (r102 == null) goto L21;
        int r103 = 0;
    L16:
        if (r103 >= r102.length) goto L21;
        if (r101.equals(r102[r103]) == true) goto L19;
        r103 = r103 + 1;
        goto L16
    L19:
        return true;
    L21:
        return false;
    L22:
        AppOpsManager r104 = (AppOpsManager) this.f274613zza.getSystemService("appops");     // Catch: SecurityException -> L10
        if (r104 == null) goto L9;
        r104.checkPackage(r100, r101);     // Catch: SecurityException -> L10
        return true;
    L9:
        throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");     // Catch: SecurityException -> L10
    L10:
        return false;
    }
}
