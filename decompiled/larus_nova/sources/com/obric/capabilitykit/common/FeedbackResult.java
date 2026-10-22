package com.obric.capabilitykit.common;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/FeedbackResult;", "", "code", "", "msg", "", "data", "uiType", "replyFor", "shouldNotify", "", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getMsg", "getReplyFor", "getShouldNotify", "()Z", "getUiType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FeedbackResult {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final String data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("replyFor")
    private final String replyFor;

    @SerializedName("shouldNotify")
    private final boolean shouldNotify;

    @SerializedName("uiType")
    private final int uiType;

    public FeedbackResult() {
        this(0, null, null, 0, null, false, 63, null);
    }

    public FeedbackResult(int r100, String r101, String r102, int r103, String r104, boolean r105) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
        this.uiType = r103;
        this.replyFor = r104;
        this.shouldNotify = r105;
    }

    public /* synthetic */ FeedbackResult(int r100, String r101, String r102, int r103, String r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        int r105 = 0;
        if ((r111 & 1) == 0) goto L5;
        int r113 = 0;
    L6:
        String r106 = null;
        if ((r111 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r111 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        r104 = "";
    L21:
        String r108 = r104;
        if ((r111 & 32) == 0) goto L24;
        boolean r114 = true;
    L25:
        this(r113, r107, r106, r105, r108, r114);
        return;
    L24:
        r114 = r110;
        goto L25
    L9:
        r107 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L6
    }

    public static /* synthetic */ FeedbackResult copy$default(FeedbackResult r100, int r101, String r102, String r103, int r104, String r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.msg;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.data;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.uiType;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.replyFor;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.shouldNotify;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.data;
    }

    public final int component4() {
        return this.uiType;
    }

    public final String component5() {
        return this.replyFor;
    }

    public final boolean component6() {
        return this.shouldNotify;
    }

    public final FeedbackResult copy(int r100, String r110, String r111, int r112, String r113, boolean r114) {
        return new FeedbackResult(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackResult) == true) goto L8;
        return false;
    L8:
        FeedbackResult r101 = (FeedbackResult) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (this.uiType == r101.uiType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replyFor, r101.replyFor) == true) goto L24;
        return false;
    L24:
        if (this.shouldNotify == r101.shouldNotify) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    public final int getUiType() {
        return this.uiType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.msg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.data;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.uiType) * 31;
        String r108 = this.replyFor;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        boolean r110 = this.shouldNotify;
        ?? r111 = r110;
        if (r110 == false) goto L18;
        r111 = 1;
    L18:
        return r109 + r111;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", shouldNotify=" + this.shouldNotify + ')';
    }
}
