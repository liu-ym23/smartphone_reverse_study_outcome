package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f431757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f431758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f431759c;

    public d(View r100, int r101, View r102) {
        this.f431757a = r100;
        this.f431758b = r101;
        this.f431759c = r102;
    }

    public final void a() {
        Rect r100 = new Rect();
        this.f431757a.getHitRect(r100);
        int r101 = r100.width();
        int r102 = r100.height();
        int r103 = RangesKt.coerceAtLeast(this.f431758b - r101, 0) / 2;
        int r104 = RangesKt.coerceAtLeast(this.f431758b - r102, 0) / 2;
        r100.inset(-r103, -r104);
        this.f431759c.setTouchDelegate(new TouchDelegate(r100, this.f431757a));
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
