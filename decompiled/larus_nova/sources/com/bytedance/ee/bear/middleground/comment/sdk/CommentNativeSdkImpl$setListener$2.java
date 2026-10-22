package com.bytedance.ee.bear.middleground.comment.sdk;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "topLocation", "", "<unused var>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CommentNativeSdkImpl$setListener$2 extends Lambda implements Function2<Integer, Boolean, Unit> {
    final /* synthetic */ a this$0;

    public CommentNativeSdkImpl$setListener$2(a r100) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Boolean r101) {
        invoke(r100.intValue(), r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, boolean r101) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        throw null;
    }
}
