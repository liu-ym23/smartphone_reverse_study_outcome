package tg5;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f545878a;

    public j(b r100) {
        this.f545878a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        p.a r102 = this.f545878a.f545854d;
        if (r102 == null) goto L6;
        r102.W2();
        return;
    }
}
