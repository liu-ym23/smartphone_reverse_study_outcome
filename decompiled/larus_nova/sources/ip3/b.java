package ip3;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends hp3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f495273b;

    @Override // hp3.b
    public final Map<String, Object> a() {
        a r100 = this.f495273b;
        boolean r101 = false;
        Map<String, Object> r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, Integer.valueOf(r100.f495267a)), TuplesKt.to(BdpAppEventConstant.PARAMS_UNIQUEID, r100.f495268b), TuplesKt.to("category_id", r100.f495271e), TuplesKt.to("nearest_dynamic_insert_distance", Integer.valueOf(r100.f495272f))});
        if ((!r100.f495269c.isEmpty()) == false) goto L6;
        r102.put("dynamic_insert_data", r100.f495269c);
    L6:
        if (r100.f495270d.length() <= 0) goto L8;
        r101 = true;
    L8:
        if (r101 == false) goto L10;
        r102.put("surrounded_product_ids", r100.f495270d);
    L10:
        return r102;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        super("windowCardClicked");
        this.f495273b = r100;
    }
}
