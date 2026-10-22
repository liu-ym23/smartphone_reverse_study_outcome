package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lp57/c;", AbsMethodDelegate.TAG_INVOKE, "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class InitHelper$initCrashProtect$1 extends Lambda implements Function0<List<? extends p57.c>> {
    public static final InitHelper$initCrashProtect$1 INSTANCE = null;

    static {
        INSTANCE = new InitHelper$initCrashProtect$1();
    }

    public InitHelper$initCrashProtect$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends p57.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends p57.c> invoke2() {
        CopyOnWriteArrayList<p57.c> r100 = c.f396996a;
        return c.f396996a;
    }
}
