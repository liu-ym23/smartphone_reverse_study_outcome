package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends e {
    public final boolean q;
    public final boolean r;
    public final String s;
    public final boolean t;
    public final int u;
    public final int v;

    @Override // com.bytedance.ee.bear.more.view3.ui.e, com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return 2131563681;
    }

    @Override // com.bytedance.ee.bear.more.view3.ui.e, com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r6) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        super.a(r6);
        if (this.h == true) goto L5;
    L7:
        ((TextView) r6.findViewById(2131387252)).setVisibility(8);
    L9:
        if (this.u != (-1)) goto L11;
    L15:
        r6.findViewById(2131374796).setVisibility(8);
        return;
    L11:
        if (this.t == false) goto L15;
        r6.findViewById(2131374796).setVisibility(0);
        r6.findViewById(2131374796).setImageResource(this.u);
        if (this.v == (-1)) goto L17;
        l.c((ImageView) r6.findViewById(2131374796), this.v);
        return;
    L17:
        return;
    L5:
        if (this.t == false) goto L7;
        ((TextView) r6.findViewById(2131387252)).setVisibility(0);
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.view3.ui.e, com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof d) == false) goto L29;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L29;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L29;
        if (this.f != r4.f) goto L29;
        if (this.g != r4.g) goto L29;
        if (this.q != r4.q) goto L29;
        if (this.r != r4.r) goto L29;
        if (Intrinsics.areEqual(this.s, r4.s) == false) goto L29;
        if (this.h != r4.h) goto L29;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L29;
        if (this.t != r4.t) goto L29;
        if (this.u != r4.u) goto L29;
        if (Intrinsics.areEqual(this.c, r4.c) == false) goto L29;
        return true;
    L29:
        return false;
    }

    public d(String r14, String r15, int r16, int r17, boolean r18, String r19, boolean r20, String r21, View.OnClickListener r22, boolean r23, int r24, int r25) {
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r15, "title");
        Intrinsics.checkNotNullParameter(r19, "label");
        Intrinsics.checkNotNullParameter(r21, "disableReason");
        super(r14, r15, r16, r17, false, r18, r19, r20, r21, r22);
        this.q = false;
        this.r = r18;
        this.s = r19;
        this.t = r23;
        this.u = r24;
        this.v = r25;
    }
}
