package ta3;

import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.extensions.k;
import io.reactivex.functions.Action;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Action {
    public final /* synthetic */ UltimateBuyParams a;

    public b(UltimateBuyParams r1) {
        this.a = r1;
    }

    public final void run() {
        EventActionImpl r0 = new EventActionImpl();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("page_scene", "1");
        UltimateBuyParams r2 = this.a;
        if (r2 == null) goto L7;
        SkuParams r3 = r2.getSkuParams();
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getSceneType());
    L8:
        r1[1] = TuplesKt.to("scene_type", String.valueOf(k.f(r4)));
        r0.doEventAction("enter_submit_orders", MapsKt.mapOf(r1));
        return;
    L7:
        r4 = null;
        goto L8
    }
}
