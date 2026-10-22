package com.bytedance.ee.bear.basesdk.business.comment;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "hasAnim", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Boolean;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseCommentPlugin$init$7 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ a this$0;

    public BaseCommentPlugin$init$7(a r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean r100) {
        tt5.a.h("BaseCommentPlugin", "clost comment listener invoke");
        a r101 = this.this$0;
        int r102 = a.f206587a;
        r101.getClass();
        this.this$0.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
