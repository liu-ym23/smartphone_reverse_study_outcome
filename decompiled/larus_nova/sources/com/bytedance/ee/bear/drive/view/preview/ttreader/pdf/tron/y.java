package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;

/* JADX INFO: loaded from: classes16.dex */
public final class y<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleBarViewModel f225448a;

    public y(TitleBarViewModel r100) {
        this.f225448a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f225448a.hideOutlineMenu();
    }
}
