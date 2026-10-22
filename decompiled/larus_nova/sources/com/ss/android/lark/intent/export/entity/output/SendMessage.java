package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.core.data.UserInfo;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0017\u001a\u00020\u0004H\u0016J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001f\u001a\u00020\nJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006*"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "createTime", "", UserInfo.UPDATE_TIME, "msg", "position", "", "chatId", "<init>", "(Ljava/lang/String;JJLjava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "()J", "getUpdateTime", "getMsg", "getPosition", "()I", "getChatId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessage implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendMessage> CREATOR = null;
    private final String chatId;
    private final long createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f428147id;
    private final String msg;
    private final int position;
    private final long updateTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SendMessage> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendMessage createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SendMessage(r110.readString(), r110.readLong(), r110.readLong(), r110.readString(), r110.readInt(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendMessage createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendMessage[] newArray(int r100) {
            return new SendMessage[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendMessage[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendMessage copy$default(SendMessage r100, String r110, long r111, long r112, String r113, int r114, String r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        String r101 = r100.f428147id;
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r102 = r100.createTime;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.updateTime;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.msg;
    L19:
        if ((r116 & 16) == 0) goto L21;
        int r105 = r100.position;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r106 = r100.chatId;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.f428147id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.updateTime;
    }

    public final String component4() {
        return this.msg;
    }

    public final int component5() {
        return this.position;
    }

    public final String component6() {
        return this.chatId;
    }

    public final SendMessage copy(String r110, long r111, long r112, String r113, int r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "id");
        return new SendMessage(r110, r111, r112, r113, r114, r115);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendMessage) == true) goto L8;
        return false;
    L8:
        SendMessage r101 = (SendMessage) r100;
        if (Intrinsics.areEqual(this.f428147id, r101.f428147id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r101.createTime) goto L15;
        return false;
    L15:
        if (this.updateTime == r101.updateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L21;
        return false;
    L21:
        if (this.position == r101.position) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.f428147id.hashCode() * 31;
        long r101 = this.createTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.updateTime;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.msg;
        int r106 = 0;
        if (r105 != null) goto L5;
        int r107 = 0;
    L6:
        int r108 = (((r104 + r107) * 31) + this.position) * 31;
        String r109 = this.chatId;
        if (r109 == null) goto L11;
        r106 = r109.hashCode();
    L11:
        return r108 + r106;
    L5:
        r107 = r105.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f428147id);
        r100.writeLong(this.createTime);
        r100.writeLong(this.updateTime);
        r100.writeString(this.msg);
        r100.writeInt(this.position);
        r100.writeString(this.chatId);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendMessage(id='");
        r100.append(this.f428147id);
        r100.append("', createTime=");
        r100.append(this.createTime);
        r100.append(", updateTime=");
        r100.append(this.updateTime);
        r100.append(", msg=");
        String r101 = this.msg;
        if (r101 == null) goto L5;
        String r102 = a.a(r101);
    L6:
        r100.append(r102);
        r100.append(", position=");
        r100.append(this.position);
        r100.append(", chatId=");
        r100.append(this.chatId);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.f428147id;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public SendMessage(String r100, long r101, long r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f428147id = r100;
        this.createTime = r101;
        this.updateTime = r102;
        this.msg = r103;
        this.position = r104;
        this.chatId = r105;
    }

    public /* synthetic */ SendMessage(String r110, long r111, long r112, String r113, int r114, String r115, int r116, DefaultConstructorMarker r210) {
        if ((r116 & 16) == 0) goto L5;
        int r100 = -1;
    L6:
        this(r110, r111, r112, r113, r100, r115);
        return;
    L5:
        r100 = r114;
        goto L6
    }
}
