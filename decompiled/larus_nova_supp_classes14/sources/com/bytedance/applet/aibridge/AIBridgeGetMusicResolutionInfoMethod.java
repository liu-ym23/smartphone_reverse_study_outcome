package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetMusicResolutionInfoMethod;", "Lcom/bytedance/applet/aibridge/AbsGetMusicResolutionInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsGetMusicResolutionInfoMethodIDL$GetMusicResolutionInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsGetMusicResolutionInfoMethodIDL$GetMusicResolutionInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetMusicResolutionInfoMethod extends AbsGetMusicResolutionInfoMethodIDL {
    public AIBridgeGetMusicResolutionInfoMethod() {
    }

    public final void handle(e3.d r3, ParamModel r4, f3.h r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetMusicResolutionInfoMethodIDL.a) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ArrayList r6 = new ArrayList();
        String r7 = i.b;
        if (r7 == null) goto L10;
        Iterator r8 = MusicPlayManagerDelegate.b.i(r7).iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        String r0 = (String) r8.next();
        String r1 = i.a.j(r0);
        if (r1 == null) goto L6;
        r6.add(r1);
    L10:
        String r9 = i.a.j(MusicPlayManagerDelegate.b.n());
        if (r9 != null) goto L13;
        r9 = "undefine";
    L13:
        Intrinsics.checkNotNullParameter(AbsGetMusicResolutionInfoMethodIDL.b.class, "<this>");
        AbsGetMusicResolutionInfoMethodIDL.b r2 = k3.c.a(AbsGetMusicResolutionInfoMethodIDL.b.class);
        AbsGetMusicResolutionInfoMethodIDL.b r10 = r2;
        r10.setResolutionList(r6);
        r10.setCurrentResolution(r9);
        r5.b(r2, "");
    }
}
