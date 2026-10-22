package com.obric.capabilitykit;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.obric.capabilitykit.entity.EntityContextHolder;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/PackageUtils;", "", "()V", "NOVA_PKG_NAME", "", "NOVA_SIGNATURE", "TAG", "checkSignature", "", "callingPkg", "checkSignatureApi28Plus", "checkSignatureLegacy", "isMemoryPackageName", "pkgName", "isPrivilegedApp", "packageName", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageUtils {
    public static final PackageUtils INSTANCE = null;
    public static final String NOVA_PKG_NAME = "com.larus.nova";
    private static final String NOVA_SIGNATURE = "ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a";
    private static final String TAG = "PersonalContextPackageUtils";

    static {
        INSTANCE = new PackageUtils();
    }

    private PackageUtils() {
    }

    private final boolean checkSignatureApi28Plus(String r110) {
        SigningInfo r111 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r110, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo;     // Catch: Exception -> L27
        if (r111 != null) goto L6;
        return false;
    L6:
        Signature[] r112 = r111.getApkContentsSigners();     // Catch: Exception -> L27
        if (r112 == null) goto L26;
        if (r112.length != 0) goto L11;
        boolean r100 = true;
    L12:
        if (r100 == true) goto L26;
        int r101 = r112.length;     // Catch: Exception -> L27
        int r102 = 0;
    L15:
        if (r102 >= r101) goto L26;
        byte[] r103 = r112[r102].toByteArray();     // Catch: Exception -> L27
        byte[] r104 = MessageDigest.getInstance("SHA-256").digest(r103);     // Catch: Exception -> L27
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L27
        int r106 = r104.length;     // Catch: Exception -> L27
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L23;
        String r108 = Integer.toHexString(r104[r107] & UByte.MAX_VALUE);     // Catch: Exception -> L27
        if (r108.length() != 1) goto L21;
        r105.append('0');     // Catch: Exception -> L27
    L21:
        r105.append(r108);     // Catch: Exception -> L27
        r107 = r107 + 1;     // Catch: Exception -> L27
        goto L17
    L23:
        if (Intrinsics.areEqual(r105.toString(), NOVA_SIGNATURE) == true) goto L24;
        r102 = r102 + 1;
        goto L15
    L24:
        return true;
    L11:
        r100 = false;
    L26:
        return false;
    }

    private final boolean checkSignatureLegacy(String r110) {
        Signature[] r111 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r110, 64).signatures;     // Catch: Exception -> L24
        if (r111 == null) goto L23;
        if (r111.length != 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == true) goto L23;
        int r101 = r111.length;     // Catch: Exception -> L24
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L23;
        byte[] r103 = r111[r102].toByteArray();     // Catch: Exception -> L24
        byte[] r104 = MessageDigest.getInstance("SHA-256").digest(r103);     // Catch: Exception -> L24
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L24
        int r106 = r104.length;     // Catch: Exception -> L24
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L20;
        String r108 = Integer.toHexString(r104[r107] & UByte.MAX_VALUE);     // Catch: Exception -> L24
        if (r108.length() != 1) goto L18;
        r105.append('0');     // Catch: Exception -> L24
    L18:
        r105.append(r108);     // Catch: Exception -> L24
        r107 = r107 + 1;     // Catch: Exception -> L24
        goto L14
    L20:
        if (Intrinsics.areEqual(r105.toString(), NOVA_SIGNATURE) == true) goto L21;
        r102 = r102 + 1;
        goto L12
    L21:
        return true;
    L8:
        r100 = false;
    L23:
        return false;
    }

    public final boolean checkSignature(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r100, EntityContextHolder.INSTANCE.getPackageName()) == false) goto L15;
        return true;
    L15:
        if (isMemoryPackageName(r100) == true) goto L18;
        return false;
    L18:
        if (isPrivilegedApp(r100) == true) goto L22;
        return false;
    L22:
        if (Build.VERSION.SDK_INT < 28) goto L25;
        return checkSignatureApi28Plus(r100);
    L25:
        return checkSignatureLegacy(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean isMemoryPackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        return Intrinsics.areEqual("com.larus.nova", r100);
    }

    public final boolean isPrivilegedApp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        ApplicationInfo r101 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getApplicationInfo(r100, 0);     // Catch: Throwable -> L7
        Field r102 = ApplicationInfo.class.getDeclaredField("privateFlags");     // Catch: Throwable -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L7
        if ((r102.getInt(r101) & 8) == 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }
}
