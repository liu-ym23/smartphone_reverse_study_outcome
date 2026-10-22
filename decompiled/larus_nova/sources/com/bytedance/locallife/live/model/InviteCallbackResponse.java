package com.bytedance.locallife.live.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/live/model/InviteCallbackResponse;", "Ljava/io/Serializable;", "statusCode", "", a.KEY_STATUS_MSG, "", "data", "Lcom/bytedance/locallife/live/model/InviteCallbackData;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/locallife/live/model/InviteCallbackData;)V", "getData", "()Lcom/bytedance/locallife/live/model/InviteCallbackData;", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/locallife/live/model/InviteCallbackData;)Lcom/bytedance/locallife/live/model/InviteCallbackResponse;", "equals", "", "other", "", "hashCode", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class InviteCallbackResponse implements Serializable {

    @SerializedName("data")
    private final InviteCallbackData data;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    public InviteCallbackResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InviteCallbackResponse copy$default(InviteCallbackResponse r100, Integer r101, String r102, InviteCallbackData r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.statusMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.statusMsg;
    }

    public final InviteCallbackData component3() {
        return this.data;
    }

    public final InviteCallbackResponse copy(Integer r100, String r101, InviteCallbackData r102) {
        return new InviteCallbackResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InviteCallbackResponse) == true) goto L8;
        return false;
    L8:
        InviteCallbackResponse r101 = (InviteCallbackResponse) r100;
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.statusCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.statusMsg;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        InviteCallbackData r107 = this.data;
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
        return "InviteCallbackResponse(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", data=" + this.data + ')';
    }

    public final InviteCallbackData getData() {
        return this.data;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public InviteCallbackResponse(Integer r100, String r101, InviteCallbackData r102) {
        this.statusCode = r100;
        this.statusMsg = r101;
        this.data = r102;
    }

    public /* synthetic */ InviteCallbackResponse(Integer r100, String r101, InviteCallbackData r102, int r103, DefaultConstructorMarker r104) {
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
