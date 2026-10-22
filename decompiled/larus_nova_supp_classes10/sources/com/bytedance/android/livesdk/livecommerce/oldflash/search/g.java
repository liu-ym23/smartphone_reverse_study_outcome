package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.view.View;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ LiveFlashSearchDialogFragment a;

    public g(LiveFlashSearchDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        ECSearchBar r0 = this.a.ia0(2131385326);
        int r1 = 0;
        if (r0 != null) goto L5;
    L9:
        View r2 = this.a.ia0(2131377932);
        if (r2 != null) goto L12;
        return;
    L12:
        if (r5.booleanValue() == true) goto L15;
        r1 = 4;
    L15:
        r2.setVisibility(r1);
        return;
    L5:
        if (r5.booleanValue() == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        goto L9
    L7:
        r3 = 8;
        goto L8
    }
}
