package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchLoadingFooterInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isLoading", "", "<init>", "(Z)V", "()Z", "setLoading", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchLoadingFooterInfo extends SearchBaseInfo {
    private boolean isLoading;

    public final boolean isLoading() {
        return this.isLoading;
    }

    public SearchLoadingFooterInfo(boolean r100) {
        this.isLoading = r100;
    }

    public final void setLoading(boolean r100) {
        this.isLoading = r100;
    }
}
