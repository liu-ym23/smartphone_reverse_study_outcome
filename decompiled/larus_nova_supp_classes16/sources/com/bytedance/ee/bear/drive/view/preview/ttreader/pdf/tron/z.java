package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ PDFCtrlViewModel a;
    public final /* synthetic */ TitleBarViewModel b;

    public z(PDFCtrlViewModel r1, TitleBarViewModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        if (this.a.isShowMenu() == false) goto L6;
        this.b.showOutlineMenu();
        return;
    }
}
