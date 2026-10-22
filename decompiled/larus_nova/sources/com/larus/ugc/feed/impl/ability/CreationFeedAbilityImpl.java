package com.larus.ugc.feed.impl.ability;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import com.larus.ugc.feed.api.model.UserCreationMusicKmp;
import com.larus.ugc.feed.api.model.UserCreationTrackParamsKmp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationFeedAbilityImpl implements g0a.g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f374563o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f374564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1a.b f374565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CreationFeedInitParamsKmp f374566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m0a.h f374567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f374568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f374569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f374570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f374571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f374572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f374573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f374574k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Integer, Boolean> f374575l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f374576m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UserCreationKmp f374577n;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f374578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<UserCreationModelKmp> f374579b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f374578a == r101.f374578a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f374579b, r101.f374579b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f374578a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f374579b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeletionResult(changed=" + this.f374578a + ", newList=" + this.f374579b + ')';
        }

        public b(boolean r100, List<UserCreationModelKmp> r101) {
            Intrinsics.checkNotNullParameter(r101, "newList");
            this.f374578a = r100;
            this.f374579b = r101;
        }
    }

    static {
    }

    public final m0a.l n() {
        m0a.h r100 = this.f374567d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final Unit o(boolean r100) {
        n0a.a r101 = this.f374565b.a();
        int r102 = this.f374570g;
        if (r102 < 200) goto L6;
        p("preCheckCanLoadMore: pageIndex=" + this.f374570g + " hit MAX_PAGES=200, stop load more");
    L14:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L20;
        if (r100 == true) goto L20;
        p("tryLoadMore refused, pageIndex:" + this.f374570g + ", isForce:" + r100);
    L27:
        return Unit.INSTANCE;
    L20:
        p("loadMore:" + this.f374570g + ", isForce:" + r100);
        if (r100 == false) goto L25;
        Job r104 = this.f374573j;
        if (r104 == null) goto L25;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L25:
        this.f374575l.put(Integer.valueOf(this.f374570g), Boolean.TRUE);
        this.f374565b.update(new h());
        this.f374573j = BuildersKt.launch$default(this.f374564a, Dispatchers.getDefault(), null, new CreationFeedAbilityImpl$loadMoreRecommendList$2(this, null), 2, null);
        goto L27
    L6:
        if (this.f374572i == false) goto L14;
        if (this.f374575l.containsKey(Integer.valueOf(r102)) == true) goto L14;
        if ((r101.f516615c instanceof n0a.e.b) == true) goto L14;
        if (Intrinsics.areEqual(r101.f516616d, n0a.b.C6879b.f516620a) == true) goto L14;
        r103 = true;
        goto L16
    }

    public final void p(String r100) {
        c0.f348199b.i("CreationFeedAbilityImpl", r100);
    }

    public static final void b(CreationFeedAbilityImpl r100, String r101) {
        r100.getClass();
        c0.f348199b.d("CreationFeedAbilityImpl", r101);
    }

    public static boolean i(List r100, List r101) {
        if (((ArrayList) r100).size() == ((ArrayList) r101).size()) goto L5;
        return false;
    L5:
        List r102 = CollectionsKt.zip(r100, r101);
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L63;
        Pair r104 = (Pair) r103.next();
        UserCreationKmp r105 = (UserCreationKmp) r104.component1();
        UserCreationKmp r106 = (UserCreationKmp) r104.component2();
        if (r106.getUserCreationType() != 1) goto L52;
        if (Intrinsics.areEqual(r106.getCreationId(), r105.getCreationId()) == true) goto L18;
    L60:
        boolean r107 = false;
    L61:
        if (r107 == true) goto L12;
        return false;
    L18:
        if (Intrinsics.areEqual(r106.getPrivateStatus(), r105.getPrivateStatus()) == false) goto L60;
        if (Intrinsics.areEqual(r106.getStatus(), r105.getStatus()) == false) goto L60;
        if (r106.getUserCreationType() != r105.getUserCreationType()) goto L60;
        UserCreationContentKmp r108 = r106.getContent();
        String r109 = null;
        if (r108 == null) goto L28;
        UserCreationMusicKmp r110 = r108.getMusicContent();
        if (r110 == null) goto L28;
        ImageInfoKmp r111 = r110.getCover();
    L29:
        UserCreationContentKmp r112 = r105.getContent();
        if (r112 == null) goto L34;
        UserCreationMusicKmp r113 = r112.getMusicContent();
        if (r113 == null) goto L34;
        ImageInfoKmp r114 = r113.getCover();
    L36:
        if (Intrinsics.areEqual(r111, r114) == false) goto L60;
        UserCreationContentKmp r115 = r106.getContent();
        if (r115 == null) goto L42;
        UserCreationMusicKmp r116 = r115.getMusicContent();
        if (r116 == null) goto L42;
        String r117 = r116.getTitle();
    L43:
        UserCreationContentKmp r118 = r105.getContent();
        if (r118 == null) goto L49;
        UserCreationMusicKmp r119 = r118.getMusicContent();
        if (r119 == null) goto L49;
        r109 = r119.getTitle();
    L49:
        if (Intrinsics.areEqual(r117, r109) == false) goto L60;
    L59:
        r107 = true;
    L42:
        r117 = null;
    L34:
        r114 = null;
    L28:
        r111 = null;
        goto L29
    L52:
        if (Intrinsics.areEqual(r106.getCreationId(), r105.getCreationId()) == false) goto L60;
        if (Intrinsics.areEqual(r106.getPrivateStatus(), r105.getPrivateStatus()) == false) goto L60;
        if (Intrinsics.areEqual(r106.getStatus(), r105.getStatus()) == false) goto L60;
        if (r106.getUserCreationType() != r105.getUserCreationType()) goto L60;
    L63:
        return true;
    L8:
        if (r102.isEmpty() == false) goto L10;
        goto L10
    }

    public final Object c(boolean r310, Continuation<? super Boolean> r311) {
        if ((r311 instanceof CreationFeedAbilityImpl$checkCurrentData$1) == false) goto L7;
        CreationFeedAbilityImpl$checkCurrentData$1 r100 = (CreationFeedAbilityImpl$checkCurrentData$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CreationFeedAbilityImpl$checkCurrentData$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        int r110 = 0;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r102.I$0;
        ResultKt.throwOnFailure(r103);
    L24:
        Pair r107 = (Pair) r103;
        if (r107 == null) goto L92;
        CommonCreationFeedDataKmp r108 = (CommonCreationFeedDataKmp) r107.getFirst();
        if (r108 == null) goto L92;
        Map<String, String> r109 = r108.getTraceMap();
        if (r109 == null) goto L31;
        String r111 = r109.get("request_id");
    L32:
        List<UserCreationKmp> r112 = r108.getCreationList();
        if (r112 != null) goto L35;
    L38:
        boolean r113 = true;
    L40:
        if (r113 == true) goto L42;
        List<UserCreationModelKmp> r114 = t(r111, r106, r108.getCreationList());
    L54:
        p("New data size: " + r114.size());
        HashSet r115 = new HashSet();
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r114.iterator();
    L56:
        if (r117.hasNext() == false) goto L60;
        Object r118 = r117.next();
        if (r115.add(((UserCreationModelKmp) r118).getModelId()) == false) goto L56;
        r116.add(r118);
        goto L56
    L60:
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r120 = r116.iterator();
    L62:
        if (r120.hasNext() == false) goto L75;
        Object r121 = r120.next();
        int r122 = r110 + 1;
        if (r110 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        UserCreationModelKmp r123 = (UserCreationModelKmp) r121;
        List<UserCreationKmp> r124 = r123.getCreationList();
        if (r124 == null) goto L73;
        List<UserCreationKmp> r125 = r124;
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator<T> r127 = r125.iterator();
    L70:
        if (r127.hasNext() == false) goto L72;
        r126.add(w.a((UserCreationKmp) r127.next(), r122));
        goto L70
    L72:
        List r128 = CollectionsKt.toMutableList(r126);
    L74:
        UserCreationModelKmp r129 = UserCreationModelKmp.copy$default(r123, 0, r128, null, 5, null);
        m0a.o.a(r129);
        r119.add(r129);
        r110 = r122;
        goto L62
    L73:
        r128 = null;
        goto L74
    L75:
        p("Processed data size: " + r119.size());
        List r130 = CollectionsKt.take(this.f374565b.a().f516613a, r119.size());
        ArrayList r131 = new ArrayList();
        Iterator r132 = r130.iterator();
    L77:
        if (r132.hasNext() == false) goto L82;
        List<UserCreationKmp> r133 = ((UserCreationModelKmp) r132.next()).getCreationList();
        if (r133 != null) goto L81;
        r133 = CollectionsKt.emptyList();
    L81:
        CollectionsKt.addAll(r131, r133);
        goto L77
    L82:
        ArrayList r134 = new ArrayList();
        Iterator r135 = r119.iterator();
    L84:
        if (r135.hasNext() == false) goto L89;
        List<UserCreationKmp> r136 = ((UserCreationModelKmp) r135.next()).getCreationList();
        if (r136 != null) goto L88;
        r136 = CollectionsKt.emptyList();
    L88:
        CollectionsKt.addAll(r134, r136);
        goto L84
    L89:
        boolean r137 = !i(r131, r134);
        p("Data changed: " + r137);
        return Boxing.boxBoolean(r137);
    L42:
        List<List<UserCreationKmp>> r138 = r108.getCreationGroupList();
        if (r138 == null) goto L53;
        List<List<UserCreationKmp>> r139 = r138;
        ArrayList r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator<T> r141 = r139.iterator();
    L46:
        if (r141.hasNext() == false) goto L52;
        List r142 = (List) r141.next();
        ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r142, 10));
        Iterator r144 = r142.iterator();
    L49:
        if (r144.hasNext() == false) goto L51;
        r143.add(UserCreationKmp.copy$default((UserCreationKmp) r144.next(), null, 0, null, null, null, null, null, null, null, null, null, null, null, f(r106, r111), null, null, null, 122879, null));
        goto L49
    L51:
        UserCreationModelKmp r145 = new UserCreationModelKmp(2, CollectionsKt.toMutableList(r143), null, 4, null);
        m0a.o.a(r145);
        r140.add(r145);
        goto L46
    L52:
        r114 = r140;
        goto L54
    L53:
        r114 = CollectionsKt.emptyList();
        goto L54
    L35:
        if (r112.isEmpty() == true) goto L38;
        r113 = false;
        goto L40
    L31:
        r111 = null;
    L92:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        p("Start checking current data, request index: 1, isHotLaunch: " + r310);
        long r146 = RandomKt.Random(com.larus.im.internal.delegate.c.f348197a.currentTimeMillis()).nextLong();
        if (r310 == false) goto L17;
        String r147 = "hot_launch";
    L18:
        String r148 = r147;
        m0a.l r149 = n();
        if (r149 == null) goto L92;
        Long r150 = Boxing.boxLong(r146);
        r102.I$0 = 1;
        r102.label = 1;
        r103 = r149.a(1, null, r150, r148, r102);
        if (r103 != r104) goto L23;
        return r104;
    L23:
        r106 = 1;
        goto L24
    L17:
        r147 = "refresh";
    L7:
        r100 = new CreationFeedAbilityImpl$checkCurrentData$1(this, r311);
        goto L8
    }

    public final UserCreationTrackParamsKmp f(int r110, String r111) {
        Integer r100 = Integer.valueOf(r110);
        Integer r101 = null;
        CreationFeedInitParamsKmp r112 = this.f374566c;
        if (r112 == null) goto L7;
        TabItemInfoKmp r113 = r112.getCurrentTabItemInfo();
        if (r113 == null) goto L7;
        String r102 = r113.getId();
    L8:
        CreationFeedInitParamsKmp r114 = this.f374566c;
        if (r114 == null) goto L13;
        TabItemInfoKmp r115 = r114.getCurrentTabItemInfo();
        if (r115 == null) goto L13;
        String r103 = r115.getStarlingKey();
    L14:
        CreationFeedInitParamsKmp r116 = this.f374566c;
        if (r116 == null) goto L19;
        TabItemInfoKmp r117 = r116.getCurrentTabItemInfo();
        if (r117 == null) goto L19;
        String r104 = r117.getTrackerTabType();
    L20:
        CreationFeedInitParamsKmp r118 = this.f374566c;
        if (r118 == null) goto L25;
        CreationFeedTrackParamsKmp r119 = r118.getTrackParams();
        if (r119 == null) goto L25;
        String r105 = r119.getBotId();
    L27:
        return new UserCreationTrackParamsKmp(r111, r100, r101, r102, r103, r104, r105, 4, null);
    L25:
        r105 = null;
    L19:
        r104 = null;
    L13:
        r103 = null;
    L7:
        r102 = null;
        goto L8
    }

    public final Object q(String r100, boolean r101) {
        p(r100.concat(", refresh"));
        if (r101 == false) goto L5;
        this.f374577n = null;
        p("clearMock");
    L5:
        Object r102 = r(true, false, false);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r102;
    L9:
        return Unit.INSTANCE;
    }

    public CreationFeedAbilityImpl(CoroutineScope r100, a1a.b r101, o0a.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "stateHolder");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        this.f374564a = r100;
        this.f374565b = r101;
        this.f374569f = RandomKt.Random(com.larus.im.internal.delegate.c.f348197a.currentTimeMillis()).nextLong();
        this.f374570g = 1;
        this.f374575l = new LinkedHashMap();
    }

    public static b d(List r110, String r111, boolean r112) {
        ArrayList r100 = new ArrayList();
        Iterator r113 = r110.iterator();
        boolean r101 = false;
        int r102 = 1;
    L4:
        if (r113.hasNext() == false) goto L67;
        UserCreationModelKmp r103 = (UserCreationModelKmp) r113.next();
        Integer r104 = null;
        if (r112 == true) goto L7;
        List<UserCreationKmp> r105 = r103.getCreationList();
        if (r105 == null) goto L43;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L39:
        if (r107.hasNext() == false) goto L44;
        Object r114 = r107.next();
        if ((!Intrinsics.areEqual(((UserCreationKmp) r114).getCreationId(), r111)) == false) goto L39;
        r106.add(r114);
    L44:
        List<UserCreationKmp> r108 = r103.getCreationList();
        if (r108 == null) goto L47;
        Integer r109 = Integer.valueOf(r108.size());
    L48:
        if (r106 == null) goto L51;
        r104 = Integer.valueOf(r106.size());
    L51:
        if (Intrinsics.areEqual(r109, r104) == true) goto L53;
        r101 = true;
    L53:
        if (r106 != null) goto L55;
    L58:
        boolean r115 = true;
    L59:
        if (r115 == true) goto L4;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r117 = r106.iterator();
    L62:
        if (r117.hasNext() == false) goto L64;
        r116.add(w.a((UserCreationKmp) r117.next(), r102));
        goto L62
    L64:
        UserCreationModelKmp r118 = UserCreationModelKmp.copy$default(r103, 0, CollectionsKt.toMutableList(r116), null, 5, null);
        m0a.o.a(r118);
        r100.add(r118);
    L65:
        r102 = r102 + 1;
        goto L4
    L55:
        if (r106.isEmpty() == true) goto L58;
        r115 = false;
        goto L59
    L47:
        r109 = null;
        goto L48
    L43:
        r106 = null;
        goto L44
    L7:
        List<UserCreationKmp> r119 = r103.getCreationList();
        if (r119 == null) goto L23;
        List<UserCreationKmp> r120 = r119;
        if ((r120 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r121 = r120.iterator();
    L16:
        if (r121.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((UserCreationKmp) r121.next()).getCreationId(), r111) == false) goto L16;
        boolean r122 = true;
    L21:
        if (r122 != true) goto L23;
        boolean r123 = true;
    L24:
        if (r123 == false) goto L25;
        r101 = true;
        goto L4
    L25:
        List<UserCreationKmp> r124 = r103.getCreationList();
        if (r124 == null) goto L32;
        List<UserCreationKmp> r125 = r124;
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator<T> r127 = r125.iterator();
    L29:
        if (r127.hasNext() == false) goto L31;
        r126.add(w.a((UserCreationKmp) r127.next(), r102));
        goto L29
    L31:
        List r128 = CollectionsKt.toMutableList(r126);
    L33:
        UserCreationModelKmp r129 = UserCreationModelKmp.copy$default(r103, 0, r128, null, 5, null);
        m0a.o.a(r129);
        r100.add(r129);
        goto L65
    L32:
        r128 = null;
    L20:
        r122 = false;
        goto L21
    L12:
        if (r120.isEmpty() == false) goto L14;
    L23:
        r123 = false;
        goto L24
    L67:
        return new b(r101, r100);
    }

    public final Object r(boolean r110, boolean r111, boolean r112) {
        ((LinkedHashMap) this.f374575l).clear();
        this.f374570g = 1;
        this.f374571h = null;
        Job r100 = this.f374573j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f374575l.put(Boxing.boxInt(this.f374570g), Boxing.boxBoolean(true));
        if (r110 == true) goto L10;
        m0a.l r101 = n();
        if (r101 == null) goto L10;
        CreationFeedCacheEntityKmp r102 = r101.b();
    L11:
        final boolean r103 = false;
        if (r102 == null) goto L40;
        CommonCreationFeedDataKmp r104 = r102.getListData();
        if (r104 == null) goto L39;
        int r105 = this.f374570g;
        this.f374570g = r105 + 1;
        Long r106 = r102.getRandomSeed();
        if (r106 == null) goto L19;
        long r107 = r106.longValue();
    L20:
        this.f374569f = r107;
        this.f374571h = r104.getNextCursor();
        u(r105, r104, false, true);
        List<UserCreationKmp> r108 = r104.getCreationList();
        if (r108 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L37;
        List<List<UserCreationKmp>> r113 = r104.getCreationGroupList();
        if (r113 != null) goto L31;
    L34:
        boolean r114 = true;
    L35:
        if (r114 == false) goto L37;
        r103 = true;
        goto L37
    L31:
        if (r113.isEmpty() == true) goto L34;
        r114 = false;
    L37:
        this.f374565b.b(new n(r103));
        goto L39
    L23:
        if (r108.isEmpty() == true) goto L26;
        r109 = false;
        goto L27
    L19:
        r107 = 0;
    L39:
        return Boxing.boxBoolean(true);
    L40:
        if (r110 == false) goto L42;
        this.f374565b.update(new k());
    L43:
        Job r115 = this.f374574k;
        if (r115 == null) goto L46;
        Job.DefaultImpls.cancel$default(r115, null, 1, null);
    L46:
        this.f374574k = BuildersKt.launch$default(this.f374564a, Dispatchers.getDefault(), null, new CreationFeedAbilityImpl$requestFirstRecommendList$4(this, r112, r110, r111, null), 2, null);
        return Boxing.boxBoolean(false);
    L42:
        this.f374565b.update(new l());
    L10:
        r102 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<UserCreationModelKmp> t(String r210, int r211, List<UserCreationKmp> r212) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = r212;
        UserCreationKmp r101 = this.f374577n;
        if (r101 == null) goto L11;
        List<UserCreationKmp> r102 = r212;
        if (r102 == null) goto L9;
        List r103 = CollectionsKt.toMutableList(r102);
        if (r103 == null) goto L9;
        ListProtector.add(r103, 0, r101);
        T r104 = r103;
    L10:
        r100.element = r104;
    L9:
        r104 = 0;
    L11:
        List r105 = (List) r100.element;
        if (r105 == null) goto L18;
        List r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L20;
        UserCreationModelKmp r110 = new UserCreationModelKmp(1, CollectionsKt.arrayListOf(new UserCreationKmp[]{UserCreationKmp.copy$default((UserCreationKmp) r108.next(), null, 0, null, null, null, null, null, null, null, null, null, null, null, f(r211, r210), null, null, null, 122879, null)}), null, 4, null);
        m0a.o.a(r110);
        r107.add(r110);
        goto L15
    L20:
        return r107;
    L18:
        return CollectionsKt.emptyList();
    }

    public final Object l(boolean r100, boolean r101, boolean r102, Continuation<? super Boolean> r103) {
        boolean r104 = false;
        if (r100 == true) goto L5;
    L14:
        this.f374576m = true;
        return r(false, r101, r102);
    L5:
        if (this.f374576m == false) goto L14;
        p("viewModel has init so return");
        m0a.l r105 = n();
        if (r105 == null) goto L9;
        CreationFeedCacheEntityKmp r106 = r105.b();
    L10:
        if (r106 == null) goto L13;
        r104 = true;
    L13:
        return Boxing.boxBoolean(r104);
    L9:
        r106 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    public final void u(final int r310, CommonCreationFeedDataKmp r311, boolean r312, boolean r313) {
        this.f374572i = r311.getHasMore();
        final n0a.a r100 = this.f374565b.a();
        ArrayList r101 = new ArrayList();
        if (r312 == false) goto L5;
        r101.addAll(r100.f516613a);
    L5:
        Map<String, String> r102 = r311.getTraceMap();
        if (r102 == null) goto L8;
        String r103 = r102.get("request_id");
    L9:
        List<UserCreationKmp> r104 = r311.getCreationList();
        int r105 = 0;
        if (r104 != null) goto L12;
    L15:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L19;
        r101.addAll(t(r103, r310, r311.getCreationList()));
    L31:
        p("origin size: " + r101.size());
        HashSet r107 = new HashSet();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r101.iterator();
    L33:
        if (r109.hasNext() == false) goto L37;
        Object r110 = r109.next();
        if (r107.add(((UserCreationModelKmp) r110).getModelId()) == false) goto L33;
        r108.add(r110);
        goto L33
    L37:
        final ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r112 = r108.iterator();
    L39:
        if (r112.hasNext() == false) goto L52;
        Object r113 = r112.next();
        int r114 = r105 + 1;
        if (r105 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        UserCreationModelKmp r115 = (UserCreationModelKmp) r113;
        List<UserCreationKmp> r116 = r115.getCreationList();
        if (r116 == null) goto L50;
        List<UserCreationKmp> r117 = r116;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r119 = r117.iterator();
    L47:
        if (r119.hasNext() == false) goto L49;
        r118.add(w.a((UserCreationKmp) r119.next(), r114));
        goto L47
    L49:
        List r120 = CollectionsKt.toMutableList(r118);
    L51:
        UserCreationModelKmp r121 = UserCreationModelKmp.copy$default(r115, 0, r120, null, 5, null);
        m0a.o.a(r121);
        r111.add(r121);
        r105 = r114;
        goto L39
    L50:
        r120 = null;
        goto L51
    L52:
        p("final size: " + r111.size());
        if (r312 == true) goto L76;
        if (r313 == true) goto L76;
        if ((!r100.f516613a.isEmpty()) == false) goto L76;
        if ((!r111.isEmpty()) == false) goto L76;
        List r122 = CollectionsKt.take(r100.f516613a, r111.size());
        ArrayList r123 = new ArrayList();
        Iterator r124 = r122.iterator();
    L61:
        if (r124.hasNext() == false) goto L66;
        List<UserCreationKmp> r125 = ((UserCreationModelKmp) r124.next()).getCreationList();
        if (r125 != null) goto L65;
        r125 = CollectionsKt.emptyList();
    L65:
        CollectionsKt.addAll(r123, r125);
        goto L61
    L66:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r111.iterator();
    L68:
        if (r127.hasNext() == false) goto L73;
        List<UserCreationKmp> r128 = ((UserCreationModelKmp) r127.next()).getCreationList();
        if (r128 != null) goto L72;
        r128 = CollectionsKt.emptyList();
    L72:
        CollectionsKt.addAll(r126, r128);
        goto L68
    L73:
        boolean r129 = i(r123, r126);
        p("blockRefresh: " + r129);
        if (r129 == false) goto L76;
        return;
    L76:
        Function1<? super n0a.a, n0a.a> r130 = new m(r310, this, r100, r111);
        if (r313 == false) goto L79;
        this.f374565b.b(r130);
        return;
    L79:
        this.f374565b.update(r130);
        return;
    L19:
        List<List<UserCreationKmp>> r131 = r311.getCreationGroupList();
        if (r131 == null) goto L29;
        List<List<UserCreationKmp>> r132 = r131;
        ?? r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));
        Iterator r134 = r132.iterator();
    L23:
        if (r134.hasNext() == false) goto L30;
        List r135 = (List) r134.next();
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator r137 = r135.iterator();
    L26:
        if (r137.hasNext() == false) goto L28;
        r136.add(UserCreationKmp.copy$default((UserCreationKmp) r137.next(), null, 0, null, null, null, null, null, null, null, null, null, null, null, f(r310, r103), null, null, null, 122879, null));
        goto L26
    L28:
        UserCreationModelKmp r138 = new UserCreationModelKmp(2, CollectionsKt.toMutableList(r136), null, 4, null);
        m0a.o.a(r138);
        r133.add(r138);
    L30:
        r101.addAll((Collection) r133);
        goto L31
    L29:
        r133 = CollectionsKt.emptyList();
        goto L30
    L12:
        if (r104.isEmpty() == true) goto L15;
        r106 = false;
        goto L17
    L8:
        r103 = null;
        goto L9
    }
}
