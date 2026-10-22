package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.TimeTransformAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/resp/ChatLimit;", "", "isLimit", "", "limitTime", "", "limitTips", "", "<init>", "(ZJLjava/lang/String;)V", "()Z", "getLimitTime", "()J", "getLimitTips", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatLimit {

    @SerializedName("is_limit")
    private final boolean isLimit;

    @SerializedName("limit_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final long limitTime;

    @SerializedName("limit_tips")
    private final String limitTips;

    public ChatLimit() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ ChatLimit copy$default(ChatLimit r100, boolean r101, long r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isLimit;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.limitTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.limitTips;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isLimit;
    }

    public final long component2() {
        return this.limitTime;
    }

    public final String component3() {
        return this.limitTips;
    }

    public final ChatLimit copy(boolean r100, long r101, String r102) {
        return new ChatLimit(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatLimit) == true) goto L8;
        return false;
    L8:
        ChatLimit r101 = (ChatLimit) r100;
        if (this.isLimit == r101.isLimit) goto L12;
        return false;
    L12:
        if (this.limitTime == r101.limitTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.limitTips, r101.limitTips) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isLimit == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.limitTime;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.limitTips;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatLimit(isLimit=" + this.isLimit + ", limitTime=" + this.limitTime + ", limitTips=" + this.limitTips + ')';
    }

    public final long getLimitTime() {
        return this.limitTime;
    }

    public final String getLimitTips() {
        return this.limitTips;
    }

    public final boolean isLimit() {
        return this.isLimit;
    }

    public ChatLimit(boolean r100, long r101, String r102) {
        this.isLimit = r100;
        this.limitTime = r101;
        this.limitTips = r102;
    }

    public /* synthetic */ ChatLimit(boolean r100, long r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 60000;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "LIMITING";
    L11:
        this(r100, r101, r102);
    }
}
