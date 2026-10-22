package com.bytedance.ee.bear.document;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public final class u6 extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ MenuItem f222444k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        this.f222444k.onClick(r100);
    }

    public u6(Drawable r100, ColorStateList r101, MenuItem r102) {
        this.f222444k = r102;
        super(r100, r101);
    }
}
