package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiMoreModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "treeNode", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;", "x", "", "y", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;II)V", "getTreeNode", "()Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;", "getX", "()I", "getY", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSWikiMoreModel implements NonProguard {
    public static final a Companion = null;
    public static final String TAG = "JSWikiMoreModel";
    private final JSWikiTreeNode treeNode;
    private final int x;
    private final int y;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ JSWikiMoreModel copy$default(JSWikiMoreModel r0, JSWikiTreeNode r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.treeNode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.x;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.y;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final JSWikiTreeNode component1() {
        return this.treeNode;
    }

    public final int component2() {
        return this.x;
    }

    public final int component3() {
        return this.y;
    }

    public final JSWikiMoreModel copy(JSWikiTreeNode r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "treeNode");
        return new JSWikiMoreModel(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JSWikiMoreModel) == true) goto L8;
        return false;
    L8:
        JSWikiMoreModel r6 = (JSWikiMoreModel) r5;
        if (Intrinsics.areEqual(this.treeNode, r6.treeNode) == true) goto L12;
        return false;
    L12:
        if (this.x == r6.x) goto L15;
        return false;
    L15:
        if (this.y == r6.y) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.treeNode.hashCode() * 31) + this.x) * 31) + this.y;
    }

    public String toString() {
        return "JSWikiMoreModel(treeNode=" + this.treeNode + ", x=" + this.x + ", y=" + this.y + ')';
    }

    /* JADX INFO: renamed from: getTreeNode, reason: collision with other method in class */
    public final TreeNode m664getTreeNode() {
        TreeNode r0 = new TreeNode();
        r0.url = this.treeNode.getUrl();
        r0.space_id = this.treeNode.getSpaceId();
        r0.wiki_token = this.treeNode.getWikiToken();
        r0.obj_token = this.treeNode.getObjToken();
        r0.obj_type = this.treeNode.getObjType();
        r0.title = this.treeNode.getTitle();
        r0.parent_wiki_token = this.treeNode.getParentWikiToken();
        r0.sort_id = this.treeNode.getSortId();
        r0.wiki_node_type = this.treeNode.getWikiNodeType();
        r0.origin_wiki_token = this.treeNode.getOriginWikiToken();
        r0.origin_space_id = this.treeNode.getOriginSpaceId();
        r0.is_star = this.treeNode.isStar();
        r0.has_child = this.treeNode.getHasChild();
        r0.secret_key_delete = this.treeNode.getSecretKeyDelete();
        r0.is_explorer_star = this.treeNode.isExplorerStar();
        r0.is_explorer_pin = this.treeNode.isExplorerPin();
        r0.origin_is_external = this.treeNode.getOriginIsExternal();
        r0.entity_delete_flag = this.treeNode.getEntityDeleteFlag();
        JSONObject r1 = new JSONObject(this.treeNode.getDetailInfo());     // Catch: Exception -> L5
        WikiDetailInfo r2 = new WikiDetailInfo();     // Catch: Exception -> L5
        r0.detail_info = r2;     // Catch: Exception -> L5
        r2.owner_id = r1.optString("owner_id");     // Catch: Exception -> L5
        WikiDetailInfo r3 = r0.detail_info;     // Catch: Exception -> L5
        r3.thumbnail = r1.optString("thumbnail");     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.d(TAG, String.valueOf(e.getMessage()));
        goto L7
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final JSWikiTreeNode getTreeNode() {
        return this.treeNode;
    }

    public JSWikiMoreModel(JSWikiTreeNode r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "treeNode");
        this.treeNode = r2;
        this.x = r3;
        this.y = r4;
    }
}
