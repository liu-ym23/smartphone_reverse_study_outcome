package fo2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f478105a;

    public b() {
        this.f478105a = new CopyOnWriteArrayList();
    }

    @Override // fo2.a
    public final void onAudioStall(Long r100) {
        Iterator<a> r101 = this.f478105a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onAudioStall(r100);
        goto L4
    }

    @Override // fo2.a
    public final void onStreamNetStall(Long r100) {
        Iterator<a> r101 = this.f478105a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onStreamNetStall(r100);
        goto L4
    }

    @Override // fo2.a
    public final void onVideoRenderStall(Long r100) {
        Iterator<a> r101 = this.f478105a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onVideoRenderStall(r100);
        goto L4
    }
}
