package com.bytedance.ee.bear.document.fab;

import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FabVisibilityController extends ViewModel {
    private a delegate;

    public interface a {
        void a(boolean r1);
    }

    public void hideFab() {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.a(false);
        return;
    }

    public void showFab() {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.a(true);
        return;
    }

    public FabVisibilityController() {
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }
}
