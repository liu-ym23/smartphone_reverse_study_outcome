package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SidebarListInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "nodeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getNodeList", "()Ljava/util/ArrayList;", "setNodeList", "(Ljava/util/ArrayList;)V", "entities", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SidebarListInfo$NodeEntities;", "getEntities", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SidebarListInfo$NodeEntities;", "setEntities", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SidebarListInfo$NodeEntities;)V", "NodeEntities", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarListInfo implements NonProguard {

    @SerializedName("entities")
    private NodeEntities entities;

    @SerializedName("node_list")
    private ArrayList<String> nodeList;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R>\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR>\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SidebarListInfo$NodeEntities;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "nodes", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "Lkotlin/collections/HashMap;", "getNodes", "()Ljava/util/HashMap;", "setNodes", "(Ljava/util/HashMap;)V", "space", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity;", "getSpace", "setSpace", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NodeEntities implements NonProguard {

        @SerializedName("nodes")
        private HashMap<String, TreeNode> nodes;

        /* JADX INFO: renamed from: space, reason: collision with root package name */
        @SerializedName("space")
        private HashMap<String, SpaceEntity> f241719space;

        public NodeEntities() {
        }

        public final HashMap<String, TreeNode> getNodes() {
            return this.nodes;
        }

        public final HashMap<String, SpaceEntity> getSpace() {
            return this.f241719space;
        }

        public final void setNodes(HashMap<String, TreeNode> r100) {
            this.nodes = r100;
        }

        public final void setSpace(HashMap<String, SpaceEntity> r100) {
            this.f241719space = r100;
        }
    }

    public SidebarListInfo() {
    }

    public final NodeEntities getEntities() {
        return this.entities;
    }

    public final ArrayList<String> getNodeList() {
        return this.nodeList;
    }

    public final void setEntities(NodeEntities r100) {
        this.entities = r100;
    }

    public final void setNodeList(ArrayList<String> r100) {
        this.nodeList = r100;
    }
}
