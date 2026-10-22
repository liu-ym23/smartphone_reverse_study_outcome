package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.entity.dto.InteractiveControl;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductListPresenter$handleDynamicInsert$2$1"}, k = 3, mv = {1, 4, 3})
final class ECShopHybridProductListPresenter$handleDynamicInsert$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InteractiveControl $interactiveInfo;
    final /* synthetic */ Map $itemConfigs;
    final /* synthetic */ ArrayList $items;
    final /* synthetic */ com.bytedance.android.ec.hybrid.list.entity.i $productSection;
    final /* synthetic */ String $recommendProductIds;
    final /* synthetic */ ECShopProductListBffResponseDTO $responseDto$inlined;
    final /* synthetic */ ECShopHybridProductListPresenter this$0;

    public ECShopHybridProductListPresenter$handleDynamicInsert$$inlined$apply$lambda$1(InteractiveControl r1, ArrayList r2, com.bytedance.android.ec.hybrid.list.entity.i r3, Map r4, String r5, ECShopHybridProductListPresenter r6, ECShopProductListBffResponseDTO r7) {
        this.$interactiveInfo = r1;
        this.$items = r2;
        this.$productSection = r3;
        this.$itemConfigs = r4;
        this.$recommendProductIds = r5;
        this.this$0 = r6;
        this.$responseDto$inlined = r7;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m217invoke() {
        String r0 = ECAppInfoService.e.getAppId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        JsonElement r2 = this.$interactiveInfo.getClientAiParams();
        if (r2 != null) goto L8;
    L15:
        JSONObject r3 = new JSONObject();
    L16:
        IPitayaCore r4 = PitayaCoreFactory.getCore(r0);
        String r5 = this.$interactiveInfo.getClientAiBusinessName();
        if (r5 == null) goto L20;
        r1 = r5;
    L20:
        r4.runTask(r1, new PTYTaskData(r3), new PTYTaskConfig(false, null, 0.0f, 7, null), new AnonymousClass1(this));
        return;
    L8:
        if (r2.isJsonObject() != true) goto L15;
        JsonElement r6 = this.$interactiveInfo.getClientAiParams();
        if (r6 == null) goto L14;
        JsonObject r7 = r6.getAsJsonObject();
        if (r7 == null) goto L14;
        r3 = tv5.a.c(r7);
    L14:
        r3 = new JSONObject("");
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m217invoke();
        return Unit.INSTANCE;
    }
}
