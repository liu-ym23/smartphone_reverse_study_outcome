package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lcom/larus/paging/g0$a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class PagedList$addWeakCallback$1 extends Lambda implements Function1<WeakReference<g0.a>, Boolean> {
    public static final PagedList$addWeakCallback$1 INSTANCE = null;

    static {
        INSTANCE = new PagedList$addWeakCallback$1();
    }

    public PagedList$addWeakCallback$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<g0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.get() != null) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<g0.a> r100) {
        return invoke2(r100);
    }
}
