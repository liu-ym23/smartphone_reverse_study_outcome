package com.bytedance.ee.bear.document.fab;

import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes16.dex */
public class FabVisibilityController extends ViewModel {
    private a delegate;

    public interface a {
        void a(boolean r100);
    }

    public void hideFab() {
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.a(false);
        return;
    }

    public void showFab() {
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.a(true);
        return;
    }

    public FabVisibilityController() {
    }

    public void setDelegate(a r100) {
        this.delegate = r100;
    }
}
