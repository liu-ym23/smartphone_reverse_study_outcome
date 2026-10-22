package com.bytedance.ee.bear.bitable.search;

import android.text.Editable;
import com.bytedance.ee.bear.bitable.common.j;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends j {
    public final /* synthetic */ BitableSearchFragment a;

    public d(BitableSearchFragment r1) {
        this.a = r1;
    }

    public final void afterTextChanged(Editable r3) {
        BitableSearchModel r0 = (BitableSearchModel) this.a.e.getValue();
        if (r0 == null) goto L12;
        ActionPayload r1 = r0.getSearchAction();
        if (r1 == null) goto L13;
        BitableSearchFragment r2 = this.a;
        if (r3 == null) goto L9;
        String r4 = r3.toString();
    L10:
        r1.setContent(r4);
        r2.f.a(r1);
        return;
    L9:
        r4 = null;
        goto L10
    L13:
        return;
    }
}
