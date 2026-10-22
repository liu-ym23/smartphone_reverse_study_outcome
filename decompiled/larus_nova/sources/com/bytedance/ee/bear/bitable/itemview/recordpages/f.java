package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.NativeAction;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214201c;

    public f(t r100) {
        this.f214201c = r100;
        super(350);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        gv4.a r101 = this.f214201c;
        if (r101 == null) goto L6;
        Action.Companion.getClass();
        r101.a(new NativeAction(Action.access$getTYPE_SCROLL_RIGHT$cp(), null));
        return;
    }
}
