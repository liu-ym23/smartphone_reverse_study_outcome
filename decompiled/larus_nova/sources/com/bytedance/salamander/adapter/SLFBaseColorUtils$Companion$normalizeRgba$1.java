package com.bytedance.salamander.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "x", "idx", "", "arr", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLFBaseColorUtils$Companion$normalizeRgba$1 extends Lambda implements Function3<String, Integer, ArrayList<String>, String> {
    public static final SLFBaseColorUtils$Companion$normalizeRgba$1 INSTANCE = null;

    static {
        INSTANCE = new SLFBaseColorUtils$Companion$normalizeRgba$1();
    }

    public SLFBaseColorUtils$Companion$normalizeRgba$1() {
        super(3);
    }

    public final String invoke(String r100, int r101, ArrayList<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "x");
        Intrinsics.checkNotNullParameter(r102, "arr");
        return r100 + r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(String r100, Integer r101, ArrayList<String> r102) {
        return invoke(r100, r101.intValue(), r102);
    }
}
