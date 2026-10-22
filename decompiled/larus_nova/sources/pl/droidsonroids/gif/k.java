package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class k extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<d> f529743a;

    public k(d r100) {
        super(Looper.getMainLooper());
        this.f529743a = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        d r101 = this.f529743a.get();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.what != (-1)) goto L8;
        r101.invalidateSelf();
        return;
    L8:
        Iterator<a> r102 = r101.f529715h.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        r102.next().a();
        goto L10
    }
}
