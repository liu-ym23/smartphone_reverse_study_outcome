package mac;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f512754a = null;

    static {
        f512754a = new a();
    }

    public a() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
