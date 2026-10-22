package ng4;

import com.bytedance.component.lyric_v2.core.LyricComponentManager$downloadCallback$1;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f519055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f519056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f519057c;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        this.f519057c.d(this.f519056b);
        Object[] r101 = new Object[2];
        StringBuilder r102 = new StringBuilder("下载取消: ");
        if (r100 == null) goto L5;
        String r103 = r100.getUrl();
    L6:
        r102.append(r103);
        r101[0] = r102.toString();
        r101[1] = this.f519056b;
        ug4.b.a(r101);
        b r104 = this.f519055a;
        r104.f519059b = false;
        r104.f519060c = null;
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getTotalBytes() <= 0) goto L8;
        int r101 = (int) ((r100.getCurBytes() * ((long) 100)) / r100.getTotalBytes());
        this.f519057c.f(r101);
        ug4.b.a(new Object[]{"下载进度: " + r101 + '%', this.f519056b});
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        l r101 = this.f519056b;
        if (r100 == null) goto L6;
        String r102 = r100.getTargetFilePath();
        if (r102 == null) goto L6;
    L7:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f519078j = r102;
        this.f519057c.c(this.f519056b);
        Object[] r103 = new Object[2];
        StringBuilder r104 = new StringBuilder("下载成功: ");
        if (r100 == null) goto L10;
        String r105 = r100.getUrl();
    L11:
        r104.append(r105);
        r103[0] = r104.toString();
        r103[1] = this.f519056b;
        ug4.b.a(r103);
        b r106 = this.f519055a;
        r106.f519059b = false;
        r106.f519060c = null;
        return;
    L10:
        r105 = null;
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        l r102 = this.f519056b;
        r102.getClass();
        String r103 = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r102.f519078j = "";
        f r104 = this.f519057c;
        l r105 = this.f519056b;
        int r106 = r101.getErrorCode();
        String r107 = r101.getErrorMessage();
        if (r107 == null) goto L6;
        r103 = r107;
    L6:
        r104.g(r105, r106, r103);
        Object[] r108 = new Object[2];
        StringBuilder r109 = new StringBuilder("下载失败: ");
        if (r100 == null) goto L9;
        String r110 = r100.getUrl();
    L10:
        r109.append(r110);
        r108[0] = r109.toString();
        r108[1] = this.f519056b;
        ug4.b.a(r108);
        b r111 = this.f519055a;
        r111.f519059b = false;
        r111.f519060c = null;
        return;
    L9:
        r110 = null;
        goto L10
    }

    public a(b r100, l r101, LyricComponentManager$downloadCallback$1 r102) {
        this.f519055a = r100;
        this.f519056b = r101;
        this.f519057c = r102;
    }
}
