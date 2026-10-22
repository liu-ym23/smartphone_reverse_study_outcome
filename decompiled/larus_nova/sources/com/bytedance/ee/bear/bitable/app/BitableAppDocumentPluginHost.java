package com.bytedance.ee.bear.bitable.app;

import com.bytedance.ee.bear.bitable.BitableDocumentPluginHost;
import com.bytedance.ee.bear.bitable.load.BitableSceneType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/BitableAppDocumentPluginHost;", "Lcom/bytedance/ee/bear/bitable/BitableDocumentPluginHost;", "web", "Lcom/bytedance/ee/bear/browser/Web;", "<init>", "(Lcom/bytedance/ee/bear/browser/Web;)V", "getBitableSceneType", "Lcom/bytedance/ee/bear/bitable/load/BitableSceneType;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAppDocumentPluginHost extends BitableDocumentPluginHost {
    @Override // com.bytedance.ee.bear.bitable.BitableDocumentPluginHost
    public final BitableSceneType e() {
        return BitableSceneType.BaseApp;
    }

    public BitableAppDocumentPluginHost(vv4.k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        super(r100);
    }
}
