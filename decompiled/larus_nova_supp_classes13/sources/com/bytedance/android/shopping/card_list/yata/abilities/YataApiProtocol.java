package com.bytedance.android.shopping.card_list.yata.abilities;

import com.bytedance.android.shopping.card_list.abilities.CardMultiUpdateComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v96.j;
import v96.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class YataApiProtocol implements v96.a {
    public final Lazy a;
    public final CardListObjectContainer b;
    public final String c;
    public final Map<String, Object> d;

    public final j a(m r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        String r5 = this.c;
        LinkedHashMap r0 = new LinkedHashMap();
        CardPassThroughData r1 = this.b.e.a;
        if (r1 == null) goto L7;
        HashMap<String, String> r2 = r1.getSchemaParamsOrCreate();
        if (r2 == null) goto L7;
        r0.putAll(r2);
    L7:
        CardMultiUpdateComponent r3 = (CardMultiUpdateComponent) this.a.getValue();
        if (r3 == null) goto L10;
        Long r6 = Long.valueOf(r3.h());
    L11:
        r0.put("uplink_version", r6);
        Map<String, Object> r7 = this.d;
        if (r7 == null) goto L14;
        r0.putAll(r7);
    L14:
        Unit r8 = Unit.INSTANCE;
        return new j(r5, r0);
    L10:
        r6 = null;
        goto L11
    }

    public YataApiProtocol(CardListObjectContainer r2, String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "api");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(new YataApiProtocol$cardMultiUpdateComponent$2(this));
    }
}
