package com.bytedance.mira.pm.cache;

import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageParser;
import android.os.Build;
import android.os.Parcel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class PackageParserReflectUtils {
    private static Field sAccessFlagsField;
    private static Field sActivityActivityInfoFiled;
    private static Field sActivityIntentInfoActivityFiled;
    private static Field sAppClassNamesByProcessField;
    private static Field sArtFiledField;
    private static Field sComponentClassNameFiled;
    private static Field sComponentIntentsFiled;
    private static Field sComponentOwnerFiled;
    private static volatile boolean sInit;
    private static Method sIntentFilterInitMethod;
    private static Field sPackageActivitiesFiled;
    private static Field sPackageApplicationInfoFiled;
    private static Field sPackagePermissionsFiled;
    private static Field sPackageProvidersFiled;
    private static Field sPackageReceiversFiled;
    private static Field sPackageRequestedPermissionsFiled;
    private static Field sPackageServicesFiled;
    private static Field sPermissionPermissionInfoFiled;
    private static Field sProviderIntentInfoProviderFiled;
    private static Field sProviderProviderInfoFiled;
    private static Field sServiceIntentInfoServiceFiled;
    private static Field sServiceServiceInfoFiled;

    public PackageParserReflectUtils() {
    }

    public static boolean ensureInit() {
        if (sInit == true) goto L16;
        if (initStep1() == true) goto L7;
    L13:
        boolean r100 = false;
    L14:
        sInit = r100;
        goto L16
    L7:
        if (initStep2() == false) goto L13;
        if (initStep3() == false) goto L13;
        if (initStep4() == false) goto L13;
        r100 = true;
    L16:
        return sInit;
    }

    private static boolean initStep1() {
        if (Build.VERSION.SDK_INT >= 23) goto L14;
        Field r100 = findDeclaredFieldByClass(Field.class, "artField");
        sArtFiledField = r100;
        if (r100 != null) goto L7;
        Class<?> r101 = null;
    L8:
        Field r102 = findDeclaredFieldByClass(r101, "accessFlags");
        sAccessFlagsField = r102;
        if (sArtFiledField == null) goto L12;
        if (r102 == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = r100.getType();
        goto L8
    L14:
        Field r103 = findDeclaredFieldByClass(Field.class, "accessFlags");
        sAccessFlagsField = r103;
        if (r103 != null) goto L20;
        return false;
    L20:
        return true;
    }

    private static boolean initStep2() {
        Field r100 = findDeclaredFieldByClass(Method.class, "artMethod");
        if (r100 != null) goto L5;
        return false;
    L5:
        Constructor<?> r101 = findDeclaredConstructor(IntentFilter.class, new Class[]{Parcel.class});
        if (r101 != null) goto L8;
        return false;
    L8:
        Object r102 = getFiledValue(r100, r101);
        if (r102 != null) goto L11;
        return false;
    L11:
        Method r103 = findDeclaredMethod(Object.class, "internalClone", new Class[0]);
        if (r103 != null) goto L14;
        return false;
    L14:
        Method r104 = findMethod(IntentFilter.class, "getAction", new Class[]{Integer.TYPE});
        if (r104 != null) goto L17;
        return false;
    L17:
        Method r105 = (Method) methodInvoke(r103, r104, new Object[0]);
        if (r105 != null) goto L20;
        return false;
    L20:
        r105.setAccessible(true);
        if (setFiledValue(r100, r105, r102) == false) goto L24;
        sIntentFilterInitMethod = r105;
        return true;
    L24:
        return false;
    }

    private static boolean initStep3() {
        Field r100 = findFieldByClass(PackageParser.Package.class, "applicationInfo");
        sPackageApplicationInfoFiled = r100;
        if (r100 != null) goto L5;
        return false;
    L5:
        removeFinal(r100);
        Field r101 = findFieldByClass(PackageParser.Package.class, ComplianceResult.JsonKey.PERMISSIONS);
        sPackagePermissionsFiled = r101;
        if (r101 != null) goto L8;
        return false;
    L8:
        removeFinal(r101);
        Field r102 = findFieldByClass(PackageParser.Package.class, "activities");
        sPackageActivitiesFiled = r102;
        if (r102 != null) goto L11;
        return false;
    L11:
        removeFinal(r102);
        Field r103 = findFieldByClass(PackageParser.Package.class, "receivers");
        sPackageReceiversFiled = r103;
        if (r103 != null) goto L14;
        return false;
    L14:
        removeFinal(r103);
        Field r104 = findFieldByClass(PackageParser.Package.class, "providers");
        sPackageProvidersFiled = r104;
        if (r104 != null) goto L17;
        return false;
    L17:
        removeFinal(r104);
        Field r105 = findFieldByClass(PackageParser.Package.class, PromotionProductPrivilegesStruct.SERVICES);
        sPackageServicesFiled = r105;
        if (r105 != null) goto L20;
        return false;
    L20:
        removeFinal(r105);
        Field r106 = findFieldByClass(PackageParser.Package.class, "requestedPermissions");
        sPackageRequestedPermissionsFiled = r106;
        if (r106 != null) goto L23;
        return false;
    L23:
        removeFinal(r106);
        Field r107 = findFieldByClass(PackageParser.Permission.class, "info");
        sPermissionPermissionInfoFiled = r107;
        if (r107 != null) goto L26;
        return false;
    L26:
        removeFinal(r107);
        Field r108 = findFieldByClass(PackageParser.Service.class, "info");
        sServiceServiceInfoFiled = r108;
        if (r108 != null) goto L29;
        return false;
    L29:
        removeFinal(r108);
        Field r109 = findFieldByClass(PackageParser.Activity.class, "info");
        sActivityActivityInfoFiled = r109;
        if (r109 != null) goto L32;
        return false;
    L32:
        removeFinal(r109);
        Field r110 = findFieldByClass(PackageParser.Provider.class, "info");
        sProviderProviderInfoFiled = r110;
        if (r110 != null) goto L35;
        return false;
    L35:
        removeFinal(r110);
        Field r111 = findFieldByClass(PackageParser.ServiceIntentInfo.class, "service");
        sServiceIntentInfoServiceFiled = r111;
        if (r111 != null) goto L38;
        return false;
    L38:
        removeFinal(r111);
        Field r112 = findFieldByClass(PackageParser.ActivityIntentInfo.class, "activity");
        sActivityIntentInfoActivityFiled = r112;
        if (r112 != null) goto L41;
        return false;
    L41:
        removeFinal(r112);
        Field r113 = findFieldByClass(PackageParser.ProviderIntentInfo.class, ShortVideoSegments.KEY_PROP_PROVIDER);
        sProviderIntentInfoProviderFiled = r113;
        if (r113 != null) goto L44;
        return false;
    L44:
        removeFinal(r113);
        Field r114 = findFieldByClass(PackageParser.Component.class, "owner");
        sComponentOwnerFiled = r114;
        if (r114 != null) goto L47;
        return false;
    L47:
        removeFinal(r114);
        Field r115 = findFieldByClass(PackageParser.Component.class, "intents");
        sComponentIntentsFiled = r115;
        if (r115 != null) goto L50;
        return false;
    L50:
        removeFinal(r115);
        Field r116 = findFieldByClass(PackageParser.Component.class, PushClientConstants.TAG_CLASS_NAME);
        sComponentClassNameFiled = r116;
        if (r116 != null) goto L53;
        return false;
    L53:
        removeFinal(r116);
        return true;
    }

    private static boolean initStep4() {
        if (Build.VERSION.SDK_INT < 33) goto L9;
        Field r100 = findDeclaredFieldByClass(ApplicationInfo.class, "mAppClassNamesByProcess");
        sAppClassNamesByProcessField = r100;
        if (r100 != null) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private static void removeFinal(Field r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        Object r101 = getFiledValue(sArtFiledField, r100);
        Object r102 = getFiledValue(sAccessFlagsField, r101);
        if (r102 == null) goto L7;
        int r103 = ((Integer) r102).intValue();
    L8:
        if (r103 == (-1)) goto L17;
        setFiledValue(sAccessFlagsField, r101, Integer.valueOf(r103 & (-17)));
        return;
    L17:
        return;
    L7:
        r103 = -1;
        goto L8
    L10:
        Object r104 = getFiledValue(sAccessFlagsField, r100);
        if (r104 == null) goto L13;
        int r105 = ((Integer) r104).intValue();
    L14:
        if (r105 == (-1)) goto L19;
        setFiledValue(sAccessFlagsField, r100, Integer.valueOf(r105 & (-17)));
        return;
    L19:
        return;
    L13:
        r105 = -1;
        goto L14
    }

    public static void clearAppClassNamesByProcess(Object r100, Object r101) {
        setObjFieldValueInner(sAppClassNamesByProcessField, r100, r101);
    }

    private static Constructor<?> findDeclaredConstructor(Class<?> r100, Class<?>... r101) {
        Constructor<?> r102 = r100.getDeclaredConstructor(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    private static Field findDeclaredFieldByClass(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L6;
        Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        return r102;
    L5:
        r100 = r100.getSuperclass();
        goto L2
    L6:
        return null;
    }

    private static Field findFieldByClass(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L6;
        Field r102 = r100.getField(r101);     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        return r102;
    L5:
        r100 = r100.getSuperclass();
        goto L2
    L6:
        return null;
    }

    private static Object getFiledValue(Field r100, Object r101) {
        return r100.get(r101);
    L4:
        return null;
    }

    public static void invokeIntentFilterInitMethod(Object r100, Object... r101) {
        Method r102 = sIntentFilterInitMethod;
        if (r102 != null) goto L5;
        return;
    L5:
        methodInvoke(r102, r100, r101);
    }

    public static void setActivityIntentInfoWithActivity(Object r100, Object r101) {
        setObjFieldValueInner(sActivityIntentInfoActivityFiled, r100, r101);
    }

    public static void setActivityWithActivityInfo(Object r100, Object r101) {
        setObjFieldValueInner(sActivityActivityInfoFiled, r100, r101);
    }

    public static void setComponentWithClassName(Object r100, Object r101) {
        setObjFieldValueInner(sComponentClassNameFiled, r100, r101);
    }

    public static void setComponentWithIntents(Object r100, Object r101) {
        setObjFieldValueInner(sComponentIntentsFiled, r100, r101);
    }

    public static void setComponentWithOwner(Object r100, Object r101) {
        setObjFieldValueInner(sComponentOwnerFiled, r100, r101);
    }

    public static void setPackageWithActivities(Object r100, Object r101) {
        setObjFieldValueInner(sPackageActivitiesFiled, r100, r101);
    }

    public static void setPackageWithApplicationInfo(Object r100, Object r101) {
        setObjFieldValueInner(sPackageApplicationInfoFiled, r100, r101);
    }

    public static void setPackageWithPermissions(Object r100, Object r101) {
        setObjFieldValueInner(sPackagePermissionsFiled, r100, r101);
    }

    public static void setPackageWithProviders(Object r100, Object r101) {
        setObjFieldValueInner(sPackageProvidersFiled, r100, r101);
    }

    public static void setPackageWithReceivers(Object r100, Object r101) {
        setObjFieldValueInner(sPackageReceiversFiled, r100, r101);
    }

    public static void setPackageWithRequestedPermissions(Object r100, Object r101) {
        setObjFieldValueInner(sPackageRequestedPermissionsFiled, r100, r101);
    }

    public static void setPackageWithServices(Object r100, Object r101) {
        setObjFieldValueInner(sPackageServicesFiled, r100, r101);
    }

    public static void setPermissionWithPermissionInfo(Object r100, Object r101) {
        setObjFieldValueInner(sPermissionPermissionInfoFiled, r100, r101);
    }

    public static void setProviderIntentInfoWithProvider(Object r100, Object r101) {
        setObjFieldValueInner(sProviderIntentInfoProviderFiled, r100, r101);
    }

    public static void setProviderWithProviderInfo(Object r100, Object r101) {
        setObjFieldValueInner(sProviderProviderInfoFiled, r100, r101);
    }

    public static void setServiceIntentInfoWithService(Object r100, Object r101) {
        setObjFieldValueInner(sServiceIntentInfoServiceFiled, r100, r101);
    }

    public static void setServiceWithServiceInfo(Object r100, Object r101) {
        setObjFieldValueInner(sServiceServiceInfoFiled, r100, r101);
    }

    private static Method findDeclaredMethod(Class<?> r100, String r101, Class<?>... r102) {
        Method r103 = r100.getDeclaredMethod(r101, r102);     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        return r103;
    L4:
        return null;
    }

    private static Method findMethod(Class<?> r100, String r101, Class<?>... r102) {
        Method r103 = r100.getMethod(r101, r102);     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        return r103;
    L4:
        return null;
    }

    private static Object methodInvoke(Method r100, Object r101, Object... r102) {
        return r100.invoke(r101, r102);
    L4:
        return null;
    }

    private static boolean setFiledValue(Field r100, Object r101, Object r102) {
        r100.set(r101, r102);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    private static void setObjFieldValueInner(Field r100, Object r101, Object r102) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        setFiledValue(r100, r101, r102);
        return;
    L8:
        return;
    }
}
