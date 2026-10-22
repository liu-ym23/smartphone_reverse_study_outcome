package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeSDKRustCallbackDispatchModule$provideLoginCallbackExecutorGroup$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public OfficeSDKRustCallbackDispatchModule$provideLoginCallbackExecutorGroup$1(Object r100) {
        super(0, r100, q.class, "isLoginCallbackExecutorEnabled", "isLoginCallbackExecutorEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        q r100 = (q) this.receiver;
        q r101 = q.f425709a;
        r100.getClass();
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
    L7:
        boolean r102 = false;
    L9:
        return Boolean.valueOf(r102);
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.officesdk.rust.login_callback_executor.disable") == true) goto L7;
        r102 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
