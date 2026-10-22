package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetFavoriteRelationPuller;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class WikiRelation implements NonProguard {
    private static final String TAG = "WikiRelation";
    public boolean fromCache;

    @SerializedName("path_resolve_result")
    @JSONField(name = "path_resolve_result")
    public Integer pathResolveResult;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    public SpaceInfo f241731space;
    public SpacePerm space_perm;
    public Tree tree;
    public SpaceUserPerm user_space_perm;

    public static class Tree implements NonProguard {
        public HashMap<String, List<String>> child_map;
        public String favorite_root_token;
        public HashMap<String, TreeNode> nodes;
        public List<String> paths;
        public String pinedRootToken;
        public List<String> root_list;
        public String root_token;
        public List<String> shared;
        public String shared_root_token;
        public String spaceRootToken;

        public Tree() {
        }
    }

    public WikiRelation() {
    }

    public void init() {
        Tree r100 = this.tree;
        r100.favorite_root_token = "wikiroot%favorite";
        r100.shared_root_token = "wikiroot%shared";
        addRoot(TreeNode.createVirtualRoot(this.f241731space.space_id, "wikiroot%shared", -4), this.tree.shared);
        addRoot(TreeNode.createVirtualRoot(this.f241731space.space_id, this.tree.root_token, 2), null);
        addRoot(TreeNode.createVirtualRoot(this.f241731space.space_id, "wikiroot%favorite", -1), null);
    }

    public boolean isValid() {
        Tree r100 = this.tree;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.root_token) == true) goto L11;
        SpaceInfo r101 = this.f241731space;
        if (r101 == null) goto L11;
        if (TextUtils.isEmpty(r101.space_id) == true) goto L11;
        return true;
    }

    public String toString() {
        Tree r100 = this.tree;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        Tree r103 = this.tree;
        if (r103 == null) goto L11;
        r101 = hu5.a.c(r103.shared);
    L11:
        return "WikiRelation{root_list=" + r102 + ", shared=" + r101 + '}';
    L5:
        r102 = hu5.a.c(r100.root_list);
        goto L6
    }

    public void addFavorite(GetFavoriteRelationPuller.Result r100) {
        Tree r101 = this.tree;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.nodes != null) goto L7;
        return;
    L7:
        if (r101.child_map == null) goto L29;
        GetFavoriteRelationPuller.Data r102 = r100.favorite_node_list;
        if (r102 != null) goto L11;
        return;
    L11:
        if (hu5.a.e(r102.nodes) == false) goto L13;
        return;
    L13:
        if (hu5.a.d(r100.favorite_node_list.root_list) == true) goto L32;
        Iterator<TreeNode> r103 = r100.favorite_node_list.nodes.values().iterator();
    L16:
        if (r103.hasNext() == false) goto L20;
        TreeNode r104 = r103.next();
        if (this.tree.nodes.containsKey(r104.wiki_token) == true) goto L16;
        this.tree.nodes.put(r104.wiki_token, r104);
        goto L16
    L20:
        this.tree.child_map.put("wikiroot%favorite", r100.favorite_node_list.root_list);
        return;
    L32:
        return;
    }

    public void addRoot(TreeNode r100, List<String> r101) {
        Tree r102 = this.tree;
        if (r102.nodes != null) goto L5;
        r102.nodes = new HashMap();
    L5:
        Tree r103 = this.tree;
        if (r103.child_map != null) goto L8;
        r103.child_map = new HashMap();
    L8:
        this.tree.nodes.put(r100.wiki_token, r100);
        if (r101 == null) goto L23;
        Iterator<String> r104 = r101.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        TreeNode r106 = this.tree.nodes.get(r105);
        if (r106 == null) goto L12;
        r106.parent_wiki_token = r100.wiki_token;
        goto L12
    L16:
        this.tree.child_map.put(r100.wiki_token, r101);
        return;
    }
}
