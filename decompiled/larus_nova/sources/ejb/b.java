package ejb;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.batterymonitor.api.BatteryHandlerPlugin;
import com.ss.android.lark.batterymonitor.api.ConditionState;
import com.ss.android.lark.utils.o0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
@BatteryHandlerPlugin
public final class b implements xwa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f472897a;

    @Override // xwa.a
    public final void a() {
    }

    @Override // xwa.a
    public final void b() {
    }

    public b() {
        this.f472897a = 0;
    }

    @Override // xwa.a
    public final boolean c(Context r100) {
        if (o0.a(r100) == false) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // xwa.a
    public final void d(ConditionState r100) {
        boolean r101 = true;
        if (r100.f409777a != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (r100.f409779c == 0) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L19;
        long r103 = System.currentTimeMillis();
        if ((r103 - this.f472897a) < 1200000) goto L20;
        this.f472897a = r103;
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new a(), 1, TimeUnit.SECONDS);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
