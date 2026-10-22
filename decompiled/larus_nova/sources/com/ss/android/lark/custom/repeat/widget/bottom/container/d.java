package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import com.larus.nova.R;
import oab.e;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRepeatBottomContainer f420357a;

    public d(CustomRepeatBottomContainer r100) {
        this.f420357a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomRepeatBottomContainer r101 = this.f420357a;
        r101.mSwitchDate.setTextColor(qab.c.a(r101.getContext(), R.color.text_title));
        CustomRepeatBottomContainer r102 = this.f420357a;
        r102.mSwitchWeek.setTextColor(qab.c.a(r102.getContext(), R.color.primary_fill_default));
        this.f420357a.mCustomRepeatMonthly.setVisibility(8);
        this.f420357a.mChooseRepeatWeeksViewGroup.setVisibility(0);
        this.f420357a.b();
        CustomRepeatBottomContainer r103 = this.f420357a;
        r103.f420332a = false;
        e r104 = r103.f420339h;
        if (r104 == null) goto L6;
        r104.f();
        CustomRepeatBottomContainer r105 = this.f420357a;
        r105.a(r105.f420334c, r105.f420348q);
        return;
    }
}
