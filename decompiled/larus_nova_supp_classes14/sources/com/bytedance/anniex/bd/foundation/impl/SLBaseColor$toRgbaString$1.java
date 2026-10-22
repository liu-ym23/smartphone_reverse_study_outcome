package com.bytedance.anniex.bd.foundation.impl;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "v", "", "i", "arr", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SLBaseColor$toRgbaString$1 extends Lambda implements Function3<Integer, Integer, ArrayList<Integer>, String> {
    public static final SLBaseColor$toRgbaString$1 INSTANCE = null;

    static {
        INSTANCE = new SLBaseColor$toRgbaString$1();
    }

    public SLBaseColor$toRgbaString$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Number) r1).intValue(), ((Number) r2).intValue(), (ArrayList) r3);
    }

    public final String invoke(int r1, int r2, ArrayList<Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "arr");
        return d.a(r1);
    }
}
