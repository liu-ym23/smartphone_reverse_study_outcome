package bh2;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements Observer<String> {
    public final /* synthetic */ ECBaseDialogFragment a;

    public o(ECBaseDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Context r0 = this.a.getContext();
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r0, (String) r2);
    }
}
