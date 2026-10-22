package ug2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wg2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final List<com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a> a;
    public final b b;

    public a() {
        this.a = new ArrayList();
        this.b = new b();
    }

    public final void a(vg2.a r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        Map<String, String> r0 = r10.a;
        Intrinsics.checkNotNullParameter(r0, "newParams");
        String r4 = r10.b;
        EventType r5 = r10.c;
        String r6 = r10.d;
        String r7 = r10.e;
        String r8 = r10.f;
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r6, "module");
        Intrinsics.checkNotNullParameter(r7, "action");
        vg2.a r2 = new vg2.a(r4, r5, r6, r7, r8);
        ((LinkedHashMap) r2.a).clear();
        r2.a.putAll(r0);
        Iterator<wg2.a> r3 = r1.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        r2 = r3.next().a(r2);
        if (r2 != null) goto L4;
        r2 = null;
        dm.a.a("ActionRecordServiceImpl").w("ConvertEvent is Empty, Event is " + r10, null);
    L8:
        if (r2 == null) goto L15;
        Iterator r9 = ((ArrayList) this.a).iterator();
    L11:
        if (r9.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a r11 = (com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a) r9.next();
        if (r11.b().contains(r10.getType()) == false) goto L11;
        r11.c(r2);
        goto L11
    L24:
        return;
    }
}
