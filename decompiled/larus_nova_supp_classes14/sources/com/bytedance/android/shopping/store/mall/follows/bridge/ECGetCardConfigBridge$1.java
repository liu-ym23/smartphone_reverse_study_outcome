package com.bytedance.android.shopping.store.mall.follows.bridge;

import com.bytedance.android.ec.sdk.helper.d;
import fj.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "", "params", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECGetCardConfigBridge$1 extends Lambda implements Function1<Map<String, ? extends Object>, Map<String, ? extends Object>> {
    public static final ECGetCardConfigBridge$1 INSTANCE = null;

    static {
        INSTANCE = new ECGetCardConfigBridge$1();
    }

    public ECGetCardConfigBridge$1() {
        super(1);
    }

    public final Map<String, Object> invoke(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Pair[] r6 = new Pair[2];
        boolean r2 = false;
        r6[0] = TuplesKt.to("code", 1);
        JSONObject r1 = new JSONObject();
        a r3 = d.b.getAudioMuteService();
        if (r3 == null) goto L5;
        r3.c();
    L6:
        r1.put("is_global_muted", r2);
        Unit r4 = Unit.INSTANCE;
        r6[1] = TuplesKt.to("result", r1);
        return MapsKt.mutableMapOf(r6);
    L5:
        r2 = true;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map) r1);
    }
}
