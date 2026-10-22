package com.bytedance.ee.bear.document.titlebar;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x extends BaseTitleBar.c {
    public final /* synthetic */ MenuItem k;

    public final void performAction(View r2) {
        this.k.onClick(r2);
    }

    public x(Drawable r1, ColorStateList r2, MenuItem r3) {
        this.k = r3;
        super(r1, r2);
    }
}
