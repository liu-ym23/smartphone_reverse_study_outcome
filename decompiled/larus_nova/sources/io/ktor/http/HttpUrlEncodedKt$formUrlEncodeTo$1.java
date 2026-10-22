package io.ktor.http;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpUrlEncodedKt$formUrlEncodeTo$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {
    public static final HttpUrlEncodedKt$formUrlEncodeTo$1 INSTANCE = null;

    static {
        INSTANCE = new HttpUrlEncodedKt$formUrlEncodeTo$1();
    }

    public HttpUrlEncodedKt$formUrlEncodeTo$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Pair<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = CodecsKt.f(r100.getFirst(), true);
        if (r100.getSecond() != null) goto L6;
        return r101;
    L6:
        return r101 + com.alipay.sdk.m.n.a.f25612h + CodecsKt.g(String.valueOf(r100.getSecond()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> r100) {
        return invoke2(r100);
    }
}
