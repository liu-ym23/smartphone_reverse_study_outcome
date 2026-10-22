package com.bytedance.locallife.dito.data;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/dito/data/f;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "", SalesInfoStruct.REPEAT, "Z", "getRepeat", "()Z", "", "utParams", "Ljava/util/Map;", "getUtParams", "()Ljava/util/Map;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("track_event_name")
    private final String eventName;

    @SerializedName("repeat_track")
    private final boolean repeat;

    @SerializedName("ut_params")
    private final Map<String, String> utParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (this.repeat == r101.repeat) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.utParams, r101.utParams) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.eventName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.repeat == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        Map<String, String> r106 = this.utParams;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoMobParamsData(eventName=" + this.eventName + ", repeat=" + this.repeat + ", utParams=" + this.utParams + ')';
    }

    public f() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.eventName = "";
        this.repeat = false;
        this.utParams = r100;
    }
}
