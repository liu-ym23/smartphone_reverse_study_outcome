package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560006a;

    public o(l r100) {
        this.f560006a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        boolean r102 = false;
        tt5.a.e("DocShortcutMoreInfoBehavior", "publicPermissionFlow err. ", r101, false);
        if (ax4.d.b(r101, 1002) == false) goto L5;
    L6:
        r102 = true;
    L7:
        oj5.a r103 = this.f560006a.c();
        if (r103 == null) goto L10;
        r103.f523546q = r102;
    L10:
        l r104 = this.f560006a;
        r104.e(r104.c());
        return;
    L5:
        if (ax4.d.b(r101, 3) == false) goto L7;
        goto L6
    }
}
