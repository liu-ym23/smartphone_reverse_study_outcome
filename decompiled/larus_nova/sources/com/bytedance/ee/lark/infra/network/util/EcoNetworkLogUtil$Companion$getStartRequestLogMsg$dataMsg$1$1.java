package com.bytedance.ee.lark.infra.network.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "entry", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class EcoNetworkLogUtil$Companion$getStartRequestLogMsg$dataMsg$1$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {
    public static final EcoNetworkLogUtil$Companion$getStartRequestLogMsg$dataMsg$1$1 INSTANCE = null;

    static {
        INSTANCE = new EcoNetworkLogUtil$Companion$getStartRequestLogMsg$dataMsg$1$1();
    }

    public EcoNetworkLogUtil$Companion$getStartRequestLogMsg$dataMsg$1$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Pair<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        return r100.getFirst() + " = " + r100.getSecond();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> r100) {
        return invoke2(r100);
    }
}
