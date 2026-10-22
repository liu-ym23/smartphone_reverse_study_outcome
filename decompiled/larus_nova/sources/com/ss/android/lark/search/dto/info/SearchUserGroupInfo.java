package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchUserGroupInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "name", "", "description", "userGroupType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getDescription", "getUserGroupType", "()I", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchUserGroupInfo extends SearchBaseInfo {
    private final String description;
    private final String name;
    private final int userGroupType;

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUserGroupType() {
        return this.userGroupType;
    }

    public SearchUserGroupInfo(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "description");
        this.name = r100;
        this.description = r101;
        this.userGroupType = r102;
        this.type = SearchCommonConstants.SearchResultType.USER_GROUP;
    }
}
