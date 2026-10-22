package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 extends BaseViewHolder {
    public final RadioGroup c;
    public final TextView d;

    public static final class a implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup r1, int r2) {
            if (r2 != 2131383719) goto L5;
            this.a.d = 1;
            return;
        L5:
            this.a.d = 2;
        }
    }

    public k0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = (RadioGroup) r2.findViewById(2131384496);
        RadioButton r0 = (RadioButton) r2.findViewById(2131383719);
        RadioButton r1 = (RadioButton) r2.findViewById(2131383720);
        this.d = (TextView) r2.findViewById(2131390840);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        if ((r2 instanceof j) == true) goto L5;
        r2 = null;
    L5:
        j r4 = (j) r2;
        if (r4 == null) goto L13;
        this.d.setText(r4.b);
        if (r4.d != 1) goto L10;
        this.c.check(2131383719);
    L11:
        this.c.setOnCheckedChangeListener(new a(r4));
        return;
    L10:
        this.c.check(2131383720);
        goto L11
    }
}
