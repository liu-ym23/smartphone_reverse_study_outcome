package com.ss.android.lark.dto.draft;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/dto/draft/ScheduleDraftInfo;", "Ljava/io/Serializable;", "<init>", "()V", "scheduleSendTime", "", "getScheduleSendTime", "()J", "setScheduleSendTime", "(J)V", "scheduleMessageId", "", "getScheduleMessageId", "()Ljava/lang/String;", "setScheduleMessageId", "(Ljava/lang/String;)V", "isPreScheduleMessage", "", "()Z", "setPreScheduleMessage", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScheduleDraftInfo implements Serializable {
    private boolean isPreScheduleMessage;
    private String scheduleMessageId;
    private long scheduleSendTime;

    public int hashCode() {
        return (this.scheduleMessageId.hashCode() * 31) + ((int) this.scheduleSendTime);
    }

    public String toString() {
        return "time = " + this.scheduleSendTime + ", message id = " + this.scheduleMessageId;
    }

    public ScheduleDraftInfo() {
        this.scheduleMessageId = "";
    }

    public final String getScheduleMessageId() {
        return this.scheduleMessageId;
    }

    public final long getScheduleSendTime() {
        return this.scheduleSendTime;
    }

    public final boolean isPreScheduleMessage() {
        return this.isPreScheduleMessage;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ScheduleDraftInfo) == true) goto L5;
        return false;
    L5:
        ScheduleDraftInfo r101 = (ScheduleDraftInfo) r100;
        if (this.scheduleSendTime == r101.scheduleSendTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scheduleMessageId, r101.scheduleMessageId) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final void setPreScheduleMessage(boolean r100) {
        this.isPreScheduleMessage = r100;
    }

    public final void setScheduleMessageId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scheduleMessageId = r100;
    }

    public final void setScheduleSendTime(long r100) {
        this.scheduleSendTime = r100;
    }
}
