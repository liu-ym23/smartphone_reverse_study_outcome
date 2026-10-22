package com.larus.network.interceptor.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/larus/network/interceptor/config/TimeoutConfig;", "", "connectTimeoutMs", "", "readTimeoutMs", "writeTimeoutMs", "protectTimeoutMs", "socketConnectTimeoutMs", "socketReadTimeoutMs", "socketWriteTimeoutMs", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getConnectTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReadTimeoutMs", "getWriteTimeoutMs", "getProtectTimeoutMs", "getSocketConnectTimeoutMs", "getSocketReadTimeoutMs", "getSocketWriteTimeoutMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/network/interceptor/config/TimeoutConfig;", "equals", "", "other", "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeoutConfig {

    @SerializedName("connect_timeout_ms")
    private final Long connectTimeoutMs;

    @SerializedName("protect_timeout_ms")
    private final Long protectTimeoutMs;

    @SerializedName("read_timeout_ms")
    private final Long readTimeoutMs;

    @SerializedName("socket_connect_timeout_ms")
    private final Long socketConnectTimeoutMs;

    @SerializedName("socket_read_timeout_ms")
    private final Long socketReadTimeoutMs;

    @SerializedName("socket_write_timeout_ms")
    private final Long socketWriteTimeoutMs;

    @SerializedName("write_timeout_ms")
    private final Long writeTimeoutMs;

    public TimeoutConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ TimeoutConfig copy$default(TimeoutConfig r100, Long r101, Long r102, Long r103, Long r104, Long r110, Long r111, Long r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.connectTimeoutMs;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.readTimeoutMs;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.writeTimeoutMs;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.protectTimeoutMs;
    L14:
        Long r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.socketConnectTimeoutMs;
    L17:
        Long r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.socketReadTimeoutMs;
    L20:
        Long r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.socketWriteTimeoutMs;
    L23:
        Long r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Long component1() {
        return this.connectTimeoutMs;
    }

    public final Long component2() {
        return this.readTimeoutMs;
    }

    public final Long component3() {
        return this.writeTimeoutMs;
    }

    public final Long component4() {
        return this.protectTimeoutMs;
    }

    public final Long component5() {
        return this.socketConnectTimeoutMs;
    }

    public final Long component6() {
        return this.socketReadTimeoutMs;
    }

    public final Long component7() {
        return this.socketWriteTimeoutMs;
    }

    public final TimeoutConfig copy(Long r110, Long r111, Long r112, Long r113, Long r114, Long r115, Long r116) {
        return new TimeoutConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimeoutConfig) == true) goto L8;
        return false;
    L8:
        TimeoutConfig r101 = (TimeoutConfig) r100;
        if (Intrinsics.areEqual(this.connectTimeoutMs, r101.connectTimeoutMs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.readTimeoutMs, r101.readTimeoutMs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.writeTimeoutMs, r101.writeTimeoutMs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.protectTimeoutMs, r101.protectTimeoutMs) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.socketConnectTimeoutMs, r101.socketConnectTimeoutMs) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.socketReadTimeoutMs, r101.socketReadTimeoutMs) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.socketWriteTimeoutMs, r101.socketWriteTimeoutMs) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Long r100 = this.connectTimeoutMs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.readTimeoutMs;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.writeTimeoutMs;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.protectTimeoutMs;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.socketConnectTimeoutMs;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.socketReadTimeoutMs;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.socketWriteTimeoutMs;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "TimeoutConfig(connectTimeoutMs=" + this.connectTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", writeTimeoutMs=" + this.writeTimeoutMs + ", protectTimeoutMs=" + this.protectTimeoutMs + ", socketConnectTimeoutMs=" + this.socketConnectTimeoutMs + ", socketReadTimeoutMs=" + this.socketReadTimeoutMs + ", socketWriteTimeoutMs=" + this.socketWriteTimeoutMs + ')';
    }

    public final Long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final Long getProtectTimeoutMs() {
        return this.protectTimeoutMs;
    }

    public final Long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final Long getSocketConnectTimeoutMs() {
        return this.socketConnectTimeoutMs;
    }

    public final Long getSocketReadTimeoutMs() {
        return this.socketReadTimeoutMs;
    }

    public final Long getSocketWriteTimeoutMs() {
        return this.socketWriteTimeoutMs;
    }

    public final Long getWriteTimeoutMs() {
        return this.writeTimeoutMs;
    }

    public TimeoutConfig(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106) {
        this.connectTimeoutMs = r100;
        this.readTimeoutMs = r101;
        this.writeTimeoutMs = r102;
        this.protectTimeoutMs = r103;
        this.socketConnectTimeoutMs = r104;
        this.socketReadTimeoutMs = r105;
        this.socketWriteTimeoutMs = r106;
    }

    public /* synthetic */ TimeoutConfig(Long r100, Long r101, Long r102, Long r110, Long r111, Long r112, Long r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Long r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Long r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Long r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Long r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Long r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Long r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Long r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
