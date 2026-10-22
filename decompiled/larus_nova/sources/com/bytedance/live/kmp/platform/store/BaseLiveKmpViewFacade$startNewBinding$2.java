package com.bytedance.live.kmp.platform.store;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\f\b\u0001\u0010\u0004*\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "VIEW", "Lcom/bytedance/android/scope/j;", "Lcom/bytedance/tools/kcp/kmpscope/runtime/Scope;", CommonConstant.RETKEY.SCOPE, "", AbsMethodDelegate.TAG_INVOKE, "()V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class BaseLiveKmpViewFacade$startNewBinding$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public BaseLiveKmpViewFacade$startNewBinding$2(a r100) {
        super(0, r100, a.class, "leaveScope", "leaveScope()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((a) this.receiver).b();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
