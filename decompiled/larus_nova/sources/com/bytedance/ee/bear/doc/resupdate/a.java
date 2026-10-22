package com.bytedance.ee.bear.doc.resupdate;

import android.text.TextUtils;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.chameleon.container.webcontainer.util.CommonResUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f218001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f218002b;

    public final boolean a(VFSPath r100) {
        boolean r101 = false;
        if (FileUtils.H(r100) == false) goto L5;
        tt5.a.k(CommonResUtils.TAG, "checkResourceIsValid, filePath is empty");
        boolean r102 = false;
    L6:
        if (r102 == true) goto L11;
        StringBuilder r103 = new StringBuilder("filePath is null : ");
        if (r100 != null) goto L10;
        r101 = true;
    L10:
        r103.append(r101);
        c("file_not_exist", r103.toString());
    L11:
        return r102;
    L5:
        r102 = true;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    public final boolean b(VFSPath r110) {
        if (a(r110) == true) goto L5;
        return false;
    L5:
        HashMap r100 = new HashMap();
        VFSFile r111 = r110.toFile();
        VFSFile[] r101 = r111.listFiles();
        ?? r102 = 0;
        if (r101 != null) goto L8;
    L66:
        tt5.a.k("CheckResHelper", "checkMd5TableFile 11 verifyMd5ByReadFileList: not found .md5,file = " + r111);
        c("md5_not_exist", "md5_not_exist");
    L67:
        boolean r103 = false;
    L68:
        if (r103 == false) goto L120;
        tt5.a.b("CheckResHelper", "checkResourceIsValid md5 file is ready");
        Iterator r112 = r100.entrySet().iterator();
    L71:
        if (r112.hasNext() == false) goto L95;
        Map.Entry r104 = (Map.Entry) r112.next();
        String r105 = (String) r104.getKey();
        if (r105 != null) goto L75;
    L74:
        boolean r106 = true;
    L81:
        if (r106 == false) goto L83;
        VFSPath r107 = null;
    L84:
        if (r107 == null) goto L86;
        VFSFile r108 = r107.toFile();
    L87:
        if (r108 == null) goto L94;
        if (r108.exists() == false) goto L94;
        String r109 = (String) r104.getValue();
        String r113 = du5.b.j(r108.getVfsPath());
        if (TextUtils.equals(r109, r113) == true) goto L71;
        tt5.a.k("CheckResHelper", " checkFilesCompletion(): invalid file name = " + r108.getName() + ",right md5 = " + r109 + ",error md5 = " + r113);
        StringBuilder r114 = new StringBuilder();
        r114.append(r109);
        r114.append(",");
        r114.append(r113);
        c("file_damage", r114.toString());
        return false;
    L94:
        tt5.a.k("CheckResHelper", " checkFilesCompletion(): not found file on: = " + r105);
        c("file_not_exist", r105);
        return false;
    L86:
        r108 = null;
        goto L87
    L83:
        r107 = ay4.d.a().z(r105);
        goto L84
    L75:
        int r115 = r105.length();
        int r116 = 0;
    L76:
        if (r116 >= r115) goto L74;
        if (Character.isWhitespace(r105.charAt(r116)) == false) goto L79;
        r116 = r116 + 1;
        goto L76
    L79:
        r106 = false;
        goto L81
    L95:
        return true;
    L120:
        return false;
    L8:
        if (r111.length() == 0) goto L66;
        int r117 = r101.length;
        ?? r118 = 0;
    L12:
        if (r118 >= r117) goto L17;
        VFSFile r119 = r101[r118];
        if (r119.getName().endsWith(".md5") == true) goto L15;
        r118 = r118 + 1;
        goto L12
    L15:
        VFSPath r120 = r119.getVfsPath();
    L18:
        if (r120 != null) goto L20;
        tt5.a.k("CheckResHelper", "checkMd5TableFile 22 verifyMd5ByReadFileList: not found .md5");
        c("md5_not_exist", "md5_not_exist");
        goto L67
    L20:
        String r121 = r120.getName().substring(0, r120.getName().lastIndexOf(".md5"));
        r103 = TextUtils.equals(r121, du5.b.j(r120));
        if (r103 == false) goto L65;
        Map<String, String> r122 = FileUtils.f243139a;
        if (r120.toFile().exists() == true) goto L102;
    L45:
        ArrayList r123 = null;
    L46:
        if (r123 == null) goto L68;
        if (r123.size() == 0) goto L68;
        VFSPath r124 = r120.getParent();
        if (r124 != null) goto L53;
        tt5.a.h("CheckResHelper", "getMd5TableMap md5Table getParent == null");
        goto L68
    L53:
        String r125 = r124.getRealPath() + File.separator;
        Iterator r126 = r123.iterator();     // Catch: Exception -> L59
    L56:
        if (r126.hasNext() == false) goto L68;
        String[] r127 = ((String) r126.next()).trim().split(" ");     // Catch: Exception -> L59
        r100.put(r125 + r127[0], r127[1]);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        tt5.a.f("CheckResHelper", e, false);
        goto L68
    L102:
        r123 = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41
        BufferedReader r128 = new BufferedReader(new InputStreamReader(r120.toFile().newInputStream()));     // Catch: Throwable -> L39 IOException -> L41
        int r129 = 1;
    L100:
        String r130 = r128.readLine();     // Catch: IOException -> L37 Throwable -> L61
        if (r130 == null) goto L36;
        if (r129 > Integer.MAX_VALUE) goto L36;
        if (r129 < 0) goto L35;
        if (r129 > Integer.MAX_VALUE) goto L35;
        r123.add(r130);     // Catch: IOException -> L37 Throwable -> L61
    L35:
        r129 = r129 + 1;
    L36:
        FileUtils.d(r128);
    L37:
        e = e;
    L43:
        e.printStackTrace();     // Catch: Throwable -> L61
        FileUtils.d(r128);
        goto L45
    L41:
        e = e;
        r128 = null;
    L39:
        th = th;
    L63:
        FileUtils.d(r102);
        throw th;
    L61:
        th = th;
        r102 = r118;
        goto L63
    L65:
        tt5.a.k("CheckResHelper", "checkMd5TableFile: md5 file error: right=" + r121 + ",error=" + du5.b.j(r120));
        c("md5_damage", r121 + "," + du5.b.j(r120));
        goto L68
    L17:
        r120 = null;
        goto L18
    }

    public a(String r100, String r101) {
        this.f218001a = r100;
        this.f218002b = r101;
    }

    public final void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("scm_version", this.f218001a);     // Catch: JSONException -> L5
        r102.put("stage", "preload");     // Catch: JSONException -> L5
        r102.put("type", this.f218002b);     // Catch: JSONException -> L5
        r102.put("error_type", r100);     // Catch: JSONException -> L5
        r102.put("errorMsg", r101);     // Catch: JSONException -> L5
    L7:
        ((h) org.koin.java.a.a(h.class)).a("dev_performance_res_fail_cause", r102);
        return;
    L5:
        e = move-exception;
        tt5.a.e("CheckResHelper", "onTrackResFailReason failed", e, false);
        goto L7
    }
}
