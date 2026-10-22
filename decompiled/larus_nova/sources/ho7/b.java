package ho7;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.io.File;
import java.lang.ref.WeakReference;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f486225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f486226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f486227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f486228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ WeakReference f486229e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ co7.a f486230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Activity f486231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ b f486232h;

        /* JADX INFO: renamed from: ho7.b$a$a, reason: collision with other inner class name */
        public class C6178a implements in7.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f486233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f486234b;

            @Override // in7.d
            public final void a() {
                ShareContent r100 = this.f486234b.f486225a;
                if (r100 != null) goto L5;
            L7:
                go7.a.d(0, this.f486234b.f486228d, System.currentTimeMillis() - this.f486233a);
                String r101 = this.f486234b.f486227c + File.separator + this.f486234b.f486226b;
                ShareContent r102 = this.f486234b.f486225a;
                if (r102 == null) goto L10;
                r102.setFileUrl(r101);
                a r103 = this.f486234b;
                b r104 = r103.f486232h;
                ShareContent r105 = r103.f486225a;
                co7.a r106 = r103.f486230f;
                r104.getClass();
                b.a(r105, r106);
            L10:
                WeakReference r107 = this.f486234b.f486229e;
                if (r107 != null) goto L13;
                return;
            L13:
                if (r107.get() != null) goto L20;
                return;
            L20:
                ((mn7.a) this.f486234b.f486229e.get()).dismiss();     // Catch: Exception -> L17
                return;
            L17:
                e = move-exception;
                e.printStackTrace();
                return;
            L5:
                if (r100.getEventCallBack() == null) goto L7;
                in7.h r108 = this.f486234b.f486225a.getEventCallBack();
                DownloadStatus r109 = DownloadStatus.SUCCESS;
                a r110 = this.f486234b;
                r108.d(r109, r110.f486228d, r110.f486225a);
                goto L7
            }

            @Override // in7.d
            public final void onCanceled() {
                ShareContent r100 = this.f486234b.f486225a;
                if (r100 != null) goto L5;
            L7:
                go7.a.d(2, this.f486234b.f486228d, System.currentTimeMillis() - this.f486233a);
                WeakReference r101 = this.f486234b.f486229e;
                if (r101 != null) goto L10;
            L16:
                co7.a r102 = this.f486234b.f486230f;
                if (r102 == null) goto L19;
                r102.a();
            L19:
                a r103 = this.f486234b;
                o.a(r103.f486231g, r103.f486225a, 2, R.string.share_sdk_file_share_save_failed);
                return;
            L10:
                if (r101.get() == null) goto L16;
                ((mn7.a) this.f486234b.f486229e.get()).dismiss();     // Catch: Exception -> L14
            L14:
                e = move-exception;
                e.printStackTrace();
                goto L16
            L5:
                if (r100.getEventCallBack() == null) goto L7;
                in7.h r104 = this.f486234b.f486225a.getEventCallBack();
                DownloadStatus r105 = DownloadStatus.CANCELED;
                a r106 = this.f486234b;
                r104.d(r105, r106.f486228d, r106.f486225a);
                goto L7
            }

            @Override // in7.d
            public final void onFailed() {
                ShareContent r100 = this.f486234b.f486225a;
                if (r100 != null) goto L5;
            L7:
                go7.a.d(1, this.f486234b.f486225a.getFileUrl(), System.currentTimeMillis() - this.f486233a);
                WeakReference r101 = this.f486234b.f486229e;
                if (r101 != null) goto L10;
            L16:
                co7.a r102 = this.f486234b.f486230f;
                if (r102 == null) goto L19;
                r102.a();
            L19:
                a r103 = this.f486234b;
                o.a(r103.f486231g, r103.f486225a, 3, R.string.share_sdk_file_share_save_failed);
                return;
            L10:
                if (r101.get() == null) goto L16;
                ((mn7.a) this.f486234b.f486229e.get()).dismiss();     // Catch: Exception -> L14
            L14:
                e = move-exception;
                e.printStackTrace();
                goto L16
            L5:
                if (r100.getEventCallBack() == null) goto L7;
                in7.h r104 = this.f486234b.f486225a.getEventCallBack();
                DownloadStatus r105 = DownloadStatus.FAILED;
                a r106 = this.f486234b;
                r104.d(r105, r106.f486228d, r106.f486225a);
                goto L7
            }

            @Override // in7.d
            public final void onStart() {
                ShareContent r100 = this.f486234b.f486225a;
                if (r100 != null) goto L5;
            L7:
                WeakReference r101 = this.f486234b.f486229e;
                if (r101 != null) goto L10;
                return;
            L10:
                if (r101.get() == null) goto L14;
                ((mn7.a) this.f486234b.f486229e.get()).show();
                return;
            L14:
                return;
            L5:
                if (r100.getEventCallBack() == null) goto L7;
                in7.h r102 = this.f486234b.f486225a.getEventCallBack();
                DownloadStatus r103 = DownloadStatus.START;
                a r104 = this.f486234b;
                r102.d(r103, r104.f486228d, r104.f486225a);
                goto L7
            }

            @Override // in7.d
            public final void onProgress(int r100) {
                WeakReference r101 = this.f486234b.f486229e;
                if (r101 != null) goto L5;
                return;
            L5:
                if (r101.get() == null) goto L9;
                ((mn7.a) this.f486234b.f486229e.get()).b();
                return;
            }

            public C6178a(a r100, long r101) {
                this.f486234b = r100;
                this.f486233a = r101;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L4
            eo7.a.b.f473353a.a(this.f486225a, this.f486226b, this.f486227c, this.f486228d, new C6178a(this, r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, ShareContent r101, String r102, String r103, String r104, WeakReference r105, co7.a r106, Activity r107) {
            this.f486232h = r100;
            this.f486225a = r101;
            this.f486226b = r102;
            this.f486227c = r103;
            this.f486228d = r104;
            this.f486229e = r105;
            this.f486230f = r106;
            this.f486231g = r107;
        }
    }

    /* JADX INFO: renamed from: ho7.b$b, reason: collision with other inner class name */
    public static class C6179b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f486235a = null;

        static {
            f486235a = new b();
        }
    }

    public b() {
    }

    public static void a(ShareContent r100, co7.a r101) {
        if (r100 != null) goto L6;
        if (r101 == null) goto L12;
        r101.a();
        return;
    L12:
        return;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100.getFileUrl()) == true) goto L10;
        r101.b(r100.getFileUrl());
        return;
    L10:
        r101.a();
    }

    public final void b(ShareContent r110, co7.a r111) {
        if (r110 != null) goto L5;
        r111.a();
        return;
    L5:
        String r100 = r110.getFileUrl();
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r111.a();
        return;
    L9:
        eo7.a r101 = eo7.a.b.f473353a;
        if (r101.h() != null) goto L14;
        r111.a();
        return;
    L14:
        if (oo7.g.a(r100) == true) goto L17;
        a(r110, r111);
        return;
    L17:
        Activity r112 = r101.h();
        if (TextUtils.isEmpty(r110.getFileUrl()) == true) goto L28;
        if (r112 == null) goto L28;
        mn7.a r102 = r110.getDownloadProgressDialog();
        if (r102 != null) goto L26;
        r102 = r101.b(r112);
        if (r102 != null) goto L26;
        return;
    L26:
        WeakReference r103 = new WeakReference(r102);
        String r104 = oo7.f.f();
        String r105 = r110.getFileName();
        String r106 = r110.getFileUrl();
        r102.a();
        jo7.c.a(new a(this, r110, r105, r104, r106, r103, r111, r112));
        return;
    L28:
        r111.a();
    }
}
