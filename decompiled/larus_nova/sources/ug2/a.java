package ug2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wg2.b;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a> f549984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f549985b;

    public a() {
        this.f549984a = new ArrayList();
        this.f549985b = new b();
    }

    public final void a(vg2.a r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        b r100 = this.f549985b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        Map<String, String> r101 = r110.f554676a;
        Intrinsics.checkNotNullParameter(r101, "newParams");
        String r102 = r110.f554677b;
        EventType r103 = r110.f554678c;
        String r104 = r110.f554679d;
        String r105 = r110.f554680e;
        String r106 = r110.f554681f;
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "action");
        vg2.a r107 = new vg2.a(r102, r103, r104, r105, r106);
        ((LinkedHashMap) r107.f554676a).clear();
        r107.f554676a.putAll(r101);
        Iterator<wg2.a> r108 = r100.f559544a.iterator();
    L4:
        if (r108.hasNext() == false) goto L8;
        r107 = r108.next().a(r107);
        if (r107 != null) goto L4;
        r107 = null;
        dm.a.a("ActionRecordServiceImpl").w("ConvertEvent is Empty, Event is " + r110, null);
    L8:
        if (r107 == null) goto L15;
        Iterator r109 = ((ArrayList) this.f549984a).iterator();
    L11:
        if (r109.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a r111 = (com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a) r109.next();
        if (r111.b().contains(r110.getType()) == false) goto L11;
        r111.c(r107);
        goto L11
    L24:
        return;
    }
}
