package yk6;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f568221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f568222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.livesdk.ktvcommon.download.api.g f568223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.livesdk.ktvcommon.download.model.f f568224d;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        super.onProgress(r100);
        if (r100 == null) goto L6;
        float r101 = (r100.getCurBytes() / r100.getTotalBytes()) * 100;
        b r102 = this.f568221a;
        String[] r103 = {"onProgress: taskId=" + this.f568222b + ", progress=" + r101};
        r102.getClass();
        b.b(r103);
        this.f568223c.b(this.f568222b, (int) r101);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r110) {
        super.onSuccessed(r110);
        b r100 = this.f568221a;
        String[] r101 = new String[1];
        StringBuilder r102 = new StringBuilder("onSuccessed: taskId=");
        r102.append(this.f568222b);
        r102.append(", filePath=");
        if (r110 == null) goto L5;
        String r103 = r110.getTargetFilePath();
    L6:
        r102.append(r103);
        r101[0] = r102.toString();
        r100.getClass();
        b.b(r101);
        com.bytedance.livesdk.ktvcommon.download.api.g r104 = this.f568223c;
        String r105 = this.f568222b;
        DownloadState r111 = DownloadState.SUCCESS;
        com.bytedance.livesdk.ktvcommon.download.model.f r106 = this.f568224d;
        String r107 = r106.f255975b;
        MusicType r108 = r106.f255976c;
        String r109 = r106.f255977d;
        if (r110 == null) goto L10;
        String r112 = r110.getTargetFilePath();
        if (r112 == null) goto L10;
    L11:
        r104.a(r105, r111, new com.bytedance.livesdk.ktvcommon.download.model.d(r105, r107, r108, r109, r112, 0, ""));
        return;
    L10:
        r112 = "";
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r110, BaseException r111) {
        Intrinsics.checkNotNullParameter(r111, "e");
        super.onFailed(r110, r111);
        b r112 = this.f568221a;
        String[] r100 = {"onFailed: taskId=" + this.f568222b + ", errorCode=" + r111.getErrorCode() + ", errorMsg=" + r111.getErrorMessage()};
        r112.getClass();
        b.b(r100);
        com.bytedance.livesdk.ktvcommon.download.api.g r113 = this.f568223c;
        String r101 = this.f568222b;
        DownloadState r102 = DownloadState.FAILED;
        com.bytedance.livesdk.ktvcommon.download.model.f r103 = this.f568224d;
        r113.a(r101, r102, new com.bytedance.livesdk.ktvcommon.download.model.d(r101, r103.f255975b, r103.f255976c, r103.f255977d, "", r111.getErrorCode(), r111.getErrorMessage()));
    }

    public a(b r100, String r101, com.bytedance.livesdk.ktvcommon.download.e r102, com.bytedance.livesdk.ktvcommon.download.model.f r103) {
        this.f568221a = r100;
        this.f568222b = r101;
        this.f568223c = r102;
        this.f568224d = r103;
    }
}
