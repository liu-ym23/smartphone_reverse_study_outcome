package com.bytedance.bdp.appbase.cpapi.impl;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/bdp/appbase/cpapi/impl/a;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/bdp/appbase/cpapi/impl/a;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class CpApiServiceImpl$mApiRuntime$2 extends Lambda implements Function0<a> {
    final /* synthetic */ BdpAppContext $context;

    public CpApiServiceImpl$mApiRuntime$2(BdpAppContext r100) {
        this.$context = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return new a(this.$context);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
