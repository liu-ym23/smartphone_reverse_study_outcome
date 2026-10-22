package com.larus.bmhome.chat.cmd;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JF\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/cmd/InnerVideoPreloadInfo;", "Ljava/io/Serializable;", "reqId", "", "cacheTime", "", "itemIds", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)V", "getReqId", "()Ljava/lang/String;", "setReqId", "(Ljava/lang/String;)V", "getCacheTime", "()Ljava/lang/Long;", "setCacheTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getItemIds", "()Ljava/util/List;", "setItemIds", "(Ljava/util/List;)V", "getMessageId", "setMessageId", "toString", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)Lcom/larus/bmhome/chat/cmd/InnerVideoPreloadInfo;", "equals", "", "other", "", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InnerVideoPreloadInfo implements Serializable {

    @SerializedName("cache_time")
    private Long cacheTime;

    @SerializedName("item_ids")
    private List<String> itemIds;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private String messageId;

    @SerializedName("req_id")
    private String reqId;

    public InnerVideoPreloadInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InnerVideoPreloadInfo copy$default(InnerVideoPreloadInfo r100, String r101, Long r102, List r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.reqId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.cacheTime;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.itemIds;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.messageId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.reqId;
    }

    public final Long component2() {
        return this.cacheTime;
    }

    public final List<String> component3() {
        return this.itemIds;
    }

    public final String component4() {
        return this.messageId;
    }

    public final InnerVideoPreloadInfo copy(String r100, Long r101, List<String> r102, String r103) {
        return new InnerVideoPreloadInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InnerVideoPreloadInfo) == true) goto L8;
        return false;
    L8:
        InnerVideoPreloadInfo r101 = (InnerVideoPreloadInfo) r100;
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cacheTime, r101.cacheTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.itemIds, r101.itemIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.reqId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.cacheTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.itemIds;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.messageId;
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

    public final Long getCacheTime() {
        return this.cacheTime;
    }

    public final List<String> getItemIds() {
        return this.itemIds;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final void setCacheTime(Long r100) {
        this.cacheTime = r100;
    }

    public final void setItemIds(List<String> r100) {
        this.itemIds = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setReqId(String r100) {
        this.reqId = r100;
    }

    public InnerVideoPreloadInfo(String r100, Long r101, List<String> r102, String r103) {
        this.reqId = r100;
        this.cacheTime = r101;
        this.itemIds = r102;
        this.messageId = r103;
    }

    public /* synthetic */ InnerVideoPreloadInfo(String r100, Long r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
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
