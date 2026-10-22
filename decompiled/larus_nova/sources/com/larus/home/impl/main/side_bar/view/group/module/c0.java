package com.larus.home.impl.main.side_bar.view.group.module;

import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.home.impl.main.side_bar.view.SideBarContentFragment;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import com.larus.home.impl.main.side_bar.view.j1;
import com.larus.home.impl.main.side_bar.view.o1;
import com.larus.home.impl.main.side_bar.view.p1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.assembly.n f345464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f345465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f345466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConversationGroupPolicy f345467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.data.p f345468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d1 f345469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConversationArchiveFilter f345470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f345471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f345472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f345473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f345474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f345475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f345476m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Boolean> f345477n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<com.larus.home.impl.main.side_bar.view.group.datasource.im.s0, Unit> f345478o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o0 f345479p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<GroupSortPolicy> f345480q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ac9.n f345481r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, com.larus.home.impl.main.side_bar.view.group.render.o<?>> f345482s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final n0 f345483t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f345484u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final z f345485v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f345486w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b0 f345487x;

    /* JADX WARN: Type inference failed for: r1v9, types: [com.larus.home.impl.main.side_bar.view.group.module.b0] */
    public c0(SideBarContentFragment.b r110, CoroutineScope r111, CoroutineContext r112, ConversationGroupPolicy r210, com.larus.home.impl.main.side_bar.data.p r211, d1 r212, ConversationArchiveFilter r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, j1 r311, o1 r312, o0 r313, p1 r314, ac9.n r315, Map r316, n0 r317) {
        Intrinsics.checkNotNullParameter(r110, "host");
        Intrinsics.checkNotNullParameter(r111, "viewScope");
        Intrinsics.checkNotNullParameter(r112, "buildContext");
        Intrinsics.checkNotNullParameter(r210, "policy");
        Intrinsics.checkNotNullParameter(r211, "component");
        Intrinsics.checkNotNullParameter(r212, "tabInfo");
        Intrinsics.checkNotNullParameter(r213, "archiveFilter");
        Intrinsics.checkNotNullParameter(r311, "sortWithPinTime");
        Intrinsics.checkNotNullParameter(r312, "onMainConversationSourceCreated");
        Intrinsics.checkNotNullParameter(r313, "paging");
        Intrinsics.checkNotNullParameter(r314, "sortPolicyProvider");
        Intrinsics.checkNotNullParameter(r315, "menuCallbacks");
        Intrinsics.checkNotNullParameter(r316, "reusableContent");
        Intrinsics.checkNotNullParameter(r317, "support");
        this.f345464a = r110;
        this.f345465b = r111;
        this.f345466c = r112;
        this.f345467d = r210;
        this.f345468e = r211;
        this.f345469f = r212;
        this.f345470g = r213;
        this.f345471h = r214;
        this.f345472i = r215;
        this.f345473j = r216;
        this.f345474k = r218;
        this.f345475l = r219;
        this.f345476m = r310;
        this.f345477n = r311;
        this.f345478o = r312;
        this.f345479p = r313;
        this.f345480q = r314;
        this.f345481r = r315;
        this.f345482s = r316;
        this.f345483t = r317;
        this.f345484u = new s(r210, r314, r213, r214, r216, r217, r315);
        this.f345485v = new z(this);
        this.f345486w = LazyKt.lazy(new a0(this));
        this.f345487x = new b0(this);
    }
}
