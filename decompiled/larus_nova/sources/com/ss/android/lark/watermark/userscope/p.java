package com.ss.android.lark.watermark.userscope;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.watermark.v2.v f445481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3$generateDefaultDrawable$observer$1 f445482b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<Drawable> f445483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.watermark.v2.u f445484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WatermarkImplV3 f445485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WatermarkImplV3$generateDefaultDrawable$observer$1 f445486d;

        public a(IGetDataCallback<Drawable> r100, com.ss.android.lark.watermark.v2.u r101, WatermarkImplV3 r102, WatermarkImplV3$generateDefaultDrawable$observer$1 r103) {
            this.f445483a = r100;
            this.f445484b = r101;
            this.f445485c = r102;
            this.f445486d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IGetDataCallback<Drawable> r100 = this.f445483a;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.onSuccess(this.f445484b);     // Catch: Throwable -> L7
        L5:
            this.f445485c.f().f().removeObserver(this.f445486d);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public p(com.ss.android.lark.watermark.v2.v r100, WatermarkImplV3$generateDefaultDrawable$observer$1 r101) {
        this.f445481a = r100;
        this.f445482b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.watermark.v2.u r100 = new com.ss.android.lark.watermark.v2.u(this.f445481a, null);     // Catch: Throwable -> L4
        new Handler(Looper.getMainLooper()).post(new a(null, r100, null, this.f445482b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
