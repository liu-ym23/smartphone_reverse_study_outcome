package com.larksuite.framework.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f285950a = 0;

    public static final class a implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<Bitmap> f285951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f285952b;

        public a(IGetDataCallback<Bitmap> r100, Bitmap r101) {
            this.f285951a = r100;
            this.f285952b = r101;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r100) {
            if (r100 != 0) goto L4;
            this.f285951a.onSuccess(this.f285952b);
            return;
        L4:
            this.f285951a.onError(new ErrorResult(r100));
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f285953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<Bitmap> f285954b;

        public b(View r100, IGetDataCallback<Bitmap> r101) {
            this.f285953a = r100;
            this.f285954b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap r100 = Bitmap.createBitmap(this.f285953a.getWidth(), this.f285953a.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L4
            Canvas r101 = new Canvas(r100);     // Catch: Throwable -> L4
            this.f285953a.draw(r101);     // Catch: Throwable -> L4
            r101.setBitmap(null);     // Catch: Throwable -> L4
            this.f285954b.onSuccess(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(View r100, Window r110, IGetDataCallback<Bitmap> r111) {
        Intrinsics.checkNotNullParameter(r110, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r100 != null) goto L6;
        Log.e("ScreenShotUtil", "getScreenshot view is null");
        r111.onError(new ErrorResult("getScreenshot view is null"));
        return;
    L6:
        int r101 = r100.getWidth();
        if (r101 > 0) goto L10;
        String r102 = "getScreenshot view.getWidth() <= 0, view.getWidth() = " + r101;
        Log.e("ScreenShotUtil", r102);
        r111.onError(new ErrorResult(r102));
        return;
    L10:
        int r103 = r100.getHeight();
        if (r103 > 0) goto L15;
        String r104 = "getScreenshot view.getHeight() <= 0, view.getWidth() = " + r103;
        Log.e("ScreenShotUtil", r104);
        r111.onError(new ErrorResult(r104));
        return;
    L15:
        if (Build.VERSION.SDK_INT < 26) goto L21;
        Bitmap r105 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        a r106 = new a(r111, r105);
        Handler r112 = new Handler(Looper.getMainLooper());
        int[] r107 = new int[2];     // Catch: Exception -> L19
        r100.getLocationInWindow(r107);     // Catch: Exception -> L19
        int r108 = r107[0];     // Catch: Exception -> L19
        PixelCopy.request(r110, new Rect(r108, r107[1], r100.getWidth() + r108, r107[1] + r100.getHeight()), r105, r106, r112);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Log.e("ScreenShotUtil", "screenshotAndroidO error", e);
        r112.post(new c0(r106));
        return;
    L21:
        UICallbackExecutor.execute(new b(r100, r111));
    }
}
