package com.ss.android.ugc.aweme.search.hostapi;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchPadSplitService;", "", "getFoldStatus", "", "()Ljava/lang/Integer;", "getFoldType", "getScreenHeight", "getSpiltWidth", "isFold", "", "isPad", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ITradeSearchPadSplitService {
    Integer getFoldStatus();

    int getFoldType();

    int getScreenHeight();

    int getSpiltWidth();

    boolean isFold();

    boolean isPad();
}
