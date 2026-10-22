package com.bytedance.push.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.push.PushSupporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class ManifestUtils {
    private static List<ActivityInfo> sActivities;
    private static Bundle sMetadata;
    private static List<String> sPermissions;
    private static List<ProviderInfo> sProviders;
    private static List<ActivityInfo> sReceivers;
    private static List<ServiceInfo> sServices;

    public ManifestUtils() {
    }

    private static List<ActivityInfo> getActivities(Context r100) throws PackageManager.NameNotFoundException {
        if (sActivities != null) goto L17;
        monitor-enter(ManifestUtils.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sActivities != null) goto L11;
        ActivityInfo[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 513).activities;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        sActivities = Arrays.asList(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ManifestUtils.class);     // Catch: Throwable -> L13
    L17:
        return sActivities;
    }

    private static List<String> getAllPermissions(Context r100) throws PackageManager.NameNotFoundException {
        if (sPermissions != null) goto L17;
        monitor-enter(ManifestUtils.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sPermissions != null) goto L11;
        String[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 4096).requestedPermissions;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        sPermissions = Arrays.asList(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ManifestUtils.class);     // Catch: Throwable -> L13
    L17:
        return sPermissions;
    }

    private static Bundle getMetadata(Context r100) throws PackageManager.NameNotFoundException {
        if (sMetadata != null) goto L15;
        monitor-enter(ManifestUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sMetadata != null) goto L9;
        sMetadata = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 128).applicationInfo.metaData;     // Catch: Throwable -> L11
    L9:
        monitor-exit(ManifestUtils.class);     // Catch: Throwable -> L11
    L15:
        return sMetadata;
    }

    private static List<ProviderInfo> getProviders(Context r100) throws PackageManager.NameNotFoundException {
        if (sProviders != null) goto L17;
        monitor-enter(ManifestUtils.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sProviders != null) goto L11;
        ProviderInfo[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 520).providers;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        sProviders = Arrays.asList(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ManifestUtils.class);     // Catch: Throwable -> L13
    L17:
        return sProviders;
    }

    private static List<ActivityInfo> getReceivers(Context r100) throws PackageManager.NameNotFoundException {
        if (sReceivers != null) goto L17;
        monitor-enter(ManifestUtils.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sReceivers != null) goto L11;
        ActivityInfo[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 514).receivers;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        sReceivers = Arrays.asList(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ManifestUtils.class);     // Catch: Throwable -> L13
    L17:
        return sReceivers;
    }

    private static List<ServiceInfo> getServices(Context r100) throws PackageManager.NameNotFoundException {
        if (sServices != null) goto L17;
        monitor-enter(ManifestUtils.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sServices != null) goto L11;
        ServiceInfo[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 516).services;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        sServices = Arrays.asList(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ManifestUtils.class);     // Catch: Throwable -> L13
    L17:
        return sServices;
    }

    public static boolean checkActivities(Context r110, String r111, String r112, List<Component> r113) throws PackageManager.NameNotFoundException {
        if (r113 != null) goto L5;
        return true;
    L5:
        if (r113.isEmpty() == true) goto L80;
        List<ActivityInfo> r100 = getActivities(r110);
        if (r100 != null) goto L10;
    L61:
        PushSupporter.logger().e(r111, r112 + ". You need to declare activity(s) {" + r113 + "} in AndroidManifest.xml");
        return false;
    L10:
        if (r100.size() == 0) goto L61;
        ArrayList r101 = new ArrayList();
        Iterator<Component> r102 = r113.iterator();
        boolean r103 = true;
    L14:
        if (r102.hasNext() == false) goto L53;
        Component r104 = r102.next();
        Iterator<ActivityInfo> r114 = r100.iterator();
    L17:
        if (r114.hasNext() == false) goto L49;
        ActivityInfo r115 = r114.next();
        if (TextUtils.equals(r115.name, r104.name) == false) goto L17;
        if (TextUtils.equals(r104.processName, r115.processName) == true) goto L24;
        PushSupporter.logger().e(r111, r112 + r104.name + " should be declared in process " + r104.processName + ", but now in process " + r115.processName);
        r103 = false;
    L24:
        if (TextUtils.isEmpty(r104.permission) == true) goto L26;
        boolean r116 = TextUtils.equals(r115.permission, r104.permission);
    L27:
        if (r116 == true) goto L29;
        PushSupporter.logger().e(r111, r112 + r104.name + " need permission(s) {" + r104.permission + "}, but now is " + r115.permission);
        r103 = false;
    L29:
        List<Component.IntentFilter> r117 = r104.intentFilter;
        if (r117 == null) goto L47;
        Iterator<Component.IntentFilter> r118 = r117.iterator();
        boolean r119 = true;
    L33:
        if (r118.hasNext() == false) goto L44;
        Component.IntentFilter r120 = r118.next();
        List<String> r121 = r120.actions;
        if (r121 == null) goto L33;
        Iterator<String> r122 = r121.iterator();
    L38:
        if (r122.hasNext() == false) goto L33;
        String r123 = r122.next();
        if (checkActivityFilter(r110, r104.name, r120, r123) == true) goto L38;
        PushSupporter.logger().e(r111, r112 + " " + r104.name + " need action " + r123);
        r119 = false;
        goto L38
    L44:
        if (r119 == true) goto L47;
        r103 = false;
    L47:
        boolean r105 = true;
    L50:
        if (r105 == true) goto L14;
        r101.add(r104);
        goto L14
    L26:
        r116 = true;
        goto L27
    L49:
        r105 = false;
        goto L50
    L53:
        if (r101.isEmpty() == true) goto L55;
        PushSupporter.logger().e(r111, r112 + ".You should declare activities {" + r101 + "} in AndroidManifest.xml");
    L55:
        if (r103 == true) goto L57;
    L59:
        return false;
    L57:
        if (r101.isEmpty() == false) goto L59;
        return true;
    L80:
        return true;
    }

    private static boolean checkActivityFilter(Context r100, String r101, Component.IntentFilter r102, String r103) {
        Intent r104 = new Intent();
        r104.setPackage(r100.getPackageName());
        List<String> r105 = r102.categories;
        if (r105 == null) goto L8;
        Iterator<String> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r104.addCategory(r106.next());
    L8:
        r104.setAction(r103);
        Uri r107 = r102.data;
        if (r107 == null) goto L11;
        r104.setData(r107);
    L11:
        List<ResolveInfo> r108 = r100.getPackageManager().queryIntentActivities(r104, 576);
        if (r108 != null) goto L14;
        return false;
    L14:
        if (r108.size() <= 0) goto L34;
        Iterator<ResolveInfo> r109 = r108.iterator();
    L17:
        if (r109.hasNext() == false) goto L35;
        ActivityInfo r110 = r109.next().activityInfo;
        if (r110 == null) goto L17;
        if (TextUtils.equals(r110.name, r101) == false) goto L17;
        return true;
    L35:
        return false;
    L34:
        return false;
    }

    public static boolean checkContentProviders(Context r100, String r110, String r111, List<Component> r112) throws PackageManager.NameNotFoundException {
        if (r112 != null) goto L5;
    L44:
        return true;
    L5:
        if (r112.isEmpty() == true) goto L44;
        List<ProviderInfo> r101 = getProviders(r100);
        if (r101 != null) goto L10;
    L42:
        PushSupporter.logger().e(r110, r111 + " need to declare ContentProvider(s) " + r112);
        return false;
    L10:
        if (r101.size() == 0) goto L42;
        ArrayList r102 = new ArrayList();
        Iterator<Component> r113 = r112.iterator();
        boolean r103 = true;
    L14:
        if (r113.hasNext() == false) goto L34;
        Component r104 = r113.next();
        Iterator<ProviderInfo> r105 = r101.iterator();
    L17:
        if (r105.hasNext() == false) goto L30;
        ProviderInfo r106 = r105.next();
        if (TextUtils.equals(r106.name, r104.name) == false) goto L17;
        if (TextUtils.equals(r104.processName, r106.processName) == true) goto L24;
        PushSupporter.logger().e(r110, r111 + r104.name + " should be declared in process " + r104.processName + ", but now is " + r106.processName);
        r103 = false;
    L24:
        if (TextUtils.isEmpty(r104.authorities) == true) goto L26;
        boolean r107 = TextUtils.equals(r106.authority, r104.authorities);
    L27:
        if (r107 == true) goto L29;
        PushSupporter.logger().e(r110, r111 + r104.name + " need permission(s) {" + r104.authorities + "}, but now is" + r106.authority);
        r103 = false;
    L29:
        boolean r108 = true;
    L31:
        if (r108 == true) goto L14;
        r102.add(r104);
        goto L14
    L26:
        r107 = true;
        goto L27
    L30:
        r108 = false;
        goto L31
    L34:
        if (r102.isEmpty() == true) goto L36;
        PushSupporter.logger().e(r110, r111 + " .You should declare activities {" + r102 + "} in AndroidManifest.xml");
    L36:
        if (r103 == true) goto L38;
    L40:
        return false;
    L38:
        if (r102.isEmpty() == false) goto L40;
        return true;
    }

    public static boolean checkMetadata(Context r100, String r101, String r102, List<String> r103) throws PackageManager.NameNotFoundException {
        Bundle r104 = getMetadata(r100);
        if (r104 == null) goto L7;
        if (r104.isEmpty() == true) goto L7;
    L10:
        ArrayList r105 = new ArrayList();
        Iterator<String> r106 = r103.iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();
        if (r104 == null) goto L17;
        if (r104.containsKey(r107) == true) goto L12;
    L17:
        r105.add(r107);
        goto L12
    L19:
        if (r105.isEmpty() == true) goto L22;
        PushSupporter.logger().e(r101, r102 + ".You need to declare metadata {" + r105 + "} in AndroidManifest.xml");
        return false;
    L22:
        return true;
    L7:
        if (r103.isEmpty() == true) goto L10;
        PushSupporter.logger().e(r101, r102 + " metadata is empty!!!");
        return false;
    }

    public static boolean checkPermissions(Context r100, String r101, String r102, List<String> r103) throws PackageManager.NameNotFoundException {
        List<String> r104 = getAllPermissions(r100);
        if (r104 != null) goto L5;
    L19:
        PushSupporter.logger().e(r101, r102 + ".You need to declare permission(s) {" + r103 + "} in AndroidManifest.xml");
        return false;
    L5:
        if (r104.isEmpty() == true) goto L19;
        ArrayList r105 = new ArrayList();
        Iterator<String> r106 = r103.iterator();
    L9:
        if (r106.hasNext() == false) goto L14;
        String r107 = r106.next();
        if (r104.contains(r107) == true) goto L9;
        r105.add(r107);
        goto L9
    L14:
        if (r105.isEmpty() == true) goto L17;
        PushSupporter.logger().e(r101, r102 + ".You need to declare permission(s) {" + r105 + "} in AndroidManifest.xml");
        return false;
    L17:
        return true;
    }

    public static boolean checkReceiver(Context r110, String r111, String r112, List<Component> r113) throws PackageManager.NameNotFoundException {
        if (r113 != null) goto L5;
        return true;
    L5:
        if (r113.isEmpty() == true) goto L80;
        List<ActivityInfo> r100 = getReceivers(r110);
        if (r100 != null) goto L10;
    L61:
        PushSupporter.logger().e(r111, r112 + " error configuration:" + r113);
        return false;
    L10:
        if (r100.size() == 0) goto L61;
        ArrayList r101 = new ArrayList();
        Iterator<Component> r102 = r113.iterator();
        boolean r103 = true;
    L14:
        if (r102.hasNext() == false) goto L53;
        Component r104 = r102.next();
        Iterator<ActivityInfo> r114 = r100.iterator();
    L17:
        if (r114.hasNext() == false) goto L49;
        ActivityInfo r115 = r114.next();
        if (TextUtils.equals(r115.name, r104.name) == false) goto L17;
        if (TextUtils.equals(r104.processName, r115.processName) == true) goto L24;
        PushSupporter.logger().e(r111, r112 + " receiver configure error: " + r104.name + " should be in" + r104.processName + ",but now in " + r115.processName + " process");
        r103 = false;
    L24:
        if (TextUtils.isEmpty(r104.permission) == true) goto L26;
        boolean r116 = TextUtils.equals(r115.permission, r104.permission);
    L27:
        if (r116 == true) goto L29;
        PushSupporter.logger().e(r111, r112 + " receiver configure error: " + r104.name + " need permission " + r104.permission + ", but now the permission is:" + r115.permission);
        r103 = false;
    L29:
        List<Component.IntentFilter> r105 = r104.intentFilter;
        if (r105 == null) goto L47;
        Iterator<Component.IntentFilter> r106 = r105.iterator();
        boolean r117 = true;
    L33:
        if (r106.hasNext() == false) goto L44;
        Component.IntentFilter r118 = r106.next();
        List<String> r119 = r118.actions;
        if (r119 == null) goto L33;
        Iterator<String> r120 = r119.iterator();
    L38:
        if (r120.hasNext() == false) goto L33;
        String r121 = r120.next();
        if (checkReceiverFilter(r110, r104.name, r118, r121) == true) goto L38;
        PushSupporter.logger().e(r111, r112 + " " + r104.name + " configure error，need action : " + r121);
        r117 = false;
        goto L38
    L44:
        if (r117 == true) goto L47;
        r103 = false;
    L47:
        boolean r107 = true;
    L50:
        if (r107 == true) goto L14;
        r101.add(r104);
        goto L14
    L26:
        r116 = true;
        goto L27
    L49:
        r107 = false;
        goto L50
    L53:
        if (r101.isEmpty() == true) goto L55;
        PushSupporter.logger().e(r111, r112 + " receiver configure error: " + r101);
    L55:
        if (r103 == true) goto L57;
    L59:
        return false;
    L57:
        if (r101.isEmpty() == false) goto L59;
        return true;
    L80:
        return true;
    }

    private static boolean checkReceiverFilter(Context r100, String r101, Component.IntentFilter r102, String r103) {
        Intent r104 = new Intent();
        r104.setPackage(r100.getPackageName());
        List<String> r105 = r102.categories;
        if (r105 == null) goto L8;
        Iterator<String> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r104.addCategory(r106.next());
    L8:
        r104.setAction(r103);
        if (r102.data == null) goto L15;
        if (TextUtils.isEmpty(r102.mimeType) == true) goto L13;
        r104.setDataAndType(r102.data, r102.mimeType);
    L17:
        List<ResolveInfo> r107 = r100.getPackageManager().queryBroadcastReceivers(r104, 576);
        if (r107 != null) goto L20;
        return false;
    L20:
        if (r107.size() <= 0) goto L40;
        Iterator<ResolveInfo> r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L41;
        ActivityInfo r109 = r108.next().activityInfo;
        if (r109 == null) goto L23;
        if (TextUtils.equals(r109.name, r101) == false) goto L23;
        return true;
    L41:
        return false;
    L40:
        return false;
    L13:
        r104.setData(r102.data);
        goto L17
    L15:
        if (TextUtils.isEmpty(r102.mimeType) == true) goto L17;
        r104.setType(r102.mimeType);
        goto L17
    }

    public static boolean checkService(Context r110, String r111, String r112, List<Component> r113) throws PackageManager.NameNotFoundException {
        if (r113 != null) goto L5;
        return true;
    L5:
        if (r113.isEmpty() == true) goto L80;
        List<ServiceInfo> r100 = getServices(r110);
        if (r100 != null) goto L10;
    L61:
        PushSupporter.logger().e(r111, r112 + ". You need to declare service(s) {" + r113 + "} in AndroidManifest.xml");
        return false;
    L10:
        if (r100.size() == 0) goto L61;
        ArrayList r101 = new ArrayList();
        Iterator<Component> r102 = r113.iterator();
        boolean r103 = true;
    L14:
        if (r102.hasNext() == false) goto L53;
        Component r104 = r102.next();
        Iterator<ServiceInfo> r114 = r100.iterator();
    L17:
        if (r114.hasNext() == false) goto L49;
        ServiceInfo r115 = r114.next();
        if (TextUtils.equals(r115.name, r104.name) == false) goto L17;
        boolean r116 = TextUtils.equals(r104.processName, r115.processName);
        if (TextUtils.isEmpty(r104.permission) == true) goto L23;
        boolean r117 = TextUtils.equals(r115.permission, r104.permission);
    L25:
        if (r116 == true) goto L27;
        PushSupporter.logger().e(r111, r112 + " service configure error: " + r104.name + " should be declared in process " + r104.processName + ", but now in " + r115.processName);
        r103 = false;
    L27:
        if (r117 == true) goto L29;
        PushSupporter.logger().e(r111, r112 + " service configure error: " + r104.name + " need permission(s) {" + r104.permission + "}, but now " + r115.permission);
        r103 = false;
    L29:
        List<Component.IntentFilter> r118 = r104.intentFilter;
        if (r118 == null) goto L47;
        Iterator<Component.IntentFilter> r119 = r118.iterator();
        boolean r120 = true;
    L33:
        if (r119.hasNext() == false) goto L44;
        Component.IntentFilter r121 = r119.next();
        List<String> r122 = r121.actions;
        if (r122 == null) goto L33;
        Iterator<String> r123 = r122.iterator();
    L38:
        if (r123.hasNext() == false) goto L33;
        String r124 = r123.next();
        if (checkServiceFilter(r110, r104.name, r121, r124) == true) goto L38;
        PushSupporter.logger().e(r111, r112 + r104.name + " need to declare {" + r124 + "} action(s) in AndroidManifest.xml");
        r120 = false;
        goto L38
    L44:
        if (r120 == true) goto L47;
        r103 = false;
    L47:
        boolean r105 = true;
    L50:
        if (r105 == true) goto L14;
        r101.add(r104);
        goto L14
    L23:
        r117 = true;
        goto L25
    L49:
        r105 = false;
        goto L50
    L53:
        if (r101.isEmpty() == true) goto L55;
        PushSupporter.logger().e(r111, r112 + " need to declare service(s) {" + r101 + "} in AndroidManifest.xml");
    L55:
        if (r103 == true) goto L57;
    L59:
        return false;
    L57:
        if (r101.isEmpty() == false) goto L59;
        return true;
    L80:
        return true;
    }

    public static boolean checkServiceFilter(Context r100, String r101, Component.IntentFilter r102, String r103) {
        Intent r104 = new Intent();
        r104.setPackage(r100.getPackageName());
        List<String> r105 = r102.categories;
        if (r105 == null) goto L8;
        Iterator<String> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r104.addCategory(r106.next());
    L8:
        r104.setAction(r103);
        Uri r107 = r102.data;
        if (r107 == null) goto L11;
        r104.setData(r107);
    L11:
        List<ResolveInfo> r108 = r100.getPackageManager().queryIntentServices(r104, 576);
        if (r108 != null) goto L14;
        return false;
    L14:
        if (r108.size() <= 0) goto L38;
        Iterator<ResolveInfo> r109 = r108.iterator();
    L17:
        if (r109.hasNext() == false) goto L39;
        ResolveInfo r110 = r109.next();
        if (r110.serviceInfo == null) goto L17;
        if (TextUtils.isEmpty(r101) == true) goto L25;
        if (TextUtils.equals(r110.serviceInfo.name, r101) == false) goto L17;
        return true;
    L25:
        return true;
    L39:
        return false;
    L38:
        return false;
    }
}
