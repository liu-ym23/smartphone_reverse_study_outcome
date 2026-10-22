package com.bytedance.ee.bear.document.plugin.permapply;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends BaseTitleBar.c {
    public final /* synthetic */ MenuItem k;

    public final void performAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.k.onClick(r2);
    }

    public a(MenuItem r1, Drawable r2) {
        this.k = r1;
        super(r2);
    }
}
