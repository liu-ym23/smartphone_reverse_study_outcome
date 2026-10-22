package com.bytedance.ee.bear.bitable.superagent;

import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements kn4.g.a {
    public final /* synthetic */ BitableSuperAgentPanel a;
    public final /* synthetic */ BitableAtEditText b;

    public final void b() {
    }

    public final void c() {
    }

    public final void a(bo4.a r4) {
        Intrinsics.checkNotNullParameter(r4, "at");
        tt5.a.h(this.a.t, "onSelectedAt: type=" + Integer.valueOf(r4.c));
        this.b.G(r4);
    }

    public e(BitableSuperAgentPanel r1, BitableAtEditText r2) {
        this.a = r1;
        this.b = r2;
    }
}
