package com.larus.home.impl.main.side_bar.view.group.render;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import com.larus.home.impl.main.side_bar.feed.arch.CardFeedSlot;
import com.larus.home.impl.main.side_bar.feed.arch.FlowFeedAdapter;
import com.larus.home.impl.main.side_bar.view.d2;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class g extends k0<com.larus.home.impl.main.side_bar.data.j0> {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f345618p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.v f345619q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.b f345620r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f345621s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<Unit> f345622t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j0 f345623u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CardFeedSlot f345624v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f345625w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FlowFeedAdapter f345626x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<com.larus.home.impl.main.side_bar.data.j0> f345627y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<com.larus.home.impl.main.side_bar.data.j0> f345628z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345629a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f345630b = null;

        static {
            int[] r100 = new int[GroupSortPolicy.values().length];
            r100[GroupSortPolicy.UpdateTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r100[GroupSortPolicy.CreateTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r100[GroupSortPolicy.PinTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f345629a = r100;
            int[] r101 = new int[SideBarItemType.values().length];
            r101[SideBarItemType.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r101[SideBarItemType.SHOW_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r101[SideBarItemType.HUMAN_FEED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[SideBarItemType.QUICK_ACCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f345630b = r101;
        }
    }

    static {
    }

    public g() {
        throw null;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final int D() {
        fb9.i r100 = (fb9.i) this.f345625w.getValue();
        if (r100 != null) goto L5;
        return -1;
    L5:
        eb9.n r101 = r100.n();
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r100.i(r101);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final long y() {
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.v r100 = this.f345619q;
        if (r100 != null) goto L5;
        return 0;
    L5:
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.a r101 = r100.f345454d;
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.c(r100.f345453c);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final List<fb9.a> z() {
        return CollectionsKt.listOfNotNull((fb9.i) this.f345625w.getValue());
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final boolean B() {
        if (super.B() == false) goto L7;
        return true;
    L7:
        if (this.f345619q != null) goto L9;
        return false;
    L9:
        fb9.i r100 = (fb9.i) this.f345625w.getValue();
        if (r100 == null) goto L16;
        eb9.n r101 = r100.n();
        if (r101 == null) goto L16;
        int r102 = qb9.a.f532418a;
        Intrinsics.checkNotNullParameter(r101, "selectionKey");
        return Intrinsics.areEqual(r101.f471903a, "side_bar_human_feed");
    L16:
        return false;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.o
    public final void v() {
        super.v();
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.v r100 = this.f345619q;
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.a r101 = r100.f345454d;
        if (r101 == null) goto L16;
        r101.a(this.f345622t);
    L16:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        r100.f345451a.c();     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        int r105 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.b("human_release_fail", "query_adapter=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this) + " section=" + this.f345618p, r104);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.o
    public final FlowFeedAdapter t() {
        return this.f345626x;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final boolean A(com.larus.home.impl.main.side_bar.data.i0 r100) {
        com.larus.home.impl.main.side_bar.data.j0 r101 = (com.larus.home.impl.main.side_bar.data.j0) r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (r101.f344506a != SideBarItemType.HUMAN_FEED) goto L10;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.v r102 = this.f345619q;
        if (r102 == null) goto L7;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.a r103 = r102.f345454d;
    L8:
        if (r103 == null) goto L10;
        return true;
    L7:
        r103 = null;
    L10:
        return false;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final void C(List<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f345628z = r100;
        E(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.home.impl.main.side_bar.feed.arch.CardFeedSlot] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void E(List<com.larus.home.impl.main.side_bar.data.j0> r210) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = r210.iterator();
    L3:
        int r102 = 0;
        boolean r103 = true;
        if (r101.hasNext() == false) goto L18;
        Object r104 = r101.next();
        wh8.a r105 = ((com.larus.home.impl.main.side_bar.data.j0) r104).f344507b;
        if (r105 == null) goto L10;
        wc9.e r106 = r105.f559708a;
        if (r106 == null) goto L10;
        String r107 = r106.f559198a;
    L11:
        if (r107 != null) goto L13;
    L15:
        if (r102 != 0) goto L3;
        r100.add(r104);
        goto L3
    L13:
        if (this.f345620r.dw(r107) == false) goto L15;
        r102 = 1;
    L10:
        r107 = null;
        goto L11
    L18:
        if (hasMore() == true) goto L20;
    L22:
        List<com.larus.home.impl.main.side_bar.data.j0> r108 = r100;
    L23:
        this.f345627y = r108;
        ?? r109 = this.f345624v;
        if (this.f345621s != null) goto L33;
        List<com.larus.home.impl.main.side_bar.data.j0> r110 = r108;
        ?? r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L27:
        if (r112.hasNext() == false) goto L59;
        Object r113 = r112.next();
        int r114 = r102 + 1;
        if (r102 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        r111.add(F((com.larus.home.impl.main.side_bar.data.j0) r113, r102));
        r102 = r114;
    L59:
        r109.b(r111);
        return;
    L33:
        if (r108.size() > r100.size()) goto L36;
        r103 = false;
    L36:
        h r115 = this.f345621s;
        if (r115 == null) goto L57;
        k r116 = r115.f345632a;
        if (r116 == null) goto L57;
        final GroupSortPolicy r117 = this.f345685a.e();
        List<Object> r118 = r116.insert(r100, ConversationGroupContent$renderWithDateHeaders$entries$1.INSTANCE, r117, new com.larus.home.impl.main.side_bar.view.group.render.b(this, r117));
        List r119 = CollectionsKt.createListBuilder();
        Iterator r120 = r118.iterator();
    L43:
        if (r120.hasNext() == false) goto L54;
        Object r121 = r120.next();
        int r122 = r102 + 1;
        if (r102 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        if ((r121 instanceof l) == false) goto L51;
        StringBuilder r123 = new StringBuilder();
        r123.append(this.f345618p);
        r123.append(':');
        l r124 = (l) r121;
        r123.append(r124.a());
        r119.add(new eb9.o(r123.toString(), tb9.b.f545288g, r121, null, false, 0, 0, r124.hashCode(), 120));
    L53:
        r102 = r122;
        goto L43
    L51:
        if ((r121 instanceof com.larus.home.impl.main.side_bar.data.j0) == false) goto L53;
        r119.add(F((com.larus.home.impl.main.side_bar.data.j0) r121, r102));
        goto L53
    L54:
        if (r103 == false) goto L56;
        r119.add(F(new com.larus.home.impl.main.side_bar.data.j0(SideBarItemType.SHOW_ALL, null, null, null, null, AppHost.f326268a.getApplication().getString(R.string.larus_sidebar_show_more), null, null, false, 0, 990), r118.size()));
    L56:
        List r125 = CollectionsKt.build(r119);
    L58:
        r111 = r125;
    L57:
        r125 = CollectionsKt.emptyList();
        goto L58
    L20:
        if (this.f345669k == true) goto L22;
        r108 = CollectionsKt.plus(r100, new com.larus.home.impl.main.side_bar.data.j0(SideBarItemType.SHOW_ALL, null, null, null, null, AppHost.f326268a.getApplication().getString(R.string.larus_sidebar_show_more), null, null, false, 0, 990));
        goto L23
    }

    public final eb9.o<com.larus.home.impl.main.side_bar.data.j0> F(com.larus.home.impl.main.side_bar.data.j0 r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        wh8.a r100 = r110.f344507b;
        Long r101 = null;
        if (r100 == null) goto L7;
        wc9.e r102 = r100.f559708a;
        if (r102 == null) goto L7;
        String r103 = r102.f559198a;
    L8:
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r104 = r110.f344513h;
        int r105 = 0;
        if (r104 == null) goto L18;
        String r106 = r104.f345406a;
        if (r106 == null) goto L18;
        if (r106.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
    L19:
        if (r103 != null) goto L21;
    L24:
        boolean r108 = true;
    L25:
        if (r108 == true) goto L29;
        d2 r109 = d2.f345076a;
        if (d2.a(r103) == null) goto L29;
        r105 = 1;
    L29:
        SideBarItemType r112 = r110.f344506a;
        int[] r113 = b.f345630b;
        int r114 = r113[r112.ordinal()];
        if (r114 == 1) goto L52;
        if (r114 == 2) goto L51;
        if (r114 != 3) goto L34;
        if (r106 == null) goto L50;
        String r115 = this.f345618p + ":human_feed:" + r106;
        if (r115 == null) goto L50;
    L57:
        int r116 = r113[r110.f344506a.ordinal()];
        if (r116 == 1) goto L67;
        if (r116 == 2) goto L66;
        if (r116 == 3) goto L65;
        if (r116 != 4) goto L64;
        SideBarFeedCardType r117 = tb9.h.f545317e;
    L68:
        SideBarFeedCardType r118 = r117;
        if (r103 == null) goto L71;
        int r119 = qb9.a.f532418a;
        Intrinsics.checkNotNullParameter(r103, "conversationId");
        eb9.n r120 = new eb9.n("side_bar_conversation", r103, null, null);
    L73:
        eb9.n r121 = r120;
    L75:
        boolean r122 = r110.f344514i;
        wh8.a r123 = r110.f344507b;
        if (r123 == null) goto L82;
        wc9.e r124 = r123.f559708a;
        if (r124 == null) goto L82;
        Long r125 = r124.f559201d;
        if (r125 == null) goto L82;
        long r126 = r125.longValue();
    L95:
        return new eb9.o(r115, r118, r110, r121, r122, r126, 0, (r110.hashCode() * 31) + r105);
    L82:
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r127 = r110.f344513h;
        if (r127 == null) goto L86;
        r126 = r127.a();
        goto L95
    L86:
        ll9.t r128 = r110.f344510e;
        if (r128 == null) goto L91;
        Long r129 = r128.f509783j;
        if (r129 == null) goto L91;
        r101 = Long.valueOf(r129.longValue() / 1000000);
    L91:
        if (r101 == null) goto L93;
        r126 = r101.longValue();
        goto L95
    L93:
        r126 = 0;
        goto L95
    L71:
        if (r106 == null) goto L74;
        int r130 = qb9.a.f532418a;
        Intrinsics.checkNotNullParameter(r106, "id");
        r120 = new eb9.n("side_bar_human_feed", r106, null, null);
        goto L73
    L74:
        r121 = null;
        goto L75
    L64:
        throw new IllegalStateException(("Unsupported query group item type=" + r110.f344506a).toString());
    L65:
        r117 = l0.f345680c;
        goto L68
    L66:
        r117 = tb9.i.f545324d;
        goto L68
    L67:
        r117 = tb9.a.f545279h;
    L50:
        String r131 = this.f345618p + ":human_feed_fallback:" + r111;
    L56:
        r115 = r131;
        goto L57
    L34:
        if (r114 == 4) goto L36;
        r131 = this.f345618p + ':' + r110.f344506a.name().toLowerCase(Locale.ROOT) + ':' + r111;
        goto L56
    L36:
        ll9.t r132 = r110.f344510e;
        StringBuilder r133 = new StringBuilder();
        r133.append(this.f345618p);
        r133.append(":quick_access:");
        if (r132 == null) goto L41;
        NodeType r134 = r132.f509774a;
        if (r134 == null) goto L41;
        Integer r135 = Integer.valueOf(r134.getValue());
    L42:
        r133.append(r135);
        r133.append(':');
        if (r132 == null) goto L45;
        String r136 = r132.f509775b;
    L46:
        r133.append(r136);
        r131 = r133.toString();
        goto L56
    L45:
        r136 = null;
    L41:
        r135 = null;
        goto L42
    L51:
        r131 = this.f345618p + ":show_all";
        goto L56
    L52:
        if (r103 == null) goto L55;
        r115 = this.f345618p + ":conversation:" + r103;
        if (r115 != null) goto L57;
    L55:
        r131 = this.f345618p + ":conversation_fallback:" + r111;
        goto L56
    L21:
        if (StringsKt.isBlank(r103) == true) goto L24;
        r108 = false;
        goto L25
    L15:
        r107 = false;
    L18:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [com.larus.home.impl.main.side_bar.view.group.render.d] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.home.impl.main.side_bar.view.group.render.e] */
    public g(String r110, zb9.a r111, com.larus.home.impl.main.side_bar.view.group.datasource.lark.v r112, boolean r113, com.larus.home.impl.main.side_bar.view.c r114, com.larus.home.impl.main.side_bar.view.b r210, d1 r211, int r212, String r213, com.larus.home.impl.main.side_bar.view.group.module.l0 r214, com.larus.home.impl.main.side_bar.view.group.module.m0 r215, z r216, boolean r217, n r218, final h r219, boolean r310) {
        super(r111, new q(r216, r218, r111.f571163a), r217, r310);
        this.f345618p = r110;
        this.f345619q = r112;
        this.f345620r = r210;
        this.f345621s = r219;
        ConversationGroupContent$humanBadgeListener$1 r100 = new ConversationGroupContent$humanBadgeListener$1(this);
        this.f345622t = r100;
        if (r112 == null) goto L7;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.a r101 = r112.f345454d;
        if (r101 == null) goto L7;
        r101.b(r100);
    L7:
        j0 r115 = new j0(r210, r211, r212, r213, r110, r214, r215);
        this.f345623u = r115;
        String r102 = "side_bar_query_group_" + r110;
        com.larus.home.impl.main.side_bar.feed.arch.w r103 = new com.larus.home.impl.main.side_bar.feed.arch.w();
        r103.a(new tb9.a(r114, r210, new ConversationGroupContent$feedSource$1$1(r115), new ConversationGroupContent$feedSource$1$2(r115), 1.0f));
        r103.a(new tb9.i(new c(this), new ConversationGroupContent$feedSource$1$4(r115)));
        if (r112 == null) goto L10;
        r103.a(new l0(r112.f345452b));
    L10:
        if (r113 == false) goto L12;
        r103.a(new tb9.h(new d(this), new ConversationGroupContent$feedSource$1$7(r115), new ConversationGroupContent$feedSource$1$8(this)));
    L12:
        if (r219 == null) goto L14;
        r103.a(new tb9.b(r219.f345633b, r219.f345634c, new ConversationGroupContent$feedSource$1$9$1(this), r219.f345635d, new e(r219)));
    L14:
        Unit r104 = Unit.INSTANCE;
        Fragment r105 = r210.getFragment();
        RecyclerView r106 = r210.W50();
        if (r106 != null) goto L17;
        r106 = new RecyclerView(AppHost.f326268a.getApplication().getApplicationContext());
    L17:
        CardFeedSlot r107 = new CardFeedSlot(r102, r103, r105, r106, new ConversationGroupContent$feedSource$2(r210));
        this.f345624v = r107;
        this.f345625w = LazyKt.lazy(new f(this));
        this.f345626x = r107.f344561i;
        this.f345627y = CollectionsKt.emptyList();
        this.f345628z = CollectionsKt.emptyList();
    }
}
