package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.NativeAction;
import com.bytedance.ee.bear.bitable.uikit.ReportActionPayload;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214202c;

    public g(t r100) {
        this.f214202c = r100;
        super(350);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        gv4.a r101 = this.f214202c;
        if (r101 == null) goto L5;
        Action.Companion.getClass();
        r101.a(new NativeAction(Action.access$getTYPE_SCROLL_LEFT$cp(), null));
    L5:
        gv4.a r102 = this.f214202c;
        if (r102 == null) goto L9;
        r102.a(new ReportActionPayload("ItemViewSwitchLeft"));
        return;
    }
}
