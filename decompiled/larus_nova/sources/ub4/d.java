package ub4;

import android.view.View;
import com.bytedance.bdturing.identityverify.IdentityDialogActivity;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IdentityDialogActivity f549353a;

    public d(IdentityDialogActivity r100) {
        this.f549353a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f549353a.f201799f;
        if (r101 == null) goto L5;
        r101.onConfirm();
    L5:
        IdentityDialogActivity r102 = this.f549353a;
        r102.f201799f = null;
        r102.finish();
    }
}
