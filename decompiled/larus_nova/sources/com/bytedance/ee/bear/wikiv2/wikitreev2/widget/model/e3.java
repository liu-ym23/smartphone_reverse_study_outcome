package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
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

/* JADX INFO: loaded from: classes18.dex */
public final class e3 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e3 f241826r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f241827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f241828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f241830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f241831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f241832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, TreeNode> f241833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> f241834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, List<String>> f241835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SpaceInfo f241836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SpaceUserPerm f241837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SpacePerm f241838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function<TreeNode, Boolean> f241839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Function<TreeNode, Boolean>> f241840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<Function<TreeNode, Boolean>> f241841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f241842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final BenefitStore f241843q;

    static {
        f241826r = new e3();
    }

    public final Map<String, TreeNode> b() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, TreeNode>> r101 = this.f241833g.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, TreeNode> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue().clone());
        goto L4
    L6:
        return r100;
    }

    public final Map<String, List<String>> c() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, List<String>>> r101 = this.f241832f.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r102 = r101.next();
        r100.put(r102.getKey(), new ArrayList(r102.getValue()));
        goto L4
    L6:
        return r100;
    }

    public final Map<String, List<String>> d() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, List<String>>> r101 = this.f241835i.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r102 = r101.next();
        r100.put(r102.getKey(), new ArrayList(r102.getValue()));
        goto L4
    L6:
        return r100;
    }

    public final Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> e() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a>> r101 = this.f241834h.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue().a());
        goto L4
    L6:
        return r100;
    }

    public final boolean u() {
        String r100 = this.f241827a;
        String r101 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r100, r100, 0, "");
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r102 = this.f241834h.get(r101);
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.f241735d;
    }

    public final boolean w() {
        SpaceInfo r100 = this.f241836j;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.space_id) == true) goto L7;
        return true;
    }

    public e3() {
        this.f241832f = new ConcurrentHashMap();
        this.f241833g = new ConcurrentHashMap();
        this.f241834h = new ConcurrentHashMap();
        this.f241835i = new ConcurrentHashMap();
        this.f241838l = new SpacePerm();
        this.f241843q = null;
    }

    public final String o() {
        if (w() == true) goto L7;
        return "";
    L7:
        return this.f241836j.space_id;
    }

    public final List<String> A(String r100) {
        ArrayList r101 = new ArrayList();
        if (x(r100) == true) goto L5;
    L22:
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeNode, invalid params. ");
        return r101;
    L5:
        if (x(((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).parent_wiki_token) == false) goto L22;
        String r102 = ((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).parent_wiki_token;
        if (q(r102) == true) goto L11;
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeNode, destParent type: dir, no children cache. ");
        return r101;
    L11:
        ((List) ((ConcurrentHashMap) this.f241832f).get(r102)).remove(r100);
        Map<String, List<String>> r103 = this.f241832f;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        List r105 = (List) r104.get(this.f241827a);
        if (r105 != null) goto L14;
    L16:
        f(r100, r101, 0);
        Iterator r106 = r101.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        String r107 = (String) r106.next();
        ((ConcurrentHashMap) this.f241832f).remove(r107);
        ((ConcurrentHashMap) this.f241833g).remove(r107);
        goto L18
    L20:
        a(r102);
        return r101;
    L14:
        if (r105.contains(r100) == false) goto L16;
        K(r100);
        goto L16
    }

    public final void C(String r100) {
        if (y(r100) == false) goto L6;
        ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) this.f241834h).get(r100)).f241735d = true;
        return;
    }

    public final Triple<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a, String> E(String r100) {
        if (x(r100) == false) goto L12;
        TreeNode r101 = this.f241833g.get(r100);
        String r102 = r101.parent_wiki_token;
        if (TextUtils.isEmpty(r102) == false) goto L8;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r103 = n(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r100, r100, 0, ""), "", r100);
        r103.f241736e = 0;
        r103.f241735d = true;
        return new Triple(r100, r103, "");
    L8:
        Triple<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a, String> r104 = E(r102);
        if (r104 == null) goto L14;
        String r105 = r104.getFirst();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r106 = r104.getSecond();
        String r107 = r104.getThird();
        int r108 = r106.f241736e + 1;
        String r109 = r106.f241732a;
        String r110 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r105, r100, r108, r107);
        String r111 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.b(r101.isShortcut(), r100, r107);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r112 = n(r110, r109, r100);
        r112.f241736e = r108;
        r112.f241735d = true;
        return new Triple(r105, r112, r111);
    L14:
        return null;
    L12:
        return null;
    }

    public final void I(String r100) {
        Iterator r101 = ((ConcurrentHashMap) this.f241833g).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        TreeNode r102 = (TreeNode) r101.next();
        if (TextUtils.equals(r102.getOriginToken(), r100) == false) goto L4;
        r102.entity_delete_flag = 1;
        goto L4
    }

    public final void K(String r100) {
        if (x(r100) == false) goto L6;
        this.f241833g.get(r100).is_star = false;
        j(this.f241827a).remove(r100);
        return;
    }

    public final void a(String r100) {
        ((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).has_child = !hu5.a.d((Collection) ((ConcurrentHashMap) this.f241832f).get(r100));
    }

    public final List<String> i(String r100) {
        ArrayList r101 = new ArrayList();
        List<String> r102 = this.f241832f.get(r100);
        if (hu5.a.d(r102) == false) goto L5;
        return r101;
    L5:
        r101.addAll(r102);
        return r101;
    }

    public final List<String> j(String r100) {
        List<String> r101 = this.f241832f.get(r100);
        if (r101 != null) goto L6;
        ArrayList r102 = new ArrayList();
        this.f241832f.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final List<j> k(String r110) {
        if (x(r110) == true) goto L6;
        tt5.a.k("Wiki_Workspaces", "Workspaces.getDftFlatResult, invalid params. ");
        return new ArrayList(0);
    L6:
        ArrayList r100 = new ArrayList();
        g(r110, r110, 0, "", "", new HashSet(), r100);
        return r100;
    }

    public final String l(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        List<String> r101 = this.f241835i.get(r100);
        if (hu5.a.d(r101) == true) goto L20;
        int r102 = r101.size() - 1;
    L7:
        if (r102 < 0) goto L21;
        String r103 = (String) ListProtector.get(r101, r102);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r104 = this.f241834h.get(r103);
        if (r104 == null) goto L13;
        if (r104.f241739h == false) goto L13;
        return r103;
    L13:
        r102 = r102 - 1;
        goto L7
    L21:
        return "";
    L20:
        return "";
    L14:
        return "";
    }

    public final TreeNode m(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return this.f241833g.get(r100);
    }

    public final boolean q(String r100) {
        if (x(r100) == true) goto L7;
        tt5.a.k("Wiki_Workspaces", "Workspaces.hasNodeChildrenCache, invalid params. ");
        return false;
    L7:
        return !hu5.a.d(this.f241832f.get(r100));
    }

    public final boolean v(String r100) {
        if (x(r100) == true) goto L5;
        tt5.a.k("Wiki_Workspaces", "Workspaces.getNodeType, invalid params. ");
        int r101 = -1;
    L7:
        if (r101 != WikNodeType.LEAF.getValue()) goto L9;
    L14:
        return true;
    L9:
        if (TextUtils.equals(r100, this.f241828b) == true) goto L14;
        if (q(r100) == true) goto L14;
        return false;
    L5:
        r101 = ((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).getNodeType();
        goto L7
    }

    public final boolean x(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f241833g.get(r100) == null) goto L7;
        return true;
    }

    public final boolean y(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r101 = this.f241834h.get(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (x(r101.f241734c) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public e3(f3 r100, ce5.a r101) {
        ConcurrentHashMap r102 = new ConcurrentHashMap();
        this.f241832f = r102;
        ConcurrentHashMap r103 = new ConcurrentHashMap();
        this.f241833g = r103;
        this.f241834h = new ConcurrentHashMap();
        this.f241835i = new ConcurrentHashMap();
        this.f241838l = new SpacePerm();
        this.f241843q = null;
        this.f241828b = r100.f241860a;
        this.f241827a = r100.f241861b;
        this.f241829c = r100.f241862c;
        this.f241830d = r100.f241863d;
        this.f241831e = r100.f241864e;
        r103.putAll(r100.f241866g);
        this.f241843q = r101.f23452g.n1();
        if (qc5.a.g(r101) == false) goto L22;
        Map<String, List<String>> r104 = r100.f241865f;
        ConcurrentHashMap r105 = new ConcurrentHashMap();
        if (r104 == null) goto L21;
        Iterator<Map.Entry<String, List<String>>> r106 = r104.entrySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L21;
        Map.Entry<String, List<String>> r107 = r106.next();
        if (r107 == null) goto L9;
        List<String> r108 = r107.getValue();
        if (r108 == null) goto L9;
        ArrayList r109 = new ArrayList();
        Iterator<String> r110 = r108.iterator();
    L18:
        if (r110.hasNext() == false) goto L20;
        r109.add(r110.next());
        goto L18
    L20:
        r105.put(r107.getKey(), r109);
    L21:
        r102.putAll(r105);
    L23:
        this.f241836j = r100.f241867h;
        this.f241837k = r100.f241868i;
        this.f241838l = r100.f241869j;
        this.f241842p = r100.f241870k;
        Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> r111 = r100.f241871l;
        if (r111 == null) goto L26;
        ((ConcurrentHashMap) this.f241834h).putAll(r111);
    L26:
        Map<String, List<String>> r112 = r100.f241872m;
        if (r112 == null) goto L38;
        ((ConcurrentHashMap) this.f241835i).putAll(r112);
        return;
    L38:
        return;
    L22:
        r102.putAll(r100.f241865f);
        goto L23
    }

    public final void B(String r100, List<TreeNode> r101) {
        if (x(r100) == true) goto L5;
    L25:
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeSingleNode, invalid wikiToken. ");
        return;
    L5:
        if (x(((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).parent_wiki_token) == false) goto L25;
        String r102 = ((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).parent_wiki_token;
        if (q(r102) == true) goto L11;
        tt5.a.k("Wiki_Workspaces", "Workspaces.removeSingleNode, destParent type: dir, no children cache. ");
        return;
    L11:
        ((List) ((ConcurrentHashMap) this.f241832f).get(r102)).remove(r100);
        Map<String, List<String>> r103 = this.f241832f;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        List r105 = (List) r104.get(this.f241827a);
        if (r105 != null) goto L14;
    L16:
        ((ConcurrentHashMap) this.f241832f).remove(r100);
        ((ConcurrentHashMap) this.f241833g).remove(r100);
        if (r101 == null) goto L23;
        ArrayList r106 = new ArrayList();
        Iterator<TreeNode> r107 = r101.iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        TreeNode r108 = r107.next();
        Map<String, TreeNode> r109 = this.f241833g;
        ConcurrentHashMap r110 = (ConcurrentHashMap) r109;
        r110.put(r108.wiki_token, r108);
        r106.add(r108.wiki_token);
        goto L20
    L22:
        ((ConcurrentHashMap) this.f241832f).put(r102, r106);
    L23:
        a(r102);
        return;
    L14:
        if (r105.contains(r100) == false) goto L16;
        K(r100);
        goto L16
    }

    public final void F(String r100, boolean r101) {
        if (x(r100) == false) goto L17;
        TreeNode r102 = this.f241833g.get(r100);
        Triple<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a, String> r103 = E(r100);
        if (r103 == null) goto L18;
        String r104 = r103.getSecond().f241732a;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r105 = this.f241834h.get(r104);
        if (r105 == null) goto L19;
        if (r101 == true) goto L10;
    L14:
        boolean r106 = false;
    L15:
        r105.f241735d = r106;
        return;
    L10:
        if (q(r102.getOriginToken()) == false) goto L12;
    L13:
        r106 = true;
        goto L15
    L12:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.c(r102.wiki_node_type) == false) goto L14;
    L19:
        return;
    L18:
        return;
    }

    public final void G(String r100, boolean r101) {
        Iterator<TreeNode> r102 = this.f241833g.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        TreeNode r103 = r102.next();
        if (TextUtils.equals(r103.getOriginToken(), r100) == false) goto L4;
        r103.is_explorer_star = r101;
        goto L4
    }

    public final void H(String r100, boolean r101) {
        Iterator<TreeNode> r102 = this.f241833g.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        TreeNode r103 = r102.next();
        if (TextUtils.equals(r103.getOriginToken(), r100) == false) goto L4;
        r103.is_explorer_pin = r101;
        goto L4
    }

    public final int J(String r100, double r101) {
        if (x(r100) == true) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (q(r100) == false) goto L18;
        Iterator<String> r102 = this.f241832f.get(r100).iterator();
        int r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L13;
        String r104 = r102.next();
        if (Double.compare(r101, this.f241833g.get(r104).sort_id) <= 0) goto L13;
        r103 = r103 + 1;
    L13:
        return r103;
    L18:
        return Integer.MAX_VALUE;
    }

    public final void M(String r100, String r101) {
        if (x(r100) == true) goto L6;
        tt5.a.k("Wiki_Workspaces", "Workspaces.updateSpaceId, invalid params. ");
        return;
    L6:
        ArrayList r102 = new ArrayList();
        f(r100, r102, 0);
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        TreeNode r105 = (TreeNode) ((ConcurrentHashMap) this.f241833g).get(r104);
        if (r105 == null) goto L8;
        r105.space_id = r101;
        r105.perm = null;
        goto L8
    }

    public final String p(String r100, String r101) {
        List<String> r102 = this.f241835i.get(r100);
        if (hu5.a.d(r102) == true) goto L12;
        Iterator<String> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r105 = this.f241834h.get(r104);
        if (r105 == null) goto L6;
        if (TextUtils.equals(r105.f241733b, r101) == false) goto L6;
        return r104;
    L20:
        return "";
    L12:
        return "";
    }

    public final void s(String r100, List<TreeNode> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.size() <= 0) goto L6;
        double r102 = ((TreeNode) ListProtector.get(r101, 0)).sort_id;
    L7:
        r(r100, J(r100, r102), r101);
        return;
    L6:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L7
    }

    public final boolean t(String r100, String r101) {
        if (x(r101) == true) goto L5;
    L13:
        return false;
    L5:
        if (x(r100) == false) goto L13;
        TreeNode r102 = (TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100);
    L8:
        if (r102 == null) goto L13;
        if (TextUtils.equals(r102.wiki_token, r101) == true) goto L11;
        Map<String, TreeNode> r103 = this.f241833g;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r102 = (TreeNode) r104.get(r102.parent_wiki_token);
        goto L8
    L11:
        return true;
    }

    public e3(WikiRelation r110, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r111, ce5.a r210) {
        WikiRelation.Tree r100 = r110.tree;
        this(new f3(r100.root_token, r100.favorite_root_token, r100.shared_root_token, r100.pinedRootToken, r100.spaceRootToken, r100.child_map, r100.nodes, r110.f241731space, r110.user_space_perm, r110.space_perm, r110.fromCache, r111.f241740a, r111.f241741b), r210);
    }

    public final void D(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        F(r100, r102);
        return;
    L5:
        if (y(r101) == false) goto L19;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r103 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) this.f241834h).get(r101);
        Map<String, TreeNode> r104 = this.f241833g;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        TreeNode r106 = (TreeNode) r105.get(r103.f241734c);
        if (r102 == true) goto L9;
    L11:
        boolean r107 = false;
    L12:
        r103.f241735d = r107;
        String r108 = r103.f241733b;
    L14:
        if (y(r108) == false) goto L20;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r109 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) this.f241834h).get(r108);
        r109.f241735d = true;
        r108 = r109.f241733b;
        goto L14
    L20:
        return;
    L9:
        if (q(r106.getOriginToken()) == false) goto L11;
        r107 = true;
        goto L12
    }

    public final void L(String r100, TreeNode r101, String r102) {
        if (x(r100) == true) goto L6;
        tt5.a.k("Wiki_Workspaces", "Wiki_Workspaces.updateNodeToken, invalid params. ");
        return;
    L6:
        if (r101 != null) goto L10;
        tt5.a.h("Wiki_Workspaces", "Wiki_Workspaces.updateNodeToken, empty childs. ");
        return;
    L10:
        if (((ConcurrentHashMap) this.f241833g).containsKey(r102) == false) goto L12;
        ((ConcurrentHashMap) this.f241833g).remove(r102);
        ((ConcurrentHashMap) this.f241832f).remove(r102);
    L12:
        Map<String, TreeNode> r103 = this.f241833g;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(r101.wiki_token) == true) goto L15;
        Map<String, TreeNode> r105 = this.f241833g;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(r101.wiki_token, r101);
    L15:
        List<String> r107 = j(r100);
        r107.remove(r102);
        ArrayList r108 = new ArrayList();
        r108.add(r101.wiki_token);
        r108.removeAll(r107);
        int r109 = J(r100, r101.sort_id);
        int r110 = r107.size();
        int r111 = up5.h.f551055a;
        if (r110 >= 0) goto L18;
        int r112 = -1;
    L19:
        r107.addAll(r112, r108);
        a(r100);
        return;
    L18:
        r112 = Math.min(Math.max(r109, 0), r110);
        goto L19
    }

    public final void f(String r100, List<String> r101, int r102) {
        if (r102 <= 30) goto L5;
        return;
    L5:
        ArrayList r103 = (ArrayList) r101;
        r103.add(((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).wiki_token);
        List r104 = (List) ((ConcurrentHashMap) this.f241832f).get(r100);
        if (hu5.a.d(r104) == true) goto L11;
        Iterator r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        f((String) r105.next(), r101, r102 + 1);
        goto L9
    L13:
        return;
    }

    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a n(String r100, String r101, String r102) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r103 = this.f241834h.get(r100);
        if (r103 != null) goto L8;
        r103 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a(r100, r101, r102);
        this.f241834h.put(r100, r103);
        List<String> r104 = this.f241835i.get(r102);
        if (r104 != null) goto L7;
        r104 = new ArrayList();
    L7:
        r104.add(r100);
        this.f241835i.put(r102, r104);
    L8:
        return r103;
    }

    public final void r(String r100, int r101, List<TreeNode> r102) {
        if (x(r100) == true) goto L7;
        tt5.a.k("Wiki_Workspaces", "Wiki_Workspaces.insertChildren, invalid params. ");
        return;
    L7:
        if (hu5.a.d(r102) == false) goto L10;
        tt5.a.h("Wiki_Workspaces", "Wiki_Workspaces.insertChildren, empty childs. ");
        return;
    L10:
        ArrayList r103 = new ArrayList();
        if (r102 == null) goto L22;
        Iterator<TreeNode> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L22;
        TreeNode r105 = r104.next();
        r103.add(r105.wiki_token);
        TreeNode r106 = this.f241833g.get(r105.wiki_token);
        if (r106 == null) goto L17;
        if (r105.isSortIdNativeGenerate() == true) goto L14;
        r106.sort_id = r105.sort_id;
        goto L14
    L17:
        this.f241833g.put(r105.wiki_token, r105);
    L22:
        if (hu5.a.d(r103) == true) goto L28;
        List<String> r107 = j(r100);
        r103.removeAll(r107);
        int r108 = r107.size();
        int r109 = up5.h.f551055a;
        if (r108 >= 0) goto L26;
        int r110 = -1;
    L27:
        r107.addAll(r110, r103);
        goto L28
    L26:
        r110 = Math.min(Math.max(r101, 0), r108);
    L28:
        a(r100);
    }

    public final void z(String r100, String r101, double r102, String r103) {
        if (x(r100) == true) goto L5;
    L22:
        tt5.a.k("Wiki_Workspaces", "Workspaces.moveNode, invalid params. ");
        return;
    L5:
        if (x(((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).parent_wiki_token) == false) goto L22;
        if (x(r101) == false) goto L22;
        String r104 = ((TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100)).parent_wiki_token;
        if (q(r104) == true) goto L13;
        tt5.a.k("Wiki_Workspaces", "Workspaces.moveNodes, destParent type: dir, no children cache. ");
        return;
    L13:
        ((List) ((ConcurrentHashMap) this.f241832f).get(r104)).remove(r100);
        a(r104);
        TreeNode r105 = (TreeNode) ((ConcurrentHashMap) this.f241833g).get(r100);
        if (r105 == null) goto L16;
        r105.parent_wiki_token = r101;
        r105.space_id = r103;
    L16:
        List<String> r106 = j(r101);
        int r107 = J(r101, r102);
        int r108 = r106.size();
        int r109 = up5.h.f551055a;
        if (r108 >= 0) goto L19;
        int r110 = -1;
    L20:
        ListProtector.add(r106, r110, r100);
        a(r101);
        return;
    L19:
        r110 = Math.min(Math.max(r107, 0), r108);
        goto L20
    }

    public final j h(TreeNode r100, String r101, int r102, String r103, String r104) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r105 = n(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r101, r100.wiki_token, r102, r103), r104, r100.wiki_token);
        r105.f241736e = r102;
        r105.f241739h = TextUtils.isEmpty(r103);
        List<Function<TreeNode, Boolean>> r106 = this.f241840n;
        boolean r107 = false;
        if (r106 == null) goto L13;
        Iterator<Function<TreeNode, Boolean>> r108 = r106.iterator();
    L6:
        if (r108.hasNext() == false) goto L13;
        if (r108.next().apply(r100).booleanValue() == true) goto L6;
        boolean r109 = false;
    L14:
        r105.f241737f = r109;
        List<Function<TreeNode, Boolean>> r110 = this.f241841o;
        if (r110 != null) goto L29;
    L24:
        r107 = true;
    L25:
        r105.f241738g = r107;
        return j.a(r100, r105);
    L29:
        Iterator<Function<TreeNode, Boolean>> r111 = r110.iterator();     // Catch: Exception -> L22
    L18:
        if (r111.hasNext() == false) goto L24;
        if (r111.next().apply(r100).booleanValue() == true) goto L18;
    L22:
        e = move-exception;
        tt5.a.e("Wiki_Workspaces", "enableSwipeChecker apply err. ", e, false);
    L11:
        e = move-exception;
        tt5.a.e("Wiki_Workspaces", "enableChecker apply err. ", e, false);
    L13:
        r109 = true;
        goto L14
    }

    public final void g(String r110, String r210, int r211, String r212, String r213, Set r214, List r215) {
        TreeNode r100 = (TreeNode) ((ConcurrentHashMap) this.f241833g).get(r210);
        if (r100 != null) goto L5;
        return;
    L5:
        Function<TreeNode, Boolean> r101 = this.f241839m;
        boolean r102 = false;
        if (r101 != null) goto L41;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L16;
        return;
    L16:
        if (r100.isShortcut() == false) goto L20;
        Map<String, TreeNode> r104 = this.f241833g;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        TreeNode r106 = (TreeNode) r105.get(r100.getOriginToken());
        if (r106 == null) goto L20;
        r100.has_child = r106.has_child;
    L20:
        j r107 = h(r100, r110, r211, r212, r213);
        ArrayList r111 = (ArrayList) r215;
        r111.add(r107);
        String r112 = r107.f241926n;
        String r113 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.b(r100.isShortcut(), r210, r212);
        String r114 = r100.getOriginToken();
        HashSet r108 = (HashSet) r214;
        if (r108.contains(r114) == false) goto L23;
        r107.f241923k = false;
        r107.f241929q = WikNodeType.LEAF.getValue();
        List r109 = null;
    L25:
        if (r107.f241929q != WikNodeType.LEAF.getValue()) goto L27;
        r102 = true;
    L27:
        if (r102 == false) goto L29;
        return;
    L29:
        if (r107.f241928p == false) goto L45;
        r108.add(r114);
        int r115 = r111.size();
        if (hu5.a.d(r109) == true) goto L36;
        Iterator r116 = r109.iterator();
    L34:
        if (r116.hasNext() == false) goto L36;
        g(r110, (String) r116.next(), r211 + 1, r113, r112, r214, r215);
        r108 = r108;
    L36:
        HashSet r117 = r108;
        if (r111.size() != r115) goto L39;
        r111.add(h(TreeNode.createNone(i.a(this), r210), r110, r211 + 1, r113, r112));
    L39:
        r117.remove(r114);
        return;
    L45:
        return;
    L23:
        r109 = (List) ((ConcurrentHashMap) this.f241832f).get(r114);
        goto L25
    L41:
        if (r101.apply(r100).booleanValue() == true) goto L12;
        r103 = true;
    L10:
        e = move-exception;
        tt5.a.e("Wiki_Workspaces", "dataFilter apply err. ", e, false);
        goto L12
    }
}
