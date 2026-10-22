package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0006\u0010\u0011\u001a\u00020\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItem;", "Ljava/io/Serializable;", "messageId", "", "type", "Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;)V", "getMessageId", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;", "equals", "", "other", "", "toString", "isPreScheduleMessage", "component1", "component2", "copy", "hashCode", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScheduleMessageItem implements Serializable {
    private final String messageId;
    private final ScheduleMessageItemType type;

    public static /* synthetic */ ScheduleMessageItem copy$default(ScheduleMessageItem r100, String r101, ScheduleMessageItemType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.messageId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.messageId;
    }

    public final ScheduleMessageItemType component2() {
        return this.type;
    }

    public final ScheduleMessageItem copy(String r100, ScheduleMessageItemType r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "type");
        return new ScheduleMessageItem(r100, r101);
    }

    public int hashCode() {
        return (this.messageId.hashCode() * 31) + this.type.hashCode();
    }

    public final boolean isPreScheduleMessage() {
        if (this.type != ScheduleMessageItemType.QUASI_SCHEDULE_MESSAGE) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("message id = " + this.messageId);
        r100.append(", type = " + this.type);
        return r100.toString();
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final ScheduleMessageItemType getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ScheduleMessageItem) == true) goto L5;
        return false;
    L5:
        ScheduleMessageItem r101 = (ScheduleMessageItem) r100;
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L8;
        return false;
    L8:
        if (this.type != r101.type) goto L12;
        return true;
    L12:
        return false;
    }

    public ScheduleMessageItem(String r100, ScheduleMessageItemType r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.messageId = r100;
        this.type = r101;
    }
}
