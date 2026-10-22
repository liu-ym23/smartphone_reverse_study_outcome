package m1c;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import e1c.d;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends k1c.a<Integer> implements DevicePerfManager.c {

    public static final class a {
    }

    static {
    }

    @Override // k1c.a
    public final Integer n() {
        return Integer.valueOf(DevicePerfManager.b.f432386a.f432372e.f20363a);
    }

    public b() {
    }

    @Override // com.ss.android.lark.monitor.callback.DevicePerfManager.c
    public final void a(int r100) {
        o(Integer.valueOf(r100));
        Log.d("Detector/TurboModeDetector", "onDevicePerfChanged:" + r100);
    }

    @Override // k1c.a, k1c.b
    public final void j(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "manager");
        super.j(r100, r101);
        final DevicePerfManager r102 = DevicePerfManager.b.f432386a;
        r102.getClass();
        final DevicePerfManager.PerfType r103 = DevicePerfManager.PerfType.ALL;
        Iterator<DevicePerfManager.a> r104 = r102.f432368a.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        DevicePerfManager.a r105 = r104.next();
        if (y0.a(r105.f432384d, "TurboModeDetector") == false) goto L4;
        if (r105.f432382b != r103) goto L4;
        Log.w("DevicePerfManager", "found repeat register, key is: TurboModeDetector, perfType is: " + r103);
        boolean r106 = true;
    L11:
        if (r106 == true) goto L21;
        DevicePerfManager.PerfType r107 = DevicePerfManager.PerfType.ALL;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new bsb.d(r102, this, r103));
        r102.f432368a.add(new DevicePerfManager.a(new SoftReference(this), r103, null));
        return;
    L21:
        return;
    L10:
        r106 = false;
        goto L11
    }
}
