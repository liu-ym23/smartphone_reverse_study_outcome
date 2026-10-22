package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.chat.TeamChatType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/biz/im/api/FeedTeamInfo;", "Ljava/io/Serializable;", "teamId", "", "teamName", "", "teamChatType", "Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "orderWeight", "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/chat/TeamChatType;Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "()Ljava/lang/Long;", "copy", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/chat/TeamChatType;Ljava/lang/Long;)Lcom/ss/android/lark/biz/im/api/FeedTeamInfo;", "equals", "", "other", "", "hashCode", "", "toString", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedTeamInfo implements Serializable {
    public final Long orderWeight;
    public final TeamChatType teamChatType;
    public final long teamId;
    public final String teamName;

    public static /* synthetic */ FeedTeamInfo copy$default(FeedTeamInfo r100, long r101, String r102, TeamChatType r110, Long r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.teamId;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.teamName;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.teamChatType;
    L11:
        TeamChatType r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.orderWeight;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.teamId;
    }

    public final String component2() {
        return this.teamName;
    }

    public final TeamChatType component3() {
        return this.teamChatType;
    }

    public final Long component4() {
        return this.orderWeight;
    }

    public final FeedTeamInfo copy(long r100, String r110, TeamChatType r111, Long r112) {
        Intrinsics.checkNotNullParameter(r110, "teamName");
        Intrinsics.checkNotNullParameter(r111, "teamChatType");
        return new FeedTeamInfo(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedTeamInfo) == true) goto L8;
        return false;
    L8:
        FeedTeamInfo r101 = (FeedTeamInfo) r100;
        if (this.teamId == r101.teamId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.teamName, r101.teamName) == true) goto L15;
        return false;
    L15:
        if (this.teamChatType == r101.teamChatType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.orderWeight, r101.orderWeight) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.teamId;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.teamName.hashCode()) * 31) + this.teamChatType.hashCode()) * 31;
        Long r102 = this.orderWeight;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public String toString() {
        return "FeedTeamInfo(teamId=" + this.teamId + ", teamName=" + this.teamName + ", teamChatType=" + this.teamChatType + ", orderWeight=" + this.orderWeight + ')';
    }

    public FeedTeamInfo(long r100, String r101, TeamChatType r102, Long r103) {
        Intrinsics.checkNotNullParameter(r101, "teamName");
        Intrinsics.checkNotNullParameter(r102, "teamChatType");
        this.teamId = r100;
        this.teamName = r101;
        this.teamChatType = r102;
        this.orderWeight = r103;
    }
}
