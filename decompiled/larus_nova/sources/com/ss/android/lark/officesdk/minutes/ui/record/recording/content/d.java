package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import androidx.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f436329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f436330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MmRecordingContentController f436331c;

    public d(ViewPager2 r100, String r101, MmRecordingContentController r102) {
        this.f436329a = r100;
        this.f436330b = r101;
        this.f436331c = r102;
    }

    public final void a() {
        if (this.f436329a.isAttachedToWindow() == true) goto L6;
        int r100 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "onHostConfigurationChanged", "skip detached pager, reason=" + this.f436330b, this.f436331c.c());
        return;
    L6:
        int r101 = this.f436329a.getWidth();
        int r102 = this.f436329a.getHeight();
        if (r101 <= 0) goto L22;
        if (r102 <= 0) goto L22;
        if (r101 == this.f436331c.f436307i) goto L13;
        boolean r103 = true;
    L14:
        int r104 = bwb.b.f21271a;
        bwb.b.a(MmUiLogScene.CONTENT, "onHostConfigurationChanged", "reason=" + this.f436330b + ", width=" + r101 + ", height=" + r102 + ", lastWidth=" + this.f436331c.f436307i + ", sizeChanged=" + r103, this.f436331c.c());
        MmRecordingContentController.a(this.f436331c);
        if (r103 == true) goto L17;
        return;
    L17:
        this.f436331c.f436308j = true;
        this.f436329a.requestLayout();
        MmRecordingContentController r105 = this.f436331c;
        String r106 = "config_" + this.f436330b;
        if (r105.f436309k == true) goto L24;
        r105.f436309k = true;
        r105.f436299a.b().post(new e(r105, r106));
        return;
    L24:
        return;
    L13:
        r103 = false;
    L22:
        int r107 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "onHostConfigurationChanged", "skip invalid size, reason=" + this.f436330b + ", width=" + r101 + ", height=" + r102, this.f436331c.c());
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
