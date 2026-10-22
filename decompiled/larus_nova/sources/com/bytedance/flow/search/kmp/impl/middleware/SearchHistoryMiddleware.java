package com.bytedance.flow.search.kmp.impl.middleware;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.DividerPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryAction;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryItem;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryList;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryPayload;
import com.bytedance.flow.search.kmp.api.store.SearchLoadingState;
import com.larus.im.internal.delegate.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchHistoryMiddleware extends aw5.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f243580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<FlowQuery> f243581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f243582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f243583f;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Object r100 = this.f243580c;
        monitor-enter(r100);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.f243583f == false) goto L34;
        monitor-exit(r100);
        return;
    L34:
        String r101 = "aggregate_search_history_cache_" + com.larus.im.internal.delegate.b.f348193b.getUserId();     // Catch: Exception -> L26 Throwable -> L31
        if (com.flow.kmp.common.thread.a.a() == false) goto L14;
        Object r102 = ((gb6.c) this.f243582e.getValue()).getString(r101, "");     // Catch: Exception -> L26 Throwable -> L31
        if (r102 != null) goto L15;
        r102 = "";
    L15:
        String r103 = (String) r102;     // Catch: Exception -> L26 Throwable -> L31
        if ((!StringsKt.isBlank(r103)) == false) goto L24;
        ouc.a.C7114a r104 = ouc.a.f526798d;     // Catch: Exception -> L26 Throwable -> L31
        r104.getClass();     // Catch: Exception -> L26 Throwable -> L31
        List r105 = (List) r104.c(new nuc.f(FlowQuery.Companion.serializer()), r103);     // Catch: Exception -> L26 Throwable -> L31
        this.f243581d.clear();     // Catch: Exception -> L26 Throwable -> L31
        ArrayDeque<FlowQuery> r106 = this.f243581d;     // Catch: Exception -> L26 Throwable -> L31
        ArrayList r107 = new ArrayList();     // Catch: Exception -> L26 Throwable -> L31
        Iterator r108 = r105.iterator();     // Catch: Exception -> L26 Throwable -> L31
    L19:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();     // Catch: Exception -> L26 Throwable -> L31
        if ((!StringsKt.isBlank(((FlowQuery) r109).f243270a)) == false) goto L19;
        r107.add(r109);     // Catch: Exception -> L26 Throwable -> L31
        goto L19
    L23:
        r106.addAll(CollectionsKt.take(r107, this.f243579b));     // Catch: Exception -> L26 Throwable -> L31
    L24:
        c0.f348199b.i("SearchHistoryMW", "ensureHistoryLoaded: key=" + r101 + ", rawLength=" + r103.length() + ", historySize=" + this.f243581d.size());     // Catch: Exception -> L26 Throwable -> L31
    L28:
        this.f243583f = true;     // Catch: Throwable -> L31
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r100);
        return;
    L14:
        r102 = BuildersKt.runBlocking(Dispatchers.getMain(), new SearchHistoryMiddleware$ensureHistoryLoaded$lambda$14$$inlined$runOnMainThreadIfNeed$1(null, this, r101));     // Catch: Exception -> L26 Throwable -> L31
    L26:
        e = move-exception;
        c0.f348199b.e("SearchHistoryMW", "ensureHistoryLoaded failed, clearing history: " + e.getMessage());     // Catch: Throwable -> L31
        this.f243581d.clear();     // Catch: Throwable -> L31
        h(this);     // Catch: Throwable -> L31
        goto L28
    }

    public SearchHistoryMiddleware(int r100) {
        this.f243579b = 50;
        this.f243580c = new Object();
        this.f243581d = new ArrayDeque();
        this.f243582e = LazyKt.lazy(new l());
    }

    public static aw5.d b(aw5.c r210) {
        List<FlowSearchData> r100 = r210.f16542b.get("history");
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        c0.f348199b.i("SearchHistoryMW", "buildEmptyHistoryUpdate: existingItems=" + r100.size());
        SearchLoadingState r101 = null;
        Map r102 = null;
        List<FlowSearchData> r103 = r100;
        if (r103.isEmpty() == false) goto L9;
        r103 = null;
    L9:
        return new aw5.d(r101, r102, r103, false, null, null, null, false, false, null, null, null, null, null, 1048571);
    }

    public static FlowQuery f(FlowQuery r110) {
        if (r110.f243271b.isEmpty() == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return new FlowQuery(r110.f243270a, CollectionsKt.emptyList(), 1, null, null, null);
    L12:
        return new FlowQuery(r110.f243270a, r110.f243271b, 1, null, r110.f243274e, null);
    L5:
        if (Intrinsics.areEqual(r110.f243271b, aw5.e.f16575a) == true) goto L8;
        r100 = false;
        goto L9
    }

    public static /* synthetic */ void h(SearchHistoryMiddleware r100) {
        Object r101 = r100.f243580c;
        monitor-enter(r101);
        List<FlowQuery> r102 = CollectionsKt.toList(r100.f243581d);     // Catch: Throwable -> L8
        monitor-exit(r101);
        r100.g(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean j(aw5.c r100) {
        FlowQuery r101 = r100.f16547g;
        if (r101 != null) goto L5;
        return true;
    L5:
        boolean r102 = StringsKt.isBlank(r101.f243270a);
        if (r101.f243271b.size() <= 1) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r102 == false) goto L15;
        if (r103 == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        if (r101.f243271b.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public final void g(List<FlowQuery> r100) {
        String r101 = "aggregate_search_history_cache_" + com.larus.im.internal.delegate.b.f348193b.getUserId();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        ouc.a.C7114a r103 = ouc.a.f526798d;     // Catch: Throwable -> L5
        r103.getClass();     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(r103.a(new nuc.f(FlowQuery.Companion.serializer()), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L11;
        r104 = "[]";
    L11:
        String r105 = (String) r104;
        if (com.flow.kmp.common.thread.a.a() == false) goto L14;
        ((gb6.c) this.f243582e.getValue()).storeString(r101, r105);
    L15:
        c0.f348199b.i("SearchHistoryMW", "persistHistory: key=" + r101 + ", historySize=" + r100.size() + ", jsonLength=" + r105.length());
        return;
    L14:
        BuildersKt.runBlocking(Dispatchers.getMain(), new SearchHistoryMiddleware$persistHistory$$inlined$runOnMainThreadIfNeed$1(null, this, r101, r105));
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void i(final FlowQuery r100) {
        if (StringsKt.isBlank(r100.f243270a) == false) goto L5;
        return;
    L5:
        Object r101 = this.f243580c;
        monitor-enter(r101);
        CollectionsKt.removeAll(this.f243581d, new n(r100, this));     // Catch: Throwable -> L15
        this.f243581d.addFirst(r100);     // Catch: Throwable -> L15
    L9:
        if (this.f243581d.size() <= this.f243579b) goto L11;
        this.f243581d.removeLast();     // Catch: Throwable -> L15
        goto L9
    L11:
        List<FlowQuery> r102 = CollectionsKt.toList(this.f243581d);     // Catch: Throwable -> L15
        monitor-exit(r101);
        g(r102);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean e(Map r100, Map r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        String r103 = null;
        if (r102 == false) goto L12;
    L21:
        boolean r104 = true;
    L22:
        if (r101 != null) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == false) goto L30;
    L38:
        boolean r106 = true;
    L40:
        if (Intrinsics.areEqual(r100, r101) == true) goto L43;
        if (r104 == false) goto L45;
        if (r106 == true) goto L43;
        return false;
    L45:
        return false;
    L43:
        return true;
    L30:
        if (r101.size() != 1) goto L37;
        List r107 = (List) r101.get("search_range");
        if (r107 == null) goto L35;
        r103 = (String) CollectionsKt.firstOrNull(r107);
    L35:
        if (Intrinsics.areEqual(r103, "no_limit") == true) goto L38;
    L37:
        r106 = false;
        goto L40
    L24:
        if (r101.isEmpty() == true) goto L27;
        r105 = false;
        goto L28
    L12:
        if (r100.size() != 1) goto L20;
        List r108 = (List) r100.get("search_range");
        if (r108 == null) goto L16;
        String r109 = (String) CollectionsKt.firstOrNull(r108);
    L18:
        if (Intrinsics.areEqual(r109, "no_limit") == false) goto L20;
    L16:
        r109 = null;
    L20:
        r104 = false;
        goto L22
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // aw5.b
    public final Object a(aw5.a r110, com.bytedance.flow.search.kmp.impl.core.c r111) {
        d();
        boolean r100 = ((aw5.c) r111.invoke()).f16546f;
        boolean r101 = false;
        if ((r110 instanceof aw5.a.i) == false) goto L19;
        aw5.a.i r112 = (aw5.a.i) r110;
        boolean r102 = StringsKt.isBlank(r112.f16533a.f243270a);
        if (r112.f16533a.f243271b.size() <= 1) goto L7;
    L8:
        r101 = true;
    L9:
        c0.f348199b.i("SearchHistoryMW", "process: UpdateQuery keyword='" + r112.f16533a.f243270a + "', isIntermediate=" + r102 + ", isComprehensive=" + r101 + ", historySize=" + this.f243581d.size());
        if (r102 == false) goto L18;
        if (r101 == false) goto L18;
        if ((!this.f243581d.isEmpty()) == false) goto L99;
        return new kotlinx.coroutines.flow.n(c(((aw5.c) r111.invoke()).f16545e, r100, (aw5.c) r111.invoke()));
    L99:
        return kotlinx.coroutines.flow.d.f504845a;
    L18:
        return kotlinx.coroutines.flow.d.f504845a;
    L7:
        if (r112.f16533a.f243271b.isEmpty() == false) goto L9;
    L19:
        FlowQuery r103 = null;
        String r104 = null;
        r103 = null;
        if ((r110 instanceof aw5.a.d) == false) goto L48;
        c0 r105 = c0.f348199b;
        StringBuilder r106 = new StringBuilder("process: DeleteHistory deleteAll=");
        aw5.a.d r113 = (aw5.a.d) r110;
        r106.append(r113.f16526b);
        r106.append(", query=");
        FlowQuery r107 = r113.f16525a;
        if (r107 == null) goto L24;
        r104 = r107.f243270a;
    L24:
        r106.append(r104);
        r105.i("SearchHistoryMW", r106.toString());
        if (r113.f16526b == false) goto L35;
        Object r114 = this.f243580c;
        monitor-enter(r114);
        this.f243581d.clear();     // Catch: Throwable -> L32
        List<FlowQuery> r108 = CollectionsKt.toList(this.f243581d);     // Catch: Throwable -> L32
        monitor-exit(r114);
        g(r108);
        return new kotlinx.coroutines.flow.n(aw5.d.a(c(false, false, (aw5.c) r111.invoke()), Boxing.boxBoolean(false), Boxing.boxBoolean(false), true, true, 1042335));
    L32:
        th = move-exception;
        throw th;
    L35:
        FlowQuery r115 = r113.f16525a;
        if (r115 == null) goto L45;
        final FlowQuery r116 = f(r115);
        Object r109 = this.f243580c;
        monitor-enter(r109);
        CollectionsKt.removeAll(this.f243581d, new m(r116, this));     // Catch: Throwable -> L42
        List<FlowQuery> r117 = CollectionsKt.toList(this.f243581d);     // Catch: Throwable -> L42
        monitor-exit(r109);
        g(r117);
    L42:
        th = move-exception;
        throw th;
    L45:
        r105.i("SearchHistoryMW", "process: DeleteHistory after remove, historySize=" + this.f243581d.size());
        return new kotlinx.coroutines.flow.n(c(((aw5.c) r111.invoke()).f16545e, r100, (aw5.c) r111.invoke()));
    L48:
        if ((r110 instanceof aw5.a.h) == false) goto L52;
        c0 r118 = c0.f348199b;
        StringBuilder r119 = new StringBuilder("process: UpdateHistoryManageState isManaging=");
        aw5.a.h r120 = (aw5.a.h) r110;
        r119.append(r120.f16532a);
        r118.i("SearchHistoryMW", r119.toString());
        return new kotlinx.coroutines.flow.n(aw5.d.a(c(r120.f16532a, r100, (aw5.c) r111.invoke()), Boxing.boxBoolean(r120.f16532a), null, true, false, 1046495));
    L52:
        if ((r110 instanceof aw5.a.e) == false) goto L56;
        c0.f348199b.i("SearchHistoryMW", "process: ExpandHistory");
        return new kotlinx.coroutines.flow.n(aw5.d.a(c(((aw5.c) r111.invoke()).f16545e, true, (aw5.c) r111.invoke()), null, Boxing.boxBoolean(true), false, true, 1044415));
    L56:
        if ((r110 instanceof aw5.a.c) == false) goto L60;
        c0.f348199b.i("SearchHistoryMW", "process: CollapseHistory");
        return new kotlinx.coroutines.flow.n(aw5.d.a(c(((aw5.c) r111.invoke()).f16545e, false, (aw5.c) r111.invoke()), null, Boxing.boxBoolean(false), false, true, 1044415));
    L60:
        if ((r110 instanceof aw5.a.C0240a) == false) goto L70;
        FlowQuery r121 = ((aw5.c) r111.invoke()).f16547g;
        if (r121 == null) goto L99;
        i(f(r121));
        c0.f348199b.i("SearchHistoryMW", "process: ClickSearchButton recorded query='" + r121.f243270a + "', shouldShow=" + j((aw5.c) r111.invoke()));
        if (j((aw5.c) r111.invoke()) == true) goto L68;
        return new kotlinx.coroutines.flow.n(b((aw5.c) r111.invoke()));
    L68:
        return new kotlinx.coroutines.flow.n(c(((aw5.c) r111.invoke()).f16545e, r100, (aw5.c) r111.invoke()));
    L70:
        if ((r110 instanceof aw5.a.b) == false) goto L99;
        aw5.a.b r122 = (aw5.a.b) r110;
        aw5.c r123 = (aw5.c) r111.invoke();
        ISearchDataPayload r124 = r122.f16523a.f243281c;
        if ((r124 instanceof SearchHistoryPayload) == false) goto L85;
        Iterator<T> r125 = ((SearchHistoryPayload) r124).f243495i.f243492a.iterator();
    L75:
        if (r125.hasNext() == false) goto L79;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((SearchHistoryItem) r126).f243488c.f243482a, "replay_history") == false) goto L75;
    L80:
        SearchHistoryItem r127 = (SearchHistoryItem) r126;
        if (r127 == null) goto L86;
        SearchHistoryAction r128 = r127.f243488c;
        if (r128 == null) goto L86;
        r103 = r128.f243483b;
    L86:
        boolean r129 = r122.f16523a.f243281c instanceof SearchHistoryPayload;
        if (r103 == null) goto L99;
        c0 r130 = c0.f348199b;
        r130.i("SearchHistoryMW", "process: ClickSearchResult recorded query='" + r103.f243270a + "', isHistoryClick=" + r129 + ", shouldShow=" + j((aw5.c) r111.invoke()));
        if (r129 == true) goto L91;
        i(f(r103));
        r130.i("SearchHistoryMW", "process: ClickSearchResult recorded query='" + r103.f243270a + "', shouldShow=" + j((aw5.c) r111.invoke()));
        if (j((aw5.c) r111.invoke()) == true) goto L97;
        return new kotlinx.coroutines.flow.n(b((aw5.c) r111.invoke()));
    L97:
        return new kotlinx.coroutines.flow.n(c(((aw5.c) r111.invoke()).f16545e, r100, (aw5.c) r111.invoke()));
    L91:
        return kotlinx.coroutines.flow.d.f504845a;
    L79:
        r126 = null;
        goto L80
    L85:
        r103 = r123.f16547g;
        goto L86
    }

    public final aw5.d c(boolean r210, boolean r211, aw5.c r310) {
        List<FlowSearchData> r100 = r310.f16542b.get("history");
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        Object r101 = this.f243580c;
        monitor-enter(r101);
        List r102 = CollectionsKt.toList(this.f243581d);     // Catch: Throwable -> L94
        monitor-exit(r101);
        if (r102.isEmpty() == false) goto L17;
        c0.f348199b.i("SearchHistoryMW", "buildHistoryUpdate: history is empty, removing existingItems=" + r100.size());
        SearchLoadingState r103 = null;
        Map r104 = null;
        List<FlowSearchData> r105 = r100;
        if (r105.isEmpty() == false) goto L14;
        List<FlowSearchData> r106 = null;
    L16:
        return new aw5.d(r103, r104, r106, false, null, null, null, false, false, null, null, null, null, null, 1048571);
    L14:
        r106 = r105;
        goto L16
    L17:
        FlowSearchData[] r107 = new FlowSearchData[2];
        r107[0] = new FlowSearchData("history", 104, new DividerPayload());
        List r110 = r102;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L19:
        if (r112.hasNext() == false) goto L88;
        FlowQuery r113 = (FlowQuery) r112.next();
        String r114 = r113.f243270a;
        int r115 = r114.length();
        int r108 = 0;
        int r116 = 0;
    L21:
        if (r108 >= r115) goto L72;
        char r109 = r114.charAt(r108);
        if (19968 <= r109) goto L25;
    L27:
        boolean r117 = false;
    L28:
        if (r117 == false) goto L30;
    L66:
        int r118 = 2;
    L67:
        int r119 = r116 + r118;
        if (r119 > 20) goto L69;
        r108 = r108 + 1;
        r116 = r119;
        goto L21
    L69:
        r114 = r114.substring(0, r108) + "...";
        goto L72
    L30:
        if (13312 <= r109) goto L32;
    L34:
        boolean r120 = false;
    L35:
        if (r120 == true) goto L66;
        if (63744 <= r109) goto L39;
    L41:
        boolean r121 = false;
    L42:
        if (r121 == true) goto L66;
        if (0 <= r109) goto L46;
    L48:
        boolean r122 = false;
    L49:
        if (r122 == true) goto L66;
        if (65281 <= r109) goto L53;
    L55:
        boolean r123 = false;
    L56:
        if (r123 == true) goto L66;
        if (12288 <= r109) goto L60;
    L62:
        boolean r124 = false;
    L63:
        if (r124 == true) goto L66;
        r118 = 1;
        goto L67
    L60:
        if (r109 >= 12352) goto L62;
        r124 = true;
        goto L63
    L53:
        if (r109 >= 65377) goto L55;
        r123 = true;
        goto L56
    L46:
        if (r109 >= 42720) goto L48;
        r122 = true;
        goto L49
    L39:
        if (r109 >= 64256) goto L41;
        r121 = true;
        goto L42
    L32:
        if (r109 >= 19904) goto L34;
        r120 = true;
        goto L35
    L25:
        if (r109 >= 40960) goto L27;
        r117 = true;
    L72:
        if (r113.f243271b.size() != 1) goto L78;
        StringBuilder r125 = new StringBuilder();
        r125.append(r114);
        r125.append(" · ");
        int r126 = b.f243585a;
        String r127 = (String) CollectionsKt.firstOrNull(r113.f243271b);
        if (r127 != null) goto L76;
        r127 = "";
    L76:
        r125.append(b.b(r127));
        r114 = r125.toString();
    L78:
        if (r113.f243271b.isEmpty() == false) goto L80;
        String r128 = "all";
    L81:
        Map<String, List<String>> r129 = r113.f243274e;
        if (r129 == null) goto L84;
        String r130 = r129.toString();
    L85:
        if (r130 != null) goto L87;
        r130 = "";
    L87:
        r111.add(new SearchHistoryItem(r114, "domain=" + r128 + ";filter=" + r130, new SearchHistoryAction("replay_history", r113)));
        goto L19
    L84:
        r130 = null;
        goto L85
    L80:
        r128 = CollectionsKt.joinToString$default(r113.f243271b, ",", null, null, 0, null, null, 62, null);
        goto L81
    L88:
        r107[1] = new FlowSearchData("history", 101, new SearchHistoryPayload(new SearchHistoryList(r111), r210, r211));
        List r131 = CollectionsKt.listOf(r107);
        c0.f348199b.i("SearchHistoryMW", "buildHistoryUpdate: historySize=" + r102.size() + ", isManaging=" + r210 + ", isExpanded=" + r211 + ", existingItems=" + r100.size());
        List<FlowSearchData> r132 = r100;
        if (r132.isEmpty() == false) goto L91;
        List<FlowSearchData> r133 = null;
    L93:
        return new aw5.d(null, MapsKt.mapOf(TuplesKt.to("history", r131)), r133, false, null, null, null, false, false, null, null, null, null, null, 1048569);
    L91:
        r133 = r132;
    L94:
        th = move-exception;
        throw th;
    }
}
