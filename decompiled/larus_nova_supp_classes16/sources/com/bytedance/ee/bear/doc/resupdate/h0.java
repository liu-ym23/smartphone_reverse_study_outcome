package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h0 {
    public final String a;
    public g0 b;

    public static class a {
        public static final h0 a = null;

        static {
            a = new h0();
        }
    }

    public h0() {
        this.a = h0.class.getSimpleName();
    }

    public static VFSFile b(Context r6) {
        com.ss.android.lark.vfs.h r0 = ay4.d.a();
        Biz r1 = Biz.DYNAMIC;
        int r2 = ay4.c.a;
        VFSFile r7 = r0.v(ay4.c.a.f(r1, "simAsset", true, false, 8).getRealPath(), ApkUtil.getAppVersionName(r6) + "-eesz.7z");
        if (r7.getParentFile().exists() == true) goto L5;
        r7.getParentFile().mkdirs();
    L5:
        return r7;
    }

    public final g0 c(Context r13) {
        String r3 = ThreadMethodProxy.currentThread().getName();
        File r4 = b(r13);
        if (r4.exists() == true) goto L5;
        tt5.a.h(this.a, "getSimRevision: local eesz asset not exist,begin copy thread:" + r3);
        monitor-enter(h0.class);
    L34:
        th = move-exception;
        throw th;
    L12:
        if (r4.exists() == true) goto L14;
        com.ss.android.lark.vfs.h r6 = ay4.d.a();     // Catch: Throwable -> L34
        Biz r7 = Biz.DYNAMIC;     // Catch: Throwable -> L34
        int r8 = ay4.c.a;     // Catch: Throwable -> L34
        VFSFile r9 = r6.v(ay4.c.a.f(r7, "simAsset", true, false, 8).getRealPath(), System.currentTimeMillis() + "eesz.7z");     // Catch: Throwable -> L34
        tt5.a.h(this.a, "getSimRevision: clean directory thread:" + r3);     // Catch: IOException -> L22 Throwable -> L34
        FileUtils.c(r9.getVfsPath().getParent());     // Catch: IOException -> L22 Throwable -> L34
    L25:
        if (FileUtils.f(r13, "eesz.7z", r9.getAbsolutePath()) == true) goto L27;
    L31:
        r9.deleteOnExit();     // Catch: Throwable -> L34
        tt5.a.h(this.a, "getSimRevision: asset copy to local fails thread:" + r3);     // Catch: Throwable -> L34
        g0 r14 = new g0();     // Catch: Throwable -> L34
        monitor-exit(h0.class);     // Catch: Throwable -> L34
        return r14;
    L27:
        if (r9.exists() == false) goto L31;
        r9.renameTo(r4);     // Catch: Throwable -> L34
        tt5.a.h(this.a, "getSimRevision: renameto :" + r4.getAbsolutePath() + " thread:" + r3);     // Catch: Throwable -> L34
        g0 r16 = d0.h(r4.getAbsolutePath());     // Catch: Throwable -> L34
        this.b = r16;     // Catch: Throwable -> L34
        monitor-exit(h0.class);     // Catch: Throwable -> L34
        return r16;
    L22:
        e = move-exception;
        tt5.a.d(this.a, r3 + " => getSimRevision: clean directory fails : " + e);     // Catch: Throwable -> L34
        goto L25
    L14:
        if (this.b != null) goto L16;
        this.b = d0.h(r4.getAbsolutePath());     // Catch: Throwable -> L34
    L16:
        g0 r17 = this.b;     // Catch: Throwable -> L34
        monitor-exit(h0.class);     // Catch: Throwable -> L34
        return r17;
    L5:
        if (this.b != null) goto L8;
        this.b = d0.h(r4.getAbsolutePath());
    L8:
        return this.b;
    }

    public final boolean a(Context r16, VFSFile r17, String r18) {
        long r2 = System.currentTimeMillis();
        tt5.a.h(this.a, "extractSimAssetToLocal: begin extract sim eesz");
        int r5 = -1;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.7z_upgrade") == false) goto L44;
        String r7 = b(r16).getAbsolutePath();
        String r8 = r17.getAbsolutePath();
        String r0 = com.bytedance.ee.util.io.d.a;
        if (TextUtils.isEmpty(r7) == false) goto L7;
    L43:
        int r9 = -1;
    L63:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L51
        if (r9 != 0) goto L49;
        r5 = 0;
    L49:
        r1.put(TipCallBackData.RESULT, r5);     // Catch: Exception -> L51
        r1.put("error_des", r9);     // Catch: Exception -> L51
        r1.put("channel", r18);     // Catch: Exception -> L51
        r1.put("package_version", this.b.b);     // Catch: Exception -> L51
        r1.put("localPath", r17.getAbsolutePath());     // Catch: Exception -> L51
        r1.put("during", System.currentTimeMillis() - r2);     // Catch: Exception -> L51
        r1.put("is_emulator", ku5.c.j());     // Catch: Exception -> L51
        ((h) org.koin.java.a.a(h.class)).a("ccm_extract_eesz_asset_result_dev", r1);     // Catch: Exception -> L51
    L53:
        if (r9 == 0) goto L65;
        return false;
    L65:
        return true;
    L51:
        e = move-exception;
        tt5.a.d(this.a, "extractSimAssetToLocal : extract result report fails:  " + e);
        goto L53
    L7:
        if (TextUtils.isEmpty(r8) == true) goto L43;
    L15:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        String r12 = com.bytedance.ee.util.io.d.a;
        tt5.a.d(r12, "extractAll fails : " + e + "  message:" + r11);
        if (r11.contains("Can't stat existing object") == false) goto L43;
        if (r11.contains("errno=2") == false) goto L43;
        tt5.a.h(r12, "extractAll fails, retry");
        FileUtils.m(ay4.d.a().i(r8).getVfsPath());     // Catch: IOException -> L26
        boolean r3 = true;
    L28:
        if (r3 == false) goto L43;
        if (ay4.d.a().i(r8).mkdirs() == false) goto L43;
        if (TextUtils.isEmpty(r7) == true) goto L43;
        if (TextUtils.isEmpty(r8) == true) goto L43;
    L41:
        e = move-exception;
        tt5.a.d(r12, "extract7zWithDeepDirThreshold fails : " + e + "  message:" + e.getMessage());
        goto L43
    L37:
        if (r8.endsWith("/") == true) goto L39;
        r8 = r8 + File.separator;     // Catch: IOException -> L41
    L39:
        int r4 = Archive.extractAll(r7, r8, null, 200);     // Catch: IOException -> L41
    L45:
        r9 = r4;
    L26:
        e = move-exception;
        tt5.a.d(r12, "deleteFile fails : " + e + "  message:" + e.getMessage());
        r3 = false;
        goto L28
    L11:
        if (r8.endsWith("/") == true) goto L13;
        r8 = r8 + File.separator;     // Catch: IOException -> L15
    L13:
        r4 = Archive.extractAll(r7, r8, null, 0);     // Catch: IOException -> L15
        goto L45
    L44:
        r4 = com.bytedance.ee.util.io.d.a(b(r16).getAbsolutePath(), r17.getAbsolutePath());
        goto L45
    }
}
