package com.bytedance.iesgurd.core;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f250651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f250652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ File[] f250653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f250654d;

    public c(String r100, String r101, File[] r102, String r103) {
        this.f250651a = r100;
        this.f250652b = r101;
        this.f250653c = r102;
        this.f250654d = r103;
    }

    public final void a() {
        c r100 = this;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.f250651a, r100.f250652b);
        ez5.c.b(r101);     // Catch: Exception -> L57
        File[] r102 = r100.f250653c;
        int r103 = r102.length;
        String r104 = "";
        String r105 = "";
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= r103) goto L47;
        File r110 = r102[r106];
        boolean r111 = a.f250646a;
        String r112 = r100.f250652b;
        String r108 = r110.getName();
        File[] r113 = r102;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r101, r108);
        String r114 = r109.getAbsolutePath();
        PolarisFileWrapper r115 = r101;
        if (vy5.b.e(r114) == true) goto L10;
        int r210 = r103;
        String r211 = r104;
    L37:
        boolean r212 = false;
    L43:
        if (r212 == false) goto L45;
        r105 = r105 + r110.getName() + ';';
    L46:
        r106 = r106 + 1;
        r100 = this;
        r102 = r113;
        r101 = r115;
        r103 = r210;
        r104 = r211;
        goto L6
    L45:
        r107 = r107 + 1;
        goto L46
    L10:
        r212 = true;
        if (r109.exists() == true) goto L13;
    L41:
        r210 = r103;
        r211 = r104;
    L42:
        r110.renameTo(r109);
        vy5.b.f(r114);
        goto L43
    L13:
        if (r109.lastModified() <= r110.lastModified()) goto L41;
        File[] r116 = r109.listFiles(b.f250650a);
        r210 = r103;
        if (r116 == null) goto L39;
        int r117 = r116.length;
        r211 = r104;
        int r118 = 0;
    L17:
        if (r118 >= r117) goto L40;
        int r213 = r117;
        if ((!Intrinsics.areEqual(r116[r118].getName(), ".consumed")) == true) goto L20;
        r118 = r118 + 1;
        r117 = r213;
        goto L17
    L20:
        ez5.c.delete(r110);
        vy5.b.f(r114);
        File[] r119 = r110.listFiles();
        if (r119 == null) goto L25;
        int r120 = r119.length;
        String r121 = r211;
        int r122 = 0;
    L23:
        if (r122 >= r120) goto L26;
        r121 = r121 + r119[r122].getName() + ';';
        r122 = r122 + 1;
        r119 = r119;
    L26:
        int r123 = r116.length;
        String r124 = r211;
        int r125 = 0;
    L27:
        if (r125 >= r123) goto L29;
        r124 = r124 + r116[r125].getName() + ';';
        r125 = r125 + 1;
        r123 = r123;
        goto L27
    L29:
        String r126 = "oldVersion: " + r121 + ", newVersion: " + r124;
        EventSubType r127 = EventSubType.MIGRATE_RES_SKIP;
        JSONObject r128 = new JSONObject();
        r128.put("sub_type", r127.getType());
        if (r112 == null) goto L32;
        r128.put("access_key", r112);
    L32:
        if (r108 == null) goto L34;
        r128.put("channels", r108);
    L34:
        if (r126 == null) goto L36;
        r128.put(LocationMonitorConst.ERR_MSG, r126);
    L36:
        y86.a.c("geckosdk_event_message", r128);
        goto L37
    L25:
        r121 = r211;
    L40:
        ez5.c.delete(r109);
        goto L42
    L39:
        r211 = r104;
        goto L40
    L47:
        String r214 = r104;
        GeckoLogger.d("migrateResToSameDir, accessKey: " + this.f250652b + ", srcDir: " + this.f250654d + ", destDir: " + this.f250651a + ", channels: " + r105 + ", channelsIgnored: " + r107);
        EventSubType r129 = EventSubType.MIGRATE_RES;
        String r130 = this.f250652b;
        String r131 = String.valueOf(r107);
        JSONObject r132 = new JSONObject();
        r132.put("sub_type", r129.getType());
        if (r130 == null) goto L50;
        r132.put("access_key", r130);
    L50:
        if (r105 == null) goto L52;
        r132.put("channels", r105);
    L52:
        r132.put(LocationMonitorConst.ERR_MSG, r214);
        if (r131 == null) goto L55;
        r132.put("extra", r131);
    L55:
        y86.a.c("geckosdk_event_message", r132);
        return;
    L57:
        GeckoLogger.w("migrateResToSameDir, createDir failed, accessKey: " + r100.f250652b);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
