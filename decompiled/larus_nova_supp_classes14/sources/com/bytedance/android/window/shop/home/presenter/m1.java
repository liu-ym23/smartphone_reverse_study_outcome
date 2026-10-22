package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m1 implements Runnable {
    public final /* synthetic */ ECWindowInfoPresenterBase a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ String c;

    public m1(ECWindowInfoPresenterBase r1, TextView r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (zq3.l.b() == true) goto L5;
    L8:
        int r1 = 0;
        ECWindowInfoPresenterBase.Z(this.a).setVisibility(0);
        int r0 = ECWindowInfoPresenterBase.Z(this.a).getWidth() - this.a.w().b(2131390976).f().getWidth();
        View r2 = ECWindowInfoPresenterBase.Z(this.a).findViewById(2131370894);
        if (r2 == null) goto L11;
        r1 = r2.getWidth();
    L11:
        float r3 = r0 - r1;
        int r4 = com.bytedance.android.shopping.utils.k0.a;
        com.bytedance.android.shopping.utils.k0.d(this.b, this.c, r3);
        if (this.a.d0() == false) goto L18;
        float r5 = this.b.getPaint().measureText(this.b.getText().toString());
        ViewGroup r6 = ECWindowInfoPresenterBase.Z(this.a);
        int r7 = (((int) r5) + this.a.w().b(2131390976).f().getWidth()) + this.a.w().b(2131392503).f().getWidth();
        this.a.w().b(2131370878).f().getLayoutParams().width -= ECWindowInfoPresenterBase.Z(this.a).getWidth() - r7;
        r6.getLayoutParams().width = r7;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if (r8 == null) goto L17;
        ((LinearLayout.LayoutParams) r8).weight = 0.0f;
        ECWindowInfoPresenterBase.Z(this.a).requestLayout();
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L18:
        return;
    L5:
        if (this.a.d0() == false) goto L8;
        this.b.setText(this.c);
        this.b.setSelected(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
