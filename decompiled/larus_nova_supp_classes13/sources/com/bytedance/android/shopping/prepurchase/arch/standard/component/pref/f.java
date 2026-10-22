package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import android.os.MessageQueue;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.utils.UIUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements MessageQueue.IdleHandler {
    public final /* synthetic */ TaskScheduler a;

    public f(TaskScheduler r1) {
        this.a = r1;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        Lazy r0 = UIUtils.a;
        return UIUtils.c().postDelayed(this.a.d, PdpMessageOpt.b.h());
    }
}
