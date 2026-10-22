package com.ss.android.lark.watermark.userscope;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.watermark.v2.v f445491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3 f445492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f445493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IAttachToBitmapCallback f445494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ LiveData<com.ss.android.lark.watermark.v2.v> f445495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3$tryAddFileWatermarkToBitmap$1$observer$1 f445496f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveData<com.ss.android.lark.watermark.v2.v> f445497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WatermarkImplV3$tryAddFileWatermarkToBitmap$1$observer$1 f445498b;

        public a(LiveData<com.ss.android.lark.watermark.v2.v> r100, WatermarkImplV3$tryAddFileWatermarkToBitmap$1$observer$1 r101) {
            this.f445497a = r100;
            this.f445498b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f445497a.removeObserver(this.f445498b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public r(com.ss.android.lark.watermark.v2.v r100, WatermarkImplV3 r101, Bitmap r102, IAttachToBitmapCallback r103, LiveData<com.ss.android.lark.watermark.v2.v> r104, WatermarkImplV3$tryAddFileWatermarkToBitmap$1$observer$1 r105) {
        this.f445491a = r100;
        this.f445492b = r101;
        this.f445493c = r102;
        this.f445494d = r103;
        this.f445495e = r104;
        this.f445496f = r105;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L7
        com.ss.android.lark.watermark.v2.u r101 = new com.ss.android.lark.watermark.v2.u(this.f445491a, this.f445492b.f445352d);     // Catch: Exception -> L7
        Bitmap.Config r102 = this.f445493c.getConfig();     // Catch: Exception -> L7
        if (r102 == null) goto L8;
        Bitmap r103 = this.f445493c;     // Catch: Exception -> L7
        IAttachToBitmapCallback r104 = this.f445494d;     // Catch: Exception -> L7
        Bitmap r105 = r103.copy(r102, true);     // Catch: Exception -> L7
        r101.setBounds(0, 0, r103.getWidth(), r103.getHeight());     // Catch: Exception -> L7
        r101.draw(new Canvas(r105));     // Catch: Exception -> L7
        r104.onAttachSuccess(r105);     // Catch: Exception -> L7
        Log.i("watermarkV3", "tryAddFileWatermarkToBitmap cost " + (System.currentTimeMillis() - r100));     // Catch: Exception -> L7
    L8:
        new Handler(Looper.getMainLooper()).post(new a(this.f445495e, this.f445496f));
        return;
    L7:
        this.f445494d.onAttachFailed(this.f445493c, "Out of memory");
        goto L8
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
