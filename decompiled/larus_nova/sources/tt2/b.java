package tt2;

import android.app.Dialog;
import android.content.DialogInterface;
import com.bytedance.android.livesdk.urge.LynxUrgeGiftPanel;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxUrgeGiftPanel f547540a;

    public b(LynxUrgeGiftPanel r100) {
        this.f547540a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Dialog r101 = LynxUrgeGiftPanel.S90(this.f547540a);
        if (r101 == null) goto L6;
        r101.cancel();
        return;
    }
}
