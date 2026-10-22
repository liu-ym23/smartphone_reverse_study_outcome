package gq1;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f482146a = null;

    static {
        f482146a = new a();
    }

    public a() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L5;
        r100.dismiss();
        return;
    }
}
