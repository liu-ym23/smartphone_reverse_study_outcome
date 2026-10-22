package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import com.bytedance.awemeopen.infra.support.AoThrowableResult;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/support/AoThrowableResult;", "Li34/a$a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/awemeopen/infra/support/AoThrowableResult;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ShareHelper$getOriginLinkShare$1 extends Lambda implements Function1<AoThrowableResult<i34.a.C6222a>, Unit> {
    final /* synthetic */ Function1<AoThrowableResult<i24.c>, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareHelper$getOriginLinkShare$1(Function1<? super AoThrowableResult<i24.c>, Unit> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AoThrowableResult<i34.a.C6222a> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOriginLinkShare");
        Object r101 = r100.f198935a;     // Catch: Throwable -> L9
        if ((r101 instanceof AoThrowableResult.b) == true) goto L8;
        int r102 = AoThrowableResult.f198934d;     // Catch: Throwable -> L9
        ((i34.a.C6222a) r101).getClass();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(null, SocialConstants.PARAM_APP_DESC);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(null, "url");     // Catch: Throwable -> L9
        throw null;     // Catch: Throwable -> L9
    L8:
        throw ((AoThrowableResult.b) r101).f198938a;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Function1<AoThrowableResult<i24.c>, Unit> r103 = this.$callback;
        int r104 = AoThrowableResult.f198934d;
        r103.invoke(AoThrowableResult.a.a(th));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AoThrowableResult<i34.a.C6222a> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
