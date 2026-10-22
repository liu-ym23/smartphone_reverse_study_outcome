package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.io.NonProguard;
import ct4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderTree;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "current", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderItem;", "Lkotlin/collections/ArrayList;", "getCurrent", "()Ljava/util/ArrayList;", "setCurrent", "(Ljava/util/ArrayList;)V", "children", "getChildren", "setChildren", "isGroupTree", "", "isRecordLeafs", "genRenderItem", "", "collapsedSet", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ICollapsedSet;", "genGroupTreeItems", "genRecordLeafs", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderTree implements NonProguard {
    public static final a Companion = null;
    public static final String GROUP_TREE = "groupTree";
    public static final String RECORD_LEAFS = "recordLeafs";
    private ArrayList<RenderTree> children;
    private ArrayList<RenderItem> current;
    private String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RenderTree() {
    }

    public final boolean isGroupTree() {
        return TextUtils.equals(this.type, GROUP_TREE);
    }

    public final boolean isRecordLeafs() {
        return TextUtils.equals(this.type, RECORD_LEAFS);
    }

    public final ArrayList<RenderTree> getChildren() {
        return this.children;
    }

    public final ArrayList<RenderItem> getCurrent() {
        return this.current;
    }

    public final String getType() {
        return this.type;
    }

    public final List<RenderItem> genGroupTreeItems(d r100) {
        Intrinsics.checkNotNullParameter(r100, "collapsedSet");
        ArrayList<RenderItem> r101 = this.current;
        if (r101 == null) goto L17;
        RenderItem r102 = (RenderItem) m.j(r101, 0, null);
        if (r102 == null) goto L17;
        ArrayList r103 = new ArrayList();
        r103.add(r102);
        if (r100.q(r102.getId()) == true) goto L15;
        ArrayList<RenderTree> r104 = this.children;
        if (r104 == null) goto L15;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        r103.addAll(((RenderTree) r105.next()).genRenderItem(r100));
    L15:
        return r103;
    L17:
        return new ArrayList();
    }

    public final List<RenderItem> genRecordLeafs(d r100) {
        Intrinsics.checkNotNullParameter(r100, "collapsedSet");
        ArrayList<RenderItem> r101 = this.current;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new ArrayList();
    }

    public final List<RenderItem> genRenderItem(d r100) {
        Intrinsics.checkNotNullParameter(r100, "collapsedSet");
        if (isGroupTree() == false) goto L7;
        return genGroupTreeItems(r100);
    L7:
        if (isRecordLeafs() == false) goto L11;
        return genRecordLeafs(r100);
    L11:
        return new ArrayList();
    }

    public final void setChildren(ArrayList<RenderTree> r100) {
        this.children = r100;
    }

    public final void setCurrent(ArrayList<RenderItem> r100) {
        this.current = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
