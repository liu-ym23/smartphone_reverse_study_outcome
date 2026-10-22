package com.bytedance.ee.bear.bitable.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppDrawerManager f206927a;

    public d(BitableAppDrawerManager r100) {
        this.f206927a = r100;
    }

    public final void a() {
        BitableAppDrawerManager r100 = this.f206927a;
        if (r100.C == false) goto L6;
        return;
    L6:
        if (r100.f206809h.getWidth() <= com.bytedance.ee.util.ui.n.d(600)) goto L8;
        boolean r101 = true;
    L9:
        BitableAppDrawerManager r102 = this.f206927a;
        View r103 = r102.f206813l;
        if (r103 == null) goto L12;
        int r104 = r103.getMeasuredHeight();
    L13:
        if (r101 == false) goto L15;
        this.f206927a.f206814m = com.bytedance.ee.util.ui.n.d(260);
        int r105 = r104;
    L16:
        BitableAppDrawerManager r106 = this.f206927a;
        FrameLayout r107 = r106.f206810i;
        if (r107 == null) goto L19;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.width = r106.f206814m;
        r107.setLayoutParams(r108);
        r107.setTranslationX(-r106.f206814m);
        r107.setPadding(r107.getPaddingLeft(), r105, r107.getPaddingRight(), r107.getPaddingBottom());
    L19:
        BitableAppDrawerManager r109 = this.f206927a;
        View r110 = r109.f206811j;
        if (r110 != null) goto L22;
        return;
    L22:
        if (r109.f206806e.f206937g == true) goto L25;
        r110 = null;
    L25:
        if (r110 == null) goto L29;
        r110.setPadding(r110.getPaddingLeft(), r104, r110.getPaddingRight(), r110.getPaddingBottom());
        return;
    L29:
        return;
    L15:
        BitableAppDrawerManager r111 = this.f206927a;
        r111.f206814m = (int) (r111.f206809h.getWidth() * 0.88f);
        r105 = this.f206927a.b();
        goto L16
    L12:
        r104 = r102.b();
        goto L13
    L8:
        r101 = false;
        goto L9
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
