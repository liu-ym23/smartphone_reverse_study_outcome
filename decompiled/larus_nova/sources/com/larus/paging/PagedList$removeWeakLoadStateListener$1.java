package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lkotlin/Function2;", "Lcom/larus/paging/LoadType;", "Lcom/larus/paging/u;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class PagedList$removeWeakLoadStateListener$1 extends Lambda implements Function1<WeakReference<Function2<? super LoadType, ? super u, ? extends Unit>>, Boolean> {
    final /* synthetic */ Function2<LoadType, u, Unit> $listener;

    /* JADX WARN: Multi-variable type inference failed */
    public PagedList$removeWeakLoadStateListener$1(Function2<? super LoadType, ? super u, Unit> r100) {
        this.$listener = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<Function2<LoadType, u, Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.get() != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return Boolean.valueOf(r101);
    L5:
        if (r100.get() == this.$listener) goto L8;
        r101 = false;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function2<? super LoadType, ? super u, ? extends Unit>> r100) {
        return invoke2(r100);
    }
}
