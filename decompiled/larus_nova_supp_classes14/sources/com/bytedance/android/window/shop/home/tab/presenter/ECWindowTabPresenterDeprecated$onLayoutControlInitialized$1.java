package com.bytedance.android.window.shop.home.tab.presenter;

import android.app.Activity;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModelDeprecated;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "name", "", "paramsMap", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECWindowTabPresenterDeprecated$onLayoutControlInitialized$1 extends Lambda implements Function2<String, Map<String, ? extends String>, Unit> {
    final /* synthetic */ ECWindowTabPresenterDeprecated this$0;

    public ECWindowTabPresenterDeprecated$onLayoutControlInitialized$1(ECWindowTabPresenterDeprecated r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        ECWindowTabPresenterDeprecated r0 = this.this$0;
        int r1 = ECWindowTabPresenterDeprecated.x;
        WindowTabViewModelDeprecated r2 = r0.k0();
        Pair[] r3 = new Pair[5];
        r3[0] = TuplesKt.to("store_type", "window");
        r3[1] = TuplesKt.to("author_id", this.this$0.j0().getShopParam().getAuthorId());
        r3[2] = TuplesKt.to("follow_status", String.valueOf(this.this$0.j0().getShopParam().getFollowStatus()));
        r3[3] = TuplesKt.to("tab_name", "100");
        Activity r4 = l0.b(this.this$0.a0().getContext());
        if (r4 == null) goto L7;
        JSONObject r7 = xn.c.c(r4);
        if (r7 == null) goto L7;
        String r8 = r7.toString();
    L8:
        r3[4] = TuplesKt.to("entrance_info", r8);
        r2.doEventAction(r5, r6, r3);
        return;
    L7:
        r8 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Map) r2);
        return Unit.INSTANCE;
    }
}
