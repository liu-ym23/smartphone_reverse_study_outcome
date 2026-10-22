package com.bytedance.ee.bear.bitable.jsapi.common;

import com.alibaba.fastjson.JSONObject;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements com.ss.android.lark.location.service.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationHelper.c f214422a;

    public p(com.bytedance.ee.bear.bitable.jsapi.f r100) {
        this.f214422a = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.location.service.h.a
    public final void a(POIInfo r100) {
        if (r100 != null) goto L7;
        tt5.a.d("NewLarkForm", "poiInfo is null");
        LocationHelper.c r101 = this.f214422a;
        if (r101 == null) goto L20;
        JSONObject r102 = new JSONObject();
        BitableJSApiErrorCode r103 = BitableJSApiErrorCode.UNKNOWN;
        r102.put2("errCode", Integer.valueOf(r103.getCode()));
        r102.put2("errMsg", r103.getErrMsg());
        r101.b(r102);
        return;
    L20:
        return;
    L7:
        LocationHelper.c r104 = this.f214422a;
        if (r104 == null) goto L21;
        JSONObject r105 = new JSONObject();
        String r106 = r100.getLocationName();
        if (r106 != null) goto L12;
        r106 = r100.getLocationAddress();
    L12:
        r105.put2("name", r106);
        String r107 = r100.getLocationAddress();
        if (r107 != null) goto L15;
        r107 = r100.getLocationName();
    L15:
        r105.put2("address", r107);
        r105.put2("isInternal", Boolean.valueOf(r100.isInternal()));
        AddressComponent r108 = r100.getAddressComponent();
        if (r108 == null) goto L18;
        JSONObject r109 = new JSONObject();
        r109.put2(DistrictSearchQuery.KEYWORDS_COUNTRY, r108.getCountry());
        r109.put2("province", r108.getProvince());
        r109.put2("city", r108.getCity());
        r109.put2(DistrictSearchQuery.KEYWORDS_DISTRICT, r108.getDistrict());
        r109.put2("township", r108.getTownship());
        r109.put2("neighborhood", r108.getNeighborhood());
        r109.put2(LocationConstants$NameType.BUILDING, r108.getBuilding());
        Unit r110 = Unit.INSTANCE;
        r105.put2("addressComponent", r109);
    L18:
        r104.a(r105);
        return;
    }
}
