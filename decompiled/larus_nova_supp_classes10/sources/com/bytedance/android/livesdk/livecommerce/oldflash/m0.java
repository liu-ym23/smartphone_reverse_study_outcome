package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0 extends BaseViewHolder {
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final boolean f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ m0 a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.oldflash.b b;

        public b(m0 r1, com.bytedance.android.livesdk.livecommerce.oldflash.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveFlashViewModel r3 = this.a.a;
            if (r3 == null) goto L8;
            MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.b> r4 = r3.getItemClickObserver();
            if (r4 == null) goto L9;
            r4.postValue(this.b);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public m0(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.c = (TextView) r3.findViewById(2131390392);
        this.d = (TextView) r3.findViewById(2131390840);
        this.e = (TextView) r3.findViewById(2131391675);
        Context r4 = r3.getContext();
        ECDisplayUtils.ScreenType r0 = ECDisplayUtils.a;
        boolean r1 = false;
        if (r4 == null) goto L5;
        Resources r5 = r4.getResources();
        int r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels;
    L7:
        if (r6 >= w0.a(375.0f)) goto L9;
        r1 = true;
    L9:
        this.f = r1;
        return;
    L5:
        r6 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(com.bytedance.android.livesdk.livecommerce.oldflash.b r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        if ((r5 instanceof l) == true) goto L5;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r7 = null;
    L6:
        l r8 = (l) r7;
        if (r8 == null) goto L31;
        TextView r0 = this.c;
        String r2 = r8.c;
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        r0.setText(new StringBuilder(r2));
        this.d.setText(r8.b);
        TextView r1 = this.e;
        String r9 = r8.d;
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r1.setText(r9);
        CharSequence r10 = this.e.getText();
        if (r10 != null) goto L17;
    L22:
        TextView r11 = this.e;
        Context r3 = r11.getContext();
        if (this.f == false) goto L25;
        int r4 = 2131896587;
    L26:
        r11.setHint(th.a.g(r3, r4));
    L28:
        if (this.f == false) goto L30;
        this.d.setMaxWidth(w0.a(102.0f));
        goto L31
    L30:
        this.d.setMaxWidth(w0.a(148.0f));
        goto L31
    L25:
        r4 = 2131896586;
        goto L26
    L17:
        if (r10.length() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 != true) goto L22;
        this.e.setHint("");
        goto L28
    L19:
        r12 = false;
    L31:
        this.e.setOnClickListener(new b(this, r5));
        return;
    L5:
        r7 = r5;
        goto L6
    }
}
