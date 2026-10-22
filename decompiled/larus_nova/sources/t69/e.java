package t69;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends r0 {
    public e() {
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void b0(DoraDevice r100, int[] r101) {
        if (g.f544687e == false) goto L6;
        FLogger.f375446a.i("DoraWearStatusManager", "onBatteryChanged show toast");
        g.f544687e = false;
        g.c(null, false, 3);
        return;
    }
}
