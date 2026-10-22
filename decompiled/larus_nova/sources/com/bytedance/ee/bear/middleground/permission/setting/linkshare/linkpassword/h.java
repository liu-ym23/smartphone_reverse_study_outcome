package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.q;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.a f234181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f234182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RequestPasswordView f234183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f234184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f234185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f234186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pcb.a f234187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ii5.h f234188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f234189i;

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.b
    public final void P1() {
        RequestPasswordView r100 = this.f234183c;
        Toast.showFailureText(r100.getContext(), r100.getResources().getString(R.string.Doc_Permission_PasswordError), 0);
        r100.c();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.b
    public final void V5() {
        q r100 = this.f234182b;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [ii5.h, ocb.a] */
    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f234182b = new q(this.f234184d);
        BaseTitleBar r100 = (BaseTitleBar) this.f234185e.findViewById(R.id.request_password_title);
        if (this.f234186f == false) goto L5;
        r100.setLeftClickListener(new ii5.f(this));
    L6:
        RequestPasswordView r101 = (RequestPasswordView) this.f234185e.findViewById(R.id.request_password_container);
        this.f234183c = r101;
        r101.setEditTextHint(R.string.Doc_Permission_PleaseEnterPassowrd);
        this.f234183c.setTips(R.string.Doc_Permission_PleaseEnterPasswordAccess);
        this.f234183c.setOnInputPasswordListener(new ii5.g(this));
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm_mobile_ccm_space_at_doubao_reverse_in_feishu") == true) goto L14;
        View r102 = this.f234185e;
        int r103 = n.f243167a;
        Activity r104 = n.g(r102.getContext());
        if (r104 == null) goto L15;
        pcb.a r105 = pcb.a.AbstractC7181a.b(r104);
        this.f234187g = r105;
        ?? r106 = new ii5.h(this);
        this.f234188h = r106;
        r105.c(r106);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r100.setLeftIconVisibility(false);
        goto L6
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        pcb.a r100 = this.f234187g;
        if (r100 == null) goto L7;
        ii5.h r101 = this.f234188h;
        if (r101 == null) goto L7;
        r100.a(r101);
    L7:
        this.f234187g = null;
        this.f234188h = null;
        this.f234189i = false;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.b
    public final void i0() {
        q r100 = this.f234182b;
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f234181a = (b.a) r100;
    }

    public h(FragmentActivity r100, View r101, boolean r102) {
        this.f234184d = r100;
        this.f234185e = r101;
        this.f234186f = r102;
    }
}
