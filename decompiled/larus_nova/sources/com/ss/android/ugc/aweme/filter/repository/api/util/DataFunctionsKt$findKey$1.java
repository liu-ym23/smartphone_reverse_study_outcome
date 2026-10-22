package com.ss.android.ugc.aweme.filter.repository.api.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "K", "V", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Z"}, k = 3, mv = {1, 4, 1})
final class DataFunctionsKt$findKey$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Object $v;

    public DataFunctionsKt$findKey$1(Object r100) {
        this.$v = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object r100) {
        return Intrinsics.areEqual(r100, this.$v);
    }
}
