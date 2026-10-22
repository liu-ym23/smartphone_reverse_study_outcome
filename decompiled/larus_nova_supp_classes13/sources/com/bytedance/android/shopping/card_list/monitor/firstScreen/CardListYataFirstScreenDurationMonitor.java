package com.bytedance.android.shopping.card_list.monitor.firstScreen;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListYataFirstScreenDurationMonitor {
    public final Lazy a;
    public final ConcurrentHashMap<CardListFirstScreenPoint, Long> b;
    public final Map<String, Object> c;
    public final String d;
    public final JSONObject e;

    public static final class a {
    }

    static {
    }

    public CardListYataFirstScreenDurationMonitor(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "baseParams");
        this.d = r3;
        this.e = r4;
        Lazy r5 = LazyKt.lazy(new CardListYataFirstScreenDurationMonitor$monitorKey$2(this));
        this.a = r5;
        this.b = new ConcurrentHashMap();
        this.c = new LinkedHashMap();
        d r6 = i.a.get((String) r5.getValue());
        if (r6 == null) goto L10;
        Iterator<String> r7 = r4.keys();
    L6:
        if (r7.hasNext() == false) goto L16;
        String r0 = r7.next();
        Object r1 = this.e.opt(r0);
        if (r1 == null) goto L6;
        r6.b(r0, r1);
        goto L6
    L16:
        return;
    }

    public static void b(final CardListYataFirstScreenDurationMonitor r4, final CardListFirstScreenPoint r5) {
        Intrinsics.checkNotNullParameter(r5, "point");
        final Long r3 = null;
        CardListRunCatchExtKt.a(r4.d, CardListErrorMonitorType.ADD_POINT.getValue(), new CardListYataFirstScreenDurationMonitor$addPointSafely$1(r4, r5, r3));
    }

    public final void a(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.c.put(r2, r3);
    }
}
