package oo7;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f524622a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f524623b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f524624a;

        @Override // java.lang.Runnable
        public final void run() {
            eo7.a r100 = eo7.a.b.f473353a;     // Catch: Throwable -> L18
            if (r100.h() == null) goto L27;
            ShareContent r101 = this.f524624a;     // Catch: Exception -> L15 Throwable -> L18
            if (r101 == null) goto L8;
            r101.getShareProgressView();     // Catch: Exception -> L15 Throwable -> L18
        L8:
            jn7.l r102 = r100.f473336j;     // Catch: Exception -> L15 Throwable -> L18
            if (r102 == null) goto L11;
            r102.a();     // Catch: Exception -> L15 Throwable -> L18
        L11:
            jn7.l r103 = com.bytedance.ug.sdk.share.impl.manager.b.c();     // Catch: Exception -> L15 Throwable -> L18
            if (r103 == null) goto L21;
            r103.a();     // Catch: Exception -> L15 Throwable -> L18
        L28:
            return;
        L21:
            return;
        L15:
            e = move-exception;
            k.b(e.toString());     // Catch: Throwable -> L18
            return;
        L27:
            return;
        L18:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }

        public a(ShareContent r100) {
            this.f524624a = r100;
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static void a() {
        Handler r100 = f524623b;
        if (r100 == null) goto L6;
        r100.removeCallbacksAndMessages(null);
        f524623b.post(new b());
        return;
    }

    public static void b(ShareContent r100) {
        if (f524622a >= 0) goto L6;
        f524622a = ((Integer) eo7.a.b.f473353a.c("image_download_loading_delay", 150)).intValue();
    L6:
        if (f524623b != null) goto L8;
        f524623b = new Handler(Looper.getMainLooper());
    L8:
        f524623b.postDelayed(new a(r100), f524622a);
    }
}
