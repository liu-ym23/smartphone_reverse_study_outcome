package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d0 {
    public static VFSFile g() {
        if (((Boolean) new ml5.b("debug_config").a("offline_support_change_resource", Boolean.FALSE)).booleanValue() == false) goto L5;
        VFSFile r0 = ay4.c.a(Biz.DYNAMIC, "").toFile();
    L7:
        if (r0.exists() == true) goto L9;
        r0.mkdirs();
    L13:
        return r0;
    L9:
        if (r0.isFile() == false) goto L11;
        r0.delete();
    L11:
        r0.mkdirs();
        goto L13
    L5:
        Biz r1 = Biz.DYNAMIC;
        int r2 = ay4.c.a;
        r0 = ay4.c.a.f(r1, "", true, false, 8).toFile();
        goto L7
    }

    public static VFSFile c() throws IOException {
        VFSFile r0 = g();
        VFSFile r1 = ay4.d.a().D(r0, "space_downloadX");
        n(r1);
        return r1;
    }

    public static void a(List<VFSFile> r6) {
        ArrayList r7 = (ArrayList) r6;
        if (r7.isEmpty() == true) goto L20;
        tt5.a.h("ResUtil", "clearRedundancyFiles(): size == " + r7.size());
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        VFSFile r2 = (VFSFile) r8.next();
        VFSFile r3 = ay4.d.a().i(r2.getAbsolutePath() + "_del");
        if (r2.renameTo(r3) == true) goto L10;
        tt5.a.k("ResUtil", "getLatestResourceVersion: rename failed origin file = " + r2);
        goto L7
    L10:
        r0.add(r3);
        goto L7
    L12:
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new c0(r0), new b0());
        return;
    }

    public static void b(Closeable r2) {
        ((BufferedReader) r2).close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);
    }

    public static VFSFile d(String r2) throws IOException {
        VFSFile r3 = j(r2);
        VFSFile r4 = ay4.d.a().D(r3, "gray");
        n(r4);
        return r4;
    }

    public static String f(VFSPath r5) {
        if (r5 == null) goto L43;
        VFSPath r6 = r5.subPath("current_revision");
        if (r6.toFile().isFile() == true) goto L7;
        return "";
    L7:
        if (r6.toFile().exists() == true) goto L34;
        return "";
    L34:
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper(r6.toFile()));     // Catch: FileNotFoundException -> L19
    L32:
        String r7 = r2.readLine();     // Catch: Throwable -> L21 IOException -> L23
        if (r7 == null) goto L25;
        if (r7.startsWith("version") == false) goto L32;
        String[] r8 = r7.split(":");     // Catch: Throwable -> L21 IOException -> L23
        if (r8.length != 2) goto L32;
        String r9 = r8[1];     // Catch: Throwable -> L21 IOException -> L23
        b(r2);     // Catch: FileNotFoundException -> L19
        return r9;
    L25:
        b(r2);     // Catch: FileNotFoundException -> L19
        return null;
    L23:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        b(r2);     // Catch: FileNotFoundException -> L19
        throw th;     // Catch: FileNotFoundException -> L19
    L19:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);
        return "";
    L43:
        return "";
    }

    public static g0 h(String r5) {
        String r1 = com.bytedance.ee.util.io.d.a;
        String r2 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L27:
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r2) == false) goto L14;
        int r3 = -1;
    L15:
        r6.put(TipCallBackData.RESULT, r3);     // Catch: JSONException -> L17
        ((h) org.koin.java.a.a(h.class)).a("ccm_get_revison_from_7zeesz_asset_result_dev", r6);     // Catch: JSONException -> L17
    L20:
        if (TextUtils.isEmpty(r2) == false) goto L24;
        tt5.a.d("ResUtil", "get versioninfo is null");
        return new g0();
    L24:
        return k(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r2.getBytes()))));
    L14:
        r3 = 0;
    L17:
        e = move-exception;
        tt5.a.d("ResUtil", "getResInfoOf7z: report event fails:" + e);
        goto L20
    L5:
        if (TextUtils.isEmpty("eesz/current_revision") == true) goto L27;
        r2 = Archive.extractEntryToString(r5, "eesz/current_revision", null);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        tt5.a.d(com.bytedance.ee.util.io.d.a, "extractEntry :eesz/current_revision fails : " + e + " message:" + e.getMessage());
        goto L27
    }

    public static g0 i(VFSFile r6) {
        File[] r7 = r6.listFiles();     // Catch: Exception -> L14
        if (r7 == null) goto L13;
        int r1 = r7.length;     // Catch: Exception -> L14
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        File r3 = r7[r2];     // Catch: Exception -> L14
        if ("current_revision".equals(r3.getName()) == true) goto L10;
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L6
    L10:
        return k(new BufferedReader(new InputStreamReader(ay4.d.a().j(r3))));
    L13:
        return new g0();
    L14:
        e = move-exception;
        tt5.a.e("ResUtil", "getResourceRevision fail", e, false);
        return new g0();
    }

    public static VFSFile j(String r3) throws IOException {
        VFSFile r0 = g();
        VFSFile r1 = ay4.d.a().D(r0, "space_res");
        n(r1);
        if (TextUtils.isEmpty(r3) == false) goto L6;
        tt5.a.h("ResUtil", "getResourceRootDir(): channel is empty,return folder spaceRes");
        return r1;
    L6:
        VFSFile r4 = ay4.d.a().D(r1, r3);
        n(r4);
        return r4;
    }

    public static g0 k(BufferedReader r7) {
        g0 r0 = new g0();
    L41:
        String r1 = r7.readLine();     // Catch: Throwable -> L33 IOException -> L35
        if (r1 == null) goto L37;
        if (r1.startsWith("version") == false) goto L12;
        String[] r2 = r1.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r2.length != 2) goto L12;
        r0.b = r2[1];     // Catch: Throwable -> L33 IOException -> L35
    L12:
        if (r1.startsWith("revision") == false) goto L17;
        String[] r3 = r1.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r3.length != 2) goto L17;
        r0.a = r3[1];     // Catch: Throwable -> L33 IOException -> L35
    L17:
        if (r1.startsWith("is_slim") == false) goto L22;
        String[] r4 = r1.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r4.length != 2) goto L22;
        r0.c = DiagramData$RESULT.SUCCESS.equals(r4[1]);     // Catch: Throwable -> L33 IOException -> L35
    L22:
        if (r1.startsWith("full_pkg_scm_version") == false) goto L27;
        String[] r5 = r1.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r5.length != 2) goto L27;
        r0.f = r5[1];     // Catch: Throwable -> L33 IOException -> L35
    L27:
        if (r1.startsWith("full_pkg_url_home") == false) goto L30;
        r0.d = r1.substring(r1.indexOf(":") + 1);     // Catch: Throwable -> L33 IOException -> L35
    L30:
        if (r1.startsWith("full_pkg_url_oversea") == false) goto L41;
        r0.e = r1.substring(r1.indexOf(":") + 1);     // Catch: Throwable -> L33 IOException -> L35
    L37:
        b(r7);
        return r0;
    L33:
        th = move-exception;
        b(r7);
        throw th;
    L35:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);     // Catch: Throwable -> L33
        goto L37
    }

    public static boolean l(String r7) {
        File[] r8 = j(r7).listFiles();     // Catch: IOException -> L20
        if (r8 != null) goto L6;
    L18:
        tt5.a.h("ResUtil", "hasFullResource(): resourceRootDir is empty");     // Catch: IOException -> L20
        return false;
    L6:
        if (r8.length == 0) goto L18;
        int r2 = r8.length;     // Catch: IOException -> L20
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L22;
        File r4 = r8[r3];     // Catch: IOException -> L20
        String r5 = r4.getName();     // Catch: IOException -> L20
        if (TextUtils.isEmpty(r5) == false) goto L13;
        boolean r6 = false;
    L14:
        if (r6 == true) goto L15;
        r3 = r3 + 1;     // Catch: IOException -> L20
        goto L9
    L15:
        tt5.a.h("ResUtil", "hasFullResource(): version is = " + r4.getName());     // Catch: IOException -> L20
        return true;
    L13:
        r6 = Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r5);     // Catch: IOException -> L20
    L22:
        return false;
    L20:
        e = move-exception;
        tt5.a.e("ResUtil", "hasFullResource(): failed ", e, false);
        goto L22
    }

    public static boolean m(String r3) {
        VFSFile r0 = g();
        VFSFile r1 = ay4.d.a().D(r0, "space_res");
        return ay4.d.a().D(r1, r3).exists();
    }

    public static void n(VFSFile r3) throws IOException {
        if (r3.exists() == false) goto L14;
        if (r3.isFile() == false) goto L15;
        boolean r0 = r3.delete();
        tt5.a.h("ResUtil", "getResourceRootDir(): delete file result = " + r0 + ",file = " + r3);
        if (r0 == true) goto L9;
        return;
    L9:
        if (r3.mkdir() == false) goto L12;
        return;
    L12:
        throw new IOException("spaceRes mkdir() false " + r3);
    L15:
        return;
    L14:
        if (r3.mkdir() == false) goto L17;
        return;
    L17:
        throw new IOException("spaceRes mkdir() false file = " + r3);
    }

    public static String e(Context r5, String r6, boolean r7) {
        VFSFile[] r8 = j(r6).listFiles();     // Catch: IOException -> L21
        if (r8 != null) goto L6;
    L19:
        tt5.a.h("ResUtil", "getLatestResourceVersion(): resourceRootDir is empty");     // Catch: IOException -> L21
        return "";
    L6:
        if (r8.length == 0) goto L19;
        ArrayList r3 = new ArrayList();     // Catch: IOException -> L21
        ArrayList r4 = new ArrayList();     // Catch: IOException -> L21
        o(r5, r8, r3, r4);     // Catch: IOException -> L21
        Collections.sort(r3, new tu5.a());     // Catch: IOException -> L21
        if (r3.size() <= 0) goto L11;
        VFSFile r9 = (VFSFile) ListProtector.remove(r3, 0);     // Catch: IOException -> L21
    L12:
        r4.addAll(r3);     // Catch: IOException -> L21
        if (r7 == false) goto L15;
        a(r4);     // Catch: IOException -> L21
    L15:
        if (r9 != null) goto L18;
        return "";
    L18:
        return r9.getName();
    L11:
        r9 = null;
    L21:
        e = move-exception;
        tt5.a.e("ResUtil", "getLatestResourceVersion(): failed ", e, false);
        return "";
    }

    public static void o(Context r6, VFSFile[] r7, List<VFSFile> r8, List<VFSFile> r9) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L22;
        VFSFile r3 = r7[r2];
        String r4 = r3.getName();
        if (TextUtils.isEmpty(r4) == false) goto L7;
        boolean r5 = false;
    L8:
        if (r5 == false) goto L11;
        ((ArrayList) r8).add(r3);
    L21:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r3.getName().contains("_sim") == true) goto L21;
        if (r3.getName().contains("_temp") == true) goto L21;
        if (r3.getName().contains(r6.getString(2131895998)) == true) goto L21;
        if (r3.getName().contains("gray") == true) goto L21;
        if (r3.getName().contains("specific") == true) goto L21;
        ((ArrayList) r9).add(r3);
        goto L21
    L7:
        r5 = Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r4);
        goto L8
    }
}
