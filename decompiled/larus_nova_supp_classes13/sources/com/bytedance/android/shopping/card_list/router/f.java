package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import com.bytedance.android.shopping.extensions.k;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends CardListKitStarter {
    @Override // com.bytedance.android.shopping.card_list.router.CardListKitStarter
    public final CardPassThroughData b(HashMap<String, String> r13) {
        Intrinsics.checkNotNullParameter(r13, "schemaMap");
        CardPassThroughData r0 = super.b(r13);
        String r1 = r13.get("previous_page");
        String r2 = r13.get("is_from_personal");
        String r3 = r13.get("collect_experiment_value");
        String r4 = r13.get("sec_uid");
        if (r4 != null) goto L5;
        String r6 = "";
    L6:
        String r7 = r13.get("uid");
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        String r14 = r13.get("uid");
        if (r14 != null) goto L13;
        r14 = "";
    L13:
        if (r1 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        r1 = "personal_homepage";
    L21:
        String r8 = r6;
        String r9 = r7;
        String r10 = r14;
        r0.setCollectSchemaData(new CollectPassThroughData(r8, r9, r10, r1, Intrinsics.areEqual(r2, "1"), k.r(r3, 0)));
        return r0;
    L15:
        if (r1.length() == 0) goto L18;
        r5 = false;
        goto L19
    L5:
        r6 = r4;
        goto L6
    }

    public f(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "pageConfig");
        super(r2, r3);
    }
}
