package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J4\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u000f\u001a\u00020\bHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashPermissionInfoResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "component2", "", "component3", "status", "popupInfo", "requestId", "copy", "(Ljava/lang/Integer;Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;Ljava/lang/String;)Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashPermissionInfoResponse;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getStatus", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "getPopupInfo", "()Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;Ljava/lang/String;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlashPermissionInfoResponse extends g implements Serializable {

    @SerializedName("popup_info")
    private final ECV2PopupInfo popupInfo;

    @SerializedName("log_id")
    private final String requestId;

    @SerializedName("status")
    private final Integer status;

    public ECFlashPermissionInfoResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ECFlashPermissionInfoResponse copy$default(ECFlashPermissionInfoResponse r0, Integer r1, ECV2PopupInfo r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.popupInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.requestId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.status;
    }

    public final ECV2PopupInfo component2() {
        return this.popupInfo;
    }

    public final String component3() {
        return this.requestId;
    }

    public final ECFlashPermissionInfoResponse copy(Integer r2, ECV2PopupInfo r3, String r4) {
        return new ECFlashPermissionInfoResponse(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECFlashPermissionInfoResponse) == false) goto L12;
        ECFlashPermissionInfoResponse r4 = (ECFlashPermissionInfoResponse) r3;
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popupInfo, r4.popupInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.requestId, r4.requestId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.status;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECV2PopupInfo r4 = this.popupInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.requestId;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECFlashPermissionInfoResponse(status=" + this.status + ", popupInfo=" + this.popupInfo + ", requestId=" + this.requestId + ")";
    }

    public final ECV2PopupInfo getPopupInfo() {
        return this.popupInfo;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public ECFlashPermissionInfoResponse(Integer r1, ECV2PopupInfo r2, String r3) {
        this.status = r1;
        this.popupInfo = r2;
        this.requestId = r3;
    }

    public /* synthetic */ ECFlashPermissionInfoResponse(Integer r2, ECV2PopupInfo r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
