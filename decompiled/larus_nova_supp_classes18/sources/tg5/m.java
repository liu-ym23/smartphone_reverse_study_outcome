package tg5;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ b a;

    public m(b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        p.a r3 = this.a.d;
        if (r3 == null) goto L6;
        r3.W2();
        return;
    }
}
