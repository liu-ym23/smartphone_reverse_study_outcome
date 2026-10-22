package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchCommodityReloadLynxSchemaConfig;", "", "", "", "schemaList", "Ljava/util/Set;", "getSchemaList", "()Ljava/util/Set;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityReloadLynxSchemaConfig {

    @SerializedName("search_commodity_not_reload_schema_list")
    private final Set<String> schemaList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchCommodityReloadLynxSchemaConfig) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.schemaList, ((SearchCommodityReloadLynxSchemaConfig) r100).schemaList) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Set<String> r100 = this.schemaList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SearchCommodityReloadLynxSchemaConfig(schemaList=" + this.schemaList + ")";
    }

    public SearchCommodityReloadLynxSchemaConfig() {
        this.schemaList = null;
    }
}
