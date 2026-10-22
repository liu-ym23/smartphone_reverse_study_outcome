package uz6;

import android.content.Context;
import com.bytedance.lottie.d;
import com.bytedance.lottie.e;
import com.bytedance.lottie.network.FileExtension;
import com.bytedance.lottie.o;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;
import wz6.h;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f552194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uz6.a f552196c;

    public class a extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f552197a;

        public a(CountDownLatch r100) {
            this.f552197a = r100;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            this.f552197a.countDown();
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            this.f552197a.countDown();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f552198a = null;

        static {
            int[] r100 = new int[FileExtension.values().length];
            f552198a = r100;
            r100[FileExtension.Zip.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f552198a[FileExtension.Json.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public final o a() throws IOException {
        CountDownLatch r100 = new CountDownLatch(1);
        String r101 = this.f552195b;
        Set<String> r102 = com.bytedance.lottie.c.f264422a;
        if (r101.endsWith(InvRouter.FLOW_SUFFIX) == false) goto L5;
        FileExtension r103 = FileExtension.Json;
    L6:
        String r104 = uz6.a.a(this.f552195b, r103, true);
        Downloader.with(this.f552194a).url(this.f552195b).name(r104).savePath(this.f552194a.getCacheDir().getAbsolutePath()).mainThreadListener(new a(r100)).monitorScene("legacy_lynx_lottie").download();
        r100.await(3, TimeUnit.SECONDS);     // Catch: InterruptedException -> L21
        PolarisFileWrapper r105 = new PolarisFileWrapper(this.f552194a.getCacheDir().getAbsolutePath(), r104);     // Catch: InterruptedException -> L21
        if (b.f552198a[r103.ordinal()] == 1) goto L10;
        o<d> r106 = e.b(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r105.getAbsolutePath())), this.f552195b, true);     // Catch: InterruptedException -> L21
    L14:
        if (r106.f264578a == null) goto L17;
        this.f552196c.b(r103);     // Catch: InterruptedException -> L21
    L17:
        return r106;
    L10:
        ZipInputStream r107 = new ZipInputStream(new PolarisFileInputStreamWrapper(r105));     // Catch: InterruptedException -> L21
        r106 = e.d(r107, this.f552195b);     // Catch: Throwable -> L18
        h.c(r107);     // Catch: InterruptedException -> L21
        goto L14
    L18:
        th = move-exception;
        h.c(r107);     // Catch: InterruptedException -> L21
        throw th;     // Catch: InterruptedException -> L21
    L22:
        return new o(new IllegalArgumentException("Unable to fetch " + this.f552195b));
    L5:
        r103 = FileExtension.Zip;
        goto L6
    }

    public c(Context r100, String r101) {
        Context r102 = r100.getApplicationContext();
        this.f552194a = r102;
        this.f552195b = r101;
        this.f552196c = new uz6.a(r102, r101);
    }
}
