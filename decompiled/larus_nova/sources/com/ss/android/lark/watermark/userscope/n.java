package com.ss.android.lark.watermark.userscope;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.watermark.v2.v f445465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3 f445466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f445467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IAttachToBitmapCallback f445468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3$addWatermarkToBitmap$observer$1 f445469e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAttachToBitmapCallback f445470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f445471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bitmap f445472c;

        public a(IAttachToBitmapCallback r100, Bitmap r101, Bitmap r102) {
            this.f445470a = r100;
            this.f445471b = r101;
            this.f445472c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAttachToBitmapCallback r100 = this.f445470a;     // Catch: Throwable -> L6 OutOfMemoryError -> L8
            if (r100 == null) goto L14;
            r100.onAttachSuccess(this.f445471b);     // Catch: Throwable -> L6 OutOfMemoryError -> L8
        L21:
            return;
        L14:
            return;
        L8:
            IAttachToBitmapCallback r101 = this.f445470a;     // Catch: Throwable -> L6
            if (r101 == null) goto L19;
            r101.onAttachFailed(this.f445472c, "Out of memory");     // Catch: Throwable -> L6
            return;
        L19:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WatermarkImplV3 f445473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WatermarkImplV3$addWatermarkToBitmap$observer$1 f445474b;

        public b(WatermarkImplV3 r100, WatermarkImplV3$addWatermarkToBitmap$observer$1 r101) {
            this.f445473a = r100;
            this.f445474b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f445473a.f().b().removeObserver(this.f445474b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public n(com.ss.android.lark.watermark.v2.v r100, WatermarkImplV3 r101, Bitmap r102, IAttachToBitmapCallback r103, WatermarkImplV3$addWatermarkToBitmap$observer$1 r104) {
        this.f445465a = r100;
        this.f445466b = r101;
        this.f445467c = r102;
        this.f445468d = r103;
        this.f445469e = r104;
    }

    public final void a() {
        com.ss.android.lark.watermark.v2.u r100 = new com.ss.android.lark.watermark.v2.u(this.f445465a, this.f445466b.f445352d);     // Catch: OutOfMemoryError -> L6
        Bitmap.Config r101 = this.f445467c.getConfig();     // Catch: OutOfMemoryError -> L6
        if (r101 == null) goto L9;
        Bitmap r102 = this.f445467c;     // Catch: OutOfMemoryError -> L6
        IAttachToBitmapCallback r103 = this.f445468d;     // Catch: OutOfMemoryError -> L6
        Bitmap r104 = r102.copy(r101, true);     // Catch: OutOfMemoryError -> L6
        r100.setBounds(0, 0, r102.getWidth(), r102.getHeight());     // Catch: OutOfMemoryError -> L6
        r100.draw(new Canvas(r104));     // Catch: OutOfMemoryError -> L6
        new Handler(Looper.getMainLooper()).post(new a(r103, r104, r102));     // Catch: OutOfMemoryError -> L6
    L9:
        new Handler(Looper.getMainLooper()).post(new b(this.f445466b, this.f445469e));
        return;
    L6:
        IAttachToBitmapCallback r105 = this.f445468d;
        if (r105 == null) goto L9;
        r105.onAttachFailed(this.f445467c, "Out of memory");
        goto L9
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
}
