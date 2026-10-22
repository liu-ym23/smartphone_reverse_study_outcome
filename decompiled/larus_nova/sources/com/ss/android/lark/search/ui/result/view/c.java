package com.ss.android.lark.search.ui.result.view;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CeilingExpandFoldBar f440355a;

    public c(CeilingExpandFoldBar r100) {
        this.f440355a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CeilingExpandFoldBar r101 = this.f440355a;
        boolean r102 = !r101.f440325b;
        r101.f440325b = r102;
        TextView r103 = r101.f440326c;
        if (r102 == true) goto L5;
        r101.f440327d.setImageDrawable(r101.f440328e);
        String r104 = UIHelper.getString(R.string.Lark_ASLSearch_Contacts_ShowFullDepartment_Button);
    L6:
        r103.setText(r104);
        this.f440355a.getClass();
        return;
    L5:
        r101.f440327d.setImageDrawable(r101.f440329f);
        r104 = UIHelper.getString(R.string.Lark_ASLSearch_Contacts_HideFullDepartment_Button);
        goto L6
    }
}
