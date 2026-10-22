package pk5;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements gk5.c {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public static final JSONObject c(f r100, POIInfo r101) {
        r100.getClass();
        PoiInfo r102 = PoiInfo.parseByAddressForOffice(null, r101);
        JSONObject r103 = new JSONObject();
        String r104 = r101.getLocationName();
        if (r104 != null) goto L7;
        r104 = r101.getLocationAddress();
        if (r104 != null) goto L7;
        r104 = r102.getName();
    L7:
        r103.put2("name", r104);
        String r105 = r101.getLocationAddress();
        if (r105 != null) goto L12;
        r105 = r101.getLocationName();
        if (r105 != null) goto L12;
        r105 = r102.getAddress();
    L12:
        r103.put2("address", r105);
        r103.put2("isInternal", Boolean.valueOf(r101.isInternal()));
        AddressComponent r106 = r101.getAddressComponent();
        if (r106 == null) goto L15;
        JSONObject r107 = new JSONObject();
        r107.put2(DistrictSearchQuery.KEYWORDS_COUNTRY, r106.getCountry());
        r107.put2("province", r106.getProvince());
        r107.put2("city", r106.getCity());
        r107.put2(DistrictSearchQuery.KEYWORDS_DISTRICT, r106.getDistrict());
        r107.put2("township", r106.getTownship());
        r107.put2("neighborhood", r106.getNeighborhood());
        r107.put2(LocationConstants$NameType.BUILDING, r106.getBuilding());
        Unit r108 = Unit.INSTANCE;
        r103.put2("addressComponent", r107);
    L15:
        return r103;
    }

    @Override // gk5.c
    public final void a(FragmentActivity r100, org.json.JSONObject r110, p r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r112 = Result.m9449constructorimpl(new LocationHelper.ReverseLocationRequest(JSONObjectProtectorUtils.getDouble(r110, "latitude"), JSONObjectProtectorUtils.getDouble(r110, "longitude")));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r112) == false) goto L10;
        r112 = null;
    L10:
        LocationHelper.ReverseLocationRequest r113 = (LocationHelper.ReverseLocationRequest) r112;
        if (r113 != null) goto L19;
        nk5.b.d(r111, "invalid latitude or longitude");
        return;
    L19:
        ((r) org.koin.java.a.c(r.class, null, null, 6)).c(r100, r113.getLatitude(), r113.getLongitude(), new g(r111, this));     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        nk5.b.c(r111, th);
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
