package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.feedback.v1.SearchResult;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchFeedbackInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "end", "", "getEnd", "()I", "setEnd", "(I)V", "results", "", "Lcom/bytedance/lark/pb/search/feedback/v1/SearchResult;", "getResults", "()Ljava/util/List;", "setResults", "(Ljava/util/List;)V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "addToList", "getAddToList", "setAddToList", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchFeedbackInfo extends SearchBaseInfo {
    private boolean addToList;
    private int end;
    private List<SearchResult> results;
    private boolean show;

    public SearchFeedbackInfo() {
        this.end = 15;
        this.results = new ArrayList();
        this.show = true;
        this.addToList = true;
        this.type = SearchCommonConstants.SearchResultType.SEARCH_FEEDBACK;
    }

    public final boolean getAddToList() {
        return this.addToList;
    }

    public final int getEnd() {
        return this.end;
    }

    public final List<SearchResult> getResults() {
        return this.results;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setAddToList(boolean r100) {
        this.addToList = r100;
    }

    public final void setEnd(int r100) {
        this.end = r100;
    }

    public final void setResults(List<SearchResult> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.results = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }
}
