package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchServiceCardInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "cardId", "", "renderContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRenderContent", "()Ljava/lang/String;", "getResultTypeForReport", "getTagForReport", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchServiceCardInfo extends SearchBaseInfo {
    private final String renderContent;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "service_card";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        return super.getTagForReport() + "fuzzy_kg_staff_service_card,";
    }

    public final String getRenderContent() {
        return this.renderContent;
    }

    public SearchServiceCardInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cardId");
        Intrinsics.checkNotNullParameter(r101, "renderContent");
        this.renderContent = r101;
        setId(r100);
        this.type = SearchCommonConstants.SearchResultType.SERVICE_CARD;
    }
}
