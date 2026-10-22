package xg3;

import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ d c;

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.f(this.c.c2());
    }

    public c(d r1) {
        this.c = r1;
        super("destroy_message_opt");
    }
}
