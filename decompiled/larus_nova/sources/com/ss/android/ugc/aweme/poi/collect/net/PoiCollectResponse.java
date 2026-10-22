package com.ss.android.ugc.aweme.poi.collect.net;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JH\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0006\u0010$\u001a\u00020\bJ\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectResponse;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Ljava/io/Serializable;", "collectCount", "", "sceneInfoStruct", "Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectSceneInfoStruct;", "nearbyCollectEntry", "", "collectEduStyle", "collectEduSchema", "Lcom/ss/android/ugc/aweme/poi/collect/net/CollectEduScheme;", "(Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectSceneInfoStruct;Ljava/lang/Boolean;ILcom/ss/android/ugc/aweme/poi/collect/net/CollectEduScheme;)V", "getCollectCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectEduSchema", "()Lcom/ss/android/ugc/aweme/poi/collect/net/CollectEduScheme;", "getCollectEduStyle", "()I", "getNearbyCollectEntry", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSceneInfoStruct", "()Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectSceneInfoStruct;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectSceneInfoStruct;Ljava/lang/Boolean;ILcom/ss/android/ugc/aweme/poi/collect/net/CollectEduScheme;)Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectResponse;", "equals", "other", "", "hashCode", "isFTaskAvailable", "toString", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiCollectResponse extends BaseResponse implements Serializable {

    @SerializedName("collect_count")
    private final Integer collectCount;

    @SerializedName("diamond_collect_entry_edu_schema")
    private final CollectEduScheme collectEduSchema;

    @SerializedName("collect_edu_style")
    private final int collectEduStyle;

    @SerializedName("has_diamond_collect_entry")
    private final Boolean nearbyCollectEntry;

    @SerializedName("scene_info")
    private final PoiCollectSceneInfoStruct sceneInfoStruct;

    public PoiCollectResponse() {
        this(null, null, null, 0, null, 31, null);
    }

    public static /* synthetic */ PoiCollectResponse copy$default(PoiCollectResponse r100, Integer r101, PoiCollectSceneInfoStruct r102, Boolean r103, int r104, CollectEduScheme r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.collectCount;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.sceneInfoStruct;
    L8:
        PoiCollectSceneInfoStruct r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.nearbyCollectEntry;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.collectEduStyle;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.collectEduSchema;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.collectCount;
    }

    public final PoiCollectSceneInfoStruct component2() {
        return this.sceneInfoStruct;
    }

    public final Boolean component3() {
        return this.nearbyCollectEntry;
    }

    public final int component4() {
        return this.collectEduStyle;
    }

    public final CollectEduScheme component5() {
        return this.collectEduSchema;
    }

    public final PoiCollectResponse copy(Integer r100, PoiCollectSceneInfoStruct r101, Boolean r110, int r111, CollectEduScheme r112) {
        return new PoiCollectResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiCollectResponse) == true) goto L8;
        return false;
    L8:
        PoiCollectResponse r101 = (PoiCollectResponse) r100;
        if (Intrinsics.areEqual(this.collectCount, r101.collectCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneInfoStruct, r101.sceneInfoStruct) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nearbyCollectEntry, r101.nearbyCollectEntry) == true) goto L18;
        return false;
    L18:
        if (this.collectEduStyle == r101.collectEduStyle) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.collectEduSchema, r101.collectEduSchema) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.collectCount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiCollectSceneInfoStruct r104 = this.sceneInfoStruct;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.nearbyCollectEntry;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.collectEduStyle) * 31;
        CollectEduScheme r110 = this.collectEduSchema;
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

    @Override // com.bytedance.locallife.model.response.BaseResponse
    public String toString() {
        return "PoiCollectResponse(collectCount=" + this.collectCount + ", sceneInfoStruct=" + this.sceneInfoStruct + ", nearbyCollectEntry=" + this.nearbyCollectEntry + ", collectEduStyle=" + this.collectEduStyle + ", collectEduSchema=" + this.collectEduSchema + ')';
    }

    public final boolean isFTaskAvailable() {
        PoiCollectSceneInfoStruct r100 = this.sceneInfoStruct;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getTaskCounter() <= 0) goto L7;
    L8:
        return true;
    L7:
        if (this.sceneInfoStruct.getSchema() == null) goto L9;
        goto L8
    }

    public final Integer getCollectCount() {
        return this.collectCount;
    }

    public final CollectEduScheme getCollectEduSchema() {
        return this.collectEduSchema;
    }

    public final int getCollectEduStyle() {
        return this.collectEduStyle;
    }

    public final Boolean getNearbyCollectEntry() {
        return this.nearbyCollectEntry;
    }

    public final PoiCollectSceneInfoStruct getSceneInfoStruct() {
        return this.sceneInfoStruct;
    }

    public PoiCollectResponse(Integer r100, PoiCollectSceneInfoStruct r101, Boolean r102, int r103, CollectEduScheme r104) {
        this.collectCount = r100;
        this.sceneInfoStruct = r101;
        this.nearbyCollectEntry = r102;
        this.collectEduStyle = r103;
        this.collectEduSchema = r104;
    }

    public /* synthetic */ PoiCollectResponse(Integer r100, PoiCollectSceneInfoStruct r101, Boolean r102, int r103, CollectEduScheme r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        PoiCollectSceneInfoStruct r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = Boolean.FALSE;
    L13:
        Boolean r106 = r102;
        if ((r110 & 8) == 0) goto L16;
        int r107 = 0;
    L18:
        if ((r110 & 16) == 0) goto L20;
        CollectEduScheme r113 = null;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
