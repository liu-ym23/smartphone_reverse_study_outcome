package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp57/c;", "crashPortrait", "", AbsMethodDelegate.TAG_INVOKE, "(Lp57/c;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class InitHelper$initCrashProtect$2 extends Lambda implements Function1<p57.c, Unit> {
    public static final InitHelper$initCrashProtect$2 INSTANCE = null;

    static {
        INSTANCE = new InitHelper$initCrashProtect$2();
    }

    public InitHelper$initCrashProtect$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p57.c r100) {
        Intrinsics.checkNotNullParameter(r100, "crashPortrait");
        gka.b.c("InitHelper", "Crash caught successfully: " + r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p57.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
