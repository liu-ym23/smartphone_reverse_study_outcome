package pk5;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements gk5.c {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public static final JSONObject c(f r3, POIInfo r4) {
        r3.getClass();
        PoiInfo r5 = PoiInfo.parseByAddressForOffice(null, r4);
        JSONObject r0 = new JSONObject();
        String r1 = r4.getLocationName();
        if (r1 != null) goto L7;
        r1 = r4.getLocationAddress();
        if (r1 != null) goto L7;
        r1 = r5.getName();
    L7:
        r0.put("name", r1);
        String r2 = r4.getLocationAddress();
        if (r2 != null) goto L12;
        r2 = r4.getLocationName();
        if (r2 != null) goto L12;
        r2 = r5.getAddress();
    L12:
        r0.put("address", r2);
        r0.put("isInternal", Boolean.valueOf(r4.isInternal()));
        AddressComponent r6 = r4.getAddressComponent();
        if (r6 == null) goto L15;
        JSONObject r7 = new JSONObject();
        r7.put("country", r6.getCountry());
        r7.put("province", r6.getProvince());
        r7.put("city", r6.getCity());
        r7.put("district", r6.getDistrict());
        r7.put("township", r6.getTownship());
        r7.put("neighborhood", r6.getNeighborhood());
        r7.put("building", r6.getBuilding());
        Unit r8 = Unit.INSTANCE;
        r0.put("addressComponent", r7);
    L15:
        return r0;
    }

    @Override // gk5.c
    public final void a(FragmentActivity r9, org.json.JSONObject r10, p r11) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(new LocationHelper.ReverseLocationRequest(JSONObjectProtectorUtils.getDouble(r10, "latitude"), JSONObjectProtectorUtils.getDouble(r10, "longitude")));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        LocationHelper.ReverseLocationRequest r13 = (LocationHelper.ReverseLocationRequest) r12;
        if (r13 != null) goto L19;
        nk5.b.d(r11, "invalid latitude or longitude");
        return;
    L19:
        ((r) org.koin.java.a.c(r.class, null, null, 6)).c(r9, r13.getLatitude(), r13.getLongitude(), new g(r11, this));     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        nk5.b.c(r11, th);
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
