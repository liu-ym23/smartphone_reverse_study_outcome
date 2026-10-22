package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0 extends l0 {
    public final TextView h;
    public final TextView i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ f0 a;
        public final /* synthetic */ b b;

        public a(f0 r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveFlashViewModel r5 = this.a.a;
            if (r5 == null) goto L7;
            q r6 = r5.getEventHelper();
            if (r6 == null) goto L7;
            b r0 = this.b;
            r6.c(((com.bytedance.android.livesdk.livecommerce.oldflash.a) r0).b, "button", ((com.bytedance.android.livesdk.livecommerce.oldflash.a) r0).q);
        L7:
            LiveFlashViewModel r7 = this.a.a;
            if (r7 == null) goto L13;
            MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.a> r8 = r7.getBarCodeClickObserver();
            if (r8 == null) goto L14;
            r8.setValue(this.b);
            return;
        L14:
            return;
        }
    }

    public f0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.h = (TextView) r2.findViewById(2131390694);
        this.i = (TextView) r2.findViewById(2131390693);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.l0, com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        super.T3(r3, r4);
        if ((r3 instanceof com.bytedance.android.livesdk.livecommerce.oldflash.a) == true) goto L5;
        b r5 = null;
    L6:
        com.bytedance.android.livesdk.livecommerce.oldflash.a r6 = (com.bytedance.android.livesdk.livecommerce.oldflash.a) r5;
        if (r6 == null) goto L30;
        LiveFlashViewModel r0 = this.a;
        if (r0 == null) goto L25;
        if (r0.getCanLogShowSku() != true) goto L25;
        LiveFlashViewModel r1 = this.a;
        if (r1 == null) goto L25;
        if (r1.getHasLogShowSku() == true) goto L25;
        LiveFlashViewModel r2 = this.a;
        if (r2 == null) goto L19;
        r2.setHasLogShowSku(true);
    L19:
        LiveFlashViewModel r7 = this.a;
        if (r7 == null) goto L25;
        q r8 = r7.getEventHelper();
        if (r8 == null) goto L25;
        r8.a(r6.q, r6.b);
    L25:
        if (((com.bytedance.android.livesdk.livecommerce.oldflash.a) r3).q == false) goto L27;
        this.i.setText(2131896577);
        this.h.setText(2131896575);
    L28:
        this.i.setOnClickListener(new a(this, r3));
        return;
    L27:
        this.i.setText(2131896574);
        this.h.setText(2131896578);
        goto L28
    L30:
        return;
    L5:
        r5 = r3;
        goto L6
    }
}
