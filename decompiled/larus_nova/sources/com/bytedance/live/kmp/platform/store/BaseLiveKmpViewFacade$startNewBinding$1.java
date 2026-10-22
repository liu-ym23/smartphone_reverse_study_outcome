package com.bytedance.live.kmp.platform.store;

import com.bytedance.android.scope.j;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\f\b\u0001\u0010\u0004*\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "VIEW", "Lcom/bytedance/android/scope/j;", "Lcom/bytedance/tools/kcp/kmpscope/runtime/Scope;", CommonConstant.RETKEY.SCOPE, "p1", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/scope/j;)Lcom/bytedance/android/scope/j;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class BaseLiveKmpViewFacade$startNewBinding$1 extends FunctionReferenceImpl implements Function1<j, j> {
    public BaseLiveKmpViewFacade$startNewBinding$1(a r100) {
        super(1, r100, a.class, "enterOrGetScope", "enterOrGetScope(Lcom/bytedance/android/scope/Scope;)Lcom/bytedance/android/scope/Scope;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j invoke2(j r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return ((a) this.receiver).a();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j invoke(j r100) {
        return invoke2(r100);
    }
}
