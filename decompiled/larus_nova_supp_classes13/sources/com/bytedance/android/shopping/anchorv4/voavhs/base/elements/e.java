package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ Link a;
    public final /* synthetic */ TextElementView b;

    public e(Link r1, TextElementView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Context r0 = this.b.getContext();
        String r1 = this.a.getLinkUrl();
        if (r1 == null) goto L7;
        ECLiveHybridUtil.k(r0, r1, false, false, false, null, 252);
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }
}
