package com.bytedance.ee.bear.bitable.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExceptionUtilKt$throwOrLog$1 extends Lambda implements Function1<String, RuntimeException> {
    public static final ExceptionUtilKt$throwOrLog$1 INSTANCE = null;

    static {
        INSTANCE = new ExceptionUtilKt$throwOrLog$1();
    }

    public ExceptionUtilKt$throwOrLog$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RuntimeException invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return new RuntimeException(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ RuntimeException invoke(String r100) {
        return invoke2(r100);
    }
}
