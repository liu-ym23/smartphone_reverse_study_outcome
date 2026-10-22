package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;", "Ljava/io/Serializable;", "replyCntNum", "", "replyListScheme", "", "replyList", "", "Lcom/bytedance/locallife/model/poi/resp/RateReplyStruct;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)V", "getReplyCntNum", "()Ljava/lang/Long;", "setReplyCntNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReplyList", "()Ljava/util/List;", "getReplyListScheme", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ReplyGroup implements Serializable {

    @SerializedName("reply_cnt_num")
    private Long replyCntNum;

    @SerializedName("outside_reply_list")
    private final List<RateReplyStruct> replyList;

    @SerializedName("reply_list_schema")
    private final String replyListScheme;

    public ReplyGroup() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReplyGroup copy$default(ReplyGroup r100, Long r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.replyCntNum;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.replyListScheme;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.replyList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.replyCntNum;
    }

    public final String component2() {
        return this.replyListScheme;
    }

    public final List<RateReplyStruct> component3() {
        return this.replyList;
    }

    public final ReplyGroup copy(Long r100, String r101, List<RateReplyStruct> r102) {
        return new ReplyGroup(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReplyGroup) == true) goto L8;
        return false;
    L8:
        ReplyGroup r101 = (ReplyGroup) r100;
        if (Intrinsics.areEqual(this.replyCntNum, r101.replyCntNum) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyListScheme, r101.replyListScheme) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.replyList, r101.replyList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.replyCntNum;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.replyListScheme;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<RateReplyStruct> r107 = this.replyList;
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
        return "ReplyGroup(replyCntNum=" + this.replyCntNum + ", replyListScheme=" + this.replyListScheme + ", replyList=" + this.replyList + ')';
    }

    public final Long getReplyCntNum() {
        return this.replyCntNum;
    }

    public final List<RateReplyStruct> getReplyList() {
        return this.replyList;
    }

    public final String getReplyListScheme() {
        return this.replyListScheme;
    }

    public final void setReplyCntNum(Long r100) {
        this.replyCntNum = r100;
    }

    public ReplyGroup(Long r100, String r101, List<RateReplyStruct> r102) {
        this.replyCntNum = r100;
        this.replyListScheme = r101;
        this.replyList = r102;
    }

    public /* synthetic */ ReplyGroup(Long r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0L;
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
