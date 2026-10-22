package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o0 implements View.OnClickListener {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ s b;
    public final /* synthetic */ int c;

    public o0(p0 r1, s r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.c.invoke(Integer.valueOf(this.b.c), Integer.valueOf(this.c));
    }
}
