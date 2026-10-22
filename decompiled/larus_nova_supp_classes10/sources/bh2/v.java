package bh2;

import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements Observer<String> {
    public final /* synthetic */ ECBaseDialogFragment a;

    public v(ECBaseDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ECBaseDialogFragment r0 = this.a;
        r0.ga0((String) r2);
    }
}
