package com.bytedance.locallife.groupon.struct;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "Ljava/io/Serializable;", SlcCommonAction.KEY_ACTIONS, "", "", "objectType", "objectIndex", "objectSvrData", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActions", "()Ljava/util/List;", "getObjectIndex", "()Ljava/lang/String;", "getObjectSvrData", "getObjectType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FrequencyInfo implements Serializable {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<String> actions;

    @SerializedName("object_index")
    private final String objectIndex;

    @SerializedName("object_svr_data")
    private final String objectSvrData;

    @SerializedName("object_type")
    private final String objectType;

    public FrequencyInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FrequencyInfo copy$default(FrequencyInfo r100, List r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.actions;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.objectType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.objectIndex;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.objectSvrData;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<String> component1() {
        return this.actions;
    }

    public final String component2() {
        return this.objectType;
    }

    public final String component3() {
        return this.objectIndex;
    }

    public final String component4() {
        return this.objectSvrData;
    }

    public final FrequencyInfo copy(List<String> r100, String r101, String r102, String r103) {
        return new FrequencyInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FrequencyInfo) == true) goto L8;
        return false;
    L8:
        FrequencyInfo r101 = (FrequencyInfo) r100;
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.objectType, r101.objectType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objectIndex, r101.objectIndex) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objectSvrData, r101.objectSvrData) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.actions;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.objectType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.objectIndex;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.objectSvrData;
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
        return "FrequencyInfo(actions=" + this.actions + ", objectType=" + this.objectType + ", objectIndex=" + this.objectIndex + ", objectSvrData=" + this.objectSvrData + ')';
    }

    public final List<String> getActions() {
        return this.actions;
    }

    public final String getObjectIndex() {
        return this.objectIndex;
    }

    public final String getObjectSvrData() {
        return this.objectSvrData;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public FrequencyInfo(List<String> r100, String r101, String r102, String r103) {
        this.actions = r100;
        this.objectType = r101;
        this.objectIndex = r102;
        this.objectSvrData = r103;
    }

    public /* synthetic */ FrequencyInfo(List r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
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
