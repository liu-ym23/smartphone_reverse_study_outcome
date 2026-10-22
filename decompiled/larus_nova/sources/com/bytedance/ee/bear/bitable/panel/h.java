package com.bytedance.ee.bear.bitable.panel;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableViewPanelFragment f214851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f214852b;

    public h(BitableViewPanelFragment r100, SimpleItemModel r101) {
        this.f214851a = r100;
        this.f214852b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f214851a.f214823J;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("actionHandler");
        r101 = null;
    L6:
        r101.a(new Action(this.f214852b.getId(), this.f214852b.getClickAction()));
    }
}
