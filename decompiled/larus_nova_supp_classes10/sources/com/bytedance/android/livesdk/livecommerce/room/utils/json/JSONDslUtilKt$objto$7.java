package com.bytedance.android.livesdk.livecommerce.room.utils.json;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
final class JSONDslUtilKt$objto$7 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $this_objto;
    final /* synthetic */ JSONArray $value;

    public JSONDslUtilKt$objto$7(String r1, JSONArray r2) {
        this.$this_objto = r1;
        this.$value = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.put(this.$this_objto, this.$value);
    }
}
