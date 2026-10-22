package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.DowngradeStrategy;
import com.bytedance.lark.pb.tool.v1.PushCpuManagerMagicShareSceneDowngradeStrategy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements com.ss.android.lark.sdk.g.b {
    public final List<rf5.a> a;

    public d0() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void a(byte[] r5) {
        PushCpuManagerMagicShareSceneDowngradeStrategy r6 = (PushCpuManagerMagicShareSceneDowngradeStrategy) PushCpuManagerMagicShareSceneDowngradeStrategy.ADAPTER.decode(r5);     // Catch: Throwable -> L12
        if (r6.ms_strategy == null) goto L6;
        DowngradeStrategy r2 = new DowngradeStrategy();     // Catch: Throwable -> L12
        r2.sendCursorDebounce = r6.ms_strategy.send_cursor_debounce.intValue();     // Catch: Throwable -> L12
        r2.updateCursorShortThrottle = r6.ms_strategy.update_cursor_short_throttle.intValue();     // Catch: Throwable -> L12
        r2.updateCursorLongThrottle = r6.ms_strategy.update_cursor_long_throttle.intValue();     // Catch: Throwable -> L12
        r2.memberBufferActiveConsumeInterval = r6.ms_strategy.member_buffer_active_consume_interval.intValue();     // Catch: Throwable -> L12
        r2.engineBufferActiveConsumeInterval = r6.ms_strategy.engine_buffer_active_consume_interval.intValue();     // Catch: Throwable -> L12
    L7:
        tt5.a.h("DowngradeStateListener", "downgradeStrategy=" + r2);     // Catch: Throwable -> L12
        Iterator r7 = ((CopyOnWriteArrayList) this.a).iterator();     // Catch: Throwable -> L12
    L8:
        if (r7.hasNext() == false) goto L18;
        ((rf5.a) r7.next()).onStrategyChange(r2);     // Catch: Throwable -> L12
        goto L8
    L18:
        return;
    L6:
        uu5.i.c();     // Catch: Throwable -> L12
        r2 = null;
    L12:
        th = move-exception;
        tt5.a.f("DowngradeStateListener", th, false);
    }
}
