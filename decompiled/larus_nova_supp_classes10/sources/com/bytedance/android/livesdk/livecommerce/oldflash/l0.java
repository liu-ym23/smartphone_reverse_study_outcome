package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.ECAutoScaleLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class l0 extends BaseViewHolder {
    public final View c;
    public final TextView d;
    public final TextView e;
    public final ECAutoScaleLayout f;
    public final TextView g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ l0 a;
        public final /* synthetic */ b b;

        public a(l0 r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveFlashViewModel r3 = this.a.a;
            if (r3 == null) goto L8;
            MutableLiveData<b> r4 = r3.getItemClickObserver();
            if (r4 == null) goto L9;
            r4.setValue(this.b);
            return;
        L9:
            return;
        }
    }

    public l0(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.c = r3.findViewById(2131376558);
        this.d = (TextView) r3.findViewById(2131390840);
        this.e = (TextView) r3.findViewById(2131390392);
        ECAutoScaleLayout r0 = r3.findViewById(2131377473);
        this.f = r0;
        this.g = (TextView) r3.findViewById(2131390395);
        this.b = r3.findViewById(2131392505);
        r0.setScaleType(1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public void T3(b r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "itemData");
        String r1 = "";
        ConstraintLayout.LayoutParams r2 = null;
        int r4 = 0;
        if ((r7 instanceof k) == false) goto L13;
        ((RecyclerView.ViewHolder) this).itemView.setPadding(0, 0, 0, 0);
        View r9 = this.c;
        k r0 = (k) r7;
        if (r0.p == false) goto L7;
        int r5 = 8;
    L8:
        r9.setVisibility(r5);
        this.d.setText(r0.b);
        TextView r10 = this.e;
        String r6 = r0.g;
        if (r6 == null) goto L11;
        r1 = r6;
    L11:
        r10.setText(r1);
        this.e.setHint(r0.o);
        this.f.setVisibility(8);
        U3(r0.a());
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new a(this, r7));
    L25:
        ConstraintLayout.LayoutParams r11 = this.e.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L29;
        r2 = r11;
    L29:
        ConstraintLayout.LayoutParams r3 = r2;
        if (r3 != null) goto L32;
        return;
    L32:
        if (this.f.getVisibility() == 8) goto L35;
        r4 = -2;
    L35:
        ((ViewGroup.MarginLayoutParams) r3).width = r4;
        this.e.setLayoutParams(r3);
        return;
    L7:
        r5 = 0;
        goto L8
    L13:
        if ((r7 instanceof h) == false) goto L25;
        LiveFlashViewModel r12 = this.a;
        if (r12 != null) goto L17;
    L19:
        ((RecyclerView.ViewHolder) this).itemView.setPadding(0, 0, 0, 0);
    L20:
        this.c.setVisibility(8);
        h r13 = (h) r7;
        this.d.setText(r13.b);
        this.e.setText(r13.c);
        this.e.setHint("");
        if (TextUtils.isEmpty(r13.d) == true) goto L23;
        this.g.setText(r13.d);
        this.f.setVisibility(0);
    L24:
        U3(false);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(null);
        goto L25
    L23:
        this.f.setVisibility(8);
        goto L24
    L17:
        if (r12.checkIsBarCodeItem(r8 - 1) != true) goto L19;
        ((RecyclerView.ViewHolder) this).itemView.setPadding(0, (int) UtilityKotlinExtentionsKt.c(30), 0, 0);
        goto L20
    }
}
