package llc;

import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.Triple;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements IDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f509815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.effectplatform.bridge.network.a f509816b;

    public static final class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileInputStream f509817a;

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            super.close();
            this.f509817a.close();
        }

        public a(PolarisFileInputStreamWrapper r100, PolarisFileInputStreamWrapper r101) {
            this.f509817a = r100;
            super(r101);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstStart(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstSuccess(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPrepare(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetryDelay(DownloadInfo r100, BaseException r101) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        Triple<String, DownloadTask, NetResponse> r101 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r101 == null) goto L7;
        String r102 = r101.getFirst();
        if (r102 == null) goto L7;
    L8:
        Logger.e$default(Logger.INSTANCE, "JKL", "[取消][SDK][" + r102 + "][网络响应码：" + r100.getHttpStatusCode() + "][耗时:" + r100.getDownloadTime() + ']', null, 4, null);
        Triple<String, DownloadTask, NetResponse> r103 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r103 == null) goto L13;
        NetResponse r104 = r103.getThird();
        if (r104 == null) goto L13;
        r104.setStatusCode(600);
        r104.setBodyStream(new EmptyByteReadStream());
        r104.setContentLength(-3);
    L13:
        Triple<String, DownloadTask, NetResponse> r105 = this.f509815a.f509812b.remove(b.c(r100.getUrl()));
        b.b(this.f509815a, r100.getId());
        return;
    L7:
        r102 = "";
        goto L8
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPause(DownloadInfo r100) {
        Triple<String, DownloadTask, NetResponse> r101 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r101 == null) goto L7;
        String r102 = r101.getFirst();
        if (r102 == null) goto L7;
    L8:
        Logger.INSTANCE.w("JKL", "[暂停][SDK][" + r102 + "][网络状态码:" + r100.getHttpStatusCode() + "][进度:" + r100.getDownloadProcess() + ']');
        Triple<String, DownloadTask, NetResponse> r103 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r103 == null) goto L13;
        NetResponse r104 = r103.getThird();
        if (r104 == null) goto L13;
        r104.setStatusCode(206);
        r104.setBodyStream(new EmptyByteReadStream());
        r104.setContentLength(-2);
    L13:
        b.b(this.f509815a, r100.getId());
        return;
    L7:
        r102 = "";
        goto L8
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        com.ss.ugc.effectplatform.bridge.network.a r101 = this.f509816b;
        if (r101 == null) goto L6;
        r101.onProgress(r100.getDownloadProcess(), r100.getTotalBytes());
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onStart(DownloadInfo r100) {
        Triple<String, DownloadTask, NetResponse> r101 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r101 == null) goto L7;
        String r102 = r101.getFirst();
        if (r102 == null) goto L7;
    L8:
        Logger.INSTANCE.d("JKL", "[开始][SDK][" + r102 + ']');
        return;
    L7:
        r102 = "";
        goto L8
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        Triple<String, DownloadTask, NetResponse> r101 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r101 == null) goto L7;
        String r102 = r101.getFirst();
        if (r102 == null) goto L7;
    L8:
        Logger.INSTANCE.d("JKL", "[成功][SDK][" + r102 + "][状态码:" + r100.getHttpStatusCode() + "][总大小:" + r100.getTotalBytes() + "][单次耗时:" + r100.getDownloadTime() + "][总体耗时:" + r100.getRealDownloadTime() + ']');
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100.getTargetFilePath()));
        e r104 = new e(new a(r103, r103));
        Triple<String, DownloadTask, NetResponse> r105 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r105 == null) goto L13;
        NetResponse r106 = r105.getThird();
        if (r106 == null) goto L13;
        r106.setStatusCode(200);
        r106.setBodyStream(r104);
        r106.setContentLength(r100.getTotalBytes());
        r106.setFilePath(r100.getSavePath() + File.separator + r100.getName());
    L13:
        Triple<String, DownloadTask, NetResponse> r107 = this.f509815a.f509812b.remove(b.c(r100.getUrl()));
        b.b(this.f509815a, r100.getId());
        return;
    L7:
        r102 = "";
        goto L8
    }

    public c(b r100, com.ss.ugc.effectplatform.bridge.network.a r101) {
        this.f509815a = r100;
        this.f509816b = r101;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        Triple<String, DownloadTask, NetResponse> r102 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r102 == null) goto L7;
        String r103 = r102.getFirst();
        if (r103 == null) goto L7;
    L8:
        Logger.e$default(Logger.INSTANCE, "JKL", "[失败][SDK][" + r103 + "][耗时:" + r100.getDownloadTime() + "][StatusCode:" + r100.getHttpStatusCode() + "][Size：" + r100.getExpectFileLength() + "][ErrorMsg:" + r101.getErrorMessage() + ']', null, 4, null);
        Triple<String, DownloadTask, NetResponse> r104 = this.f509815a.f509812b.get(b.c(r100.getUrl()));
        if (r104 == null) goto L17;
        NetResponse r105 = r104.getThird();
        if (r105 == null) goto L17;
        if (r100.getHttpStatusCode() != 200) goto L15;
        int r106 = 601;
    L16:
        r105.setStatusCode(r106);
        r105.setBodyStream(new EmptyByteReadStream());
        r105.setContentLength(-1);
        r105.setErrorMsg(r101.getErrorMessage());
        goto L17
    L15:
        r106 = r100.getHttpStatusCode();
    L17:
        r101.printStackTrace();
        Triple<String, DownloadTask, NetResponse> r107 = this.f509815a.f509812b.remove(b.c(r100.getUrl()));
        b.b(this.f509815a, r100.getId());
        return;
    L7:
        r103 = "";
        goto L8
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetry(DownloadInfo r100, BaseException r101) {
        Logger.e$default(Logger.INSTANCE, "JKL", "[重试][SDK] : " + r100.getId(), null, 4, null);
    }
}
