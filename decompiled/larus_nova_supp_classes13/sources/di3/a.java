package di3;

import com.bytedance.android.bst.api.g;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements g {
    public final /* synthetic */ b a;
    public final /* synthetic */ jq.a b;
    public final /* synthetic */ Map c;

    public final void a(String r9, Map<Object, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "params");
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a.b);
        if (r1 == null) goto L17;
        LinkedHashMap r2 = new LinkedHashMap();
        Map r3 = this.c;
        if (r3 == null) goto L7;
        r2.putAll(r3);
    L7:
        Map r4 = this.b.i();
        if (r4 == null) goto L10;
        r2.putAll(r4);
    L10:
        ArrayList r5 = new ArrayList(r10.size());
        Iterator r11 = ((LinkedHashMap) r10).entrySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) r11.next();
        r5.add(TuplesKt.to(r6.getKey().toString(), r6.getValue()));
        goto L12
    L14:
        MapsKt.putAll(r2, r5);
        Unit r12 = Unit.INSTANCE;
        r1.c = r2;
        AnchorV4TrackerImpl.b(r1, r9, false, null, false, null, 30);
        return;
    }

    public a(b r1, jq.a r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
