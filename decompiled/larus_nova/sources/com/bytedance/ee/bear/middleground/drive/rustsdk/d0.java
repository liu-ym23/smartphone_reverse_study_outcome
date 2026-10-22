package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.DowngradeStrategy;
import com.bytedance.lark.pb.tool.v1.PushCpuManagerMagicShareSceneDowngradeStrategy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 implements com.ss.android.lark.sdk.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<rf5.a> f232567a;

    public d0() {
        this.f232567a = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        PushCpuManagerMagicShareSceneDowngradeStrategy r101 = PushCpuManagerMagicShareSceneDowngradeStrategy.ADAPTER.decode(r100);     // Catch: Throwable -> L12
        if (r101.ms_strategy == null) goto L6;
        DowngradeStrategy r102 = new DowngradeStrategy();     // Catch: Throwable -> L12
        r102.sendCursorDebounce = r101.ms_strategy.send_cursor_debounce.intValue();     // Catch: Throwable -> L12
        r102.updateCursorShortThrottle = r101.ms_strategy.update_cursor_short_throttle.intValue();     // Catch: Throwable -> L12
        r102.updateCursorLongThrottle = r101.ms_strategy.update_cursor_long_throttle.intValue();     // Catch: Throwable -> L12
        r102.memberBufferActiveConsumeInterval = r101.ms_strategy.member_buffer_active_consume_interval.intValue();     // Catch: Throwable -> L12
        r102.engineBufferActiveConsumeInterval = r101.ms_strategy.engine_buffer_active_consume_interval.intValue();     // Catch: Throwable -> L12
    L7:
        tt5.a.h("DowngradeStateListener", "downgradeStrategy=" + r102);     // Catch: Throwable -> L12
        Iterator r103 = ((CopyOnWriteArrayList) this.f232567a).iterator();     // Catch: Throwable -> L12
    L8:
        if (r103.hasNext() == false) goto L18;
        ((rf5.a) r103.next()).onStrategyChange(r102);     // Catch: Throwable -> L12
        goto L8
    L18:
        return;
    L6:
        uu5.i.c();     // Catch: Throwable -> L12
        r102 = null;
    L12:
        th = move-exception;
        tt5.a.f("DowngradeStateListener", th, false);
    }
}
