package com.larus.bmhome.chat.resp;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/resp/NestedFileRemoteState;", "", "code", "", "msg", "", "data", "Lcom/larus/bmhome/chat/resp/EntityState;", "<init>", "(JLjava/lang/String;Lcom/larus/bmhome/chat/resp/EntityState;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/bmhome/chat/resp/EntityState;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedFileRemoteState {

    @SerializedName("code")
    private final long code;

    @SerializedName("data")
    private final EntityState data;

    @SerializedName("msg")
    private final String msg;

    public NestedFileRemoteState() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ NestedFileRemoteState copy$default(NestedFileRemoteState r100, long r101, String r102, EntityState r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final EntityState component3() {
        return this.data;
    }

    public final NestedFileRemoteState copy(long r100, String r101, EntityState r102) {
        return new NestedFileRemoteState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NestedFileRemoteState) == true) goto L8;
        return false;
    L8:
        NestedFileRemoteState r101 = (NestedFileRemoteState) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.code;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.msg;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        EntityState r106 = this.data;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        return r105 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final long getCode() {
        return this.code;
    }

    public final EntityState getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public NestedFileRemoteState(long r100, String r101, EntityState r102) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    public /* synthetic */ NestedFileRemoteState(long r100, String r101, EntityState r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
