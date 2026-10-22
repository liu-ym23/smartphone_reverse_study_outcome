package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ l a;

    public o(l r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        boolean r2 = false;
        tt5.a.e("DocShortcutMoreInfoBehavior", "publicPermissionFlow err. ", r5, false);
        if (ax4.d.b(r5, 1002) == false) goto L5;
    L6:
        r2 = true;
    L7:
        oj5.a r6 = this.a.c();
        if (r6 == null) goto L10;
        r6.q = r2;
    L10:
        l r7 = this.a;
        r7.e(r7.c());
        return;
    L5:
        if (ax4.d.b(r5, 3) == false) goto L7;
        goto L6
    }
}
