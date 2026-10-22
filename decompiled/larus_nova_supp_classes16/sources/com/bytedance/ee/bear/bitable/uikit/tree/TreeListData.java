package com.bytedance.ee.bear.bitable.uikit.tree;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "T", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "renderTree", "Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;", "getRenderTree", "()Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;", "setRenderTree", "(Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "cacheKey", "getCacheKey", "()Ljava/lang/String;", "setCacheKey", "(Ljava/lang/String;)V", "maxLevel", "", "getMaxLevel", "()Ljava/lang/Integer;", "setMaxLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TreeListData<T> implements NonProguard {
    private String cacheKey;
    private HashMap<String, T> dataMap;
    private Integer maxLevel;
    private RenderTree renderTree;

    public TreeListData() {
        this.renderTree = new RenderTree();
        this.dataMap = new HashMap();
        this.maxLevel = 3;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final HashMap<String, T> getDataMap() {
        return this.dataMap;
    }

    public final Integer getMaxLevel() {
        return this.maxLevel;
    }

    public final RenderTree getRenderTree() {
        return this.renderTree;
    }

    public final void setCacheKey(String r1) {
        this.cacheKey = r1;
    }

    public final void setDataMap(HashMap<String, T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dataMap = r2;
    }

    public final void setMaxLevel(Integer r1) {
        this.maxLevel = r1;
    }

    public final void setRenderTree(RenderTree r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.renderTree = r2;
    }
}
