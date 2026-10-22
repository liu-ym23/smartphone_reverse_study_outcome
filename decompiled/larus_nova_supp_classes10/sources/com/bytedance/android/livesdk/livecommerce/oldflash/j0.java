package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.checkbox.ECCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 extends BaseViewHolder {
    public final TextView c;
    public final TextView d;
    public final ECCheckBox e;
    public final LinearLayout f;
    public final TextView g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ j0 d;

        public a(String r1, String r2, String r3, j0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveFlashViewModel r5 = this.d.a;
            if (r5 == null) goto L6;
            r5.postAlertDialogMessage(new String[]{this.a, this.b, this.c});
            return;
        }
    }

    public static final class b implements ECCheckBox.OnCheckedChangeListener {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final void onCheckedChanged(ECCheckBox r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "buttonView");
            this.a.d = r3;
        }
    }

    public j0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = (TextView) r2.findViewById(2131390840);
        this.d = (TextView) r2.findViewById(2131391165);
        this.e = r2.findViewById(2131365304);
        this.f = (LinearLayout) r2.findViewById(2131378807);
        this.g = (TextView) r2.findViewById(2131391166);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(com.bytedance.android.livesdk.livecommerce.oldflash.b r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        if ((r5 instanceof g) == true) goto L5;
        r5 = null;
    L5:
        g r7 = (g) r5;
        if (r7 == null) goto L32;
        this.c.setText(r7.b);
        this.d.setText(r7.g);
        String r8 = r7.e;
        boolean r1 = true;
        if (r8 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        this.g.setVisibility(8);
    L17:
        this.e.setChecked(r7.d);
        if (r7.c == false) goto L20;
        this.e.setEnabled(true);
        this.e.setClickable(true);
        this.e.setOnCheckedChangeListener(new b(r7));
        this.f.setOnClickListener(null);
        return;
    L20:
        this.e.setEnabled(false);
        this.e.setClickable(false);
        this.e.setOnCheckedChangeListener(null);
        if (r7.d == false) goto L30;
        Context r10 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        String r0 = r10.getString(2131896552);
        String r11 = r10.getString(2131896559);
        String r12 = r7.f;
        if (r12 != null) goto L25;
    L28:
        if (r1 == true) goto L34;
        this.f.setOnClickListener(new a(r0, r12, r11, this));
        return;
    L34:
        return;
    L25:
        if (r12.length() == 0) goto L28;
        r1 = false;
        goto L28
    L30:
        this.f.setOnClickListener(null);
        return;
    L16:
        this.g.setText(r7.e);
        this.g.setVisibility(0);
        goto L17
    L10:
        if (r8.length() == 0) goto L13;
        r9 = false;
        goto L14
    }
}
