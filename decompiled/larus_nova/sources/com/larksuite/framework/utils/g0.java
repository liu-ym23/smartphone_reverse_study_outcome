package com.larksuite.framework.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class g0 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f285990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f285991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f285992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f285993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f285994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f285995f;

        public final void a() {
            Rect r100 = new Rect();
            this.f285990a.getHitRect(r100);
            r100.top -= this.f285991b;
            r100.bottom += this.f285992c;
            r100.left -= this.f285993d;
            r100.right += this.f285994e;
            this.f285995f.setTouchDelegate(new TouchDelegate(r100, this.f285990a));
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

        public a(View r100, int r101, int r102, int r103, int r104, View r105) {
            this.f285990a = r100;
            this.f285991b = r101;
            this.f285992c = r102;
            this.f285993d = r103;
            this.f285994e = r104;
            this.f285995f = r105;
        }
    }

    public static void a(View r100, int r110, int r111, int r112, int r113) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = (View) r100.getParent();
        if (r101 == null) goto L9;
        r101.post(new a(r100, r110, r113, r111, r112, r101));
        return;
    L9:
        throw new RuntimeException("view set TouchDelegate must have parent view");
    }
}
