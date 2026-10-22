package xg3;

import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ d c;

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = ((k) this.c.O1().d().q0().a()) instanceof k.c;
        boolean r1 = PdpMessageOpt.a;
        PdpMessageOpt.g(this.c.c2(), r0);
    }

    public b(d r1) {
        this.c = r1;
        super("message_opt_first_frame_real");
    }
}
