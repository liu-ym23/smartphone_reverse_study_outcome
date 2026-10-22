package com.ss.android.lark.passport.flow.auth_type;

import android.view.View;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.router.FlowStep;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthTypeActivity f437730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ButtonInfo f437731b;

    public a(AuthTypeActivity r100, ButtonInfo r101) {
        this.f437730a = r100;
        this.f437731b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AuthTypeActivity r101 = this.f437730a;
        int r102 = AuthTypeActivity.f437725f;
        AuthTypeViewModel r103 = r101.z1();
        ButtonInfo r104 = this.f437731b;
        FlowStep r105 = r104.next;
        ButtonType.a r106 = ButtonType.Companion;
        int r107 = r104.actionType;
        r106.getClass();
        r103.reduce(new AuthTypeViewModel.a.b(r105, ButtonType.a.a(r107)));
    }
}
