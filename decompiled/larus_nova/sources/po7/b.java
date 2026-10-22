package po7;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.webkit.MimeTypeMap;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import in7.d;
import in7.h;
import java.io.File;
import java.lang.ref.WeakReference;
import oo7.f;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareContent f530089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f530090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f530091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f530092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ WeakReference f530093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Activity f530094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ po7.a f530095g;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f530096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f530097b;

        @Override // in7.d
        public final void a() {
            ShareContent r100 = this.f530097b.f530089a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(0, this.f530097b.f530092d, System.currentTimeMillis() - this.f530096a);
            WeakReference r101 = this.f530097b.f530093e;
            if (r101 != null) goto L10;
        L16:
            b r102 = this.f530097b;
            o.a(r102.f530094f, r102.f530089a, 12, R.string.share_sdk_had_saved_to_album);
            String r103 = this.f530097b.f530091c + File.separator + this.f530097b.f530090b;
            b r104 = this.f530097b;
            po7.a r105 = r104.f530095g;
            Activity r106 = r104.f530094f;
            r105.getClass();
            f.j(r106, r103, false);
            MediaScannerConnection.scanFile(r106, new String[]{r103}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension(".mp4")}, new c());
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f530097b.f530093e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            h r107 = this.f530097b.f530089a.getEventCallBack();
            DownloadStatus r108 = DownloadStatus.SUCCESS;
            b r109 = this.f530097b;
            r107.d(r108, r109.f530092d, r109.f530089a);
            goto L7
        }

        @Override // in7.d
        public final void onCanceled() {
            ShareContent r100 = this.f530097b.f530089a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(2, this.f530097b.f530092d, System.currentTimeMillis() - this.f530096a);
            WeakReference r101 = this.f530097b.f530093e;
            if (r101 != null) goto L10;
        L16:
            b r102 = this.f530097b;
            o.a(r102.f530094f, r102.f530089a, 6, R.string.share_sdk_video_save_failed);
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f530097b.f530093e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            h r103 = this.f530097b.f530089a.getEventCallBack();
            DownloadStatus r104 = DownloadStatus.CANCELED;
            b r105 = this.f530097b;
            r103.d(r104, r105.f530092d, r105.f530089a);
            goto L7
        }

        @Override // in7.d
        public final void onFailed() {
            ShareContent r100 = this.f530097b.f530089a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(1, this.f530097b.f530092d, System.currentTimeMillis() - this.f530096a);
            WeakReference r101 = this.f530097b.f530093e;
            if (r101 != null) goto L10;
        L16:
            b r102 = this.f530097b;
            o.a(r102.f530094f, r102.f530089a, 5, R.string.share_sdk_video_save_failed);
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f530097b.f530093e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            h r103 = this.f530097b.f530089a.getEventCallBack();
            DownloadStatus r104 = DownloadStatus.FAILED;
            b r105 = this.f530097b;
            r103.d(r104, r105.f530092d, r105.f530089a);
            goto L7
        }

        @Override // in7.d
        public final void onStart() {
            ShareContent r100 = this.f530097b.f530089a;
            if (r100 != null) goto L5;
        L7:
            WeakReference r101 = this.f530097b.f530093e;
            if (r101 != null) goto L10;
            return;
        L10:
            if (r101.get() == null) goto L14;
            ((mn7.a) this.f530097b.f530093e.get()).show();
            return;
        L14:
            return;
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            h r102 = this.f530097b.f530089a.getEventCallBack();
            DownloadStatus r103 = DownloadStatus.START;
            b r104 = this.f530097b;
            r102.d(r103, r104.f530092d, r104.f530089a);
            goto L7
        }

        @Override // in7.d
        public final void onProgress(int r100) {
            WeakReference r101 = this.f530097b.f530093e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.get() == null) goto L9;
            ((mn7.a) this.f530097b.f530093e.get()).b();
            return;
        }

        public a(b r100, long r101) {
            this.f530097b = r100;
            this.f530096a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L4
        eo7.a.b.f473353a.a(this.f530089a, this.f530090b, this.f530091c, this.f530092d, new a(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(po7.a r100, ShareContent r101, String r102, String r103, String r104, WeakReference r105, Activity r106) {
        this.f530095g = r100;
        this.f530089a = r101;
        this.f530090b = r102;
        this.f530091c = r103;
        this.f530092d = r104;
        this.f530093e = r105;
        this.f530094f = r106;
    }
}
