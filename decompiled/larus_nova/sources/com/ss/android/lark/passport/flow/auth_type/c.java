package com.ss.android.lark.passport.flow.auth_type;

import android.view.View;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthTypeActivity f437733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ButtonInfo f437734b;

    public c(AuthTypeActivity r100, ButtonInfo r101) {
        this.f437733a = r100;
        this.f437734b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AuthTypeActivity r101 = this.f437733a;
        int r102 = AuthTypeActivity.f437725f;
        r101.z1().reduce(new AuthTypeViewModel.a.C5228a(this.f437734b.next));
    }
}
