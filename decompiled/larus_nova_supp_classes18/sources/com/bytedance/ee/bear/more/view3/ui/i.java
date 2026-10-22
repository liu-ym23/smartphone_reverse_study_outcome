package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends a {
    public final String n;
    public final View.OnClickListener o;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(2131563686, 2131563687);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super.a(r5);
        AppCompatImageView r0 = (AppCompatImageView) r5.findViewById(2131374718);
        TextView r1 = (TextView) r5.findViewById(2131388772);
        TextView r2 = (TextView) r5.findViewById(2131384554);
        r2.setTag("right_button");
        r5.setTag("item");
        g(r0, r1, null);
        r2.setText(this.n);
        r2.setEnabled(this.h);
        if (this.h == false) goto L5;
        b r3 = new b(this, this.o);
        r2.setOnClickListener(r3);
        r5.setOnClickListener(r3);
        return;
    L5:
        r2.setOnClickListener(null);
        r5.setOnClickListener(this.o);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof i) == false) goto L21;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L21;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L21;
        if (this.f != r4.f) goto L21;
        if (this.g != r4.g) goto L21;
        if (this.h != r4.h) goto L21;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L21;
        if (Intrinsics.areEqual(this.n, r4.n) == false) goto L21;
        if (Intrinsics.areEqual(this.c, r4.c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public i(String r11, String r12, int r13, int r14, boolean r15, String r16, String r17, View.OnClickListener r18, View.OnClickListener r19) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r17, "rightButtonText");
        super(r11, r12, r13, r14, r15, r16, r18);
        this.n = r17;
        this.o = r19;
    }
}
