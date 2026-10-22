package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasMsgInfo;", "Ljava/io/Serializable;", "sendMsgId", "", "replyMsgId", DBDefinition.TASK_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasMsgInfo implements Serializable {

    @SerializedName("reply_msg_id")
    public final String replyMsgId;

    @SerializedName("send_msg_id")
    public final String sendMsgId;

    @SerializedName("task_id")
    public final String taskId;

    public CanvasMsgInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CanvasMsgInfo copy$default(CanvasMsgInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.sendMsgId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.replyMsgId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.taskId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.sendMsgId;
    }

    public final String component2() {
        return this.replyMsgId;
    }

    public final String component3() {
        return this.taskId;
    }

    public final CanvasMsgInfo copy(String r100, String r101, String r102) {
        return new CanvasMsgInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CanvasMsgInfo) == true) goto L8;
        return false;
    L8:
        CanvasMsgInfo r101 = (CanvasMsgInfo) r100;
        if (Intrinsics.areEqual(this.sendMsgId, r101.sendMsgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyMsgId, r101.replyMsgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.sendMsgId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.replyMsgId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.taskId;
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
        return "CanvasMsgInfo(sendMsgId=" + this.sendMsgId + ", replyMsgId=" + this.replyMsgId + ", taskId=" + this.taskId + ')';
    }

    public CanvasMsgInfo(String r100, String r101, String r102) {
        this.sendMsgId = r100;
        this.replyMsgId = r101;
        this.taskId = r102;
    }

    public /* synthetic */ CanvasMsgInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
