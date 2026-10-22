package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ LiveFlashMultiSelectDialogFragment a;

    public f(LiveFlashMultiSelectDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        LiveFlashMultiSelectListAdapter r0 = this.a.m;
        if (r0 == null) goto L9;
        ((ArrayList) r0.a).clear();
        if (r4 == null) goto L7;
        ArrayList r1 = (ArrayList) r0.a;
        r1.addAll(r4);
    L7:
        r0.notifyDataSetChanged();
        return;
    }
}
