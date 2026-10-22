package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0003*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/paging/b;", "kotlin.jvm.PlatformType", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/paging/b;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class AsyncPagedListDiffer$removePagedListListener$1 extends Lambda implements Function1<b<Object>, Boolean> {
    final /* synthetic */ Function2<g0<Object>, g0<Object>, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncPagedListDiffer$removePagedListListener$1(Function2<? super g0<Object>, ? super g0<Object>, Unit> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(b<Object> r100) {
        if ((r100 instanceof a) == false) goto L7;
        ((a) r100).getClass();
        if (this.$callback != null) goto L7;
        boolean r101 = true;
    L9:
        return Boolean.valueOf(r101);
    L7:
        r101 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(b<Object> r100) {
        return invoke2(r100);
    }
}
