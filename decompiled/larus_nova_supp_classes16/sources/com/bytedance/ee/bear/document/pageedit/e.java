package com.bytedance.ee.bear.document.pageedit;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ RemoveMemberFragment.UserItemViewHodler a;
    public final /* synthetic */ RemoveMemberFragment b;
    public final /* synthetic */ PageEditPlugin.UserInfo c;

    public e(RemoveMemberFragment.UserItemViewHodler r1, RemoveMemberFragment r2, PageEditPlugin.UserInfo r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        UDCheckBox r5 = this.a.b;
        r5.setChecked(!r5.isChecked());
        if (this.a.b.isChecked() == false) goto L5;
        this.b.l.add(this.c);
    L7:
        if (this.b.l.isEmpty() == false) goto L22;
        TextView r6 = this.b.n;
        if (r6 == null) goto L11;
        r6.setEnabled(false);
    L11:
        RemoveMemberFragment r7 = this.b;
        TextView r0 = r7.n;
        if (r0 == null) goto L29;
        FragmentActivity r8 = r7.getActivity();
        if (r8 == null) goto L18;
        Resources r9 = r8.getResources();
        if (r9 == null) goto L18;
        String r10 = r9.getString(2131889134);
    L19:
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        r0.setText(r10);
        return;
    L18:
        r10 = null;
        goto L19
    L29:
        return;
    L22:
        TextView r11 = this.b.n;
        if (r11 == null) goto L25;
        r11.setEnabled(true);
    L25:
        RemoveMemberFragment r12 = this.b;
        TextView r1 = r12.n;
        if (r1 == null) goto L31;
        r1.setText(UIHelper.mustacheFormat(2131889136, "num", String.valueOf(r12.l.size())));
        return;
    L31:
        return;
    L5:
        this.b.l.remove(this.c);
        goto L7
    }
}
