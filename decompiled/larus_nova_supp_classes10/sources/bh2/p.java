package bh2;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Observer<Integer> {
    public final /* synthetic */ ECBaseDialogFragment a;

    public p(ECBaseDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        Context r0 = this.a.getContext();
        if (r0 == null) goto L6;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r0, th.a.g(r0, r3.intValue()));
        return;
    }
}
