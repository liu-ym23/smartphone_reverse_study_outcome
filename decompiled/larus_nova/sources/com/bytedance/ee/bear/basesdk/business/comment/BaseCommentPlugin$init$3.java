package com.bytedance.ee.bear.basesdk.business.comment;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "data", "", "action", "Lcom/bytedance/ee/bear/middleground/comment/export/Action;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseCommentPlugin$init$3 extends Lambda implements Function2<String, Action, Unit> {
    final /* synthetic */ a this$0;

    public BaseCommentPlugin$init$3(a r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Action r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        tt5.a.h("BaseCommentPlugin", "filterdata action = " + r101);
        a r102 = this.this$0;
        int r103 = a.f206587a;
        r102.getClass();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Action r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
