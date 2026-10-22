package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchDepartmentInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "memberCount", "", "getMemberCount", "()I", "setMemberCount", "(I)V", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchDepartmentInfo extends SearchBaseInfo {
    private int memberCount;

    public SearchDepartmentInfo() {
        this.type = 17;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final void setMemberCount(int r100) {
        this.memberCount = r100;
    }
}
