package com.bytedance.jedi.model.datasource;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032`\u0010\u0004\u001a\\\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003 \u0007*\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0018\u00010\u00060\u0006 \u0007*,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003 \u0007*\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0018\u00010\u00060\u00060\b0\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "K", "V", "it", "", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AbstractDataSource$batchEmit$2 extends Lambda implements Function1<List<Pair<Object, Object>>, Boolean> {
    public static final AbstractDataSource$batchEmit$2 INSTANCE = null;

    static {
        INSTANCE = new AbstractDataSource$batchEmit$2();
    }

    public AbstractDataSource$batchEmit$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(List<Pair<Object, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.size() <= 0) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(List<Pair<Object, Object>> r100) {
        return invoke2(r100);
    }
}
