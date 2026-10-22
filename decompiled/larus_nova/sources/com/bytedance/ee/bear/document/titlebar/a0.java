package com.bytedance.ee.bear.document.titlebar;

import android.content.res.ColorStateList;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public final class a0 extends BaseTitleBar.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MenuItem f222195j;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        this.f222195j.onClick(r100);
    }

    public a0(CharSequence r100, ColorStateList r101, MenuItem r102) {
        this.f222195j = r102;
        super(r100, r101);
    }
}
