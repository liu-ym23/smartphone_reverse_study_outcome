package ub4;

import android.view.View;
import com.bytedance.bdturing.identityverify.IdentityDialogActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ IdentityDialogActivity a;

    public d(IdentityDialogActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        a r3 = this.a.f;
        if (r3 == null) goto L5;
        r3.onConfirm();
    L5:
        IdentityDialogActivity r4 = this.a;
        r4.f = null;
        r4.finish();
    }
}
