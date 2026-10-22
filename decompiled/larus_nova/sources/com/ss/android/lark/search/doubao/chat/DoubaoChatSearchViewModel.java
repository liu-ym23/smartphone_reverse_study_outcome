package com.ss.android.lark.search.doubao.chat;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.search.v2.UniversalSearchResponse;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.usearch.ClientType;
import com.ss.android.lark.pb.usearch.DeleteDoubaoSearchQueryHistoryRequest;
import com.ss.android.lark.pb.usearch.DeleteDoubaoSearchQueryHistoryResponse;
import com.ss.android.lark.pb.usearch.DoubaoSearchQueryMeta;
import com.ss.android.lark.pb.usearch.DoubaoSearchSceneMeta;
import com.ss.android.lark.pb.usearch.PullDoubaoSearchQueryHistoryRequest;
import com.ss.android.lark.pb.usearch.PullDoubaoSearchQueryHistoryResponse;
import com.ss.android.lark.pb.usearch.PutDoubaoSearchQueryHistoryRequest;
import com.ss.android.lark.pb.usearch.PutDoubaoSearchQueryHistoryResponse;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003J\u0010\u00104\u001a\u0002022\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u001cH\u0002J\u0006\u00109\u001a\u00020\u0017J\b\u0010:\u001a\u0004\u0018\u00010%J\u0006\u0010;\u001a\u000202J\u0006\u0010<\u001a\u000202J\u0006\u0010=\u001a\u000202J\u000e\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020\u001cJ\u001e\u0010@\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u00103\u001a\u00020\u0003H\u0002J\u0012\u0010B\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010C\u001a\u000202J\u000e\u0010D\u001a\u0002022\u0006\u00103\u001a\u00020\u0003J\u000e\u0010\f\u001a\u0002022\u0006\u0010E\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/DoubaoChatSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "chatID", "", "<init>", "(Ljava/lang/String;)V", "historySugs", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ss/android/lark/search/doubao/chat/DoubaoSugAdapter$HistoryItem;", "getHistorySugs", "()Landroidx/lifecycle/MutableLiveData;", "deleteHistorySug", "getDeleteHistorySug", "resetSearchResult", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getResetSearchResult", "moreSearchResult", "getMoreSearchResult", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getError", DyPayConstant.KEY_SHOW_LOADING, "", "getShowLoading", "showEmptyResult", "getShowEmptyResult", "noNetTypeData", "", "getNoNetTypeData", "showToastRes", "getShowToastRes", "coldAndHotType", "getColdAndHotType", "datas", "", "copyWritingInfo", "Lcom/bytedance/lark/pb/search/v2/UniversalSearchResponse$CopyWritingInfo;", "hasMore", "aslRustClient", "Lcom/ss/android/lark/search/dto/userscope/IASLRust;", "searcher", "Lcom/ss/android/lark/search/doubao/InternalSearchLifecycleObserver;", "searchTimeReporter", "Lcom/ss/android/lark/search/doubao/reporter/DoubaoSearchTimeReporter;", "latestRequestId", "initSearch", "subTitleNumbs", "latestQuery", "search", "", "query", "processColdAndHotType", "data", "Lcom/ss/android/lark/search/dto/SearchResponse;", "shouldShowNetErrorView", "errorCode", "canLoadMore", "coldAndHotMsg", "hotEmptySearchCold", "hotToColdLoadMore", DitoNode.LOAD_MORE, "updateSubTitleNumbs", "numOfChars", "attachInfoForReport", "infoList", "getQueryForReport", "fetchHistorySug", "putHistorySug", MapController.ITEM_LAYER_TAG, "Companion", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoChatSearchViewModel extends ViewModel {
    public static final a Companion = null;
    private static final int ERROR_CODE_NETWORK = 100053;
    private static final int ERROR_CODE_OFFLINE = 100052;
    private static final int ERROR_CODE_SERVER_ERROR = 100012;
    private static final int ERROR_CODE_TIMEOUT = 100054;
    private static final String SEARCH_TAG = "SEARCH_MESSAGES";
    private static final String TAG = "DoubaoChatSearchViewModel";
    private final b4c.d aslRustClient;
    private final String chatID;
    private final MutableLiveData<Integer> coldAndHotType;
    private UniversalSearchResponse.CopyWritingInfo copyWritingInfo;
    private List<SearchBaseInfo> datas;
    private final MutableLiveData<DoubaoSugAdapter.a> deleteHistorySug;
    private final MutableLiveData<ErrorResult> error;
    private boolean hasMore;
    private final MutableLiveData<List<DoubaoSugAdapter.a>> historySugs;
    private boolean initSearch;
    private String latestQuery;
    private String latestRequestId;
    private final MutableLiveData<List<SearchBaseInfo>> moreSearchResult;
    private final MutableLiveData<Integer> noNetTypeData;
    private final MutableLiveData<List<SearchBaseInfo>> resetSearchResult;
    private final t3c.c searchTimeReporter;
    private final com.ss.android.lark.search.doubao.b searcher;
    private final MutableLiveData<String> showEmptyResult;
    private final MutableLiveData<Boolean> showLoading;
    private final MutableLiveData<String> showToastRes;
    private int subTitleNumbs;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final boolean shouldShowNetErrorView(int r100) {
        if (r100 != 100012) goto L5;
    L12:
        return true;
    L5:
        if (r100 == ERROR_CODE_OFFLINE) goto L12;
        if (r100 == ERROR_CODE_TIMEOUT) goto L12;
        if (r100 == ERROR_CODE_NETWORK) goto L12;
        return false;
    }

    public final void loadMore() {
        this.initSearch = false;
        final String r100 = com.ss.android.lark.sdk.a.a();
        this.latestRequestId = r100;
        this.searchTimeReporter.d();
        this.searcher.a(r100, new C121161(this, r100));
    }

    public final void fetchHistorySug() {
        PullDoubaoSearchQueryHistoryRequest.Builder r100 = new PullDoubaoSearchQueryHistoryRequest.Builder().client_type(ClientType.ANDROID).scene_meta(new DoubaoSearchSceneMeta.Builder().chat_id(this.chatID).scene(DoubaoSearchSceneMeta.DoubaoSearchScene.SEARCH_IN_CHAT).build());
        b4c.d r101 = this.aslRustClient;
        Command r102 = Command.PULL_DOUBAO_SEARCH_QUERY_HISTORY;
        Intrinsics.checkNotNull(r100);
        r101.j2(r102, r100, new C121151(this), PullDoubaoSearchQueryHistoryResponse.ADAPTER);
    }

    public final void hotEmptySearchCold() {
        this.showLoading.postValue(Boolean.TRUE);
        loadMore();
    }

    public final boolean canLoadMore() {
        return this.hasMore;
    }

    public final UniversalSearchResponse.CopyWritingInfo coldAndHotMsg() {
        return this.copyWritingInfo;
    }

    public final MutableLiveData<Integer> getColdAndHotType() {
        return this.coldAndHotType;
    }

    public final MutableLiveData<DoubaoSugAdapter.a> getDeleteHistorySug() {
        return this.deleteHistorySug;
    }

    public final MutableLiveData<ErrorResult> getError() {
        return this.error;
    }

    public final MutableLiveData<List<DoubaoSugAdapter.a>> getHistorySugs() {
        return this.historySugs;
    }

    public final MutableLiveData<List<SearchBaseInfo>> getMoreSearchResult() {
        return this.moreSearchResult;
    }

    public final MutableLiveData<Integer> getNoNetTypeData() {
        return this.noNetTypeData;
    }

    public final MutableLiveData<List<SearchBaseInfo>> getResetSearchResult() {
        return this.resetSearchResult;
    }

    public final MutableLiveData<String> getShowEmptyResult() {
        return this.showEmptyResult;
    }

    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final MutableLiveData<String> getShowToastRes() {
        return this.showToastRes;
    }

    public final void hotToColdLoadMore() {
        loadMore();
    }

    public DoubaoChatSearchViewModel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatID");
        this.chatID = r100;
        this.historySugs = new MutableLiveData();
        this.deleteHistorySug = new MutableLiveData();
        this.resetSearchResult = new MutableLiveData();
        this.moreSearchResult = new MutableLiveData();
        this.error = new MutableLiveData();
        this.showLoading = new MutableLiveData();
        this.showEmptyResult = new MutableLiveData();
        this.noNetTypeData = new MutableLiveData();
        this.showToastRes = new MutableLiveData();
        this.coldAndHotType = new MutableLiveData();
        this.datas = new ArrayList();
        this.aslRustClient = (b4c.d) e0c.k.a(LarkContext.getApplication(), b4c.d.class);
        this.searcher = new com.ss.android.lark.search.doubao.b();
        this.searchTimeReporter = new t3c.c();
        this.latestRequestId = "";
        this.initSearch = true;
        this.latestQuery = "";
    }

    public static final /* synthetic */ String access$getChatID$p(DoubaoChatSearchViewModel r100) {
        return r100.chatID;
    }

    public static final /* synthetic */ List access$getDatas$p(DoubaoChatSearchViewModel r100) {
        return r100.datas;
    }

    public static final /* synthetic */ boolean access$getInitSearch$p(DoubaoChatSearchViewModel r100) {
        return r100.initSearch;
    }

    public static final /* synthetic */ String access$getLatestRequestId$p(DoubaoChatSearchViewModel r100) {
        return r100.latestRequestId;
    }

    public static final /* synthetic */ t3c.c access$getSearchTimeReporter$p(DoubaoChatSearchViewModel r100) {
        return r100.searchTimeReporter;
    }

    public static final /* synthetic */ int access$getSubTitleNumbs$p(DoubaoChatSearchViewModel r100) {
        return r100.subTitleNumbs;
    }

    private final String getQueryForReport(String r100) {
        if (r100 == null) goto L12;
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        return r100;
    L6:
        r101 = false;
    L12:
        return this.latestQuery;
    }

    private final void processColdAndHotType(SearchResponse r100) {
        boolean r101 = r100.isHasMore();
        boolean r102 = r100.isEmpty();
        boolean r103 = r100.isSecondaryStageSearchable();
        this.copyWritingInfo = r100.getCopyWritingInfo();
        int r104 = 1;
        if ((!this.datas.isEmpty()) == true) goto L7;
        if (r102 == false) goto L7;
        boolean r105 = false;
    L8:
        int r106 = u3c.a.f548633a;
        if (r101 == true) goto L21;
        if (r103 == false) goto L14;
        if (r105 == false) goto L14;
        r104 = 2;
    L14:
        if (r103 == false) goto L17;
        if (r105 == true) goto L17;
        r104 = 4;
    L17:
        if (r103 == true) goto L20;
        if (r105 == false) goto L20;
        r104 = 3;
    L20:
        r104 = 5;
    L21:
        Log.i("ColdAndHotStorageManager", "hasMore: " + r101 + ", secondaryStageSearchable: " + r103 + ", hasData: " + r105 + ", coldAndHotType: " + r104);
        this.coldAndHotType.setValue(Integer.valueOf(r104));
        return;
    L7:
        r105 = true;
        goto L8
    }

    public final void deleteHistorySug(final DoubaoSugAdapter.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        DeleteDoubaoSearchQueryHistoryRequest.Builder r101 = new DeleteDoubaoSearchQueryHistoryRequest.Builder().client_type(ClientType.ANDROID).scene_meta(new DoubaoSearchSceneMeta.Builder().chat_id(this.chatID).scene(DoubaoSearchSceneMeta.DoubaoSearchScene.SEARCH_IN_CHAT).build());
        b4c.d r102 = this.aslRustClient;
        Command r103 = Command.DELETE_DOUBAO_SEARCH_QUERY_HISTORY;
        Intrinsics.checkNotNull(r101);
        r102.j2(r103, r101, new AnonymousClass1(this, r100), DeleteDoubaoSearchQueryHistoryResponse.ADAPTER);
    }

    public final void putHistorySug(String r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        PutDoubaoSearchQueryHistoryRequest.Builder r101 = new PutDoubaoSearchQueryHistoryRequest.Builder().client_type(ClientType.ANDROID).scene_meta(new DoubaoSearchSceneMeta.Builder().chat_id(this.chatID).scene(DoubaoSearchSceneMeta.DoubaoSearchScene.SEARCH_IN_CHAT).build()).query_meta(new DoubaoSearchQueryMeta.Builder().query(r100).build());
        b4c.d r102 = this.aslRustClient;
        Command r103 = Command.PUT_DOUBAO_SEARCH_QUERY_HISTORY;
        Intrinsics.checkNotNull(r101);
        r102.j2(r103, r101, new C121171(), PutDoubaoSearchQueryHistoryResponse.ADAPTER);
    }

    public final void search(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        boolean r101 = true;
        this.initSearch = true;
        this.latestQuery = r100;
        this.datas.clear();
        if (r100.length() == 0) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L9;
        this.latestRequestId = "";
        this.resetSearchResult.postValue(new ArrayList());
        return;
    L9:
        this.showLoading.postValue(Boolean.TRUE);
        final String r102 = com.ss.android.lark.sdk.a.a();
        this.latestRequestId = r102;
        com.ss.android.lark.search.doubao.api.request.s r103 = com.ss.android.lark.search.doubao.api.request.r.a(new DoubaoChatSearchViewModel$search$request$1(r100, this));
        this.searchTimeReporter.d();
        Log.i(TAG, "start search, RequestId = " + r102);
        this.searcher.b(r102, r103, new C121181(this, r102, r100));
    }

    public final void updateSubTitleNumbs(int r100) {
        this.subTitleNumbs = r100;
    }

    public static final /* synthetic */ String access$getQueryForReport(DoubaoChatSearchViewModel r100, String r101) {
        return r100.getQueryForReport(r101);
    }

    public static final /* synthetic */ void access$processColdAndHotType(DoubaoChatSearchViewModel r100, SearchResponse r101) {
        r100.processColdAndHotType(r101);
    }

    public static final /* synthetic */ void access$setHasMore$p(DoubaoChatSearchViewModel r100, boolean r101) {
        r100.hasMore = r101;
    }

    public static final /* synthetic */ boolean access$shouldShowNetErrorView(DoubaoChatSearchViewModel r100, int r101) {
        return r100.shouldShowNetErrorView(r101);
    }

    private final void attachInfoForReport(List<? extends SearchBaseInfo> r100, String r101) {
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((SearchBaseInfo) r102.next()).setQuery(r101);
        goto L4
    }

    public static final /* synthetic */ void access$attachInfoForReport(DoubaoChatSearchViewModel r100, List r101, String r102) {
        r100.attachInfoForReport(r101, r102);
    }
}
