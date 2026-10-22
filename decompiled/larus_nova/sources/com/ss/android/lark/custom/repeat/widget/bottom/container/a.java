package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import android.widget.AdapterView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.utils.UIHelper;
import mab.g;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRepeatBottomContainer f420354a;

    public a(CustomRepeatBottomContainer r100) {
        this.f420354a = r100;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        CustomRepeatBottomContainer r104 = this.f420354a;
        nab.a r105 = r104.f420347p;
        if (r105.f518489e == false) goto L10;
        g r106 = r104.f420333b;
        if (r106.f512738c != r102) goto L10;
        if (r105.f518491g == null) goto L12;
        String r107 = r106.a(r102);
        String r108 = UIHelper.mustacheFormat(this.f420354a.f420347p.f518491g.intValue(), "Type", r107);
        LKUIToast.show(this.f420354a.getContext(), r108);
        return;
    L12:
        return;
    L10:
        r104.f420333b.e(r102);
        CustomRepeatBottomContainer r109 = this.f420354a;
        r109.a(r109.f420333b, r109.f420349r);
    }
}
