package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceListRvView f240779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpaceBean f240780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f240781c;

    public d(WikiSpaceListRvView r100, SpaceBean r101, int r102) {
        this.f240779a = r100;
        this.f240780b = r101;
        this.f240781c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiSpaceListRvView.a r101 = this.f240779a.getViewDelegate();
        if (r101 == null) goto L6;
        r101.a(this.f240780b, this.f240781c);
        return;
    }
}
