package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidException;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class PackageManagerHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PackageManager f277898a;

    public static final enum PackageStates extends Enum<PackageStates> {
        public static final PackageStates DISABLED = null;
        public static final PackageStates ENABLED = null;
        public static final PackageStates NOT_INSTALLED = null;
        public static final PackageStates SPOOF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ PackageStates[] f277899a = null;

        static {
            PackageStates r100 = new PackageStates("ENABLED", 0);
            ENABLED = r100;
            PackageStates r101 = new PackageStates("DISABLED", 1);
            DISABLED = r101;
            PackageStates r102 = new PackageStates("NOT_INSTALLED", 2);
            NOT_INSTALLED = r102;
            PackageStates r103 = new PackageStates("SPOOF", 3);
            SPOOF = r103;
            f277899a = new PackageStates[]{r100, r101, r102, r103};
        }

        public static PackageStates[] values() {
            return (PackageStates[]) f277899a.clone();
        }

        public static PackageStates valueOf(String r100) {
            return (PackageStates) a.a(PackageStates.class, r100);
        }

        private PackageStates(String r100, int r101) {
            super(r100, r101);
        }
    }

    public PackageManagerHelper(Context r100) {
        this.f277898a = r100.getPackageManager();
    }

    private byte[] a(String r100) {
        PackageInfo r101 = this.f277898a.getPackageInfo(r100, 64);     // Catch: RuntimeException -> L11 AndroidException -> L13
        if (r101 == null) goto L15;
        Signature[] r102 = r101.signatures;     // Catch: RuntimeException -> L11 AndroidException -> L13
        if (r102 == null) goto L15;
        if (r102.length <= 0) goto L15;
        return r102[0].toByteArray();
    L15:
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    L13:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
    L11:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e);
        goto L15
    }

    public String getApplicationName(String r100) {
        return this.f277898a.getApplicationLabel(this.f277898a.getApplicationInfo(r100, 128)).toString();
    L4:
        HMSLog.e("PackageManagerHelper", "Failed to get application name for " + r100);
        return null;
    }

    public long getPackageFirstInstallTime(String r100) {
        PackageInfo r101 = this.f277898a.getPackageInfo(r100, 128);     // Catch: Throwable -> L7
        if (r101 == null) goto L10;
        return r101.firstInstallTime;
    L10:
        return 0;
    L11:
        return 0;
    }

    public String getPackageSignature(String r100) {
        byte[] r101 = a(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length != 0) goto L8;
        return null;
    L8:
        return HEX.encodeHexString(SHA256.digest(r101), true);
    }

    public String getPackageSigningCertificate(String r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L19;
        return getPackageSignature(r100);
    L19:
        PackageInfo r101 = this.f277898a.getPackageInfo(r100, AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Throwable -> L17
        if (Objects.isNull(new Object[]{r101, r101.signingInfo}) == false) goto L11;
        HMSLog.e("PackageManagerHelper", "packageInfo or packageInfo.signingInfo is null");     // Catch: Throwable -> L17
        return null;
    L11:
        Signature[] r102 = r101.signingInfo.getApkContentsSigners();     // Catch: Throwable -> L17
        if (Objects.isNull(new Object[]{r102, r102[0]}) == false) goto L16;
        HMSLog.e("PackageManagerHelper", "get V3 signature is null");     // Catch: Throwable -> L17
        return null;
    L16:
        return HEX.encodeHexString(SHA256.digest(r102[0].toByteArray()), true);
    L17:
        HMSLog.e("PackageManagerHelper", "getPackageSignatureV3 has exception");
        return null;
    }

    public PackageStates getPackageStates(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L14;
        HMSLog.e("PackageManagerHelper", "servicePackageName is empty.");
        return PackageStates.NOT_INSTALLED;
    L14:
    L12:
        HMSLog.e("PackageManagerHelper", "in getPackageStates, getApplicationInfo threw an exception");
        return PackageStates.NOT_INSTALLED;
    L7:
        if (this.f277898a.getApplicationInfo(r100, 128).enabled == false) goto L11;
        return PackageStates.ENABLED;
    L11:
        return PackageStates.DISABLED;
    }

    public int getPackageVersionCode(String r100) {
        PackageInfo r101 = this.f277898a.getPackageInfo(r100, 16);     // Catch: RuntimeException -> L8 AndroidException -> L11
        if (r101 == null) goto L7;
        return r101.versionCode;
    L7:
        return 0;
    L11:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed " + e);
        return 0;
    L8:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", e);
        return 0;
    }

    public String getPackageVersionName(String r100) {
        PackageInfo r101 = this.f277898a.getPackageInfo(r100, 16);     // Catch: RuntimeException -> L9 AndroidException -> L12
        if (r101 == null) goto L8;
        String r102 = r101.versionName;     // Catch: RuntimeException -> L9 AndroidException -> L12
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    L9:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", e);
    L11:
        return "";
    }

    public boolean isPackageFreshInstall(String r100) {
        PackageInfo r101 = this.f277898a.getPackageInfo(r100, 128);     // Catch: Throwable -> L10
        if (r101 == null) goto L13;
        if (r101.firstInstallTime != r101.lastUpdateTime) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L15:
        return false;
    }

    public boolean hasProvider(String r100, String r101) {
        PackageInfo r102 = this.f277898a.getPackageInfo(r100, 8);     // Catch: Throwable -> L15
        if (r102 == null) goto L14;
        ProviderInfo[] r103 = r102.providers;     // Catch: Throwable -> L15
        if (r103 == null) goto L14;
        int r104 = r103.length;     // Catch: Throwable -> L15
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        if (r101.equals(r103[r105].authority) == true) goto L11;
        r105 = r105 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public boolean verifyPackageArchive(String r100, String r101, String r102) {
        InputStream r103 = null;
        PackageInfo r104 = this.f277898a.getPackageArchiveInfo(r100, 64);     // Catch: Exception -> L5
    L8:
        if (r104 != null) goto L10;
    L26:
        return false;
    L10:
        if (r104.signatures.length <= 0) goto L26;
        if (r101.equals(r104.packageName) == true) goto L30;
        return false;
    L30:
        r103 = IOUtils.toInputStream(r104.signatures[0].toByteArray());     // Catch: Throwable -> L17 CertificateException -> L19 Throwable -> L21
        boolean r105 = r102.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(r103).getEncoded()), true));     // Catch: Throwable -> L17 CertificateException -> L19 Throwable -> L21
        IOUtils.closeQuietly(r103);
        return r105;
    L21:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());     // Catch: Throwable -> L17
        IOUtils.closeQuietly(r103);
    L17:
        th = move-exception;
        IOUtils.closeQuietly(null);
        throw th;
    L5:
        e = move-exception;
        HMSLog.e("PackageManagerHelper", "getPackageArchiveInfo Exception. " + e.getMessage());
        r104 = null;
        goto L8
    }
}
