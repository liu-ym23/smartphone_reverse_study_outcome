package com.bytedance.ee.bear.bitable.itemview.record;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.NativeAction;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214055c;

    public b(gv4.a r100) {
        this.f214055c = r100;
        super(350);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        gv4.a r101 = this.f214055c;
        if (r101 == null) goto L6;
        Action.Companion.getClass();
        r101.a(new NativeAction(Action.access$getTYPE_BACK$cp(), null));
        return;
    }
}
