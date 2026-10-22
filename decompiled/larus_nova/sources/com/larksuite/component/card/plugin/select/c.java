package com.larksuite.component.card.plugin.select;

import android.content.Context;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends com.larksuite.component.ui.dialog.d.a<LKUIDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f283829a;

    public c(Context r100) {
        this.f283829a = r100;
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void a(LKUIDialog r100) {
        r100.getContext();
        j08.a r101 = new j08.a(r100.getWindow());
        r101.f496833b = UDColorUtils.getColor(this.f283829a, R.color.bg_body);
        r101.a();
    }
}
