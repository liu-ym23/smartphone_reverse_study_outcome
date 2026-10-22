package com.bytedance.salamander.bridge.common;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a extends sa.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f268553g;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        Context r100 = this.f268553g;
        if ((r100 instanceof Activity) == true) goto L7;
        return null;
    L7:
        return (Activity) r100;
    }

    public final Context getContext() {
        return this.f268553g;
    }

    public a(com.bytedance.sdk.xbridge.cn.platform.lynx.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeCall");
        super(r100);
        this.f268553g = r101;
    }
}
