package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECHostNetErrorLayoutImpl extends ECHostNetErrorLayout {
    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostNetErrorLayout
    public int getGrayColor() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostNetErrorLayout
    public final TextView a() {
        View r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return (TextView) r0.findViewById(2131391305);
    }

    public ECHostNetErrorLayoutImpl(Context r1) {
        super(r1);
    }

    public ECHostNetErrorLayoutImpl(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ECHostNetErrorLayoutImpl(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
