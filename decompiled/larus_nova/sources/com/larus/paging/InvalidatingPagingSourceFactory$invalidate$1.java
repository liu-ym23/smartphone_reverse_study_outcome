package com.larus.paging;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032&\u0010\u0005\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004 \u0007*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Lcom/larus/paging/PagingSource;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/paging/PagingSource;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class InvalidatingPagingSourceFactory$invalidate$1 extends Lambda implements Function1<PagingSource<Object, Object>, Boolean> {
    public static final InvalidatingPagingSourceFactory$invalidate$1 INSTANCE = null;

    static {
        INSTANCE = new InvalidatingPagingSourceFactory$invalidate$1();
    }

    public InvalidatingPagingSourceFactory$invalidate$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(PagingSource<Object, Object> r100) {
        return Boolean.valueOf(r100.f363720a.f363915e);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PagingSource<Object, Object> r100) {
        return invoke2(r100);
    }
}
