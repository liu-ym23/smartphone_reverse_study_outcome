package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418809a;

    public i(s r100) {
        this.f418809a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        s r101 = this.f418809a;
        r101.A = true;
        r101.f();
        s r102 = this.f418809a;
        if (r102.f418833z == false) goto L6;
        return;
    L6:
        if (r102.f418829v.getText().length() != 0) goto L8;
        r102.f418832y.setEnabled(false);
        return;
    L8:
        String r103 = h9b.b.a(r102.f418829v.getText().toString());
        if (r102.f418828u.getText().toString().equals("+86") == false) goto L15;
        if (h9b.b.b("^[1]\\d{10}$", r103) == true) goto L13;
        r102.l();
        ViewUtils.showToastShort(R.string.Lark_UserGrowth_InviteMemberInvalidPhone);
    L17:
        boolean r104 = false;
    L20:
        if (r104 == true) goto L22;
        return;
    L22:
        if (r102.A == false) goto L29;
        r102.A = false;
        s.a r105 = r102.f418821n;
        if (r105 == null) goto L30;
        r105.a(r102.f418828u.getText() + h9b.b.a(r102.f418829v.getText().toString()), true, r102.B);
        return;
    L30:
        return;
    L29:
        return;
    L13:
        r102.m(Boolean.TRUE);
    L19:
        r104 = true;
        goto L20
    L15:
        if (h9b.b.b("^\\d{1,14}$", r103) == true) goto L18;
        r102.l();
        ViewUtils.showToastShort(R.string.Lark_UserGrowth_InviteMemberInvalidPhone);
        goto L17
    L18:
        r102.m(Boolean.TRUE);
        goto L19
    }
}
