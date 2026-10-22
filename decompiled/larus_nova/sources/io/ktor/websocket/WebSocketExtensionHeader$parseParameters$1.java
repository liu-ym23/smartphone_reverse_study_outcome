package io.ktor.websocket;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class WebSocketExtensionHeader$parseParameters$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends String>> {
    public static final WebSocketExtensionHeader$parseParameters$1 INSTANCE = null;

    static {
        INSTANCE = new WebSocketExtensionHeader$parseParameters$1();
    }

    public WebSocketExtensionHeader$parseParameters$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<String, String> invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = StringsKt.indexOf$default(r100, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);
        String r102 = "";
        if (r101 < 0) goto L5;
        String r103 = StringsKt.substring(r100, RangesKt.until(0, r101));
        int r104 = r101 + 1;
        if (r104 >= r100.length()) goto L10;
        r102 = r100.substring(r104);
    L10:
        return TuplesKt.to(r103, r102);
    L5:
        return TuplesKt.to(r100, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends String, ? extends String> invoke(String r100) {
        return invoke2(r100);
    }
}
