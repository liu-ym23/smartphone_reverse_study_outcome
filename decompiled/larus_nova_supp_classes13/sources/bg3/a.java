package bg3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.apm.ApmAgent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Map<String, Object> a;
    public final Set<String> b;
    public final EventActionImpl c;

    public a() {
        this.a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("area_type", "104"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page")});
        this.b = new LinkedHashSet();
        this.c = new EventActionImpl();
    }

    public final void a(String r3, Map<String, ? extends Object> r4, PageFinder r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (k.c(r6) == true) goto L5;
    L7:
        if (r6 == null) goto L9;
        this.b.add(r6);
    L9:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.putAll(this.a);
        r7.putAll(r4);
        this.c.doEventAction(r3, r5, r7);
        Lazy r8 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L18;
        Object r9 = r7.get("btm");
        if (r9 == null) goto L15;
        String r10 = r9.toString();
        if (r10 == null) goto L15;
    L16:
        TrackCatcher.c("cart", r3, r10);
    L15:
        r10 = "";
    L18:
        if (Intrinsics.areEqual(r3, "yata_cart_monitor") == false) goto L36;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L29
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L29
        Iterator r13 = r7.entrySet().iterator();     // Catch: Throwable -> L29
    L21:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r0 = (Map.Entry) r13.next();     // Catch: Throwable -> L29
        r12.put((String) r0.getKey(), r0.getValue());     // Catch: Throwable -> L29
        goto L21
    L23:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L29
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L29
        Iterator r16 = r7.entrySet().iterator();     // Catch: Throwable -> L29
    L25:
        if (r16.hasNext() == false) goto L27;
        Map.Entry r1 = (Map.Entry) r16.next();     // Catch: Throwable -> L29
        r15.put((String) r1.getKey(), r1.getValue());     // Catch: Throwable -> L29
        goto L25
    L27:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L29
        ApmAgent.monitorEvent(r3, r12, null, r15);     // Catch: Throwable -> L29
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L36:
        return;
    L5:
        if (CollectionsKt.contains(this.b, r6) == false) goto L7;
    }
}
