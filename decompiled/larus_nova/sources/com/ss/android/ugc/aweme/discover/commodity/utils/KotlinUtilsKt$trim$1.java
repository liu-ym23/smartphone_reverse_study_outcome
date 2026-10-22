package com.ss.android.ugc.aweme.discover.commodity.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3}, xi = 176)
public final class KotlinUtilsKt$trim$1 extends Lambda implements Function1<?, Boolean> {
    public static final KotlinUtilsKt$trim$1 INSTANCE = null;

    static {
        INSTANCE = new KotlinUtilsKt$trim$1();
    }

    public KotlinUtilsKt$trim$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object r100) {
        if (r100 != 0) goto L4;
        boolean r101 = true;
    L6:
        return Boolean.valueOf(r101);
    L4:
        r101 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Boolean invoke2(Object r100) {
        return invoke(r100);
    }
}
