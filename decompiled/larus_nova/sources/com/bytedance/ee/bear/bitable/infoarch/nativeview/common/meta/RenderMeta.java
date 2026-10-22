package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import ct4.e;
import et4.a;
import et4.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\b\u0010\u001d\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0007J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0010\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020!J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\bJ\u000e\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bJ\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u000201H\u0016R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderMeta;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderNode;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;", "<init>", "()V", "referMapping", "Lkotlin/Pair;", "", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "getReferMapping", "()Lkotlin/Pair;", "setReferMapping", "(Lkotlin/Pair;)V", "targetGroupPosition", "getTargetGroupPosition", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "setTargetGroupPosition", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)V", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "collapsedSet", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ICollapsedSetV2;", "init", "", "updateReferMapping", "consumeTargetGroupPosition", "updateNode", "node", "groupPath", "", "toggleNode", "positionToGroupPosition", "targetPosition", "getInitMapping", "getRenderNodeParent", "haveRealItem", "groupLength", "isCollapsed", "groupPosition", "updateChildInfo", "ordinalInMeta", "getNearGroupPosition", "originGroupPosition", "getDependence", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderMeta extends RenderNode implements b {
    private transient e collapsedSet;
    private boolean hasInit;
    private Pair<Integer, ? extends GroupPosition> referMapping;
    private GroupPosition targetGroupPosition;

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public b getDependence() {
        return this;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public boolean haveRealItem() {
        return false;
    }

    public final GroupPosition consumeTargetGroupPosition() {
        GroupPosition r100 = this.targetGroupPosition;
        this.targetGroupPosition = null;
        return r100;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public String toString() {
        return super.toString() + "referMapping=" + this.referMapping + ' ';
    }

    public final Pair<Integer, GroupPosition> getInitMapping() {
        if (hasGroup() == false) goto L6;
        return new Pair(0, new GroupPosition(new int[]{0}, -1));
    L6:
        return new Pair(0, new GroupPosition(new int[0], 0));
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public int groupLength() {
        return getGroupLength();
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode
    public void updateChildInfo() {
        dfsRenderNode(this, getGroupPath(), false);
    }

    public RenderMeta() {
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    public final Pair<Integer, GroupPosition> getReferMapping() {
        return this.referMapping;
    }

    public final GroupPosition getTargetGroupPosition() {
        return this.targetGroupPosition;
    }

    public final GroupPosition getNearGroupPosition(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "originGroupPosition");
        if (r100.isError() == true) goto L5;
        int[] r101 = r100.getGroupPath();
    L8:
        if (r101.length != 0) goto L10;
        boolean r102 = true;
    L12:
        if ((!r102) == false) goto L19;
        RenderNode r103 = getRenderNodeParent(r101);
        if (r103 != null) goto L16;
        r101 = a.c(r101);
        goto L8
    L16:
        return new GroupPosition(r103.getGroupPath(), -1);
    L19:
        return getInitMapping().getSecond();
    L10:
        r102 = false;
        goto L12
    L5:
        return getInitMapping().getSecond();
    }

    public final RenderNode getRenderNodeParent(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPath");
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return null;
    L10:
        return getRenderNode(a.c(r100), 0);
    L5:
        r101 = false;
        goto L6
    }

    public final void init(e r100) {
        Intrinsics.checkNotNullParameter(r100, "collapsedSet");
        tt5.a.h("RenderMeta", "initMeta>>>");
        this.hasInit = true;
        this.collapsedSet = r100;
        this.referMapping = getInitMapping();
        RenderNode.dfsRenderNode$default(this, this, null, false, 6, null);
    }

    @Override // et4.b
    public boolean isCollapsed(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPosition");
        e r101 = this.collapsedSet;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }

    public final int ordinalInMeta(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPosition");
    L18:
        tt5.a.h("RenderMeta", "ordinalInMeta crash. " + r100);
        return -1;
    L4:
        if (r100.isError() == false) goto L6;
        return -1;
    L6:
        RenderNode r101 = getRenderNode(r100.getGroupPath(), 0);     // Catch: Exception -> L18
        if (r101 != null) goto L9;
        return -1;
    L9:
        int r102 = offsetToOrdinal(r100.getOffset());     // Catch: Exception -> L18
    L10:
        if (r101 == null) goto L17;
        int r103 = r101.getIndexInParent();     // Catch: Exception -> L18
        r101 = getRenderNodeParent(r101.getGroupPath());     // Catch: Exception -> L18
        if (r101 == null) goto L15;
        int r104 = r101.getAheadCount(r103);     // Catch: Exception -> L18
    L16:
        r102 = r102 + r104;
        goto L10
    L15:
        r104 = 0;
        goto L16
    L17:
        return r102;
    }

    public final GroupPosition positionToGroupPosition(int r100) {
        Pair<Integer, ? extends GroupPosition> r101 = this.referMapping;
        if (r101 == null) goto L5;
        int r102 = r101.getFirst().intValue();
        GroupPosition r103 = r101.getSecond();
        RenderNode r104 = getRenderNode(r103.getGroupPath(), 0);
        if (r104 == null) goto L9;
        int r105 = r100 - r102;
        int r106 = offsetToOrdinal(r103.getOffset());
    L11:
        r106 = r106 + r105;
    L13:
        if (r104.ordinalHitCurrentRenderNode(r106) == false) goto L27;
        RenderNode r107 = r104;
    L16:
        if (r107.ordinalHitCurrentRenderNode(r106) == false) goto L13;
        if (r107.isLeafNode() == true) goto L25;
        if (r107.getNodeItemCount() != 1) goto L23;
        if (r106 == 1) goto L25;
    L23:
        int r108 = r107.ordinalToChildGroupIndex(r106);
        r106 = r106 - r107.getAheadCount(r108);
        r107 = r107.getRenderNode(r108, this);
    L25:
        return new GroupPosition(r107.getGroupPath(), ordinalToOffset(r106));
    L27:
        if (r104.getNodeLevel() == 0) goto L28;
        int r109 = r104.getIndexInParent();
        r104 = getRenderNodeParent(r104.getGroupPath());
        if (r104 == null) goto L33;
        r105 = r104.getAheadCount(r109);
        goto L11
    L33:
        return ErrorPosition.INSTANCE;
    L28:
        GroupPosition r110 = new GroupPosition(r104.getGroupPath(), -2);
        r110.setOutOfBoundIndex(r106 - r104.getItemCount());
        return r110;
    L9:
        return ErrorPosition.INSTANCE;
    L5:
        return ErrorPosition.INSTANCE;
    }

    public final void setHasInit(boolean r100) {
        this.hasInit = r100;
    }

    public final void setReferMapping(Pair<Integer, ? extends GroupPosition> r100) {
        this.referMapping = r100;
    }

    public final void setTargetGroupPosition(GroupPosition r100) {
        this.targetGroupPosition = r100;
    }

    public final void toggleNode(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPath");
        updateNode(null, r100);
    }

    public final void updateReferMapping(Pair<Integer, ? extends GroupPosition> r100) {
        Intrinsics.checkNotNullParameter(r100, "referMapping");
        this.referMapping = r100;
    }

    public final void updateNode(RenderNode r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r101, "groupPath");
        tt5.a.h("RenderMeta", "updateNode>>> node:" + r100 + ", groupPath:" + r101);
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.c("patch update meta, return.", false);
        return;
    L9:
        RenderNode r103 = getRenderNodeParent(r101);
        if (r100 == null) goto L16;
        r100.dfsRenderNode(this, r100.getGroupPath(), true);
        if (r103 == null) goto L16;
        HashMap<Integer, RenderNode> r104 = r103.getGroups();
        if (r104 == null) goto L16;
        r104.put(Integer.valueOf(a.b(r101)), r100);
    L16:
        if (r103 == null) goto L18;
        r103.updateChildInfo();
        r103 = getRenderNodeParent(r103.getGroupPath());
        goto L16
    L18:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
