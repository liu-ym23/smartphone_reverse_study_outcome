package com.obric.assistant.network.impl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/network/impl/ConfigQueryResponse;", "", "zone", "", "key", "value", "operateCursor", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getZone", "()Ljava/lang/String;", "getKey", "getValue", "getOperateCursor", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigQueryResponse {

    @SerializedName("Key")
    private final String key;

    @SerializedName("OperateCursor")
    private final long operateCursor;

    @SerializedName("Value")
    private final String value;

    @SerializedName("Zone")
    private final String zone;

    public ConfigQueryResponse() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ ConfigQueryResponse copy$default(ConfigQueryResponse r100, String r101, String r102, String r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.zone;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.key;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.value;
    L11:
        String r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.operateCursor;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.zone;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.value;
    }

    public final long component4() {
        return this.operateCursor;
    }

    public final ConfigQueryResponse copy(String r100, String r101, String r110, long r111) {
        return new ConfigQueryResponse(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConfigQueryResponse) == true) goto L8;
        return false;
    L8:
        ConfigQueryResponse r101 = (ConfigQueryResponse) r100;
        if (Intrinsics.areEqual(this.zone, r101.zone) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L18;
        return false;
    L18:
        if (this.operateCursor == r101.operateCursor) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.zone;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.key;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.value;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        long r109 = this.operateCursor;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ConfigQueryResponse(zone=" + this.zone + ", key=" + this.key + ", value=" + this.value + ", operateCursor=" + this.operateCursor + ')';
    }

    public final String getKey() {
        return this.key;
    }

    public final long getOperateCursor() {
        return this.operateCursor;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getZone() {
        return this.zone;
    }

    public ConfigQueryResponse(String r100, String r101, String r102, long r103) {
        this.zone = r100;
        this.key = r101;
        this.value = r102;
        this.operateCursor = r103;
    }

    public /* synthetic */ ConfigQueryResponse(String r100, String r101, String r102, long r103, int r104, DefaultConstructorMarker r105) {
        String r106 = null;
        if ((r104 & 1) == 0) goto L5;
        String r107 = null;
    L7:
        if ((r104 & 2) == 0) goto L9;
        String r108 = null;
    L11:
        if ((r104 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        this(r107, r108, r106, r103);
        return;
    L9:
        r108 = r101;
        goto L11
    L5:
        r107 = r100;
        goto L7
    }
}
