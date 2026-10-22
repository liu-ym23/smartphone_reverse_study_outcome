package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c1 implements View.OnClickListener {
    public final /* synthetic */ PermApplyFragment a;

    public c1(PermApplyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        rcb.c.d(r12);
        PermApplyFragment r13 = this.a;
        int r0 = PermApplyFragment.q;
        FragmentActivity r1 = r13.getActivity();
        if (r1 == null) goto L25;
        com.bytedance.ee.bear.widgets.a r2 = new com.bytedance.ee.bear.widgets.a(r1);
        CharSequence r3 = r1.getText(2131887806);
        g1 r4 = new g1(r13);
        PermApplyViewModel.PermType r5 = (PermApplyViewModel.PermType) r13.Z90().getPermType().getValue();
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L13;
        int r7 = r1.getResources().getColor(2131105548);
    L14:
        cp5.b r9 = new cp5.b();
        r9.a = r3;
        r9.d = false;
        r9.e = null;
        r9.f = r4;
        r9.c = false;
        r9.b = r7;
        r9.g = true;
        r9.h = 1.0f;
        r9.i = true;
        r2.f(r9);
        CharSequence r8 = r1.getText(2131887750);
        h1 r10 = new h1(r13);
        PermApplyViewModel.PermType r14 = (PermApplyViewModel.PermType) r13.Z90().getPermType().getValue();
        if (r14 != null) goto L17;
    L19:
        boolean r15 = false;
    L20:
        if (r15 == false) goto L22;
        int r16 = r1.getResources().getColor(2131105548);
    L23:
        cp5.b r11 = new cp5.b();
        r11.a = r8;
        r11.d = false;
        r11.e = null;
        r11.f = r10;
        r11.c = false;
        r11.b = r16;
        r11.g = true;
        r11.h = 1.0f;
        r11.i = true;
        r2.f(r11);
        r2.a();
        r2.q();
        return;
    L22:
        r16 = r1.getResources().getColor(2131106622);
        goto L23
    L17:
        if (r14.getCode() != 4) goto L19;
        r15 = true;
        goto L20
    L13:
        r7 = r1.getResources().getColor(2131106622);
        goto L14
    L7:
        if (r5.getCode() != 1) goto L9;
        r6 = true;
        goto L11
    }
}
