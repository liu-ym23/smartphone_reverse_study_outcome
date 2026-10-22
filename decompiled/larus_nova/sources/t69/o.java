package t69;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.t0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class o extends t0 {
    public o() {
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r110, int r111, int r112) {
        super.onDoraLinkStateChanged(r110, r111, r112);
        if (r110 != null) goto L5;
        return;
    L5:
        Iterator<T> r113 = p.f544693a.iterator();
    L7:
        if (r113.hasNext() == false) goto L9;
        ((h49.h) r113.next()).c(new h49.b(r110.name, r110.battery, r110.charge, r110.model, r110.getSerialNumber(), Integer.valueOf(r110.productId)), r112);
        goto L7
    }
}
