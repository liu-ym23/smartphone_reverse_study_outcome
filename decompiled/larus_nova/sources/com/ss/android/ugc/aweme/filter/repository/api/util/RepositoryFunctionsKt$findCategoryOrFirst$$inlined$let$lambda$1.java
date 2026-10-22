package com.ss.android.ugc.aweme.filter.repository.api.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.filter.FilterBean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "tableBean", "Lcom/ss/android/ugc/aweme/filter/FilterBean;", AbsMethodDelegate.TAG_INVOKE, "com/ss/android/ugc/aweme/filter/repository/api/util/RepositoryFunctionsKt$findCategoryOrFirst$1$1"}, k = 3, mv = {1, 4, 1})
final class RepositoryFunctionsKt$findCategoryOrFirst$$inlined$let$lambda$1 extends Lambda implements Function1<FilterBean, Boolean> {
    final /* synthetic */ FilterBean $filterBean$inlined;

    public RepositoryFunctionsKt$findCategoryOrFirst$$inlined$let$lambda$1(FilterBean r100) {
        this.$filterBean$inlined = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FilterBean r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FilterBean r100) {
        Intrinsics.checkNotNullParameter(r100, "tableBean");
        return Intrinsics.areEqual(r100, this.$filterBean$inlined);
    }
}
