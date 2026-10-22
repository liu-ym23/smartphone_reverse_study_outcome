package com.ss.android.lark.chameleon.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/ResponseJsData;", "", "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "callbackId", "", "data", "extraStr", "(Lcom/ss/android/lark/chameleon/bridge/Status;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getCallbackId", "()Ljava/lang/String;", "setCallbackId", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getExtraStr", "setExtraStr", "getStatus", "()Lcom/ss/android/lark/chameleon/bridge/Status;", "setStatus", "(Lcom/ss/android/lark/chameleon/bridge/Status;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResponseJsData {
    private String callbackId;
    private Object data;
    private Object extraStr;
    private Status status;

    public ResponseJsData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResponseJsData copy$default(ResponseJsData r100, Status r101, String r102, Object r103, Object r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.callbackId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extraStr;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Status component1() {
        return this.status;
    }

    public final String component2() {
        return this.callbackId;
    }

    public final Object component3() {
        return this.data;
    }

    public final Object component4() {
        return this.extraStr;
    }

    public final ResponseJsData copy(Status r100, String r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r101, "callbackId");
        return new ResponseJsData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResponseJsData) == true) goto L8;
        return false;
    L8:
        ResponseJsData r101 = (ResponseJsData) r100;
        if (this.status == r101.status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.callbackId, r101.callbackId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraStr, r101.extraStr) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Status r100 = this.status;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.callbackId.hashCode()) * 31;
        Object r104 = this.data;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.extraStr;
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
        return "ResponseJsData(status=" + this.status + ", callbackId=" + this.callbackId + ", data=" + this.data + ", extraStr=" + this.extraStr + ')';
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final Object getData() {
        return this.data;
    }

    public final Object getExtraStr() {
        return this.extraStr;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setCallbackId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.callbackId = r100;
    }

    public final void setData(Object r100) {
        this.data = r100;
    }

    public final void setExtraStr(Object r100) {
        this.extraStr = r100;
    }

    public final void setStatus(Status r100) {
        this.status = r100;
    }

    public ResponseJsData(Status r100, String r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r101, "callbackId");
        this.status = r100;
        this.callbackId = r101;
        this.data = r102;
        this.extraStr = r103;
    }

    public /* synthetic */ ResponseJsData(Status r100, String r101, Object r102, Object r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
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
