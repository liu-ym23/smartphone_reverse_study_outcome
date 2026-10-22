package com.larus.platform.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007HÆ\u0003Jp\u0010\u0019\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/platform/api/FirstFramePreloadVideoData;", "Ljava/io/Serializable;", "preLoadFirstRequestItemIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "preLoadFirstRequestItemIdToRequestIdMap", "", "innerLoadMoreRequestFromSecondRun", "", "preLoadFirstRequestItemIdToChannelIdMap", "<init>", "(Ljava/util/ArrayList;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;)V", "getPreLoadFirstRequestItemIdList", "()Ljava/util/ArrayList;", "getPreLoadFirstRequestItemIdToRequestIdMap", "()Ljava/util/Map;", "getInnerLoadMoreRequestFromSecondRun", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPreLoadFirstRequestItemIdToChannelIdMap", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/ArrayList;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/larus/platform/api/FirstFramePreloadVideoData;", "equals", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirstFramePreloadVideoData implements Serializable {

    @SerializedName("innerLoadMoreRequestFromSecondRun")
    private final Boolean innerLoadMoreRequestFromSecondRun;

    @SerializedName("preLoadFirstRequestItemIdList")
    private final ArrayList<String> preLoadFirstRequestItemIdList;

    @SerializedName("preLoadFirstRequestItemIdToChannelIdMap")
    private final Map<String, String> preLoadFirstRequestItemIdToChannelIdMap;

    @SerializedName("preLoadFirstRequestItemIdToRequestIdMap")
    private final Map<String, String> preLoadFirstRequestItemIdToRequestIdMap;

    public FirstFramePreloadVideoData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirstFramePreloadVideoData copy$default(FirstFramePreloadVideoData r100, ArrayList r101, Map r102, Boolean r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.preLoadFirstRequestItemIdList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.preLoadFirstRequestItemIdToRequestIdMap;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.innerLoadMoreRequestFromSecondRun;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.preLoadFirstRequestItemIdToChannelIdMap;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ArrayList<String> component1() {
        return this.preLoadFirstRequestItemIdList;
    }

    public final Map<String, String> component2() {
        return this.preLoadFirstRequestItemIdToRequestIdMap;
    }

    public final Boolean component3() {
        return this.innerLoadMoreRequestFromSecondRun;
    }

    public final Map<String, String> component4() {
        return this.preLoadFirstRequestItemIdToChannelIdMap;
    }

    public final FirstFramePreloadVideoData copy(ArrayList<String> r100, Map<String, String> r101, Boolean r102, Map<String, String> r103) {
        return new FirstFramePreloadVideoData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FirstFramePreloadVideoData) == true) goto L8;
        return false;
    L8:
        FirstFramePreloadVideoData r101 = (FirstFramePreloadVideoData) r100;
        if (Intrinsics.areEqual(this.preLoadFirstRequestItemIdList, r101.preLoadFirstRequestItemIdList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preLoadFirstRequestItemIdToRequestIdMap, r101.preLoadFirstRequestItemIdToRequestIdMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.innerLoadMoreRequestFromSecondRun, r101.innerLoadMoreRequestFromSecondRun) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preLoadFirstRequestItemIdToChannelIdMap, r101.preLoadFirstRequestItemIdToChannelIdMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        ArrayList<String> r100 = this.preLoadFirstRequestItemIdList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.preLoadFirstRequestItemIdToRequestIdMap;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.innerLoadMoreRequestFromSecondRun;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.preLoadFirstRequestItemIdToChannelIdMap;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FirstFramePreloadVideoData(preLoadFirstRequestItemIdList=" + this.preLoadFirstRequestItemIdList + ", preLoadFirstRequestItemIdToRequestIdMap=" + this.preLoadFirstRequestItemIdToRequestIdMap + ", innerLoadMoreRequestFromSecondRun=" + this.innerLoadMoreRequestFromSecondRun + ", preLoadFirstRequestItemIdToChannelIdMap=" + this.preLoadFirstRequestItemIdToChannelIdMap + ')';
    }

    public final Boolean getInnerLoadMoreRequestFromSecondRun() {
        return this.innerLoadMoreRequestFromSecondRun;
    }

    public final ArrayList<String> getPreLoadFirstRequestItemIdList() {
        return this.preLoadFirstRequestItemIdList;
    }

    public final Map<String, String> getPreLoadFirstRequestItemIdToChannelIdMap() {
        return this.preLoadFirstRequestItemIdToChannelIdMap;
    }

    public final Map<String, String> getPreLoadFirstRequestItemIdToRequestIdMap() {
        return this.preLoadFirstRequestItemIdToRequestIdMap;
    }

    public FirstFramePreloadVideoData(ArrayList<String> r100, Map<String, String> r101, Boolean r102, Map<String, String> r103) {
        this.preLoadFirstRequestItemIdList = r100;
        this.preLoadFirstRequestItemIdToRequestIdMap = r101;
        this.innerLoadMoreRequestFromSecondRun = r102;
        this.preLoadFirstRequestItemIdToChannelIdMap = r103;
    }

    public /* synthetic */ FirstFramePreloadVideoData(ArrayList r100, Map r101, Boolean r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
