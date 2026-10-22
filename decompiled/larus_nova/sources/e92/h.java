package e92;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f471457a = null;

    static {
        f471457a = new h();
    }

    public h() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
