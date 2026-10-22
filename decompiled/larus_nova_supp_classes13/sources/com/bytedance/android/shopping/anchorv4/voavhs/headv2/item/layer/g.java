package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements x {
    public final /* synthetic */ ItemMediaLayer a;
    public final /* synthetic */ int b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void onStartPlay() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void a() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == false) goto L14;
        ItemMediaLayer r0 = this.a;
        int r1 = this.b;
        Integer r2 = r0.a;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L15;
        this.a.C(false);
        return;
    L15:
        return;
    L8:
        if (r1 != r2.intValue()) goto L10;
        r3 = true;
        goto L11
    }

    public g(ItemMediaLayer r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
