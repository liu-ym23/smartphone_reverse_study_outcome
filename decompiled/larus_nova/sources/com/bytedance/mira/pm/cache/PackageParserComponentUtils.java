package com.bytedance.mira.pm.cache;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageParser;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class PackageParserComponentUtils {
    private static final String TAG = "PackageParserComponentUtils";
    private static final boolean sEnableSupport = false;

    public PackageParserComponentUtils() {
    }

    static {
        sEnableSupport = PackageParserReflectUtils.ensureInit();
    }

    private static PackageParser.Component<?> createComponentByName(String r100) {
        if (r100.equals(PackageParser.Activity.class.getName()) == false) goto L7;
        return new PackageParser.Activity();
    L7:
        if (r100.equals(PackageParser.Service.class.getName()) == false) goto L11;
        return new PackageParser.Service();
    L11:
        if (r100.equals(PackageParser.Provider.class.getName()) == false) goto L15;
        return new PackageParser.Provider();
    L15:
        if (r100.equals(PackageParser.Permission.class.getName()) == true) goto L17;
        return null;
    L17:
        return new PackageParser.Permission();
    }

    private static <T extends PackageParser.IntentInfo> T createIntentInfoByName(String r100) {
        if (r100.equals(PackageParser.ActivityIntentInfo.class.getName()) == false) goto L7;
        return new PackageParser.ActivityIntentInfo(null);
    L7:
        if (r100.equals(PackageParser.ServiceIntentInfo.class.getName()) == false) goto L11;
        return new PackageParser.ServiceIntentInfo(null);
    L11:
        if (r100.equals(PackageParser.ProviderIntentInfo.class.getName()) == false) goto L15;
        return new PackageParser.ProviderIntentInfo(null);
    L15:
        return (T) new PackageParser.IntentInfo();
    }

    private static <T extends PackageParser.IntentInfo> ArrayList<T> createIntentsList(Parcel r100) {
        int r101 = r100.readInt();
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        if (r101 == 0) goto L8;
        String r102 = r100.readString();
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r103 = (ArrayList<T>) new ArrayList(r101);
        int r104 = 0;
    L11:
        if (r104 >= r101) goto L14;
        PackageParser.IntentInfo r105 = createIntentInfoByName(r102);     // Catch: Exception -> L15
        PackageParserReflectUtils.invokeIntentFilterInitMethod(r105, new Object[]{r100});     // Catch: Exception -> L15
        r103.add(r105);     // Catch: Exception -> L15
        r104 = r104 + 1;
        goto L11
    L14:
        return r103;
    L15:
        return null;
    L8:
        return new ArrayList(0);
    }

    private static Parcelable getComponentInfo(PackageParser.Component<? extends PackageParser.IntentInfo> r100) {
        if ((r100 instanceof PackageParser.Activity) == false) goto L7;
        return ((PackageParser.Activity) r100).info;
    L7:
        if ((r100 instanceof PackageParser.Service) == false) goto L11;
        return ((PackageParser.Service) r100).info;
    L11:
        if ((r100 instanceof PackageParser.Provider) == false) goto L15;
        return ((PackageParser.Provider) r100).info;
    L15:
        if ((r100 instanceof PackageParser.Permission) == true) goto L17;
        return null;
    L17:
        return ((PackageParser.Permission) r100).info;
    }

    private static void internStringArrayList(List<String> r100) {
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

    private static int readInt(Parcel r100) {
        return r100.readInt();
    }

    private static PackageParser.Package readPackage(byte[] r100) {
        if (sEnableSupport == true) goto L6;
        return null;
    L6:
        Parcel r101 = Parcel.obtain();
        r101.unmarshall(r100, 0, r100.length);
        r101.setDataPosition(0);
        PackageParser.Package r102 = new PackageParser.Package("");
        ClassLoader r103 = Object.class.getClassLoader();
        r102.packageName = readString(r101);
        r102.mVersionCode = readInt(r101);
        r102.mVersionName = readString(r101);
        PackageParserReflectUtils.setPackageWithApplicationInfo(r102, readParcelable(r101, r103));
        PackageParserReflectUtils.setPackageWithActivities(r102, readComponentParcelableList(r101, new ArrayList(), r103));
        fixupOwner(r102, r102.activities);
        PackageParserReflectUtils.setPackageWithServices(r102, readComponentParcelableList(r101, new ArrayList(), r103));
        fixupOwner(r102, r102.services);
        PackageParserReflectUtils.setPackageWithReceivers(r102, readComponentParcelableList(r101, new ArrayList(), r103));
        fixupOwner(r102, r102.receivers);
        PackageParserReflectUtils.setPackageWithProviders(r102, readComponentParcelableList(r101, new ArrayList(), r103));
        fixupOwner(r102, r102.providers);
        PackageParserReflectUtils.setPackageWithPermissions(r102, readComponentParcelableList(r101, new ArrayList(), r103));
        fixupOwner(r102, r102.permissions);
        PackageParserReflectUtils.setPackageWithRequestedPermissions(r102, new ArrayList(10));
        readStringList(r101, r102.requestedPermissions);
        internStringArrayList(r102.requestedPermissions);
        r102.mAppMetaData = readBundle(r101, r103);
        r101.recycle();
        return r102;
    }

    public static PackageParser.Package readPackageWithFile(String r100) {
        return readPackageWithFileInner(r100);
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RESOLVE, "PackageParserComponentUtils readPackageWithFile error", th);
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

    private static String readString(Parcel r100) {
        return r100.readString();
    }

    private static byte[] writePackage(PackageParser.Package r100) {
        if (sEnableSupport == false) goto L5;
        Parcel r101 = Parcel.obtain();
        writeString(r101, r100.packageName);
        writeInt(r101, r100.mVersionCode);
        writeString(r101, r100.mVersionName);
        PackageParserReflectUtils.clearAppClassNamesByProcess(r100.applicationInfo, null);
        writeParcelable(r101, r100.applicationInfo, 0);
        writeComponentParcelableList(r101, r100.activities, 0);
        writeComponentParcelableList(r101, r100.services, 0);
        writeComponentParcelableList(r101, r100.receivers, 0);
        writeComponentParcelableList(r101, r100.providers, 0);
        writeComponentParcelableList(r101, r100.permissions, 0);
        writeStringList(r101, r100.requestedPermissions);
        writeBundle(r101, r100.mAppMetaData);
        byte[] r102 = r101.marshall();
        r101.recycle();
        return r102;
    L5:
        return new byte[0];
    }

    private static void fixupOwner(PackageParser.Package r100, List<? extends PackageParser.Component<?>> r101) {
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

    private static Bundle readBundle(Parcel r100, ClassLoader r101) {
        return r100.readBundle(r101);
    }

    private static PackageParser.Component<?> readComponentParcelable(Parcel r100, ClassLoader r101) {
        String r102 = readString(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        PackageParser.Component<?> r103 = createComponentByName(r102);
        if (r103 != null) goto L8;
        return null;
    L8:
        PackageParserReflectUtils.setComponentWithClassName(r103, readString(r100));
        r103.metaData = readBundle(r100, r101);
        PackageParserReflectUtils.setComponentWithIntents(r103, createIntentsList(r100));
        setComponentInfo(r103, readParcelable(r100, r101));
        return r103;
    }

    private static <T extends Parcelable> T readParcelable(Parcel r100, ClassLoader r101) {
        return (T) r100.readParcelable(r101);
    }

    private static void readStringList(Parcel r100, List<String> r101) {
        r100.readStringList(r101);
    }

    private static void setComponentInfo(PackageParser.Component<?> r100, Parcelable r101) {
        if ((r100 instanceof PackageParser.Activity) == false) goto L13;
        Iterator r102 = r100.intents.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        PackageParserReflectUtils.setActivityIntentInfoWithActivity((PackageParser.ActivityIntentInfo) r102.next(), r100);
        goto L6
    L8:
        ActivityInfo r103 = (ActivityInfo) r101;
        String r104 = r103.permission;
        if (r104 == null) goto L11;
        r103.permission = r104.intern();
    L11:
        PackageParserReflectUtils.setActivityWithActivityInfo(r100, r103);
        return;
    L13:
        if ((r100 instanceof PackageParser.Service) == false) goto L23;
        Iterator r105 = r100.intents.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        PackageParserReflectUtils.setServiceIntentInfoWithService((PackageParser.ServiceIntentInfo) r105.next(), r100);
        goto L16
    L18:
        ServiceInfo r106 = (ServiceInfo) r101;
        String r107 = r106.permission;
        if (r107 == null) goto L21;
        r106.permission = r107.intern();
    L21:
        PackageParserReflectUtils.setServiceWithServiceInfo(r100, r106);
        return;
    L23:
        if ((r100 instanceof PackageParser.Provider) == false) goto L39;
        Iterator r108 = r100.intents.iterator();
    L26:
        if (r108.hasNext() == false) goto L28;
        PackageParserReflectUtils.setProviderIntentInfoWithProvider((PackageParser.ProviderIntentInfo) r108.next(), r100);
        goto L26
    L28:
        ProviderInfo r109 = (ProviderInfo) r101;
        String r110 = r109.readPermission;
        if (r110 == null) goto L31;
        r109.readPermission = r110.intern();
    L31:
        String r111 = r109.writePermission;
        if (r111 == null) goto L34;
        r109.writePermission = r111.intern();
    L34:
        String r112 = r109.authority;
        if (r112 == null) goto L37;
        r109.authority = r112.intern();
    L37:
        PackageParserReflectUtils.setProviderWithProviderInfo(r100, r109);
        return;
    L39:
        if ((r100 instanceof PackageParser.Permission) == false) goto L51;
        PermissionInfo r113 = (PermissionInfo) r101;
        String r114 = r113.group;
        if (r114 == null) goto L43;
        r113.group = r114.intern();
    L43:
        PackageParserReflectUtils.setPermissionWithPermissionInfo(r100, r113);
        return;
    }

    private static void writeBundle(Parcel r100, Bundle r101) {
        r100.writeBundle(r101);
    }

    private static void writeInt(Parcel r100, int r101) {
        r100.writeInt(r101);
    }

    public static boolean writePackageWithFile(PackageParser.Package r100, String r101) {
        return writePackageWithFileInner(r100, r101);
    L4:
        th = move-exception;
        new PolarisFileWrapper(r101).delete();
        MiraLogger.e(MiraLogger.TAG_RESOLVE, "PackageParserComponentUtils writePackageWithFile error", th);
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

    private static void writeParcelableCreator(Parcel r100, Object r101) {
        writeString(r100, r101.getClass().getName());
    }

    private static void writeString(Parcel r100, String r101) {
        r100.writeString(r101);
    }

    private static void writeStringList(Parcel r100, List<String> r101) {
        r100.writeStringList(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends PackageParser.Component<?>> ArrayList<T> readComponentParcelableList(Parcel r100, ArrayList<T> r101, ClassLoader r102) {
        int r103 = readInt(r100);
        if (r103 != (-1)) goto L6;
        r101.clear();
        return r101;
    L6:
        int r104 = r101.size();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L10;
        if (r105 >= r103) goto L10;
        ListProtector.set(r101, r105, readComponentParcelable(r100, r102));
        r105 = r105 + 1;
    L10:
        if (r105 >= r103) goto L12;
        r101.add(readComponentParcelable(r100, r102));
        r105 = r105 + 1;
    L12:
        if (r105 >= r104) goto L14;
        ListProtector.remove(r101, r103);
        r105 = r105 + 1;
        goto L12
    L14:
        return r101;
    }

    private static void writeComponentParcelableList(Parcel r100, List<? extends PackageParser.Component<?>> r101, int r102) {
        if (r101 != null) goto L5;
        writeInt(r100, -1);
        return;
    L5:
        int r103 = r101.size();
        writeInt(r100, r103);
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        writeComponentParcelable(r100, (PackageParser.Component) ListProtector.get(r101, r104), getComponentInfo((PackageParser.Component) ListProtector.get(r101, r104)), r102);
        r104 = r104 + 1;
        goto L6
    }

    private static void writeIntentInfoToParcel(Parcel r100, Parcelable r101, int r102) {
        r101.writeToParcel(r100, r102);
    }

    private static void writeIntentsList(Parcel r100, ArrayList<? extends PackageParser.IntentInfo> r101, int r102) {
        if (r101 != null) goto L5;
        writeInt(r100, -1);
        return;
    L5:
        int r103 = r101.size();
        r100.writeInt(r103);
        if (r103 <= 0) goto L10;
        int r104 = 0;
        writeString(r100, ((PackageParser.IntentInfo) ListProtector.get(r101, 0)).getClass().getName());
    L8:
        if (r104 >= r103) goto L12;
        writeIntentInfoToParcel(r100, (Parcelable) ListProtector.get(r101, r104), r102);
        r104 = r104 + 1;
        goto L8
    L12:
        return;
    }

    private static void writeParcelable(Parcel r100, Parcelable r101, int r102) {
        r100.writeParcelable(r101, r102);
    }

    private static void writeComponentParcelable(Parcel r100, PackageParser.Component<? extends PackageParser.IntentInfo> r101, Parcelable r102, int r103) {
        if (r101 != null) goto L5;
        writeString(r100, null);
        return;
    L5:
        writeParcelableCreator(r100, r101);
        writeString(r100, r101.className);
        writeBundle(r100, r101.metaData);
        writeIntentsList(r100, r101.intents, r103);
        writeParcelable(r100, r102, r103 | 2);
    }
}
