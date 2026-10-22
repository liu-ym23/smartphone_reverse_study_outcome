package com.bytedance.push.notification;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.service.manager.push.notification.AsyncImageDownloader;
import com.bytedance.android.service.manager.push.notification.ImageDownloadCallback;
import com.bytedance.common.push.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public class AsyncImageDownloadWrapper implements AsyncImageDownloader, Handler.Callback {
    private Handler mHandler;
    private final t67.a mImageDownloader;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t67.c f266896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageDownloadCallback f266897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AsyncImageDownloadWrapper f266898c;

        /* JADX INFO: renamed from: com.bytedance.push.notification.AsyncImageDownloadWrapper$a$a, reason: collision with other inner class name */
        public class RunnableC3734a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f266899a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f266900b;

            @Override // java.lang.Runnable
            public final void run() {
                Bitmap r100 = this.f266899a;     // Catch: Throwable -> L9
                if (r100 != null) goto L5;
            L7:
                this.f266900b.f266897b.onFailed();     // Catch: Throwable -> L9
            L14:
                return;
            L5:
                if (r100.isRecycled() == true) goto L7;
                this.f266900b.f266897b.onSuccess(this.f266899a);     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            }

            public RunnableC3734a(a r100, Bitmap r101) {
                this.f266900b = r100;
                this.f266899a = r101;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap r100 = AsyncImageDownloadWrapper.access$000(this.f266898c).downloadImage(this.f266896a);     // Catch: Throwable -> L4
        L6:
            AsyncImageDownloadWrapper.access$100(this.f266898c).post(new RunnableC3734a(this, r100));     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L4:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L8
            r100 = null;
            goto L6
        }

        public a(AsyncImageDownloadWrapper r100, t67.c r101, ImageDownloadCallback r102) {
            this.f266898c = r100;
            this.f266896a = r101;
            this.f266897b = r102;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        return false;
    }

    public AsyncImageDownloadWrapper(t67.a r100) {
        this.mImageDownloader = r100;
    }

    public static /* synthetic */ t67.a access$000(AsyncImageDownloadWrapper r100) {
        return r100.mImageDownloader;
    }

    public static /* synthetic */ Handler access$100(AsyncImageDownloadWrapper r100) {
        return r100.mHandler;
    }

    @Override // com.bytedance.android.service.manager.push.notification.AsyncImageDownloader, t67.a
    public Bitmap downloadImage(t67.c r100) {
        return this.mImageDownloader.downloadImage(r100);
    }

    @Override // com.bytedance.android.service.manager.push.notification.AsyncImageDownloader
    public void asyncDownloadImage(t67.c r100, ImageDownloadCallback r101) {
        if (this.mHandler != null) goto L5;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    L5:
        ThreadPlus.submitRunnable(new a(this, r100, r101));
    }
}
