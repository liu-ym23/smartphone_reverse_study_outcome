package com.bytedance.kmp.ec.yata.common.log;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
final class YaTaLog$w$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<String> $message;
    final /* synthetic */ String $tag;

    public YaTaLog$w$1(String r100, Function0<String> r101) {
        this.$tag = r100;
        this.$message = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String r100 = YaTaLog.f251436a;
        a r101 = YaTaLog.f251441f;
        if (r101 == null) goto L6;
        r101.w("YATA-" + this.$tag, this.$message.invoke());
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
