package com.ss.android.lark.compose.foundation.toast;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDToast.b f417651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f417652b;

    public c(FlowToast.c r100, b r101) {
        this.f417651a = r100;
        this.f417652b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f417651a.a(this.f417652b);
    }
}
