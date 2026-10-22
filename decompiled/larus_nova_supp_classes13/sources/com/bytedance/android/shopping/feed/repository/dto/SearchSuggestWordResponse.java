package com.bytedance.android.shopping.feed.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/SearchSuggestWordResponse;", "Ljava/io/Serializable;", "()V", "data", "", "Lcom/bytedance/android/shopping/feed/repository/dto/PromotionSearchSuggestWord;", "getData", "()Ljava/util/List;", "errno", "", "getErrno", "()Ljava/lang/String;", "extra", "Lcom/bytedance/android/shopping/feed/repository/dto/SearchSuggestWordExtra;", "getExtra", "()Lcom/bytedance/android/shopping/feed/repository/dto/SearchSuggestWordExtra;", "logId", "getLogId", "msg", "getMsg", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWordResponse implements Serializable {

    @SerializedName("data")
    private final List<PromotionSearchSuggestWord> data;

    @SerializedName("errno")
    private final String errno;

    @SerializedName("extra")
    private final SearchSuggestWordExtra extra;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("msg")
    private final String msg;

    public SearchSuggestWordResponse() {
    }

    public final List<PromotionSearchSuggestWord> getData() {
        return this.data;
    }

    public final String getErrno() {
        return this.errno;
    }

    public final SearchSuggestWordExtra getExtra() {
        return this.extra;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMsg() {
        return this.msg;
    }
}
