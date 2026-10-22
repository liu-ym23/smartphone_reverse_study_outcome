package com.ss.android.lark.passport.signinsdk_api.base.network;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.passport.signinsdk_api.base.network.bizflow.BizFlowPayload;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J7\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000e¨\u0006-"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/ResponseModel;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "code", "", "message", "", "originData", "Lcom/alibaba/fastjson/JSONObject;", "bizFlowPayload", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlowPayload;", "<init>", "(ILjava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlowPayload;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getOriginData", "()Lcom/alibaba/fastjson/JSONObject;", "getBizFlowPayload", "()Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlowPayload;", UniContext.KEY_OF_BIZ_CODE, "getBiz_code", "setBiz_code", "(I)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "SUCCESS_CODE", "getSUCCESS_CODE", "isSuccess", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResponseModel<T> implements Serializable {
    private final int SUCCESS_CODE;
    private final BizFlowPayload bizFlowPayload;
    private int biz_code;
    private final int code;
    private T data;
    private final String message;
    private final JSONObject originData;

    public static /* synthetic */ ResponseModel copy$default(ResponseModel r100, int r101, String r102, JSONObject r103, BizFlowPayload r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.originData;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bizFlowPayload;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final JSONObject component3() {
        return this.originData;
    }

    public final BizFlowPayload component4() {
        return this.bizFlowPayload;
    }

    public final ResponseModel<T> copy(int r100, String r101, JSONObject r102, BizFlowPayload r103) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "originData");
        Intrinsics.checkNotNullParameter(r103, "bizFlowPayload");
        return new ResponseModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResponseModel) == true) goto L8;
        return false;
    L8:
        ResponseModel r101 = (ResponseModel) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originData, r101.originData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizFlowPayload, r101.bizFlowPayload) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.code * 31) + this.message.hashCode()) * 31) + this.originData.hashCode()) * 31) + this.bizFlowPayload.hashCode();
    }

    public String toString() {
        return "ResponseModel(code=" + this.code + ", message=" + this.message + ", originData=" + this.originData + ", bizFlowPayload=" + this.bizFlowPayload + ')';
    }

    public final boolean isSuccess() {
        if (this.code != this.SUCCESS_CODE) goto L5;
    L8:
        return true;
    L5:
        if (this.data != null) goto L8;
        return false;
    }

    public final BizFlowPayload getBizFlowPayload() {
        return this.bizFlowPayload;
    }

    public final int getBiz_code() {
        return this.biz_code;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final JSONObject getOriginData() {
        return this.originData;
    }

    public final int getSUCCESS_CODE() {
        return this.SUCCESS_CODE;
    }

    public final void setBiz_code(int r100) {
        this.biz_code = r100;
    }

    public final void setData(T r100) {
        this.data = r100;
    }

    public ResponseModel(int r100, String r101, JSONObject r102, BizFlowPayload r103) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "originData");
        Intrinsics.checkNotNullParameter(r103, "bizFlowPayload");
        this.code = r100;
        this.message = r101;
        this.originData = r102;
        this.bizFlowPayload = r103;
        this.biz_code = -9999;
    }
}
