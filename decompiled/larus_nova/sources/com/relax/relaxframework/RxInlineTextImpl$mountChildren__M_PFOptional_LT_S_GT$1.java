package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxInlineTextImpl$mountChildren__M_PFOptional_LT_S_GT$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<String> $___val;
    final /* synthetic */ q6 $rawText;

    public RxInlineTextImpl$mountChildren__M_PFOptional_LT_S_GT$1(Function0<String> r100, q6 r101) {
        this.$___val = r100;
        this.$rawText = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String r100 = this.$___val.invoke();
        if (r100 == null) goto L5;
        this.$rawText.w0(r100);
        return;
    L5:
        this.$rawText.w0("");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
