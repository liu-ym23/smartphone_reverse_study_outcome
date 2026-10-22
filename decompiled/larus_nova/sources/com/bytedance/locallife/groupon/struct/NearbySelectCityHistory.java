package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbySelectCityHistory;", "", "uid", "", "history", "(Ljava/lang/String;Ljava/lang/String;)V", "getHistory", "()Ljava/lang/String;", "setHistory", "(Ljava/lang/String;)V", "getUid", "setUid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbySelectCityHistory {

    @SerializedName("history")
    private String history;

    @SerializedName("uid")
    private String uid;

    /* JADX WARN: Multi-variable type inference failed */
    public NearbySelectCityHistory() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NearbySelectCityHistory copy$default(NearbySelectCityHistory r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.uid;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.history;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.history;
    }

    public final NearbySelectCityHistory copy(String r100, String r101) {
        return new NearbySelectCityHistory(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbySelectCityHistory) == true) goto L8;
        return false;
    L8:
        NearbySelectCityHistory r101 = (NearbySelectCityHistory) r100;
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.history, r101.history) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.uid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.history;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbySelectCityHistory(uid=" + this.uid + ", history=" + this.history + ')';
    }

    public final String getHistory() {
        return this.history;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setHistory(String r100) {
        this.history = r100;
    }

    public final void setUid(String r100) {
        this.uid = r100;
    }

    public NearbySelectCityHistory(String r100, String r101) {
        this.uid = r100;
        this.history = r101;
    }

    public /* synthetic */ NearbySelectCityHistory(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
