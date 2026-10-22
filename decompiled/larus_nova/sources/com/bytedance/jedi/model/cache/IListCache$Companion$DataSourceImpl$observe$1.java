package com.bytedance.jedi.model.cache;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "K", "V", "it", "Lkotlin/Pair;", "", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IListCache$Companion$DataSourceImpl$observe$1 extends Lambda implements Function1<Pair<Object, ? extends List<Object>>, Boolean> {
    final /* synthetic */ Object $k;

    public IListCache$Companion$DataSourceImpl$observe$1(Object r100) {
        this.$k = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Pair<Object, ? extends List<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(Intrinsics.areEqual(this.$k, r100.getFirst()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Pair<Object, ? extends List<Object>> r100) {
        return invoke2(r100);
    }
}
