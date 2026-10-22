package yk6;

import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {
    public b() {
    }

    public static void b(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i("AndroidDownloader", ArraysKt.joinToString$default(r110, "===", null, null, 0, null, null, 62, null));
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadId");
        Intrinsics.checkNotNullParameter(r101, "localPath");
        Downloader.getInstance(s1.getContext()).cancel(CastIntegerProtector.parseInt(r100));
    }

    public final String c(String r110, com.bytedance.livesdk.ktvcommon.download.model.f r111, com.bytedance.livesdk.ktvcommon.download.e r112) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "param");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r111.f255982i;
        if (KtvUtilsKt.l(r100) == false) goto L6;
        b(new String[]{"startDownload: taskId=" + r110 + ", resourceType=" + r111.f255976c + ", filePath=" + r100 + ", file exists"});
        r112.b(r110, 100);
        r112.a(r110, DownloadState.SUCCESS, new com.bytedance.livesdk.ktvcommon.download.model.d(r110, r111.f255975b, r111.f255976c, r111.f255977d, r100, 0, ""));
        return HttpClient.ENDFLAG;
    L6:
        DownloadTask r101 = Downloader.with(s1.getContext()).url(r111.f255977d).name(r111.f255979f).savePath(r111.f255978e).monitorScene(r111.f255980g).setCacheLifeTimeMax(1209600).autoRemoveCallback(true);
        r101.subThreadListener(new a(this, r110, r112, r111)).download();
        return String.valueOf(r101.getDownloadId());
    }
}
