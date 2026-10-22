package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.util.io.NonProguard;
import ct4.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u00072\u0006\u0010\u0011\u001a\u00020\u0012R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderForest;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "renderTrees", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderTree;", "Lkotlin/collections/ArrayList;", "getRenderTrees", "()Ljava/util/ArrayList;", "setRenderTrees", "(Ljava/util/ArrayList;)V", "renderItemList", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderItem;", "getRenderItemList", "setRenderItemList", "genRenderItem", "collapsedSet", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ICollapsedSet;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderForest implements NonProguard {
    private ArrayList<RenderItem> renderItemList;
    private ArrayList<RenderTree> renderTrees;

    public RenderForest() {
        this.renderItemList = new ArrayList();
    }

    public final ArrayList<RenderItem> getRenderItemList() {
        return this.renderItemList;
    }

    public final ArrayList<RenderTree> getRenderTrees() {
        return this.renderTrees;
    }

    public final ArrayList<RenderItem> genRenderItem(d r100) {
        Intrinsics.checkNotNullParameter(r100, "collapsedSet");
        ArrayList<RenderItem> r101 = new ArrayList();
        ArrayList<RenderTree> r102 = this.renderTrees;
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r101.addAll(((RenderTree) r103.next()).genRenderItem(r100));
    L8:
        this.renderItemList = r101;
        return r101;
    }

    public final void setRenderItemList(ArrayList<RenderItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderItemList = r100;
    }

    public final void setRenderTrees(ArrayList<RenderTree> r100) {
        this.renderTrees = r100;
    }
}
