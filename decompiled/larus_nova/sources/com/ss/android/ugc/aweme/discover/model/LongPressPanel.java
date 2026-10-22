package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\nHÆ\u0003JV\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR*\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LongPressPanel;", "Ljava/io/Serializable;", "dislikeInfoList", "", "Lcom/ss/android/ugc/aweme/discover/model/DislikeInfoList;", "photoSearchSchema", "", "useNewLongPressPanel", "", "mediaTypeDislikeInfoMap", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "getDislikeInfoList", "()Ljava/util/List;", "getMediaTypeDislikeInfoMap", "()Ljava/util/Map;", "getPhotoSearchSchema", "()Ljava/lang/String;", "getUseNewLongPressPanel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/ss/android/ugc/aweme/discover/model/LongPressPanel;", "equals", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongPressPanel implements Serializable {

    @SerializedName("dislike_info_list")
    private final List<DislikeInfoList> dislikeInfoList;

    @SerializedName("carrier_type_dislike_info_map")
    private final Map<String, List<DislikeInfoList>> mediaTypeDislikeInfoMap;

    @SerializedName("photo_search_schema_template")
    private final String photoSearchSchema;

    @SerializedName("use_new_long_press_panel")
    private final Boolean useNewLongPressPanel;

    public LongPressPanel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LongPressPanel copy$default(LongPressPanel r100, List r101, String r102, Boolean r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.dislikeInfoList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.photoSearchSchema;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.useNewLongPressPanel;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.mediaTypeDislikeInfoMap;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<DislikeInfoList> component1() {
        return this.dislikeInfoList;
    }

    public final String component2() {
        return this.photoSearchSchema;
    }

    public final Boolean component3() {
        return this.useNewLongPressPanel;
    }

    public final Map<String, List<DislikeInfoList>> component4() {
        return this.mediaTypeDislikeInfoMap;
    }

    public final LongPressPanel copy(List<DislikeInfoList> r100, String r101, Boolean r102, Map<String, ? extends List<DislikeInfoList>> r103) {
        return new LongPressPanel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LongPressPanel) == false) goto L14;
        LongPressPanel r101 = (LongPressPanel) r100;
        if (Intrinsics.areEqual(this.dislikeInfoList, r101.dislikeInfoList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.photoSearchSchema, r101.photoSearchSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.useNewLongPressPanel, r101.useNewLongPressPanel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mediaTypeDislikeInfoMap, r101.mediaTypeDislikeInfoMap) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<DislikeInfoList> r100 = this.dislikeInfoList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.photoSearchSchema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.useNewLongPressPanel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, List<DislikeInfoList>> r110 = this.mediaTypeDislikeInfoMap;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LongPressPanel(dislikeInfoList=" + this.dislikeInfoList + ", photoSearchSchema=" + this.photoSearchSchema + ", useNewLongPressPanel=" + this.useNewLongPressPanel + ", mediaTypeDislikeInfoMap=" + this.mediaTypeDislikeInfoMap + ")";
    }

    public final List<DislikeInfoList> getDislikeInfoList() {
        return this.dislikeInfoList;
    }

    public final Map<String, List<DislikeInfoList>> getMediaTypeDislikeInfoMap() {
        return this.mediaTypeDislikeInfoMap;
    }

    public final String getPhotoSearchSchema() {
        return this.photoSearchSchema;
    }

    public final Boolean getUseNewLongPressPanel() {
        return this.useNewLongPressPanel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LongPressPanel(List<DislikeInfoList> r100, String r101, Boolean r102, Map<String, ? extends List<DislikeInfoList>> r103) {
        this.dislikeInfoList = r100;
        this.photoSearchSchema = r101;
        this.useNewLongPressPanel = r102;
        this.mediaTypeDislikeInfoMap = r103;
    }

    public /* synthetic */ LongPressPanel(List r100, String r101, Boolean r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Boolean.FALSE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
