package r69;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class g implements Runnable {
    public /* synthetic */ g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference<u19.f> r100 = i.f536383b;
        u19.f r101 = r100.get();
        if (r101 == null) goto L5;
        r101.dismiss();
    L5:
        g49.d.a("DoraWearToastFactory", "clear toast holder by dismiss");
        r100.set(null);
    }
}
