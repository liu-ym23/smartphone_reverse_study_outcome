package com.larus.im.internal.database.entity.simple;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000b\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JT\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/larus/im/internal/database/entity/simple/ConversationSimpleEntity;", "", "conversationId", "", "conversationType", "", "name", "badgeCount", "readBadgeCount", "version", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "()V", "getConversationId", "()Ljava/lang/String;", "getConversationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getBadgeCount", "getReadBadgeCount", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/larus/im/internal/database/entity/simple/ConversationSimpleEntity;", "equals", "", "other", "hashCode", "toString", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationSimpleEntity {
    private final Integer badgeCount;
    private final String conversationId;
    private final Integer conversationType;
    private final String name;
    private final Integer readBadgeCount;
    private final Long version;

    public static /* synthetic */ ConversationSimpleEntity copy$default(ConversationSimpleEntity r100, String r101, Integer r102, String r103, Integer r104, Integer r105, Long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.conversationType;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.name;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.badgeCount;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.readBadgeCount;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.version;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final Integer component2() {
        return this.conversationType;
    }

    public final String component3() {
        return this.name;
    }

    public final Integer component4() {
        return this.badgeCount;
    }

    public final Integer component5() {
        return this.readBadgeCount;
    }

    public final Long component6() {
        return this.version;
    }

    public final ConversationSimpleEntity copy(String r100, Integer r110, String r111, Integer r112, Integer r113, Long r114) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return new ConversationSimpleEntity(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationSimpleEntity) == true) goto L8;
        return false;
    L8:
        ConversationSimpleEntity r101 = (ConversationSimpleEntity) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationType, r101.conversationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.badgeCount, r101.badgeCount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.readBadgeCount, r101.readBadgeCount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.conversationId.hashCode() * 31;
        Integer r101 = this.conversationType;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.name;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.badgeCount;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.readBadgeCount;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Long r114 = this.version;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationSimpleEntity(conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", name=" + this.name + ", badgeCount=" + this.badgeCount + ", readBadgeCount=" + this.readBadgeCount + ", version=" + this.version + ')';
    }

    public ConversationSimpleEntity() {
        this("", null, null, null, null, null, 62, null);
    }

    public final Integer getBadgeCount() {
        return this.badgeCount;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Integer getConversationType() {
        return this.conversationType;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getReadBadgeCount() {
        return this.readBadgeCount;
    }

    public final Long getVersion() {
        return this.version;
    }

    public ConversationSimpleEntity(String r100, Integer r101, String r102, Integer r103, Integer r104, Long r105) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.conversationId = r100;
        this.conversationType = r101;
        this.name = r102;
        this.badgeCount = r103;
        this.readBadgeCount = r104;
        this.version = r105;
    }

    public /* synthetic */ ConversationSimpleEntity(String r100, Integer r101, String r102, Integer r103, Integer r104, Long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "";
    L5:
        Long r105 = null;
        if ((r111 & 2) == 0) goto L8;
        Integer r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        String r106 = null;
    L14:
        if ((r111 & 8) == 0) goto L16;
        Integer r107 = null;
    L18:
        if ((r111 & 16) == 0) goto L20;
        Integer r108 = null;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
