package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.more.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends a {
    public final boolean n;
    public final View.OnClickListener o;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(2131563684, 2131563685);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r6) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        super.a(r6);
        AppCompatImageView r1 = (AppCompatImageView) r6.findViewById(2131374718);
        TextView r2 = (TextView) r6.findViewById(2131388772);
        TextView r3 = (TextView) r6.findViewById(2131380689);
        g(r1, r2, (ImageView) r6.findViewById(2131380891));
        if (this.n == true) goto L5;
    L9:
        int r4 = 8;
    L10:
        r3.setVisibility(r4);
        View.OnClickListener r5 = this.o;
        Intrinsics.checkNotNullParameter(r6, "itemView");
        r6.setOnClickListener(new b(this, r5));
        return;
    L5:
        if (this.h == false) goto L9;
        if (k.b(this.a) == false) goto L9;
        r4 = 0;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(com.bytedance.ee.bear.more.protocol3.k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof h) == false) goto L23;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L23;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L23;
        if (this.f != r4.f) goto L23;
        if (this.g != r4.g) goto L23;
        if (this.n != r4.n) goto L23;
        if (this.h != r4.h) goto L23;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L23;
        if (Intrinsics.areEqual(this.o, r4.o) == false) goto L23;
        if (Intrinsics.areEqual(this.c, r4.c) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public h(String r10, String r11, int r12, int r13, boolean r14, boolean r15, String r16, View.OnClickListener r17, View.OnClickListener r18) {
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r16, "disableReason");
        super(r10, r11, r12, r13, r15, r16, r17);
        this.n = r14;
        this.o = r18;
    }
}
