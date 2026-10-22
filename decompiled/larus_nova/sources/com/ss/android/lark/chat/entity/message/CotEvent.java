package com.ss.android.lark.chat.entity.message;

import com.heytap.mcssdk.constant.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotEvent;", "Ljava/io/Serializable;", b.f276361k, "", "eventType", "Lcom/ss/android/lark/chat/entity/message/CotEventType;", "content", "timestamp", "", "createdAt", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/CotEventType;Ljava/lang/String;JJ)V", "getEventId", "()Ljava/lang/String;", "getEventType", "()Lcom/ss/android/lark/chat/entity/message/CotEventType;", "getContent", "getTimestamp", "()J", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotEvent implements Serializable {
    private final String content;
    private final long createdAt;
    private final String eventId;
    private final CotEventType eventType;
    private final long timestamp;

    public static /* synthetic */ CotEvent copy$default(CotEvent r100, String r101, CotEventType r102, String r103, long r104, long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.eventId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.eventType;
    L8:
        CotEventType r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.timestamp;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.createdAt;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final String component1() {
        return this.eventId;
    }

    public final CotEventType component2() {
        return this.eventType;
    }

    public final String component3() {
        return this.content;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final long component5() {
        return this.createdAt;
    }

    public final CotEvent copy(String r110, CotEventType r111, String r112, long r113, long r114) {
        Intrinsics.checkNotNullParameter(r110, b.f276361k);
        Intrinsics.checkNotNullParameter(r111, "eventType");
        Intrinsics.checkNotNullParameter(r112, "content");
        return new CotEvent(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CotEvent) == true) goto L8;
        return false;
    L8:
        CotEvent r101 = (CotEvent) r100;
        if (Intrinsics.areEqual(this.eventId, r101.eventId) == true) goto L12;
        return false;
    L12:
        if (this.eventType == r101.eventType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (this.timestamp == r101.timestamp) goto L21;
        return false;
    L21:
        if (this.createdAt == r101.createdAt) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.eventId.hashCode() * 31) + this.eventType.hashCode()) * 31) + this.content.hashCode()) * 31;
        long r101 = this.timestamp;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.createdAt;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public String toString() {
        return "CotEvent(eventId=" + this.eventId + ", eventType=" + this.eventType + ", content=" + this.content + ", timestamp=" + this.timestamp + ", createdAt=" + this.createdAt + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final CotEventType getEventType() {
        return this.eventType;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public CotEvent(String r100, CotEventType r101, String r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, b.f276361k);
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.eventId = r100;
        this.eventType = r101;
        this.content = r102;
        this.timestamp = r103;
        this.createdAt = r104;
    }
}
