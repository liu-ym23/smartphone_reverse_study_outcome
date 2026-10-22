package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.v;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static HashMap<String, String> m8732a(String r100) {
        HashMap r101 = new HashMap();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L32:
        return r101;
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L32;
        ?? r102 = 0;
        ?? r103 = 0;
        BufferedReader r104 = null;
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L24 Exception -> L26
    L37:
        String r106 = r105.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r106 == null) goto L19;
        ?? r107 = r106.split("%%%");     // Catch: Throwable -> L20 Exception -> L22
        r103 = r107.length;     // Catch: Throwable -> L20 Exception -> L22
        if (r103 < 2) goto L37;
        r103 = 0;
        r103 = 0;
        if (TextUtils.isEmpty(r107[0]) == true) goto L37;
        if (TextUtils.isEmpty(r107[1]) == true) goto L37;
        r103 = r107[0];     // Catch: Throwable -> L20 Exception -> L22
        r101.put(r103, r107[1]);     // Catch: Throwable -> L20 Exception -> L22
    L19:
        v.a(r105);
        r102 = r103;
    L33:
        return r101;
    L22:
        e = e;
        r104 = r105;
    L27:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L24
        v.a(r104);
        r102 = r104;
    L20:
        th = th;
        r102 = r105;
    L30:
        v.a(r102);
        throw th;
    L24:
        th = th;
    L26:
        e = e;
        goto L27
    }

    private static PerfClientReport a(String r100) {
        PerfClientReport r101 = null;
        String[] r102 = m8734a(r100);     // Catch: Exception -> L17
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.length >= 4) goto L8;
        return null;
    L8:
        if (TextUtils.isEmpty(r102[0]) == false) goto L10;
        return null;
    L10:
        if (TextUtils.isEmpty(r102[1]) == false) goto L12;
        return null;
    L12:
        if (TextUtils.isEmpty(r102[2]) == false) goto L14;
        return null;
    L14:
        if (TextUtils.isEmpty(r102[3]) == true) goto L26;
        r101 = PerfClientReport.getBlankInstance();     // Catch: Exception -> L17
        r101.production = CastIntegerProtector.parseInt(r102[0]);     // Catch: Exception -> L17
        r101.clientInterfaceId = r102[1];     // Catch: Exception -> L17
        r101.reportType = CastIntegerProtector.parseInt(r102[2]);     // Catch: Exception -> L17
        r101.code = CastIntegerProtector.parseInt(r102[3]);     // Catch: Exception -> L17
        return r101;
    L26:
        return null;
    L17:
        com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static long[] m8733a(String r100) {
        long[] r101 = new long[2];
        String[] r102 = r100.split("#");     // Catch: Exception -> L7
        if (r102.length < 2) goto L6;
        r101[0] = CastLongProtector.parseLong(r102[0].trim());     // Catch: Exception -> L7
        r101[1] = CastLongProtector.parseLong(r102[1].trim());     // Catch: Exception -> L7
    L6:
        return r101;
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return null;
    }

    public static String a(PerfClientReport r100) {
        return r100.production + "#" + r100.clientInterfaceId + "#" + r100.reportType + "#" + r100.code;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String[] m8734a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return r100.split("#");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static List<String> a(Context r100, String r101) {
        ArrayList r102 = new ArrayList();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L81:
        return r102;
    L5:
        if (new PolarisFileWrapper(r101).exists() == false) goto L81;
        FileLock r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101 + ".lock");     // Catch: Throwable -> L51 Exception -> L54
        v.m9433a(r104);     // Catch: Throwable -> L47 Exception -> L49
        RandomAccessFile r105 = new RandomAccessFile(r104, "rw");     // Catch: Throwable -> L47 Exception -> L49
    L92:
        FileLock r106 = r105.getChannel().lock();     // Catch: Throwable -> L43 Exception -> L45
    L98:
        ?? r107 = new BufferedReader(new PolarisFileReaderWrapper(r101));     // Catch: Throwable -> L37 Exception -> L40
    L96:
        String r108 = r107.readLine();     // Catch: Throwable -> L33 Exception -> L35
        if (r108 == null) goto L25;
        String[] r109 = r108.split("%%%");     // Catch: Throwable -> L33 Exception -> L35
        if (r109.length < 2) goto L96;
        if (TextUtils.isEmpty(r109[0]) == true) goto L96;
        if (TextUtils.isEmpty(r109[1]) == true) goto L96;
        PerfClientReport r110 = a(a(r109[0]), r109[1]);     // Catch: Throwable -> L33 Exception -> L35
        if (r110 == null) goto L96;
        r102.add(r110.toJsonString());     // Catch: Throwable -> L33 Exception -> L35
    L25:
        if (r106 != null) goto L27;
    L32:
        v.a(r105);
        v.a(r107);
    L67:
        r104.delete();
    L68:
        return r102;
    L27:
        if (r106.isValid() == false) goto L32;
        r106.release();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L35:
        e = e;
    L42:
        r103 = r106;
        r107 = r107;
    L88:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L69
        if (r103 != null) goto L60;
    L65:
        v.a(r105);
        v.a(r107);
        if (r104 == null) goto L68;
    L60:
        if (r103.isValid() == false) goto L65;
        r103.release();     // Catch: IOException -> L63
    L63:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L69:
        th = th;
    L70:
        if (r103 != null) goto L72;
    L77:
        v.a(r105);
        v.a(r107);
        if (r104 == null) goto L112;
        r104.delete();
        throw th;
    L112:
        throw th;
    L72:
        if (r103.isValid() == false) goto L77;
        r103.release();     // Catch: IOException -> L75
    L75:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L33:
        th = th;
    L39:
        r103 = r106;
        goto L70
    L40:
        e = e;
        r107 = 0;
    L37:
        th = th;
        r107 = 0;
    L45:
        e = e;
        r107 = 0;
    L43:
        th = th;
        r107 = 0;
    L49:
        e = e;
        r105 = null;
    L56:
        r107 = r105;
    L47:
        th = th;
        r105 = null;
    L53:
        r107 = r105;
        goto L70
    L54:
        e = e;
        r104 = null;
        r105 = null;
    L51:
        th = th;
        r104 = null;
        r105 = null;
        goto L53
    }

    public static void a(String r110, com.xiaomi.clientreport.data.a[] r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (r111.length > 0) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r110) == true) goto L73;
        FileLock r100 = null;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r110 + ".lock");     // Catch: Throwable -> L31
        v.m9433a(r101);     // Catch: Throwable -> L31
        RandomAccessFile r102 = new RandomAccessFile(r101, "rw");     // Catch: Throwable -> L31
        r100 = r102.getChannel().lock();     // Catch: Throwable -> L53
        HashMap<String, String> r103 = m8732a(r110);     // Catch: Throwable -> L53
        int r104 = r111.length;     // Catch: Throwable -> L53
        int r112 = 0;
    L11:
        if (r112 >= r104) goto L23;
        com.xiaomi.clientreport.data.a r105 = r111[r112];     // Catch: Throwable -> L53
        if (r105 == null) goto L22;
        String r106 = a((PerfClientReport) r105);     // Catch: Throwable -> L53
        long r107 = ((PerfClientReport) r105).perfCounts;     // Catch: Throwable -> L53
        long r108 = ((PerfClientReport) r105).perfLatencies;     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(r106) == true) goto L22;
        if (r107 <= 0) goto L22;
        if (r108 < 0) goto L22;
        a(r103, r106, r107, r108);     // Catch: Throwable -> L53
    L22:
        r112 = r112 + 1;     // Catch: Throwable -> L53
        goto L11
    L23:
        a(r110, r103);     // Catch: Throwable -> L53
        if (r100 != null) goto L26;
    L40:
        v.a(r102);
        return;
    L26:
        if (r100.isValid() == false) goto L40;
        r100.release();     // Catch: IOException -> L29
    L29:
        e = e;
    L39:
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L58:
        com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");     // Catch: Throwable -> L42
        if (r100 == null) goto L40;
        if (r100.isValid() == false) goto L40;
        r100.release();     // Catch: IOException -> L38
    L38:
        e = e;
    L42:
        th = move-exception;
        if (r100 != null) goto L45;
    L50:
        v.a(r102);
        throw th;
    L45:
        if (r100.isValid() == false) goto L50;
        r100.release();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L31:
        r102 = null;
        goto L58
    }

    private static void a(String r100, HashMap<String, String> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L30;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.size() == 0) goto L39;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L34;
        r102.delete();
    L34:
        BufferedWriter r103 = new BufferedWriter(new PolarisFileWriterWrapper(r102));     // Catch: Throwable -> L20 Exception -> L22
        Iterator<String> r104 = r101.keySet().iterator();     // Catch: Exception -> L18 Throwable -> L27
    L15:
        if (r104.hasNext() == false) goto L25;
        String r105 = r104.next();     // Catch: Exception -> L18 Throwable -> L27
        r103.write(r105 + "%%%" + r101.get(r105));     // Catch: Exception -> L18 Throwable -> L27
        r103.newLine();     // Catch: Exception -> L18 Throwable -> L27
    L25:
        v.a(r103);
        return;
    L18:
        Exception e100 = e;
    L24:
        com.xiaomi.channel.commonutils.logger.b.a(e100);     // Catch: Throwable -> L27
    L27:
        Throwable th10 = th;
    L28:
        v.a(r103);
        throw th10;
    L22:
        e = move-exception;
        r103 = null;
        e100 = e;
    L20:
        th = move-exception;
        r103 = null;
        th10 = th;
        goto L28
    L39:
        return;
    }

    private static PerfClientReport a(PerfClientReport r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        long[] r102 = m8733a(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        r100.perfCounts = r102[0];
        r100.perfLatencies = r102[1];
        return r100;
    }

    private static void a(HashMap<String, String> r100, String r110, long r111, long r112) {
        String r101 = r100.get(r110);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r100.put(r110, r111 + "#" + r112);
        return;
    L5:
        long[] r102 = m8733a(r101);
        if (r102 == null) goto L13;
        long r103 = r102[0];
        if (r103 <= 0) goto L13;
        long r104 = r102[1];
        if (r104 < 0) goto L13;
        String r113 = (r111 + r103) + "#" + (r112 + r104);
    L14:
        r100.put(r110, r113);
        return;
    L13:
        r113 = r111 + "#" + r112;
        goto L14
    }
}
