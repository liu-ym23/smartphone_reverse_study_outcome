package com.larus.business.debug.base.controller.advancedWhite;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/business/debug/base/controller/advancedWhite/OpAdvancedWhiteSwitchResponse;", "", "code", "", "msg", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMsg", "()Ljava/lang/String;", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpAdvancedWhiteSwitchResponse {

    @SerializedName("code")
    private final Long code;

    @SerializedName("msg")
    private final String msg;

    /* JADX WARN: Multi-variable type inference failed */
    public OpAdvancedWhiteSwitchResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "OpAdvancedWhiteSwitchResponse(code=" + this.code + ", msg=" + this.msg + ')';
    }

    public final Long getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public OpAdvancedWhiteSwitchResponse(Long r100, String r101) {
        this.code = r100;
        this.msg = r101;
    }

    public /* synthetic */ OpAdvancedWhiteSwitchResponse(Long r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0L;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
