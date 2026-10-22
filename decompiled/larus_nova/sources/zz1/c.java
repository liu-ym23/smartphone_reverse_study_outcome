package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.x;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.kmp.livesdk.gift.platform.aio.service.client.OperationResultCode;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oc6.i0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements oc6.l, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1 f574020a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // oc6.l
    public final oc6.c getCurrentAISortInfo() {
        this.f574020a.getClass();
        JSONObject r100 = new JSONObject();
        r100.put("room_live_scene", null);
        r100.put("strategy_info", null);
        return new oc6.c(r100.toString());
    }

    public c(f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listSortService");
        this.f574020a = r100;
    }

    @Override // oc6.l
    public final i0 getAllGiftAIAgentDataByDimension(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dimensionKey");
        x r101 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r100, "key");
        if (Intrinsics.areEqual(r100, "") == true) goto L14;
        Map r102 = (Map) ((LinkedHashMap) r101.f128574a).get(r100);
        if (r102 == null) goto L11;
        Collection r103 = r102.values();
        if (r103 == null) goto L11;
        List r104 = CollectionsKt.toList(r103);
        if (r104 == null) goto L11;
    L13:
        return new i0(0, r104, null, 5);
    L11:
        r104 = CollectionsKt.emptyList();
        goto L13
    L14:
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    }

    @Override // oc6.l
    public final i0 removeSingleGiftAIAgentData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dimensionKey");
        Intrinsics.checkNotNullParameter(r101, "queryId");
        x r102 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "queryId");
        if (Intrinsics.areEqual(r100, "") == true) goto L16;
        Map r103 = (Map) ((LinkedHashMap) r102.f128574a).get(r100);
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r103.remove(r101);
        return new i0(0, null, null, 7);
    L15:
        return new i0(OperationResultCode.ListIsEmpty.getValue(), null, "Current list does not exist!", 2);
    L8:
        if (r103.isEmpty() == true) goto L11;
        r104 = false;
        goto L12
    L16:
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    }

    @Override // oc6.l
    public final i0 pushSingleGiftAIAgentData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "dimensionKey");
        Intrinsics.checkNotNullParameter(r101, "queryId");
        Intrinsics.checkNotNullParameter(r102, "data");
        x r103 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "queryId");
        Intrinsics.checkNotNullParameter(r102, "element");
        if (Intrinsics.areEqual(r100, "") == false) goto L6;
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    L6:
        if (r103.f128574a.size() >= r103.f128575b) goto L8;
    L10:
        LinkedHashMap r104 = (LinkedHashMap) r103.f128574a;
        Object r105 = r104.get(r100);
        if (r105 != null) goto L13;
        r105 = new LinkedHashMap();
        r104.put(r100, r105);
    L13:
        Map r106 = (Map) r105;
        r106.put(r101, r102);
        if (r106.size() <= r103.f128576c) goto L17;
        r106.remove(CollectionsKt.first(r106.keySet()));
    L17:
        return new i0(0, null, null, 7);
    L8:
        if (r103.f128574a.containsKey(r100) == true) goto L10;
        String r107 = (String) CollectionsKt.first(((LinkedHashMap) r103.f128574a).keySet());
        r103.f128574a.remove(r107);
        goto L10
    }

    @Override // oc6.l
    public final i0 updateSingleGiftAIAgentData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "dimensionKey");
        Intrinsics.checkNotNullParameter(r101, "queryId");
        Intrinsics.checkNotNullParameter(r102, "data");
        x r103 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "queryId");
        Intrinsics.checkNotNullParameter(r102, "element");
        if (Intrinsics.areEqual(r100, "") == true) goto L16;
        Map r104 = (Map) ((LinkedHashMap) r103.f128574a).get(r100);
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L15;
        r104.put(r101, r102);
        return new i0(0, null, null, 7);
    L15:
        return new i0(OperationResultCode.ListIsEmpty.getValue(), null, "Current list does not exist!", 2);
    L8:
        if (r104.isEmpty() == true) goto L11;
        r105 = false;
        goto L12
    L16:
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    }
}
