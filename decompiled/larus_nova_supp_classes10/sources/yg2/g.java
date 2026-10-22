package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static vg2.a a(xg2.c r7, EventType r8, String r9, Map r10) {
        Intrinsics.checkNotNullParameter(r7, "node");
        Intrinsics.checkNotNullParameter(r8, "eventType");
        Intrinsics.checkNotNullParameter(r9, "eventName");
        vg2.a r0 = new vg2.a(r9, r8, r7.b.getModule(), r7.b.getAction(), r7.a);
        if (r0.a != null) goto L5;
        return r0;
    L5:
        if (r10 == null) goto L11;
        Iterator r11 = r10.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r12 = (Map.Entry) r11.next();
        r0.a.put("extra_" + ((String) r12.getKey()), String.valueOf(r12.getValue()));
    L11:
        if ((r7 instanceof xg2.a) == true) goto L13;
        r7 = null;
    L13:
        xg2.a r13 = (xg2.a) r7;
        if (r13 == null) goto L16;
        r0.a.put("error_type", r13.d.getValue());
        r0.a.put(LocationMonitorConst.ERROR_CODE, String.valueOf(r13.e));
        r0.a.put(LocationMonitorConst.ERROR_MSG, r13.f);
    L16:
        return r0;
    }
}
