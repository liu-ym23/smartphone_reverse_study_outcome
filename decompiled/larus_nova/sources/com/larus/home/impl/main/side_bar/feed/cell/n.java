package com.larus.home.impl.main.side_bar.feed.cell;

import android.text.Layout;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes29.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f344694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SideBarProjectHolder f344695b;

    public n(View r100, SideBarProjectHolder r101) {
        this.f344694a = r100;
        this.f344695b = r101;
    }

    public final void a() {
        Layout r100 = this.f344695b.f344651a.f344322h.getLayout();
        if (r100 == null) goto L21;
        int r101 = Math.min(r100.getLineCount(), this.f344695b.f344651a.f344322h.getMaxLines());
        int r102 = 0;
        if (r101 > 0) goto L8;
    L7:
        boolean r103 = false;
    L15:
        View r104 = this.f344695b.f344651a.f344320f;
        if (r103 == true) goto L19;
        r102 = 4;
    L19:
        r104.setVisibility(r102);
        return;
    L8:
        int r105 = r101 - 1;
        if (r100.getLineCount() <= r101) goto L11;
    L14:
        r103 = true;
        goto L15
    L11:
        if (r100.getEllipsisCount(r105) > 0) goto L14;
        if (r100.getLineEnd(r105) >= this.f344695b.f344651a.f344322h.getText().length()) goto L7;
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
