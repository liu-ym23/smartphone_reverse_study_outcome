package t69;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.t0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends t0 {
    public l() {
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
        Iterator<T> r103 = m.f544692a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((h49.e) r103.next()).b(r102);
        goto L4
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        super.onDoraLinkStateChanged(r100, r101, r102);
        Iterator<T> r103 = m.f544692a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((h49.e) r103.next()).a(r102);
        goto L4
    }
}
