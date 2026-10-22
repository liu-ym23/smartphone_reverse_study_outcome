package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsLinearLayoutManager extends LinearLayoutManager {
    public boolean a;

    public final boolean canScrollVertically() {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically() == false) goto L7;
        return true;
    }

    public DocsLinearLayoutManager(Context r1) {
        super(r1);
        this.a = true;
    }

    public DocsLinearLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.a = true;
    }
}
