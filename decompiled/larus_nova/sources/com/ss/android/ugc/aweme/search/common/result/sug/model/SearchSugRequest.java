package com.ss.android.ugc.aweme.search.common.result.sug.model;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SearchSugRequest;", "Ljava/io/Serializable;", "()V", "enterFrom", "", "enterFromSecond", "generalSearchRequestParamsJson", "gid", "keyword", "penetrateParams", "pitayaUploadInfo", "sessionInfoJson", "source", "sugActiveSearchQuery", "sugEnterType", "", "Ljava/lang/Integer;", "sugGapTime", "", "sugServerExtra", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSugRequest implements Serializable {

    @SerializedName("enter_from")
    public String enterFrom;

    @SerializedName(ECFindSimilarConfig.ENTER_FROM_SECOND)
    public String enterFromSecond;
    public transient String generalSearchRequestParamsJson;

    @SerializedName("gid")
    public String gid;

    @SerializedName("keyword")
    public String keyword;

    @SerializedName("penetrate_params")
    public String penetrateParams;

    @SerializedName("pitaya_upload_info")
    public String pitayaUploadInfo;

    @SerializedName("session_info_json")
    public String sessionInfoJson;

    @SerializedName("source")
    public String source;

    @SerializedName("sug_active_search_query")
    public String sugActiveSearchQuery;

    @SerializedName("sug_enter_type")
    public Integer sugEnterType;

    @SerializedName("sug_gap_time")
    public long sugGapTime;

    @SerializedName("sug_server_extra")
    public String sugServerExtra;

    public SearchSugRequest() {
    }
}
