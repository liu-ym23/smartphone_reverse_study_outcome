package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECShopTabKitCompatPresenter$reportTabEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ Map $paramsMap;
    final /* synthetic */ uj3.j $tabVO;
    final /* synthetic */ ECShopTabKitCompatPresenter this$0;

    public ECShopTabKitCompatPresenter$reportTabEvent$1(ECShopTabKitCompatPresenter r1, String r2, uj3.j r3, Map r4) {
        this.this$0 = r1;
        this.$eventName = r2;
        this.$tabVO = r3;
        this.$paramsMap = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m142invoke() {
        ECShopTabKitCompatPresenter r0 = this.this$0;
        String r4 = this.$eventName;
        uj3.j r1 = this.$tabVO;
        Map<? extends String, ? extends Object> r2 = this.$paramsMap;
        int r3 = ECShopTabKitCompatPresenter.z;
        r0.getClass();
        String r5 = r1.b();
        String r6 = r1.a(r0.y());
        LinkedHashMap r7 = new LinkedHashMap();
        if (r2 != null) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        r7.putAll(r2);
        Map<String, String> r8 = r1.n;
        if (r8 != null) goto L8;
        r8 = MapsKt.emptyMap();
    L8:
        r7.putAll(r8);
        ECStoreViewModel r9 = r0.T();
        PageFinder r10 = PageFinder.via(r0.y());
        Pair<String, ? extends Object>[] r11 = new Pair[7];
        r11[0] = TuplesKt.to("author_id", r0.T().getStoreParam().getStoreAccountParam().getUserId());
        Integer r12 = r0.T().getStoreParam().getFollowStatus();
        String r13 = "";
        if (r12 == null) goto L12;
        String r14 = String.valueOf(r12.intValue());
        if (r14 == null) goto L12;
    L13:
        r11[1] = TuplesKt.to("follow_status", r14);
        Map<String, String> r15 = r0.u;
        Map<String, String> r16 = r1.n;
        String r17 = null;
        if (r16 == null) goto L16;
        String r18 = r16.get("auto_category");
    L17:
        String r19 = r15.get(r18);
        if (r19 != null) goto L20;
        r19 = "";
    L20:
        r11[2] = TuplesKt.to("page_version", r19);
        com.bytedance.android.shopping.store.home.entity.n r20 = (com.bytedance.android.shopping.store.home.entity.n) r0.T().getHeaderArea().getValue();
        if (r20 == null) goto L27;
        com.bytedance.android.shopping.store.home.entity.g r21 = r20.e;
        if (r21 == null) goto L27;
        Integer r22 = r21.a;
        if (r22 == null) goto L27;
        r17 = String.valueOf(r22.intValue());
    L27:
        if (r17 == null) goto L30;
        r13 = r17;
    L30:
        r11[3] = TuplesKt.to("product_count", r13);
        r11[4] = TuplesKt.to("temp_id", r0.T().getStoreParam().getTempId());
        r11[5] = TuplesKt.to("tab_name", r5);
        r11[6] = TuplesKt.to("tab_id", Integer.valueOf(r1.d));
        r9.doAnyEventActionWithBtm(r6, r10, r4, r7, r11);
        return;
    L16:
        r18 = null;
    L12:
        r14 = "";
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m142invoke();
        return Unit.INSTANCE;
    }
}
