package com.obric.assistant.network.api.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vea.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricStopTaskRequest;", "", RemoteMessageConst.MSGID, "", "extra", "", "", "common", "Lcom/obric/assistant/network/api/bean/CommonData;", "<init>", "(Ljava/lang/Long;Ljava/util/Map;Lcom/obric/assistant/network/api/bean/CommonData;)V", "getMsgId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtra", "()Ljava/util/Map;", "getCommon", "()Lcom/obric/assistant/network/api/bean/CommonData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/util/Map;Lcom/obric/assistant/network/api/bean/CommonData;)Lcom/obric/assistant/network/api/bean/ObricStopTaskRequest;", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStopTaskRequest {

    @SerializedName("common")
    private final a common;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("msg_id")
    private final Long msgId;

    public ObricStopTaskRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricStopTaskRequest copy$default(ObricStopTaskRequest r100, Long r101, Map r102, a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.msgId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.extra;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.common;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.msgId;
    }

    public final Map<String, String> component2() {
        return this.extra;
    }

    public final a component3() {
        return this.common;
    }

    public final ObricStopTaskRequest copy(Long r100, Map<String, String> r101, a r102) {
        return new ObricStopTaskRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricStopTaskRequest) == true) goto L8;
        return false;
    L8:
        ObricStopTaskRequest r101 = (ObricStopTaskRequest) r100;
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.common, r101.common) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.msgId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.extra;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.common;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricStopTaskRequest(msgId=" + this.msgId + ", extra=" + this.extra + ", common=" + this.common + ')';
    }

    public final a getCommon() {
        return this.common;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Long getMsgId() {
        return this.msgId;
    }

    public ObricStopTaskRequest(Long r100, Map<String, String> r101, a r102) {
        this.msgId = r100;
        this.extra = r101;
        this.common = r102;
    }

    public /* synthetic */ ObricStopTaskRequest(Long r100, Map r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
