package com.ss.android.lark.search.dto;

import com.bytedance.lark.pb.search.v2.SearchCommonResponseHeader;
import com.bytedance.lark.pb.search.v2.SearchResult;
import com.bytedance.lark.pb.search.v2.UniversalSearchResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x3c.a;

/* JADX INFO: loaded from: classes38.dex */
public class SearchResponse implements Serializable {
    private static final long serialVersionUID = 2211277683604241438L;
    private SearchCommonResponseHeader.InvokeAbnormalNotice abnormalNotice;
    private UniversalSearchResponse.CopyWritingInfo copyWritingInfo;
    private int errorCode;
    private SearchCommonResponseHeader.ErrorInfo errorInfo;
    private int from;
    private boolean hasMore;
    private String imprId;
    private boolean isErrorResponse;
    private boolean isSpotLight;
    private int larkErrorCode;
    private String logId;
    private String pageToken;
    private String query;
    private ArrayList<SearchResult> rawResultList;
    private a recommendFilterInfo;
    private String recommendTitle;
    private String requestId;
    private int resultType;
    private Scene.Type scene;
    private List<SearchBaseInfo> searchInfo;
    private boolean secondaryStageSearchable;
    private int seqId;
    private String session;
    private List<SearchBaseInfo> suggestionInfo;
    private int suggestionType;
    private HashMap<String, Integer> timeForReporter;
    private int total;

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(this.searchInfo);
    }

    public SearchResponse() {
        this.rawResultList = new ArrayList();
        this.searchInfo = new ArrayList();
        this.recommendFilterInfo = null;
        this.query = "";
        this.imprId = "";
        this.logId = "";
        this.requestId = "";
        this.from = 1;
        this.isErrorResponse = false;
        this.secondaryStageSearchable = false;
        this.suggestionInfo = new ArrayList();
        this.timeForReporter = new HashMap();
        this.isSpotLight = false;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public SearchCommonResponseHeader.InvokeAbnormalNotice getAbnormalNotice() {
        return this.abnormalNotice;
    }

    public UniversalSearchResponse.CopyWritingInfo getCopyWritingInfo() {
        return this.copyWritingInfo;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public SearchCommonResponseHeader.ErrorInfo getErrorInfo() {
        return this.errorInfo;
    }

    public int getFrom() {
        return this.from;
    }

    public String getImprId() {
        return this.imprId;
    }

    public List<SearchBaseInfo> getInfoList() {
        return this.searchInfo;
    }

    public int getLarkErrorCode() {
        return this.larkErrorCode;
    }

    public String getLogId() {
        return this.logId;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public String getQuery() {
        return this.query;
    }

    public ArrayList<SearchResult> getRawResultList() {
        return this.rawResultList;
    }

    public a getRecommendFilterInfo() {
        return this.recommendFilterInfo;
    }

    public String getRecommendTitle() {
        return this.recommendTitle;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getResultType() {
        return this.resultType;
    }

    public Scene.Type getScene() {
        return this.scene;
    }

    public int getSeqId() {
        return this.seqId;
    }

    public String getSession() {
        return this.session;
    }

    public List<SearchBaseInfo> getSuggestionList() {
        return this.suggestionInfo;
    }

    public int getSuggestionType() {
        return this.suggestionType;
    }

    public Map<String, Integer> getTimeForReporter() {
        return this.timeForReporter;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean isErrorResponse() {
        return this.isErrorResponse;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public boolean isSecondaryStageSearchable() {
        return this.secondaryStageSearchable;
    }

    public boolean isSpotLight() {
        return this.isSpotLight;
    }

    public void setAbnormalNotice(SearchCommonResponseHeader.InvokeAbnormalNotice r100) {
        this.abnormalNotice = r100;
    }

    public void setCopyWritingInfo(UniversalSearchResponse.CopyWritingInfo r100) {
        this.copyWritingInfo = r100;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setErrorInfo(SearchCommonResponseHeader.ErrorInfo r100) {
        this.errorInfo = r100;
    }

    public void setErrorResponse(boolean r100) {
        this.isErrorResponse = r100;
    }

    public void setFrom(int r100) {
        this.from = r100;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setImprId(String r100) {
        this.imprId = r100;
    }

    public void setInfoList(List<SearchBaseInfo> r100) {
        this.searchInfo = r100;
    }

    public void setLarkErrorCode(int r100) {
        this.larkErrorCode = r100;
    }

    public void setLogId(String r100) {
        this.logId = r100;
    }

    public void setPageToken(String r100) {
        this.pageToken = r100;
    }

    public void setQuery(String r100) {
        this.query = r100;
    }

    public void setRawResultList(ArrayList<SearchResult> r100) {
        this.rawResultList = r100;
    }

    public void setRecommendFilterInfo(a r100) {
        this.recommendFilterInfo = r100;
    }

    public void setRecommendTitle(String r100) {
        this.recommendTitle = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public void setResultType(int r100) {
        this.resultType = r100;
    }

    public void setScene(Scene.Type r100) {
        this.scene = r100;
    }

    public void setSecondaryStageSearchable(boolean r100) {
        this.secondaryStageSearchable = r100;
    }

    public void setSeqId(int r100) {
        this.seqId = r100;
    }

    public void setSession(String r100) {
        this.session = r100;
    }

    public void setSpotLight(boolean r100) {
        this.isSpotLight = r100;
    }

    public void setSuggestionList(List<SearchBaseInfo> r100) {
        this.suggestionInfo = r100;
    }

    public void setSuggestionType(int r100) {
        this.suggestionType = r100;
    }

    public void setTotal(int r100) {
        this.total = r100;
    }

    public void setTime(String r100, int r101) {
        this.timeForReporter.put(r100, Integer.valueOf(r101));
    }
}
