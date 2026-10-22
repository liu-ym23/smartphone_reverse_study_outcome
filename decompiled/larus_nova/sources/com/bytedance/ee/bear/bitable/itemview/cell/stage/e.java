package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f213973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.universe_design.menu.c f213974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f213975c;

    public e(View r100, com.larksuite.component.universe_design.menu.c r101, AppCompatImageView r102) {
        this.f213973a = r100;
        this.f213974b = r101;
        this.f213975c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ViewParent r101 = this.f213973a.getParent();
        if (r101 != null) goto L5;
    L7:
        this.f213974b.b(this.f213975c);
        return;
    L5:
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r101).removeAllViews();
        goto L7
    }
}
