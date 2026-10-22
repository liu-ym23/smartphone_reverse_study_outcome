package com.bytedance.mira.pm.cache;

import android.content.pm.PackageParser;
import android.os.Parcel;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class PackageParserComponentUUtils {
    private static final String TAG = "PackageParserComponentUUtils";

    public PackageParserComponentUUtils() {
    }

    public static PackageParser.Package readPackage(byte[] r100) {
        Parcel r101 = Parcel.obtain();
        r101.unmarshall(r100, 0, r100.length);
        r101.setDataPosition(0);
        PackageParser.Package r102 = r101.readParcelable(Object.class.getClassLoader());
        r101.recycle();
        return r102;
    }

    public static PackageParser.Package readPackageWithFile(String r100) {
        return readPackageWithFileInner(r100);
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RESOLVE, "PackageParserComponentUUtils readPackageWithFile error", th);
        return null;
    }

    private static PackageParser.Package readPackageWithFileInner(String r100) throws IOException {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        PolarisFileInputStreamWrapper r102 = null;
        if (r101.exists() == true) goto L17;
        return null;
    L17:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L11
        byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L9
        r103.read(r104);     // Catch: Throwable -> L9
        PackageParser.Package r105 = readPackage(r104);     // Catch: Throwable -> L9
        r103.close();
        return r105;
    L9:
        th = th;
        r102 = r103;
    L12:
        if (r102 == null) goto L14;
        r102.close();
    L14:
        throw th;
    L11:
        th = th;
        goto L12
    }

    private static void removeNullElement(List<?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.size() - 1;
    L5:
        if (r101 < 0) goto L10;
        if (ListProtector.get(r100, r101) != null) goto L9;
        ListProtector.remove(r100, r101);
    L9:
        r101 = r101 - 1;
        goto L5
    }

    public static byte[] writePackage(PackageParser.Package r100) {
        if (r100 == null) goto L5;
        removeNullElement(r100.activities);
        removeNullElement(r100.services);
        removeNullElement(r100.receivers);
        removeNullElement(r100.providers);
        removeNullElement(r100.permissions);
        Parcel r101 = Parcel.obtain();
        r101.writeParcelable(r100, 0);
        byte[] r102 = r101.marshall();
        r101.recycle();
        return r102;
    L5:
        return new byte[0];
    }

    public static boolean writePackageWithFile(PackageParser.Package r100, String r101) {
        return writePackageWithFileInner(r100, r101);
    L4:
        th = move-exception;
        new PolarisFileWrapper(r101).delete();
        MiraLogger.e(MiraLogger.TAG_RESOLVE, "PackageParserComponentUUtils writePackageWithFile error", th);
        return false;
    }

    private static boolean writePackageWithFileInner(PackageParser.Package r100, String r101) throws Throwable {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L5;
        r102.delete();
    L5:
        r102.createNewFile();
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L12
        r104.write(writePackage(r100));     // Catch: Throwable -> L10
        r104.close();
        return true;
    L10:
        th = th;
        r103 = r104;
    L13:
        if (r103 == null) goto L15;
        r103.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }
}
