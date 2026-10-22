package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016JN\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/applet/aibridge/PreviewImageMethod;", "Lcom/bytedance/applet/aibridge/AbsPreviewImageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsPreviewImageMethodIDL$PreviewImageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsPreviewImageMethodIDL$PreviewImageResultModel;", "previewImages", "imageUrls", "", "", "index", "", "templateURLs", "footInfos", "trackerInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewImageMethod extends AbsPreviewImageMethodIDL {
    public PreviewImageMethod() {
    }

    public final void handle(e3.d r13, ParamModel r14, f3.h r15) {
        AbsPreviewImageMethodIDL.a r16 = (AbsPreviewImageMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        List<String> r1 = r16.getImageURLs();
        if (r1.isEmpty() == false) goto L5;
        f3.h.a.a(r15, "urls is empty", null, null, 14);
        return;
    L5:
        int r2 = r16.getIndex();
        List<String> r3 = r16.getTemplateURLs();
        List<String> r4 = r16.getFooterInfos();
        List<String> r5 = r16.getTrackerInfos();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PreviewImageMethod$previewImages$1(r1, r2, r3, r4, r5, null), 3, null);
        Intrinsics.checkNotNullParameter(AbsPreviewImageMethodIDL.b.class, "<this>");
        r15.b(k3.c.a(AbsPreviewImageMethodIDL.b.class), "");
    }
}
