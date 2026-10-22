package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity>.e f207605a;

    public i(f<IChatterEntity>.e r100) {
        this.f207605a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f207605a.f207595n;
        r101.setChecked(!r101.isChecked());
    }
}
