package com.bytedance.ee.bear.document;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public final class w6 extends BaseTitleBar.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MenuItem f222467l;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        this.f222467l.onClick(r100);
    }

    public w6(Drawable r100, int r101, CharSequence r102, MenuItem r103) {
        this.f222467l = r103;
        super(r100, r101, r102);
    }
}
