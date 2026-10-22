package com.bytedance.kmp.klay.event;

import com.bytedance.kmp.klay.ui.KlayModuleNode;
import com.bytedance.kmp.klay.vm.KlayViewModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/kmp/klay/event/a;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/kmp/klay/event/a;", "<anonymous>"}, k = 3, mv = {1, 7, 0})
final class EventDispatcherFinderKt$klayEventDispatcher$2 extends Lambda implements Function0<a> {
    final /* synthetic */ com.bytedance.kmp.klay.ui.b $moduleKey;
    final /* synthetic */ KlayViewModel $this_klayEventDispatcher;

    public EventDispatcherFinderKt$klayEventDispatcher$2(KlayViewModel r100, com.bytedance.kmp.klay.ui.b r101) {
        this.$this_klayEventDispatcher = r100;
        this.$moduleKey = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        KlayModuleNode r100 = this.$this_klayEventDispatcher.getModuleNode$klay_release();
        if (r100 != null) goto L5;
        eb6.a.f471798a.getClass();
        eb6.a.b("klayEventDispatcher execute too early, make sure after KlayViewModel.onCrated()");
    L5:
        if (r100 == null) goto L7;
        KlayModuleNode r101 = r100.a(this.$moduleKey);
    L8:
        if (r101 != null) goto L10;
        eb6.a r102 = eb6.a.f471798a;
        String r103 = "can't find EventDispatcher for moduleKey: " + Reflection.getOrCreateKotlinClass(this.$moduleKey.getClass()).getSimpleName();
        r102.getClass();
        eb6.a.b(r103);
    L10:
        if (r101 == null) goto L14;
        a r104 = r101.f252190d;
        if (r104 == null) goto L14;
        return r104;
    L14:
        return new a();
    L7:
        r101 = null;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
