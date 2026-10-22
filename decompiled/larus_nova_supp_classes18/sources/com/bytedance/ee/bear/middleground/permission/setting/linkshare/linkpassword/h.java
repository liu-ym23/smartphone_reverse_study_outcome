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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements b {
    public b.a a;
    public q b;
    public RequestPasswordView c;
    public final Context d;
    public final View e;
    public final boolean f;
    public pcb.a g;
    public ii5.h h;
    public boolean i;

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.b
    public final void P1() {
        RequestPasswordView r0 = this.c;
        Toast.showFailureText(r0.getContext(), r0.getResources().getString(2131888104), 0);
        r0.c();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.b
    public final void V5() {
        q r0 = this.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [ii5.h, ocb.a] */
    public final void create() {
        this.b = new q(this.d);
        BaseTitleBar r0 = (BaseTitleBar) this.e.findViewById(2131384386);
        if (this.f == false) goto L5;
        r0.setLeftClickListener(new ii5.f(this));
    L6:
        RequestPasswordView r1 = (RequestPasswordView) this.e.findViewById(2131384385);
        this.c = r1;
        r1.setEditTextHint(2131888108);
        this.c.setTips(2131888109);
        this.c.setOnInputPasswordListener(new ii5.g(this));
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm_mobile_ccm_space_at_doubao_reverse_in_feishu") == true) goto L14;
        View r2 = this.e;
        int r3 = n.a;
        Activity r4 = n.g(r2.getContext());
        if (r4 == null) goto L15;
        pcb.a r5 = pcb.a.a.b(r4);
        this.g = r5;
        ?? r6 = new ii5.h(this);
        this.h = r6;
        r5.c(r6);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0.setLeftIconVisibility(false);
        goto L6
    }

    public final void destroy() {
        pcb.a r0 = this.g;
        if (r0 == null) goto L7;
        ii5.h r1 = this.h;
        if (r1 == null) goto L7;
        r0.a(r1);
    L7:
        this.g = null;
        this.h = null;
        this.i = false;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.b
    public final void i0() {
        q r0 = this.b;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.a = (b.a) r1;
    }

    public h(FragmentActivity r1, View r2, boolean r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
    }
}
