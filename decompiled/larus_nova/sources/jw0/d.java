package jw0;

import android.view.View;
import android.widget.ToggleButton;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CashExchangeDialog f500658a;

    public d(CashExchangeDialog r100) {
        this.f500658a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ToggleButton r101 = this.f500658a.f89882g;
        if (r101 == null) goto L12;
        boolean r102 = true;
        if (r101 != null) goto L7;
    L10:
        r101.setChecked(r102);
        return;
    L7:
        if (r101.isChecked() != true) goto L10;
        r102 = false;
        goto L10
    }
}
