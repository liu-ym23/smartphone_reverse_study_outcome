package y00;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f565561a = null;

    static {
        f565561a = new b();
    }

    public b() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
