package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.ReportActionPayload;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214199b;

    public d(ItemViewRecordFooterData r100, t r101) {
        this.f214198a = r100;
        this.f214199b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f214198a.getCommentCount() <= 0) goto L10;
        gv4.a r101 = this.f214199b;
        if (r101 == null) goto L7;
        Action.Companion.getClass();
        r101.a(new Action(null, Action.access$getTYPE_OPEN_COMMENT$cp()));
    L7:
        gv4.a r102 = this.f214199b;
        if (r102 == null) goto L17;
        r102.a(new ReportActionPayload("ItemViewClickComment"));
        return;
    L17:
        return;
    L10:
        gv4.a r103 = this.f214199b;
        if (r103 == null) goto L13;
        Action.Companion.getClass();
        r103.a(new Action(null, Action.access$getTYPE_ADD_COMMENT$cp()));
    L13:
        gv4.a r104 = this.f214199b;
        if (r104 == null) goto L19;
        r104.a(new ReportActionPayload("ItemViewClickCommentInput"));
        return;
    }
}
