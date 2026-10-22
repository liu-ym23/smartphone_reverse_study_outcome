package com.bytedance.android.shopping.mall.homepage.card.video;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ NativeVideoCard a;

    public e(NativeVideoCard r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        NativeVideoCard r4 = this.a;
        String r0 = r4.R;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.v1 != null) goto L7;
    L9:
        boolean r5 = false;
    L11:
        if (this.a.v1 == null) goto L13;
        g93.a.b(r0, r5);
    L13:
        NativeVideoCard r1 = this.a;
        r1.N4(r5, ((Boolean) r1.b1.getValue()).booleanValue());
        return;
    L7:
        if (g93.a.a(r0) == true) goto L9;
        r5 = true;
        goto L11
    }
}
