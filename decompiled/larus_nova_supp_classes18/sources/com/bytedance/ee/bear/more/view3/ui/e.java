package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.more.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class e extends a {
    public final boolean n;
    public final boolean o;
    public final String p;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public int e() {
        return i(2131563690, 2131563691);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public void a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        super.a(r11);
        AppCompatImageView r1 = r11.findViewById(2131374718);
        TextView r2 = (TextView) r11.findViewById(2131388772);
        TextView r3 = (TextView) r11.findViewById(2131387252);
        UDBadgeView r4 = r11.findViewById(2131363831);
        TextView r5 = (TextView) r11.findViewById(2131380689);
        TextView r6 = (TextView) r11.findViewById(2131373298);
        g(r1, r2, null);
        int r8 = 0;
        if (this.p.length() <= 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        int r9 = 0;
    L10:
        r3.setVisibility(r9);
        r3.setText(this.p);
        if (this.n == true) goto L13;
    L17:
        int r10 = 8;
    L18:
        r4.setVisibility(r10);
        if (this.o == false) goto L24;
        if ((r2.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L24;
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        r13.setMarginEnd(y9c.d.a(40));
        r2.setLayoutParams(r13);
    L24:
        if (this.o == true) goto L26;
    L30:
        r8 = 8;
    L31:
        r5.setVisibility(r8);
        if (r6 == null) goto L34;
        r6.setVisibility(8);
    L34:
        Intrinsics.checkNotNullParameter(r11, "itemView");
        r11.setOnClickListener(new b(this, null));
        return;
    L26:
        if (this.h == false) goto L30;
        if (k.b(this.a) == false) goto L30;
    L13:
        if (this.h == false) goto L17;
        if (k.a(this.a) == false) goto L17;
        r10 = 0;
        goto L18
    L9:
        r9 = 8;
        goto L10
    L5:
        r7 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public boolean f(com.bytedance.ee.bear.more.protocol3.k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof e) == false) goto L25;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L25;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L25;
        if (this.f != r4.f) goto L25;
        if (this.g != r4.g) goto L25;
        if (this.n != r4.n) goto L25;
        if (this.o != r4.o) goto L25;
        if (Intrinsics.areEqual(this.p, r4.p) == false) goto L25;
        if (this.h != r4.h) goto L25;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L25;
        if (Intrinsics.areEqual(this.c, r4.c) == false) goto L25;
        return true;
    L25:
        return false;
    }

    public e(String r11, String r12, int r13, int r14, boolean r15, boolean r16, String r17, boolean r18, String r19, View.OnClickListener r20) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r17, "label");
        Intrinsics.checkNotNullParameter(r19, "disableReason");
        super(r11, r12, r13, r14, r18, r19, r20);
        this.n = r15;
        this.o = r16;
        this.p = r17;
    }
}
