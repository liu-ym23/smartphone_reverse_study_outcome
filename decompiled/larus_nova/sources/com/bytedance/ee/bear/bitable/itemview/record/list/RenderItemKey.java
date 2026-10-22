package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderItemKey;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "renderId", "", "getRenderId", "()Ljava/lang/String;", "setRenderId", "(Ljava/lang/String;)V", "renderType", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;", "getRenderType", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;", "setRenderType", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderItemKey implements NonProguard {
    private String renderId;
    private RenderType renderType;

    public RenderItemKey() {
        this.renderId = "";
    }

    public final String getRenderId() {
        return this.renderId;
    }

    public final RenderType getRenderType() {
        return this.renderType;
    }

    public final void setRenderId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderId = r100;
    }

    public final void setRenderType(RenderType r100) {
        this.renderType = r100;
    }
}
