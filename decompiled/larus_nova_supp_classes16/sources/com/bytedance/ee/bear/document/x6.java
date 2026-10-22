package com.bytedance.ee.bear.document;

import android.content.res.ColorStateList;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x6 extends BaseTitleBar.e {
    public final /* synthetic */ MenuItem j;

    public final void performAction(View r2) {
        this.j.onClick(r2);
    }

    public x6(CharSequence r1, ColorStateList r2, MenuItem r3) {
        this.j = r3;
        super(r1, r2);
    }
}
