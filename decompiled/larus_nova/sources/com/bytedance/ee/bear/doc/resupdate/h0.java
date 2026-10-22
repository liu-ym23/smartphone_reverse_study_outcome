package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f218016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f218017b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f218018a = null;

        static {
            f218018a = new h0();
        }
    }

    public h0() {
        this.f218016a = h0.class.getSimpleName();
    }

    public static VFSFile b(Context r100) {
        com.ss.android.lark.vfs.h r101 = ay4.d.a();
        Biz r102 = Biz.DYNAMIC;
        int r103 = ay4.c.f16749a;
        VFSFile r104 = r101.v(ay4.c.a.f(r102, "simAsset", true, false, 8).getRealPath(), ApkUtil.getAppVersionName(r100) + "-eesz.7z");
        if (r104.getParentFile().exists() == true) goto L5;
        r104.getParentFile().mkdirs();
    L5:
        return r104;
    }

    public final g0 c(Context r110) {
        String r100 = ThreadMethodProxy.currentThread().getName();
        VFSFile r101 = b(r110);
        if (r101.exists() == true) goto L5;
        tt5.a.h(this.f218016a, "getSimRevision: local eesz asset not exist,begin copy thread:" + r100);
        monitor-enter(h0.class);
    L34:
        th = move-exception;
        throw th;
    L12:
        if (r101.exists() == true) goto L14;
        com.ss.android.lark.vfs.h r102 = ay4.d.a();     // Catch: Throwable -> L34
        Biz r103 = Biz.DYNAMIC;     // Catch: Throwable -> L34
        int r104 = ay4.c.f16749a;     // Catch: Throwable -> L34
        VFSFile r105 = r102.v(ay4.c.a.f(r103, "simAsset", true, false, 8).getRealPath(), System.currentTimeMillis() + "eesz.7z");     // Catch: Throwable -> L34
        tt5.a.h(this.f218016a, "getSimRevision: clean directory thread:" + r100);     // Catch: IOException -> L22 Throwable -> L34
        FileUtils.c(r105.getVfsPath().getParent());     // Catch: IOException -> L22 Throwable -> L34
    L25:
        if (FileUtils.f(r110, "eesz.7z", r105.getAbsolutePath()) == true) goto L27;
    L31:
        r105.deleteOnExit();     // Catch: Throwable -> L34
        tt5.a.h(this.f218016a, "getSimRevision: asset copy to local fails thread:" + r100);     // Catch: Throwable -> L34
        g0 r111 = new g0();     // Catch: Throwable -> L34
        monitor-exit(h0.class);     // Catch: Throwable -> L34
        return r111;
    L27:
        if (r105.exists() == false) goto L31;
        r105.renameTo(r101);     // Catch: Throwable -> L34
        tt5.a.h(this.f218016a, "getSimRevision: renameto :" + r101.getAbsolutePath() + " thread:" + r100);     // Catch: Throwable -> L34
        g0 r112 = d0.h(r101.getAbsolutePath());     // Catch: Throwable -> L34
        this.f218017b = r112;     // Catch: Throwable -> L34
        monitor-exit(h0.class);     // Catch: Throwable -> L34
        return r112;
    L22:
        e = move-exception;
        tt5.a.d(this.f218016a, r100 + " => getSimRevision: clean directory fails : " + e);     // Catch: Throwable -> L34
        goto L25
    L14:
        if (this.f218017b != null) goto L16;
        this.f218017b = d0.h(r101.getAbsolutePath());     // Catch: Throwable -> L34
    L16:
        g0 r113 = this.f218017b;     // Catch: Throwable -> L34
        monitor-exit(h0.class);     // Catch: Throwable -> L34
        return r113;
    L5:
        if (this.f218017b != null) goto L8;
        this.f218017b = d0.h(r101.getAbsolutePath());
    L8:
        return this.f218017b;
    }

    public final boolean a(Context r110, VFSFile r111, String r112) {
        long r100 = System.currentTimeMillis();
        tt5.a.h(this.f218016a, "extractSimAssetToLocal: begin extract sim eesz");
        int r101 = -1;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.7z_upgrade") == false) goto L44;
        String r102 = b(r110).getAbsolutePath();
        String r103 = r111.getAbsolutePath();
        String r104 = com.bytedance.ee.util.io.d.f243145a;
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L43:
        int r105 = -1;
    L63:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L51
        if (r105 != 0) goto L49;
        r101 = 0;
    L49:
        r106.put("result", r101);     // Catch: Exception -> L51
        r106.put("error_des", r105);     // Catch: Exception -> L51
        r106.put("channel", r112);     // Catch: Exception -> L51
        r106.put("package_version", this.f218017b.f218011b);     // Catch: Exception -> L51
        r106.put("localPath", r111.getAbsolutePath());     // Catch: Exception -> L51
        r106.put("during", System.currentTimeMillis() - r100);     // Catch: Exception -> L51
        r106.put("is_emulator", ku5.c.j());     // Catch: Exception -> L51
        ((h) org.koin.java.a.a(h.class)).a("ccm_extract_eesz_asset_result_dev", r106);     // Catch: Exception -> L51
    L53:
        if (r105 == 0) goto L65;
        return false;
    L65:
        return true;
    L51:
        e = move-exception;
        tt5.a.d(this.f218016a, "extractSimAssetToLocal : extract result report fails:  " + e);
        goto L53
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L43;
    L15:
        e = move-exception;
        String r113 = e.getMessage();
        if (r113 != null) goto L19;
        r113 = "";
    L19:
        String r114 = com.bytedance.ee.util.io.d.f243145a;
        tt5.a.d(r114, "extractAll fails : " + e + "  message:" + r113);
        if (r113.contains("Can't stat existing object") == false) goto L43;
        if (r113.contains("errno=2") == false) goto L43;
        tt5.a.h(r114, "extractAll fails, retry");
        FileUtils.m(ay4.d.a().i(r103).getVfsPath());     // Catch: IOException -> L26
        boolean r107 = true;
    L28:
        if (r107 == false) goto L43;
        if (ay4.d.a().i(r103).mkdirs() == false) goto L43;
        if (TextUtils.isEmpty(r102) == true) goto L43;
        if (TextUtils.isEmpty(r103) == true) goto L43;
    L41:
        e = move-exception;
        tt5.a.d(r114, "extract7zWithDeepDirThreshold fails : " + e + "  message:" + e.getMessage());
        goto L43
    L37:
        if (r103.endsWith(HTTP.URL_DEFAULT) == true) goto L39;
        r103 = r103 + File.separator;     // Catch: IOException -> L41
    L39:
        int r108 = Archive.extractAll(r102, r103, null, 200);     // Catch: IOException -> L41
    L45:
        r105 = r108;
    L26:
        e = move-exception;
        tt5.a.d(r114, "deleteFile fails : " + e + "  message:" + e.getMessage());
        r107 = false;
        goto L28
    L11:
        if (r103.endsWith(HTTP.URL_DEFAULT) == true) goto L13;
        r103 = r103 + File.separator;     // Catch: IOException -> L15
    L13:
        r108 = Archive.extractAll(r102, r103, null, 0);     // Catch: IOException -> L15
        goto L45
    L44:
        r108 = com.bytedance.ee.util.io.d.a(b(r110).getAbsolutePath(), r111.getAbsolutePath());
        goto L45
    }
}
