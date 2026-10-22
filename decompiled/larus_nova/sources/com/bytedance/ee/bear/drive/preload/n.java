package com.bytedance.ee.bear.drive.preload;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.util.io.FileUtils;
import com.google.gson.Gson;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a95.a f224552a;

    public n(a95.a r100) {
        Application r101 = eu5.b.f474075a;
        this.f224552a = r100;
        r.b(r100);
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(du5.d.a(r100)) == false) goto L8;
        String r101 = null;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return null;
    L13:
        return r101.concat(InvRouter.FLOW_SUFFIX);
    L8:
        r101 = du5.d.a(r100);
        goto L10
    }

    public final VFSPath a(String r100) {
        DriveFilePath r101 = t.g();
        VFSFile r102 = z75.b.f(r101, this.f224552a.f2278b);
        if (r102.exists() == true) goto L5;
        r102.mkdirs();
    L5:
        String r103 = b(r100);
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r101.cacheName(r103);
        return z75.b.b(r101, this.f224552a.f2278b);
    L9:
        return null;
    }

    public static String c(String r100, String r101) {
        if (TextUtils.isEmpty(du5.d.a(r100)) == false) goto L7;
        return null;
    L7:
        return du5.d.a(r100).concat("_").concat(r101);
    }

    public final VideoCacheInfo d(String r100, String r101) {
        VFSPath r102 = a(r100);
        if (r102 != null) goto L5;
    L23:
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo PreviewUrlResult is null");
        return null;
    L5:
        if (r102.toFile().exists() == false) goto L23;
        byte[] r103 = FileUtils.o(r102);
        if (r103 != null) goto L11;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo resultBytes is null");
        return null;
    L11:
        DriveCacheInfo r104 = (DriveCacheInfo) JSON.parseObject(r103, DriveCacheInfo.class, new Feature[0]);
        if (r104 != null) goto L16;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo parse result is null");
        return null;
    L16:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if (TextUtils.equals(r101, r104.getDataVersion()) == true) goto L22;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo dataVersion changed");
        return null;
    L22:
        return new VideoCacheInfo(TTVideoEngine.getCacheInfo(c(r100, r104.getDataVersion())), r104);
    }

    public final void e(f85.a r100, String r101) {
        if (hu5.a.e(r100.f558538g) == true) goto L5;
    L7:
        VFSPath r102 = a(r101);
        if (r102 != null) goto L10;
        tt5.a.h("VideoCacheInfoManager", "driveCacheInfoFile is null");
        return;
    L10:
        if (FileUtils.a(JSON.toJSONString(new DriveCacheInfo(r100)).getBytes(), r102) == false) goto L14;
        tt5.a.h("VideoCacheInfoManager", "result info byteToFile success");
        return;
    L14:
        return;
    L5:
        if (TextUtils.isEmpty(r100.f558540i) == false) goto L7;
    }

    public final void f(f85.b r100, String r101) {
        if (hu5.a.e(r100.f558538g) == true) goto L5;
    L7:
        VFSPath r102 = a(r101);
        if (r102 != null) goto L16;
        tt5.a.h("VideoCacheInfoManager", "driveCacheInfoFile is null");
        return;
    L16:
    L13:
        tt5.a.d("VideoCacheInfoManager", "saveDriveCacheInfo error");
        return;
    L10:
        if (FileUtils.a(new Gson().toJson(new DriveImCacheInfo(r100), DriveImCacheInfo.class).getBytes(), r102) == false) goto L18;
        tt5.a.h("VideoCacheInfoManager", "result info byteToFile success");     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r100.f558540i) == false) goto L7;
    }
}
