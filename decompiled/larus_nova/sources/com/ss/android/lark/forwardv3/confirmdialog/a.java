package com.ss.android.lark.forwardv3.confirmdialog;

import android.view.View;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardConfirmDialogAdapter.a f425264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchBaseInfo f425265b;

    public a(ForwardConfirmDialogAdapter.a r100, SearchBaseInfo r101) {
        this.f425264a = r100;
        this.f425265b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f425264a.a(this.f425265b);
    }
}
