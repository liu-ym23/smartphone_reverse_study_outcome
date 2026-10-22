package com.obric.assistant.network.impl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/network/impl/ConfigQueryRequest;", "", "zone", "", "kv", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getZone", "()Ljava/lang/String;", "getKv", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigQueryRequest {

    /* JADX INFO: renamed from: kv, reason: collision with root package name */
    @SerializedName("Key")
    private final String f390309kv;

    @SerializedName("Zone")
    private final String zone;

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigQueryRequest() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ConfigQueryRequest copy$default(ConfigQueryRequest r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.zone;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f390309kv;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.zone;
    }

    public final String component2() {
        return this.f390309kv;
    }

    public final ConfigQueryRequest copy(String r100, String r101) {
        return new ConfigQueryRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConfigQueryRequest) == true) goto L8;
        return false;
    L8:
        ConfigQueryRequest r101 = (ConfigQueryRequest) r100;
        if (Intrinsics.areEqual(this.zone, r101.zone) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390309kv, r101.f390309kv) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.zone;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f390309kv;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ConfigQueryRequest(zone=" + this.zone + ", kv=" + this.f390309kv + ')';
    }

    public final String getKv() {
        return this.f390309kv;
    }

    public final String getZone() {
        return this.zone;
    }

    public ConfigQueryRequest(String r100, String r101) {
        this.zone = r100;
        this.f390309kv = r101;
    }

    public /* synthetic */ ConfigQueryRequest(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
