package ub4;

import android.view.View;
import com.bytedance.bdturing.identityverify.IdentityDialogActivity;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IdentityDialogActivity f549352a;

    public c(IdentityDialogActivity r100) {
        this.f549352a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f549352a.f201799f;
        if (r101 == null) goto L5;
        r101.onCancel();
    L5:
        IdentityDialogActivity r102 = this.f549352a;
        r102.f201799f = null;
        r102.finish();
    }
}
