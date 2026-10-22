package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f238736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f238737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f238738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PictureDrawable f238739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f238740e;

    public l(i r100, AppCompatImageView r101, String r102, PictureDrawable r103, h r104) {
        this.f238736a = r100;
        this.f238737b = r101;
        this.f238738c = r102;
        this.f238739d = r103;
        this.f238740e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f238736a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        ImageView r101 = this.f238737b;     // Catch: Throwable -> L6
        String r102 = this.f238738c;     // Catch: Throwable -> L6
        PictureDrawable r103 = this.f238739d;     // Catch: Throwable -> L6
        h r104 = this.f238740e;     // Catch: Throwable -> L6
        float r105 = r104.f238721a;     // Catch: Throwable -> L6
        r100.a(r101, r102, r103, r104.f238722b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
