package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import com.larus.nova.R;
import oab.e;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRepeatBottomContainer f420356a;

    public c(CustomRepeatBottomContainer r100) {
        this.f420356a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomRepeatBottomContainer r101 = this.f420356a;
        r101.mSwitchDate.setTextColor(qab.c.a(r101.getContext(), R.color.primary_fill_default));
        CustomRepeatBottomContainer r102 = this.f420356a;
        r102.mSwitchWeek.setTextColor(qab.c.a(r102.getContext(), R.color.text_title));
        this.f420356a.mCustomRepeatMonthly.setVisibility(0);
        CustomRepeatBottomContainer r103 = this.f420356a;
        r103.a(r103.f420334c, r103.f420348q);
        this.f420356a.mChooseRepeatWeeksViewGroup.setVisibility(8);
        CustomRepeatBottomContainer r104 = this.f420356a;
        r104.f420332a = true;
        e r105 = r104.f420339h;
        if (r105 == null) goto L6;
        r105.i();
        CustomRepeatBottomContainer r106 = this.f420356a;
        r106.a(r106.f420334c, r106.f420348q);
        return;
    }
}
