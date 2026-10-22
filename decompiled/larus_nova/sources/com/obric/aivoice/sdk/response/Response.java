package com.obric.aivoice.sdk.response;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/obric/aivoice/sdk/response/Response;", ExifInterface.GPS_DIRECTION_TRUE, "", "errorCode", "", "errorInfo", "", "data", "isFinish", "", "isTaskId", "timeLog", "Landroid/os/Bundle;", "(ILjava/lang/String;Ljava/lang/Object;ZZLandroid/os/Bundle;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getErrorCode", "()I", "getErrorInfo", "()Ljava/lang/String;", "()Z", "setFinish", "(Z)V", "setTaskId", "getTimeLog", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Object;ZZLandroid/os/Bundle;)Lcom/obric/aivoice/sdk/response/Response;", "equals", "other", "hashCode", "toString", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Response<T> {
    private T data;
    private final int errorCode;
    private final String errorInfo;
    private boolean isFinish;
    private boolean isTaskId;
    private final Bundle timeLog;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response r100, int r101, String r102, Object r103, boolean r104, boolean r105, Bundle r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.errorInfo;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.data;
    L11:
        Object r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isFinish;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isTaskId;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.timeLog;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorInfo;
    }

    public final T component3() {
        return this.data;
    }

    public final boolean component4() {
        return this.isFinish;
    }

    public final boolean component5() {
        return this.isTaskId;
    }

    public final Bundle component6() {
        return this.timeLog;
    }

    public final Response<T> copy(int r100, String r110, T r111, boolean r112, boolean r113, Bundle r114) {
        return new Response(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r101 = (Response) r100;
        if (this.errorCode == r101.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorInfo, r101.errorInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (this.isFinish == r101.isFinish) goto L21;
        return false;
    L21:
        if (this.isTaskId == r101.isTaskId) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.timeLog, r101.timeLog) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r100 = this.errorCode * 31;
        String r101 = this.errorInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        T r105 = this.data;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.isFinish;
        ?? r109 = 1;
        ?? r110 = r108;
        if (r108 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r107 + r110) * 31;
        boolean r112 = this.isTaskId;
        if (r112 == true) goto L17;
        r109 = r112;
    L17:
        int r113 = (r111 + r109) * 31;
        Bundle r114 = this.timeLog;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Response(errorCode=" + this.errorCode + ", errorInfo=" + this.errorInfo + ", data=" + this.data + ", isFinish=" + this.isFinish + ", isTaskId=" + this.isTaskId + ", timeLog=" + this.timeLog + ')';
    }

    public final T getData() {
        return this.data;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorInfo() {
        return this.errorInfo;
    }

    public final Bundle getTimeLog() {
        return this.timeLog;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final boolean isTaskId() {
        return this.isTaskId;
    }

    public final void setData(T r100) {
        this.data = r100;
    }

    public final void setFinish(boolean r100) {
        this.isFinish = r100;
    }

    public final void setTaskId(boolean r100) {
        this.isTaskId = r100;
    }

    public Response(int r100, String r101, T r102, boolean r103, boolean r104, Bundle r105) {
        this.errorCode = r100;
        this.errorInfo = r101;
        this.data = r102;
        this.isFinish = r103;
        this.isTaskId = r104;
        this.timeLog = r105;
    }

    public /* synthetic */ Response(int r100, String r101, Object r102, boolean r110, boolean r111, Bundle r112, int r113, DefaultConstructorMarker r114) {
        Bundle r103 = null;
        if ((r113 & 2) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Object r105 = null;
    L10:
        boolean r106 = false;
        if ((r113 & 8) == 0) goto L13;
        boolean r107 = false;
    L15:
        if ((r113 & 16) != 0) goto L19;
        r106 = r111;
    L19:
        if ((r113 & 32) != 0) goto L22;
        r103 = r112;
    L22:
        this(r100, r104, r105, r107, r106, r103);
        return;
    L13:
        r107 = r110;
        goto L15
    L9:
        r105 = r102;
        goto L10
    L5:
        r104 = r101;
        goto L7
    }
}
