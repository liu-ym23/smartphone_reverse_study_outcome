package i84;

import com.bytedance.bdinstall.a0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b implements a0 {
    public final CopyOnWriteArraySet<a0> a;

    public b() {
        this.a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.bdinstall.a0
    public final void onIdLoaded(String r3, String r4, String r5) {
        Iterator<a0> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onIdLoaded(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.bdinstall.a0
    public final void onRemoteIdGet(boolean r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        Iterator<a0> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onRemoteIdGet(r12, r13, r14, r15, r16, r17, r18);
        goto L4
    }
}
