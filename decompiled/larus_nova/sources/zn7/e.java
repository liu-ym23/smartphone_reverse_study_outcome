package zn7;

import android.database.ContentObserver;
import android.net.Uri;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends ContentObserver {
    public e(d r100) {
        super(r100);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        super.onChange(r100, r101);
        if (c.f572936c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        c.f572935b.compareAndSet(false, true);
        k.e("ImageCheckerManager", "Album photos have changed");
    }
}
