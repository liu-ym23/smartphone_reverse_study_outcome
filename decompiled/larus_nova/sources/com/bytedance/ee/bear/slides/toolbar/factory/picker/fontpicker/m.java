package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f238741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f238742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f238743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j.a f238744d;

    public m(c r100, AppCompatImageView r101, String r102, j.a r103) {
        this.f238741a = r100;
        this.f238742b = r101;
        this.f238743c = r102;
        this.f238744d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f238741a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        AppCompatImageView r101 = this.f238742b;     // Catch: Throwable -> L6
        String r102 = this.f238743c;     // Catch: Throwable -> L6
        j.a r103 = this.f238744d;     // Catch: Throwable -> L6
        r100.a(r101, r102, r103.f238729a, r103.f238731c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
