package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e3 {
    public static final e3 r = null;
    public String a;
    public String b;
    public final String c;
    public final String d;
    public final String e;
    public final Map<String, List<String>> f;
    public final Map<String, TreeNode> g;
    public final Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> h;
    public final Map<String, List<String>> i;
    public SpaceInfo j;
    public final SpaceUserPerm k;
    public final SpacePerm l;
    public Function<TreeNode, Boolean> m;
    public List<Function<TreeNode, Boolean>> n;
    public List<Function<TreeNode, Boolean>> o;
    public final boolean p;
    public final BenefitStore q;

    static {
        r = new e3();
    }

    public final Map<String, TreeNode> b() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, TreeNode>> r1 = this.g.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, TreeNode> r2 = r1.next();
        r0.put(r2.getKey(), r2.getValue().clone());
        goto L4
    L6:
        return r0;
    }

    public final Map<String, List<String>> c() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, List<String>>> r1 = this.f.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r2 = r1.next();
        r0.put(r2.getKey(), new ArrayList(r2.getValue()));
        goto L4
    L6:
        return r0;
    }

    public final Map<String, List<String>> d() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, List<String>>> r1 = this.i.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r2 = r1.next();
        r0.put(r2.getKey(), new ArrayList(r2.getValue()));
        goto L4
    L6:
        return r0;
    }

    public final Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> e() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a>> r1 = this.h.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> r2 = r1.next();
        r0.put(r2.getKey(), r2.getValue().a());
        goto L4
    L6:
        return r0;
    }

    public final boolean u() {
        String r0 = this.a;
        String r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r0, r0, 0, "");
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r2 = this.h.get(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.d;
    }

    public final boolean w() {
        SpaceInfo r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r0.space_id) == true) goto L7;
        return true;
    }

    public e3() {
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.l = new SpacePerm();
        this.q = null;
    }

    public final String o() {
        if (w() == true) goto L7;
        return "";
    L7:
        return this.j.space_id;
    }

    public final List<String> A(String r5) {
        ArrayList r0 = new ArrayList();
        if (x(r5) == true) goto L5;
    L22:
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeNode, invalid params. ");
        return r0;
    L5:
        if (x(((TreeNode) ((ConcurrentHashMap) this.g).get(r5)).parent_wiki_token) == false) goto L22;
        String r1 = ((TreeNode) ((ConcurrentHashMap) this.g).get(r5)).parent_wiki_token;
        if (q(r1) == true) goto L11;
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeNode, destParent type: dir, no children cache. ");
        return r0;
    L11:
        ((List) ((ConcurrentHashMap) this.f).get(r1)).remove(r5);
        Map<String, List<String>> r2 = this.f;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        List r4 = (List) r3.get(this.a);
        if (r4 != null) goto L14;
    L16:
        f(r5, r0, 0);
        Iterator r6 = r0.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        String r7 = (String) r6.next();
        ((ConcurrentHashMap) this.f).remove(r7);
        ((ConcurrentHashMap) this.g).remove(r7);
        goto L18
    L20:
        a(r1);
        return r0;
    L14:
        if (r4.contains(r5) == false) goto L16;
        K(r5);
        goto L16
    }

    public final void C(String r2) {
        if (y(r2) == false) goto L6;
        ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) this.h).get(r2)).d = true;
        return;
    }

    public final Triple<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a, String> E(String r8) {
        if (x(r8) == false) goto L12;
        TreeNode r0 = this.g.get(r8);
        String r1 = r0.parent_wiki_token;
        if (TextUtils.isEmpty(r1) == false) goto L8;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r2 = n(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r8, r8, 0, ""), "", r8);
        r2.e = 0;
        r2.d = true;
        return new Triple(r8, r2, "");
    L8:
        Triple<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a, String> r3 = E(r1);
        if (r3 == null) goto L14;
        String r4 = (String) r3.getFirst();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r5 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) r3.getSecond();
        String r6 = (String) r3.getThird();
        int r7 = r5.e + 1;
        String r9 = r5.a;
        String r10 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r4, r8, r7, r6);
        String r11 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.b(r0.isShortcut(), r8, r6);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r12 = n(r10, r9, r8);
        r12.e = r7;
        r12.d = true;
        return new Triple(r4, r12, r11);
    L14:
        return null;
    L12:
        return null;
    }

    public final void I(String r4) {
        Iterator r0 = ((ConcurrentHashMap) this.g).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        TreeNode r1 = (TreeNode) r0.next();
        if (TextUtils.equals(r1.getOriginToken(), r4) == false) goto L4;
        r1.entity_delete_flag = 1;
        goto L4
    }

    public final void K(String r3) {
        if (x(r3) == false) goto L6;
        this.g.get(r3).is_star = false;
        j(this.a).remove(r3);
        return;
    }

    public final void a(String r3) {
        ((TreeNode) ((ConcurrentHashMap) this.g).get(r3)).has_child = !hu5.a.d((Collection) ((ConcurrentHashMap) this.f).get(r3));
    }

    public final List<String> i(String r3) {
        ArrayList r0 = new ArrayList();
        List<String> r4 = this.f.get(r3);
        if (hu5.a.d(r4) == false) goto L5;
        return r0;
    L5:
        r0.addAll(r4);
        return r0;
    }

    public final List<String> j(String r3) {
        List<String> r0 = this.f.get(r3);
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        this.f.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public final List<j> k(String r10) {
        if (x(r10) == true) goto L6;
        tt5.a.k("Wiki_Workspaces", "Workspaces.getDftFlatResult, invalid params. ");
        return new ArrayList(0);
    L6:
        ArrayList r0 = new ArrayList();
        g(r10, r10, 0, "", "", new HashSet(), r0);
        return r0;
    }

    public final String l(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L14;
        List<String> r5 = this.i.get(r4);
        if (hu5.a.d(r5) == true) goto L20;
        int r0 = r5.size() - 1;
    L7:
        if (r0 < 0) goto L21;
        String r1 = (String) ListProtector.get(r5, r0);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r2 = this.h.get(r1);
        if (r2 == null) goto L13;
        if (r2.h == false) goto L13;
        return r1;
    L13:
        r0 = r0 - 1;
        goto L7
    L21:
        return "";
    L20:
        return "";
    L14:
        return "";
    }

    public final TreeNode m(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return this.g.get(r2);
    }

    public final boolean q(String r2) {
        if (x(r2) == true) goto L7;
        tt5.a.k("Wiki_Workspaces", "Workspaces.hasNodeChildrenCache, invalid params. ");
        return false;
    L7:
        return !hu5.a.d(this.f.get(r2));
    }

    public final boolean v(String r3) {
        if (x(r3) == true) goto L5;
        tt5.a.k("Wiki_Workspaces", "Workspaces.getNodeType, invalid params. ");
        int r0 = -1;
    L7:
        if (r0 != WikNodeType.LEAF.getValue()) goto L9;
    L14:
        return true;
    L9:
        if (TextUtils.equals(r3, this.b) == true) goto L14;
        if (q(r3) == true) goto L14;
        return false;
    L5:
        r0 = ((TreeNode) ((ConcurrentHashMap) this.g).get(r3)).getNodeType();
        goto L7
    }

    public final boolean x(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.g.get(r2) == null) goto L7;
        return true;
    }

    public final boolean y(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r4 = this.h.get(r3);
        if (r4 != null) goto L8;
        return false;
    L8:
        if (x(r4.c) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public e3(f3 r7, ce5.a r8) {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        this.f = r0;
        ConcurrentHashMap r1 = new ConcurrentHashMap();
        this.g = r1;
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.l = new SpacePerm();
        this.q = null;
        this.b = r7.a;
        this.a = r7.b;
        this.c = r7.c;
        this.d = r7.d;
        this.e = r7.e;
        r1.putAll(r7.g);
        this.q = r8.g.n1();
        if (qc5.a.g(r8) == false) goto L22;
        Map<String, List<String>> r9 = r7.f;
        ConcurrentHashMap r2 = new ConcurrentHashMap();
        if (r9 == null) goto L21;
        Iterator<Map.Entry<String, List<String>>> r10 = r9.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L21;
        Map.Entry<String, List<String>> r3 = r10.next();
        if (r3 == null) goto L9;
        List<String> r4 = r3.getValue();
        if (r4 == null) goto L9;
        ArrayList r5 = new ArrayList();
        Iterator<String> r6 = r4.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        r5.add(r6.next());
        goto L18
    L20:
        r2.put(r3.getKey(), r5);
    L21:
        r0.putAll(r2);
    L23:
        this.j = r7.h;
        this.k = r7.i;
        this.l = r7.j;
        this.p = r7.k;
        Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> r11 = r7.l;
        if (r11 == null) goto L26;
        ((ConcurrentHashMap) this.h).putAll(r11);
    L26:
        Map<String, List<String>> r12 = r7.m;
        if (r12 == null) goto L38;
        ((ConcurrentHashMap) this.i).putAll(r12);
        return;
    L38:
        return;
    L22:
        r0.putAll(r7.f);
        goto L23
    }

    public final void B(String r5, List<TreeNode> r6) {
        if (x(r5) == true) goto L5;
    L25:
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeSingleNode, invalid wikiToken. ");
        return;
    L5:
        if (x(((TreeNode) ((ConcurrentHashMap) this.g).get(r5)).parent_wiki_token) == false) goto L25;
        String r0 = ((TreeNode) ((ConcurrentHashMap) this.g).get(r5)).parent_wiki_token;
        if (q(r0) == true) goto L11;
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeSingleNode, destParent type: dir, no children cache. ");
        return;
    L11:
        ((List) ((ConcurrentHashMap) this.f).get(r0)).remove(r5);
        Map<String, List<String>> r1 = this.f;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        List r3 = (List) r2.get(this.a);
        if (r3 != null) goto L14;
    L16:
        ((ConcurrentHashMap) this.f).remove(r5);
        ((ConcurrentHashMap) this.g).remove(r5);
        if (r6 == null) goto L23;
        ArrayList r7 = new ArrayList();
        Iterator<TreeNode> r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        TreeNode r4 = r8.next();
        Map<String, TreeNode> r9 = this.g;
        ConcurrentHashMap r10 = (ConcurrentHashMap) r9;
        r10.put(r4.wiki_token, r4);
        r7.add(r4.wiki_token);
        goto L20
    L22:
        ((ConcurrentHashMap) this.f).put(r0, r7);
    L23:
        a(r0);
        return;
    L14:
        if (r3.contains(r5) == false) goto L16;
        K(r5);
        goto L16
    }

    public final void F(String r3, boolean r4) {
        if (x(r3) == false) goto L17;
        TreeNode r0 = this.g.get(r3);
        Triple<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a, String> r5 = E(r3);
        if (r5 == null) goto L18;
        String r6 = ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) r5.getSecond()).a;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r7 = this.h.get(r6);
        if (r7 == null) goto L19;
        if (r4 == true) goto L10;
    L14:
        boolean r8 = false;
    L15:
        r7.d = r8;
        return;
    L10:
        if (q(r0.getOriginToken()) == false) goto L12;
    L13:
        r8 = true;
        goto L15
    L12:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.c(r0.wiki_node_type) == false) goto L14;
    L19:
        return;
    L18:
        return;
    }

    public final void G(String r4, boolean r5) {
        Iterator<TreeNode> r0 = this.g.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        TreeNode r1 = r0.next();
        if (TextUtils.equals(r1.getOriginToken(), r4) == false) goto L4;
        r1.is_explorer_star = r5;
        goto L4
    }

    public final void H(String r4, boolean r5) {
        Iterator<TreeNode> r0 = this.g.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        TreeNode r1 = r0.next();
        if (TextUtils.equals(r1.getOriginToken(), r4) == false) goto L4;
        r1.is_explorer_pin = r5;
        goto L4
    }

    public final int J(String r4, double r5) {
        if (x(r4) == true) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (q(r4) == false) goto L18;
        Iterator<String> r6 = this.f.get(r4).iterator();
        int r0 = 0;
    L9:
        if (r6.hasNext() == false) goto L13;
        String r1 = r6.next();
        if (Double.compare(r5, this.g.get(r1).sort_id) <= 0) goto L13;
        r0 = r0 + 1;
    L13:
        return r0;
    L18:
        return Integer.MAX_VALUE;
    }

    public final void M(String r3, String r4) {
        if (x(r3) == true) goto L6;
        tt5.a.k("Wiki_Workspaces", "Workspaces.updateSpaceId, invalid params. ");
        return;
    L6:
        ArrayList r0 = new ArrayList();
        f(r3, r0, 0);
        Iterator r5 = r0.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        String r1 = (String) r5.next();
        TreeNode r2 = (TreeNode) ((ConcurrentHashMap) this.g).get(r1);
        if (r2 == null) goto L8;
        r2.space_id = r4;
        r2.perm = null;
        goto L8
    }

    public final String p(String r3, String r4) {
        List<String> r5 = this.i.get(r3);
        if (hu5.a.d(r5) == true) goto L12;
        Iterator<String> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L20;
        String r0 = r6.next();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r1 = this.h.get(r0);
        if (r1 == null) goto L6;
        if (TextUtils.equals(r1.b, r4) == false) goto L6;
        return r0;
    L20:
        return "";
    L12:
        return "";
    }

    public final void s(String r3, List<TreeNode> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.size() <= 0) goto L6;
        double r0 = ((TreeNode) ListProtector.get(r4, 0)).sort_id;
    L7:
        r(r3, J(r3, r0), r4);
        return;
    L6:
        r0 = 0.0d;
        goto L7
    }

    public final boolean t(String r2, String r3) {
        if (x(r3) == true) goto L5;
    L13:
        return false;
    L5:
        if (x(r2) == false) goto L13;
        TreeNode r4 = (TreeNode) ((ConcurrentHashMap) this.g).get(r2);
    L8:
        if (r4 == null) goto L13;
        if (TextUtils.equals(r4.wiki_token, r3) == true) goto L11;
        Map<String, TreeNode> r0 = this.g;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r4 = (TreeNode) r1.get(r4.parent_wiki_token);
        goto L8
    L11:
        return true;
    }

    public e3(WikiRelation r18, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r19, ce5.a r20) {
        WikiRelation.Tree r2 = r18.tree;
        this(new f3(r2.root_token, r2.favorite_root_token, r2.shared_root_token, r2.pinedRootToken, r2.spaceRootToken, r2.child_map, r2.nodes, r18.space, r18.user_space_perm, r18.space_perm, r18.fromCache, r19.a, r19.b), r20);
    }

    public final void D(String r2, String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        F(r2, r4);
        return;
    L5:
        if (y(r3) == false) goto L19;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r5 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) this.h).get(r3);
        Map<String, TreeNode> r6 = this.g;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        TreeNode r8 = (TreeNode) r7.get(r5.c);
        if (r4 == true) goto L9;
    L11:
        boolean r9 = false;
    L12:
        r5.d = r9;
        String r10 = r5.b;
    L14:
        if (y(r10) == false) goto L20;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r11 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) this.h).get(r10);
        r11.d = true;
        r10 = r11.b;
        goto L14
    L20:
        return;
    L9:
        if (q(r8.getOriginToken()) == false) goto L11;
        r9 = true;
        goto L12
    }

    public final void L(String r4, TreeNode r5, String r6) {
        if (x(r4) == true) goto L6;
        tt5.a.k("Wiki_Workspaces", "Wiki_Workspaces.updateNodeToken, invalid params. ");
        return;
    L6:
        if (r5 != null) goto L10;
        tt5.a.h("Wiki_Workspaces", "Wiki_Workspaces.updateNodeToken, empty childs. ");
        return;
    L10:
        if (((ConcurrentHashMap) this.g).containsKey(r6) == false) goto L12;
        ((ConcurrentHashMap) this.g).remove(r6);
        ((ConcurrentHashMap) this.f).remove(r6);
    L12:
        Map<String, TreeNode> r0 = this.g;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(r5.wiki_token) == true) goto L15;
        Map<String, TreeNode> r2 = this.g;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(r5.wiki_token, r5);
    L15:
        List<String> r7 = j(r4);
        r7.remove(r6);
        ArrayList r8 = new ArrayList();
        r8.add(r5.wiki_token);
        r8.removeAll(r7);
        int r9 = J(r4, r5.sort_id);
        int r10 = r7.size();
        int r11 = up5.h.a;
        if (r10 >= 0) goto L18;
        int r12 = -1;
    L19:
        r7.addAll(r12, r8);
        a(r4);
        return;
    L18:
        r12 = Math.min(Math.max(r9, 0), r10);
        goto L19
    }

    public final void f(String r3, List<String> r4, int r5) {
        if (r5 <= 30) goto L5;
        return;
    L5:
        ArrayList r1 = (ArrayList) r4;
        r1.add(((TreeNode) ((ConcurrentHashMap) this.g).get(r3)).wiki_token);
        List r6 = (List) ((ConcurrentHashMap) this.f).get(r3);
        if (hu5.a.d(r6) == true) goto L11;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        f((String) r7.next(), r4, r5 + 1);
        goto L9
    L13:
        return;
    }

    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a n(String r2, String r3, String r4) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r0 = this.h.get(r2);
        if (r0 != null) goto L8;
        r0 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a(r2, r3, r4);
        this.h.put(r2, r0);
        List<String> r5 = this.i.get(r4);
        if (r5 != null) goto L7;
        r5 = new ArrayList();
    L7:
        r5.add(r2);
        this.i.put(r4, r5);
    L8:
        return r0;
    }

    public final void r(String r6, int r7, List<TreeNode> r8) {
        if (x(r6) == true) goto L7;
        tt5.a.k("Wiki_Workspaces", "Wiki_Workspaces.insertChildren, invalid params. ");
        return;
    L7:
        if (hu5.a.d(r8) == false) goto L10;
        tt5.a.h("Wiki_Workspaces", "Wiki_Workspaces.insertChildren, empty childs. ");
        return;
    L10:
        ArrayList r0 = new ArrayList();
        if (r8 == null) goto L22;
        Iterator<TreeNode> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L22;
        TreeNode r1 = r9.next();
        r0.add(r1.wiki_token);
        TreeNode r2 = this.g.get(r1.wiki_token);
        if (r2 == null) goto L17;
        if (r1.isSortIdNativeGenerate() == true) goto L14;
        r2.sort_id = r1.sort_id;
        goto L14
    L17:
        this.g.put(r1.wiki_token, r1);
    L22:
        if (hu5.a.d(r0) == true) goto L28;
        List<String> r10 = j(r6);
        r0.removeAll(r10);
        int r3 = r10.size();
        int r4 = up5.h.a;
        if (r3 >= 0) goto L26;
        int r11 = -1;
    L27:
        r10.addAll(r11, r0);
        goto L28
    L26:
        r11 = Math.min(Math.max(r7, 0), r3);
    L28:
        a(r6);
    }

    public final void z(String r4, String r5, double r6, String r8) {
        if (x(r4) == true) goto L5;
    L22:
        tt5.a.k("Wiki_Workspaces", "Workspaces.moveNode, invalid params. ");
        return;
    L5:
        if (x(((TreeNode) ((ConcurrentHashMap) this.g).get(r4)).parent_wiki_token) == false) goto L22;
        if (x(r5) == false) goto L22;
        String r0 = ((TreeNode) ((ConcurrentHashMap) this.g).get(r4)).parent_wiki_token;
        if (q(r0) == true) goto L13;
        tt5.a.k("Wiki_Workspaces", "Workspaces.moveNodes, destParent type: dir, no children cache. ");
        return;
    L13:
        ((List) ((ConcurrentHashMap) this.f).get(r0)).remove(r4);
        a(r0);
        TreeNode r1 = (TreeNode) ((ConcurrentHashMap) this.g).get(r4);
        if (r1 == null) goto L16;
        r1.parent_wiki_token = r5;
        r1.space_id = r8;
    L16:
        List<String> r9 = j(r5);
        int r7 = J(r5, r6);
        int r10 = r9.size();
        int r2 = up5.h.a;
        if (r10 >= 0) goto L19;
        int r11 = -1;
    L20:
        ListProtector.add(r9, r11, r4);
        a(r5);
        return;
    L19:
        r11 = Math.min(Math.max(r7, 0), r10);
        goto L20
    }

    public final j h(TreeNode r4, String r5, int r6, String r7, String r8) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r9 = n(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r5, r4.wiki_token, r6, r7), r8, r4.wiki_token);
        r9.e = r6;
        r9.h = TextUtils.isEmpty(r7);
        List<Function<TreeNode, Boolean>> r10 = this.n;
        boolean r11 = false;
        if (r10 == null) goto L13;
        Iterator<Function<TreeNode, Boolean>> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        if (((Boolean) r12.next().apply(r4)).booleanValue() == true) goto L6;
        boolean r13 = false;
    L14:
        r9.f = r13;
        List<Function<TreeNode, Boolean>> r14 = this.o;
        if (r14 != null) goto L29;
    L24:
        r11 = true;
    L25:
        r9.g = r11;
        return j.a(r4, r9);
    L29:
        Iterator<Function<TreeNode, Boolean>> r15 = r14.iterator();     // Catch: Exception -> L22
    L18:
        if (r15.hasNext() == false) goto L24;
        if (((Boolean) r15.next().apply(r4)).booleanValue() == true) goto L18;
    L22:
        e = move-exception;
        tt5.a.e("Wiki_Workspaces", "enableSwipeChecker apply err. ", e, false);
    L11:
        e = move-exception;
        tt5.a.e("Wiki_Workspaces", "enableChecker apply err. ", e, false);
    L13:
        r13 = true;
        goto L14
    }

    public final void g(String r19, String r20, int r21, String r22, String r23, Set r24, List r25) {
        TreeNode r7 = (TreeNode) ((ConcurrentHashMap) this.g).get(r20);
        if (r7 != null) goto L5;
        return;
    L5:
        Function<TreeNode, Boolean> r0 = this.m;
        boolean r8 = false;
        if (r0 != null) goto L41;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L16;
        return;
    L16:
        if (r7.isShortcut() == false) goto L20;
        Map<String, TreeNode> r2 = this.g;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        TreeNode r4 = (TreeNode) r3.get(r7.getOriginToken());
        if (r4 == null) goto L20;
        r7.has_child = r4.has_child;
    L20:
        j r5 = h(r7, r19, r21, r22, r23);
        ArrayList r12 = (ArrayList) r25;
        r12.add(r5);
        String r13 = r5.n;
        String r14 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.b(r7.isShortcut(), r20, r22);
        String r15 = r7.getOriginToken();
        HashSet r9 = (HashSet) r24;
        if (r9.contains(r15) == false) goto L23;
        r5.k = false;
        r5.q = WikNodeType.LEAF.getValue();
        List r6 = null;
    L25:
        if (r5.q != WikNodeType.LEAF.getValue()) goto L27;
        r8 = true;
    L27:
        if (r8 == false) goto L29;
        return;
    L29:
        if (r5.p == false) goto L45;
        r9.add(r15);
        int r10 = r12.size();
        if (hu5.a.d(r6) == true) goto L36;
        Iterator r16 = r6.iterator();
    L34:
        if (r16.hasNext() == false) goto L36;
        g(r19, (String) r16.next(), r21 + 1, r14, r13, r24, r25);
        r9 = r9;
    L36:
        HashSet r17 = r9;
        if (r12.size() != r10) goto L39;
        r12.add(h(TreeNode.createNone(i.a(this), r20), r19, r21 + 1, r14, r13));
    L39:
        r17.remove(r15);
        return;
    L45:
        return;
    L23:
        r6 = (List) ((ConcurrentHashMap) this.f).get(r15);
        goto L25
    L41:
        if (((Boolean) r0.apply(r7)).booleanValue() == true) goto L12;
        r1 = true;
    L10:
        e = move-exception;
        tt5.a.e("Wiki_Workspaces", "dataFilter apply err. ", e, false);
        goto L12
    }
}
