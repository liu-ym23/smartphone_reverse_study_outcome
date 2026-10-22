package com.bytedance.ee.bear.bitable;

import com.bytedance.ee.bear.bitable.load.BitableSceneType;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.jsbridge.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/BitableDocumentPluginHost;", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "web", "Lcom/bytedance/ee/bear/browser/Web;", "<init>", "(Lcom/bytedance/ee/bear/browser/Web;)V", "getBitableSceneType", "Lcom/bytedance/ee/bear/bitable/load/BitableSceneType;", "callNativeJs", "", "handlerName", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableDocumentPluginHost extends DocumentPluginHost {
    public BitableSceneType e() {
        if (this.f218588a.isBitableRecordShare() == true) goto L14;
        DocViewModel r100 = this.f218588a;
        boolean r101 = false;
        if (r100 != null) goto L8;
    L10:
        if (r101 == false) goto L13;
        return BitableSceneType.AddRecord;
    L13:
        return BitableSceneType.MainDoc;
    L8:
        if (r100.isType(sbb.e.f541299j) != true) goto L10;
        r101 = true;
        goto L10
    L14:
        return BitableSceneType.ShareRecord;
    }

    public BitableDocumentPluginHost(vv4.k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        super(r100);
    }

    public final void d(String r100, String r101, tb5.m r102) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if ((getWeb() instanceof z4) == false) goto L6;
        vv4.k r103 = getWeb();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.document.ISafeReuseDocumentWeb");
        Message r104 = new Message();
        r104.f227153d = r101;
        r104.f227154e = r100;
        ((z4) r103).E(r104, r102);
        return;
    }
}
