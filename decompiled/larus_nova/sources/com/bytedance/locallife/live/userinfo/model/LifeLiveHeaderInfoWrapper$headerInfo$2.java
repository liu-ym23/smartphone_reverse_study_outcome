package com.bytedance.locallife.live.userinfo.model;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/locallife/live/userinfo/model/a;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/locallife/live/userinfo/model/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LifeLiveHeaderInfoWrapper$headerInfo$2 extends Lambda implements Function0<a> {
    final /* synthetic */ b this$0;

    public LifeLiveHeaderInfoWrapper$headerInfo$2(b r100) {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Object r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L10;
        LiveLifeSaaSUtil.t().d("life_live_header_info", "life_live_header_info parse error");
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r100 = r103;
    L14:
        return (a) r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
