package ho7;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareContent f486241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f486242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f486243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f486244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ WeakReference f486245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Activity f486246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f486247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f486248h;

    public class a implements in7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f486249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f486250b;

        /* JADX INFO: renamed from: ho7.f$a$a, reason: collision with other inner class name */
        public class RunnableC6180a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f486251a;

            public final void a() {
                WeakReference r100 = this.f486251a.f486250b.f486245e;
                if (r100 != null) goto L5;
            L11:
                f r101 = this.f486251a.f486250b;
                ShareContent r102 = r101.f486241a;
                if (r102 == null) goto L17;
                r102.setVideoUrl(r101.f486247g);
                f r103 = this.f486251a.f486250b;
                g r104 = r103.f486248h;
                Activity r105 = r103.f486246f;
                ShareContent r106 = r103.f486241a;
                r104.getClass();
                g.a(r105, r106);
                return;
            L17:
                return;
            L5:
                if (r100.get() == null) goto L11;
                ((mn7.a) this.f486251a.f486250b.f486245e.get()).dismiss();     // Catch: Exception -> L9
            L9:
                e = move-exception;
                e.printStackTrace();
                goto L11
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC6180a(a r100) {
                this.f486251a = r100;
            }
        }

        @Override // in7.d
        public final void a() {
            WeakReference r100 = this.f486250b.f486245e;
            if (r100 != null) goto L5;
        L7:
            ShareContent r101 = this.f486250b.f486241a;
            if (r101 != null) goto L10;
        L12:
            go7.a.g(0, this.f486250b.f486244d, System.currentTimeMillis() - this.f486249a);
            f r102 = this.f486250b;
            oo7.f.j(r102.f486246f, r102.f486247g, false);
            bo7.a.C0322a.f19870a.b(this.f486250b.f486242b, false);
            this.f486250b.f486248h.f486252a.postDelayed(new RunnableC6180a(this), ((Integer) eo7.a.b.f473353a.c("download_success_share_delay", 0)).intValue());
            return;
        L10:
            if (r101.getEventCallBack() == null) goto L12;
            in7.h r103 = this.f486250b.f486241a.getEventCallBack();
            DownloadStatus r104 = DownloadStatus.SUCCESS;
            f r105 = this.f486250b;
            r103.d(r104, r105.f486244d, r105.f486241a);
            goto L12
        L5:
            if (r100.get() == null) goto L7;
            ((mn7.a) this.f486250b.f486245e.get()).b();
            goto L7
        }

        @Override // in7.d
        public final void onCanceled() {
            ShareContent r100 = this.f486250b.f486241a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(2, this.f486250b.f486244d, System.currentTimeMillis() - this.f486249a);
            WeakReference r101 = this.f486250b.f486245e;
            if (r101 != null) goto L10;
        L16:
            f r102 = this.f486250b;
            o.a(r102.f486246f, r102.f486241a, 6, R.string.share_sdk_video_share_save_failed);
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f486250b.f486245e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r103 = this.f486250b.f486241a.getEventCallBack();
            DownloadStatus r104 = DownloadStatus.CANCELED;
            f r105 = this.f486250b;
            r103.d(r104, r105.f486244d, r105.f486241a);
            goto L7
        }

        @Override // in7.d
        public final void onFailed() {
            ShareContent r100 = this.f486250b.f486241a;
            if (r100 != null) goto L5;
        L7:
            go7.a.g(1, this.f486250b.f486244d, System.currentTimeMillis() - this.f486249a);
            WeakReference r101 = this.f486250b.f486245e;
            if (r101 != null) goto L10;
        L16:
            f r102 = this.f486250b;
            o.a(r102.f486246f, r102.f486241a, 5, R.string.share_sdk_video_share_save_failed);
            return;
        L10:
            if (r101.get() == null) goto L16;
            ((mn7.a) this.f486250b.f486245e.get()).dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r103 = this.f486250b.f486241a.getEventCallBack();
            DownloadStatus r104 = DownloadStatus.FAILED;
            f r105 = this.f486250b;
            r103.d(r104, r105.f486244d, r105.f486241a);
            goto L7
        }

        @Override // in7.d
        public final void onStart() {
            ShareContent r100 = this.f486250b.f486241a;
            if (r100 != null) goto L5;
        L7:
            WeakReference r101 = this.f486250b.f486245e;
            if (r101 != null) goto L10;
            return;
        L10:
            if (r101.get() == null) goto L14;
            ((mn7.a) this.f486250b.f486245e.get()).show();
            return;
        L14:
            return;
        L5:
            if (r100.getEventCallBack() == null) goto L7;
            in7.h r102 = this.f486250b.f486241a.getEventCallBack();
            DownloadStatus r103 = DownloadStatus.START;
            f r104 = this.f486250b;
            r102.d(r103, r104.f486244d, r104.f486241a);
            goto L7
        }

        @Override // in7.d
        public final void onProgress(int r100) {
            WeakReference r101 = this.f486250b.f486245e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.get() == null) goto L9;
            ((mn7.a) this.f486250b.f486245e.get()).b();
            return;
        }

        public a(f r100, long r101) {
            this.f486250b = r100;
            this.f486249a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L4
        eo7.a.b.f473353a.a(this.f486241a, this.f486242b, this.f486243c, this.f486244d, new a(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(g r100, ShareContent r101, String r102, String r103, String r104, WeakReference r105, Activity r106, String r107) {
        this.f486248h = r100;
        this.f486241a = r101;
        this.f486242b = r102;
        this.f486243c = r103;
        this.f486244d = r104;
        this.f486245e = r105;
        this.f486246f = r106;
        this.f486247g = r107;
    }
}
