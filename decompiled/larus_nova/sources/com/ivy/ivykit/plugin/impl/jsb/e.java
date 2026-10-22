package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements IDLXBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f278384a;

    public e(LynxView r100) {
        this.f278384a = r100;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.b
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        o.a(this.f278384a, r100, r101);
    }
}
