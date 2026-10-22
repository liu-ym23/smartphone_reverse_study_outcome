package c85;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity;
import com.bytedance.ee.bear.drive.preload.DriveImCacheInfo;
import com.bytedance.ee.bear.drive.preload.n;
import com.bytedance.ee.util.io.FileUtils;
import com.google.gson.Gson;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSPath;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements f<DriveCache, f85.b> {
    public final OnlineOpenEntity a;
    public final n b;
    public final a95.a c;

    @Override // c85.f
    public final /* bridge */ /* synthetic */ Object a(String r1) {
        return null;
    }

    public final Object apply(Object r20) throws Exception {
        DriveCache r1 = (DriveCache) r20;
        OnlineOpenEntity r2 = this.a;
        a95.a r3 = this.c;
        f85.b r4 = new f85.b(new f85.b.a(r1.j, r1.a(r3.b), null, 0, "", r1.r, r2.getAppId(), r2.getFileId(), r2.getAuthExtra(), "", r2.getMountPoint(), null));
        r4.m = r1.getType();
        r4.f = r1.d;
        r4.f(true);
        DriveFilePath r5 = r1.b;
        UserSession r6 = r3.b;
        if (z75.b.d(r5, r6) == false) goto L5;
        r4.k = r5;
    L6:
        DriveFilePath r7 = r1.c;
        if (z75.b.d(r7, r6) == false) goto L9;
        r4.l = r7;
    L9:
        r4.r = r1.q;
        r4.h = r1.m;
        r4.v = r1.f;
        r4.w = r1.g;
        r4.g(r1.s);
        return r4;
    L5:
        tt5.a.k("DriveCacheManager", "convertToSdkFileModel() file not exists");
        goto L6
    }

    @Override // c85.f
    @Nullable
    public final LinkedHashMap<String, String> b(String r5) {
        n r0 = this.b;
        r0.getClass();
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.drive.mobile.video_little_rate") == true) goto L5;
    L4:
        DriveImCacheInfo r6 = null;
    L19:
        if (r6 != null) goto L21;
        return null;
    L21:
        return r6.getPreviewUrls();
    L5:
        VFSPath r7 = r0.a(r5);
        if (r7 != null) goto L8;
    L18:
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo PreviewUrlResult is null");
        goto L4
    L8:
        if (r7.toFile().exists() == false) goto L18;
        byte[] r8 = FileUtils.o(r7);
        if (r8 != null) goto L23;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo resultBytes is null");
        goto L4
    L23:
        r6 = (DriveImCacheInfo) new Gson().fromJson(new String(r8), DriveImCacheInfo.class);     // Catch: Throwable -> L17
        if (r6 != null) goto L19;
        tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo parse result is null");     // Catch: Throwable -> L17
    L17:
        tt5.a.d("VideoCacheInfoManager", "getImVideoCacheInfo error");
        goto L4
    }

    public g(OnlineOpenEntity r1, a95.a r2) {
        this.a = r1;
        this.c = r2;
        this.b = new n(r2);
    }
}
