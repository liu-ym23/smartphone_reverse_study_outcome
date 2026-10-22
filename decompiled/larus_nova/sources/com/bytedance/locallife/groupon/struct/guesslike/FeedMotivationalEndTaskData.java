package com.bytedance.locallife.groupon.struct.guesslike;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/groupon/struct/guesslike/FeedMotivationalEndTaskData;", "", "msg", "", "status", "", "trackParams", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTrackParams", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/locallife/groupon/struct/guesslike/FeedMotivationalEndTaskData;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FeedMotivationalEndTaskData {

    @SerializedName("msg")
    private String msg;

    @SerializedName("status")
    private Integer status;

    @SerializedName("track_params")
    private Map<String, ? extends Object> trackParams;

    public FeedMotivationalEndTaskData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedMotivationalEndTaskData copy$default(FeedMotivationalEndTaskData r100, String r101, Integer r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.msg;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.status;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.trackParams;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.msg;
    }

    public final Integer component2() {
        return this.status;
    }

    public final Map<String, Object> component3() {
        return this.trackParams;
    }

    public final FeedMotivationalEndTaskData copy(String r100, Integer r101, Map<String, ? extends Object> r102) {
        return new FeedMotivationalEndTaskData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedMotivationalEndTaskData) == true) goto L8;
        return false;
    L8:
        FeedMotivationalEndTaskData r101 = (FeedMotivationalEndTaskData) r100;
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.msg;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, ? extends Object> r107 = this.trackParams;
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
        return "FeedMotivationalEndTaskData(msg=" + this.msg + ", status=" + this.status + ", trackParams=" + this.trackParams + ')';
    }

    public final String getMsg() {
        return this.msg;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final void setMsg(String r100) {
        this.msg = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setTrackParams(Map<String, ? extends Object> r100) {
        this.trackParams = r100;
    }

    public FeedMotivationalEndTaskData(String r100, Integer r101, Map<String, ? extends Object> r102) {
        this.msg = r100;
        this.status = r101;
        this.trackParams = r102;
    }

    public /* synthetic */ FeedMotivationalEndTaskData(String r100, Integer r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
