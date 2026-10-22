package com.ss.android.lark.intent.export.entity.output;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.core.data.UserInfo;
import java.io.File;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendChat;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "createTime", "", UserInfo.UPDATE_TIME, "chatName", "avatar", "Ljava/io/File;", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/io/File;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "()J", "getUpdateTime", "getChatName", "getAvatar", "()Ljava/io/File;", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendChat implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendChat> CREATOR = null;
    private final File avatar;
    private final String chatName;
    private final long createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f428145id;
    private final long updateTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SendChat> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChat createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SendChat(r110.readString(), r110.readLong(), r110.readLong(), r110.readString(), (File) r110.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChat createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChat[] newArray(int r100) {
            return new SendChat[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChat[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendChat copy$default(SendChat r100, String r101, long r102, long r103, String r110, File r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.f428145id;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.createTime;
    L8:
        long r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.updateTime;
    L11:
        long r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.chatName;
    L14:
        String r114 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.avatar;
    L17:
        String r106 = r101;
        return r100.copy(r106, r104, r105, r114, r111);
    }

    public final String component1() {
        return this.f428145id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.updateTime;
    }

    public final String component4() {
        return this.chatName;
    }

    public final File component5() {
        return this.avatar;
    }

    public final SendChat copy(String r110, long r111, long r112, String r113, File r114) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "chatName");
        return new SendChat(r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendChat) == true) goto L8;
        return false;
    L8:
        SendChat r101 = (SendChat) r100;
        if (Intrinsics.areEqual(this.f428145id, r101.f428145id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r101.createTime) goto L15;
        return false;
    L15:
        if (this.updateTime == r101.updateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chatName, r101.chatName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.f428145id.hashCode() * 31;
        long r101 = this.createTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.updateTime;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.chatName.hashCode()) * 31;
        File r105 = this.avatar;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return r104 + r106;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f428145id);
        r100.writeLong(this.createTime);
        r100.writeLong(this.updateTime);
        r100.writeString(this.chatName);
        r100.writeSerializable(this.avatar);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendChat(id='");
        r100.append(this.f428145id);
        r100.append("', createTime=");
        r100.append(this.createTime);
        r100.append(", updateTime=");
        r100.append(this.updateTime);
        r100.append(", chatName='");
        r100.append(a.a(this.chatName));
        r100.append("', avatar=");
        File r101 = this.avatar;
        if (r101 == null) goto L5;
        Uri r102 = Uri.fromFile(r101);
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final File getAvatar() {
        return this.avatar;
    }

    public final String getChatName() {
        return this.chatName;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.f428145id;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public SendChat(String r100, long r101, long r102, String r103, File r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r103, "chatName");
        this.f428145id = r100;
        this.createTime = r101;
        this.updateTime = r102;
        this.chatName = r103;
        this.avatar = r104;
    }
}
