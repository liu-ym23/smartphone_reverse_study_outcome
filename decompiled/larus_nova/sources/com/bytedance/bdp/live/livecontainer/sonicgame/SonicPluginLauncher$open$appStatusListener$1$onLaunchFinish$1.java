package com.bytedance.bdp.live.livecontainer.sonicgame;

import com.bytedance.bdp.bdpbase.core.IBdpAppInstance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class SonicPluginLauncher$open$appStatusListener$1$onLaunchFinish$1 extends MutablePropertyReference0 {
    public SonicPluginLauncher$open$appStatusListener$1$onLaunchFinish$1(i r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "bdpAppInstance";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(i.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getBdpAppInstance()Lcom/bytedance/bdp/bdpbase/core/IBdpAppInstance;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        IBdpAppInstance r100 = ((i) this.receiver).f201524a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bdpAppInstance");
    L5:
        return r100;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        IBdpAppInstance r101 = (IBdpAppInstance) r100;
        ((i) this.receiver).f201524a = r101;
    }
}
