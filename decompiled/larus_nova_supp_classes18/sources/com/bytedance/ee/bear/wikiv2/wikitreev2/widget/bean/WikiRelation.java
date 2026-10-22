package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetFavoriteRelationPuller;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiRelation implements NonProguard {
    private static final String TAG = "WikiRelation";
    public boolean fromCache;

    @SerializedName("path_resolve_result")
    @JSONField(name = "path_resolve_result")
    public Integer pathResolveResult;
    public SpaceInfo space;
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
        Tree r0 = this.tree;
        r0.favorite_root_token = "wikiroot%favorite";
        r0.shared_root_token = "wikiroot%shared";
        addRoot(TreeNode.createVirtualRoot(this.space.space_id, "wikiroot%shared", -4), this.tree.shared);
        addRoot(TreeNode.createVirtualRoot(this.space.space_id, this.tree.root_token, 2), null);
        addRoot(TreeNode.createVirtualRoot(this.space.space_id, "wikiroot%favorite", -1), null);
    }

    public boolean isValid() {
        Tree r0 = this.tree;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.isEmpty(r0.root_token) == true) goto L11;
        SpaceInfo r1 = this.space;
        if (r1 == null) goto L11;
        if (TextUtils.isEmpty(r1.space_id) == true) goto L11;
        return true;
    }

    public String toString() {
        Tree r0 = this.tree;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        Tree r3 = this.tree;
        if (r3 == null) goto L11;
        r1 = hu5.a.c(r3.shared);
    L11:
        return "WikiRelation{root_list=" + r2 + ", shared=" + r1 + '}';
    L5:
        r2 = hu5.a.c(r0.root_list);
        goto L6
    }

    public void addFavorite(GetFavoriteRelationPuller.Result r5) {
        Tree r0 = this.tree;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.nodes != null) goto L7;
        return;
    L7:
        if (r0.child_map == null) goto L29;
        GetFavoriteRelationPuller.Data r1 = r5.favorite_node_list;
        if (r1 != null) goto L11;
        return;
    L11:
        if (hu5.a.e(r1.nodes) == false) goto L13;
        return;
    L13:
        if (hu5.a.d(r5.favorite_node_list.root_list) == true) goto L32;
        Iterator<TreeNode> r2 = r5.favorite_node_list.nodes.values().iterator();
    L16:
        if (r2.hasNext() == false) goto L20;
        TreeNode r3 = r2.next();
        if (this.tree.nodes.containsKey(r3.wiki_token) == true) goto L16;
        this.tree.nodes.put(r3.wiki_token, r3);
        goto L16
    L20:
        this.tree.child_map.put("wikiroot%favorite", r5.favorite_node_list.root_list);
        return;
    L32:
        return;
    }

    public void addRoot(TreeNode r4, List<String> r5) {
        Tree r0 = this.tree;
        if (r0.nodes != null) goto L5;
        r0.nodes = new HashMap();
    L5:
        Tree r1 = this.tree;
        if (r1.child_map != null) goto L8;
        r1.child_map = new HashMap();
    L8:
        this.tree.nodes.put(r4.wiki_token, r4);
        if (r5 == null) goto L23;
        Iterator<String> r2 = r5.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        String r3 = r2.next();
        TreeNode r6 = this.tree.nodes.get(r3);
        if (r6 == null) goto L12;
        r6.parent_wiki_token = r4.wiki_token;
        goto L12
    L16:
        this.tree.child_map.put(r4.wiki_token, r5);
        return;
    }
}
