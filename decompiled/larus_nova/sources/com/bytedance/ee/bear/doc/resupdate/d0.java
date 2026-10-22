package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
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

/* JADX INFO: loaded from: classes16.dex */
public final class d0 {
    public static VFSFile g() {
        if (((Boolean) new ml5.b("debug_config").a("offline_support_change_resource", Boolean.FALSE)).booleanValue() == false) goto L5;
        VFSFile r100 = ay4.c.a(Biz.DYNAMIC, "").toFile();
    L7:
        if (r100.exists() == true) goto L9;
        r100.mkdirs();
    L13:
        return r100;
    L9:
        if (r100.isFile() == false) goto L11;
        r100.delete();
    L11:
        r100.mkdirs();
        goto L13
    L5:
        Biz r101 = Biz.DYNAMIC;
        int r102 = ay4.c.f16749a;
        r100 = ay4.c.a.f(r101, "", true, false, 8).toFile();
        goto L7
    }

    public static VFSFile c() throws IOException {
        VFSFile r100 = g();
        VFSFile r101 = ay4.d.a().D(r100, "space_downloadX");
        n(r101);
        return r101;
    }

    public static void a(List<VFSFile> r100) {
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == true) goto L20;
        tt5.a.h("ResUtil", "clearRedundancyFiles(): size == " + r101.size());
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        VFSFile r104 = (VFSFile) r103.next();
        VFSFile r105 = ay4.d.a().i(r104.getAbsolutePath() + "_del");
        if (r104.renameTo(r105) == true) goto L10;
        tt5.a.k("ResUtil", "getLatestResourceVersion: rename failed origin file = " + r104);
        goto L7
    L10:
        r102.add(r105);
        goto L7
    L12:
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new c0(r102), new b0());
        return;
    }

    public static void b(Closeable r100) {
        ((BufferedReader) r100).close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);
    }

    public static VFSFile d(String r100) throws IOException {
        VFSFile r101 = j(r100);
        VFSFile r102 = ay4.d.a().D(r101, "gray");
        n(r102);
        return r102;
    }

    public static String f(VFSPath r100) {
        if (r100 == null) goto L43;
        VFSPath r101 = r100.subPath(ChameleonResConstants.TEMPLATE_VERSION);
        if (r101.toFile().isFile() == true) goto L7;
        return "";
    L7:
        if (r101.toFile().exists() == true) goto L34;
        return "";
    L34:
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r101.toFile()));     // Catch: FileNotFoundException -> L19
    L32:
        String r103 = r102.readLine();     // Catch: Throwable -> L21 IOException -> L23
        if (r103 == null) goto L25;
        if (r103.startsWith("version") == false) goto L32;
        String[] r104 = r103.split(":");     // Catch: Throwable -> L21 IOException -> L23
        if (r104.length != 2) goto L32;
        String r105 = r104[1];     // Catch: Throwable -> L21 IOException -> L23
        b(r102);     // Catch: FileNotFoundException -> L19
        return r105;
    L25:
        b(r102);     // Catch: FileNotFoundException -> L19
        return null;
    L23:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        b(r102);     // Catch: FileNotFoundException -> L19
        throw th;     // Catch: FileNotFoundException -> L19
    L19:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);
        return "";
    L43:
        return "";
    }

    public static g0 h(String r100) {
        String r101 = com.bytedance.ee.util.io.d.f243145a;
        String r102 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L27:
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r102) == false) goto L14;
        int r104 = -1;
    L15:
        r103.put("result", r104);     // Catch: JSONException -> L17
        ((h) org.koin.java.a.a(h.class)).a("ccm_get_revison_from_7zeesz_asset_result_dev", r103);     // Catch: JSONException -> L17
    L20:
        if (TextUtils.isEmpty(r102) == false) goto L24;
        tt5.a.d("ResUtil", "get versioninfo is null");
        return new g0();
    L24:
        return k(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r102.getBytes()))));
    L14:
        r104 = 0;
    L17:
        e = move-exception;
        tt5.a.d("ResUtil", "getResInfoOf7z: report event fails:" + e);
        goto L20
    L5:
        if (TextUtils.isEmpty("eesz/current_revision") == true) goto L27;
        r102 = Archive.extractEntryToString(r100, "eesz/current_revision", null);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        tt5.a.d(com.bytedance.ee.util.io.d.f243145a, "extractEntry :eesz/current_revision fails : " + e + " message:" + e.getMessage());
        goto L27
    }

    public static g0 i(VFSFile r100) {
        VFSFile[] r101 = r100.listFiles();     // Catch: Exception -> L14
        if (r101 == null) goto L13;
        int r102 = r101.length;     // Catch: Exception -> L14
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L13;
        VFSFile r104 = r101[r103];     // Catch: Exception -> L14
        if (ChameleonResConstants.TEMPLATE_VERSION.equals(r104.getName()) == true) goto L10;
        r103 = r103 + 1;     // Catch: Exception -> L14
        goto L6
    L10:
        return k(new BufferedReader(new InputStreamReader(ay4.d.a().j(r104))));
    L13:
        return new g0();
    L14:
        e = move-exception;
        tt5.a.e("ResUtil", "getResourceRevision fail", e, false);
        return new g0();
    }

    public static VFSFile j(String r100) throws IOException {
        VFSFile r101 = g();
        VFSFile r102 = ay4.d.a().D(r101, "space_res");
        n(r102);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.h("ResUtil", "getResourceRootDir(): channel is empty,return folder spaceRes");
        return r102;
    L6:
        VFSFile r103 = ay4.d.a().D(r102, r100);
        n(r103);
        return r103;
    }

    public static g0 k(BufferedReader r100) {
        g0 r101 = new g0();
    L41:
        String r102 = r100.readLine();     // Catch: Throwable -> L33 IOException -> L35
        if (r102 == null) goto L37;
        if (r102.startsWith("version") == false) goto L12;
        String[] r103 = r102.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r103.length != 2) goto L12;
        r101.f218011b = r103[1];     // Catch: Throwable -> L33 IOException -> L35
    L12:
        if (r102.startsWith("revision") == false) goto L17;
        String[] r104 = r102.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r104.length != 2) goto L17;
        r101.f218010a = r104[1];     // Catch: Throwable -> L33 IOException -> L35
    L17:
        if (r102.startsWith("is_slim") == false) goto L22;
        String[] r105 = r102.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r105.length != 2) goto L22;
        r101.f218012c = "1".equals(r105[1]);     // Catch: Throwable -> L33 IOException -> L35
    L22:
        if (r102.startsWith("full_pkg_scm_version") == false) goto L27;
        String[] r106 = r102.split(":");     // Catch: Throwable -> L33 IOException -> L35
        if (r106.length != 2) goto L27;
        r101.f218015f = r106[1];     // Catch: Throwable -> L33 IOException -> L35
    L27:
        if (r102.startsWith("full_pkg_url_home") == false) goto L30;
        r101.f218013d = r102.substring(r102.indexOf(":") + 1);     // Catch: Throwable -> L33 IOException -> L35
    L30:
        if (r102.startsWith("full_pkg_url_oversea") == false) goto L41;
        r101.f218014e = r102.substring(r102.indexOf(":") + 1);     // Catch: Throwable -> L33 IOException -> L35
    L37:
        b(r100);
        return r101;
    L33:
        th = move-exception;
        b(r100);
        throw th;
    L35:
        e = move-exception;
        tt5.a.f("ResUtil", e, false);     // Catch: Throwable -> L33
        goto L37
    }

    public static boolean l(String r100) {
        VFSFile[] r101 = j(r100).listFiles();     // Catch: IOException -> L20
        if (r101 != null) goto L6;
    L18:
        tt5.a.h("ResUtil", "hasFullResource(): resourceRootDir is empty");     // Catch: IOException -> L20
        return false;
    L6:
        if (r101.length == 0) goto L18;
        int r102 = r101.length;     // Catch: IOException -> L20
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L22;
        VFSFile r104 = r101[r103];     // Catch: IOException -> L20
        String r105 = r104.getName();     // Catch: IOException -> L20
        if (TextUtils.isEmpty(r105) == false) goto L13;
        boolean r106 = false;
    L14:
        if (r106 == true) goto L15;
        r103 = r103 + 1;     // Catch: IOException -> L20
        goto L9
    L15:
        tt5.a.h("ResUtil", "hasFullResource(): version is = " + r104.getName());     // Catch: IOException -> L20
        return true;
    L13:
        r106 = Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r105);     // Catch: IOException -> L20
    L22:
        return false;
    L20:
        e = move-exception;
        tt5.a.e("ResUtil", "hasFullResource(): failed ", e, false);
        goto L22
    }

    public static boolean m(String r100) {
        VFSFile r101 = g();
        VFSFile r102 = ay4.d.a().D(r101, "space_res");
        return ay4.d.a().D(r102, r100).exists();
    }

    public static void n(VFSFile r100) throws IOException {
        if (r100.exists() == false) goto L14;
        if (r100.isFile() == false) goto L15;
        boolean r101 = r100.delete();
        tt5.a.h("ResUtil", "getResourceRootDir(): delete file result = " + r101 + ",file = " + r100);
        if (r101 == true) goto L9;
        return;
    L9:
        if (r100.mkdir() == false) goto L12;
        return;
    L12:
        throw new IOException("spaceRes mkdir() false " + r100);
    L15:
        return;
    L14:
        if (r100.mkdir() == false) goto L17;
        return;
    L17:
        throw new IOException("spaceRes mkdir() false file = " + r100);
    }

    public static String e(Context r100, String r101, boolean r102) {
        VFSFile[] r103 = j(r101).listFiles();     // Catch: IOException -> L21
        if (r103 != null) goto L6;
    L19:
        tt5.a.h("ResUtil", "getLatestResourceVersion(): resourceRootDir is empty");     // Catch: IOException -> L21
        return "";
    L6:
        if (r103.length == 0) goto L19;
        ArrayList r104 = new ArrayList();     // Catch: IOException -> L21
        ArrayList r105 = new ArrayList();     // Catch: IOException -> L21
        o(r100, r103, r104, r105);     // Catch: IOException -> L21
        Collections.sort(r104, new tu5.a());     // Catch: IOException -> L21
        if (r104.size() <= 0) goto L11;
        VFSFile r106 = (VFSFile) ListProtector.remove(r104, 0);     // Catch: IOException -> L21
    L12:
        r105.addAll(r104);     // Catch: IOException -> L21
        if (r102 == false) goto L15;
        a(r105);     // Catch: IOException -> L21
    L15:
        if (r106 != null) goto L18;
        return "";
    L18:
        return r106.getName();
    L11:
        r106 = null;
    L21:
        e = move-exception;
        tt5.a.e("ResUtil", "getLatestResourceVersion(): failed ", e, false);
        return "";
    }

    public static void o(Context r100, VFSFile[] r101, List<VFSFile> r102, List<VFSFile> r103) {
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L22;
        VFSFile r106 = r101[r105];
        String r107 = r106.getName();
        if (TextUtils.isEmpty(r107) == false) goto L7;
        boolean r108 = false;
    L8:
        if (r108 == false) goto L11;
        ((ArrayList) r102).add(r106);
    L21:
        r105 = r105 + 1;
        goto L3
    L11:
        if (r106.getName().contains("_sim") == true) goto L21;
        if (r106.getName().contains(ChameleonResConstants.TEMP_SUFFIX) == true) goto L21;
        if (r106.getName().contains(r100.getString(R.string.config_gecko_channel)) == true) goto L21;
        if (r106.getName().contains("gray") == true) goto L21;
        if (r106.getName().contains(ModifiedTimeWatch.WATCH_TYPE_SPECIFIC) == true) goto L21;
        ((ArrayList) r103).add(r106);
        goto L21
    L7:
        r108 = Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r107);
        goto L8
    }
}
