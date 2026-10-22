package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;

/* JADX INFO: loaded from: classes16.dex */
public final class z<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlViewModel f225457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TitleBarViewModel f225458b;

    public z(PDFCtrlViewModel r100, TitleBarViewModel r101) {
        this.f225457a = r100;
        this.f225458b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (this.f225457a.isShowMenu() == false) goto L6;
        this.f225458b.showOutlineMenu();
        return;
    }
}
