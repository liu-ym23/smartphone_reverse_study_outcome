package com.bytedance.ee.bear.document;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w6 extends BaseTitleBar.d {
    public final /* synthetic */ MenuItem l;

    public final void performAction(View r2) {
        this.l.onClick(r2);
    }

    public w6(Drawable r1, int r2, CharSequence r3, MenuItem r4) {
        this.l = r4;
        super(r1, r2, r3);
    }
}
