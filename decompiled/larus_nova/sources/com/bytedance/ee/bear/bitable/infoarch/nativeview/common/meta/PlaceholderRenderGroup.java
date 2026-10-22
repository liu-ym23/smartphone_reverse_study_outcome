package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import et4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/PlaceholderRenderGroup;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderNode;", "groupLength", "", "groupPath", "", "nDependence", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;", "<init>", "(I[ILcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;)V", "getNDependence", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;", "setNDependence", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;)V", "dfsRenderNode", "", "nodeDependence", "needDfsChild", "", "getDependence", "getItemCount", "ordinalToChildGroupIndex", "ordinal", "getAheadCount", "childGroupIndex", "getPlaceHolderGroupItemCount", ToygerFaceAlgorithmConfig.DEPTH, "getRecordCount", "getGroupCount", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaceholderRenderGroup extends RenderNode {
    public static final a Companion = null;
    private static final int DEFAULT_GROUP_COUNT = 0;
    private static final int DEFAULT_RECORD_COUNT = 0;
    private transient b nDependence;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public void dfsRenderNode(b r100, int[] r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeDependence");
        Intrinsics.checkNotNullParameter(r101, "groupPath");
    }

    static {
        Companion = new a();
        DEFAULT_GROUP_COUNT = 2;
        DEFAULT_RECORD_COUNT = 10;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int getItemCount() {
        if (getDependence().isCollapsed(et4.a.a(getGroupPath())) == false) goto L7;
        return getNodeItemCount();
    L7:
        return getPlaceHolderGroupItemCount(getNodeDepth());
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int groupLength() {
        return getDependence().groupLength();
    }

    public static final /* synthetic */ int access$getDEFAULT_GROUP_COUNT$cp() {
        return DEFAULT_GROUP_COUNT;
    }

    public static final /* synthetic */ int access$getDEFAULT_RECORD_COUNT$cp() {
        return DEFAULT_RECORD_COUNT;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public b getDependence() {
        return this.nDependence;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int getGroupCount() {
        return DEFAULT_GROUP_COUNT;
    }

    public final b getNDependence() {
        return this.nDependence;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int getRecordCount() {
        return DEFAULT_RECORD_COUNT;
    }

    private final int getPlaceHolderGroupItemCount(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        if (r100 != 1) goto L6;
        int r101 = getNodeItemCount();
        int r102 = getRecordCount();
    L14:
        return r101 + r102;
    L6:
        if (r100 != 2) goto L13;
        r101 = getNodeItemCount() * 3;
        r102 = getRecordCount() * 2;
        goto L14
    L13:
        return getNodeItemCount() + getPlaceHolderGroupItemCount(r100 - 1);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int getAheadCount(int r100) {
        return getNodeItemCount() + (r100 * getPlaceHolderGroupItemCount(getNodeDepth() - 1));
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int ordinalToChildGroupIndex(int r100) {
        int r101 = getNodeItemCount();
        int r102 = getGroupCount() + 1;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101 >= r100) goto L6;
        r101 = r101 + getPlaceHolderGroupItemCount(getNodeDepth() - 1);
        r103 = r103 + 1;
        goto L3
    L6:
        return r103 - 1;
    L8:
        return -1;
    }

    public final void setNDependence(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nDependence = r100;
    }

    public PlaceholderRenderGroup(int r100, int[] r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, "groupPath");
        Intrinsics.checkNotNullParameter(r102, "nDependence");
        super(r100, r101);
        this.nDependence = r102;
    }
}
