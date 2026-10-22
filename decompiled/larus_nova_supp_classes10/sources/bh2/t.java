package bh2;

import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements Observer<Void> {
    public final /* synthetic */ ECBaseDialogFragment a;

    public t(ECBaseDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Void r2 = (Void) r1;
        this.a.fa0();
    }
}
