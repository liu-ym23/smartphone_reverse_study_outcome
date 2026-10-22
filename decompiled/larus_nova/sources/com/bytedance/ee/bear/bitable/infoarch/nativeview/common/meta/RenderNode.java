package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import et4.a;
import et4.b;
import et4.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020!H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0016H\u0016J\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010<\u001a\u00020\u0005J$\u0010=\u001a\u00020>2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020\u0016H\u0016J\b\u0010@\u001a\u00020>H\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005H\u0016J\u000e\u0010E\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u0005J\u000e\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J\u0016\u0010I\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u00052\u0006\u0010J\u001a\u00020!J\u0018\u0010I\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0005J\u0006\u0010L\u001a\u00020\u0005J\u0006\u0010M\u001a\u00020\u0005J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0006\u0010N\u001a\u00020\u0016J\u0006\u0010O\u001a\u00020\u0016J\u0006\u0010P\u001a\u00020\u0016J\b\u0010Q\u001a\u00020\u001bH\u0016R6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0000`\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00050-j\b\u0012\u0004\u0012\u00020\u0005`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderNode;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "groupLength", "", "groupPath", "", "(I[I)V", "groups", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGroups", "()Ljava/util/HashMap;", "setGroups", "(Ljava/util/HashMap;)V", "count", "getCount", "()I", "setCount", "(I)V", "isLoaded", "", "()Z", "setLoaded", "(Z)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "nodeDependence", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;", "getNodeDependence", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;", "setNodeDependence", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/NodeDependence;)V", "getGroupLength", "setGroupLength", "getGroupPath", "()[I", "setGroupPath", "([I)V", "childRange", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getChildRange", "()Ljava/util/ArrayList;", "setChildRange", "(Ljava/util/ArrayList;)V", "cacheChildrenItemCount", "getCacheChildrenItemCount", "setCacheChildrenItemCount", "getRecordCount", "getGroupCount", "getDependence", "getItemCount", "haveRealItem", "getNodeItemCount", "getIndexInParent", "dfsRenderNode", "", "needDfsChild", "updateChildInfo", "ordinalToChildGroupIndex", "ordinal", "getAheadCount", "childGroupIndex", "ordinalHitCurrentRenderNode", "offsetToOrdinal", "offset", "ordinalToOffset", "getRenderNode", "dependence", "targetGroupPathIndex", "getNodeLevel", "getNodeDepth", "hasGroup", "isLeafNode", "isNonLeafNode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RenderNode implements NonProguard {
    private transient int cacheChildrenItemCount;
    private transient ArrayList<Integer> childRange;
    private int count;
    private int groupLength;
    private int[] groupPath;
    private HashMap<Integer, RenderNode> groups;
    private boolean isLoaded;
    private transient b nodeDependence;
    private String type;

    public boolean haveRealItem() {
        return true;
    }

    public final int getIndexInParent() {
        return a.b(this.groupPath);
    }

    public final int getNodeLevel() {
        return this.groupPath.length;
    }

    public final boolean isNonLeafNode() {
        return TextUtils.equals(this.type, "NonLeaf");
    }

    public String toString() {
        return "RenderNode(groupPath=" + Arrays.toString(this.groupPath) + ",groupLength=" + groupLength() + ", count=" + getGroupCount() + ", type=" + this.type + ", childrenSize=" + getGroups().size() + " )";
    }

    public RenderNode() {
        this.groups = new HashMap();
        this.type = "";
        this.nodeDependence = c.f473923a;
        this.groupPath = new int[0];
        this.childRange = new ArrayList();
    }

    public b getDependence() {
        return getNodeDependence();
    }

    public int getGroupCount() {
        return getCount();
    }

    public int getItemCount() {
        if (getDependence().isCollapsed(a.a(this.groupPath)) == true) goto L5;
        int r100 = getNodeItemCount();
        if (isLeafNode() == false) goto L9;
        int r101 = getRecordCount();
    L11:
        return r100 + r101;
    L9:
        r101 = this.cacheChildrenItemCount;
        goto L11
    L5:
        return getNodeItemCount();
    }

    public final int getNodeDepth() {
        return (groupLength() - getNodeLevel()) + 1;
    }

    public final int getNodeItemCount() {
        return haveRealItem() ? 1 : 0;
    }

    public int getRecordCount() {
        return getCount();
    }

    public int groupLength() {
        return getDependence().groupLength();
    }

    public final boolean hasGroup() {
        if (groupLength() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLeafNode() {
        if (getNodeDepth() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void updateChildInfo() {
        dfsRenderNode(getDependence(), this.groupPath, false);
    }

    public final int getCacheChildrenItemCount() {
        return this.cacheChildrenItemCount;
    }

    public final ArrayList<Integer> getChildRange() {
        return this.childRange;
    }

    public int getCount() {
        return this.count;
    }

    public final int getGroupLength() {
        return this.groupLength;
    }

    public final int[] getGroupPath() {
        return this.groupPath;
    }

    public HashMap<Integer, RenderNode> getGroups() {
        return this.groups;
    }

    public b getNodeDependence() {
        return this.nodeDependence;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    public int getAheadCount(int r100) {
        return ((Number) ListProtector.get(this.childRange, r100)).intValue();
    }

    public final int offsetToOrdinal(int r100) {
        if (hasGroup() == false) goto L6;
        return r100 + 2;
    L6:
        return r100 + 1;
    }

    public final boolean ordinalHitCurrentRenderNode(int r100) {
        if (1 <= r100) goto L5;
        return false;
    L5:
        if (r100 > getItemCount()) goto L9;
        return true;
    L9:
        return false;
    }

    public int ordinalToChildGroupIndex(int r100) {
        int r101 = this.childRange.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (((Number) ListProtector.get(this.childRange, r102)).intValue() >= r100) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return r102 - 1;
    L9:
        return -1;
    }

    public final int ordinalToOffset(int r100) {
        if (hasGroup() == false) goto L7;
        return r100 - 2;
    L7:
        return r100 - 1;
    }

    public final void setCacheChildrenItemCount(int r100) {
        this.cacheChildrenItemCount = r100;
    }

    public final void setChildRange(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.childRange = r100;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public final void setGroupLength(int r100) {
        this.groupLength = r100;
    }

    public final void setGroupPath(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupPath = r100;
    }

    public void setGroups(HashMap<Integer, RenderNode> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groups = r100;
    }

    public final void setLoaded(boolean r100) {
        this.isLoaded = r100;
    }

    public void setNodeDependence(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nodeDependence = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public RenderNode(int r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r101, "groupPath");
        this.groups = new HashMap();
        this.type = "";
        this.nodeDependence = c.f473923a;
        this.groupPath = new int[0];
        this.childRange = new ArrayList();
        this.groupLength = r100;
        this.groupPath = r101;
    }

    public final RenderNode getRenderNode(int r100, b r101) {
        Intrinsics.checkNotNullParameter(r101, "dependence");
        if (r100 < getGroupCount()) goto L6;
        tt5.a.d("RenderMeta", "getRenderNode>>> childGroupIndex:" + r100 + ", out of groupCount:" + getCount() + '.');
        return ErrorNode.INSTANCE;
    L6:
        RenderNode r102 = getGroups().get(Integer.valueOf(r100));
        if (r102 == null) goto L9;
        return r102;
    L9:
        int r103 = groupLength();
        int[] r104 = this.groupPath;
        return new PlaceholderRenderGroup(r103, ArraysKt.plus(Arrays.copyOf(r104, r104.length), r100), r101);
    }

    public final RenderNode getRenderNode(int[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "groupPath");
        if (groupLength() >= r100.length) goto L7;
        tt5.a.d("RenderMeta", "getRenderNode>>> groupLength < size");
        return null;
    L7:
        if (Arrays.equals(r100, this.groupPath) == false) goto L10;
        return this;
    L10:
        if (r101 < r100.length) goto L13;
        tt5.a.d("RenderMeta", "getRenderNode>>> targetGroupPath outOfIndex");
        return null;
    L13:
        RenderNode r102 = getRenderNode(r100[r101], getDependence());
        if (Intrinsics.areEqual(r102, ErrorNode.INSTANCE) == false) goto L18;
        tt5.a.d("RenderMeta", "getRenderNode>>> find errorNode, error GroupPath.");
        return null;
    L18:
        return r102.getRenderNode(r100, r101 + 1);
    }

    public void dfsRenderNode(b r100, int[] r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeDependence");
        Intrinsics.checkNotNullParameter(r101, "groupPath");
        this.groupPath = r101;
        setNodeDependence(r100);
        this.childRange.clear();
        if (isLeafNode() == false) goto L5;
        int r103 = getRecordCount();
    L12:
        this.cacheChildrenItemCount = r103 - getNodeItemCount();
        return;
    L5:
        this.childRange.add(Integer.valueOf(getNodeItemCount()));
        int r104 = 0;
        int r105 = getNodeItemCount() + 0;
        int r106 = getGroupCount();
    L6:
        if (r104 >= r106) goto L11;
        RenderNode r107 = getRenderNode(r104, r100);
        if (r102 == false) goto L10;
        r107.dfsRenderNode(r100, ArraysKt.plus(Arrays.copyOf(r101, r101.length), r104), true);
    L10:
        r105 = r105 + r107.getItemCount();
        this.childRange.add(Integer.valueOf(r105));
        r104 = r104 + 1;
        goto L6
    L11:
        r103 = r105;
        goto L12
    }

    public static /* synthetic */ void dfsRenderNode$default(RenderNode r100, b r101, int[] r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = new int[0];
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        r100.dfsRenderNode(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dfsRenderNode");
    }
}
