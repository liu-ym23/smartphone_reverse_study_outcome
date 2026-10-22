package com.larus.livetutor.impl.history.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.livetutor.api.idl.FlashCardRecord;
import com.larus.livetutor.api.idl.Image;
import com.larus.livetutor.api.idl.LiveTutorRecord;
import com.larus.livetutor.api.idl.TutorEntranceType;
import com.larus.livetutor.api.idl.TutorSearchContent;
import com.larus.livetutor.impl.history.v;
import com.larus.livetutor.impl.home.data.LoadMoreState;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.livetutor.impl.repository.viewmodel.ITutorRefresh;
import com.larus.livetutor.impl.repository.viewmodel.LifecyclePageStateViewModel;
import com.larus.livetutor.impl.repository.viewmodel.PageStateViewModel;
import com.larus.livetutor.impl.utils.ApiCallConfig;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010#J2\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\r2\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\rH\u0002J\u001e\u0010)\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0002J(\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0.2\b\u0010,\u001a\u0004\u0018\u00010\n2\b\u00100\u001a\u0004\u0018\u00010\nH\u0002J\f\u00101\u001a\u00020\u0019*\u00020\u0006H\u0002J\u0006\u00102\u001a\u00020\u0002J\u0006\u00103\u001a\u00020\u001eJ\u0016\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\nJ\u0006\u00109\u001a\u00020\u001eJ\u0006\u0010:\u001a\u00020\u001eJ\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u0006R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/livetutor/impl/history/viewmodel/LiveTutorHistoryViewModel;", "Lcom/larus/livetutor/impl/repository/viewmodel/LifecyclePageStateViewModel;", "", "<init>", "()V", "cursorId", "", "Ljava/lang/Long;", "originHistoryList", "", "Lcom/larus/livetutor/impl/history/LiveTutorHistoryItem;", "historyData", "Landroidx/lifecycle/MutableLiveData;", "", "getHistoryData", "()Landroidx/lifecycle/MutableLiveData;", "hasMore", "isLoading", "_loadMoreState", "Lcom/larus/livetutor/impl/home/data/LoadMoreState;", "loadMoreState", "Landroidx/lifecycle/LiveData;", "getLoadMoreState", "()Landroidx/lifecycle/LiveData;", "actionBarId", "", "actionBarKey", "enterMethod", DyPayConstant.KEY_START_TIME, "initSchemeData", "", "startRefreshData", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/larus/livetutor/impl/repository/viewmodel/ITutorRefresh$RefreshStrategy;", "dataT", "(Lcom/larus/livetutor/impl/repository/viewmodel/ITutorRefresh$RefreshStrategy;Ljava/lang/Boolean;)V", "mergeHistoryList", "liveTutorList", "Lcom/larus/livetutor/api/idl/LiveTutorRecord;", "flashCardList", "Lcom/larus/livetutor/api/idl/FlashCardRecord;", "handleHistoryData", "newData", "insertTime", "lastItem", "initSectionRank", "Lkotlin/Pair;", "", "firstItem", "getDateString", "preCheckCanLoadMore", DitoNode.LOAD_MORE, "openTutor", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", MapController.ITEM_LAYER_TAG, "reportItemShow", "reportEnterPage", "reportLeavePage", "reportStayPage", "duration", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorHistoryViewModel extends LifecyclePageStateViewModel<Boolean> {
    public static final a Companion = null;
    private static final String HISTORY_ENTER_FROM = "live_tutor_home_page";
    private static final String HISTORY_PAGE_NAME = "history_records";
    private static final String TAG = "LiveTutorHistoryViewModel";
    private final MutableLiveData<LoadMoreState> _loadMoreState;
    private String actionBarId;
    private String actionBarKey;
    private Long cursorId;
    private String enterMethod;
    private boolean hasMore;
    private final MutableLiveData<List<v>> historyData;
    private boolean isLoading;
    private List<v> originHistoryList;
    private long startTime;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Long r102 = ((v) r101).a();
            long r103 = Long.MIN_VALUE;
            if (r102 == null) goto L5;
            long r104 = r102.longValue();
        L6:
            Long r105 = Long.valueOf(r104);
            Long r106 = ((v) r100).a();
            if (r106 == null) goto L10;
            r103 = r106.longValue();
        L10:
            return ComparisonsKt.compareValues(r105, Long.valueOf(r103));
        L5:
            r104 = Long.MIN_VALUE;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(LiveTutorHistoryViewModel r100, Boolean r101, ApiCallConfig r102) {
        return startRefreshData$lambda$0(r100, r101, r102);
    }

    public final void loadMore() {
        FLogger r100 = FLogger.f375446a;
        r100.i(TAG, "loadMore, hasMore = " + this.hasMore + ", isLoading = " + this.isLoading + ", loadMoreState = " + this._loadMoreState.getValue());
        if (this.hasMore == true) goto L6;
        this._loadMoreState.postValue(LoadMoreState.NoMore);
        r100.e(TAG, "loadMore no more data");
        return;
    L6:
        LoadMoreState r101 = this._loadMoreState.getValue();
        LoadMoreState r102 = LoadMoreState.Loading;
        if (r101 != r102) goto L11;
        r100.e(TAG, "loadMore loading");
        return;
    L11:
        if (NetworkUtils.isNetworkAvailable(UtilsKt.c()) == true) goto L14;
        r100.e(TAG, "loadMore no network");
        this._loadMoreState.setValue(LoadMoreState.Error);
        return;
    L14:
        this._loadMoreState.setValue(r102);
        startRefreshData2(ITutorRefresh.RefreshStrategy.ACTIVE_REFRESH, Boolean.TRUE);
    }

    public final boolean preCheckCanLoadMore() {
        if (this.hasMore == true) goto L5;
    L9:
        return false;
    L5:
        if (this.isLoading == true) goto L9;
        if (this._loadMoreState.getValue() != LoadMoreState.Success) goto L9;
        return true;
    }

    public final void reportEnterPage() {
        JSONObject r100 = new JSONObject();
        r100.put("enter_from", "live_tutor_home_page");
        r100.put("page_name", HISTORY_PAGE_NAME);
        this.startTime = System.currentTimeMillis();
        o.f365780a.reportEvent("live_tutor_enter_page", r100);
    }

    public final void reportLeavePage() {
        JSONObject r100 = new JSONObject();
        r100.put("enter_from", "live_tutor_home_page");
        r100.put("page_name", HISTORY_PAGE_NAME);
        r100.put("stay_duration", System.currentTimeMillis() - this.startTime);
        o.f365780a.reportEvent("live_tutor_leave_page", r100);
    }

    public LiveTutorHistoryViewModel() {
        this.originHistoryList = new ArrayList();
        this.historyData = new MutableLiveData();
        this.hasMore = true;
        this._loadMoreState = new MutableLiveData();
    }

    public final MutableLiveData<List<v>> getHistoryData() {
        return this.historyData;
    }

    public final LiveData<LoadMoreState> getLoadMoreState() {
        return this._loadMoreState;
    }

    public static final /* synthetic */ Long access$getCursorId$p(LiveTutorHistoryViewModel r100) {
        return r100.cursorId;
    }

    public static final /* synthetic */ boolean access$getHasMore$p(LiveTutorHistoryViewModel r100) {
        return r100.hasMore;
    }

    public static final /* synthetic */ MutableLiveData access$get_loadMoreState$p(LiveTutorHistoryViewModel r100) {
        return r100._loadMoreState;
    }

    private final String getDateString(long r100) {
        Date r101 = new Date(r100);
        Calendar r102 = Calendar.getInstance();
        r102.setTime(r101);
        Calendar r110 = Calendar.getInstance();
        SimpleDateFormat r103 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String r104 = r103.format(r110.getTime());
        String r105 = r103.format(r101);
        if (Intrinsics.areEqual(r104, r105) == true) goto L5;
        r110.add(6, -1);
        if (Intrinsics.areEqual(r103.format(r110.getTime()), r105) == true) goto L9;
        r110.setTime(new Date());
        r110.setFirstDayOfWeek(2);
        r102.setFirstDayOfWeek(2);
        int r106 = r110.get(3);
        int r107 = r110.get(1);
        int r108 = r102.get(3);
        int r109 = r102.get(1);
        if (r109 != r107) goto L15;
        if (r108 != r106) goto L15;
        StringBuilder r111 = new StringBuilder();
        r111.append(UtilsKt.c().getString(R.string.larus_tutor_this_cn));
        Intrinsics.checkNotNull(r102);
        r111.append(getDateString$dayOfWeek(r102));
        return r111.toString();
    L15:
        r110.add(3, -1);
        int r112 = r110.get(3);
        int r113 = r110.get(1);
        if (r109 != r107) goto L18;
        if (r108 != r112) goto L18;
    L20:
        StringBuilder r114 = new StringBuilder();
        r114.append(UtilsKt.c().getString(R.string.larus_tutor_last_cn));
        Intrinsics.checkNotNull(r102);
        r114.append(getDateString$dayOfWeek(r102));
        return r114.toString();
    L18:
        if (r109 != r113) goto L22;
        if (r108 == r112) goto L20;
    L22:
        String r115 = UtilsKt.c().getString(R.string.larus_tutor_year_cn);
        String r116 = UtilsKt.c().getString(R.string.larus_tutor_month_cn);
        String r117 = UtilsKt.c().getString(R.string.larus_tutor_day_cn);
        if (r109 != r107) goto L27;
        return new SimpleDateFormat("M" + r116 + Directory.UNIX_ID + r117, Locale.getDefault()).format(r101);
    L27:
        return new SimpleDateFormat("yyyy" + r115 + 'M' + r116 + Directory.UNIX_ID + r117, Locale.getDefault()).format(r101);
    L9:
        return UtilsKt.c().getString(R.string.larus_tutor_yesterday_cn);
    L5:
        return UtilsKt.c().getString(R.string.larus_tutor_today_cn);
    }

    private static final String getDateString$dayOfWeek(Calendar r100) {
        switch(r100.get(7)) {
            case 1: goto L12;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L4;
        };
    L4:
        return "";
    L14:
        return UtilsKt.c().getString(R.string.larus_tutor_saturday_cn);
    L15:
        return UtilsKt.c().getString(R.string.larus_tutor_friday_cn);
    L16:
        return UtilsKt.c().getString(R.string.larus_tutor_thursday_cn);
    L17:
        return UtilsKt.c().getString(R.string.larus_tutor_wednesday_cn);
    L18:
        return UtilsKt.c().getString(R.string.larus_tutor_tuesday_cn);
    L19:
        return UtilsKt.c().getString(R.string.larus_tutor_monday_cn);
    L12:
        return UtilsKt.c().getString(R.string.larus_tutor_sunday_cn);
    }

    private static final Long insertTime$getItemTimestamp(v r100) {
        Long r101 = r100.a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r101.longValue() * 1000);
    }

    public final void reportItemShow(v r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof v.d) == false) goto L5;
    L11:
        LiveTutorRecord r101 = r100.c();
        if (r101 == null) goto L14;
        Long r102 = r101.getTutorId();
    L15:
        Pair r103 = TuplesKt.to("learning_record_details", r102);
    L16:
        String r104 = (String) r103.component1();
        Long r105 = (Long) r103.component2();
        JSONObject r106 = new JSONObject();
        r106.put("enter_from", "live_tutor_home_page");
        r106.put("page_name", HISTORY_PAGE_NAME);
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r104);
        r106.put("record_id", r105);
        r106.put("photo_search_time", r100.a());
        r106.put("photo_search_section", r100.f356050a);
        r106.put("photo_search_rank", r100.f356051b);
        o.f365780a.reportEvent("live_tutor_item_show", r106);
        return;
    L14:
        r102 = null;
        goto L15
    L5:
        if ((r100 instanceof v.c) == true) goto L11;
        if ((r100 instanceof v.b) == false) goto L10;
        r103 = TuplesKt.to("knowledge_points", ((v.b) r100).f356052c.getFlashCardTaskId());
        goto L16
    }

    public final void reportStayPage(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("enter_from", "live_tutor_home_page");
        r101.put("page_name", HISTORY_PAGE_NAME);
        r101.put("stay_duration", r100);
        o.f365780a.reportEvent("live_tutor_stay_page", r101);
    }

    public static final /* synthetic */ void access$setCursorId$p(LiveTutorHistoryViewModel r100, Long r101) {
        r100.cursorId = r101;
    }

    public static final /* synthetic */ void access$setHasMore$p(LiveTutorHistoryViewModel r100, boolean r101) {
        r100.hasMore = r101;
    }

    public static final /* synthetic */ void access$setLoading$p(LiveTutorHistoryViewModel r100, boolean r101) {
        r100.isLoading = r101;
    }

    private final void handleHistoryData(List<? extends v> r110, boolean r111) {
        List<v> r112 = insertTime(CollectionsKt.toMutableList(r110), (v) CollectionsKt.lastOrNull(this.originHistoryList));
        List<v> r100 = this.originHistoryList;
        ListIterator<v> r101 = r100.listIterator(r100.size());
    L3:
        v.e r102 = null;
        if (r101.hasPrevious() == false) goto L11;
        v r103 = r101.previous();
        if (r103.d() != 1003) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L3;
    L13:
        if ((r103 instanceof v.e) == false) goto L15;
        v.e r105 = (v.e) r103;
    L16:
        List<v> r106 = r112;
        Iterator<T> r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L25;
        Object r108 = r107.next();
        if (((v) r108).d() != 1003) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L18;
    L27:
        if ((r108 instanceof v.e) == false) goto L29;
        r102 = (v.e) r108;
    L29:
        if (r105 == null) goto L34;
        if (r102 == null) goto L34;
        if (Intrinsics.areEqual(r105.f356061c, r102.f356061c) == false) goto L34;
        r112.remove(r102);
    L34:
        CollectionsKt.addAll(this.originHistoryList, r106);
        if (this.originHistoryList.isEmpty() == false) goto L37;
        notifyPageRefreshStatus(PageStateViewModel.RefreshStatus.NO_DATA);
        return;
    L37:
        notifyPageRefreshStatus(PageStateViewModel.RefreshStatus.SUCCESS);
        if (r111 == false) goto L40;
        LoadMoreState r113 = LoadMoreState.Success;
    L41:
        this.historyData.postValue(this.originHistoryList);
        FLogger.f375446a.i(TAG, "handleHistoryData, hasMore = " + r111 + ", loadMoreState = " + r113);
        this._loadMoreState.postValue(r113);
        return;
    L40:
        r113 = LoadMoreState.NoMore;
        goto L41
    L22:
        r109 = false;
        goto L23
    L25:
        r108 = null;
        goto L27
    L15:
        r105 = null;
        goto L16
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L13
    }

    private final Pair<Integer, Integer> initSectionRank(v r100, v r101) {
        Long r102 = null;
        if (r100 == null) goto L7;
        Long r103 = r100.a();
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(r103.longValue() * 1000);
    L8:
        if (r101 == null) goto L13;
        Long r105 = r101.a();
        if (r105 == null) goto L13;
        r102 = Long.valueOf(r105.longValue() * 1000);
    L13:
        if (r104 == null) goto L21;
        if (r102 == null) goto L21;
        if (UtilsKt.e(r104.longValue(), r102.longValue()) == true) goto L23;
        return TuplesKt.to(Integer.valueOf(r100.f356050a + 1), 1);
    L23:
        return TuplesKt.to(Integer.valueOf(r100.f356050a), Integer.valueOf(r100.f356051b + 1));
    L21:
        return TuplesKt.to(1, 1);
    L7:
        r104 = null;
        goto L8
    }

    private final List<v> insertTime(List<v> r110, v r111) {
        if (r110.isEmpty() == true) goto L5;
        ArrayList r100 = new ArrayList();
        List r101 = new ArrayList();
        Iterator<v> r112 = r110.iterator();
        v r102 = null;
        Triple r103 = null;
    L8:
        if (r112.hasNext() == false) goto L25;
        v r104 = r112.next();
        Long r105 = insertTime$getItemTimestamp(r104);
        if (r105 == null) goto L8;
        long r106 = r105.longValue();
        Calendar r107 = Calendar.getInstance();
        r107.setTime(new Date(r106));
        Triple r108 = new Triple(Integer.valueOf(r107.get(1)), Integer.valueOf(r107.get(2)), Integer.valueOf(r107.get(5)));
        if (r103 == null) goto L13;
        if (Intrinsics.areEqual(r103, r108) == false) goto L18;
        r101.add(r104);
        goto L8
    L18:
        v r109 = (v) CollectionsKt.firstOrNull(r101);
        if (r109 == null) goto L23;
        Long r113 = insertTime$getItemTimestamp(r109);
        if (r113 == null) goto L23;
        r100.add(TuplesKt.to(Long.valueOf(r113.longValue()), CollectionsKt.toList(r101)));
    L23:
        r101 = CollectionsKt.mutableListOf(new v[]{r104});
    L14:
        r103 = r108;
        goto L8
    L13:
        r101.add(r104);
        goto L14
    L25:
        if ((!r101.isEmpty()) == false) goto L31;
        v r114 = (v) CollectionsKt.firstOrNull(r101);
        if (r114 == null) goto L31;
        Long r115 = insertTime$getItemTimestamp(r114);
        if (r115 == null) goto L31;
        r100.add(TuplesKt.to(Long.valueOf(r115.longValue()), CollectionsKt.toList(r101)));
    L31:
        ArrayList r116 = new ArrayList();
        Pair r117 = (Pair) CollectionsKt.firstOrNull(r100);
        if (r117 == null) goto L36;
        List r118 = (List) r117.getSecond();
        if (r118 == null) goto L36;
        r102 = (v) CollectionsKt.firstOrNull(r118);
    L36:
        Pair<Integer, Integer> r119 = initSectionRank(r111, r102);
        int r120 = r119.component1().intValue();
        int r121 = r119.component2().intValue();
        Iterator r122 = r100.iterator();
    L38:
        if (r122.hasNext() == false) goto L44;
        Pair r123 = (Pair) r122.next();
        long r124 = ((Number) r123.component1()).longValue();
        List r125 = (List) r123.component2();
        r116.add(new v.e(getDateString(r124)));
        Iterator r126 = r125.iterator();
    L41:
        if (r126.hasNext() == false) goto L43;
        v r127 = (v) r126.next();
        r127.f356050a = r120;
        r127.f356051b = r121;
        r121 = r121 + 1;
        r116.add(r127);
        goto L41
    L43:
        r120 = r120 + 1;
        r121 = 1;
        goto L38
    L44:
        return r116;
    L5:
        return new ArrayList();
    }

    private final List<v> mergeHistoryList(List<LiveTutorRecord> r100, List<FlashCardRecord> r101) {
        List r102 = CollectionsKt.createListBuilder();
        if (r100 == null) goto L36;
        Iterator<T> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L36;
        LiveTutorRecord r104 = (LiveTutorRecord) r103.next();
        if (r104 == null) goto L6;
        TutorSearchContent r105 = r104.getTutorSearchContent();
        String r106 = null;
        if (r105 == null) goto L12;
        String r107 = r105.getText();
    L13:
        if (r107 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == false) goto L20;
        TutorSearchContent r109 = r104.getTutorSearchContent();
        if (r109 == null) goto L28;
        List<Image> r110 = r109.getImages();
        if (r110 == null) goto L28;
        Image r111 = (Image) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L28;
        r106 = r111.getImageUrl();
    L28:
        if (r106 != null) goto L30;
    L33:
        boolean r112 = true;
    L34:
        if (r112 == true) goto L6;
        r102.add(new v.c(r104));
        goto L6
    L30:
        if (r106.length() == 0) goto L33;
        r112 = false;
        goto L34
    L20:
        r102.add(new v.d(r104));
        goto L6
    L15:
        if (r107.length() == 0) goto L18;
        r108 = false;
        goto L19
    L12:
        r107 = null;
    L36:
        if (r101 == null) goto L53;
        Iterator<T> r113 = r101.iterator();
    L39:
        if (r113.hasNext() == false) goto L53;
        FlashCardRecord r114 = (FlashCardRecord) r113.next();
        if (r114 == null) goto L39;
        String r115 = r114.getTopicContent();
        if (r115 != null) goto L45;
    L48:
        boolean r116 = true;
    L49:
        if (r116 == true) goto L39;
        r102.add(new v.b(r114));
        goto L39
    L45:
        if (r115.length() == 0) goto L48;
        r116 = false;
    L53:
        return CollectionsKt.sortedWith(CollectionsKt.build(r102), new b());
    }

    public final void openTutor(Context r110, v r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, MapController.ITEM_LAYER_TAG);
        if ((r210 instanceof v.b) == false) goto L17;
        v.b r100 = (v.b) r210;
        String r111 = r100.f356052c.getJumpSchema();
        if (r111 != null) goto L7;
    L10:
        boolean r112 = true;
    L11:
        if (r112 == false) goto L13;
    L15:
        JSONObject r101 = new JSONObject();
        r101.put("enter_from", "live_tutor_home_page");
        r101.put("page_name", HISTORY_PAGE_NAME);
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "knowledge_points");
        r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "knowledge_points");
        r101.put("record_id", r100.f356052c.getFlashCardTaskId());
        r101.put("photo_search_time", r100.f356054e);
        r101.put("photo_search_section", r210.f356050a);
        r101.put("photo_search_rank", r210.f356051b);
        o.f365780a.reportEvent("live_tutor_click_button", r101);
        return;
    L13:
        if (SmartRouter.canOpen(r111) == false) goto L15;
        SmartRouter.buildRoute(r110, r111).d();
        goto L15
    L7:
        if (r111.length() == 0) goto L10;
        r112 = false;
        goto L11
    L17:
        LiveTutorRecord r102 = r210.c();
        if (r102 != null) goto L20;
        return;
    L20:
        FLogger.f375446a.i(TAG, "openTutor record: " + r102);
        i r103 = SmartRouter.buildRoute(r110, "//flow/live_tutor/main");
        TutorSearchContent r104 = r102.getTutorSearchContent();
        if (r104 == null) goto L23;
        String r105 = r104.getText();
    L24:
        r103.f267554c.putExtra("query_text", r105);
        TutorSearchContent r106 = r102.getTutorSearchContent();
        if (r106 == null) goto L27;
        Long r107 = r106.getFixedQueryId();
    L28:
        r103.f267554c.putExtra("live_tutor_rec_query_id", r107);
        r103.f267554c.putExtra("tutor_id", r102.getTutorId());
        TutorSearchContent r108 = r102.getTutorSearchContent();
        if (r108 == null) goto L35;
        List<Image> r109 = r108.getImages();
        if (r109 == null) goto L35;
        Image r113 = (Image) CollectionsKt.firstOrNull(r109);
        if (r113 == null) goto L35;
        String r114 = r113.getImageUrl();
    L36:
        r103.f267554c.putExtra("image_url", r114);
        TutorSearchContent r115 = r102.getTutorSearchContent();
        if (r115 == null) goto L43;
        List<Image> r116 = r115.getImages();
        if (r116 == null) goto L43;
        Image r117 = (Image) CollectionsKt.firstOrNull(r116);
        if (r117 == null) goto L43;
        String r118 = r117.getImageUri();
    L44:
        r103.f267554c.putExtra("image_uri", r118);
        r103.f267554c.putExtra(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, TutorEntranceType.History.getValue());
        r103.f267554c.putExtra("action_bar_key", this.actionBarKey);
        r103.f267554c.putExtra(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, this.actionBarId);
        r103.f267554c.putExtra("enter_method", this.enterMethod);
        r103.d();
        JSONObject r119 = new JSONObject();
        r119.put("enter_from", "live_tutor_home_page");
        r119.put("page_name", HISTORY_PAGE_NAME);
        r119.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "learning_record_details");
        r119.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "learning_record_details");
        r119.put("record_id", r102.getTutorId());
        r119.put("photo_search_time", r102.getCreatedTime());
        r119.put("photo_search_section", r210.f356050a);
        r119.put("photo_search_rank", r210.f356051b);
        o.f365780a.reportEvent("live_tutor_click_button", r119);
        return;
    L43:
        r118 = null;
    L35:
        r114 = null;
        goto L36
    L27:
        r107 = null;
        goto L28
    L23:
        r105 = null;
        goto L24
    }

    /* JADX INFO: renamed from: startRefreshData, reason: avoid collision after fix types in other method */
    public void startRefreshData2(ITutorRefresh.RefreshStrategy r100, final Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        FLogger.f375446a.i(TAG, "[requestData] is load more = " + r101);
        UtilsKt.x(this, new com.larus.livetutor.impl.history.viewmodel.a(this, r101));
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.LifecyclePageStateViewModel
    public /* bridge */ /* synthetic */ void startRefreshData(ITutorRefresh.RefreshStrategy r100, Boolean r101) {
        startRefreshData2(r100, r101);
    }

    public static final /* synthetic */ void access$handleHistoryData(LiveTutorHistoryViewModel r100, List r101, boolean r102) {
        r100.handleHistoryData(r101, r102);
    }

    public static final /* synthetic */ List access$mergeHistoryList(LiveTutorHistoryViewModel r100, List r101, List r102) {
        return r100.mergeHistoryList(r101, r102);
    }

    private static final Unit startRefreshData$lambda$0(LiveTutorHistoryViewModel r100, Boolean r101, ApiCallConfig r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$viewModelApiCall");
        LiveTutorHistoryViewModel$startRefreshData$1$1 r103 = new LiveTutorHistoryViewModel$startRefreshData$1$1(r100, r101, null);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "apiCall");
        r102.f356637a = r103;
        LiveTutorHistoryViewModel$startRefreshData$1$2 r104 = new LiveTutorHistoryViewModel$startRefreshData$1$2(r101, r100, null);
        Intrinsics.checkNotNullParameter(r104, "failureCallback");
        r102.f356638b = r104;
        return Unit.INSTANCE;
    }

    public final void initSchemeData(String r100, String r101, String r102) {
        this.actionBarId = r100;
        this.actionBarKey = r101;
        this.enterMethod = r102;
    }
}
