package com.bytedance.applet.aibridge;

import android.media.AudioManager;
import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetSystemVolumeInfoMethod;", "Lcom/bytedance/applet/aibridge/AbsGetSystemVolumeInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsGetSystemVolumeInfoMethodIDL$GetSystemVolumeInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsGetSystemVolumeInfoMethodIDL$GetSystemVolumeInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetSystemVolumeInfoMethod extends AbsGetSystemVolumeInfoMethodIDL {
    public AIBridgeGetSystemVolumeInfoMethod() {
    }

    public final void handle(e3.d r4, ParamModel r5, f3.h r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetSystemVolumeInfoMethodIDL.a) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Object r7 = AppHost.a.getApplication().getSystemService("audio");
        if ((r7 instanceof AudioManager) == false) goto L5;
        AudioManager r8 = (AudioManager) r7;
    L6:
        int r0 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L10;
        if (r8 == null) goto L10;
        int r9 = r8.getStreamMinVolume(3);
    L11:
        if (r8 == null) goto L13;
        r0 = r8.getStreamVolume(3);
    L13:
        if (r8 == null) goto L15;
        int r10 = r8.getStreamMaxVolume(3);
    L16:
        double r1 = ((double) (r0 - r9)) / ((double) (r10 - r9));
        Intrinsics.checkNotNullParameter(AbsGetSystemVolumeInfoMethodIDL.b.class, "<this>");
        AbsGetSystemVolumeInfoMethodIDL.b r11 = k3.c.a(AbsGetSystemVolumeInfoMethodIDL.b.class);
        r11.setVolume(r1);
        r6.b(r11, "");
        return;
    L15:
        r10 = 15;
    L10:
        r9 = 0;
        goto L11
    L5:
        r8 = null;
        goto L6
    }
}
