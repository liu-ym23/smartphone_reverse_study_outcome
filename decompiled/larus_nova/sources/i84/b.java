package i84;

import com.bytedance.bdinstall.a0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<a0> f488615a;

    public b() {
        this.f488615a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.bdinstall.a0
    public final void onIdLoaded(String r100, String r101, String r102) {
        Iterator<a0> r103 = this.f488615a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onIdLoaded(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.bdinstall.a0
    public final void onRemoteIdGet(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        Iterator<a0> r100 = this.f488615a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onRemoteIdGet(r110, r111, r112, r113, r114, r115, r116);
        goto L4
    }
}
