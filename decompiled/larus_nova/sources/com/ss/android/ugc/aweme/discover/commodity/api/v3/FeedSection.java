package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/FeedSection;", "Ljava/io/Serializable;", "()V", "items", "", "Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "sectionId", "", "getSectionId", "()Ljava/lang/String;", "setSectionId", "(Ljava/lang/String;)V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedSection implements Serializable {
    public static final Companion Companion = null;
    public static final String SECTION_FEED = "feed_section";
    public static final String SECTION_FILTER = "sort_and_filter_section";
    public static final String SECTION_SKELETON = "skeleton_section";
    public static final String SECTION_TOP = "top_section";
    public static final String SECTION_TOP_IMAGE = "top_section_image";

    @SerializedName("items")
    private List<SearchAggregateCommodity> items;

    @SerializedName("section_id")
    private String sectionId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/FeedSection$Companion;", "", "()V", "SECTION_FEED", "", "SECTION_FILTER", "SECTION_SKELETON", "SECTION_TOP", "SECTION_TOP_IMAGE", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public FeedSection() {
    }

    public final List<SearchAggregateCommodity> getItems() {
        return this.items;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final void setItems(List<SearchAggregateCommodity> r100) {
        this.items = r100;
    }

    public final void setSectionId(String r100) {
        this.sectionId = r100;
    }
}
