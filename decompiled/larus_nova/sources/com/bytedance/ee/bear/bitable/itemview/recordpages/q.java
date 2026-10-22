package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f214223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214224c;

    public q(ItemViewRecordFooterData r100, int r101, gv4.a r102) {
        this.f214222a = r100;
        this.f214223b = r101;
        this.f214224c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ArrayList<ActionPayload> r101 = this.f214222a.getButtonActionList();
        if (r101 == null) goto L10;
        ActionPayload r102 = (ActionPayload) com.bytedance.ee.bear.bitable.m.j(r101, this.f214223b, null);
        if (r102 == null) goto L11;
        gv4.a r103 = this.f214224c;
        if (r103 == null) goto L12;
        r103.a(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
