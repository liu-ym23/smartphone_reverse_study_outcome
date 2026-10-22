package jw0;

import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CashExchangeDialog f500659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f500660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f500661c;

    public e(CashExchangeDialog r100, long r101, long r102) {
        this.f500659a = r100;
        this.f500660b = r101;
        this.f500661c = r102;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        int r102 = h.f500665a;
        long r103 = this.f500660b;
        long r104 = this.f500661c;
        long r105 = r103 + r104;
        CashExchangeDialog r106 = this.f500659a;
        int r107 = r106.f89886k;
        ToggleButton r108 = r106.f89882g;
        if (r108 == null) goto L5;
        Boolean r109 = Boolean.valueOf(r108.isChecked());
    L6:
        h.c(r105, r104, r107, 3, r109);
        return;
    L5:
        r109 = null;
        goto L6
    }
}
