package com.larus.paging;

import androidx.arch.core.util.Function;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ToValue", "", "Key", "Value", "list", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DataSource$map$1 extends Lambda implements Function1<List<Object>, List<Object>> {
    final /* synthetic */ Function<Object, Object> $function;

    public DataSource$map$1(Function<Object, Object> r100) {
        this.$function = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<Object> invoke2(List<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        List<Object> r101 = r100;
        Function<Object, Object> r102 = this.$function;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r102.apply(r104.next()));
        goto L4
    L6:
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<Object> invoke(List<Object> r100) {
        return invoke2(r100);
    }
}
