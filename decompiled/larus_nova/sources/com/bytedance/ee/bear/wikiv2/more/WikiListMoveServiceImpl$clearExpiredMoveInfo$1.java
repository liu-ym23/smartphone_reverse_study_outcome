package com.bytedance.ee.bear.wikiv2.more;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u0005\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00050\u0003¢\u0006\u0002\b\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "it", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "Lcom/bytedance/ee/bear/wikiv2/more/WikiListMoveServiceImpl$CachedMoveInfo;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/Map$Entry;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WikiListMoveServiceImpl$clearExpiredMoveInfo$1 extends Lambda implements Function1<Map.Entry<String, c.a>, Boolean> {
    public static final WikiListMoveServiceImpl$clearExpiredMoveInfo$1 INSTANCE = null;

    static {
        INSTANCE = new WikiListMoveServiceImpl$clearExpiredMoveInfo$1();
    }

    public WikiListMoveServiceImpl$clearExpiredMoveInfo$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Map.Entry<String, c.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(!r100.getValue().a());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<String, c.a> r100) {
        return invoke2(r100);
    }
}
