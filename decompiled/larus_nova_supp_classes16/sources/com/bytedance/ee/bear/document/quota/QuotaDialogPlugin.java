package com.bytedance.ee.bear.document.quota;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/quota/QuotaDialogPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaDialogPlugin extends DocumentPluginV2 {
    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public QuotaDialogPlugin() {
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(QuotaDialogPlugin r0) {
        return r0.getDocViewModel();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r6) {
        Intrinsics.checkNotNullParameter(r6, "handlersHolder");
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L5;
        int r2 = r1.getDocumentTypeValue();
    L6:
        r6.put("biz.util.showFullQuoteDialog", new com.bytedance.ee.bear.document.alert.a("doc", r2, new AnonymousClass1(this), new AnonymousClass2(this)));
        return;
    L5:
        r2 = -1;
        goto L6
    }
}
