package vg3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.google.gson.internal.LinkedTreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface w extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(w r100, String r101, Map r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = new LinkedHashMap();
        L6:
            if ((r103 & 4) == 0) goto L8;
            boolean r104 = true;
        L9:
            r100.E0(r101, r102, r104);
            return;
        L8:
            r104 = false;
            goto L9
        }
    }

    void E0(String r100, Map<String, Object> r101, boolean r102);

    PageFinder getPageFinder();

    LinkedTreeMap<String, Object> getTrackMeta();

    ProductDetailEventService.b m();

    void n1(jq.a r100, Map<String, ? extends Object> r101, boolean r102);

    void t1();
}
