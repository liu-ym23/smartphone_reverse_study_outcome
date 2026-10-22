package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.hybrid.list.util.l;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JR\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ3\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00022!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0014J)\u0010\u0003\u001a\u00020\u00112!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0014JG\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0014J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R2\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010'\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\u0017\u0010<\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R(\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010H\u001a\u0004\b\u0013\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010H\u001a\u0004\bT\u0010I\"\u0004\bU\u0010KR(\u0010W\u001a\b\u0012\u0004\u0012\u00020V0@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010C\u001a\u0004\bX\u0010E\"\u0004\bY\u0010GR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010H\u001a\u0004\b[\u0010I\"\u0004\b\\\u0010KR\u0017\u0010]\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b]\u0010 \u001a\u0004\b^\u0010\"R$\u0010_\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010H\u001a\u0004\be\u0010I\"\u0004\bf\u0010KR\"\u0010g\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010m\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010H\u001a\u0004\bn\u0010I\"\u0004\bo\u0010KR\"\u0010p\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010H\u001a\u0004\bq\u0010I\"\u0004\br\u0010KR$\u0010s\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010 \u001a\u0004\bt\u0010\"\"\u0004\bu\u0010$¨\u0006x"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/MixFrameViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "loadMore", "", "", "", "mixFrameApiConfig", "url", "apiParams", "", "paramsKeyList", "", "tabID", "anchorTab", "Lok3/a;", "tabKitMonitor", "", "init", "isRefresh", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "callback", "initFetch", "showEmpty", "apiConfig", "fetchMixFrameData", "status", "reportMonitorPageShow", "mixFrameUrl", "Ljava/lang/String;", "getMixFrameUrl", "()Ljava/lang/String;", "setMixFrameUrl", "(Ljava/lang/String;)V", "", "mixFrameApiParams", "Ljava/util/Map;", "getMixFrameApiParams", "()Ljava/util/Map;", "setMixFrameApiParams", "(Ljava/util/Map;)V", "apiParamsKeyList", "Ljava/util/List;", "getApiParamsKeyList", "()Ljava/util/List;", "setApiParamsKeyList", "(Ljava/util/List;)V", "appendAPIParamsKeyList", "getAppendAPIParamsKeyList", "setAppendAPIParamsKeyList", "passThroghParams", "getPassThroghParams", "setPassThroghParams", "paramsMap", "getParamsMap", "setParamsMap", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "hybridListSession", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "getHybridListSession", "()Lcom/bytedance/android/ec/hybrid/list/util/l;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/shopping/store/tabkit/mixframe/ECTabKitMixFrameResponse;", "response", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getResponse", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setResponse", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "Z", "()Z", "setRefresh", "(Z)V", "", "cursor", "J", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "getHasMore", "setHasMore", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "getLoadStatus", "setLoadStatus", "fetchLock", "getFetchLock", "setFetchLock", "sceneId", "getSceneId", "tabMonitor", "Lok3/a;", "getTabMonitor", "()Lok3/a;", "setTabMonitor", "(Lok3/a;)V", "isAnchorTab", "setAnchorTab", "tabId", "I", "getTabId", "()I", "setTabId", "(I)V", "hasReportMonitor", "getHasReportMonitor", "setHasReportMonitor", "firstRequestSuccess", "getFirstRequestSuccess", "setFirstRequestSuccess", "noMoreText", "getNoMoreText", "setNoMoreText", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MixFrameViewModel extends BaseViewModel {
    private List<String> apiParamsKeyList;
    private List<String> appendAPIParamsKeyList;
    private long cursor;
    private boolean fetchLock;
    private boolean firstRequestSuccess;
    private boolean hasMore;
    private boolean hasReportMonitor;
    private final l hybridListSession;
    private boolean isAnchorTab;
    private boolean isRefresh;
    private QLiveData<LoadStatus> loadStatus;
    private Map<String, ? extends Object> mixFrameApiParams;
    private String mixFrameUrl;
    private String noMoreText;
    private Map<String, String> paramsMap;
    private Map<String, String> passThroghParams;
    private QLiveData<ECTabKitMixFrameResponse> response;
    private final String sceneId;
    private int tabId;
    private ok3.a tabMonitor;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MixFrameViewModel a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ boolean c;

        public a(MixFrameViewModel r1, Function1 r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            ECTabKitMixFrameResponse r8 = (ECTabKitMixFrameResponse) r7;
            this.b.invoke(Boolean.TRUE);
            String r3 = null;
            if (this.a.getHasReportMonitor() == true) goto L16;
            if (this.a.isAnchorTab() == false) goto L11;
            ok3.a r0 = this.a.getTabMonitor();
            if (r0 == null) goto L14;
            TabkitFirstFramePref r1 = r0.d;
            if (r1 == null) goto L14;
            TabkitFramePref.recordTime$default(r1, "t_tab_request_end", null, 2, null);
        L14:
            this.a.setHasReportMonitor(true);
            goto L16
        L11:
            ok3.a r2 = this.a.getTabMonitor();
            if (r2 == null) goto L14;
            TabkitFramePref.recordTime$default(r2.c(this.a.getTabId()), "t_tab_request_end", null, 2, null);
        L16:
            if (r8.getStatusCode() == 0) goto L18;
            this.a.getLoadStatus().g(LoadStatus.InitializeError);
            this.a.reportMonitorPageShow(2);
            return;
        L18:
            MixFrameViewModel r4 = this.a;
            r4.setCursor(r4.getCursor());
            if (this.c == false) goto L39;
            HybridListDTO r5 = r8.getHybridList();
            if (r5 == null) goto L35;
            List<SectionDTO> r6 = r5.getSections();
            if (r6 == null) goto L35;
            if ((!r6.isEmpty()) == true) goto L28;
            r6 = null;
        L28:
            if (r6 == null) goto L35;
            SectionDTO r9 = (SectionDTO) ListProtector.get(r6, 0);
            if (r9 == null) goto L35;
            ArrayList<ItemDTO> r10 = r9.getItems();
            if (r10 == null) goto L35;
            if (r10.isEmpty() == false) goto L39;
        L35:
            this.a.setFetchLock(false);
            this.a.getLoadStatus().g(LoadStatus.InitializeEmpty);
            this.a.reportMonitorPageShow(5);
            MixFrameViewModel r11 = this.a;
            BizConfig r12 = r8.getBizConfig();
            if (r12 == null) goto L38;
            r3 = r12.getNoMoreText();
        L38:
            r11.setNoMoreText(r3);
            return;
        L39:
            this.a.setFirstRequestSuccess(true);
            this.a.getLoadStatus().g(LoadStatus.InitializeSuccess);
            this.a.setCursor(r8.getCursor());
            this.a.setHasMore(r8.getHasMore());
            this.a.getResponse().g(r8);
            MixFrameViewModel r13 = this.a;
            BizConfig r14 = r8.getBizConfig();
            if (r14 == null) goto L42;
            r3 = r14.getNoMoreText();
        L42:
            r13.setNoMoreText(r3);
            this.a.setPassThroghParams(r8.getPassThroughParams());
            if (this.a.getHasMore() == true) goto L48;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MixFrameViewModel a;

        public b(MixFrameViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getLoadStatus().g(LoadStatus.InitializeError);
            this.a.reportMonitorPageShow(2);
            this.a.setFetchLock(false);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ MixFrameViewModel a;

        public c(MixFrameViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.setFetchLock(false);
            l r0 = this.a.getHybridListSession();
            r0.d = Long.valueOf(new Date().getTime());
        }
    }

    public MixFrameViewModel() {
        super(null, null, 3, null);
        this.hybridListSession = new l();
        this.response = new QLiveData();
        this.hasMore = true;
        this.loadStatus = new QLiveData();
        this.sceneId = UUID.randomUUID().toString();
        this.isAnchorTab = true;
    }

    public final List<String> getApiParamsKeyList() {
        return this.apiParamsKeyList;
    }

    public final List<String> getAppendAPIParamsKeyList() {
        return this.appendAPIParamsKeyList;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getFetchLock() {
        return this.fetchLock;
    }

    public final boolean getFirstRequestSuccess() {
        return this.firstRequestSuccess;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasReportMonitor() {
        return this.hasReportMonitor;
    }

    public final l getHybridListSession() {
        return this.hybridListSession;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final Map<String, Object> getMixFrameApiParams() {
        return this.mixFrameApiParams;
    }

    public final String getMixFrameUrl() {
        return this.mixFrameUrl;
    }

    public final String getNoMoreText() {
        return this.noMoreText;
    }

    public final Map<String, String> getParamsMap() {
        return this.paramsMap;
    }

    public final Map<String, String> getPassThroghParams() {
        return this.passThroghParams;
    }

    public final QLiveData<ECTabKitMixFrameResponse> getResponse() {
        return this.response;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final ok3.a getTabMonitor() {
        return this.tabMonitor;
    }

    public final boolean isAnchorTab() {
        return this.isAnchorTab;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    private final Map<String, Object> mixFrameApiConfig(boolean r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, ? extends Object> r1 = this.mixFrameApiParams;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        List<String> r3 = this.apiParamsKeyList;
        if (r3 == null) goto L15;
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L15;
        String r5 = (String) r4.next();
        Map<String, String> r7 = this.paramsMap;
        if (r7 == null) goto L9;
        String r8 = r7.get(r5);
        if (r8 == null) goto L9;
        r2.put(r5, r8);
    L15:
        r0.putAll(r2);
        if (r6 == false) goto L30;
        LinkedHashMap r9 = new LinkedHashMap();
        List<String> r10 = this.appendAPIParamsKeyList;
        if (r10 == null) goto L27;
        Iterator<T> r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L27;
        String r12 = (String) r11.next();
        Map<String, String> r13 = this.paramsMap;
        if (r13 == null) goto L21;
        String r14 = r13.get(r12);
        if (r14 == null) goto L21;
        r9.put(r12, r14);
    L27:
        r0.putAll(r9);
        Map<String, String> r15 = this.passThroghParams;
        if (r15 == null) goto L30;
        r0.putAll(r15);
    L30:
        Map<String, String> r16 = this.paramsMap;
        if (r16 == null) goto L33;
        String r17 = r16.get("feed_back");
    L34:
        r0.put("feed_back", r17);
        return r0;
    L33:
        r17 = null;
        goto L34
    }

    public final void loadMore(Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (this.fetchLock == false) goto L5;
        return;
    L5:
        if (this.hasMore == false) goto L10;
        this.fetchLock = true;
        this.loadStatus.g(LoadStatus.LoadMoreIn);
        l r1 = this.hybridListSession;
        r1.c = Long.valueOf(new Date().getTime());
        fetchMixFrameData(false, mixFrameApiConfig(true), r5);
        return;
    }

    public final void reportMonitorPageShow(int r6) {
        if (this.isAnchorTab == false) goto L9;
        ok3.a r0 = this.tabMonitor;
        if (r0 == null) goto L13;
        TabkitFirstFramePref r1 = r0.d;
        if (r1 == null) goto L13;
        TabkitFramePref.recordTime$default(r1, "t_page_show", null, 2, null);
    L13:
        if (this.isAnchorTab == false) goto L17;
        ok3.a r2 = this.tabMonitor;
        if (r2 == null) goto L21;
        Map<Long, TabkitFirstFramePref> r3 = ok3.a.e;
        r2.e(r6, null, null);
        return;
    L21:
        return;
    L17:
        ok3.a r4 = this.tabMonitor;
        if (r4 == null) goto L23;
        int r5 = this.tabId;
        Map<Long, TabkitFirstFramePref> r7 = ok3.a.e;
        r4.f(r5, r6, null, null);
        return;
    L23:
        return;
    L9:
        ok3.a r8 = this.tabMonitor;
        if (r8 == null) goto L13;
        TabkitFramePref.recordTime$default(r8.c(this.tabId), "t_page_show", null, 2, null);
        goto L13
    }

    public final void setAnchorTab(boolean r1) {
        this.isAnchorTab = r1;
    }

    public final void setApiParamsKeyList(List<String> r1) {
        this.apiParamsKeyList = r1;
    }

    public final void setAppendAPIParamsKeyList(List<String> r1) {
        this.appendAPIParamsKeyList = r1;
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setFetchLock(boolean r1) {
        this.fetchLock = r1;
    }

    public final void setFirstRequestSuccess(boolean r1) {
        this.firstRequestSuccess = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setHasReportMonitor(boolean r1) {
        this.hasReportMonitor = r1;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadStatus = r2;
    }

    public final void setMixFrameApiParams(Map<String, ? extends Object> r1) {
        this.mixFrameApiParams = r1;
    }

    public final void setMixFrameUrl(String r1) {
        this.mixFrameUrl = r1;
    }

    public final void setNoMoreText(String r1) {
        this.noMoreText = r1;
    }

    public final void setParamsMap(Map<String, String> r1) {
        this.paramsMap = r1;
    }

    public final void setPassThroghParams(Map<String, String> r1) {
        this.passThroghParams = r1;
    }

    public final void setRefresh(boolean r1) {
        this.isRefresh = r1;
    }

    public final void setResponse(QLiveData<ECTabKitMixFrameResponse> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.response = r2;
    }

    public final void setTabId(int r1) {
        this.tabId = r1;
    }

    public final void setTabMonitor(ok3.a r1) {
        this.tabMonitor = r1;
    }

    public final void initFetch(boolean r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (this.fetchLock == false) goto L5;
        return;
    L5:
        this.fetchLock = true;
        this.loadStatus.g(LoadStatus.Initialize);
        this.hybridListSession.c = Long.valueOf(new Date().getTime());
        fetchMixFrameData(!r4, mixFrameApiConfig(false), r5);
        if (r4 == true) goto L11;
        ok3.a r6 = this.tabMonitor;
        if (r6 == null) goto L12;
        TabkitFramePref.recordTime$default(r6.c(this.tabId), "t_tab_request_start", null, 2, null);
        return;
    L12:
        return;
    }

    public final void fetchMixFrameData(boolean r5, Map<String, Object> r6, Function1<? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "apiConfig");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r0 = this.mixFrameUrl;
        if (r0 != null) goto L5;
        return;
    L5:
        TabKitMixFrameApi.a.getClass();
        TabKitMixFrameApi r1 = TabKitMixFrameApi.a.a;
        if (r1 == null) goto L15;
        Observable<ECTabKitMixFrameResponse> r8 = r1.getMixFrameData(r0, Long.valueOf(this.cursor), (HashMap) r6);
        if (r8 == null) goto L16;
        Observable r9 = bg4.b.b(r8);
        if (r9 == null) goto L17;
        Disposable r10 = r9.subscribe(new a(this, r7, r5), new b(this), new c(this));
        if (r10 == null) goto L18;
        com.bytedance.android.ec.core.async.a.a(r10, this);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static /* synthetic */ void initFetch$default(MixFrameViewModel r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.initFetch(r1, r2);
    }

    public final void init(String r1, Map<String, Object> r2, List<String> r3, int r4, boolean r5, ok3.a r6) {
        this.mixFrameUrl = r1;
        this.mixFrameApiParams = r2;
        this.apiParamsKeyList = r3;
        this.tabMonitor = r6;
        this.isAnchorTab = r5;
        this.tabId = r4;
        initFetch(false, AnonymousClass1.INSTANCE);
    }
}
