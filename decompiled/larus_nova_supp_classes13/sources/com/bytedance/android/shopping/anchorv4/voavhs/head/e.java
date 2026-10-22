package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AnchorV4HeadView a;

    public e(AnchorV4HeadView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        AnchorV4VM r4 = this.a.h;
        if (r4 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.containers.g r5 = r4.containerAbility();
        if (r5 == null) goto L9;
        r5.b(true, true, false);
        return;
    L9:
        return;
    }
}
