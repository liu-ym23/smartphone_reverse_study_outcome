package com.ss.android.lark.intent.export.entity.input;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "chatId", "", "chatterId", "type", "Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;)V", "getChatId", "()Ljava/lang/String;", "getChatterId", "getType", "()Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;", "toString", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendChatInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendChatInfo> CREATOR = null;
    private final String chatId;
    private final String chatterId;
    private final SendChatInfoType type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SendChatInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SendChatInfo(r100.readString(), r100.readString(), SendChatInfoType.valueOf(r100.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatInfo createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatInfo[] newArray(int r100) {
            return new SendChatInfo[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatInfo[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendChatInfo copy$default(SendChatInfo r100, String r101, String r102, SendChatInfoType r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.chatId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.chatterId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.chatId;
    }

    public final String component2() {
        return this.chatterId;
    }

    public final SendChatInfoType component3() {
        return this.type;
    }

    public final SendChatInfo copy(String r100, String r101, SendChatInfoType r102) {
        Intrinsics.checkNotNullParameter(r102, "type");
        return new SendChatInfo(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendChatInfo) == true) goto L8;
        return false;
    L8:
        SendChatInfo r101 = (SendChatInfo) r100;
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterId, r101.chatterId) == true) goto L15;
        return false;
    L15:
        if (this.type == r101.type) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.chatId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.chatterId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.type.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.chatId);
        r100.writeString(this.chatterId);
        r100.writeString(this.type.name());
    }

    public String toString() {
        return "SendChatInfo(chatId=" + this.chatId + ", chatterId=" + this.chatterId + ", type=" + this.type + ')';
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final SendChatInfoType getType() {
        return this.type;
    }

    public SendChatInfo(String r100, String r101, SendChatInfoType r102) {
        Intrinsics.checkNotNullParameter(r102, "type");
        this.chatId = r100;
        this.chatterId = r101;
        this.type = r102;
    }
}
