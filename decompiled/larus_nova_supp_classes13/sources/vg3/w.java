package vg3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.google.gson.internal.LinkedTreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface w extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(w r1, String r2, Map r3, int r4) {
            if ((r4 & 2) == 0) goto L6;
            r3 = new LinkedHashMap();
        L6:
            if ((r4 & 4) == 0) goto L8;
            boolean r5 = true;
        L9:
            r1.E0(r2, r3, r5);
            return;
        L8:
            r5 = false;
            goto L9
        }
    }

    void E0(String r1, Map<String, Object> r2, boolean r3);

    PageFinder getPageFinder();

    LinkedTreeMap<String, Object> getTrackMeta();

    ProductDetailEventService.b m();

    void n1(jq.a r1, Map<String, ? extends Object> r2, boolean r3);

    void t1();
}
