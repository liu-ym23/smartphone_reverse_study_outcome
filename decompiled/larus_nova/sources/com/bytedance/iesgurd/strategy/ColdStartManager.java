package com.bytedance.iesgurd.strategy;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import ez5.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ColdStartManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f250850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f250851b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f250852c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f250853d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ColdStartManager f250854e = null;

    public ColdStartManager() {
    }

    public static Set a() {
        return (Set) f250852c.getValue();
    }

    static {
        f250854e = new ColdStartManager();
        f250850a = new AtomicBoolean(false);
        f250851b = new AtomicBoolean(false);
        f250852c = LazyKt.lazy(ColdStartManager$accessKeyWithCustomParams$2.INSTANCE);
        f250853d = new ArrayList();
    }

    private final void update(String r100) {
        RequestBodyUpdate r101 = new RequestBodyUpdate(ReqType.REGISTER_LATE);
        r101.initCustom(SetsKt.setOf(r100));
        new UpdateRequest(r101).f();
    }

    public final void b(String r210, Map<String, OptionCheckUpdateParams.CustomValue> r211) {
        if (f250851b.get() == true) goto L5;
        return;
    L5:
        if (AppSettingsManager.b.f245071a.a() == true) goto L7;
        update(r210);
        return;
    L7:
        if (r211 == null) goto L21;
        Iterator<Map.Entry<String, OptionCheckUpdateParams.CustomValue>> r100 = r211.entrySet().iterator();
    L10:
        if (r100.hasNext() == false) goto L21;
        Map.Entry<String, OptionCheckUpdateParams.CustomValue> r101 = r100.next();
        boolean r102 = true;
        if ((!Intrinsics.areEqual(r101.getKey(), "business_version")) == true) goto L23;
        Object r103 = r101.getValue().getValue();
        if (r103 == null) goto L17;
        String r104 = r103.toString();
    L19:
        if ((!Intrinsics.areEqual(r104, GlobalManager.f250637f.getAppVersion())) == false) goto L10;
    L17:
        r104 = null;
    L23:
        if (r102 == true) goto L31;
        if (a().contains(r210) == false) goto L47;
        a().remove(r210);
        g.a.f474886a.c(GlobalManager.f250642k.getContext(), "gecko_ak_with_custom_params", CollectionsKt.joinToString$default(a(), ",", null, null, 0, null, null, 62, null));
        EventSubType r105 = EventSubType.REGISTER_LATER_WITHOUT_CUSTOM;
        String r106 = String.valueOf(r211);
        JSONObject r107 = new JSONObject();
        r107.put("sub_type", r105.getType());
        if (r210 == null) goto L29;
        r107.put("access_key", r210);
    L29:
        r107.put(LocationMonitorConst.ERR_MSG, "");
        r107.put("extra", r106);
        y86.a.c("geckosdk_event_message", r107);
        update(r210);
        return;
    L47:
        return;
    L31:
        if (a().contains(r210) == true) goto L36;
        a().add(r210);
        g.a.f474886a.c(GlobalManager.f250642k.getContext(), "gecko_ak_with_custom_params", CollectionsKt.joinToString$default(a(), ",", null, null, 0, null, null, 62, null));
        EventSubType r108 = EventSubType.REGISTER_LATER_WITH_CUSTOM;
        String r109 = String.valueOf(r211);
        JSONObject r110 = new JSONObject();
        r110.put("sub_type", r108.getType());
        if (r210 == null) goto L35;
        r110.put("access_key", r210);
    L35:
        r110.put(LocationMonitorConst.ERR_MSG, "");
        r110.put("extra", r109);
        y86.a.c("geckosdk_event_message", r110);
    L36:
        RequestBodyUpdate r111 = new RequestBodyUpdate(ReqType.REGISTER_LATE);
        r111.initCustom(SetsKt.setOf(r210));
        UpdateRequest r112 = new UpdateRequest(r111);
        if (((ArrayList) f250853d).contains(r210) == false) goto L39;
        r112.f250795c = r210;
    L39:
        r112.f();
        return;
    L21:
        r102 = false;
        goto L23
    }
}
