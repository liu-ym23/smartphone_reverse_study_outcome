package xg3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ d c;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r0 = this.c.n;
        if (r0 == null) goto L6;
        r0.i.a("render_end");
        return;
    }

    public f(d r1) {
        this.c = r1;
        super("mark_main_render_end");
    }
}
