package com.bytedance.ee.bear.drive.preload;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.util.io.FileUtils;
import com.google.gson.Gson;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public final a95.a a;

    public n(a95.a r2) {
        Application r0 = eu5.b.a;
        this.a = r2;
        r.b(r2);
    }

    public static String b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(du5.d.a(r2)) == false) goto L8;
        String r3 = null;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return null;
    L13:
        return r3.concat(".json");
    L8:
        r3 = du5.d.a(r2);
        goto L10
    }

    public final VFSPath a(String r4) {
        DriveFilePath r0 = t.g();
        VFSFile r1 = z75.b.f(r0, this.a.b);
        if (r1.exists() == true) goto L5;
        r1.mkdirs();
    L5:
        String r5 = b(r4);
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r0.cacheName(r5);
        return z75.b.b(r0, this.a.b);
    L9:
        return null;
    }

    public static String c(String r1, String r2) {
        if (TextUtils.isEmpty(du5.d.a(r1)) == false) goto L7;
        return null;
    L7:
        return du5.d.a(r1).concat(OfflineDoc.DASH_DELIMITER).concat(r2);
    }

    public final VideoCacheInfo d(String r6, String r7) {
        VFSPath r0 = a(r6);
        if (r0 != null) goto L5;
    L23:
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo PreviewUrlResult is null");
        return null;
    L5:
        if (r0.toFile().exists() == false) goto L23;
        byte[] r1 = FileUtils.o(r0);
        if (r1 != null) goto L11;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo resultBytes is null");
        return null;
    L11:
        DriveCacheInfo r2 = (DriveCacheInfo) JSON.parseObject(r1, DriveCacheInfo.class, new Feature[0]);
        if (r2 != null) goto L16;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo parse result is null");
        return null;
    L16:
        if (TextUtils.isEmpty(r7) == true) goto L22;
        if (TextUtils.equals(r7, r2.getDataVersion()) == true) goto L22;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo dataVersion changed");
        return null;
    L22:
        return new VideoCacheInfo(TTVideoEngine.getCacheInfo(c(r6, r2.getDataVersion())), r2);
    }

    public final void e(f85.a r3, String r4) {
        if (hu5.a.e(r3.g) == true) goto L5;
    L7:
        VFSPath r5 = a(r4);
        if (r5 != null) goto L10;
        tt5.a.h("VideoCacheInfoManager", "driveCacheInfoFile is null");
        return;
    L10:
        if (FileUtils.a(JSON.toJSONString(new DriveCacheInfo(r3)).getBytes(), r5) == false) goto L14;
        tt5.a.h("VideoCacheInfoManager", "result info byteToFile success");
        return;
    L14:
        return;
    L5:
        if (TextUtils.isEmpty(r3.i) == false) goto L7;
    }

    public final void f(f85.b r4, String r5) {
        if (hu5.a.e(r4.g) == true) goto L5;
    L7:
        VFSPath r6 = a(r5);
        if (r6 != null) goto L16;
        tt5.a.h("VideoCacheInfoManager", "driveCacheInfoFile is null");
        return;
    L16:
    L13:
        tt5.a.d("VideoCacheInfoManager", "saveDriveCacheInfo error");
        return;
    L10:
        if (FileUtils.a(new Gson().toJson(new DriveImCacheInfo(r4), DriveImCacheInfo.class).getBytes(), r6) == false) goto L18;
        tt5.a.h("VideoCacheInfoManager", "result info byteToFile success");     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r4.i) == false) goto L7;
    }
}
