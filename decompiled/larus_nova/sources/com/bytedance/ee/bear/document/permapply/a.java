package com.bytedance.ee.bear.document.permapply;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ MenuItem f220830k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f220830k.onClick(r100);
    }

    public a(MenuItem r100, Drawable r101) {
        this.f220830k = r100;
        super(r101);
    }
}
