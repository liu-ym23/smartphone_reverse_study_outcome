package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f238732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f238733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f238734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Exception f238735d;

    public k(i r100, AppCompatImageView r101, String r102, Exception r103) {
        this.f238732a = r100;
        this.f238733b = r101;
        this.f238734c = r102;
        this.f238735d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f238732a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b(this.f238733b, this.f238734c, this.f238735d);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
