package com.ss.android.lark.inline.ai.ui.operates;

import android.view.View;
import com.ss.android.lark.inline.ai.api.ui.Operate;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OperatesAdapter f427579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Operate f427580b;

    public a(OperatesAdapter r100, Operate r101) {
        this.f427579a = r100;
        this.f427580b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OperatesAdapter.b r101 = this.f427579a.f427573b;
        if (r101 == null) goto L6;
        r101.a(this.f427580b);
        return;
    }
}
