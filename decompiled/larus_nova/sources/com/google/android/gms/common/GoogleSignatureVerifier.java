package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
@CheckReturnValue
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GoogleSignatureVerifier {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    @Nullable
    private static GoogleSignatureVerifier f274462zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    @Nullable
    private static volatile Set f274463zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(Context r100) {
        this.zzc = r100.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context r100) {
        Preconditions.checkNotNull(r100);
        monitor-enter(GoogleSignatureVerifier.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f274462zza != null) goto L7;
        f.a(r100);     // Catch: Throwable -> L10
        f274462zza = new GoogleSignatureVerifier(r100);     // Catch: Throwable -> L10
    L7:
        monitor-exit(GoogleSignatureVerifier.class);     // Catch: Throwable -> L10
        return f274462zza;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (zzb(r100, false) == false) goto L9;
        return true;
    L9:
        if (zzb(r100, true) == true) goto L11;
    L13:
        return false;
    L11:
        if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc) == false) goto L13;
        return true;
    }

    public boolean isPackageGoogleSigned(@Nullable String r100) {
        k r101 = zzc(r100, false, false);
        if (r101.f274582a == true) goto L11;
        if (Log.isLoggable("GoogleCertificatesRslt", 3) == false) goto L11;
        if (r101.f274583b == null) goto L9;
        r101.a();
        goto L11
    L9:
        r101.a();
    L11:
        return r101.f274582a;
    }

    public boolean isUidGoogleSigned(int r100) {
        String[] r101 = this.zzc.getPackageManager().getPackagesForUid(r100);
        if (r101 == null) goto L14;
        int r102 = r101.length;
        if (r102 == 0) goto L14;
        k r103 = null;
        int r104 = 0;
    L8:
        if (r104 >= r102) goto L13;
        r103 = zzc(r101[r104], false, false);
        if (r103.f274582a == true) goto L16;
        r104 = r104 + 1;
    L16:
        if (r103.f274582a == true) goto L24;
        if (Log.isLoggable("GoogleCertificatesRslt", 3) == false) goto L24;
        if (r103.f274583b == null) goto L22;
        r103.a();
        goto L24
    L22:
        r103.a();
    L24:
        return r103.f274582a;
    L13:
        Preconditions.checkNotNull(r103);
    L14:
        r103 = k.b("no pkgs");
        goto L16
    }

    @Nullable
    public static final zzj zza(PackageInfo r100, zzj... r101) {
        Signature[] r102 = r100.signatures;
        if (r102 != null) goto L6;
    L16:
        return null;
    L6:
        if (r102.length == 1) goto L8;
        return null;
    L8:
        int r103 = 0;
        zzk r104 = new zzk(r100.signatures[0].toByteArray());
    L10:
        if (r103 >= r101.length) goto L16;
        if (r101[r103].equals(r104) == true) goto L14;
        r103 = r103 + 1;
        goto L10
    L14:
        return r101[r103];
    }

    public static final boolean zzb(PackageInfo r100, boolean r101) {
        if (r101 == false) goto L16;
        if (r100 != null) goto L6;
        PackageInfo r102 = null;
    L17:
        if (r100 != null) goto L19;
    L25:
        return false;
    L19:
        if (r102.signatures == null) goto L25;
        if (r101 == false) goto L22;
        zzj r103 = zza(r102, e.f274487a);
    L23:
        if (r103 == null) goto L25;
        return true;
    L22:
        r103 = zza(r102, new zzj[]{e.f274487a[0]});
        goto L23
    L6:
        if ("com.android.vending".equals(r100.packageName) == false) goto L8;
    L9:
        ApplicationInfo r104 = r100.applicationInfo;
        if (r104 != null) goto L13;
    L11:
        r101 = false;
        goto L16
    L13:
        if ((r104.flags & 129) == 0) goto L11;
        r101 = true;
        goto L16
    L8:
        if ("com.google.android.gms".equals(r100.packageName) == true) goto L9;
    L16:
        r102 = r100;
        goto L17
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    private final k zzc(@Nullable String r110, boolean r111, boolean r112) {
        if (r110 != null) goto L7;
        return k.b("null pkg");
    L7:
        if (r110.equals(this.zzd) == true) goto L78;
        zzh r113 = f.f274488a;
        StrictMode.ThreadPolicy r114 = StrictMode.allowThreadDiskReads();
        f.c();     // Catch: Throwable -> L11 Throwable -> L14
        boolean r100 = f.f274490c.zzi();     // Catch: Throwable -> L11 Throwable -> L14
    L15:
        StrictMode.setThreadPolicy(r114);
        if (r100 == false) goto L79;
        boolean r101 = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
        StrictMode.ThreadPolicy r115 = StrictMode.allowThreadDiskReads();
        Preconditions.checkNotNull(f.f274492e);     // Catch: Throwable -> L37
        f.c();     // Catch: DynamiteModule.LoadingException -> L34 Throwable -> L37
        zzo r102 = new zzo(r110, r101, false, ObjectWrapper.wrap(f.f274492e), false, true);     // Catch: Throwable -> L37
        zzq r103 = f.f274490c.zze(r102);     // Catch: RemoteException -> L32 Throwable -> L37
        PackageManager.NameNotFoundException r104 = null;
        if (r103.f274626a == false) goto L25;
        c.a(r103.f274629d);     // Catch: Throwable -> L37
        k r105 = new k(true, null, null);     // Catch: Throwable -> L37
    L36:
        StrictMode.setThreadPolicy(r115);
    L71:
        if (r105.f274582a == false) goto L73;
        this.zzd = r110;
    L73:
        return r105;
    L25:
        String r116 = r103.f274627b;     // Catch: Throwable -> L37
        if (l.a(r103.f274628c) != 4) goto L29;
        r104 = new PackageManager.NameNotFoundException();     // Catch: Throwable -> L37
    L29:
        if (r116 != null) goto L31;
        r116 = "error checking package certificate";
    L31:
        c.a(r103.f274629d);     // Catch: Throwable -> L37
        l.a(r103.f274628c);     // Catch: Throwable -> L37
        r105 = new k(false, r116, r104);     // Catch: Throwable -> L37
        goto L36
    L32:
        e = move-exception;
        r105 = k.c("module call", e);     // Catch: Throwable -> L37
        goto L36
    L34:
        e = move-exception;
        r105 = k.c("module init: ".concat(String.valueOf(e.getMessage())), e);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        StrictMode.setThreadPolicy(r115);
        throw th;
    L79:
        PackageInfo r106 = this.zzc.getPackageManager().getPackageInfo(r110, 64);     // Catch: PackageManager.NameNotFoundException -> L74
        boolean r107 = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
        if (r106 != null) goto L44;
        r105 = k.b("null pkg");
        goto L71
    L44:
        Signature[] r117 = r106.signatures;
        if (r117 != null) goto L47;
    L69:
        r105 = k.b("single cert required");
        goto L71
    L47:
        if (r117.length != 1) goto L69;
        zzk r118 = new zzk(r106.signatures[0].toByteArray());
        String r108 = r106.packageName;
        StrictMode.ThreadPolicy r109 = StrictMode.allowThreadDiskReads();
        k r119 = f.b(r108, r118, r107, false);     // Catch: Throwable -> L66
        StrictMode.setThreadPolicy(r109);
        if (r119.f274582a == false) goto L65;
        ApplicationInfo r120 = r106.applicationInfo;
        if (r120 == null) goto L65;
        if ((r120.flags & 2) == 0) goto L65;
        StrictMode.ThreadPolicy r121 = StrictMode.allowThreadDiskReads();
        k r122 = f.b(r108, r118, false, true);     // Catch: Throwable -> L62
        StrictMode.setThreadPolicy(r121);
        if (r122.f274582a == false) goto L65;
        r105 = k.b("debuggable release cert app rejected");
    L62:
        th = move-exception;
        StrictMode.setThreadPolicy(r121);
        throw th;
    L65:
        r105 = r119;
    L66:
        th = move-exception;
        StrictMode.setThreadPolicy(r109);
        throw th;
    L74:
        e = move-exception;
        return k.c("no pkg ".concat(r110), e);
    L14:
        r100 = false;
    L11:
        th = move-exception;
        StrictMode.setThreadPolicy(r114);
        throw th;
    L78:
        return k.f274581c;
    }
}
