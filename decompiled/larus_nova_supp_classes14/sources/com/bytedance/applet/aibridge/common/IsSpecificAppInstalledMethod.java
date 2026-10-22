package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.z0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/common/IsSpecificAppInstalledMethod;", "Lcom/bytedance/applet/aibridge/common/AbsIsSpecificAppInstalledMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsIsSpecificAppInstalledMethodIDL$IsSpecificAppInstalledParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsIsSpecificAppInstalledMethodIDL$IsSpecificAppInstalledResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsSpecificAppInstalledMethod extends AbsIsSpecificAppInstalledMethodIDL {
    public IsSpecificAppInstalledMethod() {
    }

    public final void handle(d r3, ParamModel r4, h r5) {
        AbsIsSpecificAppInstalledMethodIDL.a r6 = (AbsIsSpecificAppInstalledMethodIDL.a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r7 = r6.getAppName();
        if (Intrinsics.areEqual(r7, AppPlatform.DouYin.getAppName()) == false) goto L6;
        boolean r8 = z0.a("com.ss.android.ugc.aweme");
        Intrinsics.checkNotNullParameter(AbsIsSpecificAppInstalledMethodIDL.b.class, "<this>");
        AbsIsSpecificAppInstalledMethodIDL.b r9 = c.a(AbsIsSpecificAppInstalledMethodIDL.b.class);
        r9.setInstalled(r8);
        r5.b(r9, "");
        return;
    L6:
        if (Intrinsics.areEqual(r7, AppPlatform.Luna.getAppName()) == false) goto L9;
        boolean r10 = z0.a("com.luna.music");
        Intrinsics.checkNotNullParameter(AbsIsSpecificAppInstalledMethodIDL.b.class, "<this>");
        AbsIsSpecificAppInstalledMethodIDL.b r11 = c.a(AbsIsSpecificAppInstalledMethodIDL.b.class);
        r11.setInstalled(r10);
        r5.b(r11, "");
        return;
    L9:
        if (Intrinsics.areEqual(r7, AppPlatform.QQMusic.getAppName()) == false) goto L13;
        boolean r12 = z0.a("com.tencent.qqmusic");
        Intrinsics.checkNotNullParameter(AbsIsSpecificAppInstalledMethodIDL.b.class, "<this>");
        AbsIsSpecificAppInstalledMethodIDL.b r13 = c.a(AbsIsSpecificAppInstalledMethodIDL.b.class);
        r13.setInstalled(r12);
        r5.b(r13, "");
        return;
    L13:
        throw new IllegalStateException("not support this app".toString());
    }
}
