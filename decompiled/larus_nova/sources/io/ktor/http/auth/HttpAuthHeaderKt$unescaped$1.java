package io.ktor.http.auth;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpAuthHeaderKt$unescaped$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    public static final HttpAuthHeaderKt$unescaped$1 INSTANCE = null;

    static {
        INSTANCE = new HttpAuthHeaderKt$unescaped$1();
    }

    public HttpAuthHeaderKt$unescaped$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(MatchResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return StringsKt.takeLast(r100.getValue(), 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(MatchResult r100) {
        return invoke2(r100);
    }
}
