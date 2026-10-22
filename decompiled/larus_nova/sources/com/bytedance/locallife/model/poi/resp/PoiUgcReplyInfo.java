package com.bytedance.locallife.model.poi.resp;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB)\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u000e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcReplyInfo;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Long;", "", "component2", "", "component3", "replyId", "replyType", "content", "copy", "(Ljava/lang/Long;ILjava/lang/String;)Lcom/bytedance/locallife/model/poi/resp/PoiUgcReplyInfo;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Long;", "getReplyId", "I", "getReplyType", "()I", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Long;ILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiUgcReplyInfo implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("content")
    private final String content;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private final Long replyId;

    @SerializedName("reply_type")
    private final int replyType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PoiUgcReplyInfo() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ PoiUgcReplyInfo copy$default(PoiUgcReplyInfo r100, Long r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.replyId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.replyType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.replyId;
    }

    public final int component2() {
        return this.replyType;
    }

    public final String component3() {
        return this.content;
    }

    public final PoiUgcReplyInfo copy(Long r100, int r101, String r102) {
        return new PoiUgcReplyInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcReplyInfo) == true) goto L8;
        return false;
    L8:
        PoiUgcReplyInfo r101 = (PoiUgcReplyInfo) r100;
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L12;
        return false;
    L12:
        if (this.replyType == r101.replyType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.replyId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.replyType) * 31;
        String r104 = this.content;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiUgcReplyInfo(replyId=" + this.replyId + ", replyType=" + this.replyType + ", content=" + this.content + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getReplyId() {
        return this.replyId;
    }

    public final int getReplyType() {
        return this.replyType;
    }

    public PoiUgcReplyInfo(Long r100, int r101, String r102) {
        this.replyId = r100;
        this.replyType = r101;
        this.content = r102;
    }

    public /* synthetic */ PoiUgcReplyInfo(Long r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
