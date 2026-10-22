package tg5;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f545877a;

    public i(b r100) {
        this.f545877a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        p.a r102 = this.f545877a.f545854d;
        if (r102 == null) goto L6;
        r102.W2();
        return;
    }
}
