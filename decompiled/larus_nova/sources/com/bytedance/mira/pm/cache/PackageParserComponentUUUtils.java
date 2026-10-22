package com.bytedance.mira.pm.cache;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageParser;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class PackageParserComponentUUUtils {
    private static final String TAG = "PackageParserComponentUUUtils";
    private static final boolean sEnableSupport = false;

    public PackageParserComponentUUUtils() {
    }

    static {
        sEnableSupport = PackageParserReflectUtils.ensureInit();
    }

    public static void internStringArrayList(List<String> r100) {
        if (r100 == null) goto L6;
        int r101 = r100.size();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L8;
        ListProtector.set(r100, r102, ((String) ListProtector.get(r100, r102)).intern());
        r102 = r102 + 1;
        goto L4
    L8:
        return;
    }

    public static PackageParser.Package readPackage(byte[] r100) {
        if (sEnableSupport == true) goto L6;
        return null;
    L6:
        Parcel r101 = Parcel.obtain();
        r101.unmarshall(r100, 0, r100.length);
        r101.setDataPosition(0);
        ClassLoader r102 = Object.class.getClassLoader();
        PackageParser.Package r103 = new PackageParser.Package("");
        ParcelWrapper r104 = ParcelWrapper.obtain(r101, true);
        r104.start();
        r103.packageName = r104.readString();
        r103.mVersionCode = r104.readInt();
        r103.mVersionName = r104.readString();
        r104.finishAndRecycle();
        ParcelWrapper r105 = ParcelWrapper.obtain(r101, true);
        r105.start();
        PackageParserReflectUtils.setPackageWithApplicationInfo(r103, r105.readParcelable(r102));
        r105.finishAndRecycle();
        ParcelWrapper r106 = ParcelWrapper.obtain(r101, true);
        r106.start();
        PackageParserReflectUtils.setPackageWithActivities(r103, r106.readParcelableList(new ArrayList(), r102));
        fixupOwner(r103, r103.activities);
        r106.finishAndRecycle();
        ParcelWrapper r107 = ParcelWrapper.obtain(r101, true);
        r107.start();
        PackageParserReflectUtils.setPackageWithServices(r103, r107.readParcelableList(new ArrayList(), r102));
        fixupOwner(r103, r103.services);
        r107.finishAndRecycle();
        ParcelWrapper r108 = ParcelWrapper.obtain(r101, true);
        r108.start();
        PackageParserReflectUtils.setPackageWithReceivers(r103, r108.readParcelableList(new ArrayList(), r102));
        fixupOwner(r103, r103.receivers);
        r108.finishAndRecycle();
        ParcelWrapper r109 = ParcelWrapper.obtain(r101, true);
        r109.start();
        PackageParserReflectUtils.setPackageWithProviders(r103, r109.readParcelableList(new ArrayList(), r102));
        fixupOwner(r103, r103.providers);
        r109.finishAndRecycle();
        ParcelWrapper r110 = ParcelWrapper.obtain(r101, true);
        r110.start();
        PackageParserReflectUtils.setPackageWithPermissions(r103, r110.readParcelableList(new ArrayList(), r102));
        fixupOwner(r103, r103.permissions);
        r110.finishAndRecycle();
        ParcelWrapper r111 = ParcelWrapper.obtain(r101, true);
        r111.start();
        ArrayList r112 = new ArrayList();
        r111.readStringList(r112);
        internStringArrayList(r112);
        PackageParserReflectUtils.setPackageWithRequestedPermissions(r103, r112);
        r111.finishAndRecycle();
        ParcelWrapper r113 = ParcelWrapper.obtain(r101, true);
        r113.start();
        r103.mAppMetaData = r113.readBundle(r102);
        r113.finishAndRecycle();
        r101.recycle();
        return r103;
    }

    public static PackageParser.Package readPackageWithFile(String r100) {
        return readPackageWithFileInner(r100);
    L4:
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
        if (sEnableSupport == false) goto L5;
        if (r100 == null) goto L8;
        removeNullElement(r100.activities);
        removeNullElement(r100.services);
        removeNullElement(r100.receivers);
        removeNullElement(r100.providers);
        removeNullElement(r100.permissions);
        Parcel r101 = Parcel.obtain();
        ParcelWrapper r102 = ParcelWrapper.obtain(r101, false);
        r102.start();
        r102.writeString(r100.packageName);
        r102.writeInt(r100.mVersionCode);
        r102.writeString(r100.mVersionName);
        r102.finishAndRecycle();
        ParcelWrapper r103 = ParcelWrapper.obtain(r101, false);
        r103.start();
        r103.writeParcelable(r100.applicationInfo, 0);
        r103.finishAndRecycle();
        ParcelWrapper r104 = ParcelWrapper.obtain(r101, false);
        r104.start();
        r104.writeParcelableList(r100.activities, 0);
        r104.finishAndRecycle();
        ParcelWrapper r105 = ParcelWrapper.obtain(r101, false);
        r105.start();
        r105.writeParcelableList(r100.services, 0);
        r105.finishAndRecycle();
        ParcelWrapper r106 = ParcelWrapper.obtain(r101, false);
        r106.start();
        r106.writeParcelableList(r100.receivers, 0);
        r106.finishAndRecycle();
        ParcelWrapper r107 = ParcelWrapper.obtain(r101, false);
        r107.start();
        r107.writeParcelableList(r100.providers, 0);
        r107.finishAndRecycle();
        ParcelWrapper r108 = ParcelWrapper.obtain(r101, false);
        r108.start();
        r108.writeParcelableList(r100.permissions, 0);
        r108.finishAndRecycle();
        ParcelWrapper r109 = ParcelWrapper.obtain(r101, false);
        r109.start();
        r109.writeStringList(r100.requestedPermissions);
        r109.finishAndRecycle();
        ParcelWrapper r110 = ParcelWrapper.obtain(r101, false);
        r110.start();
        r110.writeBundle(r100.mAppMetaData);
        r110.finishAndRecycle();
        byte[] r111 = r101.marshall();
        r101.recycle();
        return r111;
    L8:
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static void fixupOwner(PackageParser.Package r100, List<? extends PackageParser.Component<?>> r101) {
        if (r101 == null) goto L15;
        Iterator<? extends PackageParser.Component<?>> r102 = r101.iterator();
    L5:
        if (r102.hasNext() == false) goto L27;
        PackageParser.Provider r103 = (PackageParser.Component) r102.next();
        PackageParserReflectUtils.setComponentWithOwner(r103, r100);
        if ((r103 instanceof PackageParser.Activity) == true) goto L8;
        if ((r103 instanceof PackageParser.Service) == true) goto L11;
        if ((r103 instanceof PackageParser.Provider) == false) goto L5;
        ProviderInfo r104 = r103.info;
        r104.applicationInfo = r100.applicationInfo;
        goto L5
    L11:
        ServiceInfo r105 = ((PackageParser.Service) r103).info;
        r105.applicationInfo = r100.applicationInfo;
        goto L5
    L8:
        ActivityInfo r106 = ((PackageParser.Activity) r103).info;
        r106.applicationInfo = r100.applicationInfo;
        goto L5
    L27:
        return;
    }

    public static boolean writePackageWithFile(PackageParser.Package r100, String r101) {
        return writePackageWithFileInner(r100, r101);
    L4:
        new PolarisFileWrapper(r101).delete();
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
