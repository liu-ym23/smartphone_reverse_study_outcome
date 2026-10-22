package fj2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final Map<String, List<View>> a;

    public b() {
        this.a = new LinkedHashMap();
    }

    public final <T extends View> T a(a<T> r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L29;
        List r0 = (List) ((LinkedHashMap) this.a).get(r7.type());
        if (r0 == null) goto L23;
        T r4 = null;
        if (r0.size() > 8) goto L21;
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L17;
        Object r3 = r2.next();
        if (((View) r3).getParent() != null) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L10;
    L18:
        View r6 = (View) r3;
        if (r6 == null) goto L22;
        dm.a.a("WidgetItemManager").i("hit cache " + r7.type() + ", cache size: " + r0.size());
        r4 = (T) r6;
    L22:
        if (r4 == null) goto L23;
    L27:
        return r4;
    L14:
        r5 = false;
        goto L15
    L17:
        r3 = null;
        goto L18
    L21:
        dm.a.a("WidgetItemManager").i(r7.type() + " cache full");
    L23:
        r4 = r7.create();
        dm.a.a("WidgetItemManager").i("no cache " + r7.type() + ", create new");
        Map<String, List<View>> r1 = this.a;
        String r8 = r7.type();
        LinkedHashMap r9 = (LinkedHashMap) r1;
        Object r10 = r9.get(r8);
        if (r10 != null) goto L26;
        r10 = new ArrayList();
        r9.put(r8, r10);
    L26:
        ((List) r10).add(r4);
        goto L27
    L29:
        return r7.create();
    }
}
