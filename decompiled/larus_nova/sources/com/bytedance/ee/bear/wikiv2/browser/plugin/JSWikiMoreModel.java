package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiMoreModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "treeNode", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;", "x", "", "y", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;II)V", "getTreeNode", "()Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;", "getX", "()I", "getY", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSWikiMoreModel implements NonProguard {
    public static final a Companion = null;
    public static final String TAG = "JSWikiMoreModel";
    private final JSWikiTreeNode treeNode;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f240474x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f240475y;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ JSWikiMoreModel copy$default(JSWikiMoreModel r100, JSWikiTreeNode r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.treeNode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f240474x;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f240475y;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final JSWikiTreeNode component1() {
        return this.treeNode;
    }

    public final int component2() {
        return this.f240474x;
    }

    public final int component3() {
        return this.f240475y;
    }

    public final JSWikiMoreModel copy(JSWikiTreeNode r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "treeNode");
        return new JSWikiMoreModel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JSWikiMoreModel) == true) goto L8;
        return false;
    L8:
        JSWikiMoreModel r101 = (JSWikiMoreModel) r100;
        if (Intrinsics.areEqual(this.treeNode, r101.treeNode) == true) goto L12;
        return false;
    L12:
        if (this.f240474x == r101.f240474x) goto L15;
        return false;
    L15:
        if (this.f240475y == r101.f240475y) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.treeNode.hashCode() * 31) + this.f240474x) * 31) + this.f240475y;
    }

    public String toString() {
        return "JSWikiMoreModel(treeNode=" + this.treeNode + ", x=" + this.f240474x + ", y=" + this.f240475y + ')';
    }

    /* JADX INFO: renamed from: getTreeNode, reason: collision with other method in class */
    public final TreeNode m8336getTreeNode() {
        TreeNode r100 = new TreeNode();
        r100.url = this.treeNode.getUrl();
        r100.space_id = this.treeNode.getSpaceId();
        r100.wiki_token = this.treeNode.getWikiToken();
        r100.obj_token = this.treeNode.getObjToken();
        r100.obj_type = this.treeNode.getObjType();
        r100.title = this.treeNode.getTitle();
        r100.parent_wiki_token = this.treeNode.getParentWikiToken();
        r100.sort_id = this.treeNode.getSortId();
        r100.wiki_node_type = this.treeNode.getWikiNodeType();
        r100.origin_wiki_token = this.treeNode.getOriginWikiToken();
        r100.origin_space_id = this.treeNode.getOriginSpaceId();
        r100.is_star = this.treeNode.isStar();
        r100.has_child = this.treeNode.getHasChild();
        r100.secret_key_delete = this.treeNode.getSecretKeyDelete();
        r100.is_explorer_star = this.treeNode.isExplorerStar();
        r100.is_explorer_pin = this.treeNode.isExplorerPin();
        r100.origin_is_external = this.treeNode.getOriginIsExternal();
        r100.entity_delete_flag = this.treeNode.getEntityDeleteFlag();
        JSONObject r101 = new JSONObject(this.treeNode.getDetailInfo());     // Catch: Exception -> L5
        WikiDetailInfo r102 = new WikiDetailInfo();     // Catch: Exception -> L5
        r100.detail_info = r102;     // Catch: Exception -> L5
        r102.owner_id = r101.optString("owner_id");     // Catch: Exception -> L5
        WikiDetailInfo r103 = r100.detail_info;     // Catch: Exception -> L5
        r103.thumbnail = r101.optString(DocCallbackImpl.KEY_THUMBNAIL);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        tt5.a.d(TAG, String.valueOf(e.getMessage()));
        goto L7
    }

    public final int getX() {
        return this.f240474x;
    }

    public final int getY() {
        return this.f240475y;
    }

    public final JSWikiTreeNode getTreeNode() {
        return this.treeNode;
    }

    public JSWikiMoreModel(JSWikiTreeNode r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "treeNode");
        this.treeNode = r100;
        this.f240474x = r101;
        this.f240475y = r102;
    }
}
