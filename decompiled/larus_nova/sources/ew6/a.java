package ew6;

import com.bytedance.locallife.pdp.settings.l0;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile JSONObject f474603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f474604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f474605c = 0;

    static {
        f474603a = new JSONObject();
        PoiTradeSettingEntity r100 = l0.f261737a;
        if (r100 == null) goto L7;
        Integer r101 = r100.z();
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        f474605c = r102;
        return;
    L7:
        r102 = 5;
        goto L8
    }
}
