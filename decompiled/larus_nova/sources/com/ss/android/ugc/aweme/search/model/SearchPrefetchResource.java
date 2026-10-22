package com.ss.android.ugc.aweme.search.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u000b\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource;", "", "", "Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource$PrefetchImageItem;", "prefetchImage", "Ljava/util/List;", "getPrefetchImage", "()Ljava/util/List;", "Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource$DynamicComponentItem;", "dynamicComponent", "getDynamicComponent", "DynamicComponentItem", "PrefetchImageItem", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class SearchPrefetchResource {

    @SerializedName("dynamic_component")
    private final List<DynamicComponentItem> dynamicComponent;

    @SerializedName("prefetch_image")
    private final List<PrefetchImageItem> prefetchImage;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource$DynamicComponentItem;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "", "enableMemory", "Ljava/lang/Boolean;", "getEnableMemory", "()Ljava/lang/Boolean;", "", "maxAge", "Ljava/lang/Integer;", "getMaxAge", "()Ljava/lang/Integer;", "processType", "getProcessType", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class DynamicComponentItem {

        @SerializedName("enable_memory")
        private final Boolean enableMemory;

        @SerializedName("max_age")
        private final Integer maxAge;

        @SerializedName("process_type")
        private final String processType;

        @SerializedName("url")
        private final String url;

        public DynamicComponentItem() {
            this.url = null;
            this.enableMemory = null;
            this.maxAge = null;
            this.processType = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource$PrefetchImageItem;", "", "", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "", "urlList", "Ljava/util/List;", "getUrlList", "()Ljava/util/List;", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class PrefetchImageItem {

        @SerializedName("uri")
        private final String uri;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        private final List<String> urlList;

        public PrefetchImageItem() {
            this.uri = null;
            this.urlList = null;
        }
    }

    public SearchPrefetchResource() {
        this.prefetchImage = null;
        this.dynamicComponent = null;
    }
}
