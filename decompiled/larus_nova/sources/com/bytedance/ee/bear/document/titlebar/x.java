package com.bytedance.ee.bear.document.titlebar;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public final class x extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ MenuItem f222275k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        this.f222275k.onClick(r100);
    }

    public x(Drawable r100, ColorStateList r101, MenuItem r102) {
        this.f222275k = r102;
        super(r100, r101);
    }
}
