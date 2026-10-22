package ez5;

import android.os.Build;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f474884a = 0;

    static {
    }

    public static void a(PolarisFileWrapper r100) throws Throwable {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        boolean r101 = true;
        if ((!Intrinsics.areEqual(r100.getName(), "template.js")) == false) goto L11;
        if ((!Intrinsics.areEqual(r100.getName(), "template.js.gkfsf")) == false) goto L11;
        return;
    L11:
        if (r100.length() < 4) goto L31;
        byte[] r102 = new byte[4];
        GkFSFileInputStream r103 = new GkFSFileInputStream(r100, false);
        r103.read(r102);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r103, null);
        int r104 = 0;
    L16:
        if (r104 > 3) goto L21;
        if (r102[r104] != 0) goto L19;
        r104 = r104 + 1;
        goto L16
    L19:
        r101 = false;
    L21:
        if (r101 == true) goto L24;
        return;
    L24:
        throw new RuntimeException("file start with 4 zero: " + r100.getName());
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L31:
        throw new RuntimeException("file size less than 4: " + r100.getName());
    }

    public static void b(File r100) throws Exception {
        if (r100.exists() == false) goto L10;
        if (r100.isFile() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("create dir failed: path is a file");
    L10:
        if (r100.mkdirs() == false) goto L13;
        return;
    L13:
        throw new RuntimeException("create dir failed: " + r100.getPath());
    }

    public static boolean c(File r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.exists() == true) goto L8;
        return true;
    L8:
        if (r100.isDirectory() == false) goto L20;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L20;
        int r102 = r101.length;
        int r103 = 0;
        boolean r104 = true;
    L12:
        if (r103 >= r102) goto L21;
        File r105 = r101[r103];
        if (r104 == true) goto L16;
    L18:
        r104 = false;
    L19:
        r103 = r103 + 1;
        goto L12
    L16:
        if (c(r105) == false) goto L18;
        r104 = true;
    L21:
        if (r104 == true) goto L23;
    L25:
        return false;
    L23:
        if (r100.delete() == false) goto L25;
        return true;
    L20:
        r104 = true;
        goto L21
    }

    public static long d(File r100) {
        long r101 = 0;
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return 0;
    L6:
        if (r100.isFile() == true) goto L8;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L14;
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r101 = r101 + d(r102[r104]);
        r104 = r104 + 1;
    L14:
        return r101;
    L8:
        return r100.length();
    }

    @JvmStatic
    public static final boolean delete(File r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.exists() == false) goto L20;
        if (GkFSUtils.f() == false) goto L10;
        boolean r101 = GeckoFileSystem.f245106f.delete(r100);     // Catch: Throwable -> L17
    L11:
        if (r101 == false) goto L12;
    L13:
        GeckoLogger.d("delete file: " + r101 + ", " + r100.getAbsolutePath());
        return r101;
    L10:
        r101 = false;
    L12:
        r101 = c(r100);
        goto L13
    L20:
        return true;
    }

    public static void e(String r100, String r101, PolarisFileWrapper r102, String r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L4
        Object r105 = Result.m9449constructorimpl(MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(r102));     // Catch: Throwable -> L4
    L6:
        Long r106 = null;
        if (Result.m9455isFailureimpl(r105) == false) goto L9;
        r105 = null;
    L9:
        String r107 = "path: " + r103 + ", length: " + r102.length() + ", md5: " + ((String) r105);
        ChannelMeta r108 = com.bytedance.iesgurd.meta.a.c(r100, r101);
        if (r108 == null) goto L12;
        r106 = r108.getUpdateTime();
    L12:
        long r109 = r102.lastModified();
        if (r106 != null) goto L15;
    L17:
        boolean r110 = false;
    L18:
        String r111 = "updateTime: " + r106 + ", lastModified: " + r109 + ", isModified: " + r110;
        EventSubType r112 = EventSubType.FILE_BROKEN;
        JSONObject r113 = new JSONObject();
        r113.put("sub_type", r112.getType());
        if (r100 == null) goto L21;
        r113.put("access_key", r100);
    L21:
        if (r101 == null) goto L23;
        r113.put("channels", r101);
    L23:
        if (r111 == null) goto L25;
        r113.put(LocationMonitorConst.ERR_MSG, r111);
    L25:
        if (r107 == null) goto L27;
        r113.put("extra", r107);
    L27:
        y86.a.c("geckosdk_event_message", r113);
        return;
    L15:
        if (r106.longValue() >= r109) goto L17;
        r110 = true;
    L4:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
