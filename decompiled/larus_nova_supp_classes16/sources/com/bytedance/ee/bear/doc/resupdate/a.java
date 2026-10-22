package com.bytedance.ee.bear.doc.resupdate;

import android.text.TextUtils;
import com.bytedance.ee.util.io.FileUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public final String b;

    public final boolean a(VFSPath r6) {
        boolean r1 = false;
        if (FileUtils.H(r6) == false) goto L5;
        tt5.a.k("CommonResUtils", "checkResourceIsValid, filePath is empty");
        boolean r0 = false;
    L6:
        if (r0 == true) goto L11;
        StringBuilder r3 = new StringBuilder("filePath is null : ");
        if (r6 != null) goto L10;
        r1 = true;
    L10:
        r3.append(r1);
        c("file_not_exist", r3.toString());
    L11:
        return r0;
    L5:
        r0 = true;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    public final boolean b(VFSPath r14) {
        if (a(r14) == true) goto L5;
        return false;
    L5:
        HashMap r0 = new HashMap();
        VFSFile r16 = r14.toFile();
        File[] r2 = r16.listFiles();
        ?? r5 = 0;
        if (r2 != null) goto L8;
    L66:
        tt5.a.k("CheckResHelper", "checkMd5TableFile 11 verifyMd5ByReadFileList: not found .md5,file = " + r16);
        c("md5_not_exist", "md5_not_exist");
    L67:
        boolean r7 = false;
    L68:
        if (r7 == false) goto L120;
        tt5.a.b("CheckResHelper", "checkResourceIsValid md5 file is ready");
        Iterator r17 = r0.entrySet().iterator();
    L71:
        if (r17.hasNext() == false) goto L95;
        Map.Entry r1 = (Map.Entry) r17.next();
        String r3 = (String) r1.getKey();
        if (r3 != null) goto L75;
    L74:
        boolean r8 = true;
    L81:
        if (r8 == false) goto L83;
        VFSPath r9 = null;
    L84:
        if (r9 == null) goto L86;
        VFSFile r10 = r9.toFile();
    L87:
        if (r10 == null) goto L94;
        if (r10.exists() == false) goto L94;
        String r4 = (String) r1.getValue();
        String r6 = du5.b.j(r10.getVfsPath());
        if (TextUtils.equals(r4, r6) == true) goto L71;
        tt5.a.k("CheckResHelper", " checkFilesCompletion(): invalid file name = " + r10.getName() + ",right md5 = " + r4 + ",error md5 = " + r6);
        StringBuilder r18 = new StringBuilder();
        r18.append(r4);
        r18.append(",");
        r18.append(r6);
        c("file_damage", r18.toString());
        return false;
    L94:
        tt5.a.k("CheckResHelper", " checkFilesCompletion(): not found file on: = " + r3);
        c("file_not_exist", r3);
        return false;
    L86:
        r10 = null;
        goto L87
    L83:
        r9 = ay4.d.a().z(r3);
        goto L84
    L75:
        int r11 = r3.length();
        int r12 = 0;
    L76:
        if (r12 >= r11) goto L74;
        if (Character.isWhitespace(r3.charAt(r12)) == false) goto L79;
        r12 = r12 + 1;
        goto L76
    L79:
        r8 = false;
        goto L81
    L95:
        return true;
    L120:
        return false;
    L8:
        if (r16.length() == 0) goto L66;
        int r19 = r2.length;
        ?? r13 = 0;
    L12:
        if (r13 >= r19) goto L17;
        File r110 = r2[r13];
        if (r110.getName().endsWith(".md5") == true) goto L15;
        r13 = r13 + 1;
        goto L12
    L15:
        VFSPath r111 = r110.getVfsPath();
    L18:
        if (r111 != null) goto L20;
        tt5.a.k("CheckResHelper", "checkMd5TableFile 22 verifyMd5ByReadFileList: not found .md5");
        c("md5_not_exist", "md5_not_exist");
        goto L67
    L20:
        String r20 = r111.getName().substring(0, r111.getName().lastIndexOf(".md5"));
        r7 = TextUtils.equals(r20, du5.b.j(r111));
        if (r7 == false) goto L65;
        Map r21 = FileUtils.a;
        if (r111.toFile().exists() == true) goto L102;
    L45:
        ArrayList r22 = null;
    L46:
        if (r22 == null) goto L68;
        if (r22.size() == 0) goto L68;
        VFSPath r112 = r111.getParent();
        if (r112 != null) goto L53;
        tt5.a.h("CheckResHelper", "getMd5TableMap md5Table getParent == null");
        goto L68
    L53:
        String r113 = r112.getRealPath() + File.separator;
        Iterator r23 = r22.iterator();     // Catch: Exception -> L59
    L56:
        if (r23.hasNext() == false) goto L68;
        String[] r24 = ((String) r23.next()).trim().split(" ");     // Catch: Exception -> L59
        r0.put(r113 + r24[0], r24[1]);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        tt5.a.f("CheckResHelper", e, false);
        goto L68
    L102:
        r22 = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41
        BufferedReader r26 = new BufferedReader(new InputStreamReader(r111.toFile().newInputStream()));     // Catch: Throwable -> L39 IOException -> L41
        int r27 = 1;
    L100:
        String r114 = r26.readLine();     // Catch: IOException -> L37 Throwable -> L61
        if (r114 == null) goto L36;
        if (r27 > Integer.MAX_VALUE) goto L36;
        if (r27 < 0) goto L35;
        if (r27 > Integer.MAX_VALUE) goto L35;
        r22.add(r114);     // Catch: IOException -> L37 Throwable -> L61
    L35:
        r27 = r27 + 1;
    L36:
        FileUtils.d(r26);
    L37:
        e = e;
    L43:
        e.printStackTrace();     // Catch: Throwable -> L61
        FileUtils.d(r26);
        goto L45
    L41:
        e = e;
        r26 = null;
    L39:
        th = th;
    L63:
        FileUtils.d(r5);
        throw th;
    L61:
        th = th;
        r5 = r13;
        goto L63
    L65:
        tt5.a.k("CheckResHelper", "checkMd5TableFile: md5 file error: right=" + r20 + ",error=" + du5.b.j(r111));
        c("md5_damage", r20 + "," + du5.b.j(r111));
        goto L68
    L17:
        r111 = null;
        goto L18
    }

    public a(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void c(String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("scm_version", this.a);     // Catch: JSONException -> L5
        r0.put("stage", "preload");     // Catch: JSONException -> L5
        r0.put("type", this.b);     // Catch: JSONException -> L5
        r0.put("error_type", r4);     // Catch: JSONException -> L5
        r0.put("errorMsg", r5);     // Catch: JSONException -> L5
    L7:
        ((h) org.koin.java.a.a(h.class)).a("dev_performance_res_fail_cause", r0);
        return;
    L5:
        e = move-exception;
        tt5.a.e("CheckResHelper", "onTrackResFailReason failed", e, false);
        goto L7
    }
}
