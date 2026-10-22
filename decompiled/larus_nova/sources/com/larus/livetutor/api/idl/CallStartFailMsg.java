package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/livetutor/api/idl/CallStartFailMsg;", "Ljava/io/Serializable;", LKBaseResponseModel.ERROR_NO_KEY, "", "error", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getErrno", "()Ljava/lang/Integer;", "setErrno", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/CallStartFailMsg;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallStartFailMsg implements Serializable {

    @SerializedName(LKBaseResponseModel.ERROR_NO_KEY)
    private Integer errno;

    @SerializedName("error")
    private String error;

    /* JADX WARN: Multi-variable type inference failed */
    public CallStartFailMsg() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CallStartFailMsg copy$default(CallStartFailMsg r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errno;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.error;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.errno;
    }

    public final String component2() {
        return this.error;
    }

    public final CallStartFailMsg copy(Integer r100, String r101) {
        return new CallStartFailMsg(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CallStartFailMsg) == true) goto L8;
        return false;
    L8:
        CallStartFailMsg r101 = (CallStartFailMsg) r100;
        if (Intrinsics.areEqual(this.errno, r101.errno) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.error, r101.error) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.errno;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.error;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CallStartFailMsg(errno=" + this.errno + ", error=" + this.error + ')';
    }

    public final Integer getErrno() {
        return this.errno;
    }

    public final String getError() {
        return this.error;
    }

    public final void setErrno(Integer r100) {
        this.errno = r100;
    }

    public final void setError(String r100) {
        this.error = r100;
    }

    public CallStartFailMsg(Integer r100, String r101) {
        this.errno = r100;
        this.error = r101;
    }

    public /* synthetic */ CallStartFailMsg(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
