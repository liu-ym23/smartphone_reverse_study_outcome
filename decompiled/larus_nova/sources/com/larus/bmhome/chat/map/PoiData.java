package com.larus.bmhome.chat.map;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/map/PoiData;", "", "responseType", "", GXTemplateKey.GAIAX_TEMPLATE_ID, "", "responseForModel", "data", "Lcom/larus/bmhome/chat/map/Data;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/map/Data;)V", "getResponseType", "()Ljava/lang/String;", "getTemplateId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResponseForModel", "getData", "()Lcom/larus/bmhome/chat/map/Data;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/map/Data;)Lcom/larus/bmhome/chat/map/PoiData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PoiData {

    @SerializedName("data")
    private final Data data;

    @SerializedName("response_for_model")
    private final String responseForModel;

    @SerializedName("response_type")
    private final String responseType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final Integer templateId;

    public PoiData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PoiData copy$default(PoiData r100, String r101, Integer r102, String r103, Data r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.responseType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.templateId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.responseForModel;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.data;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.responseType;
    }

    public final Integer component2() {
        return this.templateId;
    }

    public final String component3() {
        return this.responseForModel;
    }

    public final Data component4() {
        return this.data;
    }

    public final PoiData copy(String r100, Integer r101, String r102, Data r103) {
        return new PoiData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiData) == true) goto L8;
        return false;
    L8:
        PoiData r101 = (PoiData) r100;
        if (Intrinsics.areEqual(this.responseType, r101.responseType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.responseForModel, r101.responseForModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.responseType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.templateId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.responseForModel;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Data r110 = this.data;
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
        return "PoiData(responseType=" + this.responseType + ", templateId=" + this.templateId + ", responseForModel=" + this.responseForModel + ", data=" + this.data + ')';
    }

    public final Data getData() {
        return this.data;
    }

    public final String getResponseForModel() {
        return this.responseForModel;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final Integer getTemplateId() {
        return this.templateId;
    }

    public PoiData(String r100, Integer r101, String r102, Data r103) {
        this.responseType = r100;
        this.templateId = r101;
        this.responseForModel = r102;
        this.data = r103;
    }

    public /* synthetic */ PoiData(String r100, Integer r101, String r102, Data r103, int r104, DefaultConstructorMarker r105) {
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
