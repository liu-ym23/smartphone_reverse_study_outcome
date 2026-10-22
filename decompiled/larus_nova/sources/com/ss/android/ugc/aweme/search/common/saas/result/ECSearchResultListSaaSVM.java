package com.ss.android.ugc.aweme.search.common.saas.result;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.chunkstreamprediction.network.c;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.Gson;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.ugc.aweme.discover.commodity.api.ChunkInfo;
import com.ss.android.ugc.aweme.discover.commodity.api.KiwiStruct;
import com.ss.android.ugc.aweme.discover.commodity.api.SearchCommodityAggregateResponse;
import com.ss.android.ugc.aweme.discover.commodity.helper.ILynxOperatePageExecutor;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.SearchCommodityDynamicPatch;
import com.ss.android.ugc.aweme.discover.model.SearchInsertCellJsbParams;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.GlobalDoodleConfig;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.aweme.search.common.ILoadMoreFunction;
import com.ss.android.ugc.aweme.search.common.base.ECSearchBaseViewModel;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.filter.FilterSelectStatusViewModel;
import com.ss.android.ugc.aweme.search.common.list.ESSaasCommonList;
import com.ss.android.ugc.aweme.search.common.list.ESSaasCommonListAdapter;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchResultSceneKey;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchSaasResultShowEvent;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchSaasResultShowEventTracker;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchSaasResultShowEventTrackerKt;
import com.ss.android.ugc.aweme.search.common.repo.ECSearchRequestParam;
import com.ss.android.ugc.aweme.search.common.result.LoadStatus;
import com.ss.android.ugc.aweme.search.common.result.RefreshTrigger;
import com.ss.android.ugc.aweme.search.common.result.optimize.ECSearchParamHelper;
import com.ss.android.ugc.aweme.search.common.saas.result.event.ECSearchEventSaaSUtils;
import com.ss.android.ugc.aweme.search.common.saas.result.event.ECSearchScrollMobEvent;
import com.ss.android.ugc.aweme.search.common.saas.result.request.ECRequestParamSaaSBuilder;
import com.ss.android.ugc.aweme.search.common.saas.result.request.ECSearchRequestSaaSVM;
import com.ss.android.ugc.aweme.search.common.topsection.ITopSectionManager;
import com.ss.android.ugc.aweme.search.common.utils.SearchIDManager;
import com.ss.android.ugc.aweme.search.common.utils.StringExtKt;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.android.ugc.aweme.search.model.commodity.CommodityResultParam;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r*\u0003\u00052?\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010^\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u000105H\u0002J\b\u0010`\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010bJ\u000e\u0010d\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010bJ\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010bJ\b\u0010f\u001a\u0004\u0018\u00010\u001cJ\b\u0010g\u001a\u0004\u0018\u000105J\b\u0010h\u001a\u0004\u0018\u00010iJ\u0006\u0010j\u001a\u00020]J\u0006\u0010k\u001a\u00020]J*\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020,2\u0006\u0010n\u001a\u00020T2\b\u0010o\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010p\u001a\u00020]J\u0010\u0010q\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020sH\u0016J\u0006\u0010t\u001a\u00020]J\u0006\u0010u\u001a\u00020]J\u0006\u0010v\u001a\u00020]J\u0006\u0010w\u001a\u00020\u000fJ$\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020P2\b\u0010z\u001a\u0004\u0018\u00010{2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010}J\"\u0010~\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020P2\u0006\u0010_\u001a\u0002052\n\b\u0002\u0010|\u001a\u0004\u0018\u00010}J\u0010\u0010\u007f\u001a\u00020\u000f2\u0006\u0010\u007f\u001a\u00020;H\u0016J\u0007\u0010\u0080\u0001\u001a\u00020\u000fJ/\u0010\u0081\u0001\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020P2\b\u0010_\u001a\u0004\u0018\u0001052\b\u0010|\u001a\u0004\u0018\u00010}2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J-\u0010\u0084\u0001\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020P2\u0006\u0010_\u001a\u0002052\b\u0010|\u001a\u0004\u0018\u00010}2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010\u0085\u0001\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u000105H\u0002J\u0013\u0010\u0086\u0001\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u000105H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u000fH\u0002J\u0011\u0010\u0088\u0001\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020PH\u0016J\u0019\u0010\u0089\u0001\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020P2\u0006\u0010_\u001a\u000205H\u0014J\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0013J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0013J\u0007\u0010\u008c\u0001\u001a\u00020]J\u0011\u0010\u008d\u0001\u001a\u00020\u000f2\b\u0010|\u001a\u0004\u0018\u00010}J\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0013J\u000f\u0010\u008f\u0001\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0016R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0010\u0010M\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u0002050O0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0016R\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR \u0010Y\u001a\b\u0012\u0004\u0012\u00020P0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0016R\u000e\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM;", "Lcom/ss/android/ugc/aweme/search/common/base/ECSearchBaseViewModel;", "Lcom/ss/android/ugc/aweme/discover/commodity/helper/ILynxOperatePageExecutor;", "()V", "dataSourceParams", "com/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM$dataSourceParams$1", "Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM$dataSourceParams$1;", "esCommonList", "Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonList;", "getEsCommonList", "()Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonList;", "setEsCommonList", "(Lcom/ss/android/ugc/aweme/search/common/list/ESSaasCommonList;)V", "firstScreenRenderDone", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "", "getFirstScreenRenderDone", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", SubInfo.KEY_FORMAT, "", "getFormat", "setFormat", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "loadStatus", "Lcom/ss/android/ugc/aweme/search/common/result/LoadStatus;", "getLoadStatus", "setLoadStatus", "logPbBean", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "mCommodityResultParam", "Lcom/ss/android/ugc/aweme/search/model/commodity/CommodityResultParam;", "getMCommodityResultParam", "()Lcom/ss/android/ugc/aweme/search/model/commodity/CommodityResultParam;", "setMCommodityResultParam", "(Lcom/ss/android/ugc/aweme/search/model/commodity/CommodityResultParam;)V", "originFormat", "getOriginFormat", "()Ljava/lang/String;", "setOriginFormat", "(Ljava/lang/String;)V", "originalSearchId", "getOriginalSearchId", "setOriginalSearchId", "param", "Lcom/ss/android/ugc/aweme/search/common/bean/ECSearchParam;", "getParam", "()Lcom/ss/android/ugc/aweme/search/common/bean/ECSearchParam;", "setParam", "(Lcom/ss/android/ugc/aweme/search/common/bean/ECSearchParam;)V", "performanceOptListener", "com/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM$performanceOptListener$1", "Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM$performanceOptListener$1;", "refreshResponseData", "Lcom/ss/android/ugc/aweme/discover/commodity/api/SearchCommodityAggregateResponse;", "getRefreshResponseData", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/SearchCommodityAggregateResponse;", "setRefreshResponseData", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/SearchCommodityAggregateResponse;)V", "refreshTrigger", "Lcom/ss/android/ugc/aweme/search/common/result/RefreshTrigger;", "getRefreshTrigger", "setRefreshTrigger", "requestListener", "com/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM$requestListener$1", "Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultListSaaSVM$requestListener$1;", "requestParam", "Lcom/ss/android/ugc/aweme/search/common/repo/ECSearchRequestParam;", "getRequestParam", "()Lcom/ss/android/ugc/aweme/search/common/repo/ECSearchRequestParam;", "setRequestParam", "(Lcom/ss/android/ugc/aweme/search/common/repo/ECSearchRequestParam;)V", "requestViewModel", "Lcom/ss/android/ugc/aweme/search/common/saas/result/request/ECSearchRequestSaaSVM;", "getRequestViewModel", "()Lcom/ss/android/ugc/aweme/search/common/saas/result/request/ECSearchRequestSaaSVM;", "setRequestViewModel", "(Lcom/ss/android/ugc/aweme/search/common/saas/result/request/ECSearchRequestSaaSVM;)V", OnekeyLoginConstants.CT_KEY_RSP_DATA, "responseLiveData", "Lkotlin/Pair;", "", "getResponseLiveData", "setResponseLiveData", "resultFragment", "Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultSaaSFragment;", "getResultFragment", "()Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultSaaSFragment;", "setResultFragment", "(Lcom/ss/android/ugc/aweme/search/common/saas/result/ECSearchResultSaaSFragment;)V", "scrollTop", "getScrollTop", "setScrollTop", "srpDrawTracked", "", "checkFilterAndSetData", "response", "enterFrom", "getItems", "", "Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity;", "getItemsOfTopSection", "getListItems", "getLogPbBean", "getResponse", "getTopSectionManager", "Lcom/ss/android/ugc/aweme/search/common/topsection/ITopSectionManager;", "hasTopCard", "hasTopSection", "initData", "searchParam", WidgetService.PARAM_FRAGMENT, "tabSearchChannel", "isRecreate", "insertCardByLynx", "params", "Lorg/json/JSONObject;", "isBannerEnableCeiling", "isFromFilter", "isInRefresh", DitoNode.LOAD_MORE, "realOnRequestEndError", "requestType", "error", "", "searchResultParam", "Lcom/ss/android/ugc/aweme/search/model/SearchResultParam;", "realOnRequestEndSuccess", "refresh", "reportSrpDrawIfNeeded", "requestErrorJobDelay", "requestStartTime", "", "requestSuccessJobDelay", "resetAllPassThoughParam", "resetPassThroughParam", "resetRequestParam", "responseErrorForUI", "responseSuccessForUI", "searchId", "searchKeyword", "shouldHideEmptyFooter", "sort", "tabName", "updateKeyword", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchResultListSaaSVM extends ECSearchBaseViewModel implements ILynxOperatePageExecutor {
    private final ECSearchResultListSaaSVM$dataSourceParams$1 dataSourceParams;
    private ESSaasCommonList esCommonList;
    private final QLiveData<Unit> firstScreenRenderDone;
    private QLiveData<String> format;
    private QLiveData<LoadStatus> loadStatus;
    private LogPbBean logPbBean;
    private CommodityResultParam mCommodityResultParam;
    private String originFormat;
    private String originalSearchId;
    private ECSearchParam param;
    private ECSearchResultListSaaSVM$performanceOptListener$1 performanceOptListener;
    private SearchCommodityAggregateResponse refreshResponseData;
    private QLiveData<RefreshTrigger> refreshTrigger;
    private final ECSearchResultListSaaSVM$requestListener$1 requestListener;
    private ECSearchRequestParam requestParam;
    private ECSearchRequestSaaSVM requestViewModel;
    private SearchCommodityAggregateResponse responseData;
    private QLiveData<Pair<Integer, SearchCommodityAggregateResponse>> responseLiveData;
    private ECSearchResultSaaSFragment resultFragment;
    private QLiveData<Integer> scrollTop;
    private boolean srpDrawTracked;

    /* JADX WARN: Type inference failed for: r0v10, types: [com.ss.android.ugc.aweme.search.common.saas.result.ECSearchResultListSaaSVM$requestListener$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.ss.android.ugc.aweme.search.common.saas.result.ECSearchResultListSaaSVM$dataSourceParams$1] */
    public ECSearchResultListSaaSVM() {
        super(null, 1, null);
        this.loadStatus = new QLiveData();
        this.firstScreenRenderDone = new QLiveData();
        this.refreshTrigger = new QLiveData();
        this.scrollTop = new QLiveData();
        this.requestParam = new ECSearchRequestParam();
        this.responseLiveData = new QLiveData();
        this.format = new QLiveData();
        this.performanceOptListener = new ECSearchResultListSaaSVM$performanceOptListener$1(this);
        this.dataSourceParams = new ECSearchResultListSaaSVM$dataSourceParams$1(this);
        this.requestListener = new ECSearchResultListSaaSVM$requestListener$1(this);
    }

    public void responseErrorForUI(int r100) {
    }

    private final void resetRequestParam() {
        ECSearchRequestParam r100 = this.requestParam;
        r100.cursor = 0;
        r100.level = "";
        r100.shownCount = 0;
        r100.sortParams = null;
        r100.originalSearchId = null;
        ECSearchParam r101 = this.param;
        if (r101 == null) goto L7;
        SearchResultParam r102 = r101.getSearchResultParam();
        if (r102 == null) goto L7;
        String r103 = r102.getClientEngineExtra();
    L8:
        r100.clientEngineExtra = r103;
        ECSearchRequestParam r104 = this.requestParam;
        ECSearchParamHelper r105 = ECSearchParamHelper.f451865a;
        ECSearchParam r106 = this.param;
        r105.getClass();
        r104.searchSource = ECSearchParamHelper.b(r106);
        ECSearchRequestParam r107 = this.requestParam;
        ECSearchParam r108 = this.param;
        if (r108 == null) goto L13;
        SearchResultParam r109 = r108.getSearchResultParam();
        if (r109 == null) goto L13;
        int r110 = r109.getNeedCorrect();
    L14:
        r107.correctType = r110;
        this.requestParam.hasSideBar = false;
        ECSearchResultSaaSFragment r111 = this.resultFragment;
        if (r111 == null) goto L17;
        ECSearchFilterViewModel.Companion.getClass();
        ECSearchFilterViewModel.Companion.a(r111).setHasSideBar(false);
    L17:
        resetPassThroughParam(null);
        return;
    L13:
        r110 = 1;
    L7:
        r103 = null;
        goto L8
    }

    public final String enterFrom() {
        ECSearchParam r100 = this.param;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getEnterFrom();
    }

    /* JADX INFO: renamed from: getFormat, reason: collision with other method in class */
    public final String m8704getFormat() {
        String r100 = this.format.a();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ItemStyle.ITEM_STYLE_DOUBLE;
    }

    public final List<SearchAggregateCommodity> getItems() {
        ESSaasCommonList r100 = this.esCommonList;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getItemList();
    }

    public final List<SearchAggregateCommodity> getItemsOfTopSection() {
        ESSaasCommonList r100 = this.esCommonList;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getItemListOfTopSection();
    }

    public final List<SearchAggregateCommodity> getListItems() {
        ESSaasCommonList r100 = this.esCommonList;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getItemList();
    }

    public final ITopSectionManager getTopSectionManager() {
        ESSaasCommonList r100 = this.esCommonList;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTopSectionManager();
    }

    public final boolean hasTopCard() {
        SearchCommodityAggregateResponse r100 = this.refreshResponseData;
        if (r100 == null) goto L5;
        KiwiStruct r101 = r100.getKiwiInfo();
    L6:
        if (r101 == null) goto L9;
        return true;
    L9:
        ITopSectionManager r102 = getTopSectionManager();
        if (r102 != null) goto L14;
        return false;
    L14:
        return r102.hasHeadCard();
    L5:
        r101 = null;
        goto L6
    }

    public final boolean hasTopSection() {
        ESSaasCommonList r100 = this.esCommonList;
        if (r100 == null) goto L10;
        ESSaasCommonListAdapter r101 = r100.f451639b;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.f451657x != null) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public final boolean isBannerEnableCeiling() {
        ESSaasCommonList r100 = this.esCommonList;
        SearchAggregateCommodity r101 = null;
        Object r102 = null;
        r101 = null;
        if (r100 == null) goto L13;
        List<SearchAggregateCommodity> r103 = r100.getItemList();
        if (r103 == null) goto L13;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((SearchAggregateCommodity) r105).getRefId(), "ecom_search_marketing_banner") == false) goto L8;
        r102 = r105;
    L12:
        r101 = (SearchAggregateCommodity) r102;
    L13:
        if (r101 == null) goto L19;
        SearchCommodityDynamicPatch r106 = r101.getDynamicPatch();
        if (r106 == null) goto L19;
        if (r106.getEnableCeiling() != true) goto L19;
        return true;
    L19:
        return false;
    }

    public final boolean isFromFilter() {
        ECSearchParam r100 = this.param;
        String r101 = null;
        if (r100 == null) goto L5;
        SearchResultParam r102 = r100.getSearchResultParam();
    L6:
        if (r102 == null) goto L10;
        CommodityResultParam r103 = r102.getCommodityResultParam();
        if (r103 == null) goto L10;
        String r104 = r103.getFilterOptionId();
    L12:
        if (r104 == null) goto L14;
        boolean r105 = true;
    L15:
        if (r102 == null) goto L17;
        String r106 = r102.getEnterMethod();
    L18:
        boolean r107 = Intrinsics.areEqual(r106, "by_sort");
        if (r102 == null) goto L23;
        CommodityResultParam r108 = r102.getCommodityResultParam();
        if (r108 == null) goto L23;
        r101 = r108.getSortParams();
    L23:
        if (r101 == null) goto L25;
        boolean r109 = true;
    L26:
        if (r105 == true) goto L31;
        if (r107 == true) goto L31;
        if (r109 == true) goto L31;
        boolean r110 = false;
    L32:
        if (r110 == false) goto L35;
        Logger.a("ECSearchRequest", "current request is from filter search");
        return true;
    L35:
        return false;
    L31:
        r110 = true;
        goto L32
    L25:
        r109 = false;
        goto L26
    L17:
        r106 = null;
        goto L18
    L14:
        r105 = false;
    L10:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final boolean isInRefresh() {
        ECSearchRequestSaaSVM r100 = this.requestViewModel;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isInRefresh();
    }

    public final void loadMore() {
        ESSaasCommonList r100 = this.esCommonList;
        if (r100 == null) goto L8;
        ILoadMoreFunction r101 = r100.f451643f;
        if (r101 == null) goto L9;
        r101.a();
        return;
    L9:
        return;
    }

    public final void reportSrpDrawIfNeeded() {
        if (this.srpDrawTracked == false) goto L5;
        return;
    L5:
        this.srpDrawTracked = true;
        ECSearchEventSaaSUtils r100 = ECSearchEventSaaSUtils.f452150a;
        ECSearchParam r101 = this.param;
        String r102 = searchId();
        r100.getClass();
        Intrinsics.checkNotNullParameter("search_result_page_draw", "eventName");
        if (r101 == null) goto L19;
        SearchResultParam r103 = r101.getSearchResultParam();
        if (r103 == null) goto L20;
        ECSearchScrollMobEvent r104 = new ECSearchScrollMobEvent();
        r104.c("search_keyword", r103.getKeyword());
        r104.c("search_id", r102);
        Map<String, Object> r105 = r103.getEcomBtmMap();
        if (r105 == null) goto L16;
        Iterator<Map.Entry<String, Object>> r106 = r105.entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        Map.Entry<String, Object> r107 = r106.next();
        r104.c(r107.getKey(), r107.getValue().toString());
    L16:
        r104.d();
        return;
    L20:
        return;
    }

    public final String searchId() {
        SearchIDManager r100 = SearchIDManager.f452276g;
        ECSearchResultSaaSFragment r101 = this.resultFragment;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        r100.getClass();
        return SearchIDManager.b(r102);
    L5:
        r102 = 0;
        goto L6
    }

    public final String searchKeyword() {
        ECSearchParam r100 = this.param;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKeyword();
    }

    public final boolean shouldHideEmptyFooter() {
        SearchCommodityAggregateResponse r100 = this.refreshResponseData;
        String r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = r100.getDisableFeedScroll();
    L7:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L9;
        return true;
    L9:
        List<SearchAggregateCommodity> r103 = getListItems();
        if (r103 == null) goto L12;
        SearchAggregateCommodity r104 = (SearchAggregateCommodity) CollectionsKt.lastOrNull(r103);
    L13:
        if (r104 == null) goto L17;
        CommodityText r105 = r104.getTextInfo();
        if (r105 == null) goto L17;
        r101 = r105.getType();
    L17:
        boolean r106 = Intrinsics.areEqual(r101, CommodityText.LESS_RESULT);
        SearchCommodityAggregateResponse r107 = this.responseData;
        if (r107 == null) goto L29;
        Intrinsics.checkNotNull(r107);
        if (r107.getHasMore() == true) goto L29;
        if (r104 == null) goto L29;
        Integer r108 = r104.getResultType();
        if (r108 == null) goto L29;
        if (r108.intValue() != 11) goto L29;
        if (r106 == false) goto L29;
        return true;
    L29:
        return false;
    L12:
        r104 = null;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public final String tabName() {
        ECSearchResultSaaSFragment r100 = this.resultFragment;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f452110o;
    }

    public final ESSaasCommonList getEsCommonList() {
        return this.esCommonList;
    }

    public final QLiveData<Unit> getFirstScreenRenderDone() {
        return this.firstScreenRenderDone;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final LogPbBean getLogPbBean() {
        return this.logPbBean;
    }

    public final CommodityResultParam getMCommodityResultParam() {
        return this.mCommodityResultParam;
    }

    public final String getOriginFormat() {
        return this.originFormat;
    }

    public final String getOriginalSearchId() {
        return this.originalSearchId;
    }

    public final ECSearchParam getParam() {
        return this.param;
    }

    public final SearchCommodityAggregateResponse getRefreshResponseData() {
        return this.refreshResponseData;
    }

    public final QLiveData<RefreshTrigger> getRefreshTrigger() {
        return this.refreshTrigger;
    }

    public final ECSearchRequestParam getRequestParam() {
        return this.requestParam;
    }

    public final ECSearchRequestSaaSVM getRequestViewModel() {
        return this.requestViewModel;
    }

    public final SearchCommodityAggregateResponse getResponse() {
        return this.responseData;
    }

    public final QLiveData<Pair<Integer, SearchCommodityAggregateResponse>> getResponseLiveData() {
        return this.responseLiveData;
    }

    public final ECSearchResultSaaSFragment getResultFragment() {
        return this.resultFragment;
    }

    public final QLiveData<Integer> getScrollTop() {
        return this.scrollTop;
    }

    public final QLiveData<String> getFormat() {
        return this.format;
    }

    private final void checkFilterAndSetData(SearchCommodityAggregateResponse r100) {
        if (r100 == null) goto L24;
        LogPbBean r101 = r100.getLogPb();
        if (r101 == null) goto L24;
        String r102 = r101.imprId;
        if (r102 == null) goto L24;
        if (isFromFilter() == true) goto L24;
        StringBuilder r103 = new StringBuilder("originSearchId = ");
        r103.append(r102);
        r103.append(", current Tab = ");
        ECSearchResultSaaSFragment r104 = this.resultFragment;
        if (r104 == null) goto L12;
        String r105 = r104.f452107l;
    L13:
        r103.append(r105);
        Logger.a("ECSearchRequest", r103.toString());
        this.originalSearchId = r102;
        SearchIDManager r106 = SearchIDManager.f452276g;
        ECSearchResultSaaSFragment r107 = this.resultFragment;
        if (r107 == null) goto L16;
        int r108 = r107.hashCode();
    L17:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r102, "id");
        if (r108 != 0) goto L21;
        SearchIDManager.f452273d.put(Integer.valueOf(SearchIDManager.f452270a), r102);
        goto L24
    L21:
        if (r108 == SearchIDManager.f452270a) goto L23;
        Logger.b("SearchIdDebug", "setOriginalSearchId ERROR: targetPage = " + r108 + ", currentPage = " + SearchIDManager.f452270a);
    L23:
        SearchIDManager.f452273d.put(Integer.valueOf(r108), r102);
        goto L24
    L16:
        r108 = 0;
        goto L17
    L12:
        r105 = null;
    L24:
        if (r100 == null) goto L33;
        GlobalDoodleConfig r109 = r100.getGlobalDoodleConfig();
        if (r109 == null) goto L34;
        String r110 = r109.showFormat;
        if (r110 == null) goto L35;
        this.originFormat = r110;
        if (isFromFilter() == true) goto L36;
        Logger.a("wfd_ECSearchRequest", "globalDoodleConfig showFormat = ".concat(r110));
        this.format.e(r110);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    private final void resetAllPassThoughParam(SearchCommodityAggregateResponse r100) {
        ECSearchParam r101 = this.param;
        String r102 = null;
        if (r101 == null) goto L10;
        SearchResultParam r103 = r101.getSearchResultParam();
        if (r103 == null) goto L10;
        if (r100 == null) goto L8;
        String r104 = r100.getEcomSearchAllPassThrough();
    L9:
        r103.setEcomSearchAllPassThrough(r104);
        goto L10
    L8:
        r104 = null;
    L10:
        ECSearchRequestParam r105 = this.requestParam;
        if (r100 == null) goto L13;
        r102 = r100.getEcomSearchAllPassThrough();
    L13:
        r105.ecomSearchAllPassThrough = r102;
    }

    private final void resetPassThroughParam(SearchCommodityAggregateResponse r100) {
        ECSearchParam r101 = this.param;
        String r102 = null;
        if (r101 == null) goto L10;
        SearchResultParam r103 = r101.getSearchResultParam();
        if (r103 == null) goto L10;
        if (r100 == null) goto L8;
        String r104 = r100.getEcomSearchPassThrough();
    L9:
        r103.setEcomSearchPassThrough(r104);
        goto L10
    L8:
        r104 = null;
    L10:
        ECSearchRequestParam r105 = this.requestParam;
        if (r100 == null) goto L13;
        r102 = r100.getEcomSearchPassThrough();
    L13:
        r105.ecomSearchPassThrough = r102;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.helper.ILynxOperatePageExecutor
    public void insertCardByLynx(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        SearchInsertCellJsbParams r101 = (SearchInsertCellJsbParams) new Gson().fromJson(r100.toString(), SearchInsertCellJsbParams.class);     // Catch: Throwable -> L36
        int r102 = r101.getRank();     // Catch: Throwable -> L36
        if (r102 >= 0) goto L30;
        int r103 = 0;
        if (hasTopSection() == false) goto L8;
        r102 = 0;
        goto L30
    L8:
        List<SearchAggregateCommodity> r104 = getItems();     // Catch: Throwable -> L36
        int r105 = 1;
        if (r104 == null) goto L29;
        Iterator<T> r106 = r104.iterator();     // Catch: Throwable -> L36
    L12:
        if (r106.hasNext() == false) goto L28;
        Object r107 = r106.next();     // Catch: Throwable -> L36
        int r108 = r103 + 1;     // Catch: Throwable -> L36
        if (r103 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L36
    L16:
        SearchAggregateCommodity r109 = (SearchAggregateCommodity) r107;     // Catch: Throwable -> L36
        Integer r110 = r109.getResultType();     // Catch: Throwable -> L36
        if (r110 != null) goto L20;
    L21:
        Integer r111 = r109.getResultType();     // Catch: Throwable -> L36
        if (r111 != null) goto L25;
    L27:
        r103 = r108;
        goto L12
    L25:
        if (r111.intValue() != 9999) goto L27;
    L26:
        r105 = r108;
        goto L27
    L20:
        if (r110.intValue() == 22) goto L26;
    L28:
        r102 = r105;
        goto L30
    L29:
        r102 = 1;
    L30:
        SearchAggregateCommodity r112 = r101.getCellInfo();     // Catch: Throwable -> L36
        if (r112 == null) goto L45;
        ESSaasCommonList r113 = this.esCommonList;     // Catch: Throwable -> L36
        if (r113 == null) goto L46;
        r113.a(r102, r112);     // Catch: Throwable -> L36
        return;
    L46:
        return;
    L45:
        return;
    L36:
        th = move-exception;
        Logger.c("ECSearchResultListSaasVM", "insertCardByLynx error", th);
    }

    public void refresh(RefreshTrigger r100) {
        Intrinsics.checkNotNullParameter(r100, "refresh");
        this.mCommodityResultParam = null;
        resetRequestParam();
        if (r100 != RefreshTrigger.AIChatRefresh) goto L13;
        ECSearchParam r101 = this.param;
        if (r101 == null) goto L9;
        SearchResultParam r102 = r101.getSearchResultParam();
        if (r102 == null) goto L9;
        String r103 = r102.getKeyword();
    L11:
        if (StringExtKt.a(r103) == false) goto L13;
        Logger.a("AIChatDebug", "refresh AIChatRefresh, new keyword = " + r103);
        this.requestParam.keyword = r103;
    L9:
        r103 = null;
    L13:
        this.refreshTrigger.e(r100);
        this.srpDrawTracked = false;
        ECRequestParamSaaSBuilder r104 = ECRequestParamSaaSBuilder.f452157a;
        String r105 = this.requestParam.searchSource;
        r104.getClass();
        if (ECRequestParamSaaSBuilder.c(r105) == true) goto L18;
        FilterSelectStatusViewModel.Companion r106 = FilterSelectStatusViewModel.Companion;
        ECSearchResultSaaSFragment r107 = this.resultFragment;
        r106.getClass();
        FilterSelectStatusViewModel r108 = FilterSelectStatusViewModel.Companion.a(r107);
        if (r108 == null) goto L18;
        r108.initShowFormat(null);
    L18:
        ECSearchRequestSaaSVM r109 = this.requestViewModel;
        if (r109 == null) goto L21;
        r109.updateECSearchRequestParam(this.requestParam);
    L21:
        Logger.d("ECSearchRequest", "sendSearchRequest on refresh, trigger:" + r100 + ", keyword:" + this.requestParam.keyword + ", searchSource:" + this.requestParam.searchSource + ", cursor:" + this.requestParam.cursor + "，clientEngineExtra: " + this.requestParam.clientEngineExtra);
        ECSearchRequestSaaSVM r110 = this.requestViewModel;
        if (r110 == null) goto L25;
        ECSearchRequestSaaSVM.sendSearchRequest$default(r110, 1, null, 2, null);
        return;
    }

    public final void setEsCommonList(ESSaasCommonList r100) {
        this.esCommonList = r100;
    }

    public final void setFormat(QLiveData<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.format = r100;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadStatus = r100;
    }

    public final void setMCommodityResultParam(CommodityResultParam r100) {
        this.mCommodityResultParam = r100;
    }

    public final void setOriginFormat(String r100) {
        this.originFormat = r100;
    }

    public final void setOriginalSearchId(String r100) {
        this.originalSearchId = r100;
    }

    public final void setParam(ECSearchParam r100) {
        this.param = r100;
    }

    public final void setRefreshResponseData(SearchCommodityAggregateResponse r100) {
        this.refreshResponseData = r100;
    }

    public final void setRefreshTrigger(QLiveData<RefreshTrigger> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.refreshTrigger = r100;
    }

    public final void setRequestParam(ECSearchRequestParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestParam = r100;
    }

    public final void setRequestViewModel(ECSearchRequestSaaSVM r100) {
        this.requestViewModel = r100;
    }

    public final void setResponseLiveData(QLiveData<Pair<Integer, SearchCommodityAggregateResponse>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.responseLiveData = r100;
    }

    public final void setResultFragment(ECSearchResultSaaSFragment r100) {
        this.resultFragment = r100;
    }

    public final void setScrollTop(QLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scrollTop = r100;
    }

    public final void sort(SearchResultParam r100) {
        Logger.a("ParamsDebug", "sort invoke");
        if (r100 == null) goto L5;
        CommodityResultParam r101 = r100.getCommodityResultParam();
    L6:
        this.mCommodityResultParam = r101;
        this.requestParam.format = m8704getFormat();
        ECSearchRequestParam r102 = this.requestParam;
        if (r100 == null) goto L9;
        String r103 = r100.getClientEngineExtra();
    L10:
        r102.clientEngineExtra = r103;
        Logger.a("ParamsDebug", "filter sort: originalSearchId = " + this.originalSearchId);
        this.requestParam.originalSearchId = this.originalSearchId;
        ECSearchParam r104 = this.param;
        if (r104 == null) goto L15;
        SearchResultParam r105 = r104.getSearchResultParam();
        if (r105 == null) goto L15;
        r105.setOriginSearchId(this.originalSearchId);
    L15:
        ECSearchParam r106 = this.param;
        if (r106 == null) goto L22;
        SearchResultParam r107 = r106.getSearchResultParam();
        if (r107 == null) goto L22;
        CommodityResultParam r108 = r107.getCommodityResultParam();
        if (r108 == null) goto L22;
        r108.setOriginSearchId(this.originalSearchId);
    L22:
        if (r100 == null) goto L34;
        CommodityResultParam r109 = r100.getCommodityResultParam();
        if (r109 == null) goto L34;
        String r110 = r109.getSortParams();
        if (r110 == null) goto L34;
        Logger.a("ParamsDebug", "filter search: update sortParams");
        this.requestParam.sortParams = r110;
        ECSearchParam r111 = this.param;
        if (r111 == null) goto L34;
        SearchResultParam r112 = r111.getSearchResultParam();
        if (r112 == null) goto L34;
        CommodityResultParam r113 = r112.getCommodityResultParam();
        if (r113 == null) goto L34;
        r113.setSortParams(r110);
    L34:
        if (r100 == null) goto L46;
        CommodityResultParam r114 = r100.getCommodityResultParam();
        if (r114 == null) goto L46;
        List<JSONObject> r115 = r114.getFilterOptionTotalList();
        if (r115 == null) goto L46;
        ECSearchParam r116 = this.param;
        if (r116 == null) goto L46;
        SearchResultParam r117 = r116.getSearchResultParam();
        if (r117 == null) goto L46;
        CommodityResultParam r118 = r117.getCommodityResultParam();
        if (r118 == null) goto L46;
        r118.setFilterOptionTotalList(r115);
    L46:
        ECSearchResultSaaSFragment r119 = this.resultFragment;
        if (r119 == null) goto L49;
        ECSearchRequestParam r120 = this.requestParam;
        ECSearchFilterViewModel.Companion.getClass();
        r120.hasSideBar = ECSearchFilterViewModel.Companion.a(r119).getHasSideBar();
        this.requestParam.subBoardWidth = ECSearchFilterViewModel.Companion.a(r119).getSubBoardWidth();
    L49:
        if (r100 == null) goto L57;
        String r121 = r100.getSearchFrom();
        if (r121 == null) goto L57;
        Logger.a("ParamsDebug", "filter search: update searchFrom");
        this.requestParam.searchSource = r121;
        ECSearchParam r122 = this.param;
        if (r122 == null) goto L57;
        SearchResultParam r123 = r122.getSearchResultParam();
        if (r123 == null) goto L57;
        r123.setSearchFrom(r121);
    L57:
        this.requestParam.cursor = 0;
        Logger.a("ParamsDebug", "sort resetPassThroughParam");
        resetPassThroughParam(null);
        ECSearchRequestSaaSVM r124 = this.requestViewModel;
        if (r124 == null) goto L60;
        r124.updateECSearchRequestParam(this.requestParam);
    L60:
        Logger.d("ECSearchRequest", "sendSearchRequest on sort, keyword:" + this.requestParam.keyword + ", searchSource:" + this.requestParam.searchSource + ", cursor:" + this.requestParam.cursor);
        ECSearchRequestSaaSVM r125 = this.requestViewModel;
        if (r125 == null) goto L64;
        ECSearchRequestSaaSVM.sendSearchRequest$default(r125, 1, null, 2, null);
        return;
    L64:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void updateKeyword(ECSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.param = r100;
        ECSearchRequestParam r101 = this.requestParam;
        r101.keyword = r100.getKeyword();
        ECSearchRequestParam r102 = this.requestParam;
        r102.extra = r100.getExtra();
    }

    public void responseSuccessForUI(int r100, SearchCommodityAggregateResponse r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Logger.a("ECSearchRequest", "responseSuccessForUI, thread name = " + ThreadMethodProxy.currentThread().getName());
        this.responseData = r101;
        if (r100 != 1) goto L5;
        this.refreshResponseData = r101;
    L5:
        this.logPbBean = r101.getLogPb();
        Logger.d("ECSearchRequest", "post live data, requestType = " + r100);
        this.responseLiveData.e(new Pair(Integer.valueOf(r100), r101));
        resetPassThroughParam(r101);
        resetAllPassThoughParam(r101);
        if (r100 != 1) goto L10;
        checkFilterAndSetData(r101);
        return;
    }

    public final void realOnRequestEndError(int r100, Throwable r101, SearchResultParam r102) {
        if (r100 != 1) goto L5;
        ECSearchSaasResultShowEventTracker r103 = ECSearchSaasResultShowEventTracker.f451754d;
        ECSearchResultSaaSFragment r104 = this.resultFragment;
        if (r104 == null) goto L11;
        ECSearchResultSceneKey r105 = r104.f452115t;
    L12:
        r103.getClass();
        ECSearchSaasResultShowEvent r106 = ECSearchSaasResultShowEventTracker.b(r105);
        r106.e();
        r106.d(r101);
        r106.b();
        this.loadStatus.e(LoadStatus.InitializeError);
        this.firstScreenRenderDone.e(Unit.INSTANCE);
    L13:
        responseErrorForUI(r100);
        return;
    L11:
        r105 = null;
        goto L12
    L5:
        if (r100 != 2) goto L13;
        this.loadStatus.e(LoadStatus.LoadMoreError);
        goto L13
    }

    public final void realOnRequestEndSuccess(int r100, SearchCommodityAggregateResponse r101, SearchResultParam r102) {
        Intrinsics.checkNotNullParameter(r101, "response");
        if (r100 != 1) goto L5;
        c r103 = r101.getChunkReadingReport();
        Object r104 = null;
        if (r103 != null) goto L11;
        c r105 = null;
    L19:
        ECSearchSaasResultShowEventTracker r106 = ECSearchSaasResultShowEventTracker.f451754d;
        ECSearchResultSaaSFragment r107 = this.resultFragment;
        if (r107 == null) goto L22;
        ECSearchResultSceneKey r108 = r107.f452115t;
    L23:
        r106.getClass();
        ECSearchSaasResultShowEvent r109 = ECSearchSaasResultShowEventTracker.b(r108);
        LogPbBean r110 = r101.getLogPb();
        if (r110 == null) goto L26;
        String r111 = r110.imprId;
    L27:
        r109.getClass();
        ECSearchSaasResultShowEvent r112 = ECSearchSaasResultShowEventTrackerKt.f451757b;
        if (Intrinsics.areEqual(r109, r112) == true) goto L31;
        r109.f451742p = r111;
    L31:
        r109.e();
        int r113 = 0;
        r109.f451743q = 0;
        if (Intrinsics.areEqual(r109, r112) == true) goto L35;
        r109.f451734h = r101;
    L35:
        r109.f451741o = r101.getServerTimeCost();
        r101.getListCount();
        Intrinsics.areEqual(r109, r112);
        if (Intrinsics.areEqual(r109, r112) == true) goto L39;
        r109.f451743q = 0;
        r109.f451744r = null;
        r109.f451745s = 0;
    L39:
        if (r105 == null) goto L41;
        r109.a(r105);
    L41:
        ChunkInfo r114 = r101.getChunkInfo();
        if (r114 == null) goto L44;
        Object r115 = r114.getExtra();
    L45:
        if (r115 != null) goto L47;
    L54:
        List<SearchAggregateCommodity> r116 = r101.getItems();
        if (r116 == null) goto L57;
        r113 = r116.size();
    L57:
        if (r113 <= 0) goto L59;
        this.loadStatus.e(LoadStatus.InitializeSuccess);
    L60:
        responseSuccessForUI(r100, r101);
        return;
    L59:
        this.loadStatus.e(LoadStatus.InitializeEmpty);
        this.firstScreenRenderDone.e(Unit.INSTANCE);
        goto L60
    L47:
        if ((r115 instanceof Map) == false) goto L50;
        r104 = r115;
    L50:
        Map r117 = (Map) r104;
        if (r117 != null) goto L53;
        r117 = new LinkedHashMap();
    L53:
        r109.g(r117);
        goto L54
    L44:
        r115 = null;
        goto L45
    L26:
        r111 = null;
        goto L27
    L22:
        r108 = null;
        goto L23
    L11:
        monitor-enter(r103);
        List<c.a> r118 = r103.f42525a;     // Catch: Throwable -> L15
        monitor-exit(r103);
        r105 = new c(new ArrayList(r118), r103.f42526b);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r100 != 2) goto L60;
        this.loadStatus.e(LoadStatus.LoadMoreSuccess);
        goto L60
    }

    private final void requestErrorJobDelay(int r110, SearchCommodityAggregateResponse r111, SearchResultParam r112, long r113) {
        Logger.a("ECSearchRequest", "requestErrorJobDelay start");
        if (r110 != 1) goto L11;
        ECSearchEventSaaSUtils r114 = ECSearchEventSaaSUtils.f452150a;
        ECSearchParam r100 = this.param;
        ECSearchResultSaaSFragment r101 = this.resultFragment;
        CommodityResultParam r102 = this.mCommodityResultParam;
        if (r100 == null) goto L8;
        String r103 = r100.getEnterFrom();
    L9:
        ECSearchBizScene r104 = ECSearchBizScene.EC_SEARCH;
        r114.getClass();
        ECSearchEventSaaSUtils.a(0, r100, r112, r101, r111, r102, r113, r103, r104);
        return;
    L8:
        r103 = null;
        goto L9
    }

    private final void requestSuccessJobDelay(int r110, SearchCommodityAggregateResponse r111, SearchResultParam r112, long r113) {
        Logger.a("ECSearchRequest", "requestSuccessJobDelay start");
        if (r110 != 1) goto L11;
        long r100 = System.currentTimeMillis();
        ECSearchEventSaaSUtils r101 = ECSearchEventSaaSUtils.f452150a;
        ECSearchParam r102 = this.param;
        ECSearchResultSaaSFragment r103 = this.resultFragment;
        CommodityResultParam r114 = this.mCommodityResultParam;
        if (r102 == null) goto L8;
        String r104 = r102.getEnterFrom();
    L9:
        ECSearchBizScene r115 = ECSearchBizScene.EC_SEARCH;
        r101.getClass();
        ECSearchEventSaaSUtils.a(1, r102, r112, r103, r111, r114, r113, r104, r115);
        Logger.a("ECSearchRequest", "pre process cost time: " + (System.currentTimeMillis() - r100));
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final void initData(ECSearchParam r110, ECSearchResultSaaSFragment r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "searchParam");
        Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
        this.resultFragment = r111;
        this.param = r110;
        ECRequestParamSaaSBuilder.b(ECRequestParamSaaSBuilder.f452157a, this.requestParam, r110);
        if (r112 == null) goto L5;
        this.requestParam.searchChannel = r112;
    L5:
        ECSearchRequestSaaSVM.Companion r114 = ECSearchRequestSaaSVM.Companion;
        ECSearchResultSaaSFragment r100 = this.resultFragment;
        r114.getClass();
        ECSearchRequestSaaSVM r115 = ECSearchRequestSaaSVM.Companion.a(r100);
        if (r115 == null) goto L13;
        r115.initViewModel(this.param, this.requestParam, this.resultFragment, this.dataSourceParams, this.requestListener, this.performanceOptListener, null);
        ECSearchResultSaaSFragment r101 = this.resultFragment;
        if (r101 == null) goto L12;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.addObserver(r115);
    L12:
        Unit r103 = Unit.INSTANCE;
    L14:
        this.requestViewModel = r115;
        ECSearchSaasResultShowEvent r116 = ECSearchSaasResultShowEventTracker.f451754d.d(r111.f452115t);
        if (r116 == null) goto L20;
        ECSearchSaasResultShowEventTrackerKt.b(r116, r111.f452107l);
        ECSearchSaasResultShowEventTrackerKt.a(r116, r110);
        if (Intrinsics.areEqual(r116, ECSearchSaasResultShowEventTrackerKt.f451757b) == true) goto L20;
        r116.f451746t = 1;
    L20:
        if (r113 == true) goto L25;
        ECSearchRequestSaaSVM r117 = this.requestViewModel;
        if (r117 == null) goto L26;
        ECSearchRequestSaaSVM.sendSearchRequest$default(r117, 1, null, 2, null);
        return;
    L26:
        return;
    L25:
        return;
    L13:
        r115 = null;
        goto L14
    }

    public static final /* synthetic */ void access$requestErrorJobDelay(ECSearchResultListSaaSVM r100, int r101, SearchCommodityAggregateResponse r102, SearchResultParam r103, long r104) {
        r100.requestErrorJobDelay(r101, r102, r103, r104);
    }

    public static final /* synthetic */ void access$requestSuccessJobDelay(ECSearchResultListSaaSVM r100, int r101, SearchCommodityAggregateResponse r102, SearchResultParam r103, long r104) {
        r100.requestSuccessJobDelay(r101, r102, r103, r104);
    }

    public static /* synthetic */ void realOnRequestEndError$default(ECSearchResultListSaaSVM r100, int r101, Throwable r102, SearchResultParam r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 4) == 0) goto L9;
        ECSearchParam r106 = r100.param;
        if (r106 == null) goto L8;
        r103 = r106.getSearchResultParam();
        goto L9
    L8:
        r103 = null;
    L9:
        r100.realOnRequestEndError(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: realOnRequestEndError");
    }

    public static /* synthetic */ void realOnRequestEndSuccess$default(ECSearchResultListSaaSVM r100, int r101, SearchCommodityAggregateResponse r102, SearchResultParam r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 4) == 0) goto L9;
        ECSearchParam r106 = r100.param;
        if (r106 == null) goto L8;
        r103 = r106.getSearchResultParam();
        goto L9
    L8:
        r103 = null;
    L9:
        r100.realOnRequestEndSuccess(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: realOnRequestEndSuccess");
    }

    public static /* synthetic */ void initData$default(ECSearchResultListSaaSVM r100, ECSearchParam r101, ECSearchResultSaaSFragment r102, String r103, boolean r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L6;
        r104 = false;
    L6:
        r100.initData(r101, r102, r103, r104);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initData");
    }
}
