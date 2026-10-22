package com.obric.assistant.network.api.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricRestoreImageResponse;", "", "code", "", "msg", "", "success", "", "failUris", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailUris", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/obric/assistant/network/api/bean/ObricRestoreImageResponse;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRestoreImageResponse {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("fail_uris")
    private final List<String> failUris;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("success")
    private final Boolean success;

    public ObricRestoreImageResponse() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricRestoreImageResponse copy$default(ObricRestoreImageResponse r100, Integer r101, String r102, Boolean r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.success;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.failUris;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final Boolean component3() {
        return this.success;
    }

    public final List<String> component4() {
        return this.failUris;
    }

    public final ObricRestoreImageResponse copy(Integer r100, String r101, Boolean r102, List<String> r103) {
        return new ObricRestoreImageResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricRestoreImageResponse) == true) goto L8;
        return false;
    L8:
        ObricRestoreImageResponse r101 = (ObricRestoreImageResponse) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.failUris, r101.failUris) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.code;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.msg;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.success;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.failUris;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ObricRestoreImageResponse(code=" + this.code + ", msg=" + this.msg + ", success=" + this.success + ", failUris=" + this.failUris + ')';
    }

    public final Integer getCode() {
        return this.code;
    }

    public final List<String> getFailUris() {
        return this.failUris;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public ObricRestoreImageResponse(Integer r100, String r101, Boolean r102, List<String> r103) {
        this.code = r100;
        this.msg = r101;
        this.success = r102;
        this.failUris = r103;
    }

    public /* synthetic */ ObricRestoreImageResponse(Integer r100, String r101, Boolean r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
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
