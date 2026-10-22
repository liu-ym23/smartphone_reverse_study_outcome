package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import com.bytedance.awemeopen.infra.support.AoThrowableResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/support/AoThrowableResult;", "Li34/a$a;", "", "invoke", "(Lcom/bytedance/awemeopen/infra/support/AoThrowableResult;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ShareHelper$getOriginLinkShare$1 extends Lambda implements Function1<AoThrowableResult<i34.a.a>, Unit> {
    final /* synthetic */ Function1<AoThrowableResult<i24.c>, Unit> $callback;

    public ShareHelper$getOriginLinkShare$1(Function1<? super AoThrowableResult<i24.c>, Unit> r1) {
        this.$callback = r1;
        super(1);
    }

    public final void invoke(AoThrowableResult<i34.a.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getOriginLinkShare");
        Object r4 = r3.a;     // Catch: Throwable -> L9
        if ((r4 instanceof AoThrowableResult.b) == true) goto L8;
        int r0 = AoThrowableResult.d;     // Catch: Throwable -> L9
        ((i34.a.a) r4).getClass();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(null, "desc");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(null, "url");     // Catch: Throwable -> L9
        throw null;     // Catch: Throwable -> L9
    L8:
        throw ((AoThrowableResult.b) r4).a;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Function1<AoThrowableResult<i24.c>, Unit> r1 = this.$callback;
        int r2 = AoThrowableResult.d;
        r1.invoke(AoThrowableResult.a.a(th));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((AoThrowableResult) r1);
        return Unit.INSTANCE;
    }
}
