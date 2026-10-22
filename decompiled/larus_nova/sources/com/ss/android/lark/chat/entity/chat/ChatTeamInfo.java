package com.ss.android.lark.chat.entity.chat;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\bHÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTeamInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "teamId", "", "teamChatType", "Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "discoverable", "", "<init>", "(JLcom/ss/android/lark/chat/entity/chat/TeamChatType;Z)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTeamInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ChatTeamInfo> CREATOR = null;
    public final boolean discoverable;
    public final TeamChatType teamChatType;
    public final long teamId;

    public static final class a implements Parcelable.Creator<ChatTeamInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatTeamInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            long r101 = r100.readLong();
            TeamChatType r102 = TeamChatType.valueOf(r100.readString());
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            return new ChatTeamInfo(r101, r102, r103);
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatTeamInfo[] newArray(int r100) {
            return new ChatTeamInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ChatTeamInfo copy$default(ChatTeamInfo r100, long r101, TeamChatType r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.teamId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.teamChatType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.discoverable;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.teamId;
    }

    public final TeamChatType component2() {
        return this.teamChatType;
    }

    public final boolean component3() {
        return this.discoverable;
    }

    public final ChatTeamInfo copy(long r100, TeamChatType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "teamChatType");
        return new ChatTeamInfo(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatTeamInfo) == true) goto L8;
        return false;
    L8:
        ChatTeamInfo r101 = (ChatTeamInfo) r100;
        if (this.teamId == r101.teamId) goto L12;
        return false;
    L12:
        if (this.teamChatType == r101.teamChatType) goto L15;
        return false;
    L15:
        if (this.discoverable == r101.discoverable) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.teamId;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.teamChatType.hashCode()) * 31;
        if (this.discoverable == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public String toString() {
        return "ChatTeamInfo(teamId=" + this.teamId + ", teamChatType=" + this.teamChatType + ", discoverable=" + this.discoverable + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.teamId);
        r100.writeString(this.teamChatType.name());
        r100.writeInt(this.discoverable ? 1 : 0);
    }

    public ChatTeamInfo(long r100, TeamChatType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "teamChatType");
        this.teamId = r100;
        this.teamChatType = r101;
        this.discoverable = r102;
    }
}
