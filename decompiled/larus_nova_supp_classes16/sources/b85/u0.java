package b85;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.DownStrategy;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.download.platform.PlatformDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.ApiDriveExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u0 {
    public final long a;
    public final IFileDownloadDependency b;
    public final IApiPuller<FileInfoV1Puller.Params, f85.a> c;
    public final IDownloader d;
    public final CompositeDisposable e;
    public final Set<String> f;
    public final a95.a g;

    public u0(IFileDownloadDependency r4, a95.a r5) {
        this.e = new CompositeDisposable();
        this.f = new HashSet();
        this.g = r5;
        this.b = r4;
        this.c = FileInfoPuller.V1((NetService) org.koin.java.a.a(NetService.class));
        this.d = PlatformDownloader.create(new ApiDriveExecutor(r4.getAppId(), r5), new DownStrategy(r4.getPreviewStrategy()), new c85.b(r4.getPreviewStrategy(), r5), r5);
        this.a = o75.b.a().getDriveConfig().a().getDownload_origin_file_max_size() * 1024;
    }

    public static void a(Throwable r3, u75.b.a r4) {
        if ((r3 instanceof DriveException) == false) goto L9;
        tt5.a.d("DRIVE_PREVIEW_FLOW_SourceExecutor", "handle download Err, errCode: " + ((DriveException) r3).getErrorCode());
        r4.c(((DriveException) r3).getErrorCode());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e("DRIVE_PREVIEW_FLOW_SourceExecutor", "handleErr() DriveException error", e, false);
        r4.c(ErrCode.DEFAULT);
        return;
    L9:
        tt5.a.d("DRIVE_PREVIEW_FLOW_SourceExecutor", "handleErr() no DriveException");
        r4.c(ErrCode.DEFAULT);
    }
}
