package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseRecordData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderMeta;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseListViewData;", "K", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewData;", "<init>", "()V", "renderForest", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderForest;", "getRenderForest", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderForest;", "setRenderForest", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderForest;)V", "renderMeta", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderMeta;", "getRenderMeta", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderMeta;", "setRenderMeta", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderMeta;)V", "renderNode", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderNode;", "Lkotlin/collections/ArrayList;", "getRenderNode", "()Ljava/util/ArrayList;", "setRenderNode", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseListViewData<K extends BaseCellData, T extends BaseRecordData<K>> extends BaseViewData<K, T> {
    private RenderForest renderForest;
    private RenderMeta renderMeta;
    private ArrayList<RenderNode> renderNode;

    public BaseListViewData() {
        this.renderForest = new RenderForest();
        this.renderMeta = new RenderMeta();
    }

    public final RenderForest getRenderForest() {
        return this.renderForest;
    }

    public final RenderMeta getRenderMeta() {
        return this.renderMeta;
    }

    public final ArrayList<RenderNode> getRenderNode() {
        return this.renderNode;
    }

    public final void setRenderForest(RenderForest r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderForest = r100;
    }

    public final void setRenderMeta(RenderMeta r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderMeta = r100;
    }

    public final void setRenderNode(ArrayList<RenderNode> r100) {
        this.renderNode = r100;
    }
}
