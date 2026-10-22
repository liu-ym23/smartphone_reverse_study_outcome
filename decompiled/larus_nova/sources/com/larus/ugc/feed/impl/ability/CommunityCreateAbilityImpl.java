package com.larus.ugc.feed.impl.ability;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.im.internal.delegate.c0;
import com.larus.nova.R;
import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.api.model.FabVisibilityStateKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
public final class CommunityCreateAbilityImpl implements g0a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f374549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1a.a f374550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final buc.e<b> f374551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final buc.d f374552d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f374553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m0a.e f374554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m0a.d f374555c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f374553a == r101.f374553a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f374554b, r101.f374554b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f374555c, r101.f374555c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f374553a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f374554b.hashCode()) * 31;
            m0a.d r102 = this.f374555c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(initialized=" + this.f374553a + ", params=" + this.f374554b + ", dependency=" + this.f374555c + ')';
        }

        public b(boolean r100, m0a.e r101, m0a.d r102) {
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f374553a = r100;
            this.f374554b = r101;
            this.f374555c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TabItemInfoKmp f374556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f374557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TabItemInfoKmp f374558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f374559d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f374556a, r101.f374556a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f374557b, r101.f374557b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f374558c, r101.f374558c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f374559d, r101.f374559d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f374556a.hashCode() * 31) + this.f374557b.hashCode()) * 31;
            TabItemInfoKmp r101 = this.f374558c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f374559d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingTabReport(newItem=" + this.f374556a + ", enterMethod=" + this.f374557b + ", prevItem=" + this.f374558c + ", currentPage=" + this.f374559d + ')';
        }

        public c(TabItemInfoKmp r100, String r101, TabItemInfoKmp r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "newItem");
            Intrinsics.checkNotNullParameter(r101, "enterMethod");
            Intrinsics.checkNotNullParameter(r103, "currentPage");
            this.f374556a = r100;
            this.f374557b = r101;
            this.f374558c = r102;
            this.f374559d = r103;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f374560a = null;

        static {
            int[] r100 = new int[CommunityCreateLaunchModeKmp.values().length];
            r100[CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CommunityCreateLaunchModeKmp.STANDALONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CommunityCreateLaunchModeKmp.SIDE_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f374560a = r100;
        }
    }

    static {
    }

    @Override // g0a.f
    public final void Oc() {
        m0a.f r100 = (m0a.f) this.f374550b.f1401a.getValue();
        m0a.d r101 = this.f374551c.c().f374555c;
        if (r101 == null) goto L8;
        g0a.e r102 = r101.f511497b;
        if (r102 == null) goto L9;
        r102.JA(new g0a.h(r100.f511517c));
        return;
    L9:
        return;
    }

    @Override // g0a.f
    public final void dy() {
        this.f374550b.update(new f());
    }

    @Override // g0a.f
    public final void ev() {
        m0a.f r100 = (m0a.f) this.f374550b.f1401a.getValue();
        if (r100.f511525k == false) goto L6;
        long r101 = fuc.a.a().a();
        this.f374552d.e(r101);
        return;
    L6:
        this.f374550b.update(new com.larus.ugc.feed.impl.ability.d());
        long r102 = fuc.a.a().a();
        this.f374552d.e(r102);
        if (r100.f511515a != CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB) goto L9;
        return;
    L9:
        TabItemInfoKmp r103 = (TabItemInfoKmp) CollectionsKt.getOrNull(r100.f511519e, r100.f511520f);
        if (r103 != null) goto L12;
        return;
    L12:
        String r104 = r100.f511526l;
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        d(r103, r104, null, r100.f511517c);
    }

    @Override // g0a.f
    public final i1<m0a.f> getUiState() {
        return this.f374550b.f1401a;
    }

    public final Object c(Continuation<? super Unit> r110) {
        if ((r110 instanceof CommunityCreateAbilityImpl$fetchTabList$1) == false) goto L7;
        CommunityCreateAbilityImpl$fetchTabList$1 r100 = (CommunityCreateAbilityImpl$fetchTabList$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        m0a.e r104 = (m0a.e) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L35:
        Object r112 = Result.m9449constructorimpl((List) r111);     // Catch: Throwable -> L14
    L40:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r112);
        if (r105 == null) goto L44;
        c0.f348199b.e("CommunityCreateAbilityImpl", "fetchTabList failed: " + r105);
        r112 = CollectionsKt.emptyList();
    L44:
        final List r113 = (List) r112;
        if (r104.f511502c == false) goto L47;
        r113 = CollectionsKt.plus(CollectionsKt.listOf(new TabItemInfoKmp("0", "creation_actionTab_discover", yg9.a.a(new yg9.b(R.string.larus_creation_actionTab_discover)), Boxing.boxBoolean(false), null, 16, null)), r113);
    L47:
        c0.f348199b.d("CommunityCreateAbilityImpl", "fetchTabList done: size=" + r113.size());
        this.f374550b.update(new com.larus.ugc.feed.impl.ability.b(r113));
        return Unit.INSTANCE;
    L14:
        th = th;
        m0a.e r106 = r104;
    L39:
        Result.Companion r107 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r104 = r106;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        b r114 = this.f374551c.c();
        if (r114.f374553a == true) goto L22;
        c0.f348199b.d("CommunityCreateAbilityImpl", "fetchTabList skip: not initialized");
        return Unit.INSTANCE;
    L22:
        r106 = r114.f374554b;
        if (r106.f511500a != CommunityCreateLaunchModeKmp.SIDE_BAR) goto L25;
        String r108 = CheckPointType.ENTER_PAGE;
    L26:
        c0 r109 = c0.f348199b;
        r109.d("CommunityCreateAbilityImpl", "fetchTabList: recommendType=" + r106.f511501b + " downgrade=" + r108);
        m0a.d r115 = r114.f374555c;
        if (r115 == null) goto L49;
        m0a.m r116 = r115.f511499d;
        if (r116 == null) goto L49;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L38
        int r118 = r106.f511501b;     // Catch: Throwable -> L38
        boolean r119 = r106.f511502c;     // Catch: Throwable -> L38
        r100.L$0 = r106;     // Catch: Throwable -> L38
        r100.label = 1;     // Catch: Throwable -> L38
        r111 = r116.a(r118, r119);     // Catch: Throwable -> L38
        if (r111 != r102) goto L34;
        return r102;
    L34:
        r104 = r106;
    L38:
        th = th;
    L49:
        r109.d("CommunityCreateAbilityImpl", "fetchTabList skip: dependency missing (programmer error)");
        return Unit.INSTANCE;
    L25:
        r108 = "enter_conversation_list";
    L7:
        r100 = new CommunityCreateAbilityImpl$fetchTabList$1(this, r110);
        goto L8
    }

    @Override // g0a.f
    public final void da(String r110) {
        Intrinsics.checkNotNullParameter(r110, "leaveMethod");
        m0a.f r100 = (m0a.f) this.f374550b.f1401a.getValue();
        if (r100.f511515a != CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB) goto L5;
        return;
    L5:
        long r101 = this.f374552d.c();
        if (r101 > 0) goto L8;
        return;
    L8:
        this.f374552d.e(0);
        long r111 = fuc.a.a().a() - r101;
        TabItemInfoKmp r102 = (TabItemInfoKmp) CollectionsKt.getOrNull(r100.f511519e, r100.f511520f);
        if (r102 != null) goto L11;
        return;
    L11:
        c0.f348199b.d("CommunityCreateAbilityImpl", "onTabLeave: method=" + r110 + " duration=" + r111 + " tabId=" + r102.getId());
        m0a.d r103 = this.f374551c.c().f374555c;
        if (r103 == null) goto L20;
        g0a.e r104 = r103.f511497b;
        if (r104 == null) goto L21;
        String r105 = r100.f511526l;
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r104.wF(new g0a.j(r105, r110, String.valueOf(r100.f511518d), r102.getName(), r102.getId(), r100.f511517c, r111));
        return;
    L21:
        return;
    }

    @Override // g0a.f
    public final void gk(final UserCreationKmp r100) {
        Intrinsics.checkNotNullParameter(r100, "creation");
        this.f374550b.update(new com.larus.ugc.feed.impl.ability.c(r100));
    }

    @Override // g0a.f
    public final void vi(boolean r100) {
        final FabVisibilityStateKmp r101 = b(((m0a.f) this.f374550b.f1401a.getValue()).f511515a, r100);
        c0.f348199b.d("CommunityCreateAbilityImpl", "updateFabDowngrade: " + r100 + " -> " + r101);
        this.f374550b.update(new g(r101));
    }

    public CommunityCreateAbilityImpl(CoroutineScope r110, a1a.a r111) {
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "stateHolder");
        this.f374549a = r110;
        this.f374550b = r111;
        this.f374551c = buc.b.d(new b(false, new m0a.e(null, 0, false, null, null, null, null, null, null, 0, null, 32767), null));
        this.f374552d = buc.b.c(0);
    }

    public static FabVisibilityStateKmp b(CommunityCreateLaunchModeKmp r100, boolean r101) {
        if (r101 == true) goto L4;
        int r102 = d.f374560a[r100.ordinal()];
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L18;
        if (r102 != 3) goto L13;
        return FabVisibilityStateKmp.HIDDEN_LAUNCH_MODE;
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        return FabVisibilityStateKmp.VISIBLE;
    L16:
        return FabVisibilityStateKmp.HIDDEN_LAUNCH_MODE;
    L4:
        return FabVisibilityStateKmp.HIDDEN_DOWNGRADE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g0a.f
    public final void Ow(final int r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        this.f374550b.update(new com.larus.ugc.feed.impl.ability.a(r102, r103, r100, r101));
        Integer r104 = (Integer) r103.element;
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
        c0.f348199b.d("CommunityCreateAbilityImpl", "selectTab invalid index=" + r100 + " size=" + r105);
    L5:
        c r106 = (c) r102.element;
        if (r106 == null) goto L9;
        d(r106.f374556a, r106.f374557b, r106.f374558c, r106.f374559d);
        return;
    }

    @Override // g0a.f
    public final void yG(final m0a.e r100, m0a.d r110) {
        Intrinsics.checkNotNullParameter(r100, "initParams");
        Intrinsics.checkNotNullParameter(r110, "initDependency");
        b r101 = this.f374551c.c();
        if (r101.f374553a == false) goto L7;
        c0.f348199b.d("CommunityCreateAbilityImpl", "initialize already done, skip");
        return;
    L7:
        if (this.f374551c.a(r101, new b(true, r100, r110)) == true) goto L10;
        c0.f348199b.d("CommunityCreateAbilityImpl", "initialize lost CAS race, skip");
        return;
    L10:
        c0.f348199b.d("CommunityCreateAbilityImpl", "initialize: launchMode=" + r100.f511500a + " recommendType=" + r100.f511501b + " isMultiTab=" + r100.f511502c);
        final FabVisibilityStateKmp r111 = b(r100.f511500a, r110.f511498c.zF());
        this.f374550b.update(new e(r100, this, r111));
        BuildersKt.launch$default(this.f374549a, Dispatchers.getDefault(), null, new CommunityCreateAbilityImpl$initialize$2(this, null), 2, null);
    }

    public final void d(TabItemInfoKmp r110, String r111, TabItemInfoKmp r112, String r113) {
        String r100 = r110.getId();
        if (r100 != null) goto L5;
        String r101 = "";
    L7:
        if (r101.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        c0.f348199b.d("CommunityCreateAbilityImpl", "reportEnterTab skip: empty tabId");
        return;
    L13:
        m0a.d r103 = this.f374551c.c().f374555c;
        if (r103 == null) goto L26;
        g0a.e r104 = r103.f511497b;
        if (r104 == null) goto L27;
        String r105 = r110.getStarlingKey();
        if (r105 != null) goto L20;
        String r106 = "";
    L21:
        if (r112 == null) goto L23;
        String r114 = r112.getId();
    L24:
        r104.zh(new g0a.i(r113, r101, r106, r114, r110.getTrackerTabType(), r111));
        return;
    L23:
        r114 = null;
        goto L24
    L20:
        r106 = r105;
        goto L21
    L27:
        return;
    L26:
        return;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }
}
