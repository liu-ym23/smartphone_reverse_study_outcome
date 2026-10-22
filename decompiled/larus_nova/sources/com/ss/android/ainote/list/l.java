package com.ss.android.ainote.list;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f407085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f407086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f407087c;

    public l(AppCompatImageView r100, int r101, View r102) {
        this.f407085a = r100;
        this.f407086b = r101;
        this.f407087c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rect r100 = new Rect();     // Catch: Throwable -> L4
        this.f407085a.getHitRect(r100);     // Catch: Throwable -> L4
        int r101 = -this.f407086b;
        r100.inset(r101, r101);     // Catch: Throwable -> L4
        this.f407087c.setTouchDelegate(new TouchDelegate(r100, this.f407085a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
