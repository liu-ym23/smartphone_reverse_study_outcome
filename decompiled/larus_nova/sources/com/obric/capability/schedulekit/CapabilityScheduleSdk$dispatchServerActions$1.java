package com.obric.capability.schedulekit;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CapabilityScheduleSdk$dispatchServerActions$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $payload;
    final /* synthetic */ boolean $replyForServer;

    public CapabilityScheduleSdk$dispatchServerActions$1(String r100, boolean r101) {
        this.$payload = r100;
        this.$replyForServer = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        via.b r100 = via.b.f555361a;
        CoroutineScope r101 = b.f396036a;
        r100.a("CapabilityScheduleSdk");
        b.a();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
