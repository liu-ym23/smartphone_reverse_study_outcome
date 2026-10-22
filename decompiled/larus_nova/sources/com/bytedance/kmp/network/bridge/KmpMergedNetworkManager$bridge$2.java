package com.bytedance.kmp.network.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/kmp/network/bridge/b;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/kmp/network/bridge/b;", "<anonymous>"}, k = 3, mv = {1, 7, 0})
final class KmpMergedNetworkManager$bridge$2 extends Lambda implements Function0<b> {
    public static final KmpMergedNetworkManager$bridge$2 INSTANCE = null;

    static {
        INSTANCE = new KmpMergedNetworkManager$bridge$2();
    }

    public KmpMergedNetworkManager$bridge$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final b invoke() {
        pd6.b r100 = pd6.c.f528682a;
        return (b) pd6.c.a(Reflection.getOrCreateKotlinClass(b.class));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ b invoke() {
        return invoke();
    }
}
