package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.retrofit2.SsResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/bytedance/retrofit2/SsResponse;", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LifePreRequestParams$1 extends Lambda implements Function2<SsResponse<?>, String, Unit> {
    public static final LifePreRequestParams$1 INSTANCE = null;

    static {
        INSTANCE = new LifePreRequestParams$1();
    }

    public LifePreRequestParams$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SsResponse<?> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 1>");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SsResponse<?> r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
