package com.bytedance.ee.bear.bitable.plugin.more;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f214935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableTitleMorePlugin.a f214936b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        tt5.a.h("BitableTitleMorePlugin", "toShowMenusCallback");
        this.f214935a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (BitableTitleMorePlugin.access$300(this.f214936b.f214929a) != null) goto L6;
        tt5.a.d("BitableTitleMorePlugin", "showMenus return for mMenuPanel is null.");
        return;
    L6:
        BitableTitleMorePlugin.access$300(this.f214936b.f214929a).b(this.f214935a);
    }

    public e(BitableTitleMorePlugin.a r100, View r101) {
        this.f214936b = r100;
        this.f214935a = r101;
    }
}
