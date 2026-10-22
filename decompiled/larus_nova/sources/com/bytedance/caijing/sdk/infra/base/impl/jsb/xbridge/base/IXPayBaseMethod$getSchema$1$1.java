package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class IXPayBaseMethod$getSchema$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ IXPayBaseMethod $this_runCatching;

    public IXPayBaseMethod$getSchema$1$1(IXPayBaseMethod r100) {
        this.$this_runCatching = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        CallContext r100 = (CallContext) this.$this_runCatching.provideContext(CallContext.class);
        if (r100 == null) goto L5;
        String r101 = r100.f249267b;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
