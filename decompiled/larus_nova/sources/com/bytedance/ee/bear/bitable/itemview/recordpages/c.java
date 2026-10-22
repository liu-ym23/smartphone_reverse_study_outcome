package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.ReportActionPayload;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214197a;

    public c(t r100) {
        this.f214197a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f214197a;
        if (r101 == null) goto L5;
        Action.Companion.getClass();
        r101.a(new Action(null, Action.access$getTYPE_ADD_COMMENT$cp()));
    L5:
        gv4.a r102 = this.f214197a;
        if (r102 == null) goto L9;
        r102.a(new ReportActionPayload("ItemViewClickCommentInput"));
        return;
    }
}
