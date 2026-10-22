package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchEmailInfo;", "Lcom/ss/android/lark/search/dto/info/SearchOpenSearchInfo;", "emailExtraResult", "Lcom/ss/android/lark/search/dto/info/EmailResult;", "<init>", "(Lcom/ss/android/lark/search/dto/info/EmailResult;)V", "getEmailExtraResult", "()Lcom/ss/android/lark/search/dto/info/EmailResult;", "getResultTypeForReport", "", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchEmailInfo extends SearchOpenSearchInfo {
    private final EmailResult emailExtraResult;

    @Override // com.ss.android.lark.search.dto.info.SearchOpenSearchInfo, com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "emails";
    }

    public final EmailResult getEmailExtraResult() {
        return this.emailExtraResult;
    }

    public SearchEmailInfo(EmailResult r100) {
        Intrinsics.checkNotNullParameter(r100, "emailExtraResult");
        this.emailExtraResult = r100;
    }
}
