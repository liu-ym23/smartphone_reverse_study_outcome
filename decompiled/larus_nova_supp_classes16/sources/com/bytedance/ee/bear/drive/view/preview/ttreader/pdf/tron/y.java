package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ TitleBarViewModel a;

    public y(TitleBarViewModel r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.hideOutlineMenu();
    }
}
