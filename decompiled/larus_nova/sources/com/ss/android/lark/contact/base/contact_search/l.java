package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418812a;

    public l(s r100) {
        this.f418812a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        boolean r102 = true;
        if (r101 == true) goto L5;
        s r103 = this.f418812a;
        if (r103.f418825r.getText().length() != 0) goto L13;
        r103.f418832y.setEnabled(false);
        return;
    L13:
        if (h9b.b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r103.f418825r.getText().toString().replace(" ", "")) == true) goto L15;
        r103.f418826s.setText(r103.f418825r.getText());
        r103.f418826s.setVisibility(0);
        r103.f418825r.setVisibility(8);
        ViewUtils.showToastShort(R.string.Lark_UserGrowth_InviteMemberInvalidEmail);
        r103.f418832y.setEnabled(false);
        r102 = false;
    L16:
        if (r102 == true) goto L18;
        return;
    L18:
        if (r103.A == false) goto L26;
        r103.A = false;
        s.a r104 = r103.f418821n;
        if (r104 == null) goto L27;
        r104.a(r103.f418825r.getText().toString().replace(" ", ""), false, r103.B);
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r103.f418826s.setVisibility(8);
        r103.f418825r.setVisibility(0);
        r103.f418832y.setEnabled(true);
        goto L16
    L5:
        if (this.f418812a.f418825r.getText().length() != 0) goto L7;
        this.f418812a.f418832y.setEnabled(false);
    L8:
        this.f418812a.f418825r.setVisibility(0);
        this.f418812a.f418826s.setVisibility(8);
        return;
    L7:
        this.f418812a.f418832y.setEnabled(true);
        goto L8
    }
}
