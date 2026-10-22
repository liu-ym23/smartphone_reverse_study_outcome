package com.bytedance.android.livesdk.livecommerce.room;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012:\u0010\u0002\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "it", "", "Lkotlin/Pair;", "", "", "Lcom/bytedance/revenue/platform/api/core/Entry;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ControllerCache$removeController$1 extends Lambda implements Function1<Map.Entry<? extends Pair<? extends String, ? extends String>, ? extends Object>, Boolean> {
    final /* synthetic */ String $roomId;
    final /* synthetic */ String $uniqueKey;

    public ControllerCache$removeController$1(String r1, String r2) {
        this.$roomId = r1;
        this.$uniqueKey = r2;
        super(1);
    }

    public final boolean invoke(Map.Entry<Pair<String, String>, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (Intrinsics.areEqual((String) r3.getKey().getFirst(), this.$roomId) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual((String) r3.getKey().getSecond(), this.$uniqueKey) == false) goto L7;
        return true;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((Map.Entry) r1));
    }
}
