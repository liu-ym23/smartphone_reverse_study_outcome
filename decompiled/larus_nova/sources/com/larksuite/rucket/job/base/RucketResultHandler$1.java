package com.larksuite.rucket.job.base;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class RucketResultHandler$1 extends Lambda implements Function1<ErrorResult, Unit> {
    public static final RucketResultHandler$1 INSTANCE = null;

    static {
        INSTANCE = new RucketResultHandler$1();
    }

    public RucketResultHandler$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ErrorResult r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
