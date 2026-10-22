package com.bytedance.android.livesdk.livecommerce.oldflash;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public y(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        if (r4 == null) goto L8;
        LiveFlashListAdapter r0 = this.a.l;
        if (r0 == null) goto L9;
        ((ArrayList) r0.a).clear();
        ArrayList r1 = (ArrayList) r0.a;
        r1.addAll(r4);
        r0.notifyDataSetChanged();
        return;
    L9:
        return;
    }
}
