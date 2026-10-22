package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.platform.model.SlashMentionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class ImProjectSource implements zb9.s<u0>, l {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f345271w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IProjectListDataSource f345272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f345273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f345275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.data.m f345276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zb9.t<u0> f345277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f345278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f345279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f345280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GroupSortPolicy f345281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f345282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f345283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Set<String> f345284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f345285n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScheduledFuture<?> f345286o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f345287p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f345288q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, Message> f345289r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f345290s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f345291t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f345292u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f345293v;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OmniProject f345294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<wc9.e> f345295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f345296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f345297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f345298e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f345299f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f345300g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f345301h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final OmniConversationSortType f345302i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final com.larus.home.impl.main.side_bar.view.group.render.n<com.larus.home.impl.main.side_bar.data.j0> f345303j;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f345294a, r101.f345294a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f345295b, r101.f345295b) == true) goto L15;
            return false;
        L15:
            if (this.f345296c == r101.f345296c) goto L18;
            return false;
        L18:
            if (this.f345297d == r101.f345297d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f345298e, r101.f345298e) == true) goto L24;
            return false;
        L24:
            if (this.f345299f == r101.f345299f) goto L27;
            return false;
        L27:
            if (this.f345300g == r101.f345300g) goto L30;
            return false;
        L30:
            if (this.f345301h == r101.f345301h) goto L33;
            return false;
        L33:
            if (this.f345302i == r101.f345302i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f345303j, r101.f345303j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f345294a.hashCode() * 31) + this.f345295b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f345296c == false) goto L5;
            int r102 = 1231;
        L6:
            long r103 = this.f345297d;
            int r104 = (((((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f345298e.hashCode()) * 31;
            if (this.f345299f == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r104 + r105) * 31;
            if (this.f345300g == true) goto L15;
            r101 = 1237;
        L15:
            return ((((((r106 + r101) * 31) + this.f345301h) * 31) + this.f345302i.hashCode()) * 31) + this.f345303j.hashCode();
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ProjectState(project=" + this.f345294a + ", loadedConversations=" + this.f345295b + ", hasMoreConversations=" + this.f345296c + ", nextCursor=" + this.f345297d + ", nextCursorId=" + this.f345298e + ", isLoadingMore=" + this.f345299f + ", hasLoadedMoreConversations=" + this.f345300g + ", visibleConversationTarget=" + this.f345301h + ", builtWithSortType=" + this.f345302i + ", conversationDisplayPolicy=" + this.f345303j + ')';
        }

        public final String a() {
            String r100 = this.f345294a.projectId;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        public b(OmniProject r100, List r101, boolean r102, long r103, String r104, int r105, OmniConversationSortType r110) {
            com.larus.home.impl.main.side_bar.view.group.render.m r106 = new com.larus.home.impl.main.side_bar.view.group.render.m();
            Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_PROJECT);
            Intrinsics.checkNotNullParameter(r101, "loadedConversations");
            Intrinsics.checkNotNullParameter(r104, "nextCursorId");
            Intrinsics.checkNotNullParameter(r110, "builtWithSortType");
            Intrinsics.checkNotNullParameter(r106, "conversationDisplayPolicy");
            this.f345294a = r100;
            this.f345295b = r101;
            this.f345296c = r102;
            this.f345297d = r103;
            this.f345298e = r104;
            this.f345299f = false;
            this.f345300g = false;
            this.f345301h = r105;
            this.f345302i = r110;
            this.f345303j = r106;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345304a = null;

        static {
            int[] r100 = new int[GroupSortPolicy.values().length];
            r100[GroupSortPolicy.CreateTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f345304a = r100;
        }
    }

    static {
    }

    public final OmniConversationSortType j() {
        GroupSortPolicy r100 = this.f345281j;
        if (c.f345304a[r100.ordinal()] != 1) goto L6;
        return OmniConversationSortType.OmniConversationSortType_CREATE_TIME;
    L6:
        return OmniConversationSortType.OmniConversationSortType_UPDATE_TIME;
    }

    public final void k() {
        zb9.t<u0> r100 = this.f345277f;
        List<b> r101 = this.f345282k;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(d0.c(s((b) r103.next())));
        goto L4
    L6:
        r100.b(new zb9.k(r102, this.f345288q, null));
    }

    public final void l() {
        if (this.f345291t == true) goto L5;
        this.f345291t = true;
        int r100 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("project_window_start", t() + " target=" + this.f345290s + " projects=" + ((ArrayList) this.f345282k).size());
        BuildersKt.launch$default(this.f345275d, null, null, new ImProjectSource$launchEnsureProjectWindow$1(this, null), 3, null);
        return;
    L5:
        if (this.f345292u == true) goto L7;
        int r101 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("project_window_defer", t() + " target=" + this.f345290s + " projects=" + ((ArrayList) this.f345282k).size());
    L7:
        this.f345292u = true;
    }

    public final void r() {
        Object r100 = this.f345285n;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f345286o == null) goto L8;
        monitor-exit(r100);
        return;
    L8:
        this.f345286o = ((ScheduledExecutorService) this.f345287p.getValue()).schedule(new w(this), 300, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
    }

    public final String t() {
        return "projectSource=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this);
    }

    @Override // zb9.s
    public final GroupSortPolicy e() {
        return this.f345281j;
    }

    @Override // zb9.s
    public final void a(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (this.f345288q == true) goto L5;
        return;
    L5:
        this.f345290s = d0.b(this.f345290s, RangesKt.coerceAtLeast(r100.f571193a, 1));
        l();
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.l
    public final void c(List<wc9.e> r210) {
        Intrinsics.checkNotNullParameter(r210, CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED);
        if (r210.isEmpty() == false) goto L5;
        return;
    L5:
        List<wc9.e> r100 = r210;
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L19;
        String r103 = ((wc9.e) r102.next()).I;
        if (r103 != null) goto L11;
    L16:
        String r104 = null;
    L17:
        if (r104 == null) goto L7;
        r101.add(r104);
        goto L7
    L11:
        if (r103.length() <= 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r104 = r103;
        goto L17
    L13:
        r105 = false;
        goto L14
    L19:
        LinkedHashSet r106 = new LinkedHashSet();
        Iterator<T> r107 = r100.iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        r106.add(((wc9.e) r107.next()).f559198a);
        goto L21
    L23:
        List<b> r108 = this.f345282k;
        LinkedHashSet r109 = new LinkedHashSet();
        Iterator r110 = ((ArrayList) r108).iterator();
    L25:
        if (r110.hasNext() == false) goto L50;
        b r111 = (b) r110.next();
        boolean r112 = r101.contains(r111.a());
        List<wc9.e> r113 = r111.f345295b;
        if ((r113 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r114 = r113.iterator();
    L33:
        if (r114.hasNext() == false) goto L37;
        if (r106.contains(((wc9.e) r114.next()).f559198a) == false) goto L33;
        boolean r115 = true;
    L38:
        String r116 = r111.a();
        if (r112 == true) goto L43;
        if (r115 == true) goto L43;
        boolean r117 = false;
    L44:
        if (r117 == true) goto L47;
        r116 = null;
    L47:
        if (r116 == null) goto L25;
        r109.add(r116);
    L43:
        r117 = true;
    L37:
        r115 = false;
        goto L38
    L29:
        if (r113.isEmpty() == false) goto L31;
    L50:
        if (r109.isEmpty() == false) goto L52;
        return;
    L52:
        LinkedHashSet r118 = new LinkedHashSet();
        Iterator r119 = r109.iterator();
    L54:
        if (r119.hasNext() == false) goto L153;
        Object r120 = r119.next();
        String r121 = (String) r120;
        Iterator r122 = ((ArrayList) this.f345282k).iterator();
    L57:
        if (r122.hasNext() == false) goto L61;
        Object r123 = r122.next();
        if (Intrinsics.areEqual(((b) r123).a(), r121) == false) goto L57;
    L62:
        b r124 = (b) r123;
        if (r124 != null) goto L66;
    L150:
        boolean r125 = false;
    L151:
        if (r125 == false) goto L54;
        r118.add(r120);
        goto L54
    L66:
        if (com.larus.home.impl.main.side_bar.p.b().c() == true) goto L69;
    L133:
        boolean r126 = false;
    L148:
        if (r126 == true) goto L150;
        r125 = true;
        goto L151
    L69:
        if (r124.f345295b.isEmpty() == true) goto L133;
        ArrayList r127 = new ArrayList();
        Iterator<T> r128 = r100.iterator();
    L73:
        if (r128.hasNext() == false) goto L95;
        Object r129 = r128.next();
        wc9.e r130 = (wc9.e) r129;
        if (p(r124, r130) == true) goto L91;
        List<wc9.e> r131 = r124.f345295b;
        if ((r131 instanceof Collection) == true) goto L79;
    L81:
        Iterator<T> r132 = r131.iterator();
    L83:
        if (r132.hasNext() == false) goto L87;
        if (Intrinsics.areEqual(((wc9.e) r132.next()).f559198a, r130.f559198a) == false) goto L83;
        boolean r133 = true;
    L88:
        if (r133 == true) goto L91;
        boolean r134 = false;
    L92:
        if (r134 == false) goto L73;
        r127.add(r129);
    L87:
        r133 = false;
        goto L88
    L79:
        if (r131.isEmpty() == false) goto L81;
    L91:
        r134 = true;
        goto L92
    L95:
        if (r127.isEmpty() == true) goto L147;
        List<wc9.e> r135 = CollectionsKt.toMutableList(r124.f345295b);
        Iterator r136 = r127.iterator();
        boolean r137 = false;
    L99:
        if (r136.hasNext() == false) goto L141;
        wc9.e r138 = (wc9.e) r136.next();
        Iterator<wc9.e> r139 = r135.iterator();
        int r140 = 0;
    L102:
        if (r139.hasNext() == false) goto L107;
        if (Intrinsics.areEqual(r139.next().f559198a, r138.f559198a) == true) goto L108;
        r140 = r140 + 1;
    L108:
        boolean r141 = p(r124, r138);
        if (r140 < 0) goto L112;
        if (r141 == true) goto L112;
        ListProtector.remove(r135, r140);
    L112:
        if (r140 >= 0) goto L114;
        if (r141 == false) goto L99;
        OmniConversationSortType r142 = j();
        wc9.e r143 = (wc9.e) CollectionsKt.lastOrNull(r135);
        if (r143 == null) goto L132;
    L134:
        if (r143 == null) goto L139;
        if (p.b(r138, r142) >= p.b(r143, r142)) goto L139;
        if (r124.f345296c == true) goto L99;
    L139:
        d0.a(r135, r138, r142);
        this.f345283l.add(r138.f559198a);
    L140:
        r137 = true;
        goto L99
    L132:
        if (r124.f345296c == false) goto L134;
    L114:
        if (Intrinsics.areEqual(((wc9.e) ListProtector.get(r135, r140)).f559211n, r138.f559211n) == false) goto L124;
        String r144 = r138.f559198a;
        Message r145 = (Message) ((LinkedHashMap) this.f345289r).get(r144);
        if (r145 != null) goto L120;
        j0.f345353a.getClass();
        Intrinsics.checkNotNullParameter(r144, "conversationId");
        r145 = j0.f345354b.get(r144);
        if (r145 != null) goto L120;
        boolean r146 = false;
    L121:
        if (r146 == true) goto L124;
        boolean r147 = false;
    L125:
        ListProtector.remove(r135, r140);
        d0.a(r135, r138, j());
        if (r147 == false) goto L99;
        this.f345283l.add(r138.f559198a);
    L120:
        r146 = d0.f345337a.contains(Integer.valueOf(r145.getMessageStatusLocal()));
    L124:
        r147 = true;
        goto L125
    L107:
        r140 = -1;
        goto L108
    L141:
        Intrinsics.checkNotNullParameter(r135, "<set-?>");
        r124.f345295b = r135;
        o(r124);
        int r148 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("project_mutation", t() + " project=" + com.larus.home.impl.main.side_bar.feed.arch.t.d(r124.a()) + " changes=" + r127.size() + " loaded=" + r135.size() + " visible=" + ((ArrayList) u(r124)).size() + " target=" + r124.f345301h + " hasMore=" + r124.f345296c + " briefRefresh=" + r137);
        if (r137 == false) goto L147;
        Set r149 = CollectionsKt.toSet(this.f345283l);
        this.f345283l.clear();
        if (r149.isEmpty() == true) goto L147;
        BuildersKt.launch$default(this.f345275d, null, null, new ImProjectSource$launchProjectBriefRefresh$1(this, r149, null), 3, null);
    L147:
        r126 = true;
        goto L148
    L61:
        r123 = null;
        goto L62
    L153:
        ArrayList r150 = new ArrayList();
        Iterator r151 = r109.iterator();
    L155:
        if (r151.hasNext() == false) goto L186;
        String r152 = (String) r151.next();
        Iterator r153 = ((ArrayList) this.f345282k).iterator();
    L158:
        if (r153.hasNext() == false) goto L162;
        Object r154 = r153.next();
        if (Intrinsics.areEqual(((b) r154).a(), r152) == false) goto L158;
    L163:
        b r155 = (b) r154;
        if (r155 != null) goto L167;
    L183:
        Pair r156 = null;
    L184:
        if (r156 == null) goto L155;
        r150.add(r156);
        goto L155
    L167:
        if (((ArrayList) u(r155)).size() < r155.f345301h) goto L169;
    L171:
        boolean r157 = false;
    L173:
        if (r118.contains(r152) == true) goto L177;
        if (r157 == true) goto L177;
        boolean r158 = false;
    L178:
        if (r158 == true) goto L181;
        r152 = null;
    L181:
        if (r152 == null) goto L183;
        r156 = TuplesKt.to(r152, Integer.valueOf(r155.f345301h));
    L177:
        r158 = true;
        goto L178
    L169:
        if (r155.f345296c == false) goto L171;
        r157 = true;
        goto L173
    L162:
        r154 = null;
        goto L163
    L186:
        Map<String, Integer> r159 = MapsKt.toMap(r150);
        if (r159.isEmpty() == false) goto L190;
        r();
        return;
    L190:
        m(r159, "conversation_change");
    }

    @Override // zb9.s
    public final void d(zb9.u<u0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345277f.a(r100);
        if (this.f345280i == true) goto L9;
        this.f345280i = true;
        IProjectListDataSource r101 = this.f345272a;
        if (r101 == null) goto L7;
        r101.c(this.f345278g);
    L7:
        this.f345276e.e(this.f345279h);
        CopyOnWriteArraySet<l> r102 = ImChangeNotifier.f345232a;
        ImChangeNotifier.b(this);
        return;
    }

    @Override // zb9.s
    public final void f(zb9.u<u0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345277f.d(r100);
        if (this.f345277f.f571200a.isEmpty() == true) goto L5;
        return;
    L5:
        this.f345280i = false;
        IProjectListDataSource r101 = this.f345272a;
        if (r101 == null) goto L8;
        r101.b(this.f345278g);
    L8:
        this.f345276e.g(this.f345279h);
        CopyOnWriteArraySet<l> r102 = ImChangeNotifier.f345232a;
        ImChangeNotifier.c(this);
    }

    @Override // zb9.s
    public final void g(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f345276e.c();
        ((ArrayList) this.f345282k).clear();
        this.f345288q = false;
        int r101 = r100.f571193a;
        int r102 = Integer.MAX_VALUE;
        if (r101 == Integer.MAX_VALUE) goto L6;
        r102 = RangesKt.coerceAtLeast(r101 - 1, 1);
    L6:
        this.f345290s = r102;
        IProjectListDataSource r103 = this.f345272a;
        if (r103 == null) goto L9;
        r103.e(j());
    L9:
        l();
    }

    @Override // zb9.s
    public final void h(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f345281j != r100) goto L5;
        return;
    L5:
        this.f345281j = r100;
        IProjectListDataSource r101 = this.f345272a;
        if (r101 == null) goto L9;
        r101.e(j());
        return;
    }

    public final void o(b r100) {
        List<wc9.e> r101 = r100.f345295b;
        int r102 = 0;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        if ((!this.f345284m.contains(((wc9.e) r103.next()).f559198a)) == false) goto L9;
        r102 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L16:
        if (r102 <= (r100.f345301h + 1)) goto L26;
        r100.f345296c = true;
        return;
    L26:
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public final void q(com.larus.bmhome.taskskill.service.i r210) {
        int r100 = ((ArrayList) this.f345282k).size();
        boolean r101 = this.f345288q;
        int r102 = 1;
        List r103 = CollectionsKt.take(r210.f314449a, d0.b(this.f345290s, 1));
        Iterator r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        com.larus.bmhome.taskskill.service.h r105 = (com.larus.bmhome.taskskill.service.h) r104.next();
        this.f345289r.putAll(r105.f314447c);
        j0 r106 = j0.f345353a;
        Map<String, Message> r107 = r105.f314447c;
        r106.getClass();
        j0.a(r107);
        goto L4
    L6:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r103.iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        CollectionsKt.addAll(r108, ((com.larus.bmhome.taskskill.service.h) r109.next()).f314446b);
        goto L8
    L10:
        List<b> r110 = this.f345282k;
        LinkedHashMap r111 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r110, 10)), 16));
        Iterator r112 = ((ArrayList) r110).iterator();
    L12:
        if (r112.hasNext() == false) goto L14;
        Object r113 = r112.next();
        r111.put(((b) r113).a(), r113);
        goto L12
    L14:
        OmniConversationSortType r114 = j();
        LinkedHashSet r115 = new LinkedHashSet();
        ((ArrayList) this.f345282k).clear();
        List<b> r116 = this.f345282k;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r118 = r103.iterator();
    L16:
        if (r118.hasNext() == false) goto L58;
        com.larus.bmhome.taskskill.service.h r119 = (com.larus.bmhome.taskskill.service.h) r118.next();
        String r120 = r119.f314445a.projectId;
        if (r120 != null) goto L20;
        r120 = "";
    L20:
        b r121 = (b) r111.get(r120);
        if (r121 != null) goto L23;
    L25:
        r115.add(r120);
        OmniProject r122 = r119.f314445a;
        List<wc9.e> r123 = r119.f314446b;
        boolean r124 = r119.f314448d;
        int r125 = RangesKt.coerceAtLeast(this.f345274c.f345736a, r102);
        int r126 = Integer.MAX_VALUE;
        if (r125 != Integer.MAX_VALUE) goto L28;
        int r127 = 0;
    L29:
        if (r125 == Integer.MAX_VALUE) goto L32;
        r126 = r125 + r127;
    L32:
        List r128 = CollectionsKt.take(r123, r126);
        HashSet r129 = new HashSet();
        ArrayList r130 = new ArrayList();
        Iterator r131 = r128.iterator();
    L34:
        if (r131.hasNext() == false) goto L39;
        int r132 = r125;
        Object r133 = r131.next();
        Iterator r211 = r131;
        if (r129.add(((wc9.e) r133).f559198a) == false) goto L38;
        r130.add(r133);
    L38:
        r125 = r132;
        r131 = r211;
        goto L34
    L39:
        int r134 = r125;
        if (r124 == false) goto L42;
    L45:
        boolean r135 = true;
    L46:
        OmniConversationSortType r136 = j();
        wc9.e r137 = (wc9.e) CollectionsKt.minWithOrNull(r130, new c0(new b0(r136)));
        if (r137 == null) goto L49;
        long r138 = p.b(r137, r136);
    L50:
        if (r137 == null) goto L52;
        String r139 = r137.f559198a;
    L53:
        if (r139 != null) goto L55;
        String r212 = "";
    L56:
        r121 = new b(r122, r130, r135, r138, r212, r134, r136);
        r121.f345303j.b(r134);
    L57:
        r117.add(r121);
        r118 = r118;
        r114 = r114;
        r111 = r111;
        r102 = 1;
        goto L16
    L55:
        r212 = r139;
        goto L56
    L52:
        r139 = null;
        goto L53
    L49:
        r138 = Long.MAX_VALUE;
        goto L50
    L42:
        if (r123.size() > r126) goto L45;
        r135 = false;
        goto L46
    L28:
        r127 = 1;
        goto L29
    L23:
        if (r121.f345302i != r114) goto L25;
        OmniProject r140 = r119.f314445a;
        Intrinsics.checkNotNullParameter(r140, "<set-?>");
        r121.f345294a = r140;
        goto L57
    L58:
        CollectionsKt.addAll(r116, r117);
        if (r210.f314450b == false) goto L61;
    L64:
        boolean r141 = true;
    L65:
        this.f345288q = r141;
        k();
        if (this.f345293v == true) goto L68;
    L71:
        this.f345293v = true;
        int r142 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("project_window_result", t() + " target=" + this.f345290s + " shared=" + r210.f314449a.size() + " visible=" + r100 + "->" + ((ArrayList) this.f345282k).size() + " hasMore=" + r101 + "->" + this.f345288q + " initialized=" + r210.f314451c);
    L72:
        List<b> r143 = this.f345282k;
        ArrayList r144 = new ArrayList();
        Iterator r145 = ((ArrayList) r143).iterator();
    L74:
        if (r145.hasNext() == false) goto L92;
        b r146 = (b) r145.next();
        if (r115.contains(r146.a()) == true) goto L78;
    L82:
        boolean r147 = false;
    L83:
        String r148 = r146.a();
        if (r147 == true) goto L87;
        r148 = null;
    L87:
        if (r148 == null) goto L89;
        Pair r149 = TuplesKt.to(r148, Integer.valueOf(r146.f345301h));
    L90:
        if (r149 == null) goto L74;
        r144.add(r149);
        goto L74
    L89:
        r149 = null;
        goto L90
    L78:
        if (((ArrayList) u(r146)).size() >= r146.f345301h) goto L82;
        if (r146.f345296c == false) goto L82;
        r147 = true;
        goto L83
    L92:
        m(MapsKt.toMap(r144), "initial_window");
        if ((!r108.isEmpty()) == false) goto L110;
        BuildersKt.launch$default(this.f345275d, null, null, new ImProjectSource$reconcileProjectSnapshot$3(r108, this, null), 3, null);
        return;
    L110:
        return;
    L68:
        if (r100 != ((ArrayList) this.f345282k).size()) goto L71;
        if (r101 == this.f345288q) goto L72;
    L61:
        if (r210.f314449a.size() > this.f345290s) goto L64;
        r141 = false;
        goto L65
    }

    public final u0 s(b r100) {
        return new u0(r100.f345294a, u(r100), this.f345276e.d(r100.a()), r100.f345296c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v3 java.util.List<zb9.i<com.larus.home.impl.main.side_bar.data.j0>>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final java.util.List<com.larus.home.impl.main.side_bar.data.j0> u(com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource.b r29) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v3 java.util.List<zb9.i<com.larus.home.impl.main.side_bar.data.j0>>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource.u(com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource$b):java.util.List");
    }

    public static boolean p(b r100, wc9.e r101) {
        Integer r102 = r101.f559217t;
        boolean r103 = false;
        if (r102 != null) goto L6;
    L7:
        return false;
    L6:
        if (r102.intValue() != 1) goto L7;
        if (ic8.n.r(r101) == false) goto L11;
        return false;
    L11:
        Integer r104 = r101.f559202e;
        if (r104 != null) goto L15;
    L17:
        String r105 = r101.I;
        if (r105 != null) goto L20;
    L24:
        r105 = null;
    L26:
        return Intrinsics.areEqual(r105, r100.a());
    L20:
        if (r105.length() <= 0) goto L22;
        r103 = true;
    L22:
        if (r103 == false) goto L24;
    L15:
        if (r104.intValue() != 1) goto L17;
        return false;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.l
    public final void b(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (com.larus.bmhome.chat.bean.d.D0((Message) ((LinkedHashMap) this.f345289r).get(r100), r101) == true) goto L5;
        return;
    L5:
        Iterator r102 = ((ArrayList) this.f345282k).iterator();
    L7:
        if (r102.hasNext() == false) goto L22;
        Object r103 = r102.next();
        List<wc9.e> r104 = ((b) r103).f345295b;
        if ((r104 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((wc9.e) r105.next()).f559198a, r100) == false) goto L15;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L7;
    L23:
        b r107 = (b) r103;
        if (r107 != null) goto L26;
        return;
    L26:
        this.f345289r.put(r100, r101);
        this.f345277f.c(d0.c(s(r107)));
        return;
    L19:
        r106 = false;
        goto L20
    L11:
        if (r104.isEmpty() == false) goto L13;
    L22:
        r103 = null;
        goto L23
    }

    public final void m(Map<String, Integer> r100, String r101) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f345275d, null, null, new ImProjectSource$launchProjectConversationReloads$1(r100, this, r101, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object n(String r110, Continuation<? super Unit> r210) {
        if ((r210 instanceof ImProjectSource$loadMoreConversations$1) == false) goto L7;
        ImProjectSource$loadMoreConversations$1 r100 = (ImProjectSource$loadMoreConversations$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L26;
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L18;
        t0 r104 = (t0) r100.L$1;
        b r105 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L15 CancellationException -> L81
        b r106 = r105;
    L65:
        List<wc9.e> r107 = r106.f345295b;     // Catch: Throwable -> L15 CancellationException -> L81
        LinkedHashSet r108 = new LinkedHashSet();     // Catch: Throwable -> L15 CancellationException -> L81
        Iterator<T> r109 = r107.iterator();     // Catch: Throwable -> L15 CancellationException -> L81
    L67:
        if (r109.hasNext() == false) goto L69;
        r108.add(((wc9.e) r109.next()).f559198a);     // Catch: Throwable -> L15 CancellationException -> L81
        goto L67
    L69:
        List<wc9.e> r112 = r104.f345389a;     // Catch: Throwable -> L15 CancellationException -> L81
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L15 CancellationException -> L81
        Iterator<T> r114 = r112.iterator();     // Catch: Throwable -> L15 CancellationException -> L81
    L71:
        if (r114.hasNext() == false) goto L76;
        Object r115 = r114.next();     // Catch: Throwable -> L15 CancellationException -> L81
        if (r108.contains(((wc9.e) r115).f559198a) == true) goto L71;
        r113.add(r115);     // Catch: Throwable -> L15 CancellationException -> L81
        goto L71
    L76:
        if (r113.isEmpty() == false) goto L78;
        r106.f345296c = false;     // Catch: Throwable -> L15 CancellationException -> L81
    L79:
        r106.f345299f = false;
        this.f345277f.c(d0.c(s(r106)));
        return Unit.INSTANCE;
    L78:
        List<wc9.e> r116 = CollectionsKt.plus(r106.f345295b, r113);     // Catch: Throwable -> L15 CancellationException -> L81
        Intrinsics.checkNotNullParameter(r116, "<set-?>");     // Catch: Throwable -> L15 CancellationException -> L81
        r106.f345295b = r116;     // Catch: Throwable -> L15 CancellationException -> L81
        r106.f345296c = r104.f345391c;     // Catch: Throwable -> L15 CancellationException -> L81
        r106.f345297d = r104.f345392d;     // Catch: Throwable -> L15 CancellationException -> L81
        String r117 = r104.f345393e;     // Catch: Throwable -> L15 CancellationException -> L81
        Intrinsics.checkNotNullParameter(r117, "<set-?>");     // Catch: Throwable -> L15 CancellationException -> L81
        r106.f345298e = r117;     // Catch: Throwable -> L15 CancellationException -> L81
    L81:
        e = move-exception;
        throw e;     // Catch: Throwable -> L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r118 = r100.I$0;
        b r119 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L22 CancellationException -> L24
        r119 = r119;
    L110:
        t0 r120 = (t0) r102;     // Catch: Throwable -> L22 CancellationException -> L83
        r119.f345300g = true;     // Catch: Throwable -> L22 CancellationException -> L83
        r119.f345303j.c(r118);     // Catch: Throwable -> L22 CancellationException -> L83
        r119.f345301h = d0.b(r119.f345301h, r118);     // Catch: Throwable -> L22 CancellationException -> L83
        this.f345289r.putAll(r120.f345390b);     // Catch: Throwable -> L22 CancellationException -> L83
        j0 r121 = j0.f345353a;     // Catch: Throwable -> L22 CancellationException -> L83
        Map<String, Message> r122 = r120.f345390b;     // Catch: Throwable -> L22 CancellationException -> L83
        r121.getClass();     // Catch: Throwable -> L22 CancellationException -> L83
        j0.a(r122);     // Catch: Throwable -> L22 CancellationException -> L83
        SideBarConversationBotCache r123 = SideBarConversationBotCache.f345314a;     // Catch: Throwable -> L22 CancellationException -> L83
        List<wc9.e> r124 = r120.f345389a;     // Catch: Throwable -> L22 CancellationException -> L83
        r100.L$0 = r119;     // Catch: Throwable -> L22 CancellationException -> L83
        r100.L$1 = r120;     // Catch: Throwable -> L22 CancellationException -> L83
        r100.label = 2;     // Catch: Throwable -> L22 CancellationException -> L83
        if (r123.a(r124, r100) != r111) goto L64;
        return r111;
    L64:
        r104 = r120;
        r106 = r119;
        goto L65
    L83:
        e = e;
        Object r125 = r119;
    L100:
        throw e;     // Catch: Throwable -> L15
    L22:
        th = th;
    L102:
        r119.f345299f = false;
        throw th;
    L24:
        e = move-exception;
        throw e;     // Catch: Throwable -> L15
    L26:
        ResultKt.throwOnFailure(r102);
        Iterator r126 = ((ArrayList) this.f345282k).iterator();
    L28:
        if (r126.hasNext() == false) goto L32;
        Object r127 = r126.next();
        if (Intrinsics.areEqual(((b) r127).a(), r110) == false) goto L28;
    L33:
        b r128 = (b) r127;
        if (r128 != null) goto L38;
        return Unit.INSTANCE;
    L38:
        if (r128.f345296c == false) goto L105;
        if (r128.f345299f == true) goto L105;
        r128.f345299f = true;
        com.larus.home.impl.main.side_bar.view.group.render.z r129 = this.f345274c;     // Catch: Throwable -> L94 CancellationException -> L97
        if (r128.f345300g == true) goto L46;
        boolean r130 = true;
    L114:
        if (r130 == false) goto L50;
        int r131 = r129.f345737b;     // Catch: Throwable -> L89 CancellationException -> L91
    L51:
        int r132 = RangesKt.coerceAtLeast(r131, 1);     // Catch: Throwable -> L94 CancellationException -> L97
        if (r132 != Integer.MAX_VALUE) goto L54;
        int r133 = 0;
    L55:
        v0 r134 = this.f345273b;     // Catch: Throwable -> L94 CancellationException -> L97
        long r135 = r128.f345297d;     // Catch: Throwable -> L94 CancellationException -> L97
        String r136 = r128.f345298e;     // Catch: Throwable -> L94 CancellationException -> L97
        int r137 = d0.b(r132, r133);     // Catch: Throwable -> L94 CancellationException -> L97
        OmniConversationSortType r138 = j();     // Catch: Throwable -> L94 CancellationException -> L97
        r100.L$0 = r128;     // Catch: Throwable -> L94 CancellationException -> L97
        r100.I$0 = r132;     // Catch: Throwable -> L94 CancellationException -> L97
        r100.label = 1;     // Catch: Throwable -> L94 CancellationException -> L97
        b r139 = r128;
        Object r140 = r134.a(r110, r135, r136, r137, r138, r100);     // Catch: Throwable -> L85 CancellationException -> L87
        if (r140 != r111) goto L60;
        return r111;
    L60:
        r119 = r139;
        r118 = r132;
        r102 = r140;
        goto L110
    L87:
        e = e;
    L93:
        r125 = r139;
    L85:
        th = th;
    L96:
        r119 = r139;
        goto L102
    L54:
        r133 = 1;
        goto L55
    L50:
        r131 = r129.f345738c;     // Catch: Throwable -> L89 CancellationException -> L91
    L91:
        e = e;
        r139 = r128;
    L89:
        th = th;
    L95:
        r139 = r128;
        goto L96
    L46:
        r130 = false;
    L97:
        e = e;
        r125 = r128;
    L94:
        th = th;
    L105:
        return Unit.INSTANCE;
    L32:
        r127 = null;
    L15:
        th = th;
        r119 = r100;
    L7:
        r100 = new ImProjectSource$loadMoreConversations$1(this, r210);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.home.impl.main.side_bar.view.group.datasource.im.x] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.home.impl.main.side_bar.view.group.datasource.im.y] */
    public ImProjectSource(IProjectListDataSource r100, com.larus.home.impl.main.side_bar.view.group.render.z r101, CoroutineScope r102, com.larus.home.impl.main.side_bar.data.m r103) {
        ImSdkSideBarProjectImService r104 = ImSdkSideBarProjectImService.f345306a;
        this.f345272a = r100;
        this.f345273b = r104;
        this.f345274c = r101;
        this.f345275d = r102;
        this.f345276e = r103;
        this.f345277f = new zb9.t();
        this.f345278g = new x(this);
        this.f345279h = new y(this);
        this.f345281j = GroupSortPolicy.UpdateTime;
        this.f345282k = new ArrayList();
        this.f345283l = new LinkedHashSet();
        this.f345284m = SetsKt.emptySet();
        this.f345285n = new Object();
        this.f345287p = LazyKt.lazy(new z());
        this.f345289r = new LinkedHashMap();
    }

    public static final Object i(ImProjectSource r210, String r211, int r212, String r213, Continuation r214) {
        r210.getClass();
        if ((r214 instanceof ImProjectSource$reloadProjectConversations$1) == false) goto L7;
        ImProjectSource$reloadProjectConversations$1 r100 = (ImProjectSource$reloadProjectConversations$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ImProjectSource$reloadProjectConversations$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        String r104 = " target=";
        String r105 = " visible=";
        String r106 = " loaded=";
        String r107 = " project=";
        String r108 = " reason=";
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        int r109 = r110.I$0;
        t0 r112 = (t0) r110.L$3;
        b r113 = (b) r110.L$2;
        String r114 = (String) r110.L$1;
        String r115 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        r107 = " project=";
        r106 = " loaded=";
        r105 = " visible=";
        r104 = " target=";
        b r116 = r113;
        r108 = " reason=";
    L48:
        List<wc9.e> r117 = r112.f345389a;
        HashSet r118 = new HashSet();
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r117.iterator();
    L50:
        if (r120.hasNext() == false) goto L54;
        Object r121 = r120.next();
        if (r118.add(((wc9.e) r121).f559198a) == false) goto L50;
        r119.add(r121);
        goto L50
    L54:
        r116.getClass();
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r116.f345295b = r119;
        r116.f345297d = r112.f345392d;
        String r122 = r112.f345393e;
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r116.f345298e = r122;
        if (r112.f345391c == false) goto L57;
        boolean r123 = true;
    L72:
        r116.f345296c = r123;
        int r124 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("project_refill_applied", r210.t() + r108 + r114 + r107 + com.larus.home.impl.main.side_bar.feed.arch.t.d(r115) + " received=" + r112.f345389a.size() + r106 + r119.size() + r105 + ((ArrayList) r210.u(r116)).size() + r104 + r109 + " pageHasMore=" + r112.f345391c + " hasMore=" + r116.f345296c);
        return Unit.INSTANCE;
    L57:
        if (r119.isEmpty() == false) goto L60;
        int r125 = 0;
    L59:
        r123 = true;
        if (r125 > r109) goto L72;
        r123 = false;
        goto L72
    L60:
        Iterator r126 = r119.iterator();
        r125 = 0;
    L62:
        if (r126.hasNext() == false) goto L59;
        if ((!r210.f345284m.contains(((wc9.e) r126.next()).f559198a)) == false) goto L62;
        r125 = r125 + 1;
        if (r125 >= 0) goto L62;
        CollectionsKt.throwCountOverflow();
        goto L62
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r127 = r110.I$0;
        b r128 = (b) r110.L$2;
        String r129 = (String) r110.L$1;
        String r130 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r131 = r102;
        String r132 = r129;
        int r133 = r127;
    L44:
        t0 r134 = (t0) r131;
        r210.f345289r.putAll(r134.f345390b);
        j0 r135 = j0.f345353a;
        Map<String, Message> r136 = r134.f345390b;
        r135.getClass();
        j0.a(r136);
        SideBarConversationBotCache r137 = SideBarConversationBotCache.f345314a;
        List<wc9.e> r138 = r134.f345389a;
        r110.L$0 = r130;
        r110.L$1 = r132;
        r110.L$2 = r128;
        r110.L$3 = r134;
        r110.I$0 = r133;
        r110.label = 2;
        if (r137.a(r138, r110) == r111) goto L95;
        r115 = r130;
        r114 = r132;
        r116 = r128;
        r112 = r134;
        r109 = r133;
        goto L48
    L95:
        return r111;
    L16:
        ResultKt.throwOnFailure(r102);
        Iterator r139 = ((ArrayList) r210.f345282k).iterator();
    L18:
        if (r139.hasNext() == false) goto L22;
        Object r140 = r139.next();
        if (Intrinsics.areEqual(((b) r140).a(), r211) == false) goto L18;
    L23:
        b r141 = (b) r140;
        if (r141 == null) goto L93;
        int r142 = Math.max(r212, RangesKt.coerceAtLeast(r210.f345274c.f345736a, 1));
        List<wc9.e> r143 = r141.f345295b;
        if ((r143 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r144 = r143.iterator();
        int r145 = 0;
    L33:
        if (r144.hasNext() == false) goto L40;
        if (r210.f345284m.contains(((wc9.e) r144.next()).f559198a) == false) goto L33;
        r145 = r145 + 1;
        if (r145 >= 0) goto L33;
        CollectionsKt.throwCountOverflow();
    L40:
        int r146 = d0.b(r142, r145);
        int r147 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("project_refill_request", r210.t() + " reason=" + r213 + " project=" + com.larus.home.impl.main.side_bar.feed.arch.t.d(r211) + " loaded=" + r141.f345295b.size() + " visible=" + ((ArrayList) r210.u(r141)).size() + " target=" + r142 + " pending=" + r145 + " limit=" + r146);
        v0 r148 = r210.f345273b;
        OmniConversationSortType r149 = r210.j();
        r110.L$0 = r211;
        r110.L$1 = r213;
        r110.L$2 = r141;
        r110.I$0 = r142;
        r110.label = 1;
        Object r150 = r148.a(r211, Long.MAX_VALUE, "", r146, r149, r110);
        if (r150 == r111) goto L94;
        r131 = r150;
        r132 = r213;
        r133 = r142;
        r128 = r141;
        r130 = r211;
        goto L44
    L94:
        return r111;
    L29:
        if (r143.isEmpty() == false) goto L31;
        r145 = 0;
        goto L40
    L93:
        return Unit.INSTANCE;
    L22:
        r140 = null;
    L7:
        r100 = new ImProjectSource$reloadProjectConversations$1(r210, r214);
        goto L8
    }
}
