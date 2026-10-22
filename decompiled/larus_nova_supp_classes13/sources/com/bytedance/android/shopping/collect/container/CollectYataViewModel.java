package com.bytedance.android.shopping.collect.container;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.collect.repo.CollectYataQueryFetcher;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ8\u0010\u0016\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00140\u0012J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0006\u0010\u001a\u001a\u00020\u0005J2\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0013\u00102\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/collect/container/CollectYataState;", "Lcom/bytedance/android/shopping/collect/repo/a;", "queryState", "", "showPageState", "", "", "getCommonTrackerParams", "defaultState", "Lub3/a;", "getCollectCustomDataCenter", "Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "collectParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "customDataCenter", "Lkotlin/Function0;", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "Lcom/bytedance/kmp/ec/yata/YaTaInstance;", "yataInstance", "init", "Lcom/bytedance/android/shopping/collect/container/CollectYataQueryFrom;", "queryFrom", "requestQuery", "release", "name", "", "params", "duplicateKey", "doEventAction", "Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "getCollectParams", "()Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "setCollectParams", "(Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;)V", "collectCustomDataCenter", "Lub3/a;", "Lcom/bytedance/android/shopping/collect/repo/CollectYataQueryFetcher;", "queryFetcher", "Lcom/bytedance/android/shopping/collect/repo/CollectYataQueryFetcher;", "Ltb3/b;", "trackerImpl", "Ltb3/b;", "btmPageFinder", "Lcom/bytedance/android/btm/api/model/PageFinder;", "Lpb3/a;", "getMonitorManager", "()Lpb3/a;", "monitorManager", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectYataViewModel extends JediViewModel<CollectYataState> {
    private PageFinder btmPageFinder;
    private ub3.a collectCustomDataCenter;
    private CollectParams collectParams;
    private CollectYataQueryFetcher queryFetcher;
    private final tb3.b trackerImpl;

    private final Map<String, String> getCommonTrackerParams() {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r0[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "collect_list_page");
        CollectParams r1 = this.collectParams;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getPreviousPage();
        if (r3 == null) goto L6;
    L7:
        r0[2] = TuplesKt.to("previous_page", r3);
        CollectParams r4 = this.collectParams;
        if (r4 == null) goto L10;
        String r5 = r4.getSession_id();
    L11:
        if (r5 == null) goto L14;
        r2 = r5;
    L14:
        r0[3] = TuplesKt.to("session_id", r2);
        return MapsKt.mapOf(r0);
    L10:
        r5 = null;
    L6:
        r3 = "";
        goto L7
    }

    public CollectYataState defaultState() {
        return new CollectYataState(null, null);
    }

    public final pb3.a getMonitorManager() {
        CollectYataQueryFetcher r0 = this.queryFetcher;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final void release() {
        CollectYataQueryFetcher r0 = this.queryFetcher;
        if (r0 == null) goto L8;
        r0.c = null;
        Disposable r1 = r0.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    L9:
        return;
    }

    public CollectYataViewModel() {
        CollectCommonLog.c("CollectYataViewModel", "init");
        this.trackerImpl = new tb3.b();
    }

    public final ub3.a getCollectCustomDataCenter() {
        return this.collectCustomDataCenter;
    }

    public final CollectParams getCollectParams() {
        return this.collectParams;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m661defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ CollectYataQueryFetcher access$getQueryFetcher$p(CollectYataViewModel r0) {
        return r0.queryFetcher;
    }

    private final void showPageState(final com.bytedance.android.shopping.collect.repo.a r3) {
        a r0 = r3.c;
        if (r0 == null) goto L5;
        CollectYataSkeletonLoadingStatus r1 = r0.b;
    L6:
        if (r1 == null) goto L14;
        int r2 = e.a[r1.ordinal()];
        if (r2 != 1) goto L11;
        setState(new AnonymousClass1(this, r3));
        return;
    L11:
        if (r2 != 2) goto L13;
        final d r4 = r3.b;
        if (r4 == null) goto L23;
        setState(new CollectYataViewModel$showPageState$$inlined$also$lambda$1(r4, this, r3));
        return;
    L23:
        return;
    L13:
        if (r2 != 3) goto L14;
        setState(new AnonymousClass3(r3));
        return;
    L14:
        CollectCommonLog.c("CollectYataViewModel", "errorStatus");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void requestQuery(CollectYataQueryFrom r3) {
        Intrinsics.checkNotNullParameter(r3, "queryFrom");
        if (r3 != CollectYataQueryFrom.FIRST_ENTER) goto L5;
        int r0 = tb3.a.a;
        tb3.a.a("start", MapsKt.emptyMap(), this);
    L5:
        CollectYataQueryFetcher r1 = this.queryFetcher;
        if (r1 == null) goto L9;
        r1.b(r3, this);
        return;
    }

    public final void setCollectParams(CollectParams r1) {
        this.collectParams = r1;
    }

    public static final /* synthetic */ void access$setQueryFetcher$p(CollectYataViewModel r0, CollectYataQueryFetcher r1) {
        r0.queryFetcher = r1;
    }

    public static final /* synthetic */ void access$showPageState(CollectYataViewModel r0, com.bytedance.android.shopping.collect.repo.a r1) {
        r0.showPageState(r1);
    }

    public final void doEventAction(String r5, Map<String, ? extends Object> r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "params");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(getCommonTrackerParams());
        r2.putAll(r6);
        tb3.b r8 = this.trackerImpl;
        PageFinder r3 = this.btmPageFinder;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r2, "params");
        if (k.c(r7) == true) goto L5;
    L7:
        if (r7 == null) goto L9;
        r8.b.add(r7);
    L9:
        LinkedHashMap r9 = new LinkedHashMap();
        r9.putAll(r8.c);
        r9.putAll(r2);
        r8.a.doEventAction(r5, r3, r9);
        return;
    L5:
        if (CollectionsKt.contains(r8.b, r7) == false) goto L7;
    }

    public final void init(CollectParams r2, PageFinder r3, ub3.a r4, Function0<AndroidYaTaInstance> r5) {
        Intrinsics.checkNotNullParameter(r3, "pageFinder");
        Intrinsics.checkNotNullParameter(r5, "yataInstance");
        this.collectCustomDataCenter = r4;
        this.collectParams = r2;
        this.btmPageFinder = r3;
        if (r2 == null) goto L5;
        CollectYataQueryFetcher r6 = new CollectYataQueryFetcher(r2);
    L6:
        this.queryFetcher = r6;
        if (r6 == null) goto L9;
        r6.c = new AnonymousClass2(this);
    L9:
        CollectYataQueryFetcher r7 = this.queryFetcher;
        if (r7 == null) goto L13;
        Intrinsics.checkNotNullParameter(r5, "yataInstance");
        r7.e = r5;
        return;
    L13:
        return;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doEventAction$default(CollectYataViewModel r0, String r1, Map r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = MapsKt.emptyMap();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.doEventAction(r1, r2, r3);
    }
}
