package com.larus.im.internal.audio.proto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ld9.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/im/internal/audio/proto/BatchGetRTCTokenResponse;", "Ljava/io/Serializable;", "statusCode", "", "message", "", "data", "Lcom/larus/im/internal/audio/proto/BatchGetToken;", "<init>", "(JLjava/lang/String;Lcom/larus/im/internal/audio/proto/BatchGetToken;)V", "getStatusCode", "()J", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/larus/im/internal/audio/proto/BatchGetToken;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatchGetRTCTokenResponse implements Serializable {

    @SerializedName("data")
    private final a data;

    @SerializedName("msg")
    private final String message;

    @SerializedName("code")
    private final long statusCode;

    public BatchGetRTCTokenResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BatchGetRTCTokenResponse copy$default(BatchGetRTCTokenResponse r100, long r101, String r102, a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.message;
    }

    public final a component3() {
        return this.data;
    }

    public final BatchGetRTCTokenResponse copy(long r100, String r101, a r102) {
        return new BatchGetRTCTokenResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BatchGetRTCTokenResponse) == true) goto L8;
        return false;
    L8:
        BatchGetRTCTokenResponse r101 = (BatchGetRTCTokenResponse) r100;
        if (this.statusCode == r101.statusCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.statusCode;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.message;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        a r106 = this.data;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        return r105 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "BatchGetRTCTokenResponse(statusCode=" + this.statusCode + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public final a getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getStatusCode() {
        return this.statusCode;
    }

    public BatchGetRTCTokenResponse(long r100, String r101, a r102) {
        this.statusCode = r100;
        this.message = r101;
        this.data = r102;
    }

    public /* synthetic */ BatchGetRTCTokenResponse(long r100, String r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
