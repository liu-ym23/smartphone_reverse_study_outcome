package nv8;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b {

    /* JADX INFO: renamed from: nv8.a$a, reason: collision with other inner class name */
    public static final class C6979a implements IDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f520921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f520922b;

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onCanceled(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onCanceled]");
            this.f520922b.invoke(null);
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFirstStart(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onFirstStart]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFirstSuccess(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onFirstSuccess]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onPause(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onPause]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onPrepare(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onPrepare]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onProgress]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onStart(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onStart]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            FLogger r101 = FLogger.f375446a;
            this.f520921a.getClass();
            r101.i("AccessibilityDownloadJob", "[onSuccessed] entity:" + r100);
            Function1<String, Unit> r102 = this.f520922b;
            if (r100 == null) goto L5;
            String r103 = r100.getTargetFilePath();
        L6:
            r102.invoke(r103);
            return;
        L5:
            r103 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C6979a(a r100, Function1<? super String, Unit> r101) {
            this.f520921a = r100;
            this.f520922b = r101;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            FLogger r102 = FLogger.f375446a;
            this.f520921a.getClass();
            StringBuilder r103 = new StringBuilder("[onFailed] error:");
            if (r101 == null) goto L5;
            String r104 = r101.getMessage();
        L6:
            r103.append(r104);
            r102.i("AccessibilityDownloadJob", r103.toString());
            this.f520922b.invoke(null);
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onRetry(DownloadInfo r100, BaseException r101) {
            FLogger r102 = FLogger.f375446a;
            this.f520921a.getClass();
            r102.i("AccessibilityDownloadJob", "[onRetry]");
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onRetryDelay(DownloadInfo r100, BaseException r101) {
            FLogger r102 = FLogger.f375446a;
            this.f520921a.getClass();
            r102.i("AccessibilityDownloadJob", "[onRetryDelay]");
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b
    public final void a(com.bytedance.android.accessibilityLib_Core.config.remote.subjob.a r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        FLogger.f375446a.i("AccessibilityDownloadJob", "[download] begin, param:" + r100);
        Context r102 = AppHost.f326268a.getApplication().getApplicationContext();
        String r103 = r100.f38233a;
        String r104 = r100.f38234b;
        String r105 = r100.f38236d;
        String r106 = r100.f38237e;
        AppDownloader.getInstance().addDownloadTask(new AppTaskBuilder(r102, r103).saveName(r105).savePath(r104).mimeType(r106).taskKey(r103 + ':' + r104 + ':' + r105).needWifi(false).showNotification(false).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).retryCount(3).mainThreadListener(new C6979a(this, r101)));
    }
}
