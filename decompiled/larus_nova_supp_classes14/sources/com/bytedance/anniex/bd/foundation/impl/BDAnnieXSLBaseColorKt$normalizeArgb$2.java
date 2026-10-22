package com.bytedance.anniex.bd.foundation.impl;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "x", "idx", "", "arr", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class BDAnnieXSLBaseColorKt$normalizeArgb$2 extends Lambda implements Function3<String, Integer, ArrayList<String>, String> {
    public static final BDAnnieXSLBaseColorKt$normalizeArgb$2 INSTANCE = null;

    static {
        INSTANCE = new BDAnnieXSLBaseColorKt$normalizeArgb$2();
    }

    public BDAnnieXSLBaseColorKt$normalizeArgb$2() {
        super(3);
    }

    public final String invoke(String r1, int r2, ArrayList<String> r3) {
        Intrinsics.checkNotNullParameter(r1, "x");
        Intrinsics.checkNotNullParameter(r3, "arr");
        return r1 + r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((String) r1, ((Number) r2).intValue(), (ArrayList) r3);
    }
}
