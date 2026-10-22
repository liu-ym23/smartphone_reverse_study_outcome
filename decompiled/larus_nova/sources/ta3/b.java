package ta3;

import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.extensions.k;
import io.reactivex.functions.Action;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UltimateBuyParams f545165a;

    public b(UltimateBuyParams r100) {
        this.f545165a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        EventActionImpl r100 = new EventActionImpl();
        Pair[] r101 = new Pair[2];
        r101[0] = TuplesKt.to("page_scene", "1");
        UltimateBuyParams r102 = this.f545165a;
        if (r102 == null) goto L7;
        SkuParams r103 = r102.getSkuParams();
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.getSceneType());
    L8:
        r101[1] = TuplesKt.to("scene_type", String.valueOf(k.f(r104)));
        r100.doEventAction("enter_submit_orders", MapsKt.mapOf(r101));
        return;
    L7:
        r104 = null;
        goto L8
    }
}
