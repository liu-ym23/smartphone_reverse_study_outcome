package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.ChameleonConfig;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements x0b.a {
    public c() {
    }

    @Override // x0b.a
    public final Map<String, y0b.c> h0(WebView r100, ChameleonConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "chameleonConfig");
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("emoji", new f1b.c()), TuplesKt.to("im", new f1b.d()), TuplesKt.to("temp", new f1b.e(r100)), TuplesKt.to("avatar", new f1b.a()), TuplesKt.to("docsIcon", new f1b.b())});
    }
}
