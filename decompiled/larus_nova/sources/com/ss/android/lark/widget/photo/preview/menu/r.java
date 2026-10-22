package com.ss.android.lark.widget.photo.preview.menu;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f447014a;

    public r(q r100) {
        this.f447014a = r100;
    }

    public final void a() {
        com.ss.android.lark.widget.photo.preview.ocr.menu.b r100 = this.f447014a.f447006a.b();
        if (r100 == null) goto L9;
        com.larksuite.common_selection.i r101 = r100.f447105a;
        if (r101 == null) goto L9;
        if (r101.h() != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return;
    L12:
        Integer r103 = this.f447014a.a().getValue();
        if (r103 != null) goto L15;
    L16:
        View r104 = (View) this.f447014a.f447008c.getValue();
        AlphaAnimation r105 = new AlphaAnimation(1.0f, 0.0f);
        r105.setDuration(200);
        r105.setFillAfter(true);
        r105.setAnimationListener(new x(r104));
        r104.startAnimation(r105);
        return;
    L15:
        if (r103.intValue() == 100) goto L16;
        return;
    L9:
        r102 = false;
        goto L10
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
