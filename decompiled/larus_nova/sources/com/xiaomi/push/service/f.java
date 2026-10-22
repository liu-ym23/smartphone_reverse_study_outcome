package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f464304a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final int[] f1098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SparseArray<Integer> f464305b = null;

    static {
        final int r100 = 5;
        f1098a = new int[]{1, 2, 4, 8, 16};
        f464304a = new AnonymousClass1(r100);
        f464305b = new AnonymousClass2(r100);
    }

    public f() {
    }

    private static boolean a(int r100, int r101) {
        if (r100 < 4) goto L5;
    L14:
        return true;
    L5:
        if ((r101 & 2) > 0) goto L14;
        if ((r101 & 1) > 0) goto L14;
        if ((r101 & 8) > 0) goto L14;
        if ((r101 & 16) > 0) goto L14;
        return false;
    }

    private static SharedPreferences a(Context r100) {
        return r100.getSharedPreferences("ch_permission_cache_file", 0);
    }

    public static void a(Context r100, String r101) {
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L36;
        List<NotificationChannel> r102 = af.a(r100, r101).m9353a();
        if (r102 != null) goto L9;
        return;
    L9:
        monitor-enter(f.class);
        SharedPreferences r103 = a(r100);     // Catch: Throwable -> L23
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L23
        Iterator<NotificationChannel> r105 = r102.iterator();     // Catch: Throwable -> L23
    L12:
        if (r105.hasNext() == false) goto L19;
        String r106 = (String) com.xiaomi.push.av.a(r105.next(), NativeDownloadModel.JsonKey.ID);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r106) == true) goto L12;
        if (r103.contains(r106) == false) goto L12;
        r104.add(r106);     // Catch: Throwable -> L23
        goto L12
    L19:
        if (r104.size() <= 0) goto L21;
        a(r103, r104);     // Catch: Throwable -> L23
    L21:
        monitor-exit(f.class);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static int a(String r100, String r101) {
        int r102 = 8;
        if (m9384a(r100, r101, 8) == true) goto L7;
        r102 = 0;
    L7:
        if (m9384a(r100, r101, 16) == false) goto L10;
        r102 = r102 | 16;
    L10:
        if (m9384a(r100, r101, 1) == false) goto L13;
        r102 = r102 | 1;
    L13:
        if (m9384a(r100, r101, 2) == false) goto L16;
        r102 = r102 | 2;
    L16:
        if (m9384a(r100, r101, 4) == true) goto L18;
        return r102;
    L18:
        return r102 | 4;
    }

    private static void a(SharedPreferences r100, List<String> r101) {
        SharedPreferences.Editor r102 = r100.edit();
        Iterator<String> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.remove(r103.next());
        goto L4
    L6:
        r102.commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Bundle m9383a(String r100, String r101) {
        return ag.a(com.xiaomi.push.q.m9304a(), r100, r101);
    }

    private static void a(SharedPreferences r100, final String r101) {
        a(r100, new AnonymousClass3(r101));
    }

    public static int a(Context r100, String r101, NotificationChannel r102) {
        if (Build.VERSION.SDK_INT < 26) goto L51;
        if (r100 == null) goto L51;
        if (TextUtils.isEmpty(r101) == true) goto L51;
        if (r102 == null) goto L51;
        if (r102.getImportance() == 0) goto L11;
        int r103 = 1;
    L12:
        int r104 = r103 | 0;
        int r105 = 16;
        int r106 = 4;
        if (ag.a() == false) goto L30;
        Bundle r107 = m9383a(r101, r102.getId());
        ag.a<String, String, String> r108 = ag.f464201f;
        if (r107.containsKey(r108.f464206c) == true) goto L17;
    L23:
        ag.a<String, String, String> r109 = ag.f464200e;
        if (r107.containsKey(r109.f464206c) == false) goto L43;
        if (r107.getBoolean(r109.f464206c) == true) goto L29;
        r105 = 32;
    L29:
        r104 = r104 | r105;
    L43:
        if (r102.getSound() == null) goto L45;
        int r110 = r104 | 64;
    L47:
        if (r102.shouldVibrate() == false) goto L49;
        int r111 = 256;
    L53:
        return r110 | r111;
    L49:
        r111 = 512;
        goto L53
    L45:
        r110 = r104 | 128;
        goto L47
    L17:
        if (r107.getBoolean(r108.f464206c) == true) goto L19;
    L21:
        r106 = 8;
    L22:
        r104 = r104 | r106;
        goto L23
    L19:
        if (r102.getImportance() < 4) goto L21;
    L30:
        int r112 = a(r101, r102.getId(), 8);
        if (r112 == 1) goto L33;
        if (r112 != 0) goto L37;
    L36:
        r104 = r104 | 8;
    L37:
        int r113 = a(r101, r102.getId(), 16);
        if (r113 != 1) goto L40;
        r104 = r104 | 16;
        goto L43
    L40:
        if (r113 != 0) goto L43;
        r104 = r104 | 32;
        goto L43
    L33:
        if (r102.getImportance() < 4) goto L36;
        r104 = r104 | 4;
        goto L37
    L11:
        r103 = 2;
    L51:
        com.xiaomi.channel.commonutils.logger.b.m8718a("context|packageName|channel must not be null ");
        return 0;
    }

    public static int a(Context r100, String r101, String r102) {
        if (Build.VERSION.SDK_INT < 26) goto L31;
        if (r100 == null) goto L31;
        if (TextUtils.isEmpty(r101) == true) goto L31;
        af r103 = af.a(r100, r101);
        if (r103 == null) goto L30;
        NotificationChannel r104 = r103.m9349a(r103.m9352a(r102));
        if (r104 != null) goto L12;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Channel must not be null");
        return 0;
    L12:
        if (r104.getImportance() == 0) goto L14;
        int r105 = 1;
    L15:
        int r106 = r105 | 0;
        int r107 = a(r101, r104.getId(), 8);
        if (r107 == 1) goto L18;
        if (r107 != 0) goto L22;
    L21:
        r106 = r106 | 8;
    L22:
        int r108 = a(r101, r104.getId(), 16);
        if (r108 != 1) goto L26;
        int r109 = r106 | 16;
    L33:
        return r109;
    L26:
        if (r108 != 0) goto L34;
        r109 = r106 | 32;
        goto L33
    L34:
        return r106;
    L18:
        if (r104.getImportance() < 4) goto L21;
        r106 = r106 | 4;
        goto L22
    L14:
        r105 = 2;
        goto L15
    L30:
        com.xiaomi.channel.commonutils.logger.b.m8718a("create NMHelper error");
        return 0;
    L31:
        com.xiaomi.channel.commonutils.logger.b.m8718a("Must greater than or equal android O and context|packageName not be null");
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m9384a(String r100, String r101, int r102) {
        boolean r103 = true;
        if (ag.a(com.xiaomi.push.q.m9304a(), r100, r101, f464304a.get(r102)) == 1) goto L6;
        r103 = false;
    L6:
        com.xiaomi.channel.commonutils.logger.b.m8718a("ChannelPermissions.checkPermission:" + r100 + ":" + r101 + ": <" + r102 + ContainerUtils.KEY_VALUE_DELIMITER + r103 + ">");
        return r103;
    }

    public static int a(String r100, String r101, int r102) {
        return ag.a(com.xiaomi.push.q.m9304a(), r100, r101, f464304a.get(r102));
    }

    private static void a(SharedPreferences r100, int r101, String r102) {
        r100.edit().putInt(r102, r101).commit();
    }

    public static void a(String r100, String r101, int r102, int r110) {
        int[] r103 = f1098a;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L13;
        int r106 = r103[r105];
        if ((f464305b.get(r106).intValue() & r110) == 0) goto L7;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ChannelPermissions.grantPermission:" + r100 + ":" + r101 + ": <" + r106 + "> :stoped by userLock");
    L12:
        r105 = r105 + 1;
        goto L3
    L7:
        if ((r102 & r106) <= 0) goto L9;
        boolean r107 = true;
    L10:
        a(r100, r101, r106, r107);
        goto L12
    L9:
        r107 = false;
        goto L10
    }

    private static void a(String r100, String r101, int r102, boolean r103) {
        com.xiaomi.channel.commonutils.logger.b.m8718a("ChannelPermissions.grantPermission:" + r100 + ":" + r101 + ": <" + r102 + ContainerUtils.KEY_VALUE_DELIMITER + r103 + "> :" + ag.a(com.xiaomi.push.q.m9304a(), r100, r101, f464304a.get(r102), r103));
    }

    private static void a(SharedPreferences r100, int r101, String r102, String r103, int r104) {
        if (r100.getInt(r103, 0) == r101) goto L6;
        a(r102, r103, r101, r104);
        return;
    }

    public static void a(Context r100, String r101, String r102, int r103, String r104, boolean r105, int r106) {
        if (com.xiaomi.push.j.m9295a(r100) == false) goto L38;
        if (TextUtils.isEmpty(r104) == true) goto L38;
        if (TextUtils.isEmpty(r102) == true) goto L38;
        if (TextUtils.isEmpty(r101) == true) goto L38;
        int r107 = com.xiaomi.push.r.a(r104, 0);
        boolean r108 = a(r103, r107);
        if (r105 == false) goto L23;
        a(r101, r102, r107, r106);
        if (r108 == true) goto L15;
        return;
    L15:
        monitor-enter(f.class);
        a(a(r100), r107, r102);     // Catch: Throwable -> L19
        monitor-exit(f.class);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L23:
        monitor-enter(f.class);
        SharedPreferences r109 = a(r100);     // Catch: Throwable -> L34
        if (r108 == false) goto L27;
    L28:
        a(r109, r107, r101, r102, r106);     // Catch: Throwable -> L34
        if (r108 == false) goto L31;
        a(r109, r107, r102);     // Catch: Throwable -> L34
    L32:
        monitor-exit(f.class);     // Catch: Throwable -> L34
        return;
    L31:
        a(r109, r102);     // Catch: Throwable -> L34
        goto L32
    L27:
        if (r109.contains(r102) == false) goto L32;
    L34:
        th = move-exception;
        throw th;
    L38:
        if (com.xiaomi.push.j.m9295a(r100) == false) goto L48;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(r104) + " channelId:" + String.valueOf(r102) + " targetPkg:" + r101);
        return;
    }
}
