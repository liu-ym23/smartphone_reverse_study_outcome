package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RegExp$1 extends Lambda implements Function1<MatchResult, String> {
    public static final RegExp$1 INSTANCE = null;

    static {
        INSTANCE = new RegExp$1();
    }

    public RegExp$1() {
        super(1);
    }

    public final String invoke(MatchResult r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (String) ListProtector.get(r2.getGroupValues(), 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((MatchResult) r1);
    }
}
