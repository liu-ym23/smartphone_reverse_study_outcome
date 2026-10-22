package uzb;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f552255a;

    public k() {
        this.f552255a = null;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        DialogInterface.OnClickListener r102 = this.f552255a;
        if (r102 == null) goto L6;
        r102.onClick(r100, r101);
        return;
    }
}
