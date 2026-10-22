package t69;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class n extends r0 {
    public n() {
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void D(DoraDevice r110, int[] r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        Iterator<h49.h> r100 = p.f544693a.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        r100.next().a(new h49.b(r110.name, r110.battery, r111, r110.model, r110.getSerialNumber(), Integer.valueOf(r110.productId)));
        goto L6
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void b0(DoraDevice r110, int[] r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        Iterator<h49.h> r100 = p.f544693a.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        r100.next().b(new h49.b(r110.name, r111, r110.charge, r110.model, r110.getSerialNumber(), Integer.valueOf(r110.productId)));
        goto L6
    }
}
