package vfc;

import android.animation.ValueAnimator;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f554648a;

    public i(o r100) {
        this.f554648a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        ValueAnimator r101 = this.f554648a.f554658c;
        if (r101 == null) goto L6;
        r101.removeAllUpdateListeners();
        this.f554648a.f554658c.cancel();
        this.f554648a.f554658c = null;
        return;
    }
}
