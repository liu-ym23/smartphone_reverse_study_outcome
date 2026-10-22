package com.bytedance.android.shopping.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "type", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class GalleryEventUtil$bind$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ Function1 $ability;

    public GalleryEventUtil$bind$1(Function1 r1) {
        this.$ability = r1;
        super(2);
    }

    public final void invoke(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        JSONObject r0 = new JSONObject();
        r0.put("action", r4);
        r0.put("position", r3);
        this.$ability.invoke(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), (String) r2);
        return Unit.INSTANCE;
    }
}
