package ho7;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.io.File;
import java.lang.ref.WeakReference;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareContent f486253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f486254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f486255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f486256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ WeakReference f486257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Activity f486258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ co7.e f486259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f486260h;

    public class a implements in7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f486261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f486262b;

        @Override // in7.d
        public final void a() {
            ShareContent r100 = this.f486262b.f486253a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(0, this.f486262b.f486256d, System.currentTimeMillis() - this.f486261a);
            String r101 = this.f486262b.f486255c + File.separator + this.f486262b.f486254b;
            ShareContent r102 = this.f486262b.f486253a;
            if (r102 == null) goto L10;
            r102.setVideoUrl(r101);
            h r103 = this.f486262b;
            i r104 = r103.f486260h;
            Activity r105 = r103.f486258f;
            ShareContent r106 = r103.f486253a;
            co7.e r107 = r103.f486259g;
            r104.getClass();
            i.a(r105, r106, r107);
        L10:
            WeakReference r108 = this.f486262b.f486257e;
            if (r108 != null) goto L13;
            return;
        L13:
            if (r108.get() != null) goto L20;
            return;
        L20:
            ((mn7.a) this.f486262b.f486257e.get()).dismiss();     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            e.printStackTrace();
            return;
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r109 = this.f486262b.f486253a.getEventCallBack();
            DownloadStatus r110 = DownloadStatus.SUCCESS;
            h r111 = this.f486262b;
            r109.d(r110, r111.f486256d, r111.f486253a);
            goto L7
        }

        @Override // in7.d
        public final void onCanceled() {
            ShareContent r100 = this.f486262b.f486253a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(2, this.f486262b.f486256d, System.currentTimeMillis() - this.f486261a);
            WeakReference r101 = this.f486262b.f486257e;
            if (r101 != null) goto L10;
        L16:
            co7.e r102 = this.f486262b.f486259g;
            if (r102 == null) goto L19;
            r102.a();
        L19:
            h r103 = this.f486262b;
            o.a(r103.f486258f, r103.f486253a, 6, R.string.share_sdk_video_share_save_failed);
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f486262b.f486257e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r104 = this.f486262b.f486253a.getEventCallBack();
            DownloadStatus r105 = DownloadStatus.CANCELED;
            h r106 = this.f486262b;
            r104.d(r105, r106.f486256d, r106.f486253a);
            goto L7
        }

        @Override // in7.d
        public final void onFailed() {
            ShareContent r100 = this.f486262b.f486253a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(1, this.f486262b.f486256d, System.currentTimeMillis() - this.f486261a);
            WeakReference r101 = this.f486262b.f486257e;
            if (r101 != null) goto L10;
        L16:
            co7.e r102 = this.f486262b.f486259g;
            if (r102 == null) goto L19;
            r102.a();
        L19:
            h r103 = this.f486262b;
            o.a(r103.f486258f, r103.f486253a, 5, R.string.share_sdk_video_share_save_failed);
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f486262b.f486257e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r104 = this.f486262b.f486253a.getEventCallBack();
            DownloadStatus r105 = DownloadStatus.FAILED;
            h r106 = this.f486262b;
            r104.d(r105, r106.f486256d, r106.f486253a);
            goto L7
        }

        @Override // in7.d
        public final void onStart() {
            ShareContent r100 = this.f486262b.f486253a;
            if (r100 != null) goto L5;
        L7:
            WeakReference r101 = this.f486262b.f486257e;
            if (r101 != null) goto L10;
            return;
        L10:
            if (r101.get() == null) goto L14;
            ((mn7.a) this.f486262b.f486257e.get()).show();
            return;
        L14:
            return;
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r102 = this.f486262b.f486253a.getEventCallBack();
            DownloadStatus r103 = DownloadStatus.START;
            h r104 = this.f486262b;
            r102.d(r103, r104.f486256d, r104.f486253a);
            goto L7
        }

        @Override // in7.d
        public final void onProgress(int r100) {
            WeakReference r101 = this.f486262b.f486257e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.get() == null) goto L9;
            ((mn7.a) this.f486262b.f486257e.get()).b();
            return;
        }

        public a(h r100, long r101) {
            this.f486262b = r100;
            this.f486261a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L4
        eo7.a.b.f473353a.a(this.f486253a, this.f486254b, this.f486255c, this.f486256d, new a(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(i r100, ShareContent r101, String r102, String r103, String r104, WeakReference r105, Activity r106, co7.e r107) {
        this.f486260h = r100;
        this.f486253a = r101;
        this.f486254b = r102;
        this.f486255c = r103;
        this.f486256d = r104;
        this.f486257e = r105;
        this.f486258f = r106;
        this.f486259g = r107;
    }
}
