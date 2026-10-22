package com.larus.home.impl.main.side_bar.view.group.render;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import com.larus.home.impl.main.side_bar.feed.arch.CardFeedSlot;
import com.larus.home.impl.main.side_bar.feed.arch.FlowFeedAdapter;
import com.larus.home.impl.main.side_bar.feed.factory.SideBarProjectEmptyAction;
import com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class i0 extends k0<com.larus.home.impl.main.side_bar.view.group.datasource.im.u0> {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImProjectSource f345638p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CoroutineScope f345639q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.b f345640r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<Unit> f345641s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function2<String, Boolean, Unit> f345642t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<String, Unit> f345643u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Function2<String, String, Unit> f345644v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Function2<String, String, Unit> f345645w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Function3<String, String, Boolean, Unit> f345646x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j0 f345647y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CardFeedSlot f345648z;

    public static final class a {
    }

    static {
    }

    public i0() {
        throw null;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.o
    public final FlowFeedAdapter t() {
        return this.f345648z.f344561i;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final List<fb9.a> z() {
        List<fb9.a> r100 = this.f345648z.getAbilities();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if ((r103 instanceof fb9.i) == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return CollectionsKt.listOfNotNull((fb9.a) CollectionsKt.firstOrNull(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.home.impl.main.side_bar.feed.arch.CardFeedSlot] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
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
    @Override // com.larus.home.impl.main.side_bar.view.group.render.k0
    public final void C(List<com.larus.home.impl.main.side_bar.view.group.datasource.im.u0> r210) {
        Intrinsics.checkNotNullParameter(r210, "items");
        ?? r100 = this.f345648z;
        if (((ArrayList) r210).isEmpty() == false) goto L7;
        SideBarProjectEmptyAction[] r101 = SideBarProjectEmptyAction.values();
        ?? r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L36;
        SideBarProjectEmptyAction r105 = r101[r104];
        r102.add(new eb9.o("project_empty:" + r105.getCardId(), tb9.d.f545297c, r105, null, false, 0, 0, 0, 248));
        r104 = r104 + 1;
    L36:
        r100.b(r102);
        return;
    L7:
        List r106 = CollectionsKt.createListBuilder();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r210, 10));
        Iterator r108 = r210.iterator();
    L9:
        if (r108.hasNext() == false) goto L30;
        com.larus.home.impl.main.side_bar.view.group.datasource.im.u0 r110 = (com.larus.home.impl.main.side_bar.view.group.datasource.im.u0) r108.next();
        String r109 = "project:".concat(r110.b());
        SideBarFeedCardType r111 = tb9.f.f545302m;
        Long r112 = Long.valueOf(r110.f345394a.updateTime);
        boolean r113 = true;
        long r114 = 0;
        if (r112.longValue() < 0) goto L13;
        boolean r115 = true;
    L14:
        Long r116 = null;
        if (r115 == true) goto L18;
        r112 = null;
    L18:
        if (r112 == null) goto L20;
        long r117 = r112.longValue();
    L21:
        ArrayList r211 = r107;
        Long r118 = Long.valueOf(r110.f345394a.createTime);
        if (r118.longValue() >= 0) goto L25;
        r113 = false;
    L25:
        if (r113 == false) goto L27;
        r116 = r118;
    L27:
        if (r116 == null) goto L29;
        r114 = r116.longValue();
    L29:
        r211.add(new eb9.o(r109, r111, r110, null, false, r117, r114, r110.hashCode(), 24));
        r107 = r211;
        goto L9
    L20:
        r117 = 0;
        goto L21
    L13:
        r115 = false;
        goto L14
    L30:
        r106.addAll(r107);
        if (hasMore() == true) goto L33;
    L35:
        r102 = CollectionsKt.build(r106);
        goto L36
    L33:
        if (this.f345669k == true) goto L35;
        com.larus.home.impl.main.side_bar.data.j0 r119 = new com.larus.home.impl.main.side_bar.data.j0(SideBarItemType.SHOW_ALL, null, null, null, null, AppHost.f326268a.getApplication().getString(R.string.larus_groupChats_navBar_moreProjects), null, null, false, 0, 990);
        r106.add(new eb9.o("project:show_all", tb9.i.f545324d, r119, null, false, 0, 0, r119.hashCode(), 120));
        goto L35
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.home.impl.main.side_bar.view.group.render.f0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.home.impl.main.side_bar.view.group.render.e0] */
    public i0(ImProjectSource r110, z r111, boolean r210, n r211, CoroutineScope r212, com.larus.home.impl.main.side_bar.view.c r213, com.larus.home.impl.main.side_bar.view.b r214, ac9.c0 r215, d1 r216, int r217, String r218, Function0 r219, Function0 r310, com.larus.home.impl.main.side_bar.view.group.module.j0 r311, Function2 r312, boolean r313, Function1 r314, Function2 r315, Function2 r316, Function3 r317) {
        super(r110, new q(r111, r211, new zb9.h(new d0(), new e0(), 2)), r210, false);
        this.f345638p = r110;
        this.f345639q = r212;
        this.f345640r = r214;
        this.f345641s = r311;
        this.f345642t = r312;
        this.f345643u = r314;
        this.f345644v = r315;
        this.f345645w = r316;
        this.f345646x = r317;
        j0 r112 = new j0(r214, r216, r217, r218, SlashMentionConfig.SLASH_CONTENT_PROJECT, r219, r310);
        this.f345647y = r112;
        com.larus.home.impl.main.side_bar.feed.arch.w r100 = new com.larus.home.impl.main.side_bar.feed.arch.w();
        r100.a(new tb9.f(new ProjectGroupContent$feedSource$1$1(this), new f0(this), r213, r214, new ProjectGroupContent$feedSource$1$3(r112), new ProjectGroupContent$feedSource$1$4(r112), r313, r314, r315, r316, r317));
        r100.a(new tb9.d(r311));
        r100.a(new tb9.i(new g0(this), new ProjectGroupContent$feedSource$1$6(r112)));
        Fragment r101 = r214.getFragment();
        RecyclerView r102 = r214.W50();
        if (r102 != null) goto L5;
        r102 = new RecyclerView(AppHost.f326268a.getApplication().getApplicationContext());
    L5:
        ProjectGroupContent$feedSource$2 r103 = new ProjectGroupContent$feedSource$2(r214);
        RecyclerView r220 = r102;
        this.f345648z = new CardFeedSlot("side_bar_project_group", r100, r101, r220, CollectionsKt.listOf(new rb9.b(r215)), r103);
    }
}
